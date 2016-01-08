package movies.ui.util;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.emfstore.client.model.util.EMFStoreCommandWithResult;

import movies.Episode;
import movies.Movie;
import movies.MoviesPackage;
import movies.Season;
import movies.Series;

// TODO: Auto-generated Javadoc
/**
 * The Class AssociateMovieToSeasonUtil.
 *
 * @author Jochen Clormann
 */
public class AssociateMovieToSeasonUtil {
	
	/**
	 * Gets the all series.
	 *
	 * @return returns all Series in this project
	 */
	public static EList<Series> getAllSeries() {
		return MovieUtil.getActiveProject().getAllModelElementsbyClass(MoviesPackage.eINSTANCE.getSeries(), new BasicEList<Series>());
	}
	
	/**
	 * Gets the all seasons.
	 *
	 * @return the all seasons
	 */
	public static EList<Season> getAllSeasons() {
		return MovieUtil.getActiveProject().getAllModelElementsbyClass(MoviesPackage.eINSTANCE.getSeason(), new BasicEList<Season>());
	}
	
	/**
	 * Gets the all movies.
	 *
	 * @return the all movies
	 */
	public static EList<Movie> getAllMovies() {
		return MovieUtil.getActiveProject().getAllModelElementsbyClass(MoviesPackage.eINSTANCE.getMovie(), new BasicEList<Movie>());
	}
	
	/**
	 * Creates an episode out of a movie.
	 *
	 * @param movie the movie
	 * @param selectedSeason the selected season
	 * @return the episode
	 */
	public static Episode makeMovieToEpisode(final Movie movie, final Season selectedSeason){
		return new EMFStoreCommandWithResult<Episode>() {
			@Override
			protected Episode doRun(){
				Episode episode = MoviesPackage.eINSTANCE.getMoviesFactory().createEpisode();
				episode.setTitle(movie.getTitle());
				episode.setTitle_orig(movie.getTitle_orig());
				episode.setCategory(movie.getCategory());
				episode.setImdbUrl(movie.getImdbUrl());
				episode.setLastWatchDate(movie.getLastWatchDate());
				episode.setOfdbID(movie.getOfdbID());
				episode.setOverallRating(movie.getOverallRating());
				episode.setRating(movie.getRating());
				episode.setTime(movie.getTime());
				episode.setLoaned(movie.isLoaned());
				episode.setSeason(selectedSeason);
				episode.setLoanedUntil(movie.getLoanedUntil());
				selectedSeason.getEpisodes().add(episode);
				return episode;
			}
		}.run(false);		
	}
}
