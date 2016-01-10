package movies.client.ui;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;


import movies.client.filter.EpisodesFilter;
import movies.client.filter.FilteredListDataProvider;
import movies.client.filter.MovieFilter;
import movies.client.filter.SeasonsFilter;
import movies.client.filter.SeriesFilter;
import movies.client.provider.Container;
import movies.client.provider.EpisodeProvider;
import movies.client.provider.MovieProvider;
import movies.client.provider.SeasonProvider;
import movies.client.provider.SeriesProvider;
import movies.client.ui.dialogs.MessageDialog;
import movies.web.model.Episode;
import movies.web.model.Movie;
import movies.web.model.Season;
import movies.web.model.Series;

import com.google.gwt.cell.client.TextCell;
import com.google.gwt.core.shared.GWT;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.DoubleClickEvent;
import com.google.gwt.event.dom.client.DoubleClickHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;

import com.google.gwt.user.cellview.client.CellTable;

import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.ColumnSortEvent.ListHandler;

import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.Timer;

import com.google.gwt.user.client.rpc.AsyncCallback;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.datepicker.client.CalendarUtil;
import com.google.gwt.user.datepicker.client.DatePicker;
import com.google.gwt.view.client.CellPreviewEvent;
import com.google.gwt.view.client.CellPreviewEvent.Handler;


public class MainUI extends Composite{

	MovieProvider movieProvider = new MovieProvider();
	SeriesProvider seriesProvider = new SeriesProvider();
	SeasonProvider seasonProvider = new SeasonProvider();
	EpisodeProvider episodeProvider = new EpisodeProvider();
	
	VerticalPanel verticalPanelA = new VerticalPanel();
	VerticalPanel verticalPanel = new VerticalPanel();
	
	Container componentProvider = new Container();
	GetDataFromServer server = new GetDataFromServer();
	
	Items item = new Items();
	
	public MainUI(List<Movie> movies,String string, Boolean upd) {
		clear();

		movieProvider.moviesList = new ArrayList<Movie>(movies);
		componentProvider.loanablePanel = new HorizontalPanel();
		initWidget(componentProvider.loanablePanel);

		componentProvider.filterTextBox.setText(string);
		if (upd == true){
			Button refresh = new Button("404");
			refresh.fireEvent(new Refresh ());
		}

	}
	
	public void init() {
		clear();
		
		server.getLoanableSeries();
		HTML lbl = new HTML("RC 2.242");
		RootPanel.get("content").add(lbl);
		item.setPosition();	
		
		createMovieTable();
		createSeriesTable();
		createSeasonsTable();
		createEpisodeTable();
		
		item.createAnchorMyLoans();
		item.createTextBox();
		item.createButtons();
	
		setVisible(true);
			
	}
		
	private void createMovieTable() {
		
		movieProvider.MoviesTable = new CellTable<Movie>();
	
		movieProvider.MoviesData = new FilteredListDataProvider<>(new MovieFilter());
		
		movieProvider.MoviesData.addDataDisplay(movieProvider.MoviesTable);
		movieProvider.MoviesData.setList(movieProvider.moviesList);
		movieProvider.MoviesTable.setSelectionModel(movieProvider.loanableSelection);

		movieProvider.MoviesTable.setStyleName("cellTableCell");	
		
		Column<Movie, String> titleColumn = new Column<Movie, String>(new TextCell()) {
			@Override
			public String getValue(Movie object) {
				return object.getTitle();
			}
		};

		Column<Movie, String> timeColumn = new Column<Movie, String>(
				new TextCell()) {

			@Override
			public String getValue(Movie object) {
				return "" + object.getTime();
			}
		};

		Column<Movie, String> categoryColumn = new Column<Movie, String>(
				new TextCell()) {

			@Override
			public String getValue(Movie object) {
				return object.getCategory().name();
			}
		};

		Column<Movie, String> ratingColumn = new Column<Movie, String>(
				new TextCell()) {

			@Override
			public String getValue(Movie object) {
				return "" + object.getRating().ordinal();
			}
		};

		movieProvider.MoviesTable.addColumn(titleColumn, "Title");
		movieProvider.MoviesTable.addColumn(timeColumn, "Time");
		movieProvider.MoviesTable.addColumn(categoryColumn, "Category");
		movieProvider.MoviesTable.addColumn(ratingColumn, "Rating");

		titleColumn.setSortable(true);
		timeColumn.setSortable(true);
		categoryColumn.setSortable(true);
		ratingColumn.setSortable(true);

		ListHandler<Movie> sortHandler = new ListHandler<Movie>(movieProvider.MoviesData.getList());
		movieProvider.MoviesTable.addColumnSortHandler(sortHandler);

		sortHandler.setComparator(titleColumn, new Comparator<Movie>() {

			@Override
			public int compare(Movie o1, Movie o2) {
				return o1.getTitle().compareTo(o2.getTitle());
			}
		});

		sortHandler.setComparator(timeColumn, new Comparator<Movie>() {

			@Override
			public int compare(Movie o1, Movie o2) {
				if (o1.getTime() > o2.getTime()) {
					return 1;
				}
				if (o1.getTime() < o2.getTime()) {
					return -1;
				}
				return 0;
			}
		});

		sortHandler.setComparator(categoryColumn, new Comparator<Movie>() {

			@Override
			public int compare(Movie o1, Movie o2) {
				return o1.getCategory().name()
						.compareTo(o2.getCategory().name());
			}
		});

		sortHandler.setComparator(ratingColumn, new Comparator<Movie>() {

			@Override
			public int compare(Movie o1, Movie o2) {
				if (o1.getRating().ordinal() > o2.getRating().ordinal()) {
					return 1;
				}
				if (o1.getRating().ordinal() < o2.getRating().ordinal()) {
					return -1;
				}
				return 0;
			}
		});
		
		movieProvider.MoviesTable.addDomHandler(new DoubleClickHandler() {
			@Override
			public void onDoubleClick(DoubleClickEvent event) {
				for (Movie movie : movieProvider.moviesList){
					if(movieProvider.loanableSelection.isSelected(movie)){
							new MessageDialog(movie.getOfdbID()).center();
					}
				}
			}
	    }, DoubleClickEvent.getType());
		
		componentProvider.MoviesLabel.setVisible(false);
		componentProvider.loanMovieButton.setVisible(false);

		movieProvider.MoviesTable.setVisible(false);

		verticalPanel.add(componentProvider.MoviesLabel);
		verticalPanel.add(movieProvider.MoviesTable);
		verticalPanel.add(componentProvider.loanMovieButton);

		componentProvider.loanablePanel.add(verticalPanelA);
		componentProvider.loanablePanel.setSpacing(10);

		RootPanel.get("content").add(this);
		
	}

