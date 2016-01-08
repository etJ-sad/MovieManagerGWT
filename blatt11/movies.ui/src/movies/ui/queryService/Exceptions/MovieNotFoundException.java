package movies.ui.queryService.Exceptions;

// TODO: Auto-generated Javadoc
/**
 * The Class MovieNotFoundException.
 */
public class MovieNotFoundException extends Exception{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The suchstring. */
	@SuppressWarnings("unused")
	private String suchstring;
	
	/**
	 * Instantiates a new movie not found exception.
	 *
	 * @param suchstring the suchstring
	 */
	public MovieNotFoundException(String suchstring){
		super("Movie: " + suchstring+ " konnte in der Datenbank nicht gefunden werden");
		this.suchstring = suchstring;
		
	}
	
	

}
