
public class Performer {
	private String firstname;
	private String lastname;
	private Gender gender;
	
	private Movie movie;
	private Boolean outstanding=false;
	
	Performer(String getFirstName, String getLastName, Gender getGender){
		this.firstname = getFirstName;   
		this.lastname = getLastName;
		this.gender = getGender;
	}
	
	public String getFirstname() {
		return this.firstname;
	}
	
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return this.lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public Gender getGender() {
		return this.gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	
	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public void setOutstanding(Boolean outstanding) { 
		this.outstanding = outstanding; 
    }

	public boolean isOutstanding() {
		return this.outstanding; 
	}
	
	public String toString(){
		return "Performer >> " + firstname + " " + lastname + " is " +  " " + gender + "\n";
	}
	
}