    private void createSeriesTable() {
    	
		seriesProvider.SeriesTable = new CellTable<Series>();
		seriesProvider.SeriesData = new FilteredListDataProvider<>(new SeriesFilter());

		seriesProvider.SeriesData.addDataDisplay(seriesProvider.SeriesTable);
		seriesProvider.SeriesList = seriesProvider.SeriesData.getList();
		seriesProvider.SeriesData.setList(seriesProvider.SeriesList);
		seriesProvider.SeriesTable.setSelectionModel(seriesProvider.loanableSerieSelection);
		
		seriesProvider.SeriesTable.setStyleName("cellTableCell");

		Column<Series, String> titleColumn = new Column<Series, String>(new TextCell()) {
			@Override
			public String getValue(Series object) {
				return object.getTitle();
			}
		};

		Column<Series, String> yearColumn = new Column<Series, String>(
				new TextCell()) {

			@Override
			public String getValue(Series object) {
				String year = object.getReleaseDate().toString();
				year = year.substring(28);
				return year;
			}
		};

		Column<Series, String> seasonColumn = new Column<Series, String>(new TextCell()) {

			@Override
			public String getValue(Series object) {
				return "" + object.getSeasons().size();
			}
		};

		Column<Series, String> ratingColumn = new Column<Series, String>(
				new TextCell()) {

			@Override
			public String getValue(Series object) {
				return "" + object.getRating().ordinal();
			}
		};
		
		Column<Series, String> studioColumn = new Column<Series, String>(
				new TextCell()) {

			@Override
			public String getValue(Series object) {
				return "" + object.getStudio();
			}
		};

		seriesProvider.SeriesTable.addColumn(titleColumn, "Title");
		seriesProvider.SeriesTable.addColumn(studioColumn,"Studio");
		seriesProvider.SeriesTable.addColumn(yearColumn, "Date");
		seriesProvider.SeriesTable.addColumn(seasonColumn, "Quantity");


		titleColumn.setSortable(true);
		yearColumn.setSortable(true);
		seasonColumn.setSortable(true);
		ratingColumn.setSortable(true);

		ListHandler<Series> sortHandler = new ListHandler<Series>(seriesProvider.SeriesData.getList());
		movieProvider.MoviesTable.addColumnSortHandler(sortHandler);

		sortHandler.setComparator(titleColumn, new Comparator<Series>() {

			@Override
			public int compare(Series o1, Series o2) { 
				return o1.getTitle().compareTo(o2.getTitle());
			}
		});

		sortHandler.setComparator(seasonColumn, new Comparator<Series>() {

			@Override
			public int compare(Series o1, Series o2) {
				return o1.getBroadcastedBy()
						.compareTo(o2.getBroadcastedBy());
			}
		});

		sortHandler.setComparator(ratingColumn, new Comparator<Series>() {

			@Override
			public int compare(Series o1, Series o2) {
				if (o1.getRating().ordinal() > o2.getRating().ordinal()) {
					return 1;
				}
				if (o1.getRating().ordinal() < o2.getRating().ordinal()) {
					return -1;
				}
				return 0;
			}
		});
//One Click
		seriesProvider.SeriesTable.addCellPreviewHandler(new Handler<Series>() {

			@Override
			public void onCellPreview(CellPreviewEvent<Series> event) {
				server.getLoanableSeasonFromSerie();
				episodeProvider.EpisodeTable.setVisible(false);
			//	componentProvider.loanEpisodeButton.setVisible(false);	
			}
		}); 
		
//
		seriesProvider.SeriesTable.addDomHandler(new DoubleClickHandler() {
			@Override
			public void onDoubleClick(DoubleClickEvent event) {
				for (Series serie : seriesProvider.SeriesList){
					if(seriesProvider.loanableSerieSelection.isSelected(serie)){
							new MessageDialog(serie.getProductionCountry()).center();
					}
				}
			}
	    }, DoubleClickEvent.getType());

		seriesProvider.SeriesTable.sinkEvents(Event.ONCLICK);

		componentProvider.loanSerieButton.setVisible(false);
		componentProvider.SeriesLabel.setVisible(false);
		componentProvider.showSeasonButton.setVisible(false);
		seriesProvider.SeriesTable.setVisible(false);	

		verticalPanel.add(componentProvider.SeriesLabel);
	//	componentProvider.loanablePanel.setSpacing(10);
	
	//	componentProvider.PanelS.add(componentProvider.showSeasonButton);
		
		verticalPanel.add(seriesProvider.SeriesTable);
		verticalPanel.add(componentProvider.loanSerieButton);
		componentProvider.loanablePanel.add(verticalPanel);

		Label ll = new Label();
		ll.setText("                     ");
		ll.setSize("500","500");
		
		Label lb = new Label();
		lb.setText("                        ");
		lb.setSize("500", "500");
		componentProvider.loanablePanel.add(lb);
		componentProvider.loanablePanel.add(ll);
		RootPanel.get("content").add(this);
	}
	
