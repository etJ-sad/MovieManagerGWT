package movies.client;

import java.util.List;

import movies.client.provider.ComponentProvider;
import movies.client.ui.MainUI;
import movies.web.model.Movie;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class MovieManager implements EntryPoint {
	
	public ComponentProvider provider = new ComponentProvider();
	
	public void onModuleLoad() {
		provider.movieService.listLoanableMovies(new AsyncCallback<List<Movie>>() {
			@Override
			public void onFailure(Throwable caught) {
				GWT.log(caught.getMessage());
			}
			@Override
			public void onSuccess(List<Movie> result) {
					MainUI mainPage = new MainUI(result);
					mainPage.init();
			}
		});
		
	}

}
