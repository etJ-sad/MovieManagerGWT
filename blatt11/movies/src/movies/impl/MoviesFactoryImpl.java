/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package movies.impl;

import movies.*;
import movies.Episode;
import movies.Gender;
import movies.Movie;
import movies.MovieCategory;
import movies.MovieCollection;
import movies.MoviesFactory;
import movies.MoviesPackage;
import movies.Performer;
import movies.Rating;
import movies.Season;
import movies.Series;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class MoviesFactoryImpl extends EFactoryImpl implements MoviesFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static MoviesFactory init() {
		try {
			MoviesFactory theMoviesFactory = (MoviesFactory)EPackage.Registry.INSTANCE.getEFactory("http:///movies.ecore"); 
			if (theMoviesFactory != null) {
				return theMoviesFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new MoviesFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MoviesFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case MoviesPackage.MOVIE: return createMovie();
			case MoviesPackage.MOVIE_COLLECTION: return createMovieCollection();
			case MoviesPackage.PERFORMER: return createPerformer();
			case MoviesPackage.SERIES: return createSeries();
			case MoviesPackage.SEASON: return createSeason();
			case MoviesPackage.EPISODE: return createEpisode();
			case MoviesPackage.DIRECTOR: return createDirector();
			case MoviesPackage.STUDIO: return createStudio();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case MoviesPackage.MOVIE_CATEGORY:
				return createMovieCategoryFromString(eDataType, initialValue);
			case MoviesPackage.GENDER:
				return createGenderFromString(eDataType, initialValue);
			case MoviesPackage.RATING:
				return createRatingFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case MoviesPackage.MOVIE_CATEGORY:
				return convertMovieCategoryToString(eDataType, instanceValue);
			case MoviesPackage.GENDER:
				return convertGenderToString(eDataType, instanceValue);
			case MoviesPackage.RATING:
				return convertRatingToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Movie createMovie() {
		MovieImpl movie = new MovieImpl();
		return movie;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MovieCollection createMovieCollection() {
		MovieCollectionImpl movieCollection = new MovieCollectionImpl();
		return movieCollection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Performer createPerformer() {
		PerformerImpl performer = new PerformerImpl();
		return performer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Series createSeries() {
		SeriesImpl series = new SeriesImpl();
		return series;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Season createSeason() {
		SeasonImpl season = new SeasonImpl();
		return season;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Episode createEpisode() {
		EpisodeImpl episode = new EpisodeImpl();
		return episode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Director createDirector() {
		DirectorImpl director = new DirectorImpl();
		return director;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Studio createStudio() {
		StudioImpl studio = new StudioImpl();
		return studio;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MovieCategory createMovieCategoryFromString(EDataType eDataType, String initialValue) {
		MovieCategory result = MovieCategory.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertMovieCategoryToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Gender createGenderFromString(EDataType eDataType, String initialValue) {
		Gender result = Gender.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertGenderToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Rating createRatingFromString(EDataType eDataType, String initialValue) {
		Rating result = Rating.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertRatingToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MoviesPackage getMoviesPackage() {
		return (MoviesPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static MoviesPackage getPackage() {
		return MoviesPackage.eINSTANCE;
	}

} //MoviesFactoryImpl
