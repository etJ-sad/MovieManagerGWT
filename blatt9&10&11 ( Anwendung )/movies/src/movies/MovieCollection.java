/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package movies;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Movie Collection</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link movies.MovieCollection#getName <em>Name</em>}</li>
 *   <li>{@link movies.MovieCollection#getMovies <em>Movies</em>}</li>
 * </ul>
 * </p>
 *
 * @see movies.MoviesPackage#getMovieCollection()
 * @model
 * @generated
 */
public interface MovieCollection extends EObject {
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
	 * @see movies.MoviesPackage#getMovieCollection_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link movies.MovieCollection#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Movies</b></em>' reference list.
	 * The list contents are of type {@link movies.Movie}.
	 * It is bidirectional and its opposite is '{@link movies.Movie#getMovieCollections <em>Movie Collections</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Movies</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Movies</em>' reference list.
	 * @see movies.MoviesPackage#getMovieCollection_Movies()
	 * @see movies.Movie#getMovieCollections
	 * @model opposite="movieCollections"
	 * @generated
	 */
	EList<Movie> getMovies();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	boolean hasMovies(DiagnosticChain DiagnosticianChain, Map<?, ?> Context);

} // MovieCollection
