/**
 * @version 4.4.843:RC-2
 */

package de.unihd.movies.client;



import java.util.ArrayList;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;

import de.unihd.movies.client.service.MovieManagerService;
import de.unihd.movies.client.service.MovieManagerServiceAsync;



/**
 * A simple web application showing a list of books.
 * */
public class MovieManager implements EntryPoint { // <- WebApp Startpunkt

	/**
	 * The service to connect to the server side BookService.
	 * */
	private final MovieManagerServiceAsync bookService = GWT.create(MovieManagerService.class);

	@Override
	public void onModuleLoad() { // <- aequivalent zur main() in Java-Programmen

		// Erstellen wir uns eine Liste mit Buechern
		// Das brauchen wir nicht mehr, da wir alle Filme vom Server
		// ArrayList<Book> bookList = new ArrayList<Book>();
		// bookList.add(new Book(1234, "Krieg und Frieden", "Leo Tolstoi"));
		// bookList.add(new Book(4567, "Die Tore der Welt", "Ken Follet"));
		// bookList.add(new Book(6789, "Illuminati", "Dan Brown"));
		// new BookUI(bookList);
		
		// Wir wollen das unsere App die Buecher beim Starten laedt.
		// Dazu verwenden wir den bookService.
		// Zuerst laden wir alle Buecher. Der Operation muss ein Callback
		// zugeordnet werden um die Eintraege zu uebernehmen
		bookService.loadMovies(new AsyncCallback<ArrayList<Movie>>() {

			@Override
			public void onSuccess(ArrayList<Movie> result) {
				// Die Liste result enthaelt alle Buecher, die es auf
				// Serverseite gibt. Daher setzen wir unsere Liste auf die vom
				// Server
				new MovieUI(result);
			}

			@Override
			public void onFailure(Throwable caught) {
				// Hier brauchen wir nichts zu tun!
				GWT.log(caught.getMessage());
			}
		});

	}

}
