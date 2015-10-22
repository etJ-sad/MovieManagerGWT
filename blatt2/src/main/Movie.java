package main;

/**
 * Movie Class.
 * @version 2.2.43

 */

public class Movie {
  /** The title. */
  private static final int ARG_ONE = 1;

  /** The title. */
  //private stack
  private String title;

  /** The time. */
  private int time;

  /** The number. */
  private int number;

  /** The director. */
  private Director director;

  /** The customer. */
  private Customer customer;

  /** The next number. */
  //public stack
  private static int nextNumber;

  /**
   * Instantiates a new movie.
   *
   * @param getTitle the get title
   * @param getTime the get time
   */
  Movie(final String getTitle, final int getTime) {
    this.time = getTime;
    this.title = getTitle;
    this.number = nextNumber++;
  } // end Constructor

  /**
   * Gets the title.
   *
   * @return the title
   */
  public final String getTitle() {
    return title;
  } // end getTitle()

  /**
   * Sets the title.
   *
   * @param getTitle the new title
   */
  public final void setTitle(final String getTitle) {
    this.title = getTitle;  //
  } // end setTitle(String title)

  /* Die "this" zeigt immer auf das aktuelle Objekt der klasse.
    Bsp : wie hier, this.title zeigt auf klassevariable,
    "title" nun auf locale variable
    */

  /**
   * Gets the time.
   *
   * @return the time
   */
  public final int getTime() {
    return time;
  } // end getTime()

  /**
   * Sets the time.
   *
   * @param getTime the new time
   */
  public final void setTime(final int getTime) {
    this.time = getTime;
  }

  /**
   * Gets the director.
   *
   * @return the director
   */
  public final Director getDirector() {
    return this.director;
  }

  /**
   * Sets the director.
   *
   * @param getDirector the new director
   */
  public final void setDirector(final Director getDirector) {
    this.director = getDirector;
  }

  /**
   * Gets the customer.
   *
   * @return the customer
   */
  public final Customer getCustomer() {
    return this.customer;
  }

  /**
   * Sets the customer.
   *
   * @param getCustomer the new customer
   */
  public final void setCustomer(final Customer getCustomer) {
    this.customer = getCustomer;
  }
  /**
   * Gets the number.
   *
   * @return the number
   */
  public final int getNumber() {
    return number;
  }

  /**
   * Sets the number.
   *
   * @param getNumber the new number
   */
  public final void setNumber(final int getNumber) {
    this.number = getNumber;
  }

  /**
   * Gets the next number.
   *
   * @return the next number
   */
  public static int getNextNumber() {
    return nextNumber;
  }

  /**
   * Sets the next number.
   *
   * @param getNextNumber the new next number
   */
  public static void setNextNumber(final  int getNextNumber) {
    nextNumber = getNextNumber;
  }
  /**
   *  showInformation
   * ISW 15|16.
   *
   * @version 2.2.8
   * @autor Soloninov Aleksandr
   */

  public final void showInformation() {
    System.out.println("Title : " + this.title);
    System.out.println("time : " + this.time);
    System.out.println("Number : " + number);
    System.out.println("nextNumber : " + nextNumber);
  }

  /**
   *  (non-Javadoc).
   *
   * @return Performer list
   * @see java.lang.Object#toString()
   */
  @Override
  public final String toString() {
    return this.title + " is over " + this.time + " minutes long.";
  }

  /**
   *  Main.
   *
   * @version 1.0.4
   * @param args the arguments
   * @autor Soloninov Aleksandr
   */
  public static void main(final String[] args) {
    final Movie zero;
    zero = new Movie("zero", 0);
    zero.showInformation();

    final Movie one = new Movie("one",  ARG_ONE);
    one.showInformation();
  }
}

