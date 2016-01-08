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
 * A representation of the model object '<em><b>Series</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link movies.Series#getTitle <em>Title</em>}</li>
 *   <li>{@link movies.Series#getStudio <em>Studio</em>}</li>
 *   <li>{@link movies.Series#getBroadcastedBy <em>Broadcasted By</em>}</li>
 *   <li>{@link movies.Series#getReleaseDate <em>Release Date</em>}</li>
 *   <li>{@link movies.Series#getSeasons <em>Seasons</em>}</li>
 *   <li>{@link movies.Series#getRating <em>Rating</em>}</li>
 *   <li>{@link movies.Series#getPerformers <em>Performers</em>}</li>
 *   <li>{@link movies.Series#getProductionCountry <em>Production Country</em>}</li>
 *   <li>{@link movies.Series#isLoaned <em>Loaned</em>}</li>
 *   <li>{@link movies.Series#getLoanedUntil <em>Loaned Until</em>}</li>
 *   <li>{@link movies.Series#isLoanable <em>Loanable</em>}</li>
 *   <li>{@link movies.Series#isAllpartsloanable <em>Allpartsloanable</em>}</li>
 *   <li>{@link movies.Series#isAllpartsloaned <em>Allpartsloaned</em>}</li>
 *   <li>{@link movies.Series#isPartsloaned <em>Partsloaned</em>}</li>
 * </ul>
 * </p>
 *
 * @see movies.MoviesPackage#getSeries()
 * @model
 * @generated
 */
public interface Series extends EObject {
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
	 * @see movies.MoviesPackage#getSeries_Title()
	 * @model
	 * @generated
	 */
	String getTitle();

	/**
	 * Sets the value of the '{@link movies.Series#getTitle <em>Title</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Title</em>' attribute.
	 * @see #getTitle()
	 * @generated
	 */
	void setTitle(String value);

	/**
	 * Returns the value of the '<em><b>Studio</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Studio</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Studio</em>' attribute.
	 * @see #setStudio(String)
	 * @see movies.MoviesPackage#getSeries_Studio()
	 * @model
	 * @generated
	 */
	String getStudio();

	/**
	 * Sets the value of the '{@link movies.Series#getStudio <em>Studio</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Studio</em>' attribute.
	 * @see #getStudio()
	 * @generated
	 */
	void setStudio(String value);

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
	 * @see movies.MoviesPackage#getSeries_BroadcastedBy()
	 * @model
	 * @generated
	 */
	String getBroadcastedBy();

	/**
	 * Sets the value of the '{@link movies.Series#getBroadcastedBy <em>Broadcasted By</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Broadcasted By</em>' attribute.
	 * @see #getBroadcastedBy()
	 * @generated
	 */
	void setBroadcastedBy(String value);

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
	 * @see movies.MoviesPackage#getSeries_ReleaseDate()
	 * @model
	 * @generated
	 */
	Date getReleaseDate();

	/**
	 * Sets the value of the '{@link movies.Series#getReleaseDate <em>Release Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Release Date</em>' attribute.
	 * @see #getReleaseDate()
	 * @generated
	 */
	void setReleaseDate(Date value);

	/**
	 * Returns the value of the '<em><b>Seasons</b></em>' containment reference list.
	 * The list contents are of type {@link movies.Season}.
	 * It is bidirectional and its opposite is '{@link movies.Season#getSeries <em>Series</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Seasons</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Seasons</em>' containment reference list.
	 * @see movies.MoviesPackage#getSeries_Seasons()
	 * @see movies.Season#getSeries
	 * @model opposite="Series" containment="true"
	 *        annotation="org.eclipse.emf.ecp.editor position='right'"
	 * @generated
	 */
	EList<Season> getSeasons();

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
	 * @see movies.MoviesPackage#getSeries_Rating()
	 * @model unsettable="true"
	 * @generated
	 */
	Rating getRating();

	/**
	 * Sets the value of the '{@link movies.Series#getRating <em>Rating</em>}' attribute.
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
	 * Unsets the value of the '{@link movies.Series#getRating <em>Rating</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetRating()
	 * @see #getRating()
	 * @see #setRating(Rating)
	 * @generated
	 */
	void unsetRating();

	/**
	 * Returns whether the value of the '{@link movies.Series#getRating <em>Rating</em>}' attribute is set.
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
	 * @see movies.MoviesPackage#getSeries_Performers()
	 * @model annotation="org.eclipse.emf.ecp.editor position='right'"
	 * @generated
	 */
	EList<Performer> getPerformers();

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
	 * @see movies.MoviesPackage#getSeries_ProductionCountry()
	 * @model
	 * @generated
	 */
	String getProductionCountry();

	/**
	 * Sets the value of the '{@link movies.Series#getProductionCountry <em>Production Country</em>}' attribute.
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
	 * @see movies.MoviesPackage#getSeries_Loaned()
	 * @model
	 * @generated
	 */
	boolean isLoaned();

	/**
	 * Sets the value of the '{@link movies.Series#isLoaned <em>Loaned</em>}' attribute.
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
	 * @see movies.MoviesPackage#getSeries_LoanedUntil()
	 * @model
	 * @generated
	 */
	Date getLoanedUntil();

	/**
	 * Sets the value of the '{@link movies.Series#getLoanedUntil <em>Loaned Until</em>}' attribute.
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
	 * Sets the value of the '{@link movies.Series#isLoanable <em>Loanable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Loanable</em>' attribute.
	 * @see #isLoanable()
	 * @generated
	 */
	void setLoanable(boolean value);

	/**
	 * Returns the value of the '<em><b>Allpartsloanable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Allpartsloanable</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Allpartsloanable</em>' attribute.
	 * @see #setAllpartsloanable(boolean)
	 * @see movies.MoviesPackage#getSeries_Allpartsloanable()
	 * @model
	 * @generated
	 */
	boolean isAllpartsloanable();

	/**
	 * Sets the value of the '{@link movies.Series#isAllpartsloanable <em>Allpartsloanable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Allpartsloanable</em>' attribute.
	 * @see #isAllpartsloanable()
	 * @generated
	 */
	void setAllpartsloanable(boolean value);

	/**
	 * Returns the value of the '<em><b>Allpartsloaned</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Allpartsloaned</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Allpartsloaned</em>' attribute.
	 * @see #setAllpartsloaned(boolean)
	 * @see movies.MoviesPackage#getSeries_Allpartsloaned()
	 * @model
	 * @generated
	 */
	boolean isAllpartsloaned();

	/**
	 * Sets the value of the '{@link movies.Series#isAllpartsloaned <em>Allpartsloaned</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Allpartsloaned</em>' attribute.
	 * @see #isAllpartsloaned()
	 * @generated
	 */
	void setAllpartsloaned(boolean value);

	/**
	 * Returns the value of the '<em><b>Partsloaned</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Partsloaned</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Partsloaned</em>' attribute.
	 * @see #setPartsloaned(boolean)
	 * @see movies.MoviesPackage#getSeries_Partsloaned()
	 * @model
	 * @generated
	 */
	boolean isPartsloaned();

	/**
	 * Sets the value of the '{@link movies.Series#isPartsloaned <em>Partsloaned</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Partsloaned</em>' attribute.
	 * @see #isPartsloaned()
	 * @generated
	 */
	void setPartsloaned(boolean value);

} // Series
