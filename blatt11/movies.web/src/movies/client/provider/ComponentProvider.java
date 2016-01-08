package movies.client.provider;

import movies.client.service.MovieManagerService;
import movies.client.service.MovieManagerServiceAsync;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class ComponentProvider {
	
	public final MovieManagerServiceAsync movieService = GWT.create(MovieManagerService.class);
	
	public final TextBox filterTextBox = new TextBox();
	
	public final Button searchButton = new Button("Go ... ");
	public final Button loanSerieButton = new Button("Loan Serie");

	public final Button loanSeasonButton = new Button("Loan Season");
	public final Button showSeasonButton = new Button("Show Seasons");

	public final Button loanEpisodeButton = new Button("Loan Episode");
	public final Button showEpisodeButton = new Button("Show Episodes");
	
	public final Button loanMovieButton = new Button("Loan Movie");
	public final Button returnLoanButton = new Button("Return");
	
	public final HTML SeriesLabel = new HTML("<h2>Available Series</h2>");
	public final HTML MoviesLabel = new HTML("<h2>Available Movies</h2>");
	public final HTML SeasonLabel = new HTML("<h2>Available Seasons</h2>");
	public final HTML EpisodeLabel = new HTML("<h2>Available Episodes</h2>");	
	
	public final Anchor archor = new Anchor("My Loans");
	public final Anchor startViewLink = new Anchor("Start Page");
	
	public final HorizontalPanel filterPanel = new HorizontalPanel();
	public final HorizontalPanel archorPanel = new HorizontalPanel();
	public final HorizontalPanel buttonPanel = new HorizontalPanel();
	
	public final HorizontalPanel PanelS = new HorizontalPanel();
	public final HorizontalPanel PanelH = new HorizontalPanel();

	public final VerticalPanel loansPanel = new VerticalPanel();

	public DockPanel dock = new DockPanel();
	
	public VerticalPanel loanablePanel;
	
	
	
}
