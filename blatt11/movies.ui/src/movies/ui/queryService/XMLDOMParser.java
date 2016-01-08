package movies.ui.queryService;



import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import movies.Gender;
import movies.Movie;
import movies.MovieCategory;
import movies.MoviesFactory;
import movies.Performer;
import movies.ui.queryService.Exceptions.DatabaseException;
import movies.ui.queryService.Exceptions.MovieNotFoundException;
import movies.ui.queryService.Exceptions.ParserException;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;



// TODO: Auto-generated Javadoc
/**
 * The Class XMLDOMParser.
 */
public class XMLDOMParser {
	
	/** The movies. 
	 * Behinhaltet die Filme die im ersten schritt des Parsings erstellt werden*/
	private EList<Movie> movies = new BasicEList<Movie>();	


	
	/**
	 * Parst die Antwort der Datenbank.
	 * Hier wird eine Liste erstellt mit Movies die 
	 * dem QueryString am �hnlichsten sind.
	 *  
	 * Beschreibung von NUMBER_OF_MAX_MOVIES beachten
	 *
	 * @param is the InputStream
	 * @return the EList mit Movies
	 * @throws MovieNotFoundException e
	 * @throws DatabaseException 
	 */


	public EList<Movie> parseNearMovies(InputStream is,String suchstring) throws MovieNotFoundException, ParserException, DatabaseException{
		try{
			Movie movie;
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(is);
			
			doc.getDocumentElement().normalize();
			if(doc.getElementsByTagName("rcode").item(0).getTextContent().equals("4")){
				//Fehlercode 4 steht f�r: ung�ltiger suchstring
				is.close();
				throw new MovieNotFoundException(suchstring);
			}
			if(doc.getElementsByTagName("rcode").item(0).getTextContent().equals("2")){
				//Fehlercode 4 steht f�r: ung�ltiger suchstring
				is.close();
				return null;
			}
			if(!doc.getElementsByTagName("rcode").item(0).getTextContent().equals("0")){
				//Anderer Datenbank Error
				is.close();
				//System.out.println(doc.getElementsByTagName("rcode").item(0).getTextContent());
				throw new DatabaseException(Integer.parseInt(doc.getElementsByTagName("rcode").item(0).getTextContent()));
			}
				
			NodeList nList = doc.getElementsByTagName("eintrag");
			for (int i = 0; i < nList.getLength() && i  < 	QueryServiceProperties.NUMBER_OF_MAX_MOVIES; i++) {
			
				Node nNode = nList.item(i);

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					movie = MoviesFactory.eINSTANCE.createMovie();
					Element eElement = (Element) nNode;
					
					movie.setOfdbID(eElement.getElementsByTagName("id").item(0).getTextContent());
					movie.setTitle(eElement.getElementsByTagName("titel").item(0).getTextContent());
					movie.setTitle_orig(eElement.getElementsByTagName("titel_orig").item(0).getTextContent());
					movies.add(movie);
				}
			}
				
		}catch (IOException e) {
			throw new ParserException(e.getMessage(),e);
		}catch (NullPointerException e) {
			throw new ParserException(e.getMessage(),e);
		} catch (ParserConfigurationException e) {
			throw new ParserException(e.getMessage(),e);
		} catch (SAXException e) {
			throw new ParserException(e.getMessage(),e);
		} catch (NumberFormatException e){
			throw new ParserException(e.getMessage(),e);
		}

