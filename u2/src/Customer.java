/** Customer Class
 * Aufgabe 2.1 ISW 15|16
 * <b>movieCounter</b>
 * @autor Soloninov Aleksandr
 * @version 2.2.227   
 */

import java.util.LinkedList;
import java.util.List;

public class Customer {
  private String name;
  final List<Movie> loanedMovie;
  
  /** loanMovie(Movie movie)
   * <b>movie</b>
   * @autor Soloninov Aleksandr
   * @version 2.2.226
   */
  
  public boolean loanMovie(Movie movie) {

    // 0, 1, 2, 3 ,4
    if  (loanedMovie.size() < 5)  {
      // wenn keinen Customer da ist
      if  (movie.getCustomer() == null) {
        // put rein
        loanedMovie.add(movie);
        // man can auch "name" schreiben
        movie.setCustomer(this);
        return true;
      } else {
        System.out.println("Film ist schon an " + movie.getCustomer() + " verliehen");
        return false; 
      }
    } else { 
      System.out.println("Kunde "  + this +  " hat  "  + movie.getNumber() + " Filme ausgeliehen");
      return false;
    }
  }

  public String toString() {
    return this.name;
  }

  public Customer(String name) {
    this.name = name;
    this.loanedMovie = new LinkedList<Movie>();
  }
  
  /** main 
   * 
   * @autor Soloninov Aleksandr
   * @version 2.2.19   
   */

  public static void main(String[] args)  {
    final Customer alex = new Customer("Alex");
    final Customer miranda  = new Customer("Miranda");

    final Movie futurama = new Movie("Futurama", 1);

    alex.loanMovie(futurama);
    miranda.loanMovie(futurama);
    
    final Movie starWarsOne = new Movie("Star Wars I", 2);
    final Movie starWarsTwo = new Movie("Star Wars II", 2);
    final Movie starWarsThree = new Movie("Star Wars III", 2);
    final Movie starWarsFour = new Movie("Star Wars IV", 2);
    final Movie starWarsFive = new Movie("Star Wars V", 2);
    final Movie starWarsSix = new Movie("Star Wars VI", 2);

    miranda.loanMovie(starWarsOne);
    miranda.loanMovie(starWarsTwo);
    miranda.loanMovie(starWarsThree);
    miranda.loanMovie(starWarsFour);
    miranda.loanMovie(starWarsFive);
    miranda.loanMovie(starWarsSix);
    
  }

}
