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
import movies.Studio;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Studio</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class StudioTest extends TestCase {

	/**
	 * The fixture for this Studio test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Studio fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(StudioTest.class);
	}

	/**
	 * Constructs a new Studio test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StudioTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Studio test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(Studio fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Studio test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Studio getFixture() {
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
		setFixture(MoviesFactory.eINSTANCE.createStudio());
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

} //StudioTest
