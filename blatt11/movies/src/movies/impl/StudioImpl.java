/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package movies.impl;

import java.util.Collection;
import java.util.Date;

import movies.Movie;
import movies.MoviesPackage;
import movies.Studio;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Studio</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link movies.impl.StudioImpl#getName <em>Name</em>}</li>
 *   <li>{@link movies.impl.StudioImpl#getFounded <em>Founded</em>}</li>
 *   <li>{@link movies.impl.StudioImpl#getProducedMovies <em>Produced Movies</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class StudioImpl extends EObjectImpl implements Studio {
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
	 * The default value of the '{@link #getFounded() <em>Founded</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFounded()
	 * @generated
	 * @ordered
	 */
	protected static final Date FOUNDED_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFounded() <em>Founded</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFounded()
	 * @generated
	 * @ordered
	 */
	protected Date founded = FOUNDED_EDEFAULT;

	/**
	 * The cached value of the '{@link #getProducedMovies() <em>Produced Movies</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProducedMovies()
	 * @generated
	 * @ordered
	 */
	protected EList<Movie> producedMovies;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StudioImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MoviesPackage.Literals.STUDIO;
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
			eNotify(new ENotificationImpl(this, Notification.SET, MoviesPackage.STUDIO__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Date getFounded() {
		return founded;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFounded(Date newFounded) {
		Date oldFounded = founded;
		founded = newFounded;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MoviesPackage.STUDIO__FOUNDED, oldFounded, founded));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Movie> getProducedMovies() {
		if (producedMovies == null) {
			producedMovies = new EObjectResolvingEList<Movie>(Movie.class, this, MoviesPackage.STUDIO__PRODUCED_MOVIES);
		}
		return producedMovies;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MoviesPackage.STUDIO__NAME:
				return getName();
			case MoviesPackage.STUDIO__FOUNDED:
				return getFounded();
			case MoviesPackage.STUDIO__PRODUCED_MOVIES:
				return getProducedMovies();
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
			case MoviesPackage.STUDIO__NAME:
				setName((String)newValue);
				return;
			case MoviesPackage.STUDIO__FOUNDED:
				setFounded((Date)newValue);
				return;
			case MoviesPackage.STUDIO__PRODUCED_MOVIES:
				getProducedMovies().clear();
				getProducedMovies().addAll((Collection<? extends Movie>)newValue);
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
			case MoviesPackage.STUDIO__NAME:
				setName(NAME_EDEFAULT);
				return;
			case MoviesPackage.STUDIO__FOUNDED:
				setFounded(FOUNDED_EDEFAULT);
				return;
			case MoviesPackage.STUDIO__PRODUCED_MOVIES:
				getProducedMovies().clear();
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
			case MoviesPackage.STUDIO__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case MoviesPackage.STUDIO__FOUNDED:
				return FOUNDED_EDEFAULT == null ? founded != null : !FOUNDED_EDEFAULT.equals(founded);
			case MoviesPackage.STUDIO__PRODUCED_MOVIES:
				return producedMovies != null && !producedMovies.isEmpty();
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
		result.append(", founded: ");
		result.append(founded);
		result.append(')');
		return result.toString();
	}

} //StudioImpl
