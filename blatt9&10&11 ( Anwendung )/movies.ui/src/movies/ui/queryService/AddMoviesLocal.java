package movies.ui.queryService;


import java.util.ArrayList;

import movies.Movie;
import movies.MovieCategory;
import movies.MoviesFactory;
import movies.MoviesPackage;
import movies.Performer;
import movies.ui.util.MovieUtil;
import movies.ui.wizards.queryWizard.InputValues;

import org.eclipse.core.runtime.preferences.ConfigurationScope;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.emfstore.client.model.util.EMFStoreCommand;
import org.eclipse.emf.emfstore.common.model.Project;
import org.osgi.service.prefs.BackingStoreException;
import org.osgi.service.prefs.Preferences;

/**
 * The Class AddMoviesLocal.
 */
public class AddMoviesLocal {
	
	
	/** The input. */
	private InputValues input;
	
	/** The local movies. */
	private EList<Movie> existingMovies = MovieUtil.getActiveProject().getAllModelElementsbyClass(MoviesPackage.eINSTANCE.getMovie(),  new BasicEList<Movie>());
	
	/** The existing performers. */
	private EList<Performer> existingPerformers = MovieUtil.getActiveProject().getAllModelElementsbyClass(MoviesPackage.eINSTANCE.getPerformer(), new BasicEList<Performer>());
	
	/** The active project. */
	private Project activeProject = MovieUtil.getActiveProject();
	
	/** The new movie. */
	private Movie newMovie;
	
	/** The local performer. */
	private Performer localPerformer;
	
	/** The new performers. */
	private EList<Performer> newPerformers = new BasicEList<Performer>(); 
		
	/** The query service. */
	private MovieQueryService queryService = new MovieQueryService(input);
	

	/**
	 * Instantiates a new adds the movies local.
	 *
	 * @param pInput the input
	 */
	public AddMoviesLocal(InputValues pInput){
		this.input = pInput;
	}
	
	/**
	 * Adds the movie simple.
	 *
	 * @param pNewMovie the new movie
	 */
	public void addMovieSimple(final Movie pNewMovie) {
		
	
		new EMFStoreCommand() {
			protected void doRun() {
		
				newMovie = queryService.completeMovieInformation(pNewMovie);
				//Performer Selection auf erster Wizard Page
				if(!QueryServiceProperties.CHECK_PDERFORMER){
					newMovie.getPerformers().removeAll(newMovie.getPerformers());
				}
				//Informationen �ber weitere Performer abfragen
				for(Performer nPerformer: newMovie.getPerformers()){
					nPerformer = queryService.completePerformerInformation(nPerformer);
				}
				
				

				for(int i = 0; i <= newMovie.getPerformers().size() - 1 ; i ++){
					Performer nPerformer = newMovie.getPerformers().get(i);
					if(performerExisting(nPerformer)){
						localPerformer = getLocalPerformerByName(nPerformer);
						localPerformer.getMovies().add(newMovie);

						newPerformers.add(localPerformer);
						
					}
					if(!performerExisting(nPerformer) && nPerformer != null){
						activeProject.addModelElement(nPerformer);
						newPerformers.add(nPerformer);
						savePerformerPreferences(nPerformer);
					}
				}
				newMovie.getPerformers().clear();
				newMovie.getPerformers().addAll(newPerformers);
				if(!movieExisting(newMovie)){
					activeProject.addModelElement(newMovie);
				}
			}
		}.doRun();
		saveMoviePreferences(newMovie);
	}
	
	/**
	 * Adds the movie second time.
	 * Wir wissen das ein lokaler Movie den selben Titel besitzt
	 *
	 * @param newMovie the new movie
	 */

