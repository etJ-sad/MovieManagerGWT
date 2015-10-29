package de.unihd.movies.client;

import java.util.Comparator;
import java.util.List;

import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.ColumnSortEvent.ListHandler;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.cellview.client.HasKeyboardSelectionPolicy.KeyboardSelectionPolicy;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.view.client.ListDataProvider;

public class MovieUI extends Composite {

	MovieManager manager = new MovieManager();
	
	private VerticalPanel panel;
	
	public static CellTable<Movie> table = new CellTable<Movie>();
	
	public MovieUI() {
		  MovieUI.table.setKeyboardSelectionPolicy(KeyboardSelectionPolicy.ENABLED);
		  ListDataProvider<Movie> dataProvider = new ListDataProvider<Movie>();
		    
		   //id 
		    TextColumn<Movie> idColumn = new TextColumn<Movie>() {
			      @Override
			      public String getValue(Movie object) {
			    	  String buffer = String.valueOf(object.getId());
			    	  return buffer;
			      }
			    }; table.addColumn(idColumn, "id");
		    
			//Name
		    TextColumn<Movie> nameColumn = new TextColumn<Movie>() {
		      @Override
		      public String getValue(Movie object) {
		        return object.getName();
		      }
		       }; table.addColumn(nameColumn, "Name");
		    
		    //Time
		    TextColumn<Movie> timeColumn = new TextColumn<Movie>() {
			      @Override
			      public String getValue(Movie object) {
			    	  String buffer = String.valueOf(object.getTime());
			    	  return buffer;
			      }
			    }; table.addColumn(timeColumn, "Time");
			
			//Language
		    TextColumn<Movie> languageColumn = new TextColumn<Movie>() {
			      @Override
			      public String getValue(Movie object) {
			        return object.getLanguage();
			      }
			    }; table.addColumn(languageColumn, "Language");
			
			//Description
		    TextColumn<Movie> DescriptionColumn = new TextColumn<Movie>() {
			      @Override
			      public String getValue(Movie object) {
			        return object.getDescription();
			      }
			    }; table.addColumn(DescriptionColumn, "Description");
		    
		    
		    //Place
		    TextColumn<Movie> placeColumn = new TextColumn<Movie>() {
		      @Override
		      public String getValue(Movie object) {
		        return object.getPlace();
		      }
		    }; table.addColumn(placeColumn, "Place");
			
		    
		    
		    nameColumn.setSortable(true);
		    
		    //dataProvider
		    List<Movie> list = dataProvider.getList();
		    for (Movie contact : manager.CONTACTS) {
		      list.add(contact);
		    }

		    //Handler
		    ListHandler<Movie> columnSortHandler = new ListHandler<Movie>(list);
		    columnSortHandler.setComparator(idColumn,
		            new Comparator<Movie>() {
		              public int compare(Movie t1, Movie t2) {
		            	  final String BUFFER_T1 = String.valueOf(t1.getId());
		            	  final String BUFFER_T2 = String.valueOf(t2.getId()); 
		                return BUFFER_T1.compareTo(BUFFER_T2);
		              }
		            });
		
		    // add
		    table.addColumnSortHandler(columnSortHandler);
		    table.getColumnSortList().push(idColumn);
		    table.setRowCount(manager.CONTACTS.size(), true);
		    table.setRowData(0, manager.CONTACTS);
		    RootPanel.get().add(table);
		    }
		
	
	public void show() {
		initWidget(panel);
		RootPanel.get("content").add(this);
		this.setVisible(true);
		
	}

}
