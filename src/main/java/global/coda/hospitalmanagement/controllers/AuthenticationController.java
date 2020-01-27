package global.coda.hospitalmanagement.controllers;

import java.util.ResourceBundle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import global.coda.hospitalmanagement.constants.ApiConstants;
import global.coda.hospitalmanagement.exceptions.BusinessException;
import global.coda.hospitalmanagement.exceptions.SystemException;
import global.coda.hospitalmanagement.models.CustomResponse;
import global.coda.hospitalmanagement.models.LoginModel;
import global.coda.hospitalmanagement.models.User;
import global.coda.hospitalmanagement.security.UsernamePasswordAuth;

@CrossOrigin
@RestController
@RequestMapping("/AuthenticationService")
public class AuthenticationController {

	private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationController.class);
	private static final ResourceBundle LOG_RESOURCE_BUNDLE = ResourceBundle
			.getBundle(ApiConstants.API_LOG_MESSAGE_BUNDLE_NAME);

	@Autowired
	private UsernamePasswordAuth usernamePasswordAuth;


	@RequestMapping(value = "/", method = RequestMethod.POST)
	public CustomResponse<User> login(@RequestBody LoginModel loginModel) throws BusinessException, SystemException {
		LOGGER.trace("login method of AuthenticationController called with parameter {}", loginModel);
		CustomResponse<User> customResponse = new CustomResponse<User>();
		User user = usernamePasswordAuth.login(loginModel);
		customResponse.setData(user);
		customResponse.setStatusCode(200);
		LOGGER.trace("outside of login method of AuthenticationController with return value {}");
		return customResponse;
	}

}
