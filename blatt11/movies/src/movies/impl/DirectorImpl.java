/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package movies.impl;

import java.util.Collection;

import movies.Director;
import movies.Movie;
import movies.MoviesPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Director</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link movies.impl.DirectorImpl#getNumDirectedMovies <em>Num Directed Movies</em>}</li>
 *   <li>{@link movies.impl.DirectorImpl#getMoviesDirected <em>Movies Directed</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DirectorImpl extends PerformerImpl implements Director {
	/**
	 * The default value of the '{@link #getNumDirectedMovies() <em>Num Directed Movies</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumDirectedMovies()
	 * @generated
	 * @ordered
	 */
	protected static final int NUM_DIRECTED_MOVIES_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getNumDirectedMovies() <em>Num Directed Movies</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumDirectedMovies()
	 * @generated
	 * @ordered
	 */
	protected int numDirectedMovies = NUM_DIRECTED_MOVIES_EDEFAULT;

	/**
	 * The cached value of the '{@link #getMoviesDirected() <em>Movies Directed</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMoviesDirected()
	 * @generated
	 * @ordered
	 */
	protected EList<Movie> moviesDirected;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DirectorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MoviesPackage.Literals.DIRECTOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getNumDirectedMovies() {
		return numDirectedMovies;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNumDirectedMovies(int newNumDirectedMovies) {
		int oldNumDirectedMovies = numDirectedMovies;
		numDirectedMovies = newNumDirectedMovies;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MoviesPackage.DIRECTOR__NUM_DIRECTED_MOVIES, oldNumDirectedMovies, numDirectedMovies));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Movie> getMoviesDirected() {
		if (moviesDirected == null) {
			moviesDirected = new EObjectResolvingEList<Movie>(Movie.class, this, MoviesPackage.DIRECTOR__MOVIES_DIRECTED);
		}
		return moviesDirected;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MoviesPackage.DIRECTOR__NUM_DIRECTED_MOVIES:
				return getNumDirectedMovies();
			case MoviesPackage.DIRECTOR__MOVIES_DIRECTED:
				return getMoviesDirected();
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
			case MoviesPackage.DIRECTOR__NUM_DIRECTED_MOVIES:
				setNumDirectedMovies((Integer)newValue);
				return;
			case MoviesPackage.DIRECTOR__MOVIES_DIRECTED:
				getMoviesDirected().clear();
				getMoviesDirected().addAll((Collection<? extends Movie>)newValue);
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
			case MoviesPackage.DIRECTOR__NUM_DIRECTED_MOVIES:
				setNumDirectedMovies(NUM_DIRECTED_MOVIES_EDEFAULT);
				return;
			case MoviesPackage.DIRECTOR__MOVIES_DIRECTED:
				getMoviesDirected().clear();
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
			case MoviesPackage.DIRECTOR__NUM_DIRECTED_MOVIES:
				return numDirectedMovies != NUM_DIRECTED_MOVIES_EDEFAULT;
			case MoviesPackage.DIRECTOR__MOVIES_DIRECTED:
				return moviesDirected != null && !moviesDirected.isEmpty();
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
		result.append(" (numDirectedMovies: ");
		result.append(numDirectedMovies);
		result.append(')');
		return result.toString();
	}

} //DirectorImpl