	private void createSeasonsTable() {
		
		seasonProvider.SeasonsTable = new CellTable<Season>();

		seasonProvider.SeasonsData = new FilteredListDataProvider<>(new SeasonsFilter());
		
		seasonProvider.SeasonsData.addDataDisplay(seasonProvider.SeasonsTable);
		seasonProvider.SeasonsList = seasonProvider.SeasonsData.getList();
		seasonProvider.SeasonsData.setList(seasonProvider.SeasonsList);
		seasonProvider.SeasonsTable.setSelectionModel(seasonProvider.loanableSeasonSelection);
		
		seasonProvider.SeasonsTable.setStyleName("cellTableCell");

		Column<Season, String> titleColumn = new Column<Season, String>(new TextCell()) {
			@Override
			public String getValue(Season object) {
				return object.getTitle();
			}
		};
		Column<Season, String> categoryColumn = new Column<Season, String>(new TextCell()) {

			@Override
			public String getValue(Season object) {
				return object.getBroadcastedBy();
			}
		};

		Column<Season, String> ratingColumn = new Column<Season, String>(
				new TextCell()) {

			@Override
			public String getValue(Season object) {
				return "" + object.getRating().ordinal();
			}
		};
		
		Column<Season, String> dateColumn = new Column<Season, String>(
				new TextCell()) {
			@Override
			public String getValue(Season object) {	
				String year = object.getReleaseDate().toString();
				year = year.substring(28);
				return year;
			}
		};
		
		Column<Season, String> episodeColumn = new Column<Season, String>(
				new TextCell()) {

			@Override
			public String getValue(Season object) { 
				return "" + object.getEpisodes().size();
			}
		};
		
		Column<Season, String> getSerieColumn = new Column<Season, String>(
				new TextCell()) {

			@Override
			public String getValue(Season object) { 
				return "" + object.getSeries().getTitle();
			}
		};
		
		seasonProvider.SeasonsTable.addColumn(getSerieColumn, "Series" );
		seasonProvider.SeasonsTable.addColumn(titleColumn, "Title");
		seasonProvider.SeasonsTable.addColumn(dateColumn,"Date");
		seasonProvider.SeasonsTable.addColumn(episodeColumn, "Quantity");



		titleColumn.setSortable(true);	
		categoryColumn.setSortable(true);
		ratingColumn.setSortable(true);

		ListHandler<Season> sortHandler = new ListHandler<Season>(seasonProvider.SeasonsData.getList());
		seasonProvider.SeasonsTable.addColumnSortHandler(sortHandler);

		sortHandler.setComparator(titleColumn, new Comparator<Season>() {

			@Override
			public int compare(Season o1, Season o2) {
				return o1.getTitle().compareTo(o2.getTitle());
			}
		});

		sortHandler.setComparator(categoryColumn, new Comparator<Season>() {

			@Override
			public int compare(Season o1, Season o2) {
				return o1.getBroadcastedBy()
						.compareTo(o2.getBroadcastedBy());
			}
		});

		sortHandler.setComparator(ratingColumn, new Comparator<Season>() {

			@Override
			public int compare(Season o1, Season o2) {
				if (o1.getRating().ordinal() > o2.getRating().ordinal()) {
					return 1;
				}
				if (o1.getRating().ordinal() < o2.getRating().ordinal()) {
					return -1;
				}
				return 0;
			}
		});
		
		seasonProvider.SeasonsTable.addCellPreviewHandler(new Handler<Season>() {

			@Override
			public void onCellPreview(CellPreviewEvent<Season> event) {
				server.getLoanableEpisodeFromSeason();
				episodeProvider.EpisodeTable.setVisible(true);
			//	componentProvider.loanEpisodeButton.setVisible(true);
			}

		}); 
		

		seasonProvider.SeasonsTable.sinkEvents(Event.ONCLICK);
		
		seasonProvider.SeasonsTable.addDomHandler(new DoubleClickHandler() {
			@Override
			public void onDoubleClick(DoubleClickEvent event) {
				for (Season season : seasonProvider.SeasonsList){
					if(seasonProvider.loanableSeasonSelection.isSelected(season)){
							new MessageDialog(season.getBroadcastedBy()).center();
					}
				}
			}
	    }, DoubleClickEvent.getType());
		


		componentProvider.loanSeasonButton.setVisible(false);
		componentProvider.SeasonLabel.setVisible(false);
		componentProvider.showEpisodeButton.setVisible(false);
		seasonProvider.SeasonsTable.setVisible(false);	
		
		
		verticalPanel.add(componentProvider.SeasonLabel);
		verticalPanel.add(seasonProvider.SeasonsTable);
		
		componentProvider.PanelH.add(componentProvider.loanSeasonButton);
		componentProvider.PanelH.add(componentProvider.showEpisodeButton);
		
		verticalPanel.add(componentProvider.PanelH);
		
		Label ll = new Label();
		ll.setText("                        ");
		ll.setSize("500", "500");
		componentProvider.loanablePanel.add(ll);
		
		Label lb = new Label();
		lb.setText("                        ");
		lb.setSize("500", "500");
		componentProvider.loanablePanel.add(lb);
		RootPanel.get("content").add(this);
	}

