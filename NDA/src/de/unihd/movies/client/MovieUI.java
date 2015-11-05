/**
 * @Version 3.4.642:release
 */

package de.unihd.movies.client;


import java.awt.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Random;

import com.google.gwt.cell.client.EditTextCell;
import com.google.gwt.cell.client.SelectionCell;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.ColumnSortEvent.ListHandler;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.view.client.ListDataProvider;
import com.google.gwt.view.client.SingleSelectionModel;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.*;

import de.unihd.movies.client.filter.FilteredListDataProvider;
import de.unihd.movies.client.filter.MovieFilter;
import de.unihd.movies.client.service.*;


public class MovieUI extends Composite {

	MovieManager manager = new MovieManager();
	private VerticalPanel panel;
	final CellTable<Movie> table = new CellTable<Movie>();
	final ListDataProvider<Movie> dataProvider = new ListDataProvider<Movie>();
    final SingleSelectionModel<Movie> selectionModel = new SingleSelectionModel<Movie>();
    SelectionCell categoryCell = new SelectionCell(manager.LANG);
    public final TextBox tbox = new TextBox();
	private FilteredListDataProvider<Movie> filterDataProvider;
	private final MovieManagerServiceAsync movieService = GWT.create(MovieManagerService.class);
   
	public LinkedList<Movie> movieList = new LinkedList<Movie>();
    
	int numRows = table.getRowCount();
	int ids;
	
	
	
    //-------------------------------------------//
    
    public void setupColumn(LinkedList<Movie> movies){ 	
    	movieList = movies;
    	dataProvider.setList(movieList);
       	//id 
	    TextColumn<Movie> idColumn = new TextColumn<Movie>() {
		      @Override
		      public String getValue(Movie object) {
		    	  String buffer = String.valueOf(object.getId());
		    	  return buffer;
		      }
		    }; table.addColumn(idColumn, "id");
	    
		//Name
	    Column<Movie,String> nameColumn = new Column<Movie,String>( new EditTextCell()) {
	      @Override
	      public String getValue(Movie object) {
	        return object.getName();
	      }
	       }; table.addColumn(nameColumn, "Name");
	    
	    //Time @1x
	    Column<Movie, String> timeColumn = new Column<Movie, String>( new EditTextCell()) {
		      @Override
		      public String getValue(Movie object) {		    		 
		    	  String buffer = String.valueOf(object.getTime());
		    	  if (buffer == "0") {
		    			  String swap_buff = "Only positive number";
			    		  return swap_buff;
		    	  } else {
		    		  return buffer;
		    	  }
		      }
		    }; table.addColumn(timeColumn, "Time");
		    
		//Language
	    Column<Movie,String> languageColumn = new Column<Movie,String>( categoryCell) {
		      @Override
		      public String getValue(Movie object) {
		        return object.getLanguage();
		      }
		    }; table.addColumn(languageColumn, "Language");
		
		//Description
	    Column<Movie,String> descriptionColumn = new Column<Movie, String>( new EditTextCell()) {
		      @Override
		      public String getValue(Movie object) {
		        return object.getDescription();
		      }
		    }; table.addColumn(descriptionColumn, "Description");
	    
	    
	    //Place
	    Column<Movie,String> placeColumn = new Column<Movie, String>( new EditTextCell()) {
	      @Override
	      public String getValue(Movie object) {
	        return object.getPlace();
	      }
	    }; table.addColumn(placeColumn, "Place");
	    
	    
	    //	setSortable
	    idColumn.setSortable(true);
	    nameColumn.setSortable(true);
	    timeColumn.setSortable(true);
	    languageColumn.setSortable(true);
	    descriptionColumn.setSortable(true);
	    placeColumn.setSortable(true);
	    
	    //Handler
	    ListHandler<Movie> columnSortHandler = new ListHandler<Movie>(
	    		dataProvider.getList()
	    		);

	    // Sorts:
			
	    // idColumn sort
	    columnSortHandler.setComparator(idColumn, new Comparator<Movie>() {
	    	@Override
	    	public int compare(Movie m1, Movie m2) {
	    		if(m1.getId() > m2.getId()) return 1;
	    		if(m1.getId() < m2.getId()) return -1;
	    		return 0;
				};
		});
			
		// nameCoulmn sort	
		columnSortHandler.setComparator(nameColumn, new Comparator<Movie>() {
		@Override
		public int compare(Movie m1, Movie m2) {
			return (m1.getName().compareTo(m2.getName()));
			};
		});
		
		// timeColumn sort
		columnSortHandler.setComparator(timeColumn, new Comparator<Movie>() {
		@Override
		public int compare(Movie m1, Movie m2) {
			if(m1.getId() > m2.getId()) return 1;
			if(m1.getId() < m2.getId()) return -1;
			return 0;
			};
		});
			
		// languageColumn sort
		columnSortHandler.setComparator(languageColumn, new Comparator<Movie>() {
		@Override
		public int compare(Movie m1, Movie m2) {
			return (m1.getName().compareTo(m2.getName()));
			};
		});
			
		// descriptionColumn sort
		columnSortHandler.setComparator(descriptionColumn, new Comparator<Movie>() {
		@Override
		public int compare(Movie m1, Movie m2) {
			return (m1.getName().compareTo(m2.getName()));
			};
		});
			
		// placeColumn Sort
		columnSortHandler.setComparator(placeColumn, new Comparator<Movie>() {
		@Override
		public int compare(Movie m1, Movie m2) {
			return (m1.getName().compareTo(m2.getName()));
			};
		});
		table.addColumnSortHandler(columnSortHandler);
    }

    
	public void createTable(){
		table.setRowCount(numRows+1);
		table.setRowCount(manager.getList().size());
	    dataProvider.addDataDisplay(table);
	    table.setSelectionModel(selectionModel);
	    ids = table.getRowCount();
	    filterDataProvider = new FilteredListDataProvider<Movie>(new MovieFilter());
		filterDataProvider.setList(manager.getList());
	    RootPanel.get().add(table);
	}
		
