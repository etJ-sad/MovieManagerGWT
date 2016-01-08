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
 * A representation of the model object '<em><b>Season</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link movies.Season#getTitle <em>Title</em>}</li>
 *   <li>{@link movies.Season#getReleaseDate <em>Release Date</em>}</li>
 *   <li>{@link movies.Season#getEpisodes <em>Episodes</em>}</li>
 *   <li>{@link movies.Season#getSeries <em>Series</em>}</li>
 *   <li>{@link movies.Season#getRating <em>Rating</em>}</li>
 *   <li>{@link movies.Season#getPerformers <em>Performers</em>}</li>
 *   <li>{@link movies.Season#getBroadcastedBy <em>Broadcasted By</em>}</li>
 *   <li>{@link movies.Season#getProductionCountry <em>Production Country</em>}</li>
 *   <li>{@link movies.Season#isLoaned <em>Loaned</em>}</li>
 *   <li>{@link movies.Season#getLoanedUntil <em>Loaned Until</em>}</li>
 *   <li>{@link movies.Season#isLoanable <em>Loanable</em>}</li>
 * </ul>
 * </p>
 *
 * @see movies.MoviesPackage#getSeason()
 * @model
 * @generated
 */
public interface Season extends EObject {
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
	 * @see movies.MoviesPackage#getSeason_Title()
	 * @model
	 * @generated
	 */
	String getTitle();

	/**
	 * Sets the value of the '{@link movies.Season#getTitle <em>Title</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Title</em>' attribute.
	 * @see #getTitle()
	 * @generated
	 */
	void setTitle(String value);

	/**
	 * Returns the value of the '<em><b>Release Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Release Date</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Release Date</em>' attribute.
	 * @see #setReleaseDate(Date)
	 * @see movies.MoviesPackage#getSeason_ReleaseDate()
	 * @model
	 * @generated
	 */
	Date getReleaseDate();

	/**
	 * Sets the value of the '{@link movies.Season#getReleaseDate <em>Release Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Release Date</em>' attribute.
	 * @see #getReleaseDate()
	 * @generated
	 */
	void setReleaseDate(Date value);

	/**
	 * Returns the value of the '<em><b>Episodes</b></em>' containment reference list.
	 * The list contents are of type {@link movies.Episode}.
	 * It is bidirectional and its opposite is '{@link movies.Episode#getSeason <em>Season</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Episodes</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Episodes</em>' containment reference list.
	 * @see movies.MoviesPackage#getSeason_Episodes()
	 * @see movies.Episode#getSeason
	 * @model opposite="Season" containment="true"
	 *        annotation="org.eclipse.emf.ecp.editor position='right'"
	 * @generated
	 */
	EList<Episode> getEpisodes();

	/**
	 * Returns the value of the '<em><b>Series</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link movies.Series#getSeasons <em>Seasons</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Series</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Series</em>' container reference.
	 * @see #setSeries(Series)
	 * @see movies.MoviesPackage#getSeason_Series()
	 * @see movies.Series#getSeasons
	 * @model opposite="Seasons" required="true" transient="false"
	 * @generated
	 */
	Series getSeries();

	/**
	 * Sets the value of the '{@link movies.Season#getSeries <em>Series</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Series</em>' container reference.
	 * @see #getSeries()
	 * @generated
	 */
	void setSeries(Series value);

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
	 * @see #isSetRating()
	 * @see #unsetRating()
	 * @see #setRating(Rating)
	 * @see movies.MoviesPackage#getSeason_Rating()
	 * @model unsettable="true"
	 * @generated
	 */
	Rating getRating();

	/**
	 * Sets the value of the '{@link movies.Season#getRating <em>Rating</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rating</em>' attribute.
	 * @see movies.Rating
	 * @see #isSetRating()
	 * @see #unsetRating()
	 * @see #getRating()
	 * @generated
	 */
	void setRating(Rating value);

	/**
	 * Unsets the value of the '{@link movies.Season#getRating <em>Rating</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetRating()
	 * @see #getRating()
	 * @see #setRating(Rating)
	 * @generated
	 */
	void unsetRating();

	/**
	 * Returns whether the value of the '{@link movies.Season#getRating <em>Rating</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Rating</em>' attribute is set.
	 * @see #unsetRating()
	 * @see #getRating()
	 * @see #setRating(Rating)
	 * @generated
	 */
	boolean isSetRating();

	/**
	 * Returns the value of the '<em><b>Performers</b></em>' reference list.
	 * The list contents are of type {@link movies.Performer}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Performers</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Performers</em>' reference list.
	 * @see movies.MoviesPackage#getSeason_Performers()
	 * @model annotation="org.eclipse.emf.ecp.editor position='right'"
	 * @generated
	 */
	EList<Performer> getPerformers();

	/**
	 * Returns the value of the '<em><b>Broadcasted By</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Broadcasted By</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Broadcasted By</em>' attribute.
	 * @see #setBroadcastedBy(String)
	 * @see movies.MoviesPackage#getSeason_BroadcastedBy()
	 * @model
	 * @generated
	 */
	String getBroadcastedBy();

	/**
	 * Sets the value of the '{@link movies.Season#getBroadcastedBy <em>Broadcasted By</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Broadcasted By</em>' attribute.
	 * @see #getBroadcastedBy()
	 * @generated
	 */
	void setBroadcastedBy(String value);

	/**
	 * Returns the value of the '<em><b>Production Country</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Production Country</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Production Country</em>' attribute.
	 * @see #setProductionCountry(String)
	 * @see movies.MoviesPackage#getSeason_ProductionCountry()
	 * @model
	 * @generated
	 */
	String getProductionCountry();

	/**
	 * Sets the value of the '{@link movies.Season#getProductionCountry <em>Production Country</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Production Country</em>' attribute.
	 * @see #getProductionCountry()
	 * @generated
	 */
	void setProductionCountry(String value);

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
	 * @see movies.MoviesPackage#getSeason_Loaned()
	 * @model
	 * @generated
	 */
	boolean isLoaned();

	/**
	 * Sets the value of the '{@link movies.Season#isLoaned <em>Loaned</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Loaned</em>' attribute.
	 * @see #isLoaned()
	 * @generated
	 */
	void setLoaned(boolean value);

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
	 * @see movies.MoviesPackage#getSeason_LoanedUntil()
	 * @model
	 * @generated
	 */
	Date getLoanedUntil();

	/**
	 * Sets the value of the '{@link movies.Season#getLoanedUntil <em>Loaned Until</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Loaned Until</em>' attribute.
	 * @see #getLoanedUntil()
	 * @generated
	 */
	void setLoanedUntil(Date value);
	
	/**
	 * @generated NOT
	 * */
	boolean isLoanable();

	/**
	 * Sets the value of the '{@link movies.Season#isLoanable <em>Loanable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Loanable</em>' attribute.
	 * @see #isLoanable()
	 * @generated
	 */
	void setLoanable(boolean value);
	
} // Season
