
/** Director Class
 * Aufgabe 2.2 ISW 15|16
 * <b>movieCounter</b>
 * @autor Soloninov Aleksandr
 * @version 2.2.8   
 */

public class Director extends Performer {

  private  int movieCounter;
  //@getter
  public int getMovieCount() {   
    return this.movieCounter; 
  }
  //@setter
  public void setMovieCount(int movieCount) {
    this.movieCounter = movieCount;
  }
  //@constructor
  public Director(String getFirstname, String getLastname, Gender getGender, int getMovieCounter) {
    super(getFirstname, getLastname, getGender);
    this.movieCounter = getMovieCounter;
  }

}
