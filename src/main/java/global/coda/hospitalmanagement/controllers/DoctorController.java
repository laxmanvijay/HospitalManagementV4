package global.coda.hospitalmanagement.controllers;

import java.util.List;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import global.coda.hospitalmanagement.constants.ApiConstants;
import global.coda.hospitalmanagement.delegates.DoctorDelegate;
import global.coda.hospitalmanagement.exceptions.BusinessException;
import global.coda.hospitalmanagement.exceptions.SystemException;
import global.coda.hospitalmanagement.models.CustomResponse;
import global.coda.hospitalmanagement.models.Doctor;

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
	public final CustomResponse<List<Doctor>> createDoctor(@RequestBody Doctor doctor, HttpServletRequest req) throws SystemException, BusinessException {
		LOGGER.trace(LOG_RESOURCE_BUNDLE.getString(ApiConstants.HMAPIC2000T), doctor.toString());
		System.out.println(req.getAttribute("request id"));
		int doctorId = doctorDelegate.createDoctor(doctor);
		CustomResponse<List<Doctor>> customResponse = new CustomResponse<>();
		List<Doctor> doctorAfterCreation = doctorDelegate.readDoctor(doctorId, false);
		customResponse.setStatusCode(200);
		customResponse.setData(doctorAfterCreation);
		LOGGER.trace(LOG_RESOURCE_BUNDLE.getString(ApiConstants.HMAPIC2001T), customResponse);
		return customResponse;
	}

	/**
	 *by default requirePatients is false, the function fetches doctor by id without their patients
	 *if requirepatient is given as true it fetches the doctor with the specified id along with patients
	 *if id is given as 0, all the doctors are fetched
	 *
	 * @param id id of the doctor(user)
	 * @return String json response is returned as a string processed by gson
	 * @throws Exception
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public final CustomResponse<List<Doctor>> readDoctorById(HttpServletRequest req, @PathVariable("id") int id, @RequestParam(value = "requirePatients", required = false) boolean requirePatients) throws SystemException, BusinessException {
		LOGGER.trace(LOG_RESOURCE_BUNDLE.getString(ApiConstants.HMAPIC2002T), id);
		System.out.println(req.getAttribute("request id"));
		List<Doctor> doctor = doctorDelegate.readDoctor(id, requirePatients);
		CustomResponse<List<Doctor>> customResponse = new CustomResponse<>();
		customResponse.setStatusCode(200);
		customResponse.setData(doctor);
		LOGGER.trace(LOG_RESOURCE_BUNDLE.getString(ApiConstants.HMAPIC2003T), customResponse);
		return customResponse;
	}

	/**
	 *
	 * @param doctor id of the doctor(user)
	 * @return String json response is returned as a string processed by gson
	 * @throws SystemException custom exception
	 * @throws BusinessException custom exception
	 */
	@RequestMapping(value = "/", method = RequestMethod.PUT)
	public final CustomResponse<Boolean> updateDoctor(@RequestBody Doctor doctor) throws SystemException, BusinessException {
		LOGGER.trace(LOG_RESOURCE_BUNDLE.getString(ApiConstants.HMAPIC2004T), doctor.toString());
		boolean result = doctorDelegate.updateDoctor(doctor);
		CustomResponse<Boolean> customResponse = new CustomResponse<>();
		customResponse.setStatusCode(200);
		customResponse.setData(result);
		LOGGER.trace(LOG_RESOURCE_BUNDLE.getString(ApiConstants.HMAPIC2005T), customResponse);
		return customResponse;
	}

	/**
	 *
	 * @param id id of the doctor
	 * @return String json response is returned as a string processed by gson
	 * @throws SystemException custom exception
	 * @throws BusinessException client side exceptions
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public final CustomResponse<String> deleteDoctor(@PathVariable("id") int id) throws SystemException, BusinessException {
		LOGGER.trace(LOG_RESOURCE_BUNDLE.getString(ApiConstants.HMAPIC2006T), id);
		doctorDelegate.deleteDoctor(id);
		CustomResponse<String> customResponse = new CustomResponse<>();
		customResponse.setStatusCode(204);
		customResponse.setData("Delete Success");
		LOGGER.trace(LOG_RESOURCE_BUNDLE.getString(ApiConstants.HMAPIC2007T), customResponse);
		return customResponse;

	}
}
