package global.coda.hospitalmanagement.exceptions;

/**
 *
 * Client side exceptions are thrown here.
 *
 * @author Vijay
 *
 */
public class BusinessException extends Exception {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 *
	 * @param message message to be shown
	 */
	public BusinessException(String message) {
		super(message);
	}
}
