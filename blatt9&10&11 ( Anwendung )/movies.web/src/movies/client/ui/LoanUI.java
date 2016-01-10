package movies.client.ui;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import movies.client.filter.EpisodesFilter;
import movies.client.filter.FilteredListDataProvider;
import movies.client.filter.MovieFilter;
import movies.client.filter.SeasonsFilter;
import movies.client.filter.SeriesFilter;
import movies.client.provider.ComponentProvider;
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
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.ColumnSortEvent.ListHandler;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.view.client.SingleSelectionModel;

public class LoanUI extends Composite {
	
	MovieProvider movieProvider = new MovieProvider();
	SeriesProvider seriesProvider = new SeriesProvider();
	SeasonProvider seasonProvider = new SeasonProvider();
	EpisodeProvider episodeProvider = new EpisodeProvider();
	
	ComponentProvider componentProvider = new ComponentProvider();
	GetDataFromServer server = new GetDataFromServer();
	Items item = new Items();
	
	Label ll = new Label("  ");

	
	public LoanUI(List<Movie> movies) {
		clear();
		movieProvider.moviesList = new ArrayList<Movie>(movies);
	}	
	
	public void init() {
		
		server.run();
		
		ll.setSize("500", "500");
		
		movieProvider.loanSelection = new SingleSelectionModel<Movie>();

		item.setReturnMovieButton();
		item.setReturnSerieButton();
		item.setReturnSeasonButton();
		
		item.setReturnEpisodeButton();
		
		item.setShowSeasonButton();
		item.setShowEpisodeButton();
		item.createTextBox();
		item.setPosition();

		createLoanedMovieTable();
		createLoanedSerieTable();
		createLoanedSeasonTable();
		createLoanedEpisodeTable();
		
		initWidget(componentProvider.loansPanel);
		RootPanel.get("content").add(this,100,200);

	}

	private void updateTables() {
		movieProvider.MoviesData.setList(movieProvider.moviesList);
		seriesProvider.SeriesData.setList(seriesProvider.SeriesList);
		seasonProvider.SeasonsData.setList(seasonProvider.SeasonsList);
		episodeProvider.EpisodeData.setList(episodeProvider.EpisodeList);
	}
	