		return movies;
			
	}
	
	/**
	 * Parses the extendet movie information.
	 *
	 * @param movie the movie
	 * @param is the InputStream
	 * @return the movie with extendet Information
	 * @throws ParserException e
	 */
	public Movie parseExtendetMovieInformation(Movie movie,InputStream is) throws ParserException{
		try{
			boolean performerExisting = false;
			
		
			String imdb="";
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(is);
			 
			doc.getDocumentElement().normalize();
			if(doc.getElementsByTagName("rcode").item(0).getTextContent().equals("4")){
				//Fehlercode 4 steht f�r: Falscher suchstring
				is.close();
				return movie;
			}
			if (!doc.getElementsByTagName("rcode").item(0).getTextContent().equals("0")){
				is.close();
				return null;
			}
			
			//Setzte IMDB - Attribut
			NodeList nList = doc.getElementsByTagName("resultat");
			for (int i = 0; i < nList.getLength(); i++) {
				Node nNode = nList.item(i);
					if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					
					Element eElement = (Element) nNode;
					
					imdb = eElement.getElementsByTagName("imdbid").item(0).getTextContent();
					if(imdb.startsWith("tt")){
						movie.setImdbUrl("http://www.imdb.com/title/" + imdb);
					}else{
						movie.setImdbUrl("http://www.imdb.com/title/tt" + imdb);
					}
				}
			}
			
			//Sammle Genres
			ArrayList<String> genre = new ArrayList<String>();
			NodeList genreList = doc.getElementsByTagName("genre");
			for (int i = 0; i < genreList.getLength(); i++) {
				Node genreNode = genreList.item(i);
					if (genreNode.getNodeType() == Node.ELEMENT_NODE) {
					
					Element eElement = (Element) genreNode;
					
					genre.add(eElement.getElementsByTagName("titel").item(0).getTextContent());
				}
			}
			//F�ger Performer hinzu
			if (QueryServiceProperties.CHECK_PDERFORMER){
				Performer performer;
				NodeList besetzungList = doc.getElementsByTagName("person");
				
				for (int i = 0; i < besetzungList.getLength() && movie.getPerformers().size() < QueryServiceProperties.NUMBER_OF_MAX_PERFORMER ; i++){
					performerExisting = false;
					performer = MoviesFactory.eINSTANCE.createPerformer();
					Node nNode = besetzungList.item(i);
					
					if (nNode.getNodeType() == Node.ELEMENT_NODE){
						Element eElement = (Element) nNode;
						
						performer.setName(eElement.getElementsByTagName("name").item(0).getTextContent());
//						System.out.println(eElement.getElementsByTagName("id").item(0).getTextContent());
							performer.setOfdbID(eElement.getElementsByTagName("id").item(0).getTextContent());
							//Checkt ob ein Performer zwei mal in DIESEM Movie vorhanden ist
							for(int a = 0; a < movie.getPerformers().size(); a++){
								if(movie.getPerformers().get(a).getName().equals(performer.getName())){
									performerExisting = true;
								}
							}
							if(!performerExisting){
								movie.getPerformers().add(performer);
							}
						}
					}	
				}
			for (int i=0; i < genre.size();i++){
				if(genre.get(i).contains("Action") || genre.get(i).contains("Aktion")){
					movie.setCategory(MovieCategory.ACTION);
				}
				if(genre.get(i).contains("Science Fiction") || genre.get(i).contains("Science-Fiction")){
					movie.setCategory(MovieCategory.SCIENCE_FICTION);
				}
				if(genre.get(i).contains("Kom�die") || genre.get(i).contains("Comedy") || genre.get(i).contains("Kinder")){
					movie.setCategory(MovieCategory.COMEDY);
				}	
				if(genre.get(i).contains("Music") || genre.get(i).contains("Musik")){
					movie.setCategory(MovieCategory.MUSIC);
				}
				if(genre.get(i).contains("Drama")){
					movie.setCategory(MovieCategory.DRAMA);
				}
				if(genre.get(i).contains("Thriller")){
					movie.setCategory(MovieCategory.THRILLER);
				}
				if(genre.get(i).contains("Horror")){
					movie.setCategory(MovieCategory.HORROR);
				}
				if(genre.get(i).contains("Fantasy") || genre.get(i).contains("Fantasie")){
					movie.setCategory(MovieCategory.FANTASY);
				}
				if(genre.get(i).contains("Adventure") || genre.get(i).contains("Abenteuer")){
					movie.setCategory(MovieCategory.ADVENTURE);
				}
				if(genre.get(i).contains("Romance") || genre.get(i).contains("Romantik") || genre.get(i).contains("Romanze")){
					movie.setCategory(MovieCategory.ROMANCE);
				}
				if(genre.get(i).contains("Documentation") || genre.get(i).contains("Doku")){
					movie.setCategory(MovieCategory.DOCUMENTATION);
				}
			}
		
		} catch (ParserConfigurationException e) {
			throw new ParserException(e.getMessage(),e);
		} catch (SAXException e) {
			throw new ParserException(e.getMessage(),e);
		} catch (IOException e) {
			throw new ParserException(e.getMessage(),e);
		}catch(NullPointerException e) {
			throw new ParserException(e.getMessage(),e);
		}
//		throw new ParserException("blorb",null);
		return movie;
	}
	
	/**
	 * Parses the performer information.
	 *
	 * @param performer the performer
	 * @param is the is
	 * @return the performer
	 * @throws ParserErrorException 
	 */
	public Performer parsePerformerInformation(Performer performer, InputStream is) throws ParserException{
		try{
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(is);
			 
			doc.getDocumentElement().normalize();
			if(doc.getElementsByTagName("rcode").item(0).getTextContent().equals("4")){
				//Fehlercode 4 steht f�r: Falscher suchstring
				is.close();
				return performer;
			}
			if(!doc.getElementsByTagName("rcode").item(0).getTextContent().equals("0")){
				is.close();
				return null;
			}
				
			NodeList nList = doc.getElementsByTagName("resultat");
			for (int i = 0; i < nList.getLength(); i++) {
				Node nNode = nList.item(i);
	
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
						
					Element eElement = (Element) nNode;
						
					if(eElement.getElementsByTagName("geschlecht").item(0).getTextContent().equals("m")){
						performer.setGender(Gender.MALE);
					}
					if(eElement.getElementsByTagName("geschlecht").item(0).getTextContent().equals("w")){
						performer.setGender(Gender.FEMALE);
					}	
				}
			}
			
			is.close();
		} catch (ParserConfigurationException e) {
			throw new ParserException(e.getMessage(),e);
		} catch (SAXException e) {
			throw new ParserException(e.getMessage(),e);
		} catch (IOException e) {
			throw new ParserException(e.getMessage(),e);
		}catch(NullPointerException e) {
			throw new ParserException(e.getMessage(),e);
		}
		return performer;
	}
	
}
