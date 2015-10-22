package main;


/**  Director Class.
 * Aufgabe 2.2 ISW 15|16
 * <b>movieCounter</b>
 *
 * @version 2.2.8

 */

public class Director extends Performer {

  /** The movie counter. */
  private  int movieCounter;

  /**
   * Gets the movie count.
   *
   * @return the movie count
   */
  //@getter
  public final int getMovieCount() {
    return this.movieCounter;
  }
  /**
   * Sets the movie count.
   *
   * @param movieCount the new movie count
   */
  public final void setMovieCount(final int movieCount) {
    this.movieCounter = movieCount;
  }

  /**
   * Instantiates a new director.
   *
   * @param getFirstname the get firstname
   * @param getLastname the get lastname
   * @param getGender the get gender
   * @param getMovieCounter the get movie counter
   */

  public Director(final String getFirstname,  final String getLastname,
      final Gender getGender, final int getMovieCounter) {
    super(getFirstname, getLastname, getGender);
    this.movieCounter = getMovieCounter;
  }

}
