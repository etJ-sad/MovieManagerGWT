/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package movies;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Director</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link movies.Director#getNumDirectedMovies <em>Num Directed Movies</em>}</li>
 *   <li>{@link movies.Director#getMoviesDirected <em>Movies Directed</em>}</li>
 * </ul>
 * </p>
 *
 * @see movies.MoviesPackage#getDirector()
 * @model
 * @generated
 */
public interface Director extends Performer {
	/**
	 * Returns the value of the '<em><b>Num Directed Movies</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Num Directed Movies</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Num Directed Movies</em>' attribute.
	 * @see #setNumDirectedMovies(int)
	 * @see movies.MoviesPackage#getDirector_NumDirectedMovies()
	 * @model
	 * @generated
	 */
	int getNumDirectedMovies();

	/**
	 * Sets the value of the '{@link movies.Director#getNumDirectedMovies <em>Num Directed Movies</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Num Directed Movies</em>' attribute.
	 * @see #getNumDirectedMovies()
	 * @generated
	 */
	void setNumDirectedMovies(int value);

	/**
	 * Returns the value of the '<em><b>Movies Directed</b></em>' reference list.
	 * The list contents are of type {@link movies.Movie}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Movies Directed</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Movies Directed</em>' reference list.
	 * @see movies.MoviesPackage#getDirector_MoviesDirected()
	 * @model
	 * @generated
	 */
	EList<Movie> getMoviesDirected();

} // Director
