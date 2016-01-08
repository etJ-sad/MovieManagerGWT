package movies.emfstore.client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;

import movies.emfstore.server.EMFStoreServer;
import movies.emfstore.util.EMFStoreRequest;
import movies.emfstore.util.EMFStoreTransaction;
import movies.web.model.Episode;
import movies.web.model.Movie;
import movies.web.model.Season;
import movies.web.model.Series;

/**
 * Client that provides various operations regarding the loan management of
 * movies, series, seasons and episodes. Besides the provision of operations to
 * loan movies, series, seasons and episode and operations to return loaned
 * movies, series, seasons and episodes, also operations are provided to gather
 * lists of movies, series, seasons and episodes from the MovieManager system.
 * 
 * @author Marcus Seiler
 * */
public class EMFStoreClient {

	/**
	 * The server's host name
	 * */
	private final String hostName = "localhost";

	/**
	 * The server's port number
	 * */
	private final int portNumber = 9999;

	/**
	 * Loans the given series. The series is marked as loaned in the system
	 * MovieManager.
	 * 
	 * <p>
	 * <b>Note that this operation only loans the series itself and not the
	 * containing seasons and episodes.</b>
	 * </p>
	 * 
	 * @param series
	 *            The series to loan.
	 * 
	 * @throws EMFStoreClientException
	 *             if the given series is <code>null</code> or the series could
	 *             not be loaned.
	 * */
	public void loanSeries(Series series) throws EMFStoreClientException {
		if (series == null) {
			throw new EMFStoreClientException("The series cannot be NULL");
		}

		EMFStoreTransaction trx = new EMFStoreTransaction();
		trx.setRequestToPerform(EMFStoreRequest.LOAN_SERIES);
		trx.setObjectToSend(series);

		Object result = execute(trx);
		if (result instanceof Boolean) {
			if (!((Boolean) result).booleanValue()) {
				throw new EMFStoreClientException("The series " + series
						+ " could not be loaned.");
			}
		}
	}

	/**
	 * Loans the given season. The season is marked as loaned in the system
	 * MovieManager.
	 * 
	 * <p>
	 * <b>Note that this operation only loans the season itself and not the
	 * containing episodes.</b>
	 * </p>
	 * 
	 * @param season
	 *            The season to loan.
	 * 
	 * @throws EMFStoreClientException
	 *             if the given season is <code>null</code> or the season could
	 *             not be loaned.
	 * */
	public void loanSeason(Season season) throws EMFStoreClientException {
		if (season == null) {
			throw new EMFStoreClientException("The season cannot be NULL");
		}

		EMFStoreTransaction trx = new EMFStoreTransaction();
		trx.setRequestToPerform(EMFStoreRequest.LOAN_SEASON);
		trx.setObjectToSend(season);

		Object result = execute(trx);
		if (result instanceof Boolean) {
			if (!((Boolean) result).booleanValue()) {
				throw new EMFStoreClientException("The season " + season
						+ " could not be loaned.");
			}
		}
	}

	/**
	 * Loans the given episode. The episode is marked as loaned in the system
	 * MovieManager.
	 * 
	 * @param episode
	 *            The episode to loan.
	 * 
	 * @throws EMFStoreClientException
	 *             if the given episode is <code>null</code> or the episode
	 *             could not be loaned.
	 * */
	public void loanEpisode(Episode episode) throws EMFStoreClientException {
		if (episode == null) {
			throw new EMFStoreClientException("The episode cannot be NULL");
		}

		EMFStoreTransaction trx = new EMFStoreTransaction();
		trx.setRequestToPerform(EMFStoreRequest.LOAN_EPISODE);
		trx.setObjectToSend(episode);

		Object result = execute(trx);
		if (result instanceof Boolean) {
			if (!((Boolean) result).booleanValue()) {
				throw new EMFStoreClientException("The episode " + episode
						+ " could not be loaned.");
			}
		}
	}

