package prixma.opc.services;

public class ServiceException extends RuntimeException {

	private static final long serialVersionUID = -1364445260276945001L;

	public ServiceException(String message) {
		super(message);
	}

	public ServiceException(Throwable cause) {
		super(cause);
	}

	public ServiceException(String message, Throwable cause) {
		super(message, cause);
	}

}
