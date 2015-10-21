/*
 * Soloninov Aleksandr, ESW WS 15|16
 * 
 * Blatt 1, Aufgabe 1.3
 * 
 */

public class Movie {
	//private stack
	private String title;
	private int time;
	private int number = 0;
	private Director director;
	private Customer customer;

	//public stack
	public static int nextNumber = 0;
	

	public static int getNextNumber() {
		return nextNumber;
	}

	public static void setNextNumber(int nextNumber) {
		Movie.nextNumber = nextNumber;
	}

	Movie(String getTitle, int getTime) { 
		
		this.time = getTime; 
		this.title = getTitle;
		this.number = nextNumber++;
		}
	
	Movie(String getTitle, int getTime, Director getDirector) { 	
		this.time = getTime; 
		this.title = getTitle;
		this.number = nextNumber++;
		this.director = getDirector;
	}	
	
	public String toString() {
		return this.title + " is over " + this.time + " minutes long.";
	}
	
	public String getTitle() {
		return title;
	} // end getTitle()
	
	public void setTitle(String title) {
		this.title = title;  //
	} // end setTitle(String title)
	
	public int getTime() {
		return time;
	} // end getTime()
	
	public void setTime(int time) {
		this.time = time;
	}
	
	public Director getDirector() {
		return this.director;
	}

	public void setDirector(Director director) {
		this.director = director;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public Customer getLoaningCustomer() {
		return customer;
	}

	public void setLoaningCustomer(Customer getCustomer) {
		this.customer = getCustomer;
	}

	public void showInformation() {
		System.out.println("Title : " + this.title + "\n" + "time : " + this.time + "\n" 
				+ "Number : " + number +"\n" + "nextNumber : " + Movie.nextNumber + "\n" );
	}
	
	
	public static void main(String args[]) {
	
		Director Alex = new Director("Alex", "Solo", Gender.MALE, nextNumber);
		
		Movie zero;
		zero = new Movie("zero", 0, Alex);
		zero.showInformation();
		
		Movie one = new Movie("one",1, Alex);
		one.showInformation();

		
		System.out.println(Alex.getFirstname());
		System.out.println(Alex.getGender());
		Alex.setMovieCount(nextNumber);
		System.out.println(Alex.getMovieCount());
		
	} // end Main
}

