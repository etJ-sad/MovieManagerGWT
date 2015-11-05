package de.unihd.movies.client;

import java.util.ArrayList;
import java.util.Comparator;

import com.google.gwt.cell.client.EditTextCell;
import com.google.gwt.cell.client.FieldUpdater;
import com.google.gwt.cell.client.SelectionCell;
import com.google.gwt.cell.client.TextCell;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.ColumnSortEvent.ListHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.view.client.SingleSelectionModel;

import de.unihd.movies.client.filter.FilteredListDataProvider;
import de.unihd.movies.client.filter.MovieFilter;
import de.unihd.movies.client.service.MovieManagerService;
import de.unihd.movies.client.service.MovieManagerServiceAsync;



public class MovieUI {
	
	private final HTML Header = new HTML("<h1>MovieManager</h1>");
	
	public final FilteredListDataProvider<Movie> dataProvider;
	public final ArrayList<Movie> movieList;
	public final MovieManagerServiceAsync service = GWT.create(MovieManagerService.class);
	public final Button addButton = new Button("Add Movie");
	public final Button deleteButton = new Button("Del Movie");
	public final TextBox textBox = new TextBox();
	public final SingleSelectionModel<Movie> selection = new SingleSelectionModel<Movie>();
	public final HorizontalPanel hp = new HorizontalPanel();
	public final ArrayList<String> LANG = new ArrayList<String>();

	public MovieUI(ArrayList<Movie> movie) {
		movieList = movie;
		RootPanel rootPanel = RootPanel.get("content");
		VerticalPanel vp = new VerticalPanel();
		CellTable<Movie> table = new CellTable<Movie>();
		table.setSelectionModel(selection);

		vp.add(Header);
		vp.add(hp);
		vp.add(table);

		rootPanel.add(vp);

		setAddButton();
		setDelButton();
		setTextBox();
		setLANG();

		// { Columns } 
		
		// idColumn
		Column<Movie, String> idColumn = new Column<Movie, String>(new TextCell()) {
			@Override
			public String getValue(Movie object) {
				return "" + object.getId();
			}}; table.addColumn(idColumn, "ID");
			
		// nameColumn
		Column<Movie, String> nameColumn = new Column<Movie, String>(new EditTextCell()) {
			@Override
			public String getValue(Movie object) {
				return object.getName();
			}
		};
		nameColumn.setFieldUpdater(new FieldUpdater<Movie, String>() {
			@Override
			public void update(int index, Movie object, String value) {
				object.setName(value);
				saveMovies();
				updateTable();
			}
		});table.addColumn(nameColumn, "Name");
		
		// timeColumn
		Column<Movie, String> timeColumn = new Column<Movie, String>(new EditTextCell()) {
			@Override
			public String getValue(Movie object) {
				if (object.getTime() < 0) {
					return "Error, Only positive times.";
				}else {
				return "" + object.getTime();
				}
			}
			
		};
			table.addColumn(timeColumn, "Time");
		
		Column<Movie, String> languageColumn = new Column<Movie, String>(new SelectionCell(LANG)) {

			@Override
			public String getValue(Movie object) {
				return object.getLanguage();
			}
		}; table.addColumn(languageColumn, "Language");
		languageColumn.setFieldUpdater(new FieldUpdater<Movie, String>() {
			@Override
			public void update(int index, Movie object, String value) {
				object.setLanguage(value);
				saveMovies();
				updateTable();
			}
		});
		
		// descriptionColumn	
		Column<Movie, String> descriptionColumn = new Column<Movie, String>(new EditTextCell()) {
			@Override
			public String getValue(Movie object) {
				return object.getDescription();
			}
		};
		descriptionColumn.setFieldUpdater(new FieldUpdater<Movie, String>() {
			@Override
			public void update(int index, Movie object, String value) {
				object.setDescription(value);
				saveMovies();
				updateTable();
			}
		}); table.addColumn(descriptionColumn, "Description");
		
		
		// placceColumn	
		Column<Movie, String> placeColumn = new Column<Movie, String>(new EditTextCell()) {
			@Override
			public String getValue(Movie object) {
				return object.getPlace();
			}
		};
		placeColumn.setFieldUpdater(new FieldUpdater<Movie, String>() {
			@Override
			public void update(int index, Movie object, String value) {
				object.setPlace(value);
				saveMovies();
				updateTable();
			}
		}); table.addColumn(placeColumn, "Place");
		
		
		
		dataProvider = new FilteredListDataProvider<Movie>(new MovieFilter());
		dataProvider.addDataDisplay(table);
		dataProvider.setList(movieList);

		// setSortable
		idColumn.setSortable(true);
		nameColumn.setSortable(true);
		timeColumn.setSortable(true);
		languageColumn.setSortable(true);
		descriptionColumn.setSortable(true);
		placeColumn.setSortable(true);
		
		ListHandler<Movie> sortHandler = new ListHandler<Movie>(dataProvider.getList());
		table.addColumnSortHandler(sortHandler);
	
		sortHandler.setComparator(idColumn, new Comparator<Movie>() {
			@Override
			public int compare(Movie o1, Movie o2) {
				if (o1.getId() > o2.getId()) {
					return 1;
				}
				if (o1.getId() < o2.getId()) {
					return -1;
				}
				return 0;
			}
		});
				
		sortHandler.setComparator(nameColumn, new Comparator<Movie>() {
			@Override
			public int compare(Movie o1, Movie o2) {
				return o1.getName().compareTo(o2.getName());
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
		
		sortHandler.setComparator(descriptionColumn, new Comparator<Movie>() {
			@Override
			public int compare(Movie o1, Movie o2) {
				return o1.getDescription().compareTo(o2.getDescription());
			}
		});
		
		
		sortHandler.setComparator(placeColumn, new Comparator<Movie>() {
			@Override
			public int compare(Movie o1, Movie o2) {
				return o1.getPlace().compareTo(o2.getPlace());
			}
		});

		sortHandler.setComparator(languageColumn, new Comparator<Movie>() {
			@Override
			public int compare(Movie o1, Movie o2) {
				return o1.getLanguage().compareTo(o2.getLanguage());
			}
		});

	}
	
	public void setAddButton(){
		addButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				int id = dataProvider.getList().size();
				Movie movie = new Movie(id, "",0, "", "","");
				movieList.add(movie);
				saveMovies();
				updateTable();
			}
		}); hp.add(addButton);
	}
	
	public final void setDelButton(){
			deleteButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				Movie toDelete = null;
				for (Movie current : movieList) {
					if (selection.isSelected(current)) {
						toDelete = current;
						break;
					}
				}
				if (toDelete != null) {
					movieList.remove(toDelete);
					saveMovies();
					updateTable();
				}
			} });hp.add(deleteButton);
		}
	
	public final  void setLANG(){
		LANG.add("German");
		LANG.add("English");	
		LANG.add("Spanian");
		LANG.add("France");
		LANG.add("Russian");
	}
	
	public final void setTextBox(){
		textBox.addValueChangeHandler(new ValueChangeHandler<String>() {
			@Override
			public void onValueChange(ValueChangeEvent<String> event) {
				dataProvider.setFilter(textBox.getText());
			}
		});
		hp.add(textBox);
	}
	
	private final void updateTable() {
		dataProvider.setList(movieList);
	}

	private final void saveMovies() {
		service.saveMovies(movieList, new AsyncCallback<Void>() {

			@Override
			public void onFailure(Throwable caught) {
				GWT.log(caught.getMessage());
			}

			@Override
			public void onSuccess(Void result) {
				GWT.log("All changes saved.");
			}
		});
	}

}