	/**
	 * Loans the given movie. The movie is marked as loaned in the system
	 * MovieManager.
	 * 
	 * @param movie
	 *            The movie to loan.
	 * 
	 * @throws EMFStoreClientException
	 *             if the given movie is <code>null</code> or the movie could
	 *             not be loaned.
	 * */
	public void loanMovie(Movie movie) throws EMFStoreClientException {
		if (movie == null) {
			throw new EMFStoreClientException("The movie cannot be NULL");
		}

		EMFStoreTransaction trx = new EMFStoreTransaction();
		trx.setRequestToPerform(EMFStoreRequest.LOAN_MOVIE);
		trx.setObjectToSend(movie);

		Object result = execute(trx);
		if (result instanceof Boolean) {
			if (!((Boolean) result).booleanValue()) {
				throw new EMFStoreClientException("The movie " + movie
						+ " could not be loaned.");
			}
		}
	}

	/**
	 * Returns the given series and thus the series can be loaned again. In
	 * addition, the series is marked as returned in the system MovieManager.
	 * 
	 * <p>
	 * <b>Note that this operation only returns the series itself and not the
	 * containing seasons and episodes.</b>
	 * </p>
	 * 
	 * @param series
	 *            The series to return.
	 * 
	 * @throws EMFStoreClientException
	 *             if the given series is <code>null</code> or the series could
	 *             not be returned.
	 * */
	public void returnSeries(Series series) throws EMFStoreClientException {
		if (series == null) {
			throw new EMFStoreClientException("The series cannot be NULL");
		}

		EMFStoreTransaction trx = new EMFStoreTransaction();
		trx.setRequestToPerform(EMFStoreRequest.RETURN_SERIES);
		trx.setObjectToSend(series);

		Object result = execute(trx);
		if (result instanceof Boolean) {
			if (!((Boolean) result).booleanValue()) {
				throw new EMFStoreClientException("The series " + series
						+ " could not be returned.");
			}
		}
	}

	/**
	 * Returns the given season and thus the season can be loaned again. In
	 * addition, the season is marked as returned in the system MovieManager.
	 * 
	 * <p>
	 * <b>Note that this operation only returns the season itself and not the
	 * containing episodes.</b>
	 * </p>
	 * 
	 * @param season
	 *            The season to return.
	 * 
	 * @throws EMFStoreClientException
	 *             if the given season is <code>null</code> or the season could
	 *             not be returned.
	 * */
	public void returnSeason(Season season) throws EMFStoreClientException {
		if (season == null) {
			throw new EMFStoreClientException("The season cannot be NULL");
		}

		EMFStoreTransaction trx = new EMFStoreTransaction();
		trx.setRequestToPerform(EMFStoreRequest.RETURN_SEASON);
		trx.setObjectToSend(season);

		Object result = execute(trx);
		if (result instanceof Boolean) {
			if (!((Boolean) result).booleanValue()) {
				throw new EMFStoreClientException("The season " + season
						+ " could not be returned.");
			}
		}
	}

	/**
	 * Returns the given episode and thus the episode can be loaned again. In
	 * addition, the episode is marked as returned in the system MovieManager.
	 * 
	 * @param episode
	 *            The episode to return.
	 * 
	 * @throws EMFStoreClientException
	 *             if the given episode is <code>null</code> or the episode
	 *             could not be returned.
	 * */
	public void returnEpisode(Episode episode) throws EMFStoreClientException {
		if (episode == null) {
			throw new EMFStoreClientException("The episode cannot be NULL");
		}

		EMFStoreTransaction trx = new EMFStoreTransaction();
		trx.setRequestToPerform(EMFStoreRequest.RETURN_EPISODE);
		trx.setObjectToSend(episode);

		Object result = execute(trx);
		if (result instanceof Boolean) {
			if (!((Boolean) result).booleanValue()) {
				throw new EMFStoreClientException("The episode " + episode
						+ " could not be returned.");
			}
		}
	}

	/**
	 * Returns the given movie and thus the movie can be loaned again. In
	 * addition, the movie is marked as returned in the system MovieManager.
	 * 
	 * @param movie
	 *            The movie to return.
	 * 
	 * @throws EMFStoreClientException
	 *             if the given movie is <code>null</code> or the movie could
	 *             not be returned.
	 * */
	public void returnMovie(Movie movie) throws EMFStoreClientException {
		if (movie == null) {
			throw new EMFStoreClientException("The movie cannot be NULL");
		}

		EMFStoreTransaction trx = new EMFStoreTransaction();
		trx.setRequestToPerform(EMFStoreRequest.RETURN_MOVIE);
		trx.setObjectToSend(movie);

		Object result = execute(trx);
		if (result instanceof Boolean) {
			if (!((Boolean) result).booleanValue()) {
				throw new EMFStoreClientException("The movie " + movie
						+ " could not be returned.");
			}
		}
	}