	private void createEpisodeTable(){
		episodeProvider.EpisodeTable = new CellTable<Episode>();
		episodeProvider.EpisodeData = new FilteredListDataProvider<>(new EpisodesFilter());
		episodeProvider.EpisodeData.addDataDisplay(episodeProvider.EpisodeTable);
		episodeProvider.EpisodeTable.setSelectionModel(episodeProvider.loanableEpisodeSelection);
		
		episodeProvider.EpisodeTable.setStyleName("cellTableCell");

		Column<Episode, String> titleColumn = new Column<Episode, String>(new TextCell()) {
			@Override
			public String getValue(Episode object) {
				return object.getTitle();
			}
		};
		
		Column<Episode, String> timeColumn = new Column<Episode, String>(new TextCell()) {
			@Override
			public String getValue(Episode object) {
				return "" + object.getTime();
			}
		};
		
		Column<Episode, String> categoryColumn = new Column<Episode, String>(
				new TextCell()) {

			@Override
			public String getValue(Episode object) {
				return object.getCategory().name();
			}
		};
		

		Column<Episode, String> ratingColumn = new Column<Episode, String>(
				new TextCell()) {

			@Override
			public String getValue(Episode object) {
				return "" + object.getRating().ordinal();
			}
		};
		
		Column<Episode, String> getSeasonColumn = new Column<Episode, String>(
				new TextCell()) {

			@Override
			public String getValue(Episode object) {
				return "" + object.getSeason().getTitle();
			}
		};
		
		Column<Episode, String> getSerieColumn = new Column<Episode, String>(
				new TextCell()) {

			@Override
			public String getValue(Episode object) {
				return "" + object.getSeason().getSeries().getTitle();
			}
		};
		
		episodeProvider.EpisodeTable.addColumn(getSerieColumn, "Series");
		episodeProvider.EpisodeTable.addColumn(getSeasonColumn, "Season");	
		episodeProvider.EpisodeTable.addColumn(titleColumn, "Title");
		episodeProvider.EpisodeTable.addColumn(timeColumn, "Time");
		episodeProvider.EpisodeTable.addColumn(categoryColumn, "Category");	
		episodeProvider.EpisodeTable.addColumn(ratingColumn, "Rating");


		titleColumn.setSortable(true);
		ratingColumn.setSortable(true);

		ListHandler<Episode> sortEpisodeHandler = new ListHandler<Episode>(episodeProvider.EpisodeData.getList());
		episodeProvider.EpisodeTable.addColumnSortHandler(sortEpisodeHandler);

		sortEpisodeHandler.setComparator(titleColumn, new Comparator<Episode>() {

			@Override
			public int compare(Episode o1, Episode o2) {
				return o1.getTitle().compareTo(o2.getTitle());
			}
		});

		sortEpisodeHandler.setComparator(ratingColumn, new Comparator<Episode>() {

			@Override
			public int compare(Episode o1, Episode o2) {
				if (o1.getRating().ordinal() > o2.getRating().ordinal()) {
					return 1;
				}
				if (o1.getRating().ordinal() < o2.getRating().ordinal()) {
					return -1;
				}
				return 0;
			}
		});
		
		
		episodeProvider.EpisodeTable.addDomHandler(new DoubleClickHandler() {
			@Override
			public void onDoubleClick(DoubleClickEvent event) {
				for (Episode episode: episodeProvider.EpisodeList){
					if(episodeProvider.loanableEpisodeSelection.isSelected(episode)){
							new MessageDialog(episode.getOfdbID()).center();
					}
				}
			}
	    }, DoubleClickEvent.getType());

		componentProvider.loanEpisodeButton.setVisible(false);
		componentProvider.EpisodeLabel.setVisible(false);
		episodeProvider.EpisodeTable.setVisible(false);	
		
		verticalPanel.add(componentProvider.EpisodeLabel);
		verticalPanel.add(episodeProvider.EpisodeTable);
		verticalPanel.add(componentProvider.loanEpisodeButton);
		RootPanel.get("content").add(this);
	}
	    
