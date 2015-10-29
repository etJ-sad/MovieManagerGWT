package de.unihd.movies.client;

import java.util.Arrays;
import java.util.List;
import com.google.gwt.core.client.EntryPoint;



/**
 * The Class MovieManager.
 */

public class MovieManager  implements EntryPoint {
		  
	public final List<Movie> CONTACTS = Arrays.asList(
			  new Movie (1,	"Star Wars I",	166, "English", "First Film new Trilogy", "space"),
			  new Movie (2,	"Star Wars II",	198, "English", "Second Film new Trilogy", "space"),
			  new Movie (3,	"Star Wars III",211, "English", "Three Film new Trilogy", "space"),
			  new Movie (4,	"Star Wars IV",	149, "English", "First Film old Trilogy", "space"),
			  new Movie (5,	"Star Wars V",	154, "English", "Second Film old Trilogy", "space"),
			  new Movie (6,	"Star Wars VI",	171, "English", "Three Film old Trilogy", "space"));  
	
	public MovieManager() {
	}
	
	public void onModuleLoad() {
			  MovieUI run = new MovieUI();
			  run.show();
		}
}