	public void addMovieSecondTime(Movie newMovie){
		

		if(movieExisting(newMovie)){
			newMovie = queryService.completeMovieInformation(newMovie);
			//Performer Selection auf erster Wizard Page
			if(!QueryServiceProperties.CHECK_PDERFORMER){
				newMovie.getPerformers().removeAll(newMovie.getPerformers());
			}
			//Informationen �ber weitere Performer abfragen
			for(Performer nPerformer: newMovie.getPerformers()){
				nPerformer = queryService.completePerformerInformation(nPerformer);
			}
			newPerformers = newMovie.getPerformers();
			Performer nPerformer;
			Performer ePerformer;
			for(int i = 0; i <= newPerformers.size() - 1; i++){
				nPerformer = newPerformers.get(i);
				
				if(performerExisting(nPerformer)){
					ePerformer = getLocalPerformerByName(nPerformer);
					newMovie.getPerformers().remove(i);
					newMovie.getPerformers().add(ePerformer);
					ePerformer.getMovies().add(newMovie);
				}
				if(!performerExisting(nPerformer)){
					activeProject.addModelElement(nPerformer);
					newMovie.getPerformers().add(nPerformer);
					getLocalMovieByName(newMovie).getPerformers().add(nPerformer);
					savePerformerPreferences(nPerformer);
				}
			}
			activeProject.addModelElement(newMovie);
		}
	}
	

	/**
	 * Adds the merged movie.
	 * removes existing Movie from database
	 * sets newMovie in Inputvalues = null
	 * 
	 */
	public void addMergedMovie() {
	
		Movie existingMovie = input.getExisitingMovie();
		Movie importedMovie = input.getMergedMovie();
		
		
		
		existingMovie.setCategory(importedMovie.getCategory());
		existingMovie.setRating(importedMovie.getRating());
		existingMovie.setTime(importedMovie.getTime());
		existingMovie.setTitle(importedMovie.getTitle());
		existingMovie.setTitle_orig(importedMovie.getTitle_orig());

		
	
	}

	/**
	 * Compare performers.
	 *
	 * @param p1 the p1
	 * @param p2 the p2
	 * @return true, if successful
	 */
	@SuppressWarnings("unused")
	private boolean comparePerformers(Performer p1, Performer p2){
		if((p1.getName().toLowerCase().trim()).equals(p2.getName().toLowerCase().trim())){
			return true;
		}else{
			return false;
		}
	}
	
	
	
