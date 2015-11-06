package de.unihd.movies.client.service;

import java.util.ArrayList;

import com.google.gwt.user.client.rpc.AsyncCallback;

import de.unihd.movies.client.Movie;

/**
 * The interface to provide callback methods for the {@link MovieManagerService}
 * 
 * @author Marcus Seiler
 * */
public interface MovieManagerServiceAsync {

	/**
	 * Callback to handle the movies loading.
	 * 
	 * @param callback
	 *            The callback to handle the movies loading.
	 * */
	void loadMovies(AsyncCallback<ArrayList<Movie>> callback);

	/**
	 * Callback to handle the storage of movies.
	 * 
	 * @param movies
	 *            The list of movies to be stored.
	 * @param callback
	 *            The callback to handle the movies storage.
	 * */
	void saveMovies(ArrayList<Movie> movies, AsyncCallback<Void> callback);

}
