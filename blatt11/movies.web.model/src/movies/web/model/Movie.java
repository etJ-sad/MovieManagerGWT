package movies.web.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Movie implements Serializable, Loanable {

	private static final long serialVersionUID = -4870022747763429379L;

	private String title; // Localized title
	private String title_orig; // Original title
	private int time; // Runtime
	private MovieCategory category; // Category
	private Rating rating; // Rating
	private int overallRating; // Overall rating
	private Date lastWatchDate; // Last watch date
	private boolean loaned; // Flag to indicate whether the movie is currently
							// loaned
	private List<Performer> performers; // Performers in this movie
	private String imdbUrl; // Internet Movie Database URL
	private String ofdbID; // Online-Filmdatenbank ID
	private Date loanedUntil; // Date until the movie can be lonaed again
	private boolean loanable; // Flag to indicate whether the movie is loanable

	/**
	 * Default constructor.
	 */
	public Movie() {
		title = "";
		title_orig = "";
		time = 0;
		category = MovieCategory.Action;
		rating = Rating.Zero;
		overallRating = 0;
		lastWatchDate = new Date();
		loaned = false;
		performers = new ArrayList<Performer>();
		imdbUrl = "";
		ofdbID = "";
		loanedUntil = null;
		loanable = true;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle_orig() {
		return title_orig;
	}

	public void setTitle_orig(String title_orig) {
		this.title_orig = title_orig;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public MovieCategory getCategory() {
		return category;
	}

	public void setCategory(MovieCategory category) {
		this.category = category;
	}

	public Rating getRating() {
		return rating;
	}

	public void setRating(Rating rating) {
		this.rating = rating;
	}

	public int getOverallRating() {
		return overallRating;
	}

	public void setOverallRating(int overallRating) {
		this.overallRating = overallRating;
	}

	public Date getLastWatchDate() {
		return lastWatchDate;
	}

	public void setLastWatchDate(Date lastWatchDate) {
		this.lastWatchDate = lastWatchDate;
	}

	public boolean isLoaned() {
		return loaned;
	}

	public void setLoaned(boolean loaned) {
		this.loaned = loaned;
	}

	public String getImdbUrl() {
		return imdbUrl;
	}

	public void setImdbUrl(String imdbUrl) {
		this.imdbUrl = imdbUrl;
	}

	public String getOfdbID() {
		return ofdbID;
	}

	public void setOfdbID(String ofdbID) {
		this.ofdbID = ofdbID;
	}

	public List<Performer> getPerformers() {
		return performers;
	}

	/**
	 * Adds the performer to the list of performers.
	 * 
	 * @param performer
	 *            the performer
	 * @return true if the performer was added, false if the performer is
	 *         already part of the list
	 */
	public boolean addPerformer(Performer performer) {
		if (performers.contains(performer)) {
			return false;
		}
		performers.add(performer);
		return true;
	}

	public Date getLoanedUntil() {
		return loanedUntil;
	}

	public void setLoanedUntil(Date loanedUntil) {
		this.loanedUntil = loanedUntil;
	}

	public boolean isLoanable() {
		return loanable;
	}

	public void setLoanable(boolean loanable) {
		this.loanable = loanable;
	}

	/**
	 * Calculates the overall rating for this movie by adding the movie's rating
	 * and the highest rating of its performers.
	 * 
	 * @return the overall rating
	 */
	public int overallRating() {
		int maxRatingPerformers = Rating.Zero.ordinal();
		for (Performer p : performers) {
			if (p.getRating().ordinal() > maxRatingPerformers) {
				maxRatingPerformers = p.getRating().ordinal();
			}
		}
		return rating.ordinal() + maxRatingPerformers;
	}

	/**
	 * Calculates the overall rating for the given movie by adding the movie's
	 * rating and the highest rating of its performers.
	 * 
	 * @param m
	 *            the movie
	 * @return the overall rating
	 */
	public int overallRating(Movie m) {
		int maxRatingPerformers = Rating.Zero.ordinal();
		for (Performer p : m.getPerformers()) {
			if (p.getRating().ordinal() > maxRatingPerformers) {
				maxRatingPerformers = p.getRating().ordinal();
			}
		}
		return m.getRating().ordinal() + maxRatingPerformers;
	}

	/**
	 * Returns the overall rating. The overall rating is calculated as:
	 * ratingMovie + max of ratingPerformers. The input parameter 'ratingMovie'
	 * needs to be between 0 and 5. All elements in the list 'ratingPerformers'
	 * needs to be between 0 and 5. The overall rating is between 0 and 10.
	 * 
	 * @param ratingMovie
	 *            - A single rating of a movie
	 * @param ratingPerformers
	 *            - A list of ratings of performers
	 * @return overallRating between 0 and 10. -1 if any input parameter is out
	 *         of range
	 */
	public Integer overallRating(Integer ratingMovie,
			List<Integer> ratingPerformers) {
		// The maximum that is found by the algorithm
		Integer maxRatingPerformer = 0;
		// Check if parameters are not null
		if (ratingMovie == null || ratingPerformers == null) {
			return -1;
		}
		// Check range of ratingMovie
		if (ratingMovie < 0 || ratingMovie > 5) {
			return -1;
		}
		int i;
		for (i = 0; i < ratingPerformers.size(); i++) {
			// Check range of each element of the list of ratingPerformers
			if (ratingPerformers.get(i) < 0 || ratingPerformers.get(i) > 5) {
				return -1;
			}
			// Assign maximum if found
			if (ratingPerformers.get(i) > maxRatingPerformer) {
				maxRatingPerformer = ratingPerformers.get(i);
			}
		}
		if (i > ratingPerformers.size()) {
			return -2;
		}
		return ratingMovie + maxRatingPerformer;
	}

}