	/**
	 * Movie existing.
	 *
	 * @param newMovie the new movie
	 * @return true, if successful
	 */
	private boolean movieExisting(Movie newMovie){
		for(Movie exMovie: existingMovies){
			if(exMovie.getTitle().equals(newMovie.getTitle()) || exMovie.getTitle_orig().equals(newMovie.getTitle_orig())){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Performer existing.
	 *
	 * @param newPerformer the new performer
	 * @return true, if successful
	 */
	private boolean performerExisting(Performer newPerformer){
		for(Performer exPerformer: existingPerformers){
			if(exPerformer.getName().equals(newPerformer.getName())){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Gets the performer by name.
	 * Returnwert muss ungleich null sein, da im Aufruf vorher gecheckd wurde ob der Performer existiert!
	 *
	 * @param pPerformer the performer
	 * @return the performer by name
	 */
	private Performer getLocalPerformerByName(Performer pPerformer){
		for(Performer performer: existingPerformers){
			if(performer.getName().equals(pPerformer.getName())){
				return performer;
			}
		}
		return null;
	}
	
	/**
	 * Gets the local movie by name.
	 * Returnwert ebenfalls ungleich null, da im Aufruf der funktion bereits gecheckt wurde ob der Movie Existiert
	 * @param pMovie the movie
	 * @return the local movie by name
	 */
	private Movie getLocalMovieByName(Movie pMovie){
		for(Movie movie: existingMovies){
			if(movie.getTitle().equals(pMovie.getTitle())){
				return movie;
			}
			if(movie.getTitle_orig().equals(pMovie.getTitle_orig())){
				return movie;
			}
		}
		return null;
	}
	
	/**
	 * Movie contains performer by name.
	 *
	 * @param pMovie the movie
	 * @param pPerformer the performer
	 * @return true, if successful
	 */
	@SuppressWarnings("unused")
	private boolean movieContainsPerformerByName(Movie pMovie, Performer pPerformer){
		for(Performer performer: pMovie.getPerformers()){
			if(performer.getName().equals(pPerformer.getName())){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Save movie preferences.
	 * Prefs saved at <Workspacedirektory>\.metadata\.plugins\org.eclipse.pde.core\EMFStore Client\.settings
	 * @param movie the movie
	 */
	private void saveMoviePreferences(Movie movie){
		
	    Preferences preferences = ConfigurationScope.INSTANCE
	            .getNode("MoviePrefs");
	    try {
	    	if(!getSavedMoviePreferences().contains(movie.getTitle())){
		        Preferences sub1 = preferences.node(movie.getTitle());
		        sub1.put("title", movie.getTitle());
		        sub1.put("title_orig", movie.getTitle_orig());
		        sub1.put("category", movie.getCategory().toString());
		        sub1.put("imdburl", movie.getImdbUrl());
		        sub1.put("ofdbid", movie.getOfdbID());
		        sub1.putInt("time", movie.getTime());
		        sub1.putInt("rating",movie.getRating().getValue());     
		        
		        for(int i = 0; i < movie.getPerformers().size();i++){
		        	sub1.put("performer"+i, movie.getPerformers().get(i).getName());
		        }
		       
	    	}
	    	
	    // forces the application to save the preferences
		preferences.flush();
		} catch (BackingStoreException e2) {
			e2.printStackTrace();
		}
	}
	public void savePerformerPreferences(Performer performer){
		Preferences preferences = ConfigurationScope.INSTANCE
	            .getNode("PerformerPrefs");
		
		try {
			if(!getSavedPerformerPreferences().contains(performer.getName())){
				Preferences sub1 = preferences.node(performer.getName());
				sub1.put("name", performer.getName());
				sub1.put("gender", performer.getGender().getLiteral());
				sub1.put("ofdbid", performer.getOfdbID());
				sub1.put("rating", performer.getRating().getLiteral());
			}
			preferences.flush();
		} catch (BackingStoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
/*		Testgenerierung von 100 Beispielperformern
		for(int i = 0; i < 100; i++){
			Preferences sub1 = preferences.node("performer" + i);
			sub1.put("name", "name"+i);
		
		}*/
	}
	
	
	
	private ArrayList<String> getSavedMoviePreferences() throws BackingStoreException{
		ArrayList<String> movies = new ArrayList<String>();
		
		Preferences preferences = ConfigurationScope.INSTANCE
	            .getNode("MoviePrefs");
		

		for(int i = 0; i < preferences.childrenNames().length; i++){
			movies.add(preferences.childrenNames()[i]);
		}

		return movies;
	}
	
	private ArrayList<String> getSavedPerformerPreferences() throws BackingStoreException{
		ArrayList<String> performers = new ArrayList<String>();
		
		Preferences preferences = ConfigurationScope.INSTANCE
	            .getNode("PerformerPrefs");
		

		for(int i = 0; i < preferences.childrenNames().length; i++){
			performers.add(preferences.childrenNames()[i]);
		}

		return performers;
	}
	
	public EList<Movie> searchSavedPreferences(String key) throws BackingStoreException{

	    Preferences preferences = ConfigurationScope.INSTANCE
	            .getNode("MoviePrefs");
	    Preferences performerPreferences = ConfigurationScope.INSTANCE
	            .getNode("PerformerPrefs");
	    
	    ArrayList<String> movieNames = getSavedMoviePreferences();
	    EList<Movie> movies = new BasicEList<Movie>();	
	    
	    for (int i = 0; i < movieNames.size(); i++){
	    	if(movieNames.get(i).contains(key)) {
	    		Movie movie = MoviesFactory.eINSTANCE.createMovie();
				Preferences sub1 = preferences.node(key);
				Performer performer;
				movie.setTitle(sub1.get("title", "default"));
				movie.setTitle_orig(sub1.get("title_orig", "default"));
				movie.setCategory(MovieCategory.getByName((sub1.get("category", "default"))));
				movie.setImdbUrl(sub1.get("imdburl", "default"));
				movie.setTime(Integer.parseInt(sub1.get("time", "default")));
	//			movie.setRating(Rating.valueOf(sub1.get("rating", "default")));
				for(int a = 0; a < QueryServiceProperties.MAX_PERFORMER_TO_PREFERENCES; a++){
					String sub = sub1.get("performer" + a, "default");
					performer = MoviesFactory.eINSTANCE.createPerformer();
					Preferences sub2 = performerPreferences.node(sub);
					performer.setName(sub2.get("name", "default"));
					performer.setOfdbID(sub2.get("ofdbid", "default"));
					if(performer != null){
						movie.getPerformers().add(performer);
					}
				}
				movies.add(movie);
			
	    	}
	    }
	    
	    if(movies.size() > 0){
	    	return movies;
	    }
	    if(movies.size()==0){
	    	return null;
	    }
		

		return null;
	}
}
