/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package movies.impl;

import java.util.Collection;
import java.util.Map;

import movies.Gender;
import movies.Movie;
import movies.MoviesPackage;
import movies.Performer;
import movies.Rating;
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

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Performer</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link movies.impl.PerformerImpl#getName <em>Name</em>}</li>
 *   <li>{@link movies.impl.PerformerImpl#getGender <em>Gender</em>}</li>
 *   <li>{@link movies.impl.PerformerImpl#getRating <em>Rating</em>}</li>
 *   <li>{@link movies.impl.PerformerImpl#getMovies <em>Movies</em>}</li>
 *   <li>{@link movies.impl.PerformerImpl#getOfdbID <em>Ofdb ID</em>}</li>
 *   <li>{@link movies.impl.PerformerImpl#isLoanable <em>Loanable</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PerformerImpl extends EObjectImpl implements Performer {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getGender() <em>Gender</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGender()
	 * @generated
	 * @ordered
	 */
	protected static final Gender GENDER_EDEFAULT = Gender.MALE;

	/**
	 * The cached value of the '{@link #getGender() <em>Gender</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGender()
	 * @generated
	 * @ordered
	 */
	protected Gender gender = GENDER_EDEFAULT;

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
	 * The cached value of the '{@link #getMovies() <em>Movies</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMovies()
	 * @generated
	 * @ordered
	 */
	protected EList<Movie> movies;

	/**
	 * The default value of the '{@link #getOfdbID() <em>Ofdb ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOfdbID()
	 * @generated
	 * @ordered
	 */
	protected static final String OFDB_ID_EDEFAULT = null;

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
	protected PerformerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MoviesPackage.Literals.PERFORMER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MoviesPackage.PERFORMER__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Gender getGender() {
		return gender;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGender(Gender newGender) {
		Gender oldGender = gender;
		gender = newGender == null ? GENDER_EDEFAULT : newGender;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MoviesPackage.PERFORMER__GENDER, oldGender, gender));
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
			eNotify(new ENotificationImpl(this, Notification.SET, MoviesPackage.PERFORMER__RATING, oldRating, rating));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Movie> getMovies() {
		if (movies == null) {
			movies = new EObjectWithInverseResolvingEList.ManyInverse<Movie>(Movie.class, this, MoviesPackage.PERFORMER__MOVIES, MoviesPackage.MOVIE__PERFORMERS);
		}
		return movies;
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
			eNotify(new ENotificationImpl(this, Notification.SET, MoviesPackage.PERFORMER__OFDB_ID, oldOfdbID, ofdbID));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
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
			eNotify(new ENotificationImpl(this, Notification.SET, MoviesPackage.PERFORMER__LOANABLE, oldLoanable, loanable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean hasName(DiagnosticChain DiagnosticianChain, Map<?, ?> Context) {
		// TODO: implement this method
		// -> specify the condition that violates the invariant
		// -> verify the details of the diagnostic, including severity and message
		// Ensure that you remove @generated or mark it @generated NOT
		if (name == null || name.length() == 0 || name.trim().equals("")) {
			if (DiagnosticianChain != null) {
				DiagnosticianChain.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						 "Performer Name",
						 MoviesValidator.PERFORMER__HAS_NAME,
						 "Enter a name!", new Object [] { this, MoviesPackage.eINSTANCE.getPerformer_Name() }));
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
	public boolean hasMovies(DiagnosticChain DiagnosticianChain, Map<?, ?> Context) {
		// TODO: implement this method
		// -> specify the condition that violates the invariant
		// -> verify the details of the diagnostic, including severity and message
		// Ensure that you remove @generated or mark it @generated NOT
		if (movies.size() == 0) {
			if (DiagnosticianChain != null) {
				DiagnosticianChain.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						 "Performer Movies",
						 MoviesValidator.PERFORMER__HAS_MOVIES,
						 "Link Movies!", new Object[] { this, MoviesPackage.eINSTANCE.getPerformer_Movies() }));
						
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
			case MoviesPackage.PERFORMER__MOVIES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getMovies()).basicAdd(otherEnd, msgs);
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
			case MoviesPackage.PERFORMER__MOVIES:
				return ((InternalEList<?>)getMovies()).basicRemove(otherEnd, msgs);
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
			case MoviesPackage.PERFORMER__NAME:
				return getName();
			case MoviesPackage.PERFORMER__GENDER:
				return getGender();
			case MoviesPackage.PERFORMER__RATING:
				return getRating();
			case MoviesPackage.PERFORMER__MOVIES:
				return getMovies();
			case MoviesPackage.PERFORMER__OFDB_ID:
				return getOfdbID();
			case MoviesPackage.PERFORMER__LOANABLE:
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
			case MoviesPackage.PERFORMER__NAME:
				setName((String)newValue);
				return;
			case MoviesPackage.PERFORMER__GENDER:
				setGender((Gender)newValue);
				return;
			case MoviesPackage.PERFORMER__RATING:
				setRating((Rating)newValue);
				return;
			case MoviesPackage.PERFORMER__MOVIES:
				getMovies().clear();
				getMovies().addAll((Collection<? extends Movie>)newValue);
				return;
			case MoviesPackage.PERFORMER__OFDB_ID:
				setOfdbID((String)newValue);
				return;
			case MoviesPackage.PERFORMER__LOANABLE:
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
			case MoviesPackage.PERFORMER__NAME:
				setName(NAME_EDEFAULT);
				return;
			case MoviesPackage.PERFORMER__GENDER:
				setGender(GENDER_EDEFAULT);
				return;
			case MoviesPackage.PERFORMER__RATING:
				setRating(RATING_EDEFAULT);
				return;
			case MoviesPackage.PERFORMER__MOVIES:
				getMovies().clear();
				return;
			case MoviesPackage.PERFORMER__OFDB_ID:
				setOfdbID(OFDB_ID_EDEFAULT);
				return;
			case MoviesPackage.PERFORMER__LOANABLE:
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
			case MoviesPackage.PERFORMER__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case MoviesPackage.PERFORMER__GENDER:
				return gender != GENDER_EDEFAULT;
			case MoviesPackage.PERFORMER__RATING:
				return rating != RATING_EDEFAULT;
			case MoviesPackage.PERFORMER__MOVIES:
				return movies != null && !movies.isEmpty();
			case MoviesPackage.PERFORMER__OFDB_ID:
				return OFDB_ID_EDEFAULT == null ? ofdbID != null : !OFDB_ID_EDEFAULT.equals(ofdbID);
			case MoviesPackage.PERFORMER__LOANABLE:
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
		result.append(" (name: ");
		result.append(name);
		result.append(", gender: ");
		result.append(gender);
		result.append(", rating: ");
		result.append(rating);
		result.append(", OfdbID: ");
		result.append(ofdbID);
		result.append(", loanable: ");
		result.append(loanable);
		result.append(')');
		return result.toString();
	}

} //PerformerImpl
