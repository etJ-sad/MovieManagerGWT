/**
 * @Version 3.3.8:release
 */


package de.unihd.movies.client;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;

import com.google.gwt.user.client.rpc.AsyncCallback;


import de.unihd.movies.client.service.MovieManagerService;
import de.unihd.movies.client.service.MovieManagerServiceAsync;


/**
 * The Class MovieManager.
 */

public class MovieManager  implements EntryPoint {
	
	private final MovieManagerServiceAsync movieService = GWT.create(MovieManagerService.class);


	
	LinkedList<Movie> getList() {
	    LinkedList<Movie> list = new LinkedList<Movie>();		
	    list.add(new Movie (1,	"Star Wars I",	-410, "English", "First Film new Trilogy", "space"));
	    list.add(new Movie (2,	"Star Wars I",	166, "English", "First Film new Trilogy", "space"));
	    list.add(new Movie (3,	"Star Wars III",211, "English", "Three Film new Trilogy", "space"));
	    list.add(new Movie (4,	"Star Wars IV",	149, "English", "First Film old Trilogy", "space"));
	    list.add(new Movie (5,	"Star Wars V",	154, "English", "Second Film old Trilogy", "space"));
	    list.add(new Movie (6,	"Star Wars VI",	171, "English", "Three Film old Trilogy", "space"));  
				
	    return list;
	}
		
	//
	public final List<String> LANG = Arrays.asList("German", "English", "Spanish", "France", "Russish");
  	
	//
	LinkedList<Movie> empty() {
	    LinkedList<Movie> list = new LinkedList<Movie>();
			list.add(new Movie (0,	"",	-1, "", "", "")); 
			return list;
	}
		
	
	
	public void onModuleLoad() {
		final MovieUI runModule = new MovieUI();
		runModule.setupColumn(getList());
		runModule.createTable();
		runModule.addButton();
		runModule.delButton();
		runModule.addTextBox();
		runModule.show();
		
		movieService.loadMovies(new AsyncCallback<LinkedList<Movie>>() {

			@Override
			public void onSuccess(LinkedList<Movie> result) {
				runModule.setupColumn(result);
			}

			@Override
			public void onFailure(Throwable caught) {
				GWT.log(caught.getMessage());
			}
		});

	}
}

