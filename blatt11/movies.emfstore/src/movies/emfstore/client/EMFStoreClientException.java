package movies.emfstore.client;

/**
 * Class that serves as a container for exceptions that are thrown by the
 * operations within the {@link EMFStoreClient}.
 * 
 * @author Marcus Seiler
 * */
public class EMFStoreClientException extends Exception {

	private static final long serialVersionUID = -3294403477470952394L;

	public EMFStoreClientException(String message) {
		super(message);
	}
}