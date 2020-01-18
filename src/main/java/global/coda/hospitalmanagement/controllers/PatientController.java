package global.coda.hospitalmanagement.controllers;

import java.util.ResourceBundle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import global.coda.hospitalmanagement.constants.ApiConstants;
import global.coda.hospitalmanagement.delegates.PatientDelegate;
import global.coda.hospitalmanagement.exceptions.BusinessException;
import global.coda.hospitalmanagement.exceptions.SystemException;
import global.coda.hospitalmanagement.models.CustomResponse;
import global.coda.hospitalmanagement.models.Patient;

/**
 *
 * @author Vijay
 * Api provider for patient operations
 *
 */
@RestController
@RequestMapping("/patient")
public class PatientController {
	private static final Logger LOGGER = LoggerFactory
			.getLogger(PatientController.class);
	private Gson gson = new Gson();
	private static final ResourceBundle LOG_RESOURCE_BUNDLE = ResourceBundle
			.getBundle(ApiConstants.API_LOG_MESSAGE_BUNDLE_NAME);

	@Autowired
	private PatientDelegate patientDelegate;

	/**
	 *
	 * @param patient the patient's model
	 * @return String json response is returned as string processed by gson
	 * @throws SystemException custom exception
	 * @throws BusinessException client side exceptions
	 */
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public final String createPatient(@RequestBody Patient patient) throws SystemException, BusinessException {
		LOGGER.trace(LOG_RESOURCE_BUNDLE.getString(ApiConstants.HMAPIC3000T), patient.toString());
		patientDelegate.createPatient(patient);
		CustomResponse<Patient> customResponse = new CustomResponse<>();
		LOGGER.debug("patient created using create method of PatientWebServiceApi");
		customResponse.setStatusCode(200);
		customResponse.setData(patient);
		LOGGER.trace(LOG_RESOURCE_BUNDLE.getString(ApiConstants.HMAPIC3001T), customResponse);
		return gson.toJson(customResponse);
	}

	/**
	 *
	 * @param id id of the patient
	 * @return String json response is returned as string processed by gson
	 * @throws SystemException custom exception
	 * @throws BusinessException client side exceptions
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public final String readPatientById(@PathVariable("id") int id) throws SystemException, BusinessException {
		LOGGER.trace(LOG_RESOURCE_BUNDLE.getString(ApiConstants.HMAPIC3002T), id);
		Patient patient = patientDelegate.readPatient(id);
		CustomResponse<Patient> customResponse = new CustomResponse<>();
		LOGGER.debug("patient read using read method of PatientWebServiceApi");
		customResponse.setStatusCode(200);
		customResponse.setData(patient);
		LOGGER.trace(LOG_RESOURCE_BUNDLE.getString(ApiConstants.HMAPIC3003T), customResponse);
		return gson.toJson(customResponse);
	}

	/**
	 *
	 * @param patient the patient model
	 * @return String json response is returned as string processed by gson
	 * @throws SystemException custom exception
	 * @throws BusinessException client side exceptions
	 */
	@RequestMapping(value = "/", method = RequestMethod.PUT)
	public final String updatePatient(@RequestBody Patient patient) throws SystemException, BusinessException {
		LOGGER.trace(LOG_RESOURCE_BUNDLE.getString(ApiConstants.HMAPIC3004T), patient.toString());
		patientDelegate.updatePatient(patient);
		CustomResponse<String> customResponse = new CustomResponse<>();
		LOGGER.debug("patient updated using read method of PatientWebServiceApi");
		customResponse.setStatusCode(200);
		customResponse.setData("Patient Updated");
		LOGGER.trace(LOG_RESOURCE_BUNDLE.getString(ApiConstants.HMAPIC3005T), customResponse);
		return gson.toJson(customResponse);
	}

	/**
	 *
	 * @param id id of the patient
	 * @return String json response is returned as string processed by gson
	 * @throws SystemException custom exception
	 * @throws BusinessException custom client exception
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public final String deletePatient(@PathVariable("id") int id) throws SystemException, BusinessException {
		LOGGER.trace(LOG_RESOURCE_BUNDLE.getString(ApiConstants.HMAPIC3006T), id);
		patientDelegate.deletePatient(id);
		CustomResponse<String> customResponse = new CustomResponse<>();
		LOGGER.debug("patient deleted using delete method of PatientWebServiceApi");
		customResponse.setStatusCode(200);
		customResponse.setData("Patient deleted");
		LOGGER.trace(LOG_RESOURCE_BUNDLE.getString(ApiConstants.HMAPIC3007T), customResponse);
		return gson.toJson(customResponse);
	}
}
