package movies.client.provider;

import java.util.List;

import movies.client.filter.FilteredListDataProvider;
import movies.web.model.Loanable;
import movies.web.model.Season;

import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.view.client.SingleSelectionModel;

public class SeasonProvider {
//Seasons
	public SingleSelectionModel<Season> loanSeasonSelection = new SingleSelectionModel<Season>();
	public SingleSelectionModel<Loanable> loanableSeasonSelection = new SingleSelectionModel<Loanable>();
	public List<Season> SeasonsList;
	public CellTable<Season> SeasonsTable;
	public FilteredListDataProvider<Season> SeasonsData;
		
}
