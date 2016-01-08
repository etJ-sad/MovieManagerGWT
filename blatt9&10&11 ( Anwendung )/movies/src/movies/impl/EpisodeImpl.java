/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package movies.impl;

import movies.Episode;
import movies.MoviesPackage;
import movies.Season;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Episode</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link movies.impl.EpisodeImpl#getBroadcastedBy <em>Broadcasted By</em>}</li>
 *   <li>{@link movies.impl.EpisodeImpl#getProductionCountry <em>Production Country</em>}</li>
 *   <li>{@link movies.impl.EpisodeImpl#getSeason <em>Season</em>}</li>
 *   <li>{@link movies.impl.EpisodeImpl#getEpisodeLoanable <em>Episode Loanable</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EpisodeImpl extends MovieImpl implements Episode {
	/**
	 * The default value of the '{@link #getBroadcastedBy() <em>Broadcasted By</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBroadcastedBy()
	 * @generated
	 * @ordered
	 */
	protected static final String BROADCASTED_BY_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getBroadcastedBy() <em>Broadcasted By</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBroadcastedBy()
	 * @generated
	 * @ordered
	 */
	protected String broadcastedBy = BROADCASTED_BY_EDEFAULT;
	/**
	 * The default value of the '{@link #getProductionCountry() <em>Production Country</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProductionCountry()
	 * @generated
	 * @ordered
	 */
	protected static final String PRODUCTION_COUNTRY_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getProductionCountry() <em>Production Country</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProductionCountry()
	 * @generated
	 * @ordered
	 */
	protected String productionCountry = PRODUCTION_COUNTRY_EDEFAULT;
	/**
	 * The default value of the '{@link #getEpisodeLoanable() <em>Episode Loanable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEpisodeLoanable()
	 * @generated
	 * @ordered
	 */
	protected static final Boolean EPISODE_LOANABLE_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getEpisodeLoanable() <em>Episode Loanable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEpisodeLoanable()
	 * @generated
	 * @ordered
	 */
	protected Boolean episodeLoanable = EPISODE_LOANABLE_EDEFAULT;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EpisodeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MoviesPackage.Literals.EPISODE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getBroadcastedBy() {
		return broadcastedBy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBroadcastedBy(String newBroadcastedBy) {
		String oldBroadcastedBy = broadcastedBy;
		broadcastedBy = newBroadcastedBy;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MoviesPackage.EPISODE__BROADCASTED_BY, oldBroadcastedBy, broadcastedBy));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Season getSeason() {
		if (eContainerFeatureID() != MoviesPackage.EPISODE__SEASON) return null;
		return (Season)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSeason(Season newSeason, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newSeason, MoviesPackage.EPISODE__SEASON, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSeason(Season newSeason) {
		if (newSeason != eInternalContainer() || (eContainerFeatureID() != MoviesPackage.EPISODE__SEASON && newSeason != null)) {
			if (EcoreUtil.isAncestor(this, newSeason))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newSeason != null)
				msgs = ((InternalEObject)newSeason).eInverseAdd(this, MoviesPackage.SEASON__EPISODES, Season.class, msgs);
			msgs = basicSetSeason(newSeason, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MoviesPackage.EPISODE__SEASON, newSeason, newSeason));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Boolean getEpisodeLoanable() {
		return episodeLoanable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEpisodeLoanable(Boolean newEpisodeLoanable) {
		Boolean oldEpisodeLoanable = episodeLoanable;
		episodeLoanable = newEpisodeLoanable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MoviesPackage.EPISODE__EPISODE_LOANABLE, oldEpisodeLoanable, episodeLoanable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getProductionCountry() {
		return productionCountry;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProductionCountry(String newProductionCountry) {
		String oldProductionCountry = productionCountry;
		productionCountry = newProductionCountry;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MoviesPackage.EPISODE__PRODUCTION_COUNTRY, oldProductionCountry, productionCountry));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MoviesPackage.EPISODE__SEASON:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetSeason((Season)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MoviesPackage.EPISODE__SEASON:
				return basicSetSeason(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case MoviesPackage.EPISODE__SEASON:
				return eInternalContainer().eInverseRemove(this, MoviesPackage.SEASON__EPISODES, Season.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MoviesPackage.EPISODE__BROADCASTED_BY:
				return getBroadcastedBy();
			case MoviesPackage.EPISODE__PRODUCTION_COUNTRY:
				return getProductionCountry();
			case MoviesPackage.EPISODE__SEASON:
				return getSeason();
			case MoviesPackage.EPISODE__EPISODE_LOANABLE:
				return getEpisodeLoanable();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case MoviesPackage.EPISODE__BROADCASTED_BY:
				setBroadcastedBy((String)newValue);
				return;
			case MoviesPackage.EPISODE__PRODUCTION_COUNTRY:
				setProductionCountry((String)newValue);
				return;
			case MoviesPackage.EPISODE__SEASON:
				setSeason((Season)newValue);
				return;
			case MoviesPackage.EPISODE__EPISODE_LOANABLE:
				setEpisodeLoanable((Boolean)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case MoviesPackage.EPISODE__BROADCASTED_BY:
				setBroadcastedBy(BROADCASTED_BY_EDEFAULT);
				return;
			case MoviesPackage.EPISODE__PRODUCTION_COUNTRY:
				setProductionCountry(PRODUCTION_COUNTRY_EDEFAULT);
				return;
			case MoviesPackage.EPISODE__SEASON:
				setSeason((Season)null);
				return;
			case MoviesPackage.EPISODE__EPISODE_LOANABLE:
				setEpisodeLoanable(EPISODE_LOANABLE_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case MoviesPackage.EPISODE__BROADCASTED_BY:
				return BROADCASTED_BY_EDEFAULT == null ? broadcastedBy != null : !BROADCASTED_BY_EDEFAULT.equals(broadcastedBy);
			case MoviesPackage.EPISODE__PRODUCTION_COUNTRY:
				return PRODUCTION_COUNTRY_EDEFAULT == null ? productionCountry != null : !PRODUCTION_COUNTRY_EDEFAULT.equals(productionCountry);
			case MoviesPackage.EPISODE__SEASON:
				return getSeason() != null;
			case MoviesPackage.EPISODE__EPISODE_LOANABLE:
				return EPISODE_LOANABLE_EDEFAULT == null ? episodeLoanable != null : !EPISODE_LOANABLE_EDEFAULT.equals(episodeLoanable);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (broadcastedBy: ");
		result.append(broadcastedBy);
		result.append(", productionCountry: ");
		result.append(productionCountry);
		result.append(", episodeLoanable: ");
		result.append(episodeLoanable);
		result.append(')');
		return result.toString();
	}

} //EpisodeImpl