	public void clear() {
		RootPanel.get("content").clear();
	}
	
	private class GetDataFromServer{
		
		public void getLoanableSeries() {
			
			componentProvider.movieService.listLoanableSeries(new AsyncCallback<List<Series>>() {
						@Override
						public void onSuccess(List<Series> result) {
							seriesProvider.SeriesData.setList(result);
							seriesProvider.SeriesList = new ArrayList<Series>(result);
							server.getLoanableSeason();
						}
						
						@Override
						public void onFailure(Throwable caught) {
							GWT.log(caught.getMessage());
						}
					});
		}
		
		public void getLoanableSeason(){
			
			componentProvider.movieService.listLoanableSeasons( new AsyncCallback<List<Season>>(){
			@Override
			public void onSuccess(List<Season> result) {
					seasonProvider.SeasonsData.setList(result);
					seasonProvider.SeasonsList = new ArrayList<Season>(result);
					server.getLoanableEpisodes();
			}
			@Override
			public void onFailure(Throwable caught) {
					GWT.log(caught.getMessage());
					}
				});  
			}
		
		public void getLoanableSeasonFromSerie(){
			
			for (Series serie : seriesProvider.SeriesList){
				if (seriesProvider.loanableSerieSelection.isSelected(serie)){
					seasonProvider.SeasonsData.setList(seasonProvider.SeasonsList);
					seasonProvider.SeasonsList = new ArrayList<Season>(serie.getSeasons());

				}
			}
		}
		
		public void getLoanableEpisodes(){
			
					componentProvider.movieService.listLoanableEpisodes(new AsyncCallback<List<Episode>>(){
					public void onSuccess(List<Episode> result) {
							episodeProvider.EpisodeList = new ArrayList<Episode>(result);
							episodeProvider.EpisodeData.setList(result);						
						}				
						@Override
						public void onFailure(Throwable caught) {
							GWT.log(caught.getMessage());
						}

					});
		}
		
		public void getLoanableEpisodeFromSeason(){ 
			
			for (Season season : seasonProvider.SeasonsList){
				if (seasonProvider.loanableSeasonSelection.isSelected(season)){
					componentProvider.movieService.listEpisodesFromSeason(season, new AsyncCallback<List<Episode>>(){
						
						@Override
						public void onSuccess(List<Episode> result) {
								episodeProvider.EpisodeData.setList(result);
								episodeProvider.EpisodeList = new ArrayList<Episode>(result);
						}
						@Override
						public void onFailure(Throwable caught) {
								GWT.log(caught.getMessage());
								}
							});  
						}
					}
				}	
			}		

	private class Items{
		
		public void createButtons(){
			setSearchButton();		
			setLoanMovieButton();
			setLoanSerieButton();
			setLoanSeasonButton();
			setLoanEpisodeButton();		
			setShowSeasonButton();
			setShowEpisodeButton();		
		}
		
