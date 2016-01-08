package movies.ui.queryService;

/**
 * The Class QueryServiceProperties.
 */
public class QueryServiceProperties {
	
	/** The Constant SEARCH_URL. */
	public static final String SEARCH_URL = "http://ofdbgw.org/search/"; //nimmt String
	
	/** The Constant MOVIE_URL. */
	public static final String MOVIE_URL = "http://ofdbgw.org/movie/"; //Nimmt movie id
	
	/** The Constant imdb2ofdb. */
	public static final String IMDB2OFDB = "http://ofdbgw.org/imdb2ofdb/"; //nimmt Imdb ID
			
	/** The Constant personURL. */
	public static final String PERSON_URL = "http://ofdbgw.org/searchperson/"; //Nimmt string
	
	/** The Constant singlepersonURL. */
	public static final String SINGLEPERSON_URL = "http://ofdbgw.org/person/"; //Nimmt Personen ID
	
	/** The Constant checkPerformers. 
	 * Gibt an ob Performer standardm��ig abgefragt werden sollen oder nicht.
	 * Used in EnterMovieNamePage.java & XMLDOMParser
	 * */
	public static final boolean CHECK_PDERFORMER = true;
	
	/** The Constant NUMBER_OF_MAX_PERFORMER. 
	 * Gibt an wie viele Performer von einem Film zus�tzlich hinzugef�gt werden
	 * 
	 * ACHTUNG: Ein Wert > 10 kann die Wartezeit deutlich erh�hen!!*/
	public static final int NUMBER_OF_MAX_PERFORMER = 5;
	
	/** The Constant NUMBER_OF_MAX_MOVIES. 
	 * Gibt an wie viele Movies der auswahlliste hinzugef�gt werden sollen*/
	public static final int NUMBER_OF_MAX_MOVIES = 10;
	
	public static final int MAX_PERFORMER_TO_PREFERENCES = 5;
	

}
