/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package movies.tests;

import junit.framework.TestCase;

import junit.textui.TestRunner;

import movies.MoviesFactory;
import movies.Series;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Series</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class SeriesTest extends TestCase {

	/**
	 * The fixture for this Series test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Series fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(SeriesTest.class);
	}

	/**
	 * Constructs a new Series test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SeriesTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Series test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(Series fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Series test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Series getFixture() {
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
		setFixture(MoviesFactory.eINSTANCE.createSeries());
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

} //SeriesTest