		public void setLoanMovieButton(){
			
			componentProvider.loanMovieButton.addClickHandler(new ClickHandler() {
				@Override
				public void onClick(ClickEvent event) {
					Movie loan = null;
					for (Movie movie : movieProvider.moviesList) {
						if (movieProvider.loanableSelection.isSelected(movie)) {
							loan = movie;
							break;
						}
					}
					if (loan != null) {
						new ReturnDateDialog(loan).center();
					} 
					else {
						new MessageDialog("You have to select a movie to loan!").center();
						return;
					}
				}
			});
		}
		
		public void setLoanSerieButton(){
			componentProvider.loanSerieButton.addClickHandler(new ClickHandler() {
				@Override
				public void onClick(ClickEvent event) {
					Series loanSerie = null;
					for (Series serie : seriesProvider.SeriesList) {
						if (seriesProvider.loanableSerieSelection.isSelected(serie)) {
							loanSerie = serie;
							break;
						}
					}
					if (loanSerie != null){
						new ReturnDateDialog(loanSerie).center();
					}
					else {
						new MessageDialog("You have to select a serie to loan!").center();
						return;
					}
				}
			});
		}
		
		public void setLoanSeasonButton(){
			componentProvider.loanSeasonButton.addClickHandler(new ClickHandler() {
				@Override
				public void onClick(ClickEvent event) {
					Season loanSeason = null;
					for (Season season : seasonProvider.SeasonsList) {
						if (seasonProvider.loanableSeasonSelection.isSelected(season)) {
							loanSeason = season;
							break;
						}
					}
					if (loanSeason != null){
						new ReturnDateDialog(loanSeason).center();
					}
					else {
						new MessageDialog("You have to select a season to loan!").center();
						return;
					}
				}
			});
		}
		
		public void setLoanEpisodeButton(){
			componentProvider.loanEpisodeButton.addClickHandler(new ClickHandler() {
				@Override
				public void onClick(ClickEvent event) {
					Episode loanEpisode = null;
					for (Episode episode : episodeProvider.EpisodeList) {
						if (episodeProvider.loanableEpisodeSelection.isSelected(episode)) {
							loanEpisode = episode;
							break;
						}
					}
					if (loanEpisode != null){
						new ReturnDateDialog(loanEpisode).center();
					}
					else {
						new MessageDialog("You have to select a Episode to loan!").center();
						return;
					}
				}
			});
		}
		
		public void setShowEpisodeButton(){
			
			componentProvider.showEpisodeButton.addClickHandler(new ClickHandler() {
				@Override
				public void onClick(ClickEvent event) {
					componentProvider.EpisodeLabel.setVisible(true);
					server.getLoanableEpisodeFromSeason();
					componentProvider.loanEpisodeButton.setVisible(true);
					episodeProvider.EpisodeTable.setVisible(true);
					
				}
			});
			
		}
		
		public void setShowSeasonButton(){
			
				componentProvider.showSeasonButton.addClickHandler(new ClickHandler() {
					@Override
					public void onClick(ClickEvent event) {
						server.getLoanableSeasonFromSerie();
						componentProvider.SeasonLabel.setVisible(true);
						componentProvider.loanSeasonButton.setVisible(false);
						componentProvider.showEpisodeButton.setVisible(false);
						episodeProvider.EpisodeTable.setVisible(false);
						componentProvider.loanEpisodeButton.setVisible(false);
					
				}});
		}
		
		public void setSearchButton(){
			
			componentProvider.searchButton.addClickHandler(new ClickHandler() {
				@Override
				public void onClick(ClickEvent event) {
					
							movieProvider.MoviesTable.setVisible(true);
							seriesProvider.SeriesTable.setVisible(true);

							componentProvider.loanSerieButton.setVisible(true);
							componentProvider.loanMovieButton.setVisible(true);

							componentProvider.showSeasonButton.setVisible(false);
							
							componentProvider.SeriesLabel.setVisible(true);
							componentProvider.MoviesLabel.setVisible(true);
							seasonProvider.SeasonsTable.setVisible(true);
							episodeProvider.EpisodeTable.setVisible(true);
							
							componentProvider.loanSeasonButton.setVisible(true);
							componentProvider.SeasonLabel.setVisible(true);
							componentProvider.showEpisodeButton.setVisible(false);
							
							componentProvider.EpisodeLabel.setVisible(true);
							componentProvider.loanEpisodeButton.setVisible(true);
					
				}
			});
		
		}
				
		public void createTextBox(){
			
			componentProvider.filterTextBox.addValueChangeHandler(new ValueChangeHandler<String>() {

				@Override
				public void onValueChange(ValueChangeEvent<String> event) {
					movieProvider.MoviesData.setFilter(componentProvider.filterTextBox.getText());				
					seriesProvider.SeriesData.setFilter(componentProvider.filterTextBox.getText());
					seasonProvider.SeasonsData.setFilter(componentProvider.filterTextBox.getText());
					episodeProvider.EpisodeData.setFilter(componentProvider.filterTextBox.getText());
					
					
				}
			});
		}
	
