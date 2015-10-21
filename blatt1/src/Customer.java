
import java.util.List;
import java.util.LinkedList;

public class Customer {
	public String name;
	List<Movie> loanedMovies;

	public boolean loanMovie(Movie movie) {
		if(loanedMovies.size() < 5) {		
			if (movie.getLoaningCustomer() == null) {
				loanedMovies.add(movie);
				movie.setLoaningCustomer(this);
				return true;
			}
			else {
				System.out.println("Film ist schon an KundIn " + movie.getLoaningCustomer() + " verliehen");
				return false;

			}
		}
		else { 
			System.out.println("Kunde " + this + " hat schon 5 Filme ausgeliehen");
			return false;
		}
	}


	public String toString() {
		return this.name;
	}

	public Customer(String name) {
		this.name=name;
		this.loanedMovies=new LinkedList<Movie>();
	}
	
	public static void main(String args[])
	{
		Customer kunde1=new Customer("mox");
		Customer kunde2=new Customer("andrii");
		

		Movie film1=new Movie("Film1", 1);
		Movie film2=new Movie("Film1", 2);
		Movie film3=new Movie("Film1", 3);
		Movie film4=new Movie("Film1", 4);
		Movie film5=new Movie("Film1", 5);
		Movie film6=new Movie("Film1", 6);
		Movie film7=new Movie("Film1", 7);


		

		kunde1.loanMovie(film1);
		kunde2.loanMovie(film1);
		
		kunde2.loanMovie(film2);
		kunde2.loanMovie(film3);
		kunde2.loanMovie(film4);
		kunde2.loanMovie(film5);
		kunde2.loanMovie(film6);
		kunde2.loanMovie(film7);

	}
	
}
