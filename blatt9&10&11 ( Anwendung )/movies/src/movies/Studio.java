/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package movies;

import java.util.Date;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Studio</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link movies.Studio#getName <em>Name</em>}</li>
 *   <li>{@link movies.Studio#getFounded <em>Founded</em>}</li>
 *   <li>{@link movies.Studio#getProducedMovies <em>Produced Movies</em>}</li>
 * </ul>
 * </p>
 *
 * @see movies.MoviesPackage#getStudio()
 * @model
 * @generated
 */
public interface Studio extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see movies.MoviesPackage#getStudio_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link movies.Studio#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Founded</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Founded</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Founded</em>' attribute.
	 * @see #setFounded(Date)
	 * @see movies.MoviesPackage#getStudio_Founded()
	 * @model
	 * @generated
	 */
	Date getFounded();

	/**
	 * Sets the value of the '{@link movies.Studio#getFounded <em>Founded</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Founded</em>' attribute.
	 * @see #getFounded()
	 * @generated
	 */
	void setFounded(Date value);

	/**
	 * Returns the value of the '<em><b>Produced Movies</b></em>' reference list.
	 * The list contents are of type {@link movies.Movie}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Produced Movies</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Produced Movies</em>' reference list.
	 * @see movies.MoviesPackage#getStudio_ProducedMovies()
	 * @model
	 * @generated
	 */
	EList<Movie> getProducedMovies();

} // Studio