		public void createAnchorMyLoans(){

		componentProvider.archor.setHTML("<h2>My Loans ...</h2>");
		componentProvider.archor.addClickHandler(new ClickHandler() {

		@Override
		public void onClick(ClickEvent event) {
			
			componentProvider.movieService.listLoanedMovies(new AsyncCallback<List<Movie>>() {
				@Override
				public void onSuccess(List<Movie> result) {
					LoanUI page = new LoanUI(result);
					page.init();
					page.show();
					componentProvider.archorPanel.setVisible(false);
					componentProvider.buttonPanel.setVisible(false);
					componentProvider.filterPanel.setVisible(false);
				}
				
				@Override
				public void onFailure(Throwable caught) {
					GWT.log(caught.getMessage());
				} 
			}); }});
		}

		public void setPosition(){
			
		//Image
		RootPanel.get("content").add(componentProvider.dock);
		componentProvider.dock.add(new Image("images/mainPage_Image.png"), DockPanel.CENTER);
		//archorMyLoan
		componentProvider.archorPanel.add(componentProvider.archor);
		componentProvider.archor.setStyleName("style");
		RootPanel.get("content").add(componentProvider.archor);
		
		componentProvider.filterTextBox.setPixelSize(525, 20);
		componentProvider.filterPanel.add(componentProvider.filterTextBox);
		RootPanel.get("content").add(componentProvider.filterPanel);	

		//searchButton
		componentProvider.filterPanel.add(componentProvider.searchButton);
		componentProvider.searchButton.setStyleName("setButton");
		componentProvider.filterPanel.setCellHorizontalAlignment(componentProvider.searchButton, HasHorizontalAlignment.ALIGN_CENTER );
		componentProvider.filterPanel.setCellVerticalAlignment(componentProvider.searchButton, HasVerticalAlignment.ALIGN_MIDDLE );

	}}
		
	private void upd() {
		movieProvider.MoviesData.setList(movieProvider.moviesList);
		seriesProvider.SeriesData.setList(seriesProvider.SeriesList);
		seasonProvider.SeasonsData.setList(seasonProvider.SeasonsList);
		episodeProvider.EpisodeData.setList(episodeProvider.EpisodeList);
	}
		
	public class LoanCallback implements AsyncCallback<Void> {
		
		Container componentProvider = new Container();
		
		private Movie movieToLoan;
		private Series serieToLoan;
		private Season seasonToLoan;
		private Episode episodeToLoan;
		
		public int FLAG = 0;

		public void refresh(){
			
			componentProvider.movieService.listLoanableMovies(new AsyncCallback<List<Movie>>() {
				@Override
				public void onFailure(Throwable caught) {
					GWT.log(caught.getMessage());
				}
				@Override
				public void onSuccess(final List<Movie> result) {
					Timer thread = new Timer() {
						@Override
						public void run() {
							MainUI mainPage = new MainUI(result,componentProvider.filterTextBox.getText(),true);
							mainPage.init(); 
						}
						
					};		
					thread.schedule(1);
				}
			});
		}
		
		public LoanCallback(Movie loanMovie) {
			movieToLoan = loanMovie;
			FLAG = 1;
		}
		
		public LoanCallback(Series loanSerie){
			serieToLoan = loanSerie;
			FLAG = 2;
		}

		public LoanCallback(Season loanSeason){
			seasonToLoan = loanSeason;
			FLAG = 3;
		}
		
		public LoanCallback(Episode loanEpisode){
			episodeToLoan = loanEpisode;
			FLAG = 4;
		}
		
		@Override
		public void onFailure(Throwable caught) {
			GWT.log(caught.getMessage());
		}

		@Override
		public void onSuccess(Void result) {
			if(FLAG == 1){
				movieProvider.moviesList.remove(movieToLoan);
				upd();
				refresh();
			}
			if(FLAG == 2){
				seriesProvider.SeriesList.remove(serieToLoan);
				upd();
				refresh();
			}
			if(FLAG == 3){
				seasonProvider.SeasonsList.remove(seasonToLoan);
				upd();
				refresh();
			}
			if(FLAG == 4){
				episodeProvider.EpisodeList.remove(episodeToLoan);
				upd();
				refresh();
			}
		}

	}
	
	public class ReturnDateDialog extends DialogBox {	
		
		private Date loanedUntil;

		Movie movieToLoan;
		Series seriesToLoan;
		Season seasonToLoan;
		Episode episodeToLoan;
		
		int FLAG = 0;
		