	//(addButton,10,100);
	public void addButton(){
		Button addButton = new Button("Add Movie");
		
		addButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {				
				dataProvider.getList().addAll(numRows, manager.empty());
				dataProvider.getList().get(numRows).setId(ids+1);
				ids++;
				saveMovies_ALL();
				update();
				}
	      }); RootPanel.get().add(addButton,10,100);
	}
	
	//(delButton,100,100);
	public void delButton(){
		Button delButton = new Button("Delete movie");
	    delButton.addClickHandler(new ClickHandler() {
	        @Override
	        public void onClick(ClickEvent event) {
	            Movie selected = selectionModel.getSelectedObject();
	            if (selected != null) {
	                dataProvider.getList().remove(selected);
	                saveMovies_ALL();
	                update();
	            }
	        }
	    }); RootPanel.get().add(delButton,100,100);
	}	
	
	//(tbox,210,100);
	public void addTextBox(){
		tbox.addValueChangeHandler(new ValueChangeHandler<String>() {		
			@Override
			public void onValueChange(ValueChangeEvent<String> event) {
				filterDataProvider.setFilter(tbox.getText());
			}
		});
		RootPanel.get().add(tbox,210,100);
	}
	
	
	private void update(){
		movieList = (LinkedList<Movie>) dataProvider.getList();
		dataProvider.setList(movieList);
	}
	
	private void saveMovies_ALL() {
		LinkedList<Movie> swap_list = (LinkedList<Movie>) dataProvider.getList();
		movieService.saveMovies(swap_list, new AsyncCallback<Void>() {

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
	
	
	public void show() {
		initWidget(panel);
		RootPanel.get("content").add(this);
		this.setVisible(true);
		
	}

}

