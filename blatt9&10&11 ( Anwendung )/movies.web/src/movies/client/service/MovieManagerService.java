package movies.client.service;

//
import java.util.List;

import movies.web.model.Episode;
import movies.web.model.Movie;
import movies.web.model.Season;
import movies.web.model.Series;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("moviemanagerservice")
public interface MovieManagerService extends RemoteService {
//Movies
	public List<Movie> listLoanableMovies();
	public List<Movie> listLoanedMovies();
	public void loanMovie(Movie movie);
	public void returnMovie(Movie movie);
	
//Series
	public List<Series> listLoanableSeries();
	public List<Series> listLoanedSeries();
	public void loanSerie(Series series);
	public void returnSerie(Series series);

//Season
	public List<Season> listLoanableSeasons();
	public List<Season> listLoanedSeasons();
	public void loanSeason(Season series);
	public void returnSeason(Season series);
	
//Episode	
	public List<Episode> listLoanableEpisodes();
	public List<Episode> listLoanedEpisodes();
	public List<Episode> listEpisodesFromSeason(Season season);
	public void loanEpisode(Episode episode);
	public void returnEpisode(Episode episode);


}