	private void createLoanedEpisodeTable(){
		
		episodeProvider.EpisodeTable = new CellTable<Episode>();
		episodeProvider.EpisodeData = new FilteredListDataProvider<>(new EpisodesFilter());
		
		episodeProvider.EpisodeData.addDataDisplay(episodeProvider.EpisodeTable);
		episodeProvider.EpisodeList = episodeProvider.EpisodeData.getList();
		episodeProvider.EpisodeData.setList(episodeProvider.EpisodeList);
		episodeProvider.EpisodeTable.setSelectionModel(episodeProvider.loanEpisodeSelection);

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
		

		Column<Episode, String> loanedUntilColumn = new Column<Episode, String>(
				new TextCell()) {

			@Override
			public String getValue(Episode object) {
				DateTimeFormat format = DateTimeFormat.getFormat("dd.MM.yyyy");
				return format.format(object.getLoanedUntil());
			}
		};

		episodeProvider.EpisodeTable.addColumn(getSerieColumn, "Series");
		episodeProvider.EpisodeTable.addColumn(getSeasonColumn, "Season");	
		episodeProvider.EpisodeTable.addColumn(titleColumn, "Title");
		episodeProvider.EpisodeTable.addColumn(timeColumn, "Time");
		episodeProvider.EpisodeTable.addColumn(categoryColumn, "Category");	
		episodeProvider.EpisodeTable.addColumn(ratingColumn, "Rating");
		
		episodeProvider.EpisodeTable.addColumn(loanedUntilColumn,"Return date");

		titleColumn.setSortable(true);
		ratingColumn.setSortable(true);

		ListHandler<Episode> sortHandler = new ListHandler<Episode>(episodeProvider.EpisodeData.getList());
		episodeProvider.EpisodeTable.addColumnSortHandler(sortHandler);

		sortHandler.setComparator(titleColumn, new Comparator<Episode>() {

			@Override
			public int compare(Episode o1, Episode o2) {
				return o1.getTitle().compareTo(o2.getTitle());
			}
		});

		sortHandler.setComparator(ratingColumn, new Comparator<Episode>() {

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

		componentProvider.loanEpisodeButton.setVisible(true);
		componentProvider.EpisodeLabel.setVisible(true);
		episodeProvider.EpisodeTable.setVisible(true);

		componentProvider.loanEpisodeButton.setText("Return");
		componentProvider.EpisodeLabel.setHTML("<h2>Episodes to return</h2>");
		
		componentProvider.loansPanel.add(componentProvider.EpisodeLabel);
		componentProvider.loansPanel.add(episodeProvider.EpisodeTable);
		componentProvider.loansPanel.add(ll);
		componentProvider.loansPanel.add(componentProvider.loanEpisodeButton);
		
	}
		
	private void createLoanedSerieTable() {
		
		seriesProvider.SeriesTable = new CellTable<Series>();
		seriesProvider.SeriesData = new FilteredListDataProvider<>(new SeriesFilter());
		
		seriesProvider.SeriesData.addDataDisplay(seriesProvider.SeriesTable);
		seriesProvider.SeriesList = seriesProvider.SeriesData.getList();
		seriesProvider.SeriesData.setList(seriesProvider.SeriesList);
		seriesProvider.SeriesTable.setSelectionModel(seriesProvider.loanSeriesSelection);

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

	
		Column<Series, String> loanedUntilColumn = new Column<Series, String>(
				new TextCell()) {

			@Override
			public String getValue(Series object) {
				DateTimeFormat format = DateTimeFormat.getFormat("dd.MM.yyyy");
				return format.format(object.getLoanedUntil());
			}
		};

		seriesProvider.SeriesTable.addColumn(titleColumn, "Title");
		seriesProvider.SeriesTable.addColumn(studioColumn,"Studio");
		seriesProvider.SeriesTable.addColumn(yearColumn, "Date");
		seriesProvider.SeriesTable.addColumn(seasonColumn, "Quantity");
		seriesProvider.SeriesTable.addColumn(loanedUntilColumn,"Return date");

		titleColumn.setSortable(true);
		yearColumn.setSortable(true);
		seasonColumn.setSortable(true);
		ratingColumn.setSortable(true);
		
		ListHandler<Series> sortHandler = new ListHandler<Series>(seriesProvider.SeriesData.getList());
		seriesProvider.SeriesTable.addColumnSortHandler(sortHandler);

		sortHandler.setComparator(titleColumn, new Comparator<Series>() {

			@Override
			public int compare(Series o1, Series o2) {
				return o1.getTitle().compareTo(o2.getTitle());
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

		componentProvider.loanSerieButton.setVisible(true);
		componentProvider.SeriesLabel.setVisible(true);
		

		componentProvider.loanSerieButton.setText("Return");
		componentProvider.SeriesLabel.setHTML("<h2>Series to return</h2>");
		componentProvider.loansPanel.add(ll);
		componentProvider.PanelS.add(componentProvider.loanSerieButton);
	//	componentProvider.PanelS.add(componentProvider.showSeasonButton);
		componentProvider.loansPanel.add(componentProvider.SeriesLabel);
		componentProvider.loansPanel.add(seriesProvider.SeriesTable);
		componentProvider.loansPanel.add(componentProvider.PanelS);
		
	}
	
	private void createLoanedSeasonTable() {
	
		seasonProvider.SeasonsTable = new CellTable<Season>();
		seasonProvider.SeasonsData = new FilteredListDataProvider<>(new SeasonsFilter());
		
		seasonProvider.SeasonsData.addDataDisplay(seasonProvider.SeasonsTable);
		seasonProvider.SeasonsList = seasonProvider.SeasonsData.getList();
		seasonProvider.SeasonsData.setList(seasonProvider.SeasonsList);
		seasonProvider.SeasonsTable.setSelectionModel(seasonProvider.loanSeasonSelection);

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
		
		Column<Season, String> loanedUntilColumn = new Column<Season, String>(
				new TextCell()) {

			@Override
			public String getValue(Season object) {
				DateTimeFormat format = DateTimeFormat.getFormat("dd.MM.yyyy");
				return format.format(object.getLoanedUntil());
			}
		};

		seasonProvider.SeasonsTable.addColumn(getSerieColumn, "Series" );
		seasonProvider.SeasonsTable.addColumn(titleColumn, "Title");
		seasonProvider.SeasonsTable.addColumn(dateColumn,"Date");
		seasonProvider.SeasonsTable.addColumn(episodeColumn, "Quantity");
		seasonProvider.SeasonsTable.addColumn(loanedUntilColumn,"Return date");

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

		componentProvider.loanSeasonButton.setVisible(false);
		componentProvider.SeasonLabel.setVisible(true);
		seasonProvider.SeasonsTable.setVisible(true);
		componentProvider.loanSeasonButton.setVisible(true);
		componentProvider.loanEpisodeButton.setVisible(true);
		componentProvider.showEpisodeButton.setVisible(false);
		

		componentProvider.loanSeasonButton.setText("Return");
		componentProvider.SeasonLabel.setHTML("<h2>Seasons to return</h2>");
			
		componentProvider.loansPanel.add(ll);
		componentProvider.PanelH.add(componentProvider.loanSeasonButton);
		componentProvider.loansPanel.add(ll);
		componentProvider.PanelH.add(componentProvider.showEpisodeButton);
		
		componentProvider.loansPanel.add(componentProvider.SeasonLabel);
		componentProvider.loansPanel.add(seasonProvider.SeasonsTable);
		componentProvider.loansPanel.add(componentProvider.PanelH);		
	}

	private void createLoanedMovieTable() {
		
		movieProvider.MoviesTable = new CellTable<Movie>();
		movieProvider.MoviesData = new FilteredListDataProvider<>(new MovieFilter());
		movieProvider.MoviesData.addDataDisplay(movieProvider.MoviesTable);
		movieProvider.MoviesData.setList(movieProvider.moviesList);
		movieProvider.MoviesTable.setSelectionModel(movieProvider.loanSelection);

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



		Column<Movie, String> loanedUntilColumn = new Column<Movie, String>(
				new TextCell()) {

			@Override
			public String getValue(Movie object) {
				DateTimeFormat format = DateTimeFormat.getFormat("dd.MM.yyyy");
				return format.format(object.getLoanedUntil());
			}
		};
		
		movieProvider.MoviesTable.addColumn(titleColumn, "Title");
		movieProvider.MoviesTable.addColumn(timeColumn, "Time");
		movieProvider.MoviesTable.addColumn(categoryColumn, "Category");
		movieProvider.MoviesTable.addColumn(ratingColumn, "Rating");

		movieProvider.MoviesTable.addColumn(loanedUntilColumn, "Return Date");

		titleColumn.setSortable(true);
		timeColumn.setSortable(true);
		ratingColumn.setSortable(true);
		categoryColumn.setSortable(true);
		loanedUntilColumn.setSortable(true);

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

		sortHandler.setComparator(loanedUntilColumn, new Comparator<Movie>() {

			@Override
			public int compare(Movie o1, Movie o2) {
				return o1.getLoanedUntil().compareTo(o2.getLoanedUntil());
			}
		});

		componentProvider.loanMovieButton.setText("Return");
		componentProvider.MoviesLabel.setHTML("<h2>Movies to return</h2>");
		
		componentProvider.loansPanel.add(componentProvider.MoviesLabel);
		componentProvider.loansPanel.add(movieProvider.MoviesTable);
		componentProvider.loansPanel.add(ll);
		componentProvider.loansPanel.add(componentProvider.loanMovieButton);
	}

	public void show() {
		setVisible(true);
	}

	public void clear() {
		RootPanel.get("content").clear();
	}

	public class GetDataFromServer{
		
		public void run(){
			Button btnAddField = new Button("404");
			btnAddField.fireEvent(new Shadow ());
		}
		
		public void getLoanedSeasons() {
			componentProvider.movieService.listLoanedSeasons(new AsyncCallback<List<Season>>() {
						@Override
						public void onSuccess(List<Season> result) {
							seasonProvider.SeasonsData.setList(result);
							seasonProvider.SeasonsList = new ArrayList<Season>(result);
							server.getLoanedEpisodes();
							
						}
						
						@Override
						public void onFailure(Throwable caught) {
							GWT.log(caught.getMessage());
						}
					});
		}
		
		public void getLoanedEpisodes(){				
			componentProvider.movieService.listLoanedEpisodes(new AsyncCallback<List<Episode>>(){
						@Override
						public void onSuccess(List<Episode> result) {
							episodeProvider.EpisodeData.setList(result);
							episodeProvider.EpisodeList = new ArrayList<Episode>(result);
							item.setReturnArchonButton();

						}
						
						@Override
						public void onFailure(Throwable caught) {
							GWT.log(caught.getMessage());
						}

					});
		}	
	}
	
	public class Items{
		
		public void setPosition(){
				//archorMyLoan
				componentProvider.archor.setHTML("<h2>Start Page...</h2>");
				componentProvider.archorPanel.add(componentProvider.archor);
				int top = componentProvider.archorPanel.getAbsoluteTop();
				int left = componentProvider.archorPanel.getAbsoluteLeft();
				RootPanel.get("content").add(componentProvider.archorPanel, left + 485, top+10);
				top = 0;
				left = 0;
				
				//filterPanel		
				componentProvider.filterPanel.add(componentProvider.filterTextBox);
				top = componentProvider.filterPanel.getAbsoluteTop();
				left = componentProvider.filterPanel.getAbsoluteLeft();
				componentProvider.filterTextBox.setPixelSize(525, 20);
				RootPanel.get("content").add(componentProvider.filterPanel, left +45, top +160);
				top = 0;
				left = 0;
				
				//Image
				componentProvider.dock.add(new Image("images/mainPage_Image.png"), DockPanel.CENTER);

			    RootPanel.get("content").add(componentProvider.dock,25,60);
			}
	
		public void createTextBox(){
			componentProvider.filterTextBox.addValueChangeHandler(new ValueChangeHandler<String>() {

				@Override
				public void onValueChange(ValueChangeEvent<String> event) {
					movieProvider.MoviesData.setFilter(componentProvider.filterTextBox.getText());
					seriesProvider.SeriesData.setFilter(componentProvider.filterTextBox.getText());
					seasonProvider.SeasonsData.setFilter(componentProvider.filterTextBox.getText());
				}
			});
		}
		
		public void setReturnArchonButton(){

			componentProvider.archor.addClickHandler(new ClickHandler() {
				@Override
				public void onClick(ClickEvent event) {
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
									MainUI mainPage = new MainUI(result,null,false);
									mainPage.init(); 
								}
								
							};		
							thread.schedule(1);
						}
					});
				}
			});

		}
		
		public void setShowSeasonButton(){
			componentProvider.showSeasonButton.addClickHandler(new ClickHandler() {

				@Override
				public void onClick(ClickEvent event) {
					//componentProvider.SeasonLabel.setVisible(true);
					//componentProvider.loanSeasonButton.setVisible(true);



				}
			});
		}
		
		public void setShowEpisodeButton(){
			componentProvider.showEpisodeButton.addClickHandler(new ClickHandler() {

				@Override
				public void onClick(ClickEvent event) {
					componentProvider.EpisodeLabel.setVisible(true);
					episodeProvider.EpisodeTable.setVisible(true);
					componentProvider.loanEpisodeButton.setVisible(true);




				}
			});
		}
		
		public void setReturnMovieButton(){
			
			componentProvider.loanMovieButton.addClickHandler(new ClickHandler() {

				@Override
				public void onClick(ClickEvent event) {

					Movie toReturn = null;
					for (Movie movie : movieProvider.moviesList) {
						if (movieProvider.loanSelection.isSelected(movie)) {
							toReturn = movie;
						}
					}
					if (toReturn != null) {
						componentProvider.movieService.returnMovie(toReturn, new ReturnLoanCallback(
								toReturn));
					} else {
						new MessageDialog(
								"You have to select a movie to return!").center();
					}
				}
			});
		}
		
		public void setReturnSerieButton(){
			componentProvider.loanSerieButton.addClickHandler(new ClickHandler() {

				@Override
				public void onClick(ClickEvent event) {

					Series toReturn = null;
					for (Series serie : seriesProvider.SeriesList) {
						if (seriesProvider.loanSeriesSelection.isSelected(serie)) {
							toReturn = serie;
							break;
						}
					}
					if (toReturn != null) {
						componentProvider.movieService.returnSerie(toReturn, new ReturnLoanCallback(toReturn));
					} else {
						new MessageDialog(
								"You have to select a serie to return!").center();
					}
				}
			});
		}
		
		public void setReturnSeasonButton(){
			componentProvider.loanSeasonButton.addClickHandler(new ClickHandler() {

				@Override
				public void onClick(ClickEvent event) {

					Season toReturn = null;
					for (Season season : seasonProvider.SeasonsList) {
						if (seasonProvider.loanSeasonSelection.isSelected(season)) {
							toReturn = season;
							break;
						}
					}
					if (toReturn != null) {
						componentProvider.movieService.returnSeason(toReturn, new ReturnLoanCallback(toReturn));
					} else {
						new MessageDialog(
								"You have to select a Season to return!").center();
					}
				}
			});
		}
		
		public void setReturnEpisodeButton(){
			componentProvider.loanEpisodeButton.addClickHandler(new ClickHandler() {

				@Override
				public void onClick(ClickEvent event) {

					Episode toReturn = null;
					for (Episode episode : episodeProvider.EpisodeList) {
						if (episodeProvider.loanEpisodeSelection.isSelected(episode)) {
							toReturn = episode;
							break;
						}
					}
					if (toReturn != null) {
						componentProvider.movieService.returnEpisode(toReturn, new ReturnLoanCallback(toReturn));
					} else {
						new MessageDialog(
								"You have to select a Episode to return!").center();
					}
				}
			});
		}
	
	}
	
