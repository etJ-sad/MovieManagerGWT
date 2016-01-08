package test;
import java.util.List;

import movies.server.MovieManagerServiceImpl;
import movies.web.model.Movie;
import junit.framework.TestCase;


public class TestMovieManagerServiceImpl extends TestCase {
	
	private MovieManagerServiceImpl service;  
	
	@Override  
	protected void setUp() throws Exception {   
		super.setUp();   
		service = new MovieManagerServiceImpl();  
	}  
	 
	@Override  
	protected void tearDown() throws Exception {   
		super.tearDown();   
		service = null;  
	}
	
	public void testLoanAndReturnMovie(){
		//Use service to get all movies
		List<Movie> loanableMovies = service.listLoanableMovies();
		// Vor. Loan : movies are loanable & not loaned;
		for (Movie m: loanableMovies){
			assertTrue(m.isLoanable());
			assertFalse(m.isLoaned());
		}
		
		//Test loan

		for (Movie m: loanableMovies){
			service.loanMovie(m);
		}
		
		// Nachbedingugn Loan : movies are loanable & loaned
		
		for(Movie m: service.listLoanedMovies()){ // loanaedMovie()
			assertTrue(m.isLoanable());
			assertTrue(m.isLoaned());
		}
		
		assertTrue(service.listLoanableMovies().isEmpty());
		
		List<Movie> loanedMovies = service.listLoanedMovies();
		// Vor Return : movies are loanable & loaned
		for (Movie m: loanedMovies){
			assertTrue(m.isLoanable());
			assertTrue(m.isLoaned());
		}
		//Test return;
		for (Movie m : loanedMovies){
			service.returnMovie(m);
		}
		
		for (Movie m: loanedMovies){
			assertTrue(m.isLoanable());
			assertFalse(m.isLoaned());
		}
		
		assertTrue(service.listLoanedMovies().isEmpty());
		
	}
}
