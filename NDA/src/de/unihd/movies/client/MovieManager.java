/**
 * @Version 3.3.8:release
 */


package de.unihd.movies.client;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import com.google.gwt.core.client.EntryPoint;





/**
 * The Class MovieManager.
 */

public class MovieManager  implements EntryPoint {
	
	public final List<String> LANG = Arrays.asList("German", "English", "Spanish", "France", "Russish");
  
	LinkedList<Movie> getList() {
	    LinkedList<Movie> list = new LinkedList<Movie>();
		
				list.add(new Movie (1,	"Star Wars I",	166, "English", "First Film new Trilogy", "space"));
				list.add(new Movie (1,	"Star Wars I",	166, "English", "First Film new Trilogy", "space"));
				list.add(new Movie (3,	"Star Wars III",211, "English", "Three Film new Trilogy", "space"));
				list.add(new Movie (4,	"Star Wars IV",	149, "English", "First Film old Trilogy", "space"));
				list.add(new Movie (5,	"Star Wars V",	154, "English", "Second Film old Trilogy", "space"));
				list.add(new Movie (6,	"Star Wars VI",	171, "English", "Three Film old Trilogy", "space"));  
				
	    return list;
	}
	
	LinkedList<Movie> empty() {
	    LinkedList<Movie> list = new LinkedList<Movie>();
			list.add(new Movie (0,	"",	0, "", "", "")); 
			return list;
	}
		
	public void onModuleLoad() {
			  MovieUI run = new MovieUI();
			  run.createTable();
			  run.setTable();
			  run.addButton();
			  run.delButton();
			  run.show();
		}
}

