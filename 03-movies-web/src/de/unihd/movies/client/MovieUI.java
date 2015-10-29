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

	/**
	 * The main panel which contain all other widgets
	 * */
	private VerticalPanel panel;

	/**
	 * Creates a MovieUI with the given list of movies.
	 * 
	 * @param movies
	 *            The list of movies to show.
	 * */
	  private static final List<Movie> CONTACTS = Arrays.asList(
			  new Movie(1,"John",150,"GER", "HERO", "ME"));
	public static CellTable<Movie> table = new CellTable<Movie>();
	public MovieUI() {
		  MovieUI.table.setKeyboardSelectionPolicy(KeyboardSelectionPolicy.ENABLED);
		    
		    
		    TextColumn<Movie> idColumn = new TextColumn<Movie>() {
			      @Override
			      public String getValue(Movie object) {
			    	  String buffer = String.valueOf(object.getId());
			    	  return buffer;
			      }
			    };
			MovieUI.table.addColumn(idColumn, "id");
		    
			//
		    TextColumn<Movie> nameColumn = new TextColumn<Movie>() {
		      @Override
		      public String getValue(Movie object) {
		        return object.getName();
		      }
		    };
		    table.addColumn(nameColumn, "Name");
		    
		    
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
		    // Set the total row count. This isn't strictly necessary, but it affects
		    // paging calculations, so its good habit to keep the row count up to date.
		    table.setRowCount(CONTACTS.size(), true);
		    // Push the data into the widget.
		    table.setRowData(0, CONTACTS);
		    // Add it to the root panel.
		    RootPanel.get().add(table);
		  }
		
	

	/**
	 * Shows the content of the MovieUI.
	 * */
	public void show() {
		initWidget(panel);
		RootPanel.get("content").add(this);
		this.setVisible(true);
	}

}
