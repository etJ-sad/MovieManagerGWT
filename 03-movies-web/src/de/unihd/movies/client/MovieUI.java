package de.unihd.movies.client;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.cellview.client.HasKeyboardSelectionPolicy.KeyboardSelectionPolicy;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SingleSelectionModel;

/**
 * MovieUI that contains a table of movies.
 * */
public class MovieUI extends Composite {

	private VerticalPanel panel;
	private static final List<Movie> CONTACTS = Arrays.asList(
			  new Movie(1,"John",150,"GER", "HERO", "ME"));
	
	public static CellTable<Movie> table = new CellTable<Movie>();
	
	public MovieUI() {
		  MovieUI.table.setKeyboardSelectionPolicy(KeyboardSelectionPolicy.ENABLED);
		    
		   //id 
		    TextColumn<Movie> idColumn = new TextColumn<Movie>() {
			      @Override
			      public String getValue(Movie object) {
			    	  String buffer = String.valueOf(object.getId());
			    	  return buffer;
			      }
			    };
			MovieUI.table.addColumn(idColumn, "id");
		    
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
			MovieUI.table.addColumn(timeColumn, "Time");
		    
		    
		    //
		    TextColumn<Movie> addressColumn = new TextColumn<Movie>() {
		      @Override
		      public String getValue(Movie object) {
		        return object.getPlace();
		      }
		    };
		    table.addColumn(addressColumn, "adress");
		

		 		    
		    
		    // Add a selection model to handle user selection.
			    
		    final SingleSelectionModel<Movie> selectionModel = new SingleSelectionModel<Movie>();
		    table.setSelectionModel(selectionModel);
		    
		    
		    selectionModel.addSelectionChangeHandler(new SelectionChangeEvent.Handler() {
		      public void onSelectionChange(SelectionChangeEvent event) {
		        Movie selected = selectionModel.getSelectedObject();
		        if (selected != null) {
		          Window.alert("You selected: " + selected.getName());
		        }
		      }
		    });
		    table.setRowCount(CONTACTS.size(), true);
		    // Push the data into the widget.
		    table.setRowData(0, CONTACTS);
		    // Add it to the root panel.
		    RootPanel.get().add(table);
		    }
		
	
	public void show() {
		initWidget(panel);
		RootPanel.get("content").add(this);
		this.setVisible(true);
		
	}

}
