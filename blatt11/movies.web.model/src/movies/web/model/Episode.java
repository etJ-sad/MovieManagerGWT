package movies.web.model;

public class Episode extends Movie {

	private static final long serialVersionUID = 2695308101036739779L;

	private String broadcastedBy; // Station that broadcasts the episode
	private String productionCountry; // Production country
	private Season season; // Season the episode is part of

	/**
	 * Default constructor.
	 */
	public Episode() {
		super();
		broadcastedBy = "";
		productionCountry = "";
		season = new Season();
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

	public Season getSeason() {
		return season;
	}

	public void setSeason(Season season) {
		this.season = season;
	}
}
