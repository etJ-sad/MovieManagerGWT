//

package de.unihd.movies.client.service;


import java.util.LinkedList;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import de.unihd.movies.client.Movie;

@RemoteServiceRelativePath("moviemanagerservice")
public interface MovieManagerService extends RemoteService {

	/**
	 * Loads all {@link Movie} from the server.
	 * 
	 * @return A list containing all movies.
	 * */
	public LinkedList<Movie> loadMovies();

	/**
	 * Saves the given list of movies on the server.
	 * 
	 * @param movies
	 *            The list of movies to save.
	 * */
	public void saveMovies(LinkedList<Movie> movies);
	


}
