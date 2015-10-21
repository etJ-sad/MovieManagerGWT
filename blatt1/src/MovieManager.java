/*
 * Soloninov Aleksandr, ESW WS 15|16
 * 
 * Blatt 1, Aufgabe 1.3
 * 
 */


import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class MovieManager {
	
	public Map <Movie, ArrayList<Performer> > map;
    // Constructor
	public  MovieManager(){
	
		 map = new HashMap<Movie, ArrayList<Performer>>();  // Erzeuge die Map

	} // Constructor
	
	public void addPerformer(Movie getMovie, Performer getPerformer){ 
		List<Performer> performers = map.get(getMovie);           //
		if(performers == null){
			performers = new ArrayList<Performer>();
		}

		if(!performers.contains(getPerformer)){
			performers.add(getPerformer);
			map.put(getMovie, (ArrayList<Performer>)performers);
		}
	}

	public void clearPerformers(Movie getMovie){
		final List<Performer> performers = map.get(getMovie);
		if(performers != null ) {
			performers.clear();
			map.put(getMovie, (ArrayList<Performer>)performers);
		}
	}

	public List<Performer> getPerformers(Movie getMovie){
		return map.get(getMovie);
	}

	public Performer getPerformer(Movie movie, int i){
		List <Performer> performers = this.getPerformers(movie);
		if(performers != null && performers.size() > i){
			return performers.get(i);
		}
		else{
			return null;
		}
	}

	public List<Performer> getOutstandingPerformers(Movie movie){
		List<Performer> performers = this.getPerformers(movie);
		List<Performer> returnList = new ArrayList<Performer>();
		for(Performer performer : performers){
			if(performer.isOutstanding()) {
				returnList.add(performer);
			}
		}
		return returnList;
	}
	
	public Boolean searchPerformer(Movie getMovie, String byName) {
		List<Performer> performers = this.getPerformers(getMovie);
		for(Performer performer : performers){
			if(performer.getFirstname().equalsIgnoreCase(byName) && performer.getLastname().equalsIgnoreCase(byName)) {
				return true;
			}
		}
		return false;
	}
	
	
	public static void main(String args[]) {
		
		MovieManager Manager = new MovieManager();
		Movie Futurama = new Movie("Futurama", 100500);
	
		System.out.println(Futurama);
		System.out.println("\n");
		
		Performer Fry = new Performer("Philip J.", "Fry", Gender.MALE);
		Performer Leela = new Performer("Turanga", "Leela", Gender.FEMALE);
		Performer Bender = new Performer("Bieger Rodriguez", "Bender ", Gender.MALE);
		Performer Zoidberg = new Performer("Dr. John", "Zoidberg", Gender.MALE);
		Performer Conrad = new Performer("Hermes", "Conrad", Gender.MALE);
		Performer Amy = new Performer("Wong", "Amy", Gender.FEMALE);
		
		Bender.setOutstanding(true);
		Zoidberg.setOutstanding(true);
		
		Manager.addPerformer(Futurama, Fry);
		Manager.addPerformer(Futurama, Leela);
		Manager.addPerformer(Futurama, Bender);
		Manager.addPerformer(Futurama, Zoidberg);
		Manager.addPerformer(Futurama, Conrad);
		Manager.addPerformer(Futurama, Amy);
			
		
		System.out.println(Manager.getPerformers(Futurama));
		System.out.println("Outstanding Performers : " + Manager.getOutstandingPerformers(Futurama));
		
		Leela.setLastname(Fry.getLastname());
		System.out.println("Fry + Leela  = " + Leela.getLastname() + " " + Leela.getFirstname());
		
		if (Manager.searchPerformer(Futurama, "Vader") == false ) 
			{ System.out.println("Performer not in this movie" ); }
		else { System.out.println("Performer is in this movie"); }

		System.out.println("Futurama is closed  :( ");
		Manager.clearPerformers(Futurama);
		System.out.println("0 Performers " + Manager.getPerformers(Futurama));
	}
}

/*
 * ArrayList:
 * - Implementiert ein Array -> Schneller Indexzugriff
 * - Langsame Suche nach Schlüsseln
 * - Implementiert nicht direkt eine Map -> Zuordnung müsste extern geschehen
 * 
 * HashSet:
 * - Implementiert eine gehashte Menge -> Schneller Schlüsselzugriff
 * - Keine Reihenfolge definierbar
 * - Implementiert nicht direkt eine Map -> Zuordnung müsste extern geschehen
 * 
 * HashMap:
 * - Implementierte eine gehashte Zuordnung -> Schneller Schlüsseszugriff
 * - Keine Reihenfolge definierbar
 * - Zugriff und Suche nach Wert langsam
 */