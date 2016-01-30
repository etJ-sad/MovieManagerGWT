
public class Director extends Performer {
	

	private  int movieCounter;

	public int getMovieCount() {
		return this.movieCounter;
	}

	public void setMovieCount(int movieCount) {
		this.movieCounter = movieCount;
	}

	public Director(String getFirstname, String getLastname, 
			Gender getGender, int getMovieCounter) {
		
		super(getFirstname, getLastname, getGender);
		this.movieCounter = getMovieCounter;
	}

}
