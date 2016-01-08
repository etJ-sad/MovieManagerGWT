package movies.web.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Performer implements Serializable {

	private static final long serialVersionUID = -738342195055027264L;

	private String name; // Name
	private Gender gender; // Gender
	private Rating rating; // Rating
	private List<Movie> movies; // Movies the performer acted in
	private String ofdbID; // Online-Filmdatenbank ID

	/**
	 * Default constructor.
	 */
	public Performer() {
		name = "";
		gender = Gender.Male;
		rating = Rating.Zero;
		movies = new ArrayList<Movie>();
		ofdbID = "";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Rating getRating() {
		return rating;
	}

	public void setRating(Rating rating) {
		this.rating = rating;
	}

	public String getOfdbID() {
		return ofdbID;
	}

	public void setOfdbID(String ofdbID) {
		this.ofdbID = ofdbID;
	}

	public List<Movie> getMovies() {
		return movies;
	}

	/**
	 * Adds the movie to the list of movies.
	 * 
	 * @param m
	 *            the move
	 * @return true if the movie was added, false if the movie is already part
	 *         of the list
	 */
	public boolean addMovie(Movie m) {
		if (movies.contains(m)) {
			return false;
		}
		movies.add(m);
		return true;
	}
}