	/**
	 * Retrieves an unsorted list of all series contained in the MovieManager
	 * system.
	 * 
	 * @return An unsorted list of all series.
	 * */
	public List<Series> getSeries() {
		List<Series> series = new ArrayList<Series>();

		EMFStoreTransaction trx = new EMFStoreTransaction();
		trx.setRequestToPerform(EMFStoreRequest.GET_SERIES);

		Object result = execute(trx);

		if (result instanceof List<?>) {
			for (Object o : (List<?>) result) {
				if (o instanceof Series) {
					series.add((Series) o);
				}
			}
		}

		return series;
	}

	/**
	 * Retrieves an unsorted list of all seasons from the given series contained
	 * in the MovieManager system.
	 * 
	 * @param series
	 *            The series from which all seasons should be retrieved.
	 * 
	 * @return An unsorted list of all seasons contained in the specified
	 *         series.
	 * @throws EMFStoreClientException
	 *             if the series is <code>null</code>.
	 * */
	public List<Season> getSeasonsFromSeries(Series series)
			throws EMFStoreClientException {
		if (series == null) {
			throw new EMFStoreClientException("The series cannot be NULL");
		}

		List<Season> seasons = new ArrayList<Season>();

		EMFStoreTransaction trx = new EMFStoreTransaction();
		trx.setRequestToPerform(EMFStoreRequest.GET_SEASONS);
		trx.setObjectToSend(series);

		Object result = execute(trx);

		if (result instanceof List<?>) {
			for (Object o : (List<?>) result) {
				if (o instanceof Season) {
					seasons.add((Season) o);
				}
			}
		}

		return seasons;
	}

	/**
	 * Retrieves an unsorted list of all episodes from the given season
	 * contained in the MovieManager system.
	 * 
	 * @param season
	 *            The season from which all episodes should be retrieved.
	 * 
	 * @return An unsorted list of all episodes contained in the specified
	 *         season.
	 * @throws EMFStoreClientException
	 *             if the season is <code>null</code>.
	 * */
	public List<Episode> getEpisodesFromSeason(Season season)
			throws EMFStoreClientException {
		if (season == null) {
			throw new EMFStoreClientException("The season cannot be NULL");
		}

		List<Episode> episodes = new ArrayList<Episode>();

		EMFStoreTransaction trx = new EMFStoreTransaction();
		trx.setRequestToPerform(EMFStoreRequest.GET_EPISODES);
		trx.setObjectToSend(season);

		Object result = execute(trx);

		if (result instanceof List<?>) {
			for (Object o : (List<?>) result) {
				if (o instanceof Episode) {
					episodes.add((Episode) o);
				}
			}
		}

		return episodes;
	}

	/**
	 * Retrieves an unsorted list of all movies contained in the MovieManager
	 * system.
	 * 
	 * @return An unsorted list of all movies.
	 * */
	public List<Movie> getMovies() {
		List<Movie> movies = new ArrayList<Movie>();

		EMFStoreTransaction trx = new EMFStoreTransaction();
		trx.setRequestToPerform(EMFStoreRequest.GET_MOVIES);

		Object result = execute(trx);

		if (result instanceof List<?>) {
			for (Object o : (List<?>) result) {
				if (o instanceof Movie) {
					movies.add((Movie) o);
				}
			}
		}

		return movies;
	}

	/**
	 * Executes the given {@link EMFStoreTransaction} by sending the transaction
	 * to the {@link EMFStoreServer} and finally returns the respond from the
	 * server.
	 * 
	 * @param transaction
	 *            The {@link EMFStoreTransaction} to execute.
	 * @return The server response. An error occurred if the server responds
	 *         <code>null</code>.
	 * */
	private Object execute(EMFStoreTransaction transaction) {
		Object result = null;
		try {
			Socket socket = new Socket(hostName, portNumber);

			ObjectOutputStream outputStream = new ObjectOutputStream(
					socket.getOutputStream());
			outputStream.writeObject(transaction);
			
			ObjectInputStream inputStream = new ObjectInputStream(
					socket.getInputStream());
			result = inputStream.readObject();
		} catch (SocketException se) {
			se.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return result;
	}

}
