package global.coda.hospitalmanagement;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 *
 * @author Vijay
 *
 * Initialize servlets
 *
 */
public class ServletInitializer extends SpringBootServletInitializer {

	/**
	 * @param application root app
	 */
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(HospitalManagementV4Application.class);
	}

}
