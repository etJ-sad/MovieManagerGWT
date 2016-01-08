package movies.ui.queryService.Exceptions;

// TODO: Auto-generated Javadoc
/**
 * The Class ParserErrorException.
 */
public class ParserException extends Exception{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Instantiates a new parser error exception.
	 *
	 * @param msg the msg
	 * @param e the e
	 */
	public ParserException(String msg, Throwable e){
		super("Parser Error: " + msg,e);
	}

}
