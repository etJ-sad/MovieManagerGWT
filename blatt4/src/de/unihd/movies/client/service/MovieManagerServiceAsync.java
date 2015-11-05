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
	 * Callback to handle the books loading.
	 * 
	 * @param callback
	 *            The callback to handle the books loading.
	 * */
	void loadMovies(AsyncCallback<ArrayList<Movie>> callback);

	/**
	 * Callback to handle the storage of books.
	 * 
	 * @param books
	 *            The list of books to be stored.
	 * @param callback
	 *            The callback to handle the books storage.
	 * */
	void saveMovies(ArrayList<Movie> books, AsyncCallback<Void> callback);

}
