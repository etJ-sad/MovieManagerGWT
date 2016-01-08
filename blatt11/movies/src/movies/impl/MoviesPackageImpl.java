/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package movies.impl;

import movies.Director;
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
import movies.Studio;
import movies.util.MoviesValidator;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class MoviesPackageImpl extends EPackageImpl implements MoviesPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass movieEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass movieCollectionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass performerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass seriesEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass seasonEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass episodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass directorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass studioEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum movieCategoryEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum genderEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ratingEEnum = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see movies.MoviesPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private MoviesPackageImpl() {
		super(eNS_URI, MoviesFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link MoviesPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static MoviesPackage init() {
		if (isInited) return (MoviesPackage)EPackage.Registry.INSTANCE.getEPackage(MoviesPackage.eNS_URI);

		// Obtain or create and register package
		MoviesPackageImpl theMoviesPackage = (MoviesPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof MoviesPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new MoviesPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theMoviesPackage.createPackageContents();

		// Initialize created meta-data
		theMoviesPackage.initializePackageContents();

		// Register package validator
		EValidator.Registry.INSTANCE.put
			(theMoviesPackage, 
			 new EValidator.Descriptor() {
				 public EValidator getEValidator() {
					 return MoviesValidator.INSTANCE;
				 }
			 });

		// Mark meta-data to indicate it can't be changed
		theMoviesPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(MoviesPackage.eNS_URI, theMoviesPackage);
		return theMoviesPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMovie() {
		return movieEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMovie_Title() {
		return (EAttribute)movieEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMovie_Title_orig() {
		return (EAttribute)movieEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMovie_Time() {
		return (EAttribute)movieEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMovie_Category() {
		return (EAttribute)movieEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMovie_Rating() {
		return (EAttribute)movieEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMovie_OverallRating() {
		return (EAttribute)movieEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMovie_LastWatchDate() {
		return (EAttribute)movieEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMovie_Loaned() {
		return (EAttribute)movieEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMovie_Performers() {
		return (EReference)movieEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMovie_MovieCollections() {
		return (EReference)movieEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMovie_ImdbUrl() {
		return (EAttribute)movieEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMovie_OfdbID() {
		return (EAttribute)movieEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMovie_Loanable() {
		return (EAttribute)movieEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMovie_LoanedUntil() {
		return (EAttribute)movieEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMovieCollection() {
		return movieCollectionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMovieCollection_Name() {
		return (EAttribute)movieCollectionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMovieCollection_Movies() {
		return (EReference)movieCollectionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPerformer() {
		return performerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPerformer_Name() {
		return (EAttribute)performerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPerformer_Gender() {
		return (EAttribute)performerEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPerformer_Rating() {
		return (EAttribute)performerEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPerformer_Movies() {
		return (EReference)performerEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPerformer_OfdbID() {
		return (EAttribute)performerEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPerformer_Loanable() {
		return (EAttribute)performerEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSeries() {
		return seriesEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSeries_Title() {
		return (EAttribute)seriesEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSeries_Studio() {
		return (EAttribute)seriesEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSeries_BroadcastedBy() {
		return (EAttribute)seriesEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSeries_ReleaseDate() {
		return (EAttribute)seriesEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSeries_Seasons() {
		return (EReference)seriesEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSeries_Rating() {
		return (EAttribute)seriesEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSeries_Performers() {
		return (EReference)seriesEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSeries_ProductionCountry() {
		return (EAttribute)seriesEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSeries_Loaned() {
		return (EAttribute)seriesEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSeries_LoanedUntil() {
		return (EAttribute)seriesEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSeries_Loanable() {
		return (EAttribute)seriesEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSeries_Allpartsloanable() {
		return (EAttribute)seriesEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSeries_Allpartsloaned() {
		return (EAttribute)seriesEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSeries_Partsloaned() {
		return (EAttribute)seriesEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSeason() {
		return seasonEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSeason_Title() {
		return (EAttribute)seasonEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSeason_ReleaseDate() {
		return (EAttribute)seasonEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSeason_Episodes() {
		return (EReference)seasonEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSeason_Series() {
		return (EReference)seasonEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSeason_Rating() {
		return (EAttribute)seasonEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSeason_Performers() {
		return (EReference)seasonEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSeason_BroadcastedBy() {
		return (EAttribute)seasonEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSeason_ProductionCountry() {
		return (EAttribute)seasonEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSeason_Loaned() {
		return (EAttribute)seasonEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSeason_LoanedUntil() {
		return (EAttribute)seasonEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSeason_Loanable() {
		return (EAttribute)seasonEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEpisode() {
		return episodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEpisode_BroadcastedBy() {
		return (EAttribute)episodeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEpisode_Season() {
		return (EReference)episodeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEpisode_EpisodeLoanable() {
		return (EAttribute)episodeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDirector() {
		return directorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDirector_NumDirectedMovies() {
		return (EAttribute)directorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDirector_MoviesDirected() {
		return (EReference)directorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStudio() {
		return studioEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStudio_Name() {
		return (EAttribute)studioEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStudio_Founded() {
		return (EAttribute)studioEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStudio_ProducedMovies() {
		return (EReference)studioEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEpisode_ProductionCountry() {
		return (EAttribute)episodeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getMovieCategory() {
		return movieCategoryEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getGender() {
		return genderEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getRating() {
		return ratingEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MoviesFactory getMoviesFactory() {
		return (MoviesFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		movieEClass = createEClass(MOVIE);
		createEAttribute(movieEClass, MOVIE__TITLE);
		createEAttribute(movieEClass, MOVIE__TITLE_ORIG);
		createEAttribute(movieEClass, MOVIE__TIME);
		createEAttribute(movieEClass, MOVIE__CATEGORY);
		createEAttribute(movieEClass, MOVIE__RATING);
		createEAttribute(movieEClass, MOVIE__OVERALL_RATING);
		createEAttribute(movieEClass, MOVIE__LAST_WATCH_DATE);
		createEAttribute(movieEClass, MOVIE__LOANED);
		createEAttribute(movieEClass, MOVIE__LOANED_UNTIL);
		createEAttribute(movieEClass, MOVIE__LOANABLE);
		createEReference(movieEClass, MOVIE__PERFORMERS);
		createEReference(movieEClass, MOVIE__MOVIE_COLLECTIONS);
		createEAttribute(movieEClass, MOVIE__IMDB_URL);
		createEAttribute(movieEClass, MOVIE__OFDB_ID);

		movieCollectionEClass = createEClass(MOVIE_COLLECTION);
		createEAttribute(movieCollectionEClass, MOVIE_COLLECTION__NAME);
		createEReference(movieCollectionEClass, MOVIE_COLLECTION__MOVIES);

		performerEClass = createEClass(PERFORMER);
		createEAttribute(performerEClass, PERFORMER__NAME);
		createEAttribute(performerEClass, PERFORMER__GENDER);
		createEAttribute(performerEClass, PERFORMER__RATING);
		createEReference(performerEClass, PERFORMER__MOVIES);
		createEAttribute(performerEClass, PERFORMER__OFDB_ID);
		createEAttribute(performerEClass, PERFORMER__LOANABLE);

		seriesEClass = createEClass(SERIES);
		createEAttribute(seriesEClass, SERIES__TITLE);
		createEAttribute(seriesEClass, SERIES__STUDIO);
		createEAttribute(seriesEClass, SERIES__BROADCASTED_BY);
		createEAttribute(seriesEClass, SERIES__RELEASE_DATE);
		createEReference(seriesEClass, SERIES__SEASONS);
		createEAttribute(seriesEClass, SERIES__RATING);
		createEReference(seriesEClass, SERIES__PERFORMERS);
		createEAttribute(seriesEClass, SERIES__PRODUCTION_COUNTRY);
		createEAttribute(seriesEClass, SERIES__LOANED);
		createEAttribute(seriesEClass, SERIES__LOANED_UNTIL);
		createEAttribute(seriesEClass, SERIES__LOANABLE);
		createEAttribute(seriesEClass, SERIES__ALLPARTSLOANABLE);
		createEAttribute(seriesEClass, SERIES__ALLPARTSLOANED);
		createEAttribute(seriesEClass, SERIES__PARTSLOANED);

		seasonEClass = createEClass(SEASON);
		createEAttribute(seasonEClass, SEASON__TITLE);
		createEAttribute(seasonEClass, SEASON__RELEASE_DATE);
		createEReference(seasonEClass, SEASON__EPISODES);
		createEReference(seasonEClass, SEASON__SERIES);
		createEAttribute(seasonEClass, SEASON__RATING);
		createEReference(seasonEClass, SEASON__PERFORMERS);
		createEAttribute(seasonEClass, SEASON__BROADCASTED_BY);
		createEAttribute(seasonEClass, SEASON__PRODUCTION_COUNTRY);
		createEAttribute(seasonEClass, SEASON__LOANED);
		createEAttribute(seasonEClass, SEASON__LOANED_UNTIL);
		createEAttribute(seasonEClass, SEASON__LOANABLE);

		episodeEClass = createEClass(EPISODE);
		createEAttribute(episodeEClass, EPISODE__BROADCASTED_BY);
		createEAttribute(episodeEClass, EPISODE__PRODUCTION_COUNTRY);
		createEReference(episodeEClass, EPISODE__SEASON);
		createEAttribute(episodeEClass, EPISODE__EPISODE_LOANABLE);

		directorEClass = createEClass(DIRECTOR);
		createEAttribute(directorEClass, DIRECTOR__NUM_DIRECTED_MOVIES);
		createEReference(directorEClass, DIRECTOR__MOVIES_DIRECTED);

		studioEClass = createEClass(STUDIO);
		createEAttribute(studioEClass, STUDIO__NAME);
		createEAttribute(studioEClass, STUDIO__FOUNDED);
		createEReference(studioEClass, STUDIO__PRODUCED_MOVIES);

		// Create enums
		movieCategoryEEnum = createEEnum(MOVIE_CATEGORY);
		genderEEnum = createEEnum(GENDER);
		ratingEEnum = createEEnum(RATING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		episodeEClass.getESuperTypes().add(this.getMovie());
		directorEClass.getESuperTypes().add(this.getPerformer());

		// Initialize classes and features; add operations and parameters
		initEClass(movieEClass, Movie.class, "Movie", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMovie_Title(), ecorePackage.getEString(), "title", null, 0, 1, Movie.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMovie_Title_orig(), ecorePackage.getEString(), "title_orig", null, 0, 1, Movie.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMovie_Time(), ecorePackage.getEInt(), "time", null, 0, 1, Movie.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMovie_Category(), this.getMovieCategory(), "category", null, 0, 1, Movie.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMovie_Rating(), this.getRating(), "rating", null, 0, 1, Movie.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMovie_OverallRating(), ecorePackage.getEString(), "overallRating", null, 0, 1, Movie.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMovie_LastWatchDate(), ecorePackage.getEDate(), "lastWatchDate", null, 0, 1, Movie.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMovie_Loaned(), ecorePackage.getEBoolean(), "loaned", null, 0, 1, Movie.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMovie_LoanedUntil(), ecorePackage.getEDate(), "loanedUntil", null, 0, 1, Movie.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMovie_Loanable(), ecorePackage.getEBoolean(), "loanable", null, 0, 1, Movie.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMovie_Performers(), this.getPerformer(), this.getPerformer_Movies(), "performers", null, 0, -1, Movie.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMovie_MovieCollections(), this.getMovieCollection(), this.getMovieCollection_Movies(), "movieCollections", null, 0, -1, Movie.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMovie_ImdbUrl(), ecorePackage.getEString(), "imdbUrl", null, 0, 1, Movie.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMovie_OfdbID(), ecorePackage.getEString(), "ofdbID", "", 0, 1, Movie.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		EOperation op = addEOperation(movieEClass, ecorePackage.getEBoolean(), "hasTitle", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "DiagnosticianChain", 0, 1, IS_UNIQUE, IS_ORDERED);
		EGenericType g1 = createEGenericType(ecorePackage.getEMap());
		EGenericType g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "Context", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(movieEClass, ecorePackage.getEBoolean(), "hasTime", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "DiagnosticianChain", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "Context", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(movieCollectionEClass, MovieCollection.class, "MovieCollection", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMovieCollection_Name(), ecorePackage.getEString(), "name", null, 0, 1, MovieCollection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMovieCollection_Movies(), this.getMovie(), this.getMovie_MovieCollections(), "movies", null, 0, -1, MovieCollection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(movieCollectionEClass, ecorePackage.getEBoolean(), "hasMovies", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "DiagnosticianChain", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "Context", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(performerEClass, Performer.class, "Performer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPerformer_Name(), ecorePackage.getEString(), "name", null, 0, 1, Performer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPerformer_Gender(), this.getGender(), "gender", null, 0, 1, Performer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPerformer_Rating(), this.getRating(), "rating", null, 0, 1, Performer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPerformer_Movies(), this.getMovie(), this.getMovie_Performers(), "movies", null, 0, -1, Performer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPerformer_OfdbID(), ecorePackage.getEString(), "OfdbID", null, 0, 1, Performer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPerformer_Loanable(), ecorePackage.getEBoolean(), "loanable", null, 0, 1, Performer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(performerEClass, ecorePackage.getEBoolean(), "hasName", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "DiagnosticianChain", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "Context", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(performerEClass, ecorePackage.getEBoolean(), "hasMovies", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "DiagnosticianChain", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "Context", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(seriesEClass, Series.class, "Series", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSeries_Title(), ecorePackage.getEString(), "title", null, 0, 1, Series.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSeries_Studio(), ecorePackage.getEString(), "studio", null, 0, 1, Series.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSeries_BroadcastedBy(), ecorePackage.getEString(), "broadcastedBy", null, 0, 1, Series.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSeries_ReleaseDate(), ecorePackage.getEDate(), "releaseDate", null, 0, 1, Series.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSeries_Seasons(), this.getSeason(), this.getSeason_Series(), "Seasons", null, 0, -1, Series.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSeries_Rating(), this.getRating(), "Rating", null, 0, 1, Series.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSeries_Performers(), this.getPerformer(), null, "performers", null, 0, -1, Series.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSeries_ProductionCountry(), ecorePackage.getEString(), "productionCountry", null, 0, 1, Series.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSeries_Loaned(), ecorePackage.getEBoolean(), "loaned", null, 0, 1, Series.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSeries_LoanedUntil(), ecorePackage.getEDate(), "loanedUntil", null, 0, 1, Series.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSeries_Loanable(), ecorePackage.getEBoolean(), "loanable", null, 0, 1, Series.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSeries_Allpartsloanable(), ecorePackage.getEBoolean(), "allpartsloanable", null, 0, 1, Series.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSeries_Allpartsloaned(), ecorePackage.getEBoolean(), "allpartsloaned", null, 0, 1, Series.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSeries_Partsloaned(), ecorePackage.getEBoolean(), "partsloaned", null, 0, 1, Series.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(seasonEClass, Season.class, "Season", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSeason_Title(), ecorePackage.getEString(), "title", null, 0, 1, Season.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSeason_ReleaseDate(), ecorePackage.getEDate(), "releaseDate", null, 0, 1, Season.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSeason_Episodes(), this.getEpisode(), this.getEpisode_Season(), "Episodes", null, 0, -1, Season.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSeason_Series(), this.getSeries(), this.getSeries_Seasons(), "Series", null, 1, 1, Season.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSeason_Rating(), this.getRating(), "rating", null, 0, 1, Season.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSeason_Performers(), this.getPerformer(), null, "performers", null, 0, -1, Season.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSeason_BroadcastedBy(), ecorePackage.getEString(), "broadcastedBy", null, 0, 1, Season.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSeason_ProductionCountry(), ecorePackage.getEString(), "productionCountry", null, 0, 1, Season.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSeason_Loaned(), ecorePackage.getEBoolean(), "loaned", null, 0, 1, Season.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSeason_LoanedUntil(), ecorePackage.getEDate(), "loanedUntil", null, 0, 1, Season.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSeason_Loanable(), ecorePackage.getEBoolean(), "loanable", null, 0, 1, Season.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(episodeEClass, Episode.class, "Episode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEpisode_BroadcastedBy(), ecorePackage.getEString(), "broadcastedBy", null, 0, 1, Episode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEpisode_ProductionCountry(), ecorePackage.getEString(), "productionCountry", null, 0, 1, Episode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEpisode_Season(), this.getSeason(), this.getSeason_Episodes(), "Season", null, 1, 1, Episode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEpisode_EpisodeLoanable(), ecorePackage.getEBooleanObject(), "episodeLoanable", null, 0, 1, Episode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(directorEClass, Director.class, "Director", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDirector_NumDirectedMovies(), ecorePackage.getEInt(), "numDirectedMovies", null, 0, 1, Director.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDirector_MoviesDirected(), this.getMovie(), null, "moviesDirected", null, 0, -1, Director.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(studioEClass, Studio.class, "Studio", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getStudio_Name(), ecorePackage.getEString(), "name", null, 0, 1, Studio.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getStudio_Founded(), ecorePackage.getEDate(), "founded", null, 0, 1, Studio.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getStudio_ProducedMovies(), this.getMovie(), null, "producedMovies", null, 0, -1, Studio.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(movieCategoryEEnum, MovieCategory.class, "MovieCategory");
		addEEnumLiteral(movieCategoryEEnum, MovieCategory.ACTION);
		addEEnumLiteral(movieCategoryEEnum, MovieCategory.SCIENCE_FICTION);
		addEEnumLiteral(movieCategoryEEnum, MovieCategory.COMEDY);
		addEEnumLiteral(movieCategoryEEnum, MovieCategory.MUSIC);
		addEEnumLiteral(movieCategoryEEnum, MovieCategory.DRAMA);
		addEEnumLiteral(movieCategoryEEnum, MovieCategory.THRILLER);
		addEEnumLiteral(movieCategoryEEnum, MovieCategory.HORROR);
		addEEnumLiteral(movieCategoryEEnum, MovieCategory.FANTASY);
		addEEnumLiteral(movieCategoryEEnum, MovieCategory.ADVENTURE);
		addEEnumLiteral(movieCategoryEEnum, MovieCategory.ROMANCE);
		addEEnumLiteral(movieCategoryEEnum, MovieCategory.DOCUMENTATION);

		initEEnum(genderEEnum, Gender.class, "Gender");
		addEEnumLiteral(genderEEnum, Gender.MALE);
		addEEnumLiteral(genderEEnum, Gender.FEMALE);

		initEEnum(ratingEEnum, Rating.class, "Rating");
		addEEnumLiteral(ratingEEnum, Rating.ZERO);
		addEEnumLiteral(ratingEEnum, Rating.ONE);
		addEEnumLiteral(ratingEEnum, Rating.TWO);
		addEEnumLiteral(ratingEEnum, Rating.THREE);
		addEEnumLiteral(ratingEEnum, Rating.FOUR);
		addEEnumLiteral(ratingEEnum, Rating.FIVE);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// org.eclipse.emf.ecp.editor
		createOrgAnnotations();
	}

	/**
	 * Initializes the annotations for <b>org.eclipse.emf.ecp.editor</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createOrgAnnotations() {
		String source = "org.eclipse.emf.ecp.editor";		
		addAnnotation
		  (getMovie_OverallRating(), 
		   source, 
		   new String[] {
			 "priority", "1.0",
			 "position", "right"
		   });		
		addAnnotation
		  (getMovie_Performers(), 
		   source, 
		   new String[] {
			 "priority", "1.2",
			 "position", "right"
		   });		
		addAnnotation
		  (getMovie_MovieCollections(), 
		   source, 
		   new String[] {
			 "priority", "1.3",
			 "position", "right"
		   });		
		addAnnotation
		  (getPerformer_Movies(), 
		   source, 
		   new String[] {
			 "priority", "1.0",
			 "position", "right"
		   });		
		addAnnotation
		  (getSeries_Seasons(), 
		   source, 
		   new String[] {
			 "position", "right"
		   });		
		addAnnotation
		  (getSeries_Performers(), 
		   source, 
		   new String[] {
			 "position", "right"
		   });		
		addAnnotation
		  (getSeason_Episodes(), 
		   source, 
		   new String[] {
			 "position", "right"
		   });		
		addAnnotation
		  (getSeason_Performers(), 
		   source, 
		   new String[] {
			 "position", "right"
		   });
	}

} //MoviesPackageImpl
