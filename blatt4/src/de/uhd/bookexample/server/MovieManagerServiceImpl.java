package de.uhd.bookexample.server;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import de.uhd.bookexample.client.Movie;
import de.uhd.bookexample.client.service.MovieManagerService;

/**
 * Server-side implementation of the {@link MovieManagerService}.
 * 
 * @author Marcus Seiler
 * */
public class MovieManagerServiceImpl extends RemoteServiceServlet implements
		MovieManagerService {

	/**
	 * Unique ID
	 */
	private static final long serialVersionUID = 2610052049222392123L;
	
	/**
	 * The filename to store the books.
	 * */
	private String fileName = "books.ser";

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<Movie> loadMovies() {
		ArrayList<Movie> books = new ArrayList<Movie>();
		try {
			FileInputStream fileIn = new FileInputStream(fileName);
			ObjectInputStream in = new ObjectInputStream(fileIn);
			books = (ArrayList<Movie>) in.readObject();
			in.close();
			fileIn.close();
		} catch (FileNotFoundException e) {
			// if no file is found, create empty ArrayList
			books = new ArrayList<Movie>();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return books;
	}

	@Override
	public void saveMovies(ArrayList<Movie> books) {
		try {
			FileOutputStream fileOut = new FileOutputStream(fileName);
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(books);
			out.close();
			fileOut.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
