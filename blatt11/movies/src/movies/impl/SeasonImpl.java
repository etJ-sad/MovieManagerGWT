/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package movies.impl;

import java.util.Collection;
import java.util.Date;

import movies.Episode;
import movies.MoviesPackage;
import movies.Performer;
import movies.Rating;
import movies.Season;
import movies.Series;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Season</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link movies.impl.SeasonImpl#getTitle <em>Title</em>}</li>
 *   <li>{@link movies.impl.SeasonImpl#getReleaseDate <em>Release Date</em>}</li>
 *   <li>{@link movies.impl.SeasonImpl#getEpisodes <em>Episodes</em>}</li>
 *   <li>{@link movies.impl.SeasonImpl#getSeries <em>Series</em>}</li>
 *   <li>{@link movies.impl.SeasonImpl#getRating <em>Rating</em>}</li>
 *   <li>{@link movies.impl.SeasonImpl#getPerformers <em>Performers</em>}</li>
 *   <li>{@link movies.impl.SeasonImpl#getBroadcastedBy <em>Broadcasted By</em>}</li>
 *   <li>{@link movies.impl.SeasonImpl#getProductionCountry <em>Production Country</em>}</li>
 *   <li>{@link movies.impl.SeasonImpl#isLoaned <em>Loaned</em>}</li>
 *   <li>{@link movies.impl.SeasonImpl#getLoanedUntil <em>Loaned Until</em>}</li>
 *   <li>{@link movies.impl.SeasonImpl#isLoanable <em>Loanable</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SeasonImpl extends EObjectImpl implements Season {
	/**
	 * The default value of the '{@link #getTitle() <em>Title</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTitle()
	 * @generated
	 * @ordered
	 */
	protected static final String TITLE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTitle() <em>Title</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTitle()
	 * @generated
	 * @ordered
	 */
	protected String title = TITLE_EDEFAULT;

	/**
	 * The default value of the '{@link #getReleaseDate() <em>Release Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReleaseDate()
	 * @generated
	 * @ordered
	 */
	protected static final Date RELEASE_DATE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getReleaseDate() <em>Release Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReleaseDate()
	 * @generated
	 * @ordered
	 */
	protected Date releaseDate = RELEASE_DATE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getEpisodes() <em>Episodes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEpisodes()
	 * @generated
	 * @ordered
	 */
	protected EList<Episode> episodes;

	/**
	 * The default value of the '{@link #getRating() <em>Rating</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRating()
	 * @generated
	 * @ordered
	 */
	protected static final Rating RATING_EDEFAULT = Rating.ZERO;

	/**
	 * The cached value of the '{@link #getRating() <em>Rating</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRating()
	 * @generated
	 * @ordered
	 */
	protected Rating rating = RATING_EDEFAULT;

	/**
	 * This is true if the Rating attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean ratingESet;

	/**
	 * The cached value of the '{@link #getPerformers() <em>Performers</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPerformers()
	 * @generated
	 * @ordered
	 */
	protected EList<Performer> performers;

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
	 * The default value of the '{@link #isLoaned() <em>Loaned</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isLoaned()
	 * @generated
	 * @ordered
	 */
	protected static final boolean LOANED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isLoaned() <em>Loaned</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isLoaned()
	 * @generated
	 * @ordered
	 */
	protected boolean loaned = LOANED_EDEFAULT;

	/**
	 * The default value of the '{@link #getLoanedUntil() <em>Loaned Until</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLoanedUntil()
	 * @generated
	 * @ordered
	 */
	protected static final Date LOANED_UNTIL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLoanedUntil() <em>Loaned Until</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLoanedUntil()
	 * @generated
	 * @ordered
	 */
	protected Date loanedUntil = LOANED_UNTIL_EDEFAULT;

	/**
	 * The default value of the '{@link #isLoanable() <em>Loanable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isLoanable()
	 * @generated
	 * @ordered
	 */
	protected static final boolean LOANABLE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isLoanable() <em>Loanable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isLoanable()
	 * @generated
	 * @ordered
	 */
	protected boolean loanable = LOANABLE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SeasonImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MoviesPackage.Literals.SEASON;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTitle(String newTitle) {
		String oldTitle = title;
		title = newTitle;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MoviesPackage.SEASON__TITLE, oldTitle, title));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Date getReleaseDate() {
		return releaseDate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReleaseDate(Date newReleaseDate) {
		Date oldReleaseDate = releaseDate;
		releaseDate = newReleaseDate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MoviesPackage.SEASON__RELEASE_DATE, oldReleaseDate, releaseDate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Episode> getEpisodes() {
		if (episodes == null) {
			episodes = new EObjectContainmentWithInverseEList<Episode>(Episode.class, this, MoviesPackage.SEASON__EPISODES, MoviesPackage.EPISODE__SEASON);
		}
		return episodes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Series getSeries() {
		if (eContainerFeatureID() != MoviesPackage.SEASON__SERIES) return null;
		return (Series)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSeries(Series newSeries, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newSeries, MoviesPackage.SEASON__SERIES, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSeries(Series newSeries) {
		if (newSeries != eInternalContainer() || (eContainerFeatureID() != MoviesPackage.SEASON__SERIES && newSeries != null)) {
			if (EcoreUtil.isAncestor(this, newSeries))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newSeries != null)
				msgs = ((InternalEObject)newSeries).eInverseAdd(this, MoviesPackage.SERIES__SEASONS, Series.class, msgs);
			msgs = basicSetSeries(newSeries, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MoviesPackage.SEASON__SERIES, newSeries, newSeries));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Rating getRating() {
		return rating;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRating(Rating newRating) {
		Rating oldRating = rating;
		rating = newRating == null ? RATING_EDEFAULT : newRating;
		boolean oldRatingESet = ratingESet;
		ratingESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MoviesPackage.SEASON__RATING, oldRating, rating, !oldRatingESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetRating() {
		Rating oldRating = rating;
		boolean oldRatingESet = ratingESet;
		rating = RATING_EDEFAULT;
		ratingESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, MoviesPackage.SEASON__RATING, oldRating, RATING_EDEFAULT, oldRatingESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetRating() {
		return ratingESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Performer> getPerformers() {
		if (performers == null) {
			performers = new EObjectResolvingEList<Performer>(Performer.class, this, MoviesPackage.SEASON__PERFORMERS);
		}
		return performers;
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
			eNotify(new ENotificationImpl(this, Notification.SET, MoviesPackage.SEASON__BROADCASTED_BY, oldBroadcastedBy, broadcastedBy));
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
			eNotify(new ENotificationImpl(this, Notification.SET, MoviesPackage.SEASON__PRODUCTION_COUNTRY, oldProductionCountry, productionCountry));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isLoaned() {
		return loaned;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLoaned(boolean newLoaned) {
		boolean oldLoaned = loaned;
		loaned = newLoaned;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MoviesPackage.SEASON__LOANED, oldLoaned, loaned));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Date getLoanedUntil() {
		return loanedUntil;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLoanedUntil(Date newLoanedUntil) {
		Date oldLoanedUntil = loanedUntil;
		loanedUntil = newLoanedUntil;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MoviesPackage.SEASON__LOANED_UNTIL, oldLoanedUntil, loanedUntil));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MoviesPackage.SEASON__EPISODES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getEpisodes()).basicAdd(otherEnd, msgs);
			case MoviesPackage.SEASON__SERIES:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetSeries((Series)otherEnd, msgs);
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
			case MoviesPackage.SEASON__EPISODES:
				return ((InternalEList<?>)getEpisodes()).basicRemove(otherEnd, msgs);
			case MoviesPackage.SEASON__SERIES:
				return basicSetSeries(null, msgs);
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
			case MoviesPackage.SEASON__SERIES:
				return eInternalContainer().eInverseRemove(this, MoviesPackage.SERIES__SEASONS, Series.class, msgs);
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
			case MoviesPackage.SEASON__TITLE:
				return getTitle();
			case MoviesPackage.SEASON__RELEASE_DATE:
				return getReleaseDate();
			case MoviesPackage.SEASON__EPISODES:
				return getEpisodes();
			case MoviesPackage.SEASON__SERIES:
				return getSeries();
			case MoviesPackage.SEASON__RATING:
				return getRating();
			case MoviesPackage.SEASON__PERFORMERS:
				return getPerformers();
			case MoviesPackage.SEASON__BROADCASTED_BY:
				return getBroadcastedBy();
			case MoviesPackage.SEASON__PRODUCTION_COUNTRY:
				return getProductionCountry();
			case MoviesPackage.SEASON__LOANED:
				return isLoaned();
			case MoviesPackage.SEASON__LOANED_UNTIL:
				return getLoanedUntil();
			case MoviesPackage.SEASON__LOANABLE:
				return isLoanable();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case MoviesPackage.SEASON__TITLE:
				setTitle((String)newValue);
				return;
			case MoviesPackage.SEASON__RELEASE_DATE:
				setReleaseDate((Date)newValue);
				return;
			case MoviesPackage.SEASON__EPISODES:
				getEpisodes().clear();
				getEpisodes().addAll((Collection<? extends Episode>)newValue);
				return;
			case MoviesPackage.SEASON__SERIES:
				setSeries((Series)newValue);
				return;
			case MoviesPackage.SEASON__RATING:
				setRating((Rating)newValue);
				return;
			case MoviesPackage.SEASON__PERFORMERS:
				getPerformers().clear();
				getPerformers().addAll((Collection<? extends Performer>)newValue);
				return;
			case MoviesPackage.SEASON__BROADCASTED_BY:
				setBroadcastedBy((String)newValue);
				return;
			case MoviesPackage.SEASON__PRODUCTION_COUNTRY:
				setProductionCountry((String)newValue);
				return;
			case MoviesPackage.SEASON__LOANED:
				setLoaned((Boolean)newValue);
				return;
			case MoviesPackage.SEASON__LOANED_UNTIL:
				setLoanedUntil((Date)newValue);
				return;
			case MoviesPackage.SEASON__LOANABLE:
				setLoanable((Boolean)newValue);
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
			case MoviesPackage.SEASON__TITLE:
				setTitle(TITLE_EDEFAULT);
				return;
			case MoviesPackage.SEASON__RELEASE_DATE:
				setReleaseDate(RELEASE_DATE_EDEFAULT);
				return;
			case MoviesPackage.SEASON__EPISODES:
				getEpisodes().clear();
				return;
			case MoviesPackage.SEASON__SERIES:
				setSeries((Series)null);
				return;
			case MoviesPackage.SEASON__RATING:
				unsetRating();
				return;
			case MoviesPackage.SEASON__PERFORMERS:
				getPerformers().clear();
				return;
			case MoviesPackage.SEASON__BROADCASTED_BY:
				setBroadcastedBy(BROADCASTED_BY_EDEFAULT);
				return;
			case MoviesPackage.SEASON__PRODUCTION_COUNTRY:
				setProductionCountry(PRODUCTION_COUNTRY_EDEFAULT);
				return;
			case MoviesPackage.SEASON__LOANED:
				setLoaned(LOANED_EDEFAULT);
				return;
			case MoviesPackage.SEASON__LOANED_UNTIL:
				setLoanedUntil(LOANED_UNTIL_EDEFAULT);
				return;
			case MoviesPackage.SEASON__LOANABLE:
				setLoanable(LOANABLE_EDEFAULT);
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
			case MoviesPackage.SEASON__TITLE:
				return TITLE_EDEFAULT == null ? title != null : !TITLE_EDEFAULT.equals(title);
			case MoviesPackage.SEASON__RELEASE_DATE:
				return RELEASE_DATE_EDEFAULT == null ? releaseDate != null : !RELEASE_DATE_EDEFAULT.equals(releaseDate);
			case MoviesPackage.SEASON__EPISODES:
				return episodes != null && !episodes.isEmpty();
			case MoviesPackage.SEASON__SERIES:
				return getSeries() != null;
			case MoviesPackage.SEASON__RATING:
				return isSetRating();
			case MoviesPackage.SEASON__PERFORMERS:
				return performers != null && !performers.isEmpty();
			case MoviesPackage.SEASON__BROADCASTED_BY:
				return BROADCASTED_BY_EDEFAULT == null ? broadcastedBy != null : !BROADCASTED_BY_EDEFAULT.equals(broadcastedBy);
			case MoviesPackage.SEASON__PRODUCTION_COUNTRY:
				return PRODUCTION_COUNTRY_EDEFAULT == null ? productionCountry != null : !PRODUCTION_COUNTRY_EDEFAULT.equals(productionCountry);
			case MoviesPackage.SEASON__LOANED:
				return loaned != LOANED_EDEFAULT;
			case MoviesPackage.SEASON__LOANED_UNTIL:
				return LOANED_UNTIL_EDEFAULT == null ? loanedUntil != null : !LOANED_UNTIL_EDEFAULT.equals(loanedUntil);
			case MoviesPackage.SEASON__LOANABLE:
				return loanable != LOANABLE_EDEFAULT;
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
		result.append(" (title: ");
		result.append(title);
		result.append(", releaseDate: ");
		result.append(releaseDate);
		result.append(", rating: ");
		if (ratingESet) result.append(rating); else result.append("<unset>");
		result.append(", broadcastedBy: ");
		result.append(broadcastedBy);
		result.append(", productionCountry: ");
		result.append(productionCountry);
		result.append(", loaned: ");
		result.append(loaned);
		result.append(", loanedUntil: ");
		result.append(loanedUntil);
		result.append(", loanable: ");
		result.append(loanable);
		result.append(')');
		return result.toString();
	}
	
	/**
	 * @generated NOT
	 * */
	@Override
	public boolean isLoanable() {
		return loanable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLoanable(boolean newLoanable) {
		boolean oldLoanable = loanable;
		loanable = newLoanable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MoviesPackage.SEASON__LOANABLE, oldLoanable, loanable));
	}
	
} //SeasonImpl
