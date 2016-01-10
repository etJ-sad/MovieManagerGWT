package movies.client.service;

//
import java.util.List;

import movies.web.model.Episode;
import movies.web.model.Movie;
import movies.web.model.Season;
import movies.web.model.Series;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface MovieManagerServiceAsync {
//Movies
	void listLoanableMovies(AsyncCallback<List<Movie>> callback);
	void listLoanedMovies(AsyncCallback<List<Movie>> callback);
	void loanMovie(Movie movie, AsyncCallback<Void> callback);
	void returnMovie(Movie movie, AsyncCallback<Void> callback);

//Series
	void listLoanableSeries(AsyncCallback<List<Series>> callback);
	void listLoanedSeries(AsyncCallback<List<Series>> callback);
	void loanSerie(Series series, AsyncCallback<Void> callback);
	void returnSerie(Series series, AsyncCallback<Void> callback);
	
//Seasons
	void listLoanableSeasons(AsyncCallback<List<Season>> callback);
	void listLoanedSeasons(AsyncCallback<List<Season>> callback);
	void loanSeason(Season season, AsyncCallback<Void> callback);
	void returnSeason(Season season, AsyncCallback<Void> callback);


//Episodes
	
	void listLoanableEpisodes(AsyncCallback<List<Episode>> callback);
	void listLoanedEpisodes(AsyncCallback<List<Episode>> callback);
	void loanEpisode(Episode episode, AsyncCallback<Void> callback);
	void returnEpisode(Episode episode, AsyncCallback<Void> callback);
	
	void listEpisodesFromSeason(Season season,AsyncCallback<List<Episode>> callback);

	


}
