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
import global.coda.hospitalmanagement.mappers.UserMapper;
import global.coda.hospitalmanagement.models.Doctor;

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
		if (user == null) {
			throw new BusinessException("id not found");
		}
		LOGGER.trace(LOG_RESOURCE_BUNDLE.getString(DelegateConstants.HMDC1000T), user.toString());
		int res;
		try {
			userDao.createUser(user);
			if (user.getSpecialist()==null) {
				user.setSpecialist("not specified");
			}
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
	public List<Doctor> readDoctor(int id, boolean requirePatients) throws SystemException, BusinessException {
		LOGGER.trace(LOG_RESOURCE_BUNDLE.getString(DelegateConstants.HMDC1002T), id);
		List<Doctor> user;
		try {
			if (!requirePatients) {
				user = doctorDao.readDoctorbyUserId(id);
			} else {
				user = doctorDao.readDoctorbyUserIdAlongWithPatients(id);
			}
		} catch (Exception e) {
			throw new SystemException(e.getMessage());
		}
		if (user == null) {
			throw new BusinessException("id not found");
		}
		LOGGER.trace(LOG_RESOURCE_BUNDLE.getString(DelegateConstants.HMDC1003T), user.toString());
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
		LOGGER.trace(LOG_RESOURCE_BUNDLE.getString(DelegateConstants.HMDC1004T), doctor.toString());
		int res;
		try {
			res = userDao.updateUser(doctor);
			if (doctor.getSpecialist() != null) {
				res = doctorDao.updateDoctor(doctor);
			}
		} catch (Exception e) {
			throw new SystemException(e.getMessage());
		}
		if (res == 0) {
			throw new BusinessException("id not found");
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
		} catch (Exception e) {
			throw new SystemException(e.getMessage());
		}
		if (res == 0) {
			throw new BusinessException("id not found");
		}
		LOGGER.trace(LOG_RESOURCE_BUNDLE.getString(DelegateConstants.HMDC1007T), res);
		return res;
	}
}
