package global.coda.hospitalmanagement.constants;

import global.coda.hospitalmanagement.models.Branch;
import global.coda.hospitalmanagement.models.Doctor;
import global.coda.hospitalmanagement.models.Hospital;
import global.coda.hospitalmanagement.models.Patient;
import global.coda.hospitalmanagement.models.User;

/**
 *
 * @author Vijay
 *
 * Constants for DaoTest class.
 */
public final class DaoTestConstants {

	/**
	 *
	 */
	private DaoTestConstants() {

	}

	public static final String BRANCHNAME = "abc";
	public static final String PHONE = "56788998";
	public static final String HOSPITALNAME = "apollo";
	public static final int WEIGHT = 70;
	public static final String EMAIL = "abc@gmail.com";
	public static final String PASSWORD = "123";

	/**
	 *
	 * @return Branch
	 */
	public static Branch getBranch() {
		Branch branch = new Branch();
		branch.setLocation("t nagar");
		branch.setFkHospitalId(2);
		return branch;
	}

	/**
	 *
	 * @return Doctor
	 */
	public static Doctor getDoctor() {
		Doctor user = new Doctor();
		user.setUserName("doc1");
		user.setPhone("1234");
		user.setEmail(EMAIL);
		user.setPassword(PASSWORD);
		user.setFkRoleId(3);
		user.setSpecialist("md");
		return user;
	}

	/**
	 *
	 * @return Hospital
	 */
	public static Hospital getHospital() {
		Hospital hospital = new Hospital();
		hospital.setHospitalName("siims");
		return hospital;
	}

	/**
	 *
	 * @return Patient
	 */
	public static Patient getPatient() {
		Patient user = new Patient();
		user.setUserName("abcd");
		user.setPhone("1234");
		user.setEmail(EMAIL);
		user.setPassword(PASSWORD);
		user.setActive(true);
		user.setAge(50);
		user.setFkRoleId(4);
		user.setWeight(50);
		return user;
	}

	/**
	 *
	 * @return User
	 */
	public static User getUser() {
		User user = new User();
		user.setUserName("abc");
		user.setPhone("1234");
		user.setEmail(EMAIL);
		user.setPassword(PASSWORD);
		user.setActive(true);
		user.setAge(50);
		user.setFkRoleId(1);
		return user;
	}

}
