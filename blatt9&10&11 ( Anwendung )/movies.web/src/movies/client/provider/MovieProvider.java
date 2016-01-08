package movies.client.provider;

import java.util.List;

import movies.client.filter.FilteredListDataProvider;
import movies.web.model.Loanable;
import movies.web.model.Movie;

import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.view.client.SingleSelectionModel;

public class MovieProvider {
//Movie
	public SingleSelectionModel<Loanable> loanableSelection = new SingleSelectionModel<Loanable>();	
	public SingleSelectionModel<Movie> loanSelection = new SingleSelectionModel<Movie>();
	public CellTable<Movie> MoviesTable;
	public FilteredListDataProvider<Movie> MoviesData;
	public List<Movie> moviesList;
}
