package movies.web.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Season implements Serializable, Loanable {

	private static final long serialVersionUID = -3773967961179885868L;

	private String title; // Title
	private Date releaseDate; // Release date
	private List<Episode> episodes; // Episodes
	private Series series; // Series the season is part of
	private Rating rating; // Rating
	private List<Performer> performers; // Performers in the season
	private String broadcastedBy; // Station that broadcasts the season
	private String productionCountry; // Production country
	private boolean loaned; // Flag to indicate whether the season is currently
							// loaned
	private Date loanedUntil; // Date until the season can be lonaed again
	private boolean loanable; // Flag to indicate whether the season is loanable

	/**
	 * Default constructor.
	 */
	public Season() {
		title = "";
		releaseDate = new Date();
		episodes = new ArrayList<Episode>();
		series = new Series();
		rating = Rating.Zero;
		performers = new ArrayList<Performer>();
		broadcastedBy = "";
		productionCountry = "";
		loaned = false;
		loanedUntil = null;
		loanable = true;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public List<Episode> getEpisodes() {
		return episodes;
	}

	/**
	 * Adds the episode to this series.
	 * 
	 * @param episode
	 *            the episode
	 * @return true if the episode was added, false if the episode is already
	 *         part of this season
	 */
	public boolean addEpisode(Episode episode) {
		if (episodes.contains(episode)) {
			return false;
		}
		episodes.add(episode);
		return true;
	}

	public Series getSeries() {
		return series;
	}

	public void setSeries(Series series) {
		this.series = series;
	}

	public Rating getRating() {
		return rating;
	}

	public void setRating(Rating rating) {
		this.rating = rating;
	}

	public List<Performer> getPerformers() {
		return performers;
	}

	/**
	 * Adds the performer to this season.
	 * 
	 * @param performer
	 *            the performer
	 * @return true if the performer was added, false if the performer is
	 *         already part of this season
	 */
	public boolean addPerformer(Performer performer) {
		if (performers.contains(performer)) {
			return false;
		}
		performers.add(performer);
		return true;
	}

	public String getBroadcastedBy() {
		return broadcastedBy;
	}

	public void setBroadcastedBy(String broadcastedBy) {
		this.broadcastedBy = broadcastedBy;
	}

	public String getProductionCountry() {
		return productionCountry;
	}

	public void setProductionCountry(String productionCountry) {
		this.productionCountry = productionCountry;
	}

	public boolean isLoaned() {
		return loaned;
	}

	public void setLoaned(boolean loaned) {
		this.loaned = loaned;
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

}
