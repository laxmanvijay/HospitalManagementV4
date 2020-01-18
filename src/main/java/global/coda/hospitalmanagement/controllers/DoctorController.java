package global.coda.hospitalmanagement.controllers;

import java.util.List;
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
import global.coda.hospitalmanagement.delegates.DoctorDelegate;
import global.coda.hospitalmanagement.exceptions.BusinessException;
import global.coda.hospitalmanagement.exceptions.SystemException;
import global.coda.hospitalmanagement.models.CustomResponse;
import global.coda.hospitalmanagement.models.Doctor;
import global.coda.hospitalmanagement.models.Patient;
import global.coda.hospitalmanagement.models.PatientWithDoctor;

/**
 *
 * @author Vijay
 *
 * Api provider for doctor operations
 *
 */
@RestController
@RequestMapping("/doctor")
public class DoctorController {
	private static final Logger LOGGER = LoggerFactory.getLogger(DoctorController.class);
	private Gson gson = new Gson();
	private static final ResourceBundle LOG_RESOURCE_BUNDLE = ResourceBundle
			.getBundle(ApiConstants.API_LOG_MESSAGE_BUNDLE_NAME);

	@Autowired
	private DoctorDelegate doctorDelegate;

	/**
	 *
	 * @param doctor the doctor's entity/model
	 * @return String json response is returned as a string processed by gson
	 * @throws SystemException custom exception
	 * @throws BusinessException client side exceptions
	 */
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public final String createDoctor(@RequestBody Doctor doctor) throws SystemException, BusinessException {
		LOGGER.trace(LOG_RESOURCE_BUNDLE.getString(ApiConstants.HMAPIC2000T), doctor.toString());
		int doctorId = doctorDelegate.createDoctor(doctor);
		CustomResponse<Doctor> customResponse = new CustomResponse<>();
		Doctor doctorAfterCreation = doctorDelegate.readDoctor(doctorId);
		customResponse.setStatusCode(200);
		customResponse.setData(doctorAfterCreation);
		LOGGER.trace(LOG_RESOURCE_BUNDLE.getString(ApiConstants.HMAPIC2001T), customResponse);
		return gson.toJson(customResponse);
	}

	/**
	 *
	 * @param id id of the doctor(user)
	 * @return String json response is returned as a string processed by gson
	 * @throws SystemException custom exception
	 * @throws BusinessException client side exceptions
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public final String readDoctorById(@PathVariable("id") int id) throws SystemException, BusinessException {
		LOGGER.trace(LOG_RESOURCE_BUNDLE.getString(ApiConstants.HMAPIC2002T), id);
		Doctor doctor = doctorDelegate.readDoctor(id);
		CustomResponse<Doctor> customResponse = new CustomResponse<>();
		customResponse.setStatusCode(200);
		customResponse.setData(doctor);
		LOGGER.trace(LOG_RESOURCE_BUNDLE.getString(ApiConstants.HMAPIC2003T), customResponse);
		return gson.toJson(customResponse);
	}

	/**
	 *
	 * @param doctor id of the doctor(user)
	 * @return String json response is returned as a string processed by gson
	 * @throws SystemException custom exception
	 * @throws BusinessException custom exception
	 */
	@RequestMapping(value = "/", method = RequestMethod.PUT)
	public final String updateDoctor(@RequestBody Doctor doctor) throws SystemException, BusinessException {
		LOGGER.trace(LOG_RESOURCE_BUNDLE.getString(ApiConstants.HMAPIC2004T), doctor.toString());
		boolean result = doctorDelegate.updateDoctor(doctor);
		CustomResponse<Boolean> customResponse = new CustomResponse<>();
		customResponse.setStatusCode(200);
		customResponse.setData(result);
		LOGGER.trace(LOG_RESOURCE_BUNDLE.getString(ApiConstants.HMAPIC2005T), customResponse);
		return gson.toJson(customResponse);

	}

	/**
	 *
	 * @param id id of the doctor
	 * @return String json response is returned as a string processed by gson
	 * @throws SystemException custom exception
	 * @throws BusinessException client side exceptions
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public final String deleteDoctor(@PathVariable("id") int id) throws SystemException, BusinessException {
		LOGGER.trace(LOG_RESOURCE_BUNDLE.getString(ApiConstants.HMAPIC2006T), id);
		doctorDelegate.deleteDoctor(id);
		CustomResponse<String> customResponse = new CustomResponse<>();
		customResponse.setStatusCode(204);
		customResponse.setData("Delete Success");
		LOGGER.trace(LOG_RESOURCE_BUNDLE.getString(ApiConstants.HMAPIC2007T), customResponse);
		return gson.toJson(customResponse);

	}

	/**
	 *
	 * @param id id of the doctor
	 * @return String json response is returned as a string processed by gson
	 * @throws SystemException server side errors
	 * @throws BusinessException client side errors
	 */
	@RequestMapping(value = "{id}/patients", method = RequestMethod.GET)
	public final String readAllPatientsOfDoctor(@PathVariable("id") int id) throws SystemException, BusinessException {
		LOGGER.info(LOG_RESOURCE_BUNDLE.getString(ApiConstants.HMAPIC2008T), id);
		System.out.println(id);
		List<Patient> listOfPatients = doctorDelegate.getAllPatientsOfADoctor(id);
		CustomResponse<List<Patient>> customResponse = new CustomResponse<>();
		customResponse.setStatusCode(200);
		customResponse.setData(listOfPatients);
		LOGGER.trace(LOG_RESOURCE_BUNDLE.getString(ApiConstants.HMAPIC2009T), customResponse);
		return gson.toJson(customResponse);
	}

	/**
	 *
	 * @return String
	 * @throws SystemException system side exception
	 * @throws BusinessException client side exception
	 */
	@RequestMapping(value = "getallpatients")
	public final String readAllPatientsOfAllDoctors() throws SystemException, BusinessException {
		LOGGER.info(LOG_RESOURCE_BUNDLE.getString(ApiConstants.HMAPIC2010T));
		List<PatientWithDoctor> listOfPatients = doctorDelegate.getAllPatientsOfAllDoctors();
		CustomResponse<List<PatientWithDoctor>> customResponse = new CustomResponse<>();
		customResponse.setStatusCode(200);
		customResponse.setData(listOfPatients);
		LOGGER.trace(LOG_RESOURCE_BUNDLE.getString(ApiConstants.HMAPIC2011T), customResponse);
		return gson.toJson(customResponse);
	}
}
