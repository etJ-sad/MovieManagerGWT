package movies.web.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Series implements Serializable, Loanable {

	private static final long serialVersionUID = 3286032475894709115L;

	private String title; // Title
	private String studio; // Studio
	private String broadcastedBy; // Station that broadcasts the series
	private Date releaseDate; // Release date
	private List<Season> seasons; // Seasons
	private Rating rating; // Rating
	private List<Performer> performers; // Performers in the series
	private String productionCountry; // Production country
	private boolean loaned; // Flag to indicate whether the series is currently
							// loaned
	private Date loanedUntil; // Date until the series can be lonaed again
	private boolean loanable; // Flag to indicate whether the series is loanable

	/**
	 * Default constructor.
	 */
	public Series() {
		title = "";
		studio = "";
		broadcastedBy = "";
		releaseDate = new Date();
		seasons = new ArrayList<Season>();
		rating = Rating.Zero;
		performers = new ArrayList<Performer>();
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

	public String getStudio() {
		return studio;
	}

	public void setStudio(String studio) {
		this.studio = studio;
	}

	public String getBroadcastedBy() {
		return broadcastedBy;
	}

	public void setBroadcastedBy(String broadcastedBy) {
		this.broadcastedBy = broadcastedBy;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public Rating getRating() {
		return rating;
	}

	public void setRating(Rating rating) {
		this.rating = rating;
	}

	public String getProductionCountry() {
		return productionCountry;
	}

	public void setProductionCountry(String productionCountry) {
		this.productionCountry = productionCountry;
	}

	public List<Season> getSeasons() {
		return seasons;
	}

	/**
	 * Adds the season to this series.
	 * 
	 * @param season
	 *            the season
	 * @return true if the season was added, false if the season is already part
	 *         of this series
	 */
	public boolean addSeason(Season season) {
		if (seasons.contains(season)) {
			return false;
		}
		seasons.add(season);
		return true;
	}

	public List<Performer> getPerformers() {
		return performers;
	}

	/**
	 * Adds the performer to this series.
	 * 
	 * @param performer
	 *            the performer
	 * @return true if the performer was added, false if the performer is
	 *         already part of this series
	 */
	public boolean addPerformer(Performer performer) {
		if (performers.contains(performer)) {
			return false;
		}
		performers.add(performer);
		return true;
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
