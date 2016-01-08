/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package movies.util;

import java.util.Map;

import movies.*;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.EObjectValidator;

/**
 * <!-- begin-user-doc -->
 * The <b>Validator</b> for the model.
 * <!-- end-user-doc -->
 * @see movies.MoviesPackage
 * @generated
 */
public class MoviesValidator extends EObjectValidator {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final MoviesValidator INSTANCE = new MoviesValidator();

	/**
	 * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.Diagnostic#getSource()
	 * @see org.eclipse.emf.common.util.Diagnostic#getCode()
	 * @generated
	 */
	public static final String DIAGNOSTIC_SOURCE = "movies";

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Has Title' of 'Movie'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int MOVIE__HAS_TITLE = 1;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Has Time' of 'Movie'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int MOVIE__HAS_TIME = 2;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Has Movies' of 'Movie Collection'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int MOVIE_COLLECTION__HAS_MOVIES = 3;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Has Name' of 'Performer'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int PERFORMER__HAS_NAME = 4;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Has Movies' of 'Performer'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int PERFORMER__HAS_MOVIES = 5;

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final int GENERATED_DIAGNOSTIC_CODE_COUNT = 5;

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants in a derived class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final int DIAGNOSTIC_CODE_COUNT = GENERATED_DIAGNOSTIC_CODE_COUNT;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MoviesValidator() {
		super();
	}

	/**
	 * Returns the package of this validator switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EPackage getEPackage() {
	  return MoviesPackage.eINSTANCE;
	}

	/**
	 * Calls <code>validateXXX</code> for the corresponding classifier of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected boolean validate(int classifierID, Object value, DiagnosticChain diagnostics, Map<Object, Object> context) {
		switch (classifierID) {
			case MoviesPackage.MOVIE:
				return validateMovie((Movie)value, diagnostics, context);
			case MoviesPackage.MOVIE_COLLECTION:
				return validateMovieCollection((MovieCollection)value, diagnostics, context);
			case MoviesPackage.PERFORMER:
				return validatePerformer((Performer)value, diagnostics, context);
			case MoviesPackage.SERIES:
				return validateSeries((Series)value, diagnostics, context);
			case MoviesPackage.SEASON:
				return validateSeason((Season)value, diagnostics, context);
			case MoviesPackage.EPISODE:
				return validateEpisode((Episode)value, diagnostics, context);
			case MoviesPackage.DIRECTOR:
				return validateDirector((Director)value, diagnostics, context);
			case MoviesPackage.STUDIO:
				return validateStudio((Studio)value, diagnostics, context);
			case MoviesPackage.MOVIE_CATEGORY:
				return validateMovieCategory((MovieCategory)value, diagnostics, context);
			case MoviesPackage.GENDER:
				return validateGender((Gender)value, diagnostics, context);
			case MoviesPackage.RATING:
				return validateRating((Rating)value, diagnostics, context);
			default:
				return true;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMovie(Movie movie, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(movie, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(movie, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(movie, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(movie, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(movie, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(movie, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(movie, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(movie, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(movie, diagnostics, context);
		if (result || diagnostics != null) result &= validateMovie_hasTitle(movie, diagnostics, context);
		if (result || diagnostics != null) result &= validateMovie_hasTime(movie, diagnostics, context);
		return result;
	}

	/**
	 * Validates the hasTitle constraint of '<em>Movie</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMovie_hasTitle(Movie movie, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return movie.hasTitle(diagnostics, context);
	}

	/**
	 * Validates the hasTime constraint of '<em>Movie</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMovie_hasTime(Movie movie, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return movie.hasTime(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMovieCollection(MovieCollection movieCollection, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(movieCollection, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(movieCollection, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(movieCollection, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(movieCollection, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(movieCollection, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(movieCollection, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(movieCollection, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(movieCollection, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(movieCollection, diagnostics, context);
		if (result || diagnostics != null) result &= validateMovieCollection_hasMovies(movieCollection, diagnostics, context);
		return result;
	}

	/**
	 * Validates the hasMovies constraint of '<em>Movie Collection</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMovieCollection_hasMovies(MovieCollection movieCollection, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return movieCollection.hasMovies(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePerformer(Performer performer, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(performer, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(performer, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(performer, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(performer, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(performer, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(performer, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(performer, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(performer, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(performer, diagnostics, context);
		if (result || diagnostics != null) result &= validatePerformer_hasName(performer, diagnostics, context);
		if (result || diagnostics != null) result &= validatePerformer_hasMovies(performer, diagnostics, context);
		return result;
	}

	/**
	 * Validates the hasName constraint of '<em>Performer</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePerformer_hasName(Performer performer, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return performer.hasName(diagnostics, context);
	}

	/**
	 * Validates the hasMovies constraint of '<em>Performer</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePerformer_hasMovies(Performer performer, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return performer.hasMovies(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSeries(Series series, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(series, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSeason(Season season, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(season, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEpisode(Episode episode, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(episode, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(episode, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(episode, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(episode, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(episode, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(episode, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(episode, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(episode, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(episode, diagnostics, context);
		if (result || diagnostics != null) result &= validateMovie_hasTitle(episode, diagnostics, context);
		if (result || diagnostics != null) result &= validateMovie_hasTime(episode, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDirector(Director director, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(director, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(director, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(director, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(director, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(director, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(director, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(director, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(director, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(director, diagnostics, context);
		if (result || diagnostics != null) result &= validatePerformer_hasName(director, diagnostics, context);
		if (result || diagnostics != null) result &= validatePerformer_hasMovies(director, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateStudio(Studio studio, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(studio, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMovieCategory(MovieCategory movieCategory, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateGender(Gender gender, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRating(Rating rating, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * Returns the resource locator that will be used to fetch messages for this validator's diagnostics.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		// TODO
		// Specialize this to return a resource locator for messages specific to this validator.
		// Ensure that you remove @generated or mark it @generated NOT
		return super.getResourceLocator();
	}

} //MoviesValidator
