/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package movies;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see movies.MoviesFactory
 * @model kind="package"
 * @generated
 */
public interface MoviesPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "movies";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http:///movies.ecore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "movies";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	MoviesPackage eINSTANCE = movies.impl.MoviesPackageImpl.init();

	/**
	 * The meta object id for the '{@link movies.impl.MovieImpl <em>Movie</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see movies.impl.MovieImpl
	 * @see movies.impl.MoviesPackageImpl#getMovie()
	 * @generated
	 */
	int MOVIE = 0;

	/**
	 * The feature id for the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOVIE__TITLE = 0;

	/**
	 * The feature id for the '<em><b>Title orig</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOVIE__TITLE_ORIG = 1;

	/**
	 * The feature id for the '<em><b>Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOVIE__TIME = 2;

	/**
	 * The feature id for the '<em><b>Category</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOVIE__CATEGORY = 3;

	/**
	 * The feature id for the '<em><b>Rating</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOVIE__RATING = 4;

	/**
	 * The feature id for the '<em><b>Overall Rating</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOVIE__OVERALL_RATING = 5;

	/**
	 * The feature id for the '<em><b>Last Watch Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOVIE__LAST_WATCH_DATE = 6;

	/**
	 * The feature id for the '<em><b>Loaned</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOVIE__LOANED = 7;

	/**
	 * The feature id for the '<em><b>Loaned Until</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOVIE__LOANED_UNTIL = 8;

	/**
	 * The feature id for the '<em><b>Loanable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOVIE__LOANABLE = 9;

	/**
	 * The feature id for the '<em><b>Performers</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOVIE__PERFORMERS = 10;

	/**
	 * The feature id for the '<em><b>Movie Collections</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOVIE__MOVIE_COLLECTIONS = 11;

	/**
	 * The feature id for the '<em><b>Imdb Url</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOVIE__IMDB_URL = 12;

	/**
	 * The feature id for the '<em><b>Ofdb ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOVIE__OFDB_ID = 13;

	/**
	 * The number of structural features of the '<em>Movie</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOVIE_FEATURE_COUNT = 14;

	/**
	 * The meta object id for the '{@link movies.impl.MovieCollectionImpl <em>Movie Collection</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see movies.impl.MovieCollectionImpl
	 * @see movies.impl.MoviesPackageImpl#getMovieCollection()
	 * @generated
	 */
	int MOVIE_COLLECTION = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOVIE_COLLECTION__NAME = 0;

	/**
	 * The feature id for the '<em><b>Movies</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOVIE_COLLECTION__MOVIES = 1;

	/**
	 * The number of structural features of the '<em>Movie Collection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOVIE_COLLECTION_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link movies.impl.PerformerImpl <em>Performer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see movies.impl.PerformerImpl
	 * @see movies.impl.MoviesPackageImpl#getPerformer()
	 * @generated
	 */
	int PERFORMER = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERFORMER__NAME = 0;

	/**
	 * The feature id for the '<em><b>Gender</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERFORMER__GENDER = 1;

	/**
	 * The feature id for the '<em><b>Rating</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERFORMER__RATING = 2;

	/**
	 * The feature id for the '<em><b>Movies</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERFORMER__MOVIES = 3;

	/**
	 * The feature id for the '<em><b>Ofdb ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERFORMER__OFDB_ID = 4;

	/**
	 * The feature id for the '<em><b>Loanable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERFORMER__LOANABLE = 5;

	/**
	 * The number of structural features of the '<em>Performer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERFORMER_FEATURE_COUNT = 6;

	/**
	 * The meta object id for the '{@link movies.impl.SeriesImpl <em>Series</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see movies.impl.SeriesImpl
	 * @see movies.impl.MoviesPackageImpl#getSeries()
	 * @generated
	 */
	int SERIES = 3;

	/**
	 * The feature id for the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERIES__TITLE = 0;

	/**
	 * The feature id for the '<em><b>Studio</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERIES__STUDIO = 1;

	/**
	 * The feature id for the '<em><b>Broadcasted By</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERIES__BROADCASTED_BY = 2;

	/**
	 * The feature id for the '<em><b>Release Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERIES__RELEASE_DATE = 3;

	/**
	 * The feature id for the '<em><b>Seasons</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERIES__SEASONS = 4;

	/**
	 * The feature id for the '<em><b>Rating</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERIES__RATING = 5;

	/**
	 * The feature id for the '<em><b>Performers</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERIES__PERFORMERS = 6;

	/**
	 * The feature id for the '<em><b>Production Country</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERIES__PRODUCTION_COUNTRY = 7;

	/**
	 * The feature id for the '<em><b>Loaned</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERIES__LOANED = 8;

	/**
	 * The feature id for the '<em><b>Loaned Until</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERIES__LOANED_UNTIL = 9;

	/**
	 * The feature id for the '<em><b>Loanable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERIES__LOANABLE = 10;

	/**
	 * The feature id for the '<em><b>Allpartsloanable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERIES__ALLPARTSLOANABLE = 11;

	/**
	 * The feature id for the '<em><b>Allpartsloaned</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERIES__ALLPARTSLOANED = 12;

	/**
	 * The feature id for the '<em><b>Partsloaned</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERIES__PARTSLOANED = 13;

	/**
	 * The number of structural features of the '<em>Series</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERIES_FEATURE_COUNT = 14;

	/**
	 * The meta object id for the '{@link movies.impl.SeasonImpl <em>Season</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see movies.impl.SeasonImpl
	 * @see movies.impl.MoviesPackageImpl#getSeason()
	 * @generated
	 */
	int SEASON = 4;

	/**
	 * The feature id for the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEASON__TITLE = 0;

	/**
	 * The feature id for the '<em><b>Release Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEASON__RELEASE_DATE = 1;

	/**
	 * The feature id for the '<em><b>Episodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEASON__EPISODES = 2;

	/**
	 * The feature id for the '<em><b>Series</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEASON__SERIES = 3;

	/**
	 * The feature id for the '<em><b>Rating</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEASON__RATING = 4;

	/**
	 * The feature id for the '<em><b>Performers</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEASON__PERFORMERS = 5;

	/**
	 * The feature id for the '<em><b>Broadcasted By</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEASON__BROADCASTED_BY = 6;

	/**
	 * The feature id for the '<em><b>Production Country</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEASON__PRODUCTION_COUNTRY = 7;

	/**
	 * The feature id for the '<em><b>Loaned</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEASON__LOANED = 8;

	/**
	 * The feature id for the '<em><b>Loaned Until</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEASON__LOANED_UNTIL = 9;

	/**
	 * The feature id for the '<em><b>Loanable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEASON__LOANABLE = 10;

	/**
	 * The number of structural features of the '<em>Season</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEASON_FEATURE_COUNT = 11;

	/**
	 * The meta object id for the '{@link movies.impl.EpisodeImpl <em>Episode</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see movies.impl.EpisodeImpl
	 * @see movies.impl.MoviesPackageImpl#getEpisode()
	 * @generated
	 */
	int EPISODE = 5;

	/**
	 * The feature id for the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPISODE__TITLE = MOVIE__TITLE;

	/**
	 * The feature id for the '<em><b>Title orig</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPISODE__TITLE_ORIG = MOVIE__TITLE_ORIG;

	/**
	 * The feature id for the '<em><b>Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPISODE__TIME = MOVIE__TIME;

	/**
	 * The feature id for the '<em><b>Category</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPISODE__CATEGORY = MOVIE__CATEGORY;

	/**
	 * The feature id for the '<em><b>Rating</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPISODE__RATING = MOVIE__RATING;

	/**
	 * The feature id for the '<em><b>Overall Rating</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPISODE__OVERALL_RATING = MOVIE__OVERALL_RATING;

	/**
	 * The feature id for the '<em><b>Last Watch Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPISODE__LAST_WATCH_DATE = MOVIE__LAST_WATCH_DATE;

	/**
	 * The feature id for the '<em><b>Loaned</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPISODE__LOANED = MOVIE__LOANED;

	/**
	 * The feature id for the '<em><b>Loaned Until</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPISODE__LOANED_UNTIL = MOVIE__LOANED_UNTIL;

	/**
	 * The feature id for the '<em><b>Loanable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPISODE__LOANABLE = MOVIE__LOANABLE;
	
	/**
	 * The feature id for the '<em><b>Performers</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPISODE__PERFORMERS = MOVIE__PERFORMERS;

	/**
	 * The feature id for the '<em><b>Movie Collections</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPISODE__MOVIE_COLLECTIONS = MOVIE__MOVIE_COLLECTIONS;

	/**
	 * The feature id for the '<em><b>Imdb Url</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPISODE__IMDB_URL = MOVIE__IMDB_URL;

	/**
	 * The feature id for the '<em><b>Ofdb ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPISODE__OFDB_ID = MOVIE__OFDB_ID;

	/**
	 * The feature id for the '<em><b>Broadcasted By</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPISODE__BROADCASTED_BY = MOVIE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Production Country</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPISODE__PRODUCTION_COUNTRY = MOVIE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Season</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPISODE__SEASON = MOVIE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Episode Loanable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPISODE__EPISODE_LOANABLE = MOVIE_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Episode</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPISODE_FEATURE_COUNT = MOVIE_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link movies.impl.DirectorImpl <em>Director</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see movies.impl.DirectorImpl
	 * @see movies.impl.MoviesPackageImpl#getDirector()
	 * @generated
	 */
	int DIRECTOR = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTOR__NAME = PERFORMER__NAME;

	/**
	 * The feature id for the '<em><b>Gender</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTOR__GENDER = PERFORMER__GENDER;

	/**
	 * The feature id for the '<em><b>Rating</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTOR__RATING = PERFORMER__RATING;

	/**
	 * The feature id for the '<em><b>Movies</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTOR__MOVIES = PERFORMER__MOVIES;

	/**
	 * The feature id for the '<em><b>Ofdb ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTOR__OFDB_ID = PERFORMER__OFDB_ID;

	/**
	 * The feature id for the '<em><b>Loanable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTOR__LOANABLE = PERFORMER__LOANABLE;

	/**
	 * The feature id for the '<em><b>Num Directed Movies</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTOR__NUM_DIRECTED_MOVIES = PERFORMER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Movies Directed</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTOR__MOVIES_DIRECTED = PERFORMER_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Director</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTOR_FEATURE_COUNT = PERFORMER_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link movies.impl.StudioImpl <em>Studio</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see movies.impl.StudioImpl
	 * @see movies.impl.MoviesPackageImpl#getStudio()
	 * @generated
	 */
	int STUDIO = 7;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STUDIO__NAME = 0;

	/**
	 * The feature id for the '<em><b>Founded</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STUDIO__FOUNDED = 1;

	/**
	 * The feature id for the '<em><b>Produced Movies</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STUDIO__PRODUCED_MOVIES = 2;

	/**
	 * The number of structural features of the '<em>Studio</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STUDIO_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link movies.MovieCategory <em>Movie Category</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see movies.MovieCategory
	 * @see movies.impl.MoviesPackageImpl#getMovieCategory()
	 * @generated
	 */
	int MOVIE_CATEGORY = 8;

	/**
	 * The meta object id for the '{@link movies.Gender <em>Gender</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see movies.Gender
	 * @see movies.impl.MoviesPackageImpl#getGender()
	 * @generated
	 */
	int GENDER = 9;

	/**
	 * The meta object id for the '{@link movies.Rating <em>Rating</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see movies.Rating
	 * @see movies.impl.MoviesPackageImpl#getRating()
	 * @generated
	 */
	int RATING = 10;

	/**
	 * Returns the meta object for class '{@link movies.Movie <em>Movie</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Movie</em>'.
	 * @see movies.Movie
	 * @generated
	 */
	EClass getMovie();

	/**
	 * Returns the meta object for the attribute '{@link movies.Movie#getTitle <em>Title</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Title</em>'.
	 * @see movies.Movie#getTitle()
	 * @see #getMovie()
	 * @generated
	 */
	EAttribute getMovie_Title();

	/**
	 * Returns the meta object for the attribute '{@link movies.Movie#getTitle_orig <em>Title orig</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Title orig</em>'.
	 * @see movies.Movie#getTitle_orig()
	 * @see #getMovie()
	 * @generated
	 */
	EAttribute getMovie_Title_orig();

	/**
	 * Returns the meta object for the attribute '{@link movies.Movie#getTime <em>Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Time</em>'.
	 * @see movies.Movie#getTime()
	 * @see #getMovie()
	 * @generated
	 */
	EAttribute getMovie_Time();

	/**
	 * Returns the meta object for the attribute '{@link movies.Movie#getCategory <em>Category</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Category</em>'.
	 * @see movies.Movie#getCategory()
	 * @see #getMovie()
	 * @generated
	 */
	EAttribute getMovie_Category();

	/**
	 * Returns the meta object for the attribute '{@link movies.Movie#getRating <em>Rating</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Rating</em>'.
	 * @see movies.Movie#getRating()
	 * @see #getMovie()
	 * @generated
	 */
	EAttribute getMovie_Rating();

	/**
	 * Returns the meta object for the attribute '{@link movies.Movie#getOverallRating <em>Overall Rating</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Overall Rating</em>'.
	 * @see movies.Movie#getOverallRating()
	 * @see #getMovie()
	 * @generated
	 */
	EAttribute getMovie_OverallRating();

	/**
	 * Returns the meta object for the attribute '{@link movies.Movie#getLastWatchDate <em>Last Watch Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Last Watch Date</em>'.
	 * @see movies.Movie#getLastWatchDate()
	 * @see #getMovie()
	 * @generated
	 */
	EAttribute getMovie_LastWatchDate();

	/**
	 * Returns the meta object for the attribute '{@link movies.Movie#isLoaned <em>Loaned</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Loaned</em>'.
	 * @see movies.Movie#isLoaned()
	 * @see #getMovie()
	 * @generated
	 */
	EAttribute getMovie_Loaned();

	/**
	 * Returns the meta object for the reference list '{@link movies.Movie#getPerformers <em>Performers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Performers</em>'.
	 * @see movies.Movie#getPerformers()
	 * @see #getMovie()
	 * @generated
	 */
	EReference getMovie_Performers();

	/**
	 * Returns the meta object for the reference list '{@link movies.Movie#getMovieCollections <em>Movie Collections</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Movie Collections</em>'.
	 * @see movies.Movie#getMovieCollections()
	 * @see #getMovie()
	 * @generated
	 */
	EReference getMovie_MovieCollections();

	/**
	 * Returns the meta object for the attribute '{@link movies.Movie#getImdbUrl <em>Imdb Url</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Imdb Url</em>'.
	 * @see movies.Movie#getImdbUrl()
	 * @see #getMovie()
	 * @generated
	 */
	EAttribute getMovie_ImdbUrl();

	/**
	 * Returns the meta object for the attribute '{@link movies.Movie#getOfdbID <em>Ofdb ID</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ofdb ID</em>'.
	 * @see movies.Movie#getOfdbID()
	 * @see #getMovie()
	 * @generated
	 */
	EAttribute getMovie_OfdbID();

	/**
	 * Returns the meta object for the attribute '{@link movies.Movie#isLoanable <em>Loanable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Loanable</em>'.
	 * @see movies.Movie#isLoanable()
	 * @see #getMovie()
	 * @generated
	 */
	EAttribute getMovie_Loanable();

	/**
	 * Returns the meta object for the attribute '{@link movies.Movie#getLoanedUntil <em>Loaned Until</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Loaned Until</em>'.
	 * @see movies.Movie#getLoanedUntil()
	 * @see #getMovie()
	 * @generated
	 */
	EAttribute getMovie_LoanedUntil();

	/**
	 * Returns the meta object for class '{@link movies.MovieCollection <em>Movie Collection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Movie Collection</em>'.
	 * @see movies.MovieCollection
	 * @generated
	 */
	EClass getMovieCollection();

	/**
	 * Returns the meta object for the attribute '{@link movies.MovieCollection#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see movies.MovieCollection#getName()
	 * @see #getMovieCollection()
	 * @generated
	 */
	EAttribute getMovieCollection_Name();

	/**
	 * Returns the meta object for the reference list '{@link movies.MovieCollection#getMovies <em>Movies</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Movies</em>'.
	 * @see movies.MovieCollection#getMovies()
	 * @see #getMovieCollection()
	 * @generated
	 */
	EReference getMovieCollection_Movies();

	/**
	 * Returns the meta object for class '{@link movies.Performer <em>Performer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Performer</em>'.
	 * @see movies.Performer
	 * @generated
	 */
	EClass getPerformer();

	/**
	 * Returns the meta object for the attribute '{@link movies.Performer#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see movies.Performer#getName()
	 * @see #getPerformer()
	 * @generated
	 */
	EAttribute getPerformer_Name();

	/**
	 * Returns the meta object for the attribute '{@link movies.Performer#getGender <em>Gender</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Gender</em>'.
	 * @see movies.Performer#getGender()
	 * @see #getPerformer()
	 * @generated
	 */
	EAttribute getPerformer_Gender();

	/**
	 * Returns the meta object for the attribute '{@link movies.Performer#getRating <em>Rating</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Rating</em>'.
	 * @see movies.Performer#getRating()
	 * @see #getPerformer()
	 * @generated
	 */
	EAttribute getPerformer_Rating();

	/**
	 * Returns the meta object for the reference list '{@link movies.Performer#getMovies <em>Movies</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Movies</em>'.
	 * @see movies.Performer#getMovies()
	 * @see #getPerformer()
	 * @generated
	 */
	EReference getPerformer_Movies();

	/**
	 * Returns the meta object for the attribute '{@link movies.Performer#getOfdbID <em>Ofdb ID</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ofdb ID</em>'.
	 * @see movies.Performer#getOfdbID()
	 * @see #getPerformer()
	 * @generated
	 */
	EAttribute getPerformer_OfdbID();

	/**
	 * Returns the meta object for the attribute '{@link movies.Performer#isLoanable <em>Loanable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Loanable</em>'.
	 * @see movies.Performer#isLoanable()
	 * @see #getPerformer()
	 * @generated
	 */
	EAttribute getPerformer_Loanable();

	/**
	 * Returns the meta object for class '{@link movies.Series <em>Series</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Series</em>'.
	 * @see movies.Series
	 * @generated
	 */
	EClass getSeries();

	/**
	 * Returns the meta object for the attribute '{@link movies.Series#getTitle <em>Title</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Title</em>'.
	 * @see movies.Series#getTitle()
	 * @see #getSeries()
	 * @generated
	 */
	EAttribute getSeries_Title();

	/**
	 * Returns the meta object for the attribute '{@link movies.Series#getStudio <em>Studio</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Studio</em>'.
	 * @see movies.Series#getStudio()
	 * @see #getSeries()
	 * @generated
	 */
	EAttribute getSeries_Studio();

	/**
	 * Returns the meta object for the attribute '{@link movies.Series#getBroadcastedBy <em>Broadcasted By</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Broadcasted By</em>'.
	 * @see movies.Series#getBroadcastedBy()
	 * @see #getSeries()
	 * @generated
	 */
	EAttribute getSeries_BroadcastedBy();

	/**
	 * Returns the meta object for the attribute '{@link movies.Series#getReleaseDate <em>Release Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Release Date</em>'.
	 * @see movies.Series#getReleaseDate()
	 * @see #getSeries()
	 * @generated
	 */
	EAttribute getSeries_ReleaseDate();

	/**
	 * Returns the meta object for the containment reference list '{@link movies.Series#getSeasons <em>Seasons</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Seasons</em>'.
	 * @see movies.Series#getSeasons()
	 * @see #getSeries()
	 * @generated
	 */
	EReference getSeries_Seasons();

	/**
	 * Returns the meta object for the attribute '{@link movies.Series#getRating <em>Rating</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Rating</em>'.
	 * @see movies.Series#getRating()
	 * @see #getSeries()
	 * @generated
	 */
	EAttribute getSeries_Rating();

	/**
	 * Returns the meta object for the reference list '{@link movies.Series#getPerformers <em>Performers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Performers</em>'.
	 * @see movies.Series#getPerformers()
	 * @see #getSeries()
	 * @generated
	 */
	EReference getSeries_Performers();

	/**
	 * Returns the meta object for the attribute '{@link movies.Series#getProductionCountry <em>Production Country</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Production Country</em>'.
	 * @see movies.Series#getProductionCountry()
	 * @see #getSeries()
	 * @generated
	 */
	EAttribute getSeries_ProductionCountry();

	/**
	 * Returns the meta object for the attribute '{@link movies.Series#isLoaned <em>Loaned</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Loaned</em>'.
	 * @see movies.Series#isLoaned()
	 * @see #getSeries()
	 * @generated
	 */
	EAttribute getSeries_Loaned();

	/**
	 * Returns the meta object for the attribute '{@link movies.Series#getLoanedUntil <em>Loaned Until</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Loaned Until</em>'.
	 * @see movies.Series#getLoanedUntil()
	 * @see #getSeries()
	 * @generated
	 */
	EAttribute getSeries_LoanedUntil();

	/**
	 * Returns the meta object for the attribute '{@link movies.Series#isLoanable <em>Loanable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Loanable</em>'.
	 * @see movies.Series#isLoanable()
	 * @see #getSeries()
	 * @generated
	 */
	EAttribute getSeries_Loanable();

	/**
	 * Returns the meta object for the attribute '{@link movies.Series#isAllpartsloanable <em>Allpartsloanable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Allpartsloanable</em>'.
	 * @see movies.Series#isAllpartsloanable()
	 * @see #getSeries()
	 * @generated
	 */
	EAttribute getSeries_Allpartsloanable();

	/**
	 * Returns the meta object for the attribute '{@link movies.Series#isAllpartsloaned <em>Allpartsloaned</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Allpartsloaned</em>'.
	 * @see movies.Series#isAllpartsloaned()
	 * @see #getSeries()
	 * @generated
	 */
	EAttribute getSeries_Allpartsloaned();

	/**
	 * Returns the meta object for the attribute '{@link movies.Series#isPartsloaned <em>Partsloaned</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Partsloaned</em>'.
	 * @see movies.Series#isPartsloaned()
	 * @see #getSeries()
	 * @generated
	 */
	EAttribute getSeries_Partsloaned();

	/**
	 * Returns the meta object for class '{@link movies.Season <em>Season</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Season</em>'.
	 * @see movies.Season
	 * @generated
	 */
	EClass getSeason();

	/**
	 * Returns the meta object for the attribute '{@link movies.Season#getTitle <em>Title</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Title</em>'.
	 * @see movies.Season#getTitle()
	 * @see #getSeason()
	 * @generated
	 */
	EAttribute getSeason_Title();

	/**
	 * Returns the meta object for the attribute '{@link movies.Season#getReleaseDate <em>Release Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Release Date</em>'.
	 * @see movies.Season#getReleaseDate()
	 * @see #getSeason()
	 * @generated
	 */
	EAttribute getSeason_ReleaseDate();

	/**
	 * Returns the meta object for the containment reference list '{@link movies.Season#getEpisodes <em>Episodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Episodes</em>'.
	 * @see movies.Season#getEpisodes()
	 * @see #getSeason()
	 * @generated
	 */
	EReference getSeason_Episodes();

	/**
	 * Returns the meta object for the container reference '{@link movies.Season#getSeries <em>Series</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Series</em>'.
	 * @see movies.Season#getSeries()
	 * @see #getSeason()
	 * @generated
	 */
	EReference getSeason_Series();

	/**
	 * Returns the meta object for the attribute '{@link movies.Season#getRating <em>Rating</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Rating</em>'.
	 * @see movies.Season#getRating()
	 * @see #getSeason()
	 * @generated
	 */
	EAttribute getSeason_Rating();

	/**
	 * Returns the meta object for the reference list '{@link movies.Season#getPerformers <em>Performers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Performers</em>'.
	 * @see movies.Season#getPerformers()
	 * @see #getSeason()
	 * @generated
	 */
	EReference getSeason_Performers();

	/**
	 * Returns the meta object for the attribute '{@link movies.Season#getBroadcastedBy <em>Broadcasted By</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Broadcasted By</em>'.
	 * @see movies.Season#getBroadcastedBy()
	 * @see #getSeason()
	 * @generated
	 */
	EAttribute getSeason_BroadcastedBy();

	/**
	 * Returns the meta object for the attribute '{@link movies.Season#getProductionCountry <em>Production Country</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Production Country</em>'.
	 * @see movies.Season#getProductionCountry()
	 * @see #getSeason()
	 * @generated
	 */
	EAttribute getSeason_ProductionCountry();

	/**
	 * Returns the meta object for the attribute '{@link movies.Season#isLoaned <em>Loaned</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Loaned</em>'.
	 * @see movies.Season#isLoaned()
	 * @see #getSeason()
	 * @generated
	 */
	EAttribute getSeason_Loaned();

	/**
	 * Returns the meta object for the attribute '{@link movies.Season#getLoanedUntil <em>Loaned Until</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Loaned Until</em>'.
	 * @see movies.Season#getLoanedUntil()
	 * @see #getSeason()
	 * @generated
	 */
	EAttribute getSeason_LoanedUntil();

	/**
	 * Returns the meta object for the attribute '{@link movies.Season#isLoanable <em>Loanable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Loanable</em>'.
	 * @see movies.Season#isLoanable()
	 * @see #getSeason()
	 * @generated
	 */
	EAttribute getSeason_Loanable();

	/**
	 * Returns the meta object for class '{@link movies.Episode <em>Episode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Episode</em>'.
	 * @see movies.Episode
	 * @generated
	 */
	EClass getEpisode();

	/**
	 * Returns the meta object for the attribute '{@link movies.Episode#getBroadcastedBy <em>Broadcasted By</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Broadcasted By</em>'.
	 * @see movies.Episode#getBroadcastedBy()
	 * @see #getEpisode()
	 * @generated
	 */
	EAttribute getEpisode_BroadcastedBy();

	/**
	 * Returns the meta object for the container reference '{@link movies.Episode#getSeason <em>Season</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Season</em>'.
	 * @see movies.Episode#getSeason()
	 * @see #getEpisode()
	 * @generated
	 */
	EReference getEpisode_Season();

	/**
	 * Returns the meta object for the attribute '{@link movies.Episode#getEpisodeLoanable <em>Episode Loanable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Episode Loanable</em>'.
	 * @see movies.Episode#getEpisodeLoanable()
	 * @see #getEpisode()
	 * @generated
	 */
	EAttribute getEpisode_EpisodeLoanable();

	/**
	 * Returns the meta object for class '{@link movies.Director <em>Director</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Director</em>'.
	 * @see movies.Director
	 * @generated
	 */
	EClass getDirector();

	/**
	 * Returns the meta object for the attribute '{@link movies.Director#getNumDirectedMovies <em>Num Directed Movies</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Num Directed Movies</em>'.
	 * @see movies.Director#getNumDirectedMovies()
	 * @see #getDirector()
	 * @generated
	 */
	EAttribute getDirector_NumDirectedMovies();

	/**
	 * Returns the meta object for the reference list '{@link movies.Director#getMoviesDirected <em>Movies Directed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Movies Directed</em>'.
	 * @see movies.Director#getMoviesDirected()
	 * @see #getDirector()
	 * @generated
	 */
	EReference getDirector_MoviesDirected();

	/**
	 * Returns the meta object for class '{@link movies.Studio <em>Studio</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Studio</em>'.
	 * @see movies.Studio
	 * @generated
	 */
	EClass getStudio();

	/**
	 * Returns the meta object for the attribute '{@link movies.Studio#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see movies.Studio#getName()
	 * @see #getStudio()
	 * @generated
	 */
	EAttribute getStudio_Name();

	/**
	 * Returns the meta object for the attribute '{@link movies.Studio#getFounded <em>Founded</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Founded</em>'.
	 * @see movies.Studio#getFounded()
	 * @see #getStudio()
	 * @generated
	 */
	EAttribute getStudio_Founded();

	/**
	 * Returns the meta object for the reference list '{@link movies.Studio#getProducedMovies <em>Produced Movies</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Produced Movies</em>'.
	 * @see movies.Studio#getProducedMovies()
	 * @see #getStudio()
	 * @generated
	 */
	EReference getStudio_ProducedMovies();

	/**
	 * Returns the meta object for the attribute '{@link movies.Episode#getProductionCountry <em>Production Country</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Production Country</em>'.
	 * @see movies.Episode#getProductionCountry()
	 * @see #getEpisode()
	 * @generated
	 */
	EAttribute getEpisode_ProductionCountry();

	/**
	 * Returns the meta object for enum '{@link movies.MovieCategory <em>Movie Category</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Movie Category</em>'.
	 * @see movies.MovieCategory
	 * @generated
	 */
	EEnum getMovieCategory();

	/**
	 * Returns the meta object for enum '{@link movies.Gender <em>Gender</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Gender</em>'.
	 * @see movies.Gender
	 * @generated
	 */
	EEnum getGender();

	/**
	 * Returns the meta object for enum '{@link movies.Rating <em>Rating</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Rating</em>'.
	 * @see movies.Rating
	 * @generated
	 */
	EEnum getRating();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	MoviesFactory getMoviesFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link movies.impl.MovieImpl <em>Movie</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see movies.impl.MovieImpl
		 * @see movies.impl.MoviesPackageImpl#getMovie()
		 * @generated
		 */
		EClass MOVIE = eINSTANCE.getMovie();

		/**
		 * The meta object literal for the '<em><b>Title</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MOVIE__TITLE = eINSTANCE.getMovie_Title();

		/**
		 * The meta object literal for the '<em><b>Title orig</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MOVIE__TITLE_ORIG = eINSTANCE.getMovie_Title_orig();

		/**
		 * The meta object literal for the '<em><b>Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MOVIE__TIME = eINSTANCE.getMovie_Time();

		/**
		 * The meta object literal for the '<em><b>Category</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MOVIE__CATEGORY = eINSTANCE.getMovie_Category();

		/**
		 * The meta object literal for the '<em><b>Rating</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MOVIE__RATING = eINSTANCE.getMovie_Rating();

		/**
		 * The meta object literal for the '<em><b>Overall Rating</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MOVIE__OVERALL_RATING = eINSTANCE.getMovie_OverallRating();

		/**
		 * The meta object literal for the '<em><b>Last Watch Date</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MOVIE__LAST_WATCH_DATE = eINSTANCE.getMovie_LastWatchDate();

		/**
		 * The meta object literal for the '<em><b>Loaned</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MOVIE__LOANED = eINSTANCE.getMovie_Loaned();

		/**
		 * The meta object literal for the '<em><b>Performers</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MOVIE__PERFORMERS = eINSTANCE.getMovie_Performers();

		/**
		 * The meta object literal for the '<em><b>Movie Collections</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MOVIE__MOVIE_COLLECTIONS = eINSTANCE.getMovie_MovieCollections();

		/**
		 * The meta object literal for the '<em><b>Imdb Url</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MOVIE__IMDB_URL = eINSTANCE.getMovie_ImdbUrl();

		/**
		 * The meta object literal for the '<em><b>Ofdb ID</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MOVIE__OFDB_ID = eINSTANCE.getMovie_OfdbID();

		/**
		 * The meta object literal for the '<em><b>Loanable</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MOVIE__LOANABLE = eINSTANCE.getMovie_Loanable();

		/**
		 * The meta object literal for the '<em><b>Loaned Until</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MOVIE__LOANED_UNTIL = eINSTANCE.getMovie_LoanedUntil();

		/**
		 * The meta object literal for the '{@link movies.impl.MovieCollectionImpl <em>Movie Collection</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see movies.impl.MovieCollectionImpl
		 * @see movies.impl.MoviesPackageImpl#getMovieCollection()
		 * @generated
		 */
		EClass MOVIE_COLLECTION = eINSTANCE.getMovieCollection();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MOVIE_COLLECTION__NAME = eINSTANCE.getMovieCollection_Name();

		/**
		 * The meta object literal for the '<em><b>Movies</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MOVIE_COLLECTION__MOVIES = eINSTANCE.getMovieCollection_Movies();

		/**
		 * The meta object literal for the '{@link movies.impl.PerformerImpl <em>Performer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see movies.impl.PerformerImpl
		 * @see movies.impl.MoviesPackageImpl#getPerformer()
		 * @generated
		 */
		EClass PERFORMER = eINSTANCE.getPerformer();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PERFORMER__NAME = eINSTANCE.getPerformer_Name();

		/**
		 * The meta object literal for the '<em><b>Gender</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PERFORMER__GENDER = eINSTANCE.getPerformer_Gender();

		/**
		 * The meta object literal for the '<em><b>Rating</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PERFORMER__RATING = eINSTANCE.getPerformer_Rating();

		/**
		 * The meta object literal for the '<em><b>Movies</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PERFORMER__MOVIES = eINSTANCE.getPerformer_Movies();

		/**
		 * The meta object literal for the '<em><b>Ofdb ID</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PERFORMER__OFDB_ID = eINSTANCE.getPerformer_OfdbID();

		/**
		 * The meta object literal for the '<em><b>Loanable</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PERFORMER__LOANABLE = eINSTANCE.getPerformer_Loanable();

		/**
		 * The meta object literal for the '{@link movies.impl.SeriesImpl <em>Series</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see movies.impl.SeriesImpl
		 * @see movies.impl.MoviesPackageImpl#getSeries()
		 * @generated
		 */
		EClass SERIES = eINSTANCE.getSeries();

		/**
		 * The meta object literal for the '<em><b>Title</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERIES__TITLE = eINSTANCE.getSeries_Title();

		/**
		 * The meta object literal for the '<em><b>Studio</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERIES__STUDIO = eINSTANCE.getSeries_Studio();

		/**
		 * The meta object literal for the '<em><b>Broadcasted By</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERIES__BROADCASTED_BY = eINSTANCE.getSeries_BroadcastedBy();

		/**
		 * The meta object literal for the '<em><b>Release Date</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERIES__RELEASE_DATE = eINSTANCE.getSeries_ReleaseDate();

		/**
		 * The meta object literal for the '<em><b>Seasons</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SERIES__SEASONS = eINSTANCE.getSeries_Seasons();

		/**
		 * The meta object literal for the '<em><b>Rating</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERIES__RATING = eINSTANCE.getSeries_Rating();

		/**
		 * The meta object literal for the '<em><b>Performers</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SERIES__PERFORMERS = eINSTANCE.getSeries_Performers();

		/**
		 * The meta object literal for the '<em><b>Production Country</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERIES__PRODUCTION_COUNTRY = eINSTANCE.getSeries_ProductionCountry();

		/**
		 * The meta object literal for the '<em><b>Loaned</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERIES__LOANED = eINSTANCE.getSeries_Loaned();

		/**
		 * The meta object literal for the '<em><b>Loaned Until</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERIES__LOANED_UNTIL = eINSTANCE.getSeries_LoanedUntil();

		/**
		 * The meta object literal for the '<em><b>Loanable</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERIES__LOANABLE = eINSTANCE.getSeries_Loanable();

		/**
		 * The meta object literal for the '<em><b>Allpartsloanable</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERIES__ALLPARTSLOANABLE = eINSTANCE.getSeries_Allpartsloanable();

		/**
		 * The meta object literal for the '<em><b>Allpartsloaned</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERIES__ALLPARTSLOANED = eINSTANCE.getSeries_Allpartsloaned();

		/**
		 * The meta object literal for the '<em><b>Partsloaned</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERIES__PARTSLOANED = eINSTANCE.getSeries_Partsloaned();

		/**
		 * The meta object literal for the '{@link movies.impl.SeasonImpl <em>Season</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see movies.impl.SeasonImpl
		 * @see movies.impl.MoviesPackageImpl#getSeason()
		 * @generated
		 */
		EClass SEASON = eINSTANCE.getSeason();

		/**
		 * The meta object literal for the '<em><b>Title</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SEASON__TITLE = eINSTANCE.getSeason_Title();

		/**
		 * The meta object literal for the '<em><b>Release Date</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SEASON__RELEASE_DATE = eINSTANCE.getSeason_ReleaseDate();

		/**
		 * The meta object literal for the '<em><b>Episodes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SEASON__EPISODES = eINSTANCE.getSeason_Episodes();

		/**
		 * The meta object literal for the '<em><b>Series</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SEASON__SERIES = eINSTANCE.getSeason_Series();

		/**
		 * The meta object literal for the '<em><b>Rating</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SEASON__RATING = eINSTANCE.getSeason_Rating();

		/**
		 * The meta object literal for the '<em><b>Performers</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SEASON__PERFORMERS = eINSTANCE.getSeason_Performers();

		/**
		 * The meta object literal for the '<em><b>Broadcasted By</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SEASON__BROADCASTED_BY = eINSTANCE.getSeason_BroadcastedBy();

		/**
		 * The meta object literal for the '<em><b>Production Country</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SEASON__PRODUCTION_COUNTRY = eINSTANCE.getSeason_ProductionCountry();

		/**
		 * The meta object literal for the '<em><b>Loaned</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SEASON__LOANED = eINSTANCE.getSeason_Loaned();

		/**
		 * The meta object literal for the '<em><b>Loaned Until</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SEASON__LOANED_UNTIL = eINSTANCE.getSeason_LoanedUntil();

		/**
		 * The meta object literal for the '<em><b>Loanable</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SEASON__LOANABLE = eINSTANCE.getSeason_Loanable();

		/**
		 * The meta object literal for the '{@link movies.impl.EpisodeImpl <em>Episode</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see movies.impl.EpisodeImpl
		 * @see movies.impl.MoviesPackageImpl#getEpisode()
		 * @generated
		 */
		EClass EPISODE = eINSTANCE.getEpisode();

		/**
		 * The meta object literal for the '<em><b>Broadcasted By</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EPISODE__BROADCASTED_BY = eINSTANCE.getEpisode_BroadcastedBy();

		/**
		 * The meta object literal for the '<em><b>Season</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EPISODE__SEASON = eINSTANCE.getEpisode_Season();

		/**
		 * The meta object literal for the '<em><b>Episode Loanable</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EPISODE__EPISODE_LOANABLE = eINSTANCE.getEpisode_EpisodeLoanable();

		/**
		 * The meta object literal for the '{@link movies.impl.DirectorImpl <em>Director</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see movies.impl.DirectorImpl
		 * @see movies.impl.MoviesPackageImpl#getDirector()
		 * @generated
		 */
		EClass DIRECTOR = eINSTANCE.getDirector();

		/**
		 * The meta object literal for the '<em><b>Num Directed Movies</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DIRECTOR__NUM_DIRECTED_MOVIES = eINSTANCE.getDirector_NumDirectedMovies();

		/**
		 * The meta object literal for the '<em><b>Movies Directed</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DIRECTOR__MOVIES_DIRECTED = eINSTANCE.getDirector_MoviesDirected();

		/**
		 * The meta object literal for the '{@link movies.impl.StudioImpl <em>Studio</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see movies.impl.StudioImpl
		 * @see movies.impl.MoviesPackageImpl#getStudio()
		 * @generated
		 */
		EClass STUDIO = eINSTANCE.getStudio();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STUDIO__NAME = eINSTANCE.getStudio_Name();

		/**
		 * The meta object literal for the '<em><b>Founded</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STUDIO__FOUNDED = eINSTANCE.getStudio_Founded();

		/**
		 * The meta object literal for the '<em><b>Produced Movies</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STUDIO__PRODUCED_MOVIES = eINSTANCE.getStudio_ProducedMovies();

		/**
		 * The meta object literal for the '<em><b>Production Country</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EPISODE__PRODUCTION_COUNTRY = eINSTANCE.getEpisode_ProductionCountry();

		/**
		 * The meta object literal for the '{@link movies.MovieCategory <em>Movie Category</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see movies.MovieCategory
		 * @see movies.impl.MoviesPackageImpl#getMovieCategory()
		 * @generated
		 */
		EEnum MOVIE_CATEGORY = eINSTANCE.getMovieCategory();

		/**
		 * The meta object literal for the '{@link movies.Gender <em>Gender</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see movies.Gender
		 * @see movies.impl.MoviesPackageImpl#getGender()
		 * @generated
		 */
		EEnum GENDER = eINSTANCE.getGender();

		/**
		 * The meta object literal for the '{@link movies.Rating <em>Rating</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see movies.Rating
		 * @see movies.impl.MoviesPackageImpl#getRating()
		 * @generated
		 */
		EEnum RATING = eINSTANCE.getRating();

	}

} //MoviesPackage
