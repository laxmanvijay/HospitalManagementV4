package global.coda.hospitalmanagement.delegates;

import java.util.List;
import java.util.ResourceBundle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import global.coda.hospitalmanagement.constants.DelegateConstants;
import global.coda.hospitalmanagement.exceptions.BusinessException;
import global.coda.hospitalmanagement.exceptions.DuplicateIdException;
import global.coda.hospitalmanagement.exceptions.SystemException;
import global.coda.hospitalmanagement.mappers.DoctorMapper;
import global.coda.hospitalmanagement.mappers.PatientMapper;
import global.coda.hospitalmanagement.mappers.UserMapper;
import global.coda.hospitalmanagement.models.Doctor;
import global.coda.hospitalmanagement.models.Patient;
import global.coda.hospitalmanagement.models.PatientWithDoctor;

/**
 *
 * @author Vijay
 *
 * Delegate class controlling the doctor operations.
 *
 */
@Component("doctorDelegate")
public class DoctorDelegate {

	@Autowired
	private DoctorMapper doctorDao;

	@Autowired
	private UserMapper userDao;

	@Autowired
	private PatientMapper patientDao;

	private static final Logger LOGGER = LoggerFactory.getLogger(DoctorDelegate.class);
	private static final ResourceBundle LOG_RESOURCE_BUNDLE = ResourceBundle
			.getBundle(DelegateConstants.DELEGATE_LOG_MESSAGE_BUNDLE_NAME);


	/**
	 *
	 * @param user user's model
	 * @return int id of the doctor
	 * @throws SystemException thrown in case of system errors
	 * @throws BusinessException client side exceptions
	 */
	public int createDoctor(Doctor user) throws SystemException, BusinessException {
		LOGGER.info(LOG_RESOURCE_BUNDLE.getString(DelegateConstants.HMDC1000T), user);
		if (user == null) {
			throw new BusinessException("id not found");
		}
		int res;
		try {
			System.out.println(user.getEmail());
			userDao.createUser(user);
			doctorDao.createDoctor(user);
			res = user.getPkUserId();
			if (res == -1) {
				throw new DuplicateIdException();
			}
		} catch (DuplicateIdException e) {
			throw new BusinessException("duplicate id");
		} catch (Exception e) {
			throw new SystemException(e.getMessage());
		}
		LOGGER.trace(LOG_RESOURCE_BUNDLE.getString(DelegateConstants.HMDC1001T), res);
		return res;
	}

	/**
	 *
	 * @param id id of the doctor
	 * @return doctor the doctor model
	 * @throws SystemException thrown in case of system errors
	 * @throws BusinessException client side exceptions
	 */
	public Doctor readDoctor(int id) throws SystemException, BusinessException {
		LOGGER.trace(LOG_RESOURCE_BUNDLE.getString(DelegateConstants.HMDC1002T), id);
		if (id == 0) {
			throw new BusinessException("id not given");
		}
		Doctor user;
		try {
			user = doctorDao.readDoctorbyUserId(id);
			if (user == null) {
				throw new BusinessException("id not found");
			}
		} catch (Exception e) {
			throw new SystemException(e.getMessage());
		}
		LOGGER.trace(LOG_RESOURCE_BUNDLE.getString(DelegateConstants.HMDC1003T), user);
		return user;
	}

	/**
	 *
	 * @param doctor the doctor's model
	 * @return boolean update status
	 * @throws SystemException thrown in case of system errors
	 * @throws BusinessException client side exceptions
	 */
	public boolean updateDoctor(Doctor doctor) throws SystemException, BusinessException {
		LOGGER.trace(LOG_RESOURCE_BUNDLE.getString(DelegateConstants.HMDC1004T), doctor);
		int res;
		if (doctor == null) {
			throw new BusinessException("id not found");
		}
		if (doctor.isEmpty()) {
			throw new BusinessException("provide all values");
		}
		try {
			userDao.updateUser(doctor);
			res = doctorDao.updateDoctor(doctor);
			System.out.println(doctor.getAge());
			if (res == 0) {
				throw new BusinessException("id not found");
			}
		} catch (Exception e) {
			throw new SystemException(e.getMessage());
		}
		LOGGER.trace(LOG_RESOURCE_BUNDLE.getString(DelegateConstants.HMDC1005T), res);
		return true;
	}

	/**
	 *
	 * @param id id of the doctor
	 * @return boolean delete status
	 * @throws SystemException thrown in case of system errors
	 * @throws BusinessException client side exceptions
	 */
	public int deleteDoctor(int id) throws SystemException, BusinessException {
		LOGGER.trace(LOG_RESOURCE_BUNDLE.getString(DelegateConstants.HMDC1006T), id);
		int res;
		if (id == 0) {
			throw new BusinessException("id not given");
		}
		try {
			res = userDao.deleteUser(id);
			if (res == 0) {
				throw new BusinessException("id not found");
			}
		} catch (Exception e) {
			throw new SystemException(e.getMessage());
		}
		LOGGER.trace(LOG_RESOURCE_BUNDLE.getString(DelegateConstants.HMDC1007T), res);
		return res;
	}

	/**
	 *
	 * @param id id of doctor
	 * @return List<Patient>
	 * @throws SystemException server side
	 * @throws BusinessException client side
	 */
	public List<Patient> getAllPatientsOfADoctor(int id) throws SystemException, BusinessException {
		LOGGER.trace(LOG_RESOURCE_BUNDLE.getString(DelegateConstants.HMDC1008T), id);
		List<Patient> res;
		if (id == 0) {
			throw new BusinessException("id not found");
		}
		try {
			List<Integer> patientId = doctorDao.getAllPatientIdOfADoctor(id);
			if (patientId.isEmpty()) {
				throw new BusinessException("no patient record found");
			}
			StringBuilder idstring = new StringBuilder();
			patientId.forEach(x -> {
				idstring.append(x + ",");
			});
			res = patientDao.getSeveralPatientsWithTheirId(idstring.toString());
			if (res.isEmpty()) {
				throw new BusinessException("no patient record found");
			}
		} catch (Exception e) {
			throw new SystemException(e.getMessage());
		}
		LOGGER.trace(LOG_RESOURCE_BUNDLE.getString(DelegateConstants.HMDC1009T), res);
		return res;
	}

	/**
	 *
	 * @return List<PatientWithDoctor>
	 * @throws SystemException server side errors
	 * @throws BusinessException client side errors
	 */
	public List<PatientWithDoctor> getAllPatientsOfAllDoctors() throws SystemException, BusinessException {
		LOGGER.trace(LOG_RESOURCE_BUNDLE.getString(DelegateConstants.HMDC1008T));
		List<PatientWithDoctor> patients;
		try {
			patients = doctorDao.getAllPatientsOfAllDoctors();
			if (patients.isEmpty()) {
				throw new BusinessException("no patient record found");
			}
		} catch (Exception e) {
			throw new SystemException(e.getMessage());
		}
		LOGGER.trace(LOG_RESOURCE_BUNDLE.getString(DelegateConstants.HMDC1009T), patients);
		return patients;
	}
}
