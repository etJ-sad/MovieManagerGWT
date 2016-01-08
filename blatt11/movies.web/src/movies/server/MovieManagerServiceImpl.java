package movies.server;

import java.util.ArrayList;
import java.util.List;

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
		List<Series> loanableSeries = new ArrayList<Series>();

		for (Series serie : client.getSeries()) {
			if (serie.isLoanable() && !serie.isLoaned()) {
				loanableSeries.add(serie);
				
			}
		}
		return loanableSeries;
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
		List<Season> loanableSeason = new ArrayList<Season>();	
			try {
				for (Series serie : client.getSeries()){
					for (Season season : client.getSeasonsFromSeries(serie)) {
						if (season.isLoanable() && !season.isLoaned()) {
							loanableSeason.add(season);
							}
						}
				}} catch (EMFStoreClientException e) {
					e.printStackTrace();
			} 
			
		return loanableSeason;
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
	public List<Episode> listLoanableEpisodes(List<Season> listOfSeasons) {
		List<Episode> loanableEpisodes = new ArrayList<Episode>();

		try {
			for (Season season : listOfSeasons){
				for (Episode episode : client.getEpisodesFromSeason(season)) {
					if (episode.isLoanable() && !episode.isLoaned()) {
						loanableEpisodes.add(episode);
						
					}
				}
		}} catch (EMFStoreClientException e) {
			e.printStackTrace();
		}
		return loanableEpisodes;
	}

	@Override
	public List<Episode> listLoanedEpisodes(List<Season> listOfSeasons) {
		List<Episode> loanedEpisodes = new ArrayList<Episode>();
				for (Season season : listOfSeasons){
					try {
						for (Episode episode : client.getEpisodesFromSeason(season)) {
							if (episode.isLoaned()) {
								loanedEpisodes.add(episode);					
							}
						}
					} catch (EMFStoreClientException e) {
						e.printStackTrace(); 
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
}
