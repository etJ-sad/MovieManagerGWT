package de.unihd.movies.client;

import java.util.Arrays;
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

	private VerticalPanel panel;
	
	private static final List<Movie> CONTACTS = Arrays.asList(
			  new Movie (1,	"Star Wars I",	166, "English", "First Film new Trilogy", "space"),
			  new Movie (2,	"Star Wars II",	198, "English", "Second Film new Trilogy", "space"),
			  new Movie (3,	"Star Wars III",211, "English", "Three Film new Trilogy", "space"),
			  new Movie (4,	"Star Wars IV",	149, "English", "First Film old Trilogy", "space"),
			  new Movie (5,	"Star Wars V",	154, "English", "Second Film old Trilogy", "space"),
			  new Movie (6,	"Star Wars VI",	171, "English", "Three Film old Trilogy", "space"));
	
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
			    };
			table.addColumn(idColumn, "id");
			idColumn.setSortable(true);

		    
			//Name
		    TextColumn<Movie> nameColumn = new TextColumn<Movie>() {
		      @Override
		      public String getValue(Movie object) {
		        return object.getName();
		      }
		    };
		    table.addColumn(nameColumn, "Name");
		    
		    //Time
		    TextColumn<Movie> timeColumn = new TextColumn<Movie>() {
			      @Override
			      public String getValue(Movie object) {
			    	  String buffer = String.valueOf(object.getTime());
			    	  return buffer;
			      }
			    };
			table.addColumn(timeColumn, "Time");
			
			//Language
		    TextColumn<Movie> languageColumn = new TextColumn<Movie>() {
			      @Override
			      public String getValue(Movie object) {
			        return object.getLanguage();
			      }
			    };
			table.addColumn(languageColumn, "Language");
			
			//Description
		    TextColumn<Movie> DescriptionColumn = new TextColumn<Movie>() {
			      @Override
			      public String getValue(Movie object) {
			        return object.getDescription();
			      }
			    };
			table.addColumn(DescriptionColumn, "Description");
		    
		    
		    //Place
		    TextColumn<Movie> placeColumn = new TextColumn<Movie>() {
		      @Override
		      public String getValue(Movie object) {
		        return object.getPlace();
		      }
		    };
		    table.addColumn(placeColumn, "Place");
		

		    
			//dataProvider
		    List<Movie> list = dataProvider.getList();
		    for (Movie contact : CONTACTS) {
		      list.add(contact);
		    }

		    ListHandler<Movie> columnSortHandler = new ListHandler<Movie>(list);
		    columnSortHandler.setComparator(idColumn, new Comparator<Movie>() {
		          public int compare(Movie o1, Movie o2) {
		            if (o1 == o2) {
		              return 0;
		            }
		            if (o1 != null) {
		            	String buffer_o1 = String.valueOf(o1.getId());
		            	String buffer_o2 = String.valueOf(o2.getId());
		            	
		              return (o2 != null) ? buffer_o1.compareTo(buffer_o2) : 1;
		            }
		            return -1;
		          }


		        });
		
		    table.addColumnSortHandler(columnSortHandler);
		    table.getColumnSortList().push(idColumn);
		    table.setRowCount(CONTACTS.size(), true);
		    table.setRowData(0, CONTACTS);
		    RootPanel.get().add(table);
		    }
		
	
	public void show() {
		initWidget(panel);
		RootPanel.get("content").add(this);
		this.setVisible(true);
		
	}

}
