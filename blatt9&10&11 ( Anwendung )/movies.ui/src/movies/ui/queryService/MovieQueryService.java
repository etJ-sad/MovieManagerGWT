package movies.ui.queryService;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;
import java.util.ArrayList;

import movies.Movie;
import movies.Performer;
import movies.ui.dialogs.MovieExceptionDialog;
import movies.ui.queryService.Exceptions.ConnectionException;
import movies.ui.queryService.Exceptions.DatabaseException;
import movies.ui.queryService.Exceptions.MovieNotFoundException;
import movies.ui.queryService.Exceptions.ParserException;
import movies.ui.wizards.queryWizard.InputValues;

import org.eclipse.emf.common.util.EList;
import org.eclipse.ui.PlatformUI;
import org.osgi.service.prefs.BackingStoreException;



// TODO: Auto-generated Javadoc
/**
 * The Class MovieQueryServiceImpl.
 */
public class MovieQueryService {

	/** The dom parser. */
	private XMLDOMParser domParser = new XMLDOMParser();
	
	private InputValues input;
		
	/** The exception dialog. */
	private MovieExceptionDialog exceptionDialog = new MovieExceptionDialog(PlatformUI.getWorkbench()
			.getActiveWorkbenchWindow().getShell());
	

	public MovieQueryService(InputValues input) {
		this.input = input;
	}


	/**
	 * Complete url.
	 * F�ge Subdomains ein.
	 * 2 URLs auskommentiert da keine Konstistenen Ergebnisse
	 *
	 * @param sURL the s url
	 * @param key the key
	 * @return the string
	 */
	private String completeURL(String sURL, String key){
		ArrayList<String> subDomains = new ArrayList<String>();
		
		
		subDomains.add("http://mirror1.ofdbgw.org/");
		subDomains.add("http://ofdbgw.home-of-root.de/");
//		subDomains.add("http://ofdbgw.metawave.ch/");
//		subDomains.add("http://ofdbgw.h1915283.stratoserver.net/"); 
//		subDomains.add("http://ofdbgw.johann-scharl.de/");
		subDomains.add("http://ofdbgw.geeksphere.de/");	
		
		int random = (int)( Math.random() * subDomains.size());
		
		String newURL = sURL.replaceFirst("http://ofdbgw.org/", subDomains.get(random));

		newURL = newURL + key;
		
		return newURL;
	}
	
	
	/**
	 * Connect url.
	 *
	 * @param sURL �bergebene Konstante, oben definiert, gibt an nach was gesucht wird.
	 * @param key Das Schl�sselwort nach welchem gesucht wird
	 * @return the input stream Antwort der Datenbank als input stream
	 * 
	 * Baut eine Verbindung zur ofdb Datenbank auf.
	 * @throws ConnectionException the connection exception
	 */
	private InputStream connectURL(String sURL, String key)  throws ConnectionException{
		try{
			key = key.replaceAll(" ","%20");// <- Wichtig!
			URL	url = new URL(completeURL( sURL , key));	
			
			URLConnection connected = url.openConnection();	

			connected.setConnectTimeout(5000);
				
			return connected.getInputStream();
			
		} catch(UnknownHostException e) {
			throw new ConnectionException(e.getMessage(),e);
		} catch (IOException e) {
			throw new ConnectionException(e.getMessage(),e);
		}
	}

	/**
	 * Gets the list of near movies.
	 * 
	 * 1.Stufe: Suche nach Filmen mit bestimmten Namen.
	 * Die while Schleife sorgt daf�r das im falle eines Timeouts die anfrage erneut ausgef�hrt wird
	 *
	 * @param suchstring the string to search fot in the Database
	 * @return the list of near movies

	 * 
	 */
	public EList<Movie> searchForMoviesByString(String suchstring) {
		
		EList<Movie> movies = null;
		try{
			while ((movies = domParser.parseNearMovies(
					connectURL(QueryServiceProperties.SEARCH_URL, suchstring),suchstring)) == null){}
		} catch(MovieNotFoundException e) {
			movies = searchPreferences(suchstring);
			if(movies == null){
				openDialog(e);
			}
			if(movies != null){
				return movies;
			}
		} catch (ParserException e) {
			openDialog(e);
		} catch (DatabaseException e) {
			openDialog(e);
		} catch (ConnectionException e) {
			movies = searchPreferences(suchstring);
			if(movies == null){
				openDialog(e);
			}
			if(movies != null){
				return movies;
			}
		}
     	return movies; 
	}
	
	/**
	 * Complete movie information.
	 * 
	 * Stufe 2: Ein Movie wird �bergeben, anhand seiner OfdbID werden weitere Informationen abgefragt.
	 * Die while Schleife sorgt daf�r das im falle eines Timeouts die anfrage erneut ausgef�hrt wird.
	 *
	 * @param pMmovie the mmovie
	 * @return the movie
	 */
	public Movie completeMovieInformation(Movie pMmovie)  {
		
		Movie movie = null;
			
		try {
			
			while ((movie = domParser.parseExtendetMovieInformation(
					pMmovie, connectURL(QueryServiceProperties.MOVIE_URL, pMmovie.getOfdbID()))) == null){}
			
		} catch (ParserException e) {
			openDialog(e);
		} catch (ConnectionException e) {
		/*	movie = (searchPreferences(pMmovie.getTitle())).get(0);
			if(movie == null){
				openDialog(e);
			}
			if(movie != null){
				return movie;
			}*/
			return pMmovie;
		}
			
		return movie;
	}
	
	/**
	 * Complete performer information.
	 * 
	 * Stufe 3: Die Performer eines Filmes bekommen weitere Atribute hinzugef�gt.
	 * Die while Schleife sorgt daf�r das im falle eines Timeouts die anfrage erneut ausgef�hrt wird.
	 *
	 * @param pPerformer the performer der erweitert werden soll
	 * @return the performer der erweiterte performer wird zur�ck gegeben
	 */
	
	public Performer completePerformerInformation (Performer pPerformer){
	
		Performer performer = pPerformer;
		//Manchmal sind Performer nicht als eigenes Objekt in der OFDB vorhanden
		if(!pPerformer.getOfdbID().isEmpty()){	
			try {
				while((performer = domParser.parsePerformerInformation(
						pPerformer, connectURL(QueryServiceProperties.SINGLEPERSON_URL, pPerformer.getOfdbID()))) == null){}
			} catch (ParserException e) {
				openDialog(e);
			} catch (ConnectionException e) {
//				openDialog(e);
			}
		}	
		return performer;
		
	}
	
	/**
	 * Open dialog.
	 *
	 * @param e the e
	 */
	public void openDialog(Exception e){
		exceptionDialog.setException(e);
		exceptionDialog.open();		
	}
	
	
	private EList<Movie> searchPreferences(String suchstring){
		AddMoviesLocal aml = new AddMoviesLocal(input);
		
		EList<Movie> movies = null;	
		try {
			movies = aml.searchSavedPreferences(suchstring);
		} catch (BackingStoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return movies;
	}
}
