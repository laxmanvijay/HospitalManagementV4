package global.coda.hospitalmanagement.delegates;

import java.util.ResourceBundle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import global.coda.hospitalmanagement.constants.DelegateConstants;
import global.coda.hospitalmanagement.exceptions.BusinessException;
import global.coda.hospitalmanagement.exceptions.SystemException;
import global.coda.hospitalmanagement.mappers.PatientMapper;
import global.coda.hospitalmanagement.models.Patient;

/**
 *
 * @author Vijay
 *
 * Delegate class controlling the patient.
 *
 */

@Component("patientDelegate")
public class PatientDelegate {

	@Autowired
	private PatientMapper patientDao;

	private static final Logger LOGGER = LoggerFactory.getLogger(PatientDelegate.class);
	private static final ResourceBundle LOG_RESOURCE_BUNDLE = ResourceBundle
			.getBundle(DelegateConstants.DELEGATE_LOG_MESSAGE_BUNDLE_NAME);

	/**
	 *
	 * @param patient the patient's model
	 * @return int id of the created patient
	 * @throws SystemException thrown in case of system errors
	 * @throws BusinessException client side exceptions
	 */
	public int createPatient(Patient patient) throws SystemException, BusinessException {
		if (patient == null || patient.isEmpty()) {
			throw new BusinessException("id not found");
		}
		LOGGER.trace(LOG_RESOURCE_BUNDLE.getString(DelegateConstants.HMDC2000T), patient.toString());
		int res;
		try {
			res = patientDao.createPatient(patient);
		} catch (Exception e) {
			throw new SystemException(e.getMessage());
		}
		if (res == 0) {
			throw new SystemException("error creating patient");
		}
		LOGGER.trace(LOG_RESOURCE_BUNDLE.getString(DelegateConstants.HMDC2001T), res);
		return res;
	}

	/**
	 *
	 * @param id id of the patient(user id)
	 * @return Patient patient's model
	 * @throws SystemException thrown in case of system errors
	 * @throws BusinessException client side exceptions
	 */
	public Patient readPatient(int id) throws SystemException, BusinessException {
		LOGGER.trace(LOG_RESOURCE_BUNDLE.getString(DelegateConstants.HMDC2002T), id);
		if (id == 0) {
			throw new BusinessException("id not found");
		}
		Patient patient;
		try {
			patient = patientDao.readPatientByUserId(id);
		} catch (Exception e) {
			throw new SystemException(e.getMessage());
		}
		if (patient.isEmpty() || patient == null) {
			throw new BusinessException("id not found");
		}
		LOGGER.trace(LOG_RESOURCE_BUNDLE.getString(DelegateConstants.HMDC2003T), patient.toString());
		return patient;
	}

	/**
	 *
	 * @param patient the patient's model
	 * @return boolean update status
	 * @throws SystemException thrown in case of system errors
	 * @throws BusinessException client side exceptions
	 */
	public int updatePatient(Patient patient) throws SystemException, BusinessException {
		LOGGER.trace(LOG_RESOURCE_BUNDLE.getString(DelegateConstants.HMDC2004T), patient.toString());
		int res;
		if (patient == null || patient.isEmpty()) {
			throw new BusinessException("id not found");
		}
		try {
			res = patientDao.updatePatient(patient);
		} catch (Exception e) {
			throw new SystemException(e.getMessage());
		}
		if (res == 0) {
			throw new BusinessException("duplicate id");
		}
		LOGGER.trace(LOG_RESOURCE_BUNDLE.getString(DelegateConstants.HMDC2005T), res);
		return res;
	}

	/**
	 *
	 * @param id id of the patient
	 * @return boolean update status
	 * @throws SystemException thrown in case of system errors
	 * @throws BusinessException client side exceptions
	 */
	public int deletePatient(int id) throws SystemException, BusinessException {
		LOGGER.trace(LOG_RESOURCE_BUNDLE.getString(DelegateConstants.HMDC2006T), id);
		int res;
		if (id == 0) {
			throw new BusinessException("id not found");
		}
		try {
			res = patientDao.deletePatient(id);
		} catch (Exception e) {
			throw new SystemException(e.getMessage());
		}
		if (res == 0) {
			throw new BusinessException("id not found");
		}
		LOGGER.trace(LOG_RESOURCE_BUNDLE.getString(DelegateConstants.HMDC2007T), res);
		return res;
	}
}
