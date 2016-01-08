package movies.test;

import movies.MoviesFactory;
import movies.Series;
import junit.framework.TestCase;

public class UnMarkSeriesLoanable extends TestCase {
	
	private Series series;
	
	public void testSerieLoanableNotLoaned(){
//!		Test Phase 1 = void:
		series.setLoanable(false);
		series.setLoaned(false);	
		// Test mark 1
		series.setLoanable(true);		
		// Ers for 1:
		assertTrue(series.isLoanable());
		assertFalse(series.isLoaned());
					
		//

//!		Test Phase 2 = Ers1
		series.setLoanable(true);
		series.setLoaned(false);
		// Test mark 2
		series.setLoanable(true);
		//Ers 2 == same Ers 1
		assertTrue(series.isLoanable());
		assertFalse(series.isLoaned());
				
		//
				
//!		Test Phase 3 = Ers2
		series.setLoanable(true);
		series.setLoaned(false);
		// Test unMark 1
		series.setLoanable(false);
				
		//Ers 3
		assertFalse(series.isLoanable());
		assertFalse(series.isLoaned());

		//
				
//!		Test Phase 4 = Ers3
		series.setLoanable(false);
		series.setLoaned(false);
		// Test unMark 2
		series.setLoanable(false);
		// Ers4
		assertFalse(series.isLoanable());
		assertFalse(series.isLoaned());
	}
			
	public void testSerieLoanableLoaned(){

//!		Test Phase 1 = void
		series.setLoanable(false);
		series.setLoaned(true);
		// test mark 1
		series.setLoanable(true);
		//Ers 1
		assertTrue(series.isLoanable());
		assertTrue(series.isLoaned());
				
//!		Test Phase 2 = Ers1
				
		series.setLoanable(true);
		series.setLoaned(true);
		//Test unMark
		try {
			series.setLoanable(false);
			fail("Expected exception");
		}catch (RuntimeException e){
				assertEquals(e.getMessage().toString(), "Error : serie is loaned.");
		}
		//Ers 2
		assertTrue(series.isLoanable());
		assertTrue(series.isLoaned());
				
				
	}	
	
	public void testAllPartSerieLoanableLoaned(){

//!		Test Phase 1 = void
		series.setLoanable(false);
		series.setLoaned(false);
		series.setAllpartsloanable(false);
		// test mark 1
		series.setAllpartsloanable(true);
		//Ers 1
		assertTrue(series.isAllpartsloanable());
						
//!		Test Phase 2 = Ers1
						
		series.setLoanable(true);
		series.setLoaned(true);
		series.setAllpartsloanable(true);
		//Test unMark
		try {
			series.setAllpartsloanable(false);
			fail("Expected exception");
		}catch (RuntimeException e){
			assertEquals(e.getMessage().toString(), "Error : All series is loaned.");
		}
		//Ers 2
		assertTrue(series.isLoanable());
		assertTrue(series.isLoaned());					
	}	
	
	@Override
	protected void setUp() throws Exception {   
		 series = MoviesFactory.eINSTANCE.createSeries();  
	}
	
	@Override
	protected void tearDown() throws Exception {   
		series = null;  
	} 	 
}
