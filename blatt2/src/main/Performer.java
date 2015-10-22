package main;

/** Soloninov Aleksandr, ISW WS 15|16
 * Blatt 1, Aufgabe 1.3
 * Relase 1.2.38
 */

/** class Performer
 * <b>firstname</b> - first name
 * <b>lastname</b> - last name
 * <b>gender</b> - gender
 * <b>movie</b> - movie
 * <b>oustanding</b> - outstanding
 * Relase 1.2.19
 */

public class Performer {
  private String firstname;
  private String lastname;
  private Gender gender;
  private Movie movie;
  private Boolean outstanding  = false;
  
  /** Constructor 
   * <b>getFastName</b>
   * <b>getLastName</b>
   * <b>getGender</b>
   * Relase 1.2.20
   */
  Performer(String getFirstName, String getLastName, Gender getGender)  {
    this.firstname = getFirstName;   
    this.lastname = getLastName;
    this.gender = getGender;
  }
  
  /** getFirstname() 
   * <b>this.firstname</b>
   * Relase 1.2.20
   */
  
  public String getFirstname() {
    return this.firstname;
  }
  
  /** setFirstname(String firstname) 
   * <b>firstname</b>
   * Relase 1.2.20
   */
  
  public void setFirstname(String firstname) {
    this.firstname = firstname;
  }
  
  /** getLastname() 
   * <b>this.lastname</b>
   * Relase 1.2.20
   */
  
  public String getLastname() {
    return this.lastname;
  }
  
  public void setLastname(String lastname) {
    this.lastname = lastname;
  }
  
  public Gender getGender() {
    return this.gender;
  }
  
  public void setGender(Gender gender) {
    this.gender = gender;
  }
  
  public Movie getMovie() {
    return movie;
  }

  public void setMovie(Movie movie) {
    this.movie = movie;
  }

  // setter()
  public void setOutstanding(Boolean outstanding) { 
    this.outstanding = outstanding; 
  }
  // getter();
  public boolean isOutstanding() {
    return this.outstanding; 
  }
  // braucht man zum conv @ to string
  
  public String toString()  {
    return "Performer >> " + firstname + " " + lastname + " is " +  " " + gender;
  }
}


