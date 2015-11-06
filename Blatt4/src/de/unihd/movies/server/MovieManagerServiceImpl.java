package de.unihd.movies.server;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import de.unihd.movies.client.Movie;
import de.unihd.movies.client.service.MovieManagerService;

/**
 * Server-side implementation of the {@link MovieManagerService}.
 * 
 * @author Marcus Seiler
 * */
public class MovieManagerServiceImpl extends RemoteServiceServlet implements
		MovieManagerService {

	/**
	 * Unique ID
	 * */
	private static final long serialVersionUID = -5459930379153769747L;

	/**
	 * The filename to store the movies.
	 * */
	private String fileName = "movies.ser";

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<Movie> loadMovies() {
		ArrayList<Movie> movies = new ArrayList<Movie>();
		try {
			FileInputStream fileIn = new FileInputStream(fileName);
			ObjectInputStream in = new ObjectInputStream(fileIn);
			movies = (ArrayList<Movie>) in.readObject();
			in.close();
			fileIn.close();
		} catch (FileNotFoundException e) {
			// if no file is found, create empty ArrayList
			movies = new ArrayList<Movie>();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return movies;
	}

	@Override
	public void saveMovies(ArrayList<Movie> movies) {
		try {
			FileOutputStream fileOut = new FileOutputStream(fileName);
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(movies);
			out.close();
			fileOut.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
