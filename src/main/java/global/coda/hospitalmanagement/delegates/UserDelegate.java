package global.coda.hospitalmanagement.delegates;

import java.util.ResourceBundle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import global.coda.hospitalmanagement.constants.DelegateConstants;
import global.coda.hospitalmanagement.exceptions.BusinessException;
import global.coda.hospitalmanagement.exceptions.SystemException;
import global.coda.hospitalmanagement.mappers.UserMapper;
import global.coda.hospitalmanagement.models.User;

/**
 *
 * @author Vijay
 *
 * Delegate class controlling user operations
 *
 */

@Component("userDelegate")
public class UserDelegate {

	@Autowired
	private UserMapper userDao;

	private static final Logger LOGGER = LoggerFactory.getLogger(UserDelegate.class);
	private static final ResourceBundle LOG_RESOURCE_BUNDLE = ResourceBundle
			.getBundle(DelegateConstants.DELEGATE_LOG_MESSAGE_BUNDLE_NAME);

	/**
	 *
	 * @param user the user's model
	 * @return int id of the created user
	 * @throws SystemException thrown in case of system errors
	 * @throws BusinessException client side exception
	 */
	public int createUser(User user) throws SystemException, BusinessException {
		LOGGER.trace(LOG_RESOURCE_BUNDLE.getString(DelegateConstants.HMDC3000T), user.toString());
		int res;
		try {
			res = userDao.createUser(user);
		} catch (Exception e) {
			throw new SystemException(e.getMessage());
		}
		LOGGER.trace(LOG_RESOURCE_BUNDLE.getString(DelegateConstants.HMDC3001T), res);

		return res;
	}

	/**
	 *
	 * @param id id of the user
	 * @return User
	 * @throws SystemException thrown in case of system errors
	 * @throws BusinessException client side exception
	 */
	public User readUser(int id) throws SystemException, BusinessException {
		LOGGER.trace(LOG_RESOURCE_BUNDLE.getString(DelegateConstants.HMDC3002T), id);
		User user;
		try {
			user = userDao.readUserById(id);
		} catch (Exception e) {
			throw new SystemException(e.getMessage());
		}
		LOGGER.trace(LOG_RESOURCE_BUNDLE.getString(DelegateConstants.HMDC3003T), user.toString());
		return user;
	}

	/**
	 *
	 * @param user the user's entity
	 * @return boolean
	 * @throws SystemException thrown in case of system errors
	 * @throws BusinessException client side exception
	 */
	public int updateUser(User user) throws SystemException, BusinessException {
		LOGGER.trace(LOG_RESOURCE_BUNDLE.getString(DelegateConstants.HMDC3004T), user.toString());
		int res;
		try {
			res = userDao.updateUser(user);
		} catch (Exception e) {
			throw new SystemException(e.getMessage());
		}
		LOGGER.trace(LOG_RESOURCE_BUNDLE.getString(DelegateConstants.HMDC3005T), res);
		return res;
	}

	/**
	 *
	 * @param id id of the user
	 * @return boolean
	 * @throws SystemException thrown in case of system errors
	 * @throws BusinessException client side exceptions
	 */
	public int deleteuser(int id) throws SystemException, BusinessException {
		LOGGER.trace(LOG_RESOURCE_BUNDLE.getString(DelegateConstants.HMDC3006T), id);
		int res;
		try {
			res = userDao.deleteUser(id);
		} catch (Exception e) {
			throw new SystemException(e.getMessage());
		}
		LOGGER.trace(LOG_RESOURCE_BUNDLE.getString(DelegateConstants.HMDC3007T), res);
		return res;
	}
}
