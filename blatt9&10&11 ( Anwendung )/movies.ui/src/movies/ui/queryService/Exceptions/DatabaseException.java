package movies.ui.queryService.Exceptions;

import java.util.HashMap;
import java.util.Map;

// TODO: Auto-generated Javadoc
/**
 * The Class DatabaseException.
 */
public class DatabaseException extends Exception{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The error codes. */
	private static Map<Integer,String> errorCodes = new HashMap<Integer, String>();
	
	
	/**
	 * Instantiates a new database exception.
	 *
	 * @param code the code
	 */
	public DatabaseException(int code){
		super(errorCodes.get(code));
		
		
		errorCodes.put(0,"Keine Fehler");
		errorCodes.put(1,"");
		errorCodes.put(2,"Fehler oder Timeout bei Anfrage an IMDB bzw. OFDB");
		errorCodes.put(3,"Keine oder falsche ID angeben");
		errorCodes.put(4,"Keine Daten zu angegebener ID oder Query gefunden");
		errorCodes.put(5,"Fehler bei der Datenverarbeitung");
		errorCodes.put(9,"Wartungsmodus, OFDBGW derzeit nicht verfügbar.");

	}

}
