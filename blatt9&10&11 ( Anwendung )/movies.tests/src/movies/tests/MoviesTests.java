/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package movies.tests;

import junit.framework.Test;
import junit.framework.TestSuite;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test suite for the '<em><b>movies</b></em>' package.
 * <!-- end-user-doc -->
 * @generated
 */
public class MoviesTests extends TestSuite {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(suite());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Test suite() {
		TestSuite suite = new MoviesTests("movies Tests");
		suite.addTestSuite(MovieTest.class);
		suite.addTestSuite(MovieCollectionTest.class);
		suite.addTestSuite(PerformerTest.class);
		suite.addTestSuite(EpisodeTest.class);
		suite.addTestSuite(DirectorTest.class);
		return suite;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MoviesTests(String name) {
		super(name);
	}

} //MoviesTests
