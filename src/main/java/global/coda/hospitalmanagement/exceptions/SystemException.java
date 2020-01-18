/**
 *
 */
package global.coda.hospitalmanagement.exceptions;

/**
 *
 * Server side errors are thrown here.
 *
 * @author Vijay
 *
 */
public class SystemException extends Exception {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 *
	 * @param message message to be sent
	 */
	public SystemException(String message) {
		super(message);
	}

}