		public ReturnDateDialog(final Movie loanMovie) { movieToLoan = loanMovie; FLAG = 1; createDialog();}
		public ReturnDateDialog(final Series loanSerie) { seriesToLoan = loanSerie; FLAG = 2; createDialog();}
		public ReturnDateDialog(final Season loanSeason) { seasonToLoan = loanSeason; FLAG = 3; createDialog();}
		public ReturnDateDialog(final Episode loanEpisode) { episodeToLoan = loanEpisode; FLAG = 4; createDialog();}
		
		public void createDialog() {	
			
			setAnimationEnabled(true);
			setGlassEnabled(true);

			VerticalPanel panel = new VerticalPanel();
			panel.setSpacing(10);

			HorizontalPanel hp = new HorizontalPanel();
			hp.setSpacing(50);

			//Picker
			DatePicker picker = new DatePicker();
			picker.addValueChangeHandler(new ValueChangeHandler<Date>() {

				@Override
				public void onValueChange(ValueChangeEvent<Date> event) {
					loanedUntil = event.getValue();
				}
			});

			panel.add(picker);

			//SaveButton
			Button loanButton = new Button("Save");
			loanButton.addClickHandler(new ClickHandler() {
				public void onClick(ClickEvent event) {
					
					if (isBeforeTommorow(loanedUntil)) {
						new MessageDialog("The return date must be later than today's date!").center();
						return;
					}
					if (isLoanPeriodExceeded(loanedUntil)) {
						new MessageDialog("The return date cannot be later than today's date + 14 days!").center();
						return;
					}
					ReturnDateDialog.this.hide();
					
					if (FLAG == 1) {
						movieToLoan.setLoanedUntil(loanedUntil);
						componentProvider.movieService.loanMovie(movieToLoan, new LoanCallback(movieToLoan));
					}
					if (FLAG == 2) {
						seriesToLoan.setLoanedUntil(loanedUntil);
						componentProvider.movieService.loanSerie(seriesToLoan, new LoanCallback(seriesToLoan));
					}
					if (FLAG == 3){
						seasonToLoan.setLoanedUntil(loanedUntil);
						componentProvider.movieService.loanSeason(seasonToLoan, new LoanCallback(seasonToLoan));
					}
					if (FLAG == 4){
						episodeToLoan.setLoanedUntil(loanedUntil);
						componentProvider.movieService.loanEpisode(episodeToLoan, new LoanCallback(episodeToLoan));
					}
				}

				private boolean isLoanPeriodExceeded(Date loanedUntil) {
					Date returnDate = new Date();
					CalendarUtil.addDaysToDate(returnDate, 14);
					return loanedUntil.after(returnDate);
				}

				private boolean isBeforeTommorow(Date loanedUntil) {
					return loanedUntil.before(new Date());
				}

			});

			
			//Abort Button
			Button cancelButton = new Button("Abort");
			cancelButton.addClickHandler(new ClickHandler() {

				@Override
				public void onClick(ClickEvent event) {
					ReturnDateDialog.this.hide();
				}
			});
			hp.add(loanButton);
			hp.add(cancelButton);
			panel.add(hp);
			setWidget(panel);
		}		
	}
	
	private class Refresh extends ClickEvent{
		
        Refresh(){
        	server.getLoanableSeries();
        	
    		item.setPosition();
    		
    		createMovieTable();
    		createSeriesTable();
    		createSeasonsTable();
    		createEpisodeTable();
    		
    		item.createAnchorMyLoans();
    		item.createTextBox();
    		item.createButtons();

    		
			movieProvider.MoviesTable.setVisible(true);
			seriesProvider.SeriesTable.setVisible(true);

			componentProvider.loanSerieButton.setVisible(true);
			componentProvider.loanMovieButton.setVisible(true);

			componentProvider.showSeasonButton.setVisible(false);
			
			componentProvider.SeriesLabel.setVisible(true);
			componentProvider.MoviesLabel.setVisible(true);
			seasonProvider.SeasonsTable.setVisible(true);
			episodeProvider.EpisodeTable.setVisible(true);
			
			componentProvider.loanSeasonButton.setVisible(true);
			componentProvider.SeasonLabel.setVisible(true);
			componentProvider.showEpisodeButton.setVisible(false);
			
			componentProvider.EpisodeLabel.setVisible(true);
			componentProvider.loanEpisodeButton.setVisible(true);
			
			movieProvider.MoviesData.setFilter(componentProvider.filterTextBox.getText());
			seriesProvider.SeriesData.setFilter(componentProvider.filterTextBox.getText());
			seasonProvider.SeasonsData.setFilter(componentProvider.filterTextBox.getText());
			episodeProvider.EpisodeData.setFilter(componentProvider.filterTextBox.getText());
    		
    		RootPanel.get("content").add(componentProvider.loanablePanel);
		}
     
    }
	
}
