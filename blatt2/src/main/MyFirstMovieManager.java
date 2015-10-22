package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import java.util.List;

/**
 * The Class MyFirstMovieManager.
 *  @version 1.2.95
 */
public class MyFirstMovieManager {


  /** The map. */
  private final Map<Movie, ArrayList<Performer>> map;

  /**Instantiates a new my first movie manager.

   */
  public  MyFirstMovieManager() {

    map = new HashMap<Movie, ArrayList<Performer>>();
  } // Constructor

  /** void addPerformer(Movie getMovie, Performer getPerformer).

   * Blatt 1, Aufgabe 1.3
   * Relase v1.0.7
   *
   * @param getMovie the get movie
   * @param getPerformer the get performer
   */

  public final void addPerformer(final Movie getMovie,
      final Performer getPerformer)  {
    List<Performer> performers = map.get(getMovie);           //
    if  (performers == null)  {
      // wenn keinen prf, erzugen nen neuen
      performers = new ArrayList<Performer>();
    }

    if  (!performers.contains(getPerformer))  {
      performers.add(getPerformer);
      map.put(getMovie, (ArrayList<Performer>)  performers);
    }
  }

  /** public void clearPerformers(Movie getMovie).

   * Blatt 1, Aufgabe 1.3
   * Relase v1.0.7
   *
   * @param getMovie the get movie
   */

  public final void clearPerformers(final Movie getMovie) {
    final List<Performer> performers = map.get(getMovie);
    if  (performers != null)  {
      performers.clear();
      map.put(getMovie, (ArrayList<Performer>)  performers);
    }
  }

  /**
   * Gets the performers.
   *
   * @param getMovie the get movie
   * @return the performers
   */
  // gibt alle performers ins Movie
  public final List<Performer> getPerformers(final Movie getMovie)  {
    return map.get(getMovie);
  }

  /**
   *  public void clearPerformers(Movie getMovie).
   * Blatt 1, Aufgabe 1.3
   * Relase v1.0.9
   *
   * @param movie the movie
   * @param ii the ii
   * @return the performer
   */

  public final Performer getPerformer(final Movie movie, final int ii) {
    final List<Performer>  performers = this.getPerformers(movie);
    if  (performers != null && performers.size() > ii)  {
      return performers.get(ii);
    } else {
      return null;
    }
  }

  /**
   *  getOutstandingPerformers(Movie movie).
   * Blatt 1, Aufgabe 1.3
   * Relase v1.0.42
   *
   * @param movie the movie
   * @return the outstanding performers
   */
  public final List<Performer> getOutstandingPerformers(final Movie movie)  {
    final List<Performer> performers = this.getPerformers(movie);

    final  List<Performer> returnList = new ArrayList<Performer>();
    for (Performer performer : performers)  {
      if  (performer.isOutstanding()) {
        returnList.add(performer);
      }
    }
    return returnList;
  }

  /**
   *  searchPerformer(Movie getMovie, String byName).
   * Blatt 1, Aufgabe 1.3
   * Relase v1.0.48
   *
   * @param getMovie the get movie
   * @param byName the by name
   * @return the boolean
   */
  public final Boolean searchPerformer(final Movie getMovie,
      final String byName) {
    final List<Performer> performers = this.getPerformers(getMovie);
    for (Performer performer : performers)  {
      if  (performer.getFirstname().equalsIgnoreCase(byName)
          &&  performer.getLastname().equalsIgnoreCase(byName)) {
        return true;
      }
    }
    return false;
  }

/**
 * The main method.
 *
 * @author isw15044
 * @param args the arguments
 */

  public static void main(final String[] args)  {
    final MyFirstMovieManager manager = new MyFirstMovieManager();
    final Movie futurama = new Movie("Futurama", 100500);
    System.out.println(futurama);
    final Performer fry = new Performer("Philip J.", "Fry", Gender.MALE);
    final Performer leela = new Performer("Turanga", "Leela", Gender.FEMALE);
    final Performer bender = new Performer("Bieger Rodriguez",
        "Bender ", Gender.MALE);
    final Performer zoidberg = new Performer("Dr. John", "Zoidberg",
        Gender.MALE);
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
    System.out.println("Outstanding Performers : "
        + manager.getOutstandingPerformers(futurama));

    leela.setLastname(fry.getLastname());
    System.out.println("Fry + Leela  = "  +  leela.getLastname()
        + " " + leela.getFirstname());

    if  (manager.searchPerformer(futurama, "Vader").equals(futurama)) {
      System.out.println("Performer not in this movie");
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
