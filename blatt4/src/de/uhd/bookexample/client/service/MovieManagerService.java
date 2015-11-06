package de.uhd.bookexample.client.service;

import java.util.ArrayList;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import de.uhd.bookexample.client.Movie;

@RemoteServiceRelativePath("bookservice")
public interface MovieManagerService extends RemoteService {

	/**
	 * Loads all {@link Movie} from the server.
	 * 
	 * @return A list containing all books.
	 * */
	public ArrayList<Movie> loadMovies();

	/**
	 * Saves the given list of books on the server.
	 * 
	 * @param books
	 *            The list of books to save.
	 * */
	public void saveMovies(ArrayList<Movie> books);

}
