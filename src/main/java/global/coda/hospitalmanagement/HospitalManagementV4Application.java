package global.coda.hospitalmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *
 * @author Vijay
 *
 */
@SpringBootApplication
public final class HospitalManagementV4Application {

	/**
	 *
	 */
	private HospitalManagementV4Application() {

	}

	/**
	 *
	 * @param args command line arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(HospitalManagementV4Application.class, args);
	}

}
