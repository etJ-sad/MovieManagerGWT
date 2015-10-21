/** Movie Class
 * ISW 15|16
 * 
 * @autor Soloninov Aleksandr
 * @version 1.2.18   
 */

public class Movie {
  //private stack
  private String title;
  private int time;
  private int number;
  private Director director;
  private Customer customer;
  //public stack
  private static int nextNumber; // Nummer des Objekts und erhöht die Klassenvariable
  
  Movie(String getTitle, int getTime) { 

    this.time = getTime; 
    this.title = getTitle;
    this.number = nextNumber++;
  } // end Constructor

  public String getTitle() {
    return title;
  } // end getTitle()

  public void setTitle(String title) {
    this.title = title;  //
  } // end setTitle(String title)

  /* Die "this" zeigt immer auf das aktuelle Objekt der klasse.
    Bsp : wie hier, this.title zeigt auf klassevariable, "title" nun auf locale variable
    */

  public int getTime() {
    return time;
  } // end getTime()

  public void setTime(int time) {
    this.time = time;
  }

  public Director getDirector() {
    return this.director;
  }

  public void setDirector(Director director) {
    this.director = director;
  }

  public Customer getCustomer() {
    return this.customer;
  }

  public void setCustomer(Customer customer) {
    this.customer = customer;
  }
  
  public int getNumber() {
    return number;
  }

  public void setNumber(int number) {
    this.number = number;
  }

  public static int getNextNumber() {
    return nextNumber;
  }

  public static void setNextNumber(int getNextNumber) {
    nextNumber = getNextNumber;
  }
  
  /** showInformation
   * ISW 15|16
   * 
   * @autor Soloninov Aleksandr
   * @version 2.0.7:3772   
   */
  
  public void showInformation() {
    System.out.println("Title : " + this.title);
    System.out.println("time : " + this.time);
    System.out.println("Number : " + number);
    System.out.println("nextNumber : " + nextNumber);
  }

  // bracuht man zum con @ to string
  public String toString() {
    return this.title + " is over " + this.time + " minutes long.";
  }
  
  /** Main
   * 
   * @autor Soloninov Aleksandr
   * @version 1.12   
   */
  public static void main(String[] args) {
    final Movie zero;
    zero = new Movie("zero", 0);
    zero.showInformation();
    
    final Movie one = new Movie("one",1);
    one.showInformation();
  }
}

