package main;


/** Customer Class
 * Aufgabe 2.1 ISW 15|16
 * <b>movieCounter</b>
 * @autor Alex, Oliver
 * @version 2.2.227
 */

import java.util.LinkedList;
import java.util.List;

/** Customer Class.
   * Aufgabe 2.1 ISW 15|16
   * <b>movieCounter</b>
   * @version 2.2.227
   */


public class Customer {

  /** The Constant MAX_MOVIE_LOANS. */
  private static final int MAX_MOVIE_LOANS = 5;

  /** The name. */
  private String name;

  /** The loaned movie. */
  private final List<Movie> loanedMovie;

/**
 *  loanMovie(Movie movie)
 * <b>movie</b>.
 *
 * @version 2.2.226
 * @param movie the movie
 * @return true, if successful
 * @autor Soloninov Aleksandr
 */

  public final boolean loanMovie(final Movie movie) {

    if  (loanedMovie.size() < MAX_MOVIE_LOANS) {
      // wenn keinen Customer da ist
      if  (movie.getCustomer() == null) {
        // put rein
        loanedMovie.add(movie);
        // man can auch "name" schreiben
        movie.setCustomer(this);
        return true;
      } else {
        System.out.println("Film ist schon an "
            + movie.getCustomer() + " verliehen");
        return false;
      }
    } else {
      System.out.println("Kunde "  + this +  " hat  "
          + movie.getNumber() + " Filme ausgeliehen");
      return false;
    }
  }

  /**
   *  toString.
   *
   * @return the string
   * @see java.lang.Object#toString()
   */
  public final String toString()  {
    return this.name;
  }

  /**
   * Instantiates a new customer.
   *
   * @param getName the name
   */
  public Customer(final String getName) {
    this.name = getName;
    this.loanedMovie = new LinkedList<Movie>();
  }

  /** main.
   *
   * @version 2.2.19
   * @param args the arguments
   * @autor Soloninov Aleksandr
   */

  public static void main(final String[] args)  {
    final Customer alex = new Customer("Alex");
    final Customer oliver  = new Customer("Miranda");

    final Movie futurama = new Movie("Futurama", 1);

    alex.loanMovie(futurama);
    oliver.loanMovie(futurama);

    final Movie starWarsOne = new Movie("Star Wars I", 2);
    final Movie starWarsTwo = new Movie("Star Wars II", 2);
    final Movie starWarsThree = new Movie("Star Wars III", 2);
    final Movie starWarsFour = new Movie("Star Wars IV", 2);
    final Movie starWarsFive = new Movie("Star Wars V", 2);
    final Movie starWarsSix = new Movie("Star Wars VI", 2);

    oliver.loanMovie(starWarsOne);
    oliver.loanMovie(starWarsTwo);
    oliver.loanMovie(starWarsThree);
    oliver.loanMovie(starWarsFour);
    oliver.loanMovie(starWarsFive);
    oliver.loanMovie(starWarsSix);

  }

}
