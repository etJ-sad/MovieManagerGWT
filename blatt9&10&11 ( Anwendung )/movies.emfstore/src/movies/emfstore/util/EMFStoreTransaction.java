package movies.emfstore.util;

import java.io.Serializable;

public class EMFStoreTransaction implements Serializable {

	private static final long serialVersionUID = 4842504775069599366L;

	private Object objectToSend;

	private EMFStoreRequest requestToPerform;

	public Object getObjectToSend() {
		return objectToSend;
	}

	public void setObjectToSend(Object objectToSend) {
		this.objectToSend = objectToSend;
	}

	public EMFStoreRequest getRequestToPerform() {
		return requestToPerform;
	}

	public void setRequestToPerform(EMFStoreRequest function) {
		this.requestToPerform = function;
	}

}
