package global.coda.hospitalmanagement.exception.mappers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import global.coda.hospitalmanagement.exceptions.BusinessException;
import global.coda.hospitalmanagement.exceptions.SystemException;
import global.coda.hospitalmanagement.models.CustomResponse;

@ControllerAdvice
public class HospitalManagementExceptionMapper {

	private final Logger logger = LoggerFactory.getLogger(HospitalManagementExceptionMapper.class);
	/**
	 * Business exception.
	 *
	 * @param error the error
	 * @return the response entity
	 */
	@ExceptionHandler(value = BusinessException.class)
	public ResponseEntity<CustomResponse<String>> businessException(BusinessException error) {
		logger.error(error.getMessage());
		CustomResponse<String> response = new CustomResponse<String>();
		response.setStatusCode(500);
		response.setData(error.getMessage());
		return new ResponseEntity<CustomResponse<String>>(response, HttpStatus.NOT_FOUND);
	}
	/**
	 * System exception.
	 *
	 * @param error the error
	 * @return the response entity
	 */
	@ExceptionHandler(value = SystemException.class)
	public ResponseEntity<CustomResponse<String>> systemException(SystemException error) {
		logger.error(error.getMessage());
		CustomResponse<String> response = new CustomResponse<String>();
		response.setStatusCode(500);
		response.setData("error occurred");
		return new ResponseEntity<CustomResponse<String>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
