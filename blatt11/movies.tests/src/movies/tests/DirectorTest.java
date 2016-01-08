/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package movies.tests;

import junit.textui.TestRunner;

import movies.Director;
import movies.MoviesFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Director</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class DirectorTest extends PerformerTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(DirectorTest.class);
	}

	/**
	 * Constructs a new Director test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DirectorTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Director test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected Director getFixture() {
		return (Director)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(MoviesFactory.eINSTANCE.createDirector());
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

} //DirectorTest
