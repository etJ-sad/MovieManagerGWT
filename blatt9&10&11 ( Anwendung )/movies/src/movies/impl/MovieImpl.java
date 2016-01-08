/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package movies.impl;

import java.util.Collection;
import java.util.Date;
import java.util.Map;



import movies.Episode;
import movies.Movie;
import movies.MovieCategory;
import movies.MovieCollection;
import movies.MoviesPackage;
import movies.Performer;
import movies.Rating;
import movies.Season;
import movies.Series;
import movies.util.MoviesValidator;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.emf.emfstore.client.model.util.EMFStoreCommand;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Movie</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link movies.impl.MovieImpl#getTitle <em>Title</em>}</li>
 *   <li>{@link movies.impl.MovieImpl#getTitle_orig <em>Title orig</em>}</li>
 *   <li>{@link movies.impl.MovieImpl#getTime <em>Time</em>}</li>
 *   <li>{@link movies.impl.MovieImpl#getCategory <em>Category</em>}</li>
 *   <li>{@link movies.impl.MovieImpl#getRating <em>Rating</em>}</li>
 *   <li>{@link movies.impl.MovieImpl#getOverallRating <em>Overall Rating</em>}</li>
 *   <li>{@link movies.impl.MovieImpl#getLastWatchDate <em>Last Watch Date</em>}</li>
 *   <li>{@link movies.impl.MovieImpl#isLoaned <em>Loaned</em>}</li>
 *   <li>{@link movies.impl.MovieImpl#getLoanedUntil <em>Loaned Until</em>}</li>
 *   <li>{@link movies.impl.MovieImpl#isLoanable <em>Loanable</em>}</li>
 *   <li>{@link movies.impl.MovieImpl#getPerformers <em>Performers</em>}</li>
 *   <li>{@link movies.impl.MovieImpl#getMovieCollections <em>Movie Collections</em>}</li>
 *   <li>{@link movies.impl.MovieImpl#getImdbUrl <em>Imdb Url</em>}</li>
 *   <li>{@link movies.impl.MovieImpl#getOfdbID <em>Ofdb ID</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MovieImpl extends EObjectImpl implements Movie {
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
	 * The default value of the '{@link #getTitle_orig() <em>Title orig</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTitle_orig()
	 * @generated
	 * @ordered
	 */
	protected static final String TITLE_ORIG_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTitle_orig() <em>Title orig</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTitle_orig()
	 * @generated
	 * @ordered
	 */
	protected String title_orig = TITLE_ORIG_EDEFAULT;

	/**
	 * The default value of the '{@link #getTime() <em>Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTime()
	 * @generated
	 * @ordered
	 */
	protected static final int TIME_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getTime() <em>Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTime()
	 * @generated
	 * @ordered
	 */
	protected int time = TIME_EDEFAULT;

	/**
	 * The default value of the '{@link #getCategory() <em>Category</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCategory()
	 * @generated
	 * @ordered
	 */
	protected static final MovieCategory CATEGORY_EDEFAULT = MovieCategory.ACTION;

	/**
	 * The cached value of the '{@link #getCategory() <em>Category</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCategory()
	 * @generated
	 * @ordered
	 */
	protected MovieCategory category = CATEGORY_EDEFAULT;

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
	 * The default value of the '{@link #getOverallRating() <em>Overall Rating</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOverallRating()
	 * @generated
	 * @ordered
	 */
	protected static final String OVERALL_RATING_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getOverallRating() <em>Overall Rating</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOverallRating()
	 * @generated
	 * @ordered
	 */
	protected String overallRating = OVERALL_RATING_EDEFAULT;

	/**
	 * The default value of the '{@link #getLastWatchDate() <em>Last Watch Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLastWatchDate()
	 * @generated
	 * @ordered
	 */
	protected static final Date LAST_WATCH_DATE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLastWatchDate() <em>Last Watch Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLastWatchDate()
	 * @generated
	 * @ordered
	 */
	protected Date lastWatchDate = LAST_WATCH_DATE_EDEFAULT;

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
	 * The cached value of the '{@link #getPerformers() <em>Performers</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPerformers()
	 * @generated
	 * @ordered
	 */
	protected EList<Performer> performers;

	/**
	 * The cached value of the '{@link #getMovieCollections() <em>Movie Collections</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMovieCollections()
	 * @generated
	 * @ordered
	 */
	protected EList<MovieCollection> movieCollections;

	/**
	 * The default value of the '{@link #getImdbUrl() <em>Imdb Url</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImdbUrl()
	 * @generated
	 * @ordered
	 */
	protected static final String IMDB_URL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getImdbUrl() <em>Imdb Url</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImdbUrl()
	 * @generated
	 * @ordered
	 */
	protected String imdbUrl = IMDB_URL_EDEFAULT;

	/**
	 * The default value of the '{@link #getOfdbID() <em>Ofdb ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOfdbID()
	 * @generated
	 * @ordered
	 */
	protected static final String OFDB_ID_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getOfdbID() <em>Ofdb ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOfdbID()
	 * @generated
	 * @ordered
	 */
	protected String ofdbID = OFDB_ID_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MovieImpl() {
		super();
	}


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MoviesPackage.Literals.MOVIE;
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
			eNotify(new ENotificationImpl(this, Notification.SET, MoviesPackage.MOVIE__TITLE, oldTitle, title));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTitle_orig() {
		return title_orig;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTitle_orig(String newTitle_orig) {
		String oldTitle_orig = title_orig;
		title_orig = newTitle_orig;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MoviesPackage.MOVIE__TITLE_ORIG, oldTitle_orig, title_orig));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getTime() {
		return time;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTime(int newTime) {
		int oldTime = time;
		time = newTime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MoviesPackage.MOVIE__TIME, oldTime, time));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MovieCategory getCategory() {
		return category;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCategory(MovieCategory newCategory) {
		MovieCategory oldCategory = category;
		category = newCategory == null ? CATEGORY_EDEFAULT : newCategory;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MoviesPackage.MOVIE__CATEGORY, oldCategory, category));
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
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MoviesPackage.MOVIE__RATING, oldRating, rating));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getOverallRating() {
		return overallRating;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOverallRating(String newOverallRating) {
		String oldOverallRating = overallRating;
		overallRating = newOverallRating;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MoviesPackage.MOVIE__OVERALL_RATING, oldOverallRating, overallRating));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Date getLastWatchDate() {
		return lastWatchDate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLastWatchDate(Date newLastWatchDate) {
		Date oldLastWatchDate = lastWatchDate;
		lastWatchDate = newLastWatchDate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MoviesPackage.MOVIE__LAST_WATCH_DATE, oldLastWatchDate, lastWatchDate));
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
			eNotify(new ENotificationImpl(this, Notification.SET, MoviesPackage.MOVIE__LOANED, oldLoaned, loaned));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Performer> getPerformers() {
		if (performers == null) {
			performers = new EObjectWithInverseResolvingEList.ManyInverse<Performer>(Performer.class, this, MoviesPackage.MOVIE__PERFORMERS, MoviesPackage.PERFORMER__MOVIES);
		}
		return performers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<MovieCollection> getMovieCollections() {
		if (movieCollections == null) {
			movieCollections = new EObjectWithInverseResolvingEList.ManyInverse<MovieCollection>(MovieCollection.class, this, MoviesPackage.MOVIE__MOVIE_COLLECTIONS, MoviesPackage.MOVIE_COLLECTION__MOVIES);
		}
		return movieCollections;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getImdbUrl() {
		return imdbUrl;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setImdbUrl(String newImdbUrl) {
		String oldImdbUrl = imdbUrl;
		imdbUrl = newImdbUrl;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MoviesPackage.MOVIE__IMDB_URL, oldImdbUrl, imdbUrl));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getOfdbID() {
		return ofdbID;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOfdbID(String newOfdbID) {
		String oldOfdbID = ofdbID;
		ofdbID = newOfdbID;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MoviesPackage.MOVIE__OFDB_ID, oldOfdbID, ofdbID));
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
			eNotify(new ENotificationImpl(this, Notification.SET, MoviesPackage.MOVIE__LOANED_UNTIL, oldLoanedUntil, loanedUntil));
	}


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean hasTitle(DiagnosticChain DiagnosticianChain, Map<?, ?> Context) {
		// TODO: implement this method
		// -> specify the condition that violates the invariant
		// -> verify the details of the diagnostic, including severity and message
		// Ensure that you remove @generated or mark it @generated NOT
		if (title == null || title.length() == 0 || title.trim().equals("")) {
			if (DiagnosticianChain != null) {
				DiagnosticianChain.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						 "Movie Title",
						 MoviesValidator.MOVIE__HAS_TITLE,
						 "Enter a title!", new Object[] { this, MoviesPackage.eINSTANCE.getMovie_Title() }));
						 
			}
			return false;
		}
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean hasTime(DiagnosticChain DiagnosticianChain, Map<?, ?> Context) {
		// TODO: implement this method
		// -> specify the condition that violates the invariant
		// -> verify the details of the diagnostic, including severity and message
		// Ensure that you remove @generated or mark it @generated NOT
		if (time == 0) {
			if (DiagnosticianChain != null) {
				DiagnosticianChain.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						 "Movie Time",
						 MoviesValidator.MOVIE__HAS_TIME,
						 "Enter a time!", new Object[] { this, MoviesPackage.eINSTANCE.getMovie_Time() }));
			}
			return false;
		}
		return true;
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
			case MoviesPackage.MOVIE__PERFORMERS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getPerformers()).basicAdd(otherEnd, msgs);
			case MoviesPackage.MOVIE__MOVIE_COLLECTIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getMovieCollections()).basicAdd(otherEnd, msgs);
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
			case MoviesPackage.MOVIE__PERFORMERS:
				return ((InternalEList<?>)getPerformers()).basicRemove(otherEnd, msgs);
			case MoviesPackage.MOVIE__MOVIE_COLLECTIONS:
				return ((InternalEList<?>)getMovieCollections()).basicRemove(otherEnd, msgs);
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
			case MoviesPackage.MOVIE__TITLE:
				return getTitle();
			case MoviesPackage.MOVIE__TITLE_ORIG:
				return getTitle_orig();
			case MoviesPackage.MOVIE__TIME:
				return getTime();
			case MoviesPackage.MOVIE__CATEGORY:
				return getCategory();
			case MoviesPackage.MOVIE__RATING:
				return getRating();
			case MoviesPackage.MOVIE__OVERALL_RATING:
				return getOverallRating();
			case MoviesPackage.MOVIE__LAST_WATCH_DATE:
				return getLastWatchDate();
			case MoviesPackage.MOVIE__LOANED:
				return isLoaned();
			case MoviesPackage.MOVIE__LOANED_UNTIL:
				return getLoanedUntil();
			case MoviesPackage.MOVIE__LOANABLE:
				return isLoanable();
			case MoviesPackage.MOVIE__PERFORMERS:
				return getPerformers();
			case MoviesPackage.MOVIE__MOVIE_COLLECTIONS:
				return getMovieCollections();
			case MoviesPackage.MOVIE__IMDB_URL:
				return getImdbUrl();
			case MoviesPackage.MOVIE__OFDB_ID:
				return getOfdbID();
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
			case MoviesPackage.MOVIE__TITLE:
				setTitle((String)newValue);
				return;
			case MoviesPackage.MOVIE__TITLE_ORIG:
				setTitle_orig((String)newValue);
				return;
			case MoviesPackage.MOVIE__TIME:
				setTime((Integer)newValue);
				return;
			case MoviesPackage.MOVIE__CATEGORY:
				setCategory((MovieCategory)newValue);
				return;
			case MoviesPackage.MOVIE__RATING:
				setRating((Rating)newValue);
				return;
			case MoviesPackage.MOVIE__OVERALL_RATING:
				setOverallRating((String)newValue);
				return;
			case MoviesPackage.MOVIE__LAST_WATCH_DATE:
				setLastWatchDate((Date)newValue);
				return;
			case MoviesPackage.MOVIE__LOANED:
				setLoaned((Boolean)newValue);
				return;
			case MoviesPackage.MOVIE__LOANED_UNTIL:
				setLoanedUntil((Date)newValue);
				return;
			case MoviesPackage.MOVIE__LOANABLE:
				setLoanable((Boolean)newValue);
				return;
			case MoviesPackage.MOVIE__PERFORMERS:
				getPerformers().clear();
				getPerformers().addAll((Collection<? extends Performer>)newValue);
				return;
			case MoviesPackage.MOVIE__MOVIE_COLLECTIONS:
				getMovieCollections().clear();
				getMovieCollections().addAll((Collection<? extends MovieCollection>)newValue);
				return;
			case MoviesPackage.MOVIE__IMDB_URL:
				setImdbUrl((String)newValue);
				return;
			case MoviesPackage.MOVIE__OFDB_ID:
				setOfdbID((String)newValue);
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
			case MoviesPackage.MOVIE__TITLE:
				setTitle(TITLE_EDEFAULT);
				return;
			case MoviesPackage.MOVIE__TITLE_ORIG:
				setTitle_orig(TITLE_ORIG_EDEFAULT);
				return;
			case MoviesPackage.MOVIE__TIME:
				setTime(TIME_EDEFAULT);
				return;
			case MoviesPackage.MOVIE__CATEGORY:
				setCategory(CATEGORY_EDEFAULT);
				return;
			case MoviesPackage.MOVIE__RATING:
				setRating(RATING_EDEFAULT);
				return;
			case MoviesPackage.MOVIE__OVERALL_RATING:
				setOverallRating(OVERALL_RATING_EDEFAULT);
				return;
			case MoviesPackage.MOVIE__LAST_WATCH_DATE:
				setLastWatchDate(LAST_WATCH_DATE_EDEFAULT);
				return;
			case MoviesPackage.MOVIE__LOANED:
				setLoaned(LOANED_EDEFAULT);
				return;
			case MoviesPackage.MOVIE__LOANED_UNTIL:
				setLoanedUntil(LOANED_UNTIL_EDEFAULT);
				return;
			case MoviesPackage.MOVIE__LOANABLE:
				setLoanable(LOANABLE_EDEFAULT);
				return;
			case MoviesPackage.MOVIE__PERFORMERS:
				getPerformers().clear();
				return;
			case MoviesPackage.MOVIE__MOVIE_COLLECTIONS:
				getMovieCollections().clear();
				return;
			case MoviesPackage.MOVIE__IMDB_URL:
				setImdbUrl(IMDB_URL_EDEFAULT);
				return;
			case MoviesPackage.MOVIE__OFDB_ID:
				setOfdbID(OFDB_ID_EDEFAULT);
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
			case MoviesPackage.MOVIE__TITLE:
				return TITLE_EDEFAULT == null ? title != null : !TITLE_EDEFAULT.equals(title);
			case MoviesPackage.MOVIE__TITLE_ORIG:
				return TITLE_ORIG_EDEFAULT == null ? title_orig != null : !TITLE_ORIG_EDEFAULT.equals(title_orig);
			case MoviesPackage.MOVIE__TIME:
				return time != TIME_EDEFAULT;
			case MoviesPackage.MOVIE__CATEGORY:
				return category != CATEGORY_EDEFAULT;
			case MoviesPackage.MOVIE__RATING:
				return rating != RATING_EDEFAULT;
			case MoviesPackage.MOVIE__OVERALL_RATING:
				return OVERALL_RATING_EDEFAULT == null ? overallRating != null : !OVERALL_RATING_EDEFAULT.equals(overallRating);
			case MoviesPackage.MOVIE__LAST_WATCH_DATE:
				return LAST_WATCH_DATE_EDEFAULT == null ? lastWatchDate != null : !LAST_WATCH_DATE_EDEFAULT.equals(lastWatchDate);
			case MoviesPackage.MOVIE__LOANED:
				return loaned != LOANED_EDEFAULT;
			case MoviesPackage.MOVIE__LOANED_UNTIL:
				return LOANED_UNTIL_EDEFAULT == null ? loanedUntil != null : !LOANED_UNTIL_EDEFAULT.equals(loanedUntil);
			case MoviesPackage.MOVIE__LOANABLE:
				return loanable != LOANABLE_EDEFAULT;
			case MoviesPackage.MOVIE__PERFORMERS:
				return performers != null && !performers.isEmpty();
			case MoviesPackage.MOVIE__MOVIE_COLLECTIONS:
				return movieCollections != null && !movieCollections.isEmpty();
			case MoviesPackage.MOVIE__IMDB_URL:
				return IMDB_URL_EDEFAULT == null ? imdbUrl != null : !IMDB_URL_EDEFAULT.equals(imdbUrl);
			case MoviesPackage.MOVIE__OFDB_ID:
				return OFDB_ID_EDEFAULT == null ? ofdbID != null : !OFDB_ID_EDEFAULT.equals(ofdbID);
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
		result.append(", title_orig: ");
		result.append(title_orig);
		result.append(", time: ");
		result.append(time);
		result.append(", category: ");
		result.append(category);
		result.append(", rating: ");
		result.append(rating);
		result.append(", overallRating: ");
		result.append(overallRating);
		result.append(", lastWatchDate: ");
		result.append(lastWatchDate);
		result.append(", loaned: ");
		result.append(loaned);
		result.append(", loanedUntil: ");
		result.append(loanedUntil);
		result.append(", loanable: ");
		result.append(loanable);
		result.append(", imdbUrl: ");
		result.append(imdbUrl);
		result.append(", ofdbID: ");
		result.append(ofdbID);
		result.append(')');
		return result.toString();
	}


	/**
	 * Check series performer handling.
	 * Is called by the eAdapter
	 *
	 * @param modelElement the model element
	 * @generated NOT
	 */
	public static void checkSeriesPerformerHandling(Movie modelElement){
		if(modelElement instanceof Episode){
			Episode episode = (Episode)modelElement;
			if(episode.getSeason() != null){
				episode.getSeason().getPerformers().addAll(episode.getPerformers());
			}
			if(episode.getSeason() != null && episode.getSeason().getSeries() != null){
				episode.getSeason().getSeries().getPerformers().addAll(episode.getSeason().getPerformers());
			}	
		}
	}


	/**
	 * Check series rating handling.
	 * IS called by the eAdapter
	 *
	 * @param modelElement the model element
	 * @generated NOT
	 */
	public static void checkSeriesRatingHandling(Movie modelElement) {
		if(modelElement instanceof Episode){
			Season s = ((Episode)modelElement).getSeason();
			if (s != null) {
				if(s.getSeries() != null){
					calculateAllSeasonRating(s.getSeries().getSeasons());
					calculateSeriesRating(s.getSeries());
				}
			}
		}
	}


	/**
	 * Calculate all season rating based onthe rating of the contained episodes
	 *
	 * @param seasons the seasons
	 * @generated NOT
	 */
	public static void calculateAllSeasonRating(final EList<Season> seasons){
		new EMFStoreCommand() {
			@Override
			protected void doRun() {
				int sum = 0, number = 0;
				for(Season s: seasons){
					for(Episode e: s.getEpisodes()){
						sum += e.getRating().getValue();
						number++;
					}
					s.setRating(Rating.get(calculateMean(sum,number)));
					sum = 0;
					number = 0;
				}
			}
		}.run();
	}


	/**
	 * Calculate mean.
	 *
	 * @param sum the sum
	 * @param number the number
	 * @return the mean
	 * @generated NOT
	 */
	public static int calculateMean(int sum, int number) {
		if(number > 0){return (sum/number);}
		return 0;
	}


	/**
	 * Calculate series rating based on the rating of the contained seasons
	 *
	 * @param series the series
	 * @generated NOT
	 */
	public static void calculateSeriesRating(final Series series) {
		new EMFStoreCommand() {
			@Override
			protected void doRun() {
				int sum=0, number=0;
				
				for(Season s: series.getSeasons()){
					sum += s.getRating().getValue();
					number += 1;
				}
				series.setRating(Rating.get(MovieImpl.calculateMean(sum, number)));
			}
		}.run();
	}

	/**
	 * @generated NOT
	 */
	@Override
	public boolean isLoanable() {
		return loanable; //false
	}


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setLoanable(boolean newLoanable) {
		if (!newLoanable && isLoaned()){
			throw new RuntimeException("Error : movie is loaned.");
		}
		boolean oldLoanable = loanable;
		loanable = newLoanable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MoviesPackage.MOVIE__LOANABLE, oldLoanable, loanable));
	}

} //MovieImpl
