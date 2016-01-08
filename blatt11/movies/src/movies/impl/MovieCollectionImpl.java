/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package movies.impl;

import java.util.Collection;
import java.util.Map;

import movies.Movie;
import movies.MovieCollection;
import movies.MoviesPackage;
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
 * An implementation of the model object '<em><b>Movie Collection</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link movies.impl.MovieCollectionImpl#getName <em>Name</em>}</li>
 *   <li>{@link movies.impl.MovieCollectionImpl#getMovies <em>Movies</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MovieCollectionImpl extends EObjectImpl implements MovieCollection {
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
	 * The cached value of the '{@link #getMovies() <em>Movies</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMovies()
	 * @generated
	 * @ordered
	 */
	protected EList<Movie> movies;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MovieCollectionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MoviesPackage.Literals.MOVIE_COLLECTION;
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
			eNotify(new ENotificationImpl(this, Notification.SET, MoviesPackage.MOVIE_COLLECTION__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Movie> getMovies() {
		if (movies == null) {
			movies = new EObjectWithInverseResolvingEList.ManyInverse<Movie>(Movie.class, this, MoviesPackage.MOVIE_COLLECTION__MOVIES, MoviesPackage.MOVIE__MOVIE_COLLECTIONS);
		}
		return movies;
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
						 "Movie Collection Movies",
						 MoviesValidator.MOVIE_COLLECTION__HAS_MOVIES,
						 "Link Movies!", new Object[] { this, MoviesPackage.eINSTANCE.getMovieCollection_Movies() }));
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
			case MoviesPackage.MOVIE_COLLECTION__MOVIES:
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
			case MoviesPackage.MOVIE_COLLECTION__MOVIES:
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
			case MoviesPackage.MOVIE_COLLECTION__NAME:
				return getName();
			case MoviesPackage.MOVIE_COLLECTION__MOVIES:
				return getMovies();
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
			case MoviesPackage.MOVIE_COLLECTION__NAME:
				setName((String)newValue);
				return;
			case MoviesPackage.MOVIE_COLLECTION__MOVIES:
				getMovies().clear();
				getMovies().addAll((Collection<? extends Movie>)newValue);
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
			case MoviesPackage.MOVIE_COLLECTION__NAME:
				setName(NAME_EDEFAULT);
				return;
			case MoviesPackage.MOVIE_COLLECTION__MOVIES:
				getMovies().clear();
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
			case MoviesPackage.MOVIE_COLLECTION__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case MoviesPackage.MOVIE_COLLECTION__MOVIES:
				return movies != null && !movies.isEmpty();
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
		result.append(')');
		return result.toString();
	}

} //MovieCollectionImpl
