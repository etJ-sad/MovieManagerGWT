/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package movies;

import java.util.Date;
import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Movie</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link movies.Movie#getTitle <em>Title</em>}</li>
 *   <li>{@link movies.Movie#getTitle_orig <em>Title orig</em>}</li>
 *   <li>{@link movies.Movie#getTime <em>Time</em>}</li>
 *   <li>{@link movies.Movie#getCategory <em>Category</em>}</li>
 *   <li>{@link movies.Movie#getRating <em>Rating</em>}</li>
 *   <li>{@link movies.Movie#getOverallRating <em>Overall Rating</em>}</li>
 *   <li>{@link movies.Movie#getLastWatchDate <em>Last Watch Date</em>}</li>
 *   <li>{@link movies.Movie#isLoaned <em>Loaned</em>}</li>
 *   <li>{@link movies.Movie#getLoanedUntil <em>Loaned Until</em>}</li>
 *   <li>{@link movies.Movie#isLoanable <em>Loanable</em>}</li>
 *   <li>{@link movies.Movie#getPerformers <em>Performers</em>}</li>
 *   <li>{@link movies.Movie#getMovieCollections <em>Movie Collections</em>}</li>
 *   <li>{@link movies.Movie#getImdbUrl <em>Imdb Url</em>}</li>
 *   <li>{@link movies.Movie#getOfdbID <em>Ofdb ID</em>}</li>
 * </ul>
 * </p>
 *
 * @see movies.MoviesPackage#getMovie()
 * @model
 * @generated
 */
public interface Movie extends EObject {
	/**
	 * Returns the value of the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Title</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Title</em>' attribute.
	 * @see #setTitle(String)
	 * @see movies.MoviesPackage#getMovie_Title()
	 * @model
	 * @generated
	 */
	String getTitle();

	/**
	 * Sets the value of the '{@link movies.Movie#getTitle <em>Title</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Title</em>' attribute.
	 * @see #getTitle()
	 * @generated
	 */
	void setTitle(String value);

	/**
	 * Returns the value of the '<em><b>Title orig</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Title orig</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Title orig</em>' attribute.
	 * @see #setTitle_orig(String)
	 * @see movies.MoviesPackage#getMovie_Title_orig()
	 * @model
	 * @generated
	 */
	String getTitle_orig();

	/**
	 * Sets the value of the '{@link movies.Movie#getTitle_orig <em>Title orig</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Title orig</em>' attribute.
	 * @see #getTitle_orig()
	 * @generated
	 */
	void setTitle_orig(String value);

	/**
	 * Returns the value of the '<em><b>Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Time</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Time</em>' attribute.
	 * @see #setTime(int)
	 * @see movies.MoviesPackage#getMovie_Time()
	 * @model
	 * @generated
	 */
	int getTime();

	/**
	 * Sets the value of the '{@link movies.Movie#getTime <em>Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Time</em>' attribute.
	 * @see #getTime()
	 * @generated
	 */
	void setTime(int value);

	/**
	 * Returns the value of the '<em><b>Category</b></em>' attribute.
	 * The literals are from the enumeration {@link movies.MovieCategory}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Category</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Category</em>' attribute.
	 * @see movies.MovieCategory
	 * @see #setCategory(MovieCategory)
	 * @see movies.MoviesPackage#getMovie_Category()
	 * @model
	 * @generated
	 */
	MovieCategory getCategory();

	/**
	 * Sets the value of the '{@link movies.Movie#getCategory <em>Category</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Category</em>' attribute.
	 * @see movies.MovieCategory
	 * @see #getCategory()
	 * @generated
	 */
	void setCategory(MovieCategory value);

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
	 * @see movies.MoviesPackage#getMovie_Rating()
	 * @model
	 * @generated
	 */
	Rating getRating();

	/**
	 * Sets the value of the '{@link movies.Movie#getRating <em>Rating</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rating</em>' attribute.
	 * @see movies.Rating
	 * @see #getRating()
	 * @generated
	 */
	void setRating(Rating value);

	/**
	 * Returns the value of the '<em><b>Overall Rating</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Overall Rating</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Overall Rating</em>' attribute.
	 * @see #setOverallRating(String)
	 * @see movies.MoviesPackage#getMovie_OverallRating()
	 * @model annotation="org.eclipse.emf.ecp.editor priority='1.0' position='right'"
	 * @generated
	 */
	String getOverallRating();

	/**
	 * Sets the value of the '{@link movies.Movie#getOverallRating <em>Overall Rating</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Overall Rating</em>' attribute.
	 * @see #getOverallRating()
	 * @generated
	 */
	void setOverallRating(String value);

	/**
	 * Returns the value of the '<em><b>Last Watch Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Last Watch Date</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Last Watch Date</em>' attribute.
	 * @see #setLastWatchDate(Date)
	 * @see movies.MoviesPackage#getMovie_LastWatchDate()
	 * @model
	 * @generated
	 */
	Date getLastWatchDate();

	/**
	 * Sets the value of the '{@link movies.Movie#getLastWatchDate <em>Last Watch Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Last Watch Date</em>' attribute.
	 * @see #getLastWatchDate()
	 * @generated
	 */
	void setLastWatchDate(Date value);

	/**
	 * Returns the value of the '<em><b>Loaned</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Loaned</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Loaned</em>' attribute.
	 * @see #setLoaned(boolean)
	 * @see movies.MoviesPackage#getMovie_Loaned()
	 * @model
	 * @generated
	 */
	boolean isLoaned();

	/**
	 * Sets the value of the '{@link movies.Movie#isLoaned <em>Loaned</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Loaned</em>' attribute.
	 * @see #isLoaned()
	 * @generated
	 */
	void setLoaned(boolean value);

	/**
	 * Returns the value of the '<em><b>Performers</b></em>' reference list.
	 * The list contents are of type {@link movies.Performer}.
	 * It is bidirectional and its opposite is '{@link movies.Performer#getMovies <em>Movies</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Performers</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Performers</em>' reference list.
	 * @see movies.MoviesPackage#getMovie_Performers()
	 * @see movies.Performer#getMovies
	 * @model opposite="movies"
	 *        annotation="org.eclipse.emf.ecp.editor priority='1.2' position='right'"
	 * @generated
	 */
	EList<Performer> getPerformers();

	/**
	 * Returns the value of the '<em><b>Movie Collections</b></em>' reference list.
	 * The list contents are of type {@link movies.MovieCollection}.
	 * It is bidirectional and its opposite is '{@link movies.MovieCollection#getMovies <em>Movies</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Movie Collections</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Movie Collections</em>' reference list.
	 * @see movies.MoviesPackage#getMovie_MovieCollections()
	 * @see movies.MovieCollection#getMovies
	 * @model opposite="movies"
	 *        annotation="org.eclipse.emf.ecp.editor priority='1.3' position='right'"
	 * @generated
	 */
	EList<MovieCollection> getMovieCollections();

	/**
	 * Returns the value of the '<em><b>Imdb Url</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Imdb Url</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Imdb Url</em>' attribute.
	 * @see #setImdbUrl(String)
	 * @see movies.MoviesPackage#getMovie_ImdbUrl()
	 * @model
	 * @generated
	 */
	String getImdbUrl();

	/**
	 * Sets the value of the '{@link movies.Movie#getImdbUrl <em>Imdb Url</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Imdb Url</em>' attribute.
	 * @see #getImdbUrl()
	 * @generated
	 */
	void setImdbUrl(String value);

	/**
	 * Returns the value of the '<em><b>Ofdb ID</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ofdb ID</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ofdb ID</em>' attribute.
	 * @see #setOfdbID(String)
	 * @see movies.MoviesPackage#getMovie_OfdbID()
	 * @model default=""
	 * @generated
	 */
	String getOfdbID();

	/**
	 * Sets the value of the '{@link movies.Movie#getOfdbID <em>Ofdb ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ofdb ID</em>' attribute.
	 * @see #getOfdbID()
	 * @generated
	 */
	void setOfdbID(String value);

	/**
	 * Returns the value of the '<em><b>Loaned Until</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Loaned Until</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Loaned Until</em>' attribute.
	 * @see #setLoanedUntil(Date)
	 * @see movies.MoviesPackage#getMovie_LoanedUntil()
	 * @model
	 * @generated
	 */
	Date getLoanedUntil();

	/**
	 * Sets the value of the '{@link movies.Movie#getLoanedUntil <em>Loaned Until</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Loaned Until</em>' attribute.
	 * @see #getLoanedUntil()
	 * @generated
	 */
	void setLoanedUntil(Date value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	boolean hasTitle(DiagnosticChain DiagnosticianChain, Map<?, ?> Context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	boolean hasTime(DiagnosticChain DiagnosticianChain, Map<?, ?> Context);

	/**
	 * @generated NOT
	 * */
	boolean isLoanable();

	/**
	 * Sets the value of the '{@link movies.Movie#isLoanable <em>Loanable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Loanable</em>' attribute.
	 * @see #isLoanable()
	 * @generated
	 */
	void setLoanable(boolean value);
	
} // Movie