	public class ReturnLoanCallback implements AsyncCallback<Void> {

		private Movie MovieToReturn;
		private Series SerieToReturn;
		private Season SeasonToReturn;
		private Episode EpisodeToReturn;
		int FLAG = 0;

		public ReturnLoanCallback(Movie returnMovie) {
			MovieToReturn = returnMovie;
			FLAG = 1;
		}
		
		public ReturnLoanCallback(Series returnSerie) {
			SerieToReturn = returnSerie;
			FLAG = 2;
		}
		
		public ReturnLoanCallback(Season returnSeason) {
			SeasonToReturn = returnSeason;
			FLAG = 3;
		}
		
		public ReturnLoanCallback(Episode returnEpisode){
			EpisodeToReturn = returnEpisode;
			FLAG = 4;
		}

		@Override
		public void onFailure(Throwable caught) {
			GWT.log(caught.getMessage());
		}

		@Override
		public void onSuccess(Void result) {
			if (FLAG == 1){
				movieProvider.moviesList.remove(MovieToReturn);
				updateTables();
				new MessageDialog("Done");
			}
			if(FLAG == 2){
				seriesProvider.SeriesList.remove(SerieToReturn);
				updateTables();
				new MessageDialog("Done");
			}
			if(FLAG == 3){
				seasonProvider.SeasonsList.remove(SeasonToReturn);
				updateTables();
				new MessageDialog("Done");
			}
			if(FLAG == 4){
				episodeProvider.EpisodeList.remove(EpisodeToReturn);
				updateTables();
				new MessageDialog("Done");
			}
		}
	}

	
	private class Shadow extends ClickEvent{
        Shadow(){
			componentProvider.movieService.listLoanedSeries(new AsyncCallback<List<Series>>() {
				@Override
				public void onSuccess(List<Series> result) {
					seriesProvider.SeriesData.setList(result);
					seriesProvider.SeriesList = new ArrayList<Series>(result);
					Timer thread = new Timer(){

						@Override
						public void run() {
							server.getLoanedSeasons();	
						}};
						thread.schedule(500);
					

				}
				
				@Override
				public void onFailure(Throwable caught) {
					GWT.log(caught.getMessage());
				}
			});
        }
    }
}
