package global.coda.hospitalmanagement.security;

import java.util.ResourceBundle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import global.coda.hospitalmanagement.constants.ApiConstants;
import global.coda.hospitalmanagement.controllers.AuthenticationController;
import global.coda.hospitalmanagement.exceptions.BusinessException;
import global.coda.hospitalmanagement.exceptions.SystemException;
import global.coda.hospitalmanagement.mappers.UserMapper;
import global.coda.hospitalmanagement.models.LoginModel;
import global.coda.hospitalmanagement.models.User;

@Component
public class UsernamePasswordAuth {

	private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationController.class);
	private static final ResourceBundle LOG_RESOURCE_BUNDLE = ResourceBundle
			.getBundle(ApiConstants.API_LOG_MESSAGE_BUNDLE_NAME);

	@Autowired
	private UserMapper userMapper;

	public User login(LoginModel loginModel) throws BusinessException, SystemException {
		LOGGER.trace("login method of UsernamePasswordAuth called with parameters {}",loginModel);
		User user = null;
		try {
			user = userMapper.readUserByEmail(loginModel.getEmail());
			if(user.getPassword().equals(loginModel.getPassword())) {
				return user;
			} else {
				throw new BusinessException("user not found");
			}
		} catch(BusinessException e) {
			LOGGER.error("BusinessException error occurred in login method of UsernamePasswordAuth {}",e.getMessage());
			throw new BusinessException(e.getMessage());
		} catch (Exception e) {
			LOGGER.error("Exception error occurred in login method of UsernamePasswordAuth {}",e.getMessage());
			throw new SystemException(e.getMessage());
		} finally {
			LOGGER.trace("outside of login method of UsernamePasswordAuth with return value {}", user);
		}
	}
}
