/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package movies.impl;

import java.util.Collection;
import java.util.Date;

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
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Series</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link movies.impl.SeriesImpl#getTitle <em>Title</em>}</li>
 *   <li>{@link movies.impl.SeriesImpl#getStudio <em>Studio</em>}</li>
 *   <li>{@link movies.impl.SeriesImpl#getBroadcastedBy <em>Broadcasted By</em>}</li>
 *   <li>{@link movies.impl.SeriesImpl#getReleaseDate <em>Release Date</em>}</li>
 *   <li>{@link movies.impl.SeriesImpl#getSeasons <em>Seasons</em>}</li>
 *   <li>{@link movies.impl.SeriesImpl#getRating <em>Rating</em>}</li>
 *   <li>{@link movies.impl.SeriesImpl#getPerformers <em>Performers</em>}</li>
 *   <li>{@link movies.impl.SeriesImpl#getProductionCountry <em>Production Country</em>}</li>
 *   <li>{@link movies.impl.SeriesImpl#isLoaned <em>Loaned</em>}</li>
 *   <li>{@link movies.impl.SeriesImpl#getLoanedUntil <em>Loaned Until</em>}</li>
 *   <li>{@link movies.impl.SeriesImpl#isLoanable <em>Loanable</em>}</li>
 *   <li>{@link movies.impl.SeriesImpl#isAllpartsloanable <em>Allpartsloanable</em>}</li>
 *   <li>{@link movies.impl.SeriesImpl#isAllpartsloaned <em>Allpartsloaned</em>}</li>
 *   <li>{@link movies.impl.SeriesImpl#isPartsloaned <em>Partsloaned</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SeriesImpl extends EObjectImpl implements Series {
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
	 * The default value of the '{@link #getStudio() <em>Studio</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStudio()
	 * @generated
	 * @ordered
	 */
	protected static final String STUDIO_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getStudio() <em>Studio</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStudio()
	 * @generated
	 * @ordered
	 */
	protected String studio = STUDIO_EDEFAULT;

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
	 * The cached value of the '{@link #getSeasons() <em>Seasons</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSeasons()
	 * @generated
	 * @ordered
	 */
	protected EList<Season> seasons;

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
	 * The default value of the '{@link #isAllpartsloanable() <em>Allpartsloanable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAllpartsloanable()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ALLPARTSLOANABLE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isAllpartsloanable() <em>Allpartsloanable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAllpartsloanable()
	 * @generated
	 * @ordered
	 */
	protected boolean allpartsloanable = ALLPARTSLOANABLE_EDEFAULT;

	/**
	 * The default value of the '{@link #isAllpartsloaned() <em>Allpartsloaned</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAllpartsloaned()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ALLPARTSLOANED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isAllpartsloaned() <em>Allpartsloaned</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAllpartsloaned()
	 * @generated
	 * @ordered
	 */
	protected boolean allpartsloaned = ALLPARTSLOANED_EDEFAULT;

	/**
	 * The default value of the '{@link #isPartsloaned() <em>Partsloaned</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isPartsloaned()
	 * @generated
	 * @ordered
	 */
	protected static final boolean PARTSLOANED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isPartsloaned() <em>Partsloaned</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isPartsloaned()
	 * @generated
	 * @ordered
	 */
	protected boolean partsloaned = PARTSLOANED_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SeriesImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MoviesPackage.Literals.SERIES;
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
			eNotify(new ENotificationImpl(this, Notification.SET, MoviesPackage.SERIES__TITLE, oldTitle, title));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getStudio() {
		return studio;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStudio(String newStudio) {
		String oldStudio = studio;
		studio = newStudio;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MoviesPackage.SERIES__STUDIO, oldStudio, studio));
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
			eNotify(new ENotificationImpl(this, Notification.SET, MoviesPackage.SERIES__BROADCASTED_BY, oldBroadcastedBy, broadcastedBy));
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
			eNotify(new ENotificationImpl(this, Notification.SET, MoviesPackage.SERIES__RELEASE_DATE, oldReleaseDate, releaseDate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Season> getSeasons() {
		if (seasons == null) {
			seasons = new EObjectContainmentWithInverseEList<Season>(Season.class, this, MoviesPackage.SERIES__SEASONS, MoviesPackage.SEASON__SERIES);
		}
		return seasons;
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
			eNotify(new ENotificationImpl(this, Notification.SET, MoviesPackage.SERIES__RATING, oldRating, rating, !oldRatingESet));
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
			eNotify(new ENotificationImpl(this, Notification.UNSET, MoviesPackage.SERIES__RATING, oldRating, RATING_EDEFAULT, oldRatingESet));
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
			performers = new EObjectResolvingEList<Performer>(Performer.class, this, MoviesPackage.SERIES__PERFORMERS);
		}
		return performers;
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
			eNotify(new ENotificationImpl(this, Notification.SET, MoviesPackage.SERIES__PRODUCTION_COUNTRY, oldProductionCountry, productionCountry));
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
			eNotify(new ENotificationImpl(this, Notification.SET, MoviesPackage.SERIES__LOANED, oldLoaned, loaned));
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
			eNotify(new ENotificationImpl(this, Notification.SET, MoviesPackage.SERIES__LOANED_UNTIL, oldLoanedUntil, loanedUntil));
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
			case MoviesPackage.SERIES__SEASONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getSeasons()).basicAdd(otherEnd, msgs);
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
			case MoviesPackage.SERIES__SEASONS:
				return ((InternalEList<?>)getSeasons()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MoviesPackage.SERIES__TITLE:
				return getTitle();
			case MoviesPackage.SERIES__STUDIO:
				return getStudio();
			case MoviesPackage.SERIES__BROADCASTED_BY:
				return getBroadcastedBy();
			case MoviesPackage.SERIES__RELEASE_DATE:
				return getReleaseDate();
			case MoviesPackage.SERIES__SEASONS:
				return getSeasons();
			case MoviesPackage.SERIES__RATING:
				return getRating();
			case MoviesPackage.SERIES__PERFORMERS:
				return getPerformers();
			case MoviesPackage.SERIES__PRODUCTION_COUNTRY:
				return getProductionCountry();
			case MoviesPackage.SERIES__LOANED:
				return isLoaned();
			case MoviesPackage.SERIES__LOANED_UNTIL:
				return getLoanedUntil();
			case MoviesPackage.SERIES__LOANABLE:
				return isLoanable();
			case MoviesPackage.SERIES__ALLPARTSLOANABLE:
				return isAllpartsloanable();
			case MoviesPackage.SERIES__ALLPARTSLOANED:
				return isAllpartsloaned();
			case MoviesPackage.SERIES__PARTSLOANED:
				return isPartsloaned();
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
			case MoviesPackage.SERIES__TITLE:
				setTitle((String)newValue);
				return;
			case MoviesPackage.SERIES__STUDIO:
				setStudio((String)newValue);
				return;
			case MoviesPackage.SERIES__BROADCASTED_BY:
				setBroadcastedBy((String)newValue);
				return;
			case MoviesPackage.SERIES__RELEASE_DATE:
				setReleaseDate((Date)newValue);
				return;
			case MoviesPackage.SERIES__SEASONS:
				getSeasons().clear();
				getSeasons().addAll((Collection<? extends Season>)newValue);
				return;
			case MoviesPackage.SERIES__RATING:
				setRating((Rating)newValue);
				return;
			case MoviesPackage.SERIES__PERFORMERS:
				getPerformers().clear();
				getPerformers().addAll((Collection<? extends Performer>)newValue);
				return;
			case MoviesPackage.SERIES__PRODUCTION_COUNTRY:
				setProductionCountry((String)newValue);
				return;
			case MoviesPackage.SERIES__LOANED:
				setLoaned((Boolean)newValue);
				return;
			case MoviesPackage.SERIES__LOANED_UNTIL:
				setLoanedUntil((Date)newValue);
				return;
			case MoviesPackage.SERIES__LOANABLE:
				setLoanable((Boolean)newValue);
				return;
			case MoviesPackage.SERIES__ALLPARTSLOANABLE:
				setAllpartsloanable((Boolean)newValue);
				return;
			case MoviesPackage.SERIES__ALLPARTSLOANED:
				setAllpartsloaned((Boolean)newValue);
				return;
			case MoviesPackage.SERIES__PARTSLOANED:
				setPartsloaned((Boolean)newValue);
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
			case MoviesPackage.SERIES__TITLE:
				setTitle(TITLE_EDEFAULT);
				return;
			case MoviesPackage.SERIES__STUDIO:
				setStudio(STUDIO_EDEFAULT);
				return;
			case MoviesPackage.SERIES__BROADCASTED_BY:
				setBroadcastedBy(BROADCASTED_BY_EDEFAULT);
				return;
			case MoviesPackage.SERIES__RELEASE_DATE:
				setReleaseDate(RELEASE_DATE_EDEFAULT);
				return;
			case MoviesPackage.SERIES__SEASONS:
				getSeasons().clear();
				return;
			case MoviesPackage.SERIES__RATING:
				unsetRating();
				return;
			case MoviesPackage.SERIES__PERFORMERS:
				getPerformers().clear();
				return;
			case MoviesPackage.SERIES__PRODUCTION_COUNTRY:
				setProductionCountry(PRODUCTION_COUNTRY_EDEFAULT);
				return;
			case MoviesPackage.SERIES__LOANED:
				setLoaned(LOANED_EDEFAULT);
				return;
			case MoviesPackage.SERIES__LOANED_UNTIL:
				setLoanedUntil(LOANED_UNTIL_EDEFAULT);
				return;
			case MoviesPackage.SERIES__LOANABLE:
				setLoanable(LOANABLE_EDEFAULT);
				return;
			case MoviesPackage.SERIES__ALLPARTSLOANABLE:
				setAllpartsloanable(ALLPARTSLOANABLE_EDEFAULT);
				return;
			case MoviesPackage.SERIES__ALLPARTSLOANED:
				setAllpartsloaned(ALLPARTSLOANED_EDEFAULT);
				return;
			case MoviesPackage.SERIES__PARTSLOANED:
				setPartsloaned(PARTSLOANED_EDEFAULT);
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
			case MoviesPackage.SERIES__TITLE:
				return TITLE_EDEFAULT == null ? title != null : !TITLE_EDEFAULT.equals(title);
			case MoviesPackage.SERIES__STUDIO:
				return STUDIO_EDEFAULT == null ? studio != null : !STUDIO_EDEFAULT.equals(studio);
			case MoviesPackage.SERIES__BROADCASTED_BY:
				return BROADCASTED_BY_EDEFAULT == null ? broadcastedBy != null : !BROADCASTED_BY_EDEFAULT.equals(broadcastedBy);
			case MoviesPackage.SERIES__RELEASE_DATE:
				return RELEASE_DATE_EDEFAULT == null ? releaseDate != null : !RELEASE_DATE_EDEFAULT.equals(releaseDate);
			case MoviesPackage.SERIES__SEASONS:
				return seasons != null && !seasons.isEmpty();
			case MoviesPackage.SERIES__RATING:
				return isSetRating();
			case MoviesPackage.SERIES__PERFORMERS:
				return performers != null && !performers.isEmpty();
			case MoviesPackage.SERIES__PRODUCTION_COUNTRY:
				return PRODUCTION_COUNTRY_EDEFAULT == null ? productionCountry != null : !PRODUCTION_COUNTRY_EDEFAULT.equals(productionCountry);
			case MoviesPackage.SERIES__LOANED:
				return loaned != LOANED_EDEFAULT;
			case MoviesPackage.SERIES__LOANED_UNTIL:
				return LOANED_UNTIL_EDEFAULT == null ? loanedUntil != null : !LOANED_UNTIL_EDEFAULT.equals(loanedUntil);
			case MoviesPackage.SERIES__LOANABLE:
				return loanable != LOANABLE_EDEFAULT;
			case MoviesPackage.SERIES__ALLPARTSLOANABLE:
				return allpartsloanable != ALLPARTSLOANABLE_EDEFAULT;
			case MoviesPackage.SERIES__ALLPARTSLOANED:
				return allpartsloaned != ALLPARTSLOANED_EDEFAULT;
			case MoviesPackage.SERIES__PARTSLOANED:
				return partsloaned != PARTSLOANED_EDEFAULT;
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
		result.append(", studio: ");
		result.append(studio);
		result.append(", broadcastedBy: ");
		result.append(broadcastedBy);
		result.append(", releaseDate: ");
		result.append(releaseDate);
		result.append(", Rating: ");
		if (ratingESet) result.append(rating); else result.append("<unset>");
		result.append(", productionCountry: ");
		result.append(productionCountry);
		result.append(", loaned: ");
		result.append(loaned);
		result.append(", loanedUntil: ");
		result.append(loanedUntil);
		result.append(", loanable: ");
		result.append(loanable);
		result.append(", allpartsloanable: ");
		result.append(allpartsloanable);
		result.append(", allpartsloaned: ");
		result.append(allpartsloaned);
		result.append(", partsloaned: ");
		result.append(partsloaned);
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
	 * @generated NOT
	 */
	public void setLoanable(boolean newLoanable) {
		if (!newLoanable && isLoaned()){
			throw new RuntimeException("Error : serie is loaned.");
		}
		boolean oldLoanable = loanable;
		loanable = newLoanable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MoviesPackage.SERIES__LOANABLE, oldLoanable, loanable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isAllpartsloanable() {
		return allpartsloanable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAllpartsloanable(boolean newAllpartsloanable) {
		boolean oldAllpartsloanable = allpartsloanable;
		allpartsloanable = newAllpartsloanable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MoviesPackage.SERIES__ALLPARTSLOANABLE, oldAllpartsloanable, allpartsloanable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isAllpartsloaned() {
		return allpartsloaned;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAllpartsloaned(boolean newAllpartsloaned) {
		boolean oldAllpartsloaned = allpartsloaned;
		allpartsloaned = newAllpartsloaned;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MoviesPackage.SERIES__ALLPARTSLOANED, oldAllpartsloaned, allpartsloaned));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isPartsloaned() {
		return partsloaned;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPartsloaned(boolean newPartsloaned) {
		boolean oldPartsloaned = partsloaned;
		partsloaned = newPartsloaned;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MoviesPackage.SERIES__PARTSLOANED, oldPartsloaned, partsloaned));
	}
	
} //SeriesImpl
