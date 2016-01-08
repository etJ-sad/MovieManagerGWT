/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package movies.tests;

import junit.framework.TestCase;

import junit.textui.TestRunner;

import movies.MovieCollection;
import movies.MoviesFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Movie Collection</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following operations are tested:
 * <ul>
 *   <li>{@link movies.MovieCollection#hasMovies(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Has Movies</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public class MovieCollectionTest extends TestCase {

	/**
	 * The fixture for this Movie Collection test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MovieCollection fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(MovieCollectionTest.class);
	}

	/**
	 * Constructs a new Movie Collection test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MovieCollectionTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Movie Collection test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(MovieCollection fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Movie Collection test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MovieCollection getFixture() {
		return fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(MoviesFactory.eINSTANCE.createMovieCollection());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#tearDown()
	 * @generated
	 */
	@Override
	protected void tearDown() throws Exception {
		setFixture(null);
	}

	/**
	 * Tests the '{@link movies.MovieCollection#hasMovies(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Has Movies</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see movies.MovieCollection#hasMovies(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	public void testHasMovies__DiagnosticChain_Map() {
		// TODO: implement this operation test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

} //MovieCollectionTest
