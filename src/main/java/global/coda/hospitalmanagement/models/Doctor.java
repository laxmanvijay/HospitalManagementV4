package global.coda.hospitalmanagement.models;

import java.util.List;

/**
 *
 * @author Vijay
 *
 * entity that represents doctor.
 *
 */
public class Doctor extends User {

	private String specialist;
	private List<Patient> patients;

	/**
	 * checks for null values in the object.
	 * @return boolean
	 */
	@Override
	public boolean isEmpty() {
		if (super.isEmpty() || specialist == null) {
			return true;
		}
		return false;

	}

	/**
	 * @return the patients
	 */
	public List<Patient> getPatients() {
		return patients;
	}

	/**
	 * @param patients the patients to set
	 */
	public void setPatients(List<Patient> patients) {
		this.patients = patients;
	}



	/**
	 * @return the specialist
	 */
	public String getSpecialist() {
		return specialist;
	}

	/**
	 * @param specialist the specialist to set
	 */
	public void setSpecialist(String specialist) {
		this.specialist = specialist;
	}

	/**
	 *
	 */
	@Override
	public String toString() {
		return "Doctor [specialist=" + specialist + ", isEmpty()=" + isEmpty() + ", getSpecialist()=" + getSpecialist()
		+ ", getPkUserId()=" + getPkUserId() + ", getUserName()=" + getUserName() + ", getPassword()="
		+ getPassword() + ", getFkRoleId()=" + getFkRoleId() + ", getEmail()=" + getEmail() + ", getAge()="
		+ getAge() + ", getPhone()=" + getPhone() + ", isActive()=" + isActive() + ", getCreatedTime()="
		+ getCreatedTime() + ", getUpdatedTime()=" + getUpdatedTime() + ", toString()=" + super.toString()
		+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
	}


}
