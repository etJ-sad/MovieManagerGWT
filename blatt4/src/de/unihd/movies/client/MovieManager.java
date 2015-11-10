/**
 * @version 4.4.843:RC-4
 */

package de.unihd.movies.client;



import java.util.ArrayList;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;

import de.unihd.movies.client.service.MovieManagerService;
import de.unihd.movies.client.service.MovieManagerServiceAsync;



public class MovieManager implements EntryPoint {

	private final MovieManagerServiceAsync service = GWT.create(MovieManagerService.class);

	@Override
	public void onModuleLoad() { 
		service.loadMovies(new AsyncCallback<ArrayList<Movie>>() {
			@Override
			public void onSuccess(ArrayList<Movie> res) {

				new MovieUI(res);
			}
			@Override
			public void onFailure(Throwable caught) {
				GWT.log(caught.getMessage());
			}
		});

	}

}
