/**
 * @Version 3.3.99:release
 */

package de.unihd.movies.client;

import java.util.Comparator;

import com.google.gwt.cell.client.EditTextCell;
import com.google.gwt.cell.client.SelectionCell;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.ColumnSortEvent.ListHandler;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.view.client.ListDataProvider;
import com.google.gwt.view.client.SingleSelectionModel;
import com.google.gwt.user.client.ui.*;

public class MovieUI extends Composite {

	MovieManager manager = new MovieManager();
	private VerticalPanel panel;

	final CellTable<Movie> table = new CellTable<Movie>();
	
	final ListDataProvider<Movie> dataProvider = new ListDataProvider<Movie>(manager.getList());
    final SingleSelectionModel<Movie> selectionModel = new SingleSelectionModel<Movie>();
    SelectionCell categoryCell = new SelectionCell(manager.LANG);

	public final TextBox tbox = new TextBox();
    
    
	int numRows = table.getRowCount();
	int ids;
		
    //-------------------------------------------//
    
    public void setupColumn(){ 	
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
	    
	    //Time
	    Column<Movie, String> timeColumn = new Column<Movie, String>( new EditTextCell()) {
		      @Override
		      public String getValue(Movie object) {
		    	  String buffer = String.valueOf(object.getTime());
		    	  return buffer;
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
	    RootPanel.get().add(table);
	}
		
	//(addButton,10,100);
	public void addButton(){
		Button addButton = new Button("Add movie", new ClickHandler() {
			public void onClick(ClickEvent event) {				
				dataProvider.getList().addAll(numRows, manager.empty());
				dataProvider.getList().get(numRows).setId(ids+1);
				ids++;
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
	            }
	        }
	    }); RootPanel.get().add(delButton,100,100);
	}	
	
	//(tbox,210,100);
	public void setTextBox(){
	      RootPanel.get().add(tbox,210,100);
	}
	
	public void show() {
		initWidget(panel);
		RootPanel.get("content").add(this);
		this.setVisible(true);
		
	}

}

