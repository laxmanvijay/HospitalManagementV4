package global.coda.hospitalmanagement.models;

/**
 *
 * @author Vijay
 *
 * @param <T> represents either User,Patient or Doctor
 */
public class CustomResponse<T> {

	private int statusCode;

	private T data;

	/**
	 *
	 * @return int
	 */
	public int getStatusCode() {
		return statusCode;
	}

	/**
	 *
	 * @param statusCode code that represents the current state of the response - either a success or failure
	 */
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	/**
	 *
	 * @return T
	 */
	public T getData() {
		return data;
	}

	/**
	 *
	 * @param data data may be patient or doctor or user
	 */
	public void setData(T data) {
		this.data = data;
	}

	/**
	 *
	 */
	@Override
	public String toString() {
		return "CustomResponse [statusCode=" + statusCode + ", data=" + data + "]";
	}
}
