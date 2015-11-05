// 

package de.unihd.movies.client.service;

import java.util.ArrayList;
import java.util.LinkedList;

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
	void loadMovies(AsyncCallback<LinkedList<Movie>> callback);

	/**
	 * Callback to handle the storage of movies.
	 * 
	 * @param movies
	 *            The list of movies to be stored.
	 * @param callback
	 *            The callback to handle the movies storage.
	 * */
	void saveMovies(LinkedList<Movie> movies, AsyncCallback<Void> callback);

}
