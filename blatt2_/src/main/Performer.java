package main;

/** Performer Class.
 * @version 1.1.30:relase
 */

public class Performer {

  /** The firstname. */
  private String firstname;

  /** The lastname. */
  private String lastname;

  /** The gender. */
  private Gender gender;

  /** The movie. */
  private Movie movie;

  /** The outstanding. */
  private Boolean outstanding  = false;

  /**
   *  Constructor.
   * @param getFirstName the get first name
   * @param getLastName the get last name
   * @param getGender the get gender
   */
  Performer(final String getFirstName,  final String getLastName,
        final Gender getGender) {
    this.firstname = getFirstName;
    this.lastname = getLastName;
    this.gender = getGender;
  }

  /**
   *  getFirstname.
   * @return the firstname
   */
  public final String getFirstname() {
    return this.firstname;
  }

  /** setFirstname.
   * @param getFirstname the new firstname
   */
  public final void  setFirstname(final String getFirstname) {
    this.firstname = getFirstname;
  }

  /** getLastname().
   * @return the lastname
   */
  public final String getLastname() {
    return this.lastname;
  }
  /**
   * Sets the lastname.
   *
   * @param getLastname the new lastname
   */
  public final void setLastname(final String getLastname) {
    this.lastname = getLastname;
  }

  /**
   * Gets the gender.
   *
   * @return the gender
   */
  public final Gender getGender() {
    return this.gender;
  }

  /**
   * Sets the gender.
   *
   * @param getGender the new gender
   */
  public final void setGender(final Gender getGender) {
    this.gender = getGender;
  }

  /**
   * Gets the movie.
   *
   * @return the movie
   */
  public final Movie getMovie() {
    return movie;
  }

  /**
   * Sets the movie.
   *
   * @param getMovie the new movie
   */
  public final void setMovie(final Movie getMovie) {
    this.movie = getMovie;
  }

  /**
   * Sets the outstanding.
   *
   * @param getOutstanding the new outstanding
   */
  public final void setOutstanding(final Boolean getOutstanding) {
    this.outstanding = getOutstanding;
  }
  /**
   * Checks if is outstanding.
   *
   * @return true, if is outstanding
   */
  // getter();
  public final boolean isOutstanding() {
    return this.outstanding;
  }
  // braucht man zum conv @ to string

  /** (non-Javadoc).
   * @see java.lang.Object#toString()
   * @return Performer list
   */
  @Override
  public final String toString()  {
    return "Performer >> " + firstname + " "
        + lastname + " is " +  " " + gender;
  }
}


