package movies.client.provider;

import java.util.List;

import movies.client.filter.FilteredListDataProvider;
import movies.web.model.Episode;
import movies.web.model.Loanable;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.view.client.SingleSelectionModel;

public class EpisodeProvider {

//Episode
	public SingleSelectionModel<Loanable> loanableEpisodeSelection = new SingleSelectionModel<Loanable>();
	public SingleSelectionModel<Episode> loanEpisodeSelection = new SingleSelectionModel<Episode>();
	public List<Episode> EpisodeList;
	public CellTable<Episode> EpisodeTable;
	public FilteredListDataProvider<Episode> EpisodeData;

}
