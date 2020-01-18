package global.coda.hospitalmanagement.exceptions;

/**
 *
 * @author Vijay
 *
 * Exception to handle if the patient record is empty or patient with the given id is not found
 *
 */
public class NoPatientFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 *
	 */
	public NoPatientFoundException() {
		super("no patient records found");
	}
}


