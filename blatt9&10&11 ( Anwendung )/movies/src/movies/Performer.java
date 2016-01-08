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
 * A representation of the model object '<em><b>Performer</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link movies.Performer#getName <em>Name</em>}</li>
 *   <li>{@link movies.Performer#getGender <em>Gender</em>}</li>
 *   <li>{@link movies.Performer#getRating <em>Rating</em>}</li>
 *   <li>{@link movies.Performer#getMovies <em>Movies</em>}</li>
 *   <li>{@link movies.Performer#getOfdbID <em>Ofdb ID</em>}</li>
 *   <li>{@link movies.Performer#isLoanable <em>Loanable</em>}</li>
 * </ul>
 * </p>
 *
 * @see movies.MoviesPackage#getPerformer()
 * @model
 * @generated
 */
public interface Performer extends EObject {
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
	 * @see movies.MoviesPackage#getPerformer_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link movies.Performer#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Gender</b></em>' attribute.
	 * The literals are from the enumeration {@link movies.Gender}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Gender</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Gender</em>' attribute.
	 * @see movies.Gender
	 * @see #setGender(Gender)
	 * @see movies.MoviesPackage#getPerformer_Gender()
	 * @model
	 * @generated
	 */
	Gender getGender();

	/**
	 * Sets the value of the '{@link movies.Performer#getGender <em>Gender</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Gender</em>' attribute.
	 * @see movies.Gender
	 * @see #getGender()
	 * @generated
	 */
	void setGender(Gender value);

	/**
	 * Returns the value of the '<em><b>Rating</b></em>' attribute.
	 * The literals are from the enumeration {@link movies.Rating}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rating</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rating</em>' attribute.
	 * @see movies.Rating
	 * @see #setRating(Rating)
	 * @see movies.MoviesPackage#getPerformer_Rating()
	 * @model
	 * @generated
	 */
	Rating getRating();

	/**
	 * Sets the value of the '{@link movies.Performer#getRating <em>Rating</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rating</em>' attribute.
	 * @see movies.Rating
	 * @see #getRating()
	 * @generated
	 */
	void setRating(Rating value);

	/**
	 * Returns the value of the '<em><b>Movies</b></em>' reference list.
	 * The list contents are of type {@link movies.Movie}.
	 * It is bidirectional and its opposite is '{@link movies.Movie#getPerformers <em>Performers</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Movies</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Movies</em>' reference list.
	 * @see movies.MoviesPackage#getPerformer_Movies()
	 * @see movies.Movie#getPerformers
	 * @model opposite="performers"
	 *        annotation="org.eclipse.emf.ecp.editor priority='1.0' position='right'"
	 * @generated
	 */
	EList<Movie> getMovies();

	/**
	 * Returns the value of the '<em><b>Ofdb ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ofdb ID</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ofdb ID</em>' attribute.
	 * @see #setOfdbID(String)
	 * @see movies.MoviesPackage#getPerformer_OfdbID()
	 * @model
	 * @generated
	 */
	String getOfdbID();

	/**
	 * Sets the value of the '{@link movies.Performer#getOfdbID <em>Ofdb ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ofdb ID</em>' attribute.
	 * @see #getOfdbID()
	 * @generated
	 */
	void setOfdbID(String value);

	/**
	 * Returns the value of the '<em><b>Loanable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Loanable</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Loanable</em>' attribute.
	 * @see #setLoanable(boolean)
	 * @see movies.MoviesPackage#getPerformer_Loanable()
	 * @model
	 * @generated
	 */
	boolean isLoanable();

	/**
	 * Sets the value of the '{@link movies.Performer#isLoanable <em>Loanable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Loanable</em>' attribute.
	 * @see #isLoanable()
	 * @generated
	 */
	void setLoanable(boolean value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	boolean hasName(DiagnosticChain DiagnosticianChain, Map<?, ?> Context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	boolean hasMovies(DiagnosticChain DiagnosticianChain, Map<?, ?> Context);

} // Performer
