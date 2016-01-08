/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package movies;



/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Episode</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link movies.Episode#getBroadcastedBy <em>Broadcasted By</em>}</li>
 *   <li>{@link movies.Episode#getProductionCountry <em>Production Country</em>}</li>
 *   <li>{@link movies.Episode#getSeason <em>Season</em>}</li>
 *   <li>{@link movies.Episode#getEpisodeLoanable <em>Episode Loanable</em>}</li>
 * </ul>
 * </p>
 *
 * @see movies.MoviesPackage#getEpisode()
 * @model
 * @generated
 */
public interface Episode extends Movie {

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
	 * @see movies.MoviesPackage#getEpisode_BroadcastedBy()
	 * @model
	 * @generated
	 */
	String getBroadcastedBy();

	/**
	 * Sets the value of the '{@link movies.Episode#getBroadcastedBy <em>Broadcasted By</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Broadcasted By</em>' attribute.
	 * @see #getBroadcastedBy()
	 * @generated
	 */
	void setBroadcastedBy(String value);

	/**
	 * Returns the value of the '<em><b>Season</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link movies.Season#getEpisodes <em>Episodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Season</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Season</em>' container reference.
	 * @see #setSeason(Season)
	 * @see movies.MoviesPackage#getEpisode_Season()
	 * @see movies.Season#getEpisodes
	 * @model opposite="Episodes" required="true" transient="false"
	 * @generated
	 */
	Season getSeason();

	/**
	 * Sets the value of the '{@link movies.Episode#getSeason <em>Season</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Season</em>' container reference.
	 * @see #getSeason()
	 * @generated
	 */
	void setSeason(Season value);

	/**
	 * Returns the value of the '<em><b>Episode Loanable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Episode Loanable</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Episode Loanable</em>' attribute.
	 * @see #setEpisodeLoanable(Boolean)
	 * @see movies.MoviesPackage#getEpisode_EpisodeLoanable()
	 * @model
	 * @generated
	 */
	Boolean getEpisodeLoanable();

	/**
	 * Sets the value of the '{@link movies.Episode#getEpisodeLoanable <em>Episode Loanable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Episode Loanable</em>' attribute.
	 * @see #getEpisodeLoanable()
	 * @generated
	 */
	void setEpisodeLoanable(Boolean value);

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
	 * @see movies.MoviesPackage#getEpisode_ProductionCountry()
	 * @model
	 * @generated
	 */
	String getProductionCountry();

	/**
	 * Sets the value of the '{@link movies.Episode#getProductionCountry <em>Production Country</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Production Country</em>' attribute.
	 * @see #getProductionCountry()
	 * @generated
	 */
	void setProductionCountry(String value);
} // Episode
