package movies.client.provider;

import java.util.List;

import movies.client.filter.FilteredListDataProvider;
import movies.web.model.Loanable;
import movies.web.model.Series;

import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.view.client.SingleSelectionModel;

public class SeriesProvider {
//Series
	public SingleSelectionModel<Loanable> loanableSerieSelection = new SingleSelectionModel<Loanable>();
	public SingleSelectionModel<Series> loanSeriesSelection = new SingleSelectionModel<Series>();	
	public List<Series> SeriesList;
	public CellTable<Series> SeriesTable;
	public FilteredListDataProvider<Series> SeriesData;
}
