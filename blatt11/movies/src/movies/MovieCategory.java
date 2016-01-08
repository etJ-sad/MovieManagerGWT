/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package movies;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Movie Category</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see movies.MoviesPackage#getMovieCategory()
 * @model
 * @generated
 */
public enum MovieCategory implements Enumerator {
	/**
	 * The '<em><b>Action</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ACTION_VALUE
	 * @generated
	 * @ordered
	 */
	ACTION(0, "Action", "Action"),

	/**
	 * The '<em><b>Science Fiction</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SCIENCE_FICTION_VALUE
	 * @generated
	 * @ordered
	 */
	SCIENCE_FICTION(1, "ScienceFiction", "ScienceFiction"),

	/**
	 * The '<em><b>Comedy</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #COMEDY_VALUE
	 * @generated
	 * @ordered
	 */
	COMEDY(2, "Comedy", "Comedy"), /**
	 * The '<em><b>Music</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MUSIC_VALUE
	 * @generated
	 * @ordered
	 */
	MUSIC(3, "Music", "Music"), /**
	 * The '<em><b>Drama</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DRAMA_VALUE
	 * @generated
	 * @ordered
	 */
	DRAMA(4, "Drama", "Drama"), /**
	 * The '<em><b>Thriller</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #THRILLER_VALUE
	 * @generated
	 * @ordered
	 */
	THRILLER(5, "Thriller", "Thriller"), /**
	 * The '<em><b>Horror</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #HORROR_VALUE
	 * @generated
	 * @ordered
	 */
	HORROR(6, "Horror", "Horror"), /**
	 * The '<em><b>Fantasy</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FANTASY_VALUE
	 * @generated
	 * @ordered
	 */
	FANTASY(7, "Fantasy", "Fantasy"), /**
	 * The '<em><b>Adventure</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ADVENTURE_VALUE
	 * @generated
	 * @ordered
	 */
	ADVENTURE(8, "Adventure", "Adventure"), /**
	 * The '<em><b>Romance</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ROMANCE_VALUE
	 * @generated
	 * @ordered
	 */
	ROMANCE(9, "Romance", "Romance"), /**
	 * The '<em><b>Documentation</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DOCUMENTATION_VALUE
	 * @generated
	 * @ordered
	 */
	DOCUMENTATION(10, "Documentation", "Documentation");

	/**
	 * The '<em><b>Action</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Action</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ACTION
	 * @model name="Action"
	 * @generated
	 * @ordered
	 */
	public static final int ACTION_VALUE = 0;

	/**
	 * The '<em><b>Science Fiction</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Science Fiction</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SCIENCE_FICTION
	 * @model name="ScienceFiction"
	 * @generated
	 * @ordered
	 */
	public static final int SCIENCE_FICTION_VALUE = 1;

	/**
	 * The '<em><b>Comedy</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Comedy</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #COMEDY
	 * @model name="Comedy"
	 * @generated
	 * @ordered
	 */
	public static final int COMEDY_VALUE = 2;

	/**
	 * The '<em><b>Music</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Music</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MUSIC
	 * @model name="Music"
	 * @generated
	 * @ordered
	 */
	public static final int MUSIC_VALUE = 3;

	/**
	 * The '<em><b>Drama</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Drama</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DRAMA
	 * @model name="Drama"
	 * @generated
	 * @ordered
	 */
	public static final int DRAMA_VALUE = 4;

	/**
	 * The '<em><b>Thriller</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Thriller</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #THRILLER
	 * @model name="Thriller"
	 * @generated
	 * @ordered
	 */
	public static final int THRILLER_VALUE = 5;

	/**
	 * The '<em><b>Horror</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Horror</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #HORROR
	 * @model name="Horror"
	 * @generated
	 * @ordered
	 */
	public static final int HORROR_VALUE = 6;

	/**
	 * The '<em><b>Fantasy</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Fantasy</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FANTASY
	 * @model name="Fantasy"
	 * @generated
	 * @ordered
	 */
	public static final int FANTASY_VALUE = 7;

	/**
	 * The '<em><b>Adventure</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Adventure</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ADVENTURE
	 * @model name="Adventure"
	 * @generated
	 * @ordered
	 */
	public static final int ADVENTURE_VALUE = 8;

	/**
	 * The '<em><b>Romance</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Romance</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ROMANCE
	 * @model name="Romance"
	 * @generated
	 * @ordered
	 */
	public static final int ROMANCE_VALUE = 9;

	/**
	 * The '<em><b>Documentation</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Documentation</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DOCUMENTATION
	 * @model name="Documentation"
	 * @generated
	 * @ordered
	 */
	public static final int DOCUMENTATION_VALUE = 10;

	/**
	 * An array of all the '<em><b>Movie Category</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final MovieCategory[] VALUES_ARRAY =
		new MovieCategory[] {
			ACTION,
			SCIENCE_FICTION,
			COMEDY,
			MUSIC,
			DRAMA,
			THRILLER,
			HORROR,
			FANTASY,
			ADVENTURE,
			ROMANCE,
			DOCUMENTATION,
		};

	/**
	 * A public read-only list of all the '<em><b>Movie Category</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<MovieCategory> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Movie Category</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static MovieCategory get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			MovieCategory result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Movie Category</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static MovieCategory getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			MovieCategory result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Movie Category</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static MovieCategory get(int value) {
		switch (value) {
			case ACTION_VALUE: return ACTION;
			case SCIENCE_FICTION_VALUE: return SCIENCE_FICTION;
			case COMEDY_VALUE: return COMEDY;
			case MUSIC_VALUE: return MUSIC;
			case DRAMA_VALUE: return DRAMA;
			case THRILLER_VALUE: return THRILLER;
			case HORROR_VALUE: return HORROR;
			case FANTASY_VALUE: return FANTASY;
			case ADVENTURE_VALUE: return ADVENTURE;
			case ROMANCE_VALUE: return ROMANCE;
			case DOCUMENTATION_VALUE: return DOCUMENTATION;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private MovieCategory(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getValue() {
	  return value;
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
	public String getLiteral() {
	  return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}
	
} //MovieCategory
