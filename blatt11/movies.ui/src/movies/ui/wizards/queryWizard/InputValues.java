package movies.ui.wizards.queryWizard;

import movies.Movie;
import movies.ui.dialogs.QueryWizardDialog;
import movies.ui.queryService.QueryServiceProperties;

import org.eclipse.swt.widgets.Table;


// TODO: Auto-generated Javadoc
/**
 * The Class InputValues.
 */
public class InputValues {
	
	/** The movie name. */
	private String movieName = "";
	
	/** The check performers. */
	@SuppressWarnings("unused")
	private boolean checkPerformers = QueryServiceProperties.CHECK_PDERFORMER;
	
	/** The table. */
	private Table table;
	
	/** The duplicate event. */
	private String duplicateEvent = "default";
	
	/** The duplicate detected. */
	private boolean duplicateDetected;
	
	private QueryWizardDialog qwd;

	/** The exisiting movie. 
	 * which is similar to "newMovie"
	 */
	private Movie exisitingMovie;
	
	/** The new movie.
	 * which is similar to "exisitngMovie"
	 */
	private Movie newMovie;
	
	/** The merged movie. */
	private Movie mergedMovie;

	/**
	 * Gets the exisiting movie.
	 *
	 * @return the exisiting movie
	 */
	public Movie getExisitingMovie() {
		return exisitingMovie;
	}

	/**
	 * Sets the exisiting movie.
	 *
	 * @param exisitingMovie the new exisiting movie
	 */
	public void setExisitingMovie(Movie exisitingMovie) {
		this.exisitingMovie = exisitingMovie;
	}

	/**
	 * Gets the new movie.
	 *
	 * @return the new movie
	 */
	public Movie getNewMovie() {
		
		return newMovie;
	}

	/**
	 * Sets the new movie.
	 *
	 * @param newMovie the new new movie
	 */
	public void setNewMovie(Movie newMovie) {
		this.newMovie = newMovie;
	}

	/**
	 * Gets the movie name.
	 *
	 * @return the movie name
	 */
	public String getMovieName() {
		return movieName;
	}

	/**
	 * Sets the movie name.
	 *
	 * @param pMovieName the new movie name
	 */
	public void setMovieName(String pMovieName) {
		movieName = pMovieName;
	}



	/**
	 * Sets the check performers.
	 *
	 * @param checkPerformers the new check performers
	 */
	public void setCheckPerformers(boolean checkPerformers) {
		this.checkPerformers = checkPerformers;
	}




	/**
	 * Gets the table.
	 *
	 * @return the table
	 */
	public Table getTable() {
		return table;
	}

	/**
	 * Sets the table.
	 *
	 * @param table the new table
	 */
	public void setTable(Table table) {
		this.table = table;
	}

	/**
	 * Gets the duplicate event.
	 *
	 * @return the duplicate event
	 */
	public String getDuplicateEvent() {
		return duplicateEvent;
	}

	/**
	 * Sets the duplicate event.
	 *
	 * @param duplicateEvent the new duplicate event
	 */
	public void setDuplicateEvent(String duplicateEvent) {
		this.duplicateEvent = duplicateEvent;
	}


	
	/**
	 * Checks if is duplicate detected.
	 *
	 * @return true, if is duplicate detected
	 */
	public boolean isDuplicateDetected() {
		return duplicateDetected;
	}

	/**
	 * Sets the duplicate detected.
	 *
	 * @param duplicateDetected the new duplicate detected
	 */
	public void setDuplicateDetected(boolean duplicateDetected) {
		this.duplicateDetected = duplicateDetected;
	}

	/**
	 * Gets the merged movie.
	 *
	 * @return the merged movie
	 */
	public Movie getMergedMovie() {
		return mergedMovie;
	}

	/**
	 * Sets the merged movie.
	 *
	 * @param mergedMovie the new merged movie
	 */
	public void setMergedMovie(Movie mergedMovie) {
		this.mergedMovie = mergedMovie;
	}

	public QueryWizardDialog getQwd() {
		return qwd;
	}

	public void setQwd(QueryWizardDialog qwd) {
		this.qwd = qwd;
	}



}	
