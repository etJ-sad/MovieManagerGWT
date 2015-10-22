package main;

import java.util.LinkedList;
import java.util.List;

/** Customer Class.
   * @version 2.2.228
   */
public class Customer {

  /** The Constant MAX_MOVIE_LOANS. */
  private static final int MAX_MOVIE_LOANS = 5;

  /** The name. */
  private final String name;

  /** The loaned movie. */
  private final List<Movie> loanedMovie;

/**
 *  loanMovie(Movie movie).
 * @param movie the movie
 * @return true, if successful
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
   * @param args the arguments
   */
  public static void main(final String[] args)  {
    final Customer alex = new Customer("Alex");
    final Customer oliver  = new Customer("Oliver");

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

