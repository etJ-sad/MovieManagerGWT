/** Soloninov Aleksandr, ISW WS 15|16
 * Blatt 1, Aufgabe 1.3
 * Relase v2.1.28
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class MyFirstMovieManager {
  private final Map<Movie, ArrayList<Performer>> map;

  public  MyFirstMovieManager() {
    this.map = new HashMap<Movie, ArrayList<Performer>>();// Erzeugen die Map
  } // Constructor
  
  /** void addPerformer(Movie getMovie, Performer getPerformer)
   * Blatt 1, Aufgabe 1.3
   * Relase v1.0.7
   */
  
  public void addPerformer(Movie getMovie, Performer getPerformer)  {
    List<Performer> performers = this.map.get(getMovie);           //
    if  (performers == null)  {
      // wenn keinen prf, erzugen nen neuen
      performers = new ArrayList<Performer>();
    }

    if  (!performers.contains(getPerformer))  {
      performers.add(getPerformer);
      this.map.put(getMovie, (ArrayList<Performer>)performers);
    }
  }
  
  /** public void clearPerformers(Movie getMovie)
   * Blatt 1, Aufgabe 1.3
   * Relase v1.0.7
   */

  public void clearPerformers(Movie getMovie) {
    final List<Performer> performers = this.map.get(getMovie);
    if  (performers != null)  {
      performers.clear();
      this.map.put(getMovie, (ArrayList<Performer>)performers);
    }
  }
  // gibt alle performers ins Movie
  public List<Performer> getPerformers(Movie getMovie)  {
    return this.map.get(getMovie);
  }
  
  /** public void clearPerformers(Movie getMovie)
   * Blatt 1, Aufgabe 1.3
   * Relase v1.0.7
   */
  
  public Performer getPerformer(Movie movie, int ii) {
    final List<Performer>  performers = this.getPerformers(movie);
    if  (performers != null && performers.size() > ii )  {
      return performers.get(ii);
    } else {
      return null;
    }
  }
  /** getOutstandingPerformers(Movie movie)
   * Blatt 1, Aufgabe 1.3
   * Relase v1.0.7
   */
  public List<Performer> getOutstandingPerformers(Movie movie)  {
    final List<Performer> performers = this.getPerformers(movie);

    final  List<Performer> returnList = new ArrayList<Performer>();
    for (Performer performer : performers)  {
      if  (performer.isOutstanding()) {
        returnList.add(performer);
      }
    }
    return returnList;
  }
  /** searchPerformer(Movie getMovie, String byName)
   * Blatt 1, Aufgabe 1.3
   * Relase v1.0.7
   */
  public Boolean searchPerformer(Movie getMovie, String byName) {
    final List<Performer> performers = this.getPerformers(getMovie);
    for (Performer performer : performers)  {
      if  (performer.getFirstname().equalsIgnoreCase(byName)
          &&  performer.getLastname().equalsIgnoreCase(byName)) {
        return true;
      }
    }
    return false;
  }
  
  /** searchPerformer(Movie getMovie, String byName)
   * Blatt 1, Aufgabe 1.3
   * Relase v1.0.7
   */
  public static void main(String[] args)  {
    final MyFirstMovieManager manager = new MyFirstMovieManager();
    final Movie futurama = new Movie("Futurama", 100500);
    System.out.println(futurama);

    final Performer fry = new Performer("Philip J.", "Fry", Gender.MALE);
    final Performer leela = new Performer("Turanga", "Leela", Gender.FEMALE);
    final Performer bender = new Performer("Bieger Rodriguez", "Bender ", Gender.MALE);
    final Performer zoidberg = new Performer("Dr. John", "Zoidberg", Gender.MALE);
    final Performer conrad = new Performer("Hermes", "Conrad", Gender.MALE);
    final Performer amy = new Performer("Wong", "Amy", Gender.FEMALE);
    
    bender.setOutstanding(true);
    zoidberg.setOutstanding(true);

    manager.addPerformer(futurama, fry);
    manager.addPerformer(futurama, leela);
    manager.addPerformer(futurama, bender);
    manager.addPerformer(futurama, zoidberg);
    manager.addPerformer(futurama, conrad);
    manager.addPerformer(futurama, amy);
    
    System.out.println(manager.getPerformers(futurama));
    System.out.println("Outstanding Performers : " + manager.getOutstandingPerformers(futurama));

    leela.setLastname(fry.getLastname());
    System.out.println("Fry + Leela  = "  +  leela.getLastname() + " " + leela.getFirstname());

    if  (manager.searchPerformer(futurama, "Vader").equals(futurama) ) { 
      System.out.println("Performer not in this movie" ); 
    } else  { 
      System.out.println("Performer is in this movie"); 
    }
    System.out.println("Futurama is closed  :( ");
    manager.clearPerformers(futurama);
    System.out.println("0 Performers " + manager.getPerformers(futurama));
  }
}

/*
 ArrayList:
 >> Nicht direkte Map >>  Zuordnung muesste extern geschehen
 >> Ein Array -> Schneller Indexzugriff
 >> Langsame Suche nach Schluesseln

  
 HashSet:
 >> Implementiert eine gehashte Menge >>  Schneller Schluesselzugriff
 >> Nicht direkte Map >>  Zuordnung muesste extern geschehen
 >> Keine Reihenfolge definierbar

  
 HashMap:
 >> Suche und Zugriff  sind langsam
 >> Gehashte Zuordnung >>  Schneller Schluesseszugriff
 >> Keine Reihenfolge definierbar
 */