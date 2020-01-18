package global.coda.hospitalmanagement.exceptions;

/**
 *
 * @author Vijay
 * Exception to handle DuplicateIds in the patient record.
 *
 */
public class DuplicateIdException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 *
	 */
	public DuplicateIdException() {
		super("id is duplicated,cannot add patient" + "error code:");
	}

}
