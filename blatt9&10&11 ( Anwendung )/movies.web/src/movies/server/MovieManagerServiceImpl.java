package movies.server;

import java.util.ArrayList;
import java.util.List;

import movies.client.provider.EpisodeProvider;
import movies.client.provider.SeasonProvider;
import movies.client.provider.SeriesProvider;
import movies.client.service.MovieManagerService;
import movies.emfstore.client.EMFStoreClient;
import movies.emfstore.client.EMFStoreClientException;
import movies.web.model.Episode;
import movies.web.model.Movie;
import movies.web.model.Season;
import movies.web.model.Series;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class MovieManagerServiceImpl extends RemoteServiceServlet implements
		MovieManagerService {

	private static final long serialVersionUID = -1;

	private EMFStoreClient client = new EMFStoreClient();
	SeriesProvider seriesProvider = new SeriesProvider();
	SeasonProvider seasonProvider = new SeasonProvider();
	EpisodeProvider episodeProvider = new EpisodeProvider();
	
//Movies
	@Override
	public List<Movie> listLoanableMovies() {
		List<Movie> loanableMovies = new ArrayList<Movie>();

		for (Movie movie : client.getMovies()) {
			if (movie.isLoanable() && !movie.isLoaned()) {
				loanableMovies.add(movie);
			}
		}

		return loanableMovies;
	}

	@Override
	public List<Movie> listLoanedMovies() {
		List<Movie> loanedMovies = new ArrayList<Movie>();
		for (Movie movie : client.getMovies()) {
			if (movie.isLoaned()) {
				loanedMovies.add(movie);
			}
		}

		return loanedMovies;
	}

	@Override
	public void loanMovie(Movie movie) {
		try {
			client.loanMovie(movie);
		} catch (EMFStoreClientException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void returnMovie(Movie movie) {
		try {
			client.returnMovie(movie);
		} catch (EMFStoreClientException e) {
			e.printStackTrace();
		}
	}
	
//Series
	@Override
	public List<Series> listLoanableSeries() {
		seriesProvider.SeriesList = new ArrayList<Series>();

		for (Series serie : client.getSeries()) {
			if (serie.isLoanable() && !serie.isLoaned()) {
				seriesProvider.SeriesList.add(serie);
				
			}
		}
		return seriesProvider.SeriesList;
	}

	@Override
	public List<Series> listLoanedSeries() {
		List<Series> loanedSeries = new ArrayList<Series>();

		for (Series serie : client.getSeries()) {
			if (serie.isLoaned()) {
				loanedSeries.add(serie);
			}
		}
		return loanedSeries;
	}

	@Override
	public void loanSerie(Series series) {
		try {
			client.loanSeries(series);
		} catch (EMFStoreClientException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void returnSerie(Series series) {
		try {
			client.returnSeries(series);
		} catch (EMFStoreClientException e) {
			e.printStackTrace();
		}
	}
	
//Seasons
	@Override
	public List<Season> listLoanableSeasons() {
		seasonProvider.SeasonsList = new ArrayList<Season>();	
				for (Series serie : seriesProvider.SeriesList){
					for (Season season : serie.getSeasons()) {
						if (season.isLoanable() && !season.isLoaned()) {
							seasonProvider.SeasonsList.add(season);
							}
						}
				} 	
		return seasonProvider.SeasonsList;
	}

	@Override
	public List<Season> listLoanedSeasons() {
		List<Season> loanedSeason = new ArrayList<Season>();
		
		for (Series serie : client.getSeries()){
			for (Season season : serie.getSeasons()) {
				if (season.isLoaned()) {
					loanedSeason.add(season);
				}
			}
		}
		return loanedSeason;
	}

	@Override
	public void loanSeason(Season season) {
		try {
			client.loanSeason(season);
		} catch (EMFStoreClientException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void returnSeason(Season season) {
		try {
			client.returnSeason(season);
		} catch (EMFStoreClientException e) {
			e.printStackTrace();
		}
	}

//Episode
	@Override
	public List<Episode> listLoanableEpisodes() {
		episodeProvider.EpisodeList = new ArrayList<Episode>();

			for (Season season : seasonProvider.SeasonsList){
				for (Episode episode : season.getEpisodes()) {
					if (episode.isLoanable() && !episode.isLoaned()) {
						episodeProvider.EpisodeList.add(episode);
						
					}
				}
		}
		return episodeProvider.EpisodeList;
	}

	@Override
	public List<Episode> listLoanedEpisodes() {
		List<Episode> loanedEpisodes = new ArrayList<Episode>();
		for(Series serie : client.getSeries())
				for (Season season : serie.getSeasons()){
						for (Episode episode : season.getEpisodes()) {
							if (episode.isLoaned()) {
								loanedEpisodes.add(episode);					
							}
						}
				}
		return loanedEpisodes;
	}

	@Override
	public void loanEpisode(Episode episode) {
		try {
			client.loanEpisode(episode);
		} catch (EMFStoreClientException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void returnEpisode(Episode episode) {
		try {
			client.returnEpisode(episode);
		} catch (EMFStoreClientException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Episode> listEpisodesFromSeason(Season season) {
		List<Episode> EpisodeFromSeasonList = new ArrayList<Episode>();
		for(Episode episode : season.getEpisodes()){
			if(episode.isLoanable() && !episode.isLoaned()){
				EpisodeFromSeasonList.add(episode);
			}
		}
		return EpisodeFromSeasonList;
			
	}
}
