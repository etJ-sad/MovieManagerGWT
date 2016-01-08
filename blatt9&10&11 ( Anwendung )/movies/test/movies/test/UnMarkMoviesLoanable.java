package movies.test;

import org.junit.Test;

import movies.Movie;
import movies.MoviesFactory;
import junit.framework.TestCase;

public class UnMarkMoviesLoanable extends TestCase{
	
	private Movie movie;
	
	
	@Test(expected=Exception.class) 
	public void testMovieLoanableNotLoaned(){
//!		Test Phase 1 = void:
		movie.setLoanable(false);
		movie.setLoaned(false);	
		// Test mark 1
		movie.setLoanable(true);		
		// Ers for 1:
		assertTrue(movie.isLoanable());
		assertFalse(movie.isLoaned());
			
		//

//!		Test Phase 2 = Ers1
		movie.setLoanable(true);
		movie.setLoaned(false);
		// Test mark 2
		movie.setLoanable(true);
		//Ers 2 == same Ers 1
		assertTrue(movie.isLoanable());
		assertFalse(movie.isLoaned());
		
		//
		
//!		Test Phase 3 = Ers2
		movie.setLoanable(true);
		movie.setLoaned(false);
		// Test unMark 1
		movie.setLoanable(false);
		
		//Ers 3
		assertFalse(movie.isLoanable());
		assertFalse(movie.isLoaned());

		//
		
//!		Test Phase 4 = Ers3
		movie.setLoanable(false);
		movie.setLoaned(false);
		// Test unMark 2
		movie.setLoanable(false);
		// Ers4
		assertFalse(movie.isLoanable());
		assertFalse(movie.isLoaned());
	}
	
	@Test(expected=Exception.class)
	public void testMovieLoanableLoaned(){

//!		Test Phase 1 = void
		movie.setLoanable(false);
		movie.setLoaned(true);
		// test mark 1
		movie.setLoanable(true);
		//Ers 1
		assertTrue(movie.isLoanable());
		assertTrue(movie.isLoaned());
		
//!		Test Phase 2 = Ers1
		
		movie.setLoanable(true);
		movie.setLoaned(true);
		//Test unMark
		try {
			movie.setLoanable(false);
			fail("Expected exception");
			
		}catch (RuntimeException e){
			assertEquals(e.getMessage().toString(), "Error : movie is loaned.");
		}
		//Ers 2
		assertTrue(movie.isLoanable());
		assertTrue(movie.isLoaned());
		
		
	}
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		movie = MoviesFactory.eINSTANCE.createMovie();
	}
	
	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
		movie = null;
	}
}
