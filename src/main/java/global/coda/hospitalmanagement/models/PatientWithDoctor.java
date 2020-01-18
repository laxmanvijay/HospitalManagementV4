package global.coda.hospitalmanagement.models;

import java.sql.Timestamp;

/**
 *
 * @author Vijay
 *
 * Combined bean having both patient and doctor
 *
 */
public class PatientWithDoctor {
	private int pkUserId;
	private String userName;
	private String password;
	private int fkRoleId = -1;
	private String email;
	private int age = -1;
	private String phone;
	private boolean isActive;
	private Timestamp createdTime;
	private Timestamp updatedTime;
	private int doctorId;
	private String doctorEmail;
	private String doctorName;
	/**
	 * @return the pkUserId
	 */
	public int getPkUserId() {
		return pkUserId;
	}
	/**
	 * @param pkUserId the pkUserId to set
	 */
	public void setPkUserId(int pkUserId) {
		this.pkUserId = pkUserId;
	}
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the fkRoleId
	 */
	public int getFkRoleId() {
		return fkRoleId;
	}
	/**
	 * @param fkRoleId the fkRoleId to set
	 */
	public void setFkRoleId(int fkRoleId) {
		this.fkRoleId = fkRoleId;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}
	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}
	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * @return the isActive
	 */
	public boolean isActive() {
		return isActive;
	}
	/**
	 * @param isActive the isActive to set
	 */
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	/**
	 * @return the createdTime
	 */
	public Timestamp getCreatedTime() {
		return createdTime;
	}
	/**
	 * @param createdTime the createdTime to set
	 */
	public void setCreatedTime(Timestamp createdTime) {
		this.createdTime = createdTime;
	}
	/**
	 * @return the updatedTime
	 */
	public Timestamp getUpdatedTime() {
		return updatedTime;
	}
	/**
	 * @param updatedTime the updatedTime to set
	 */
	public void setUpdatedTime(Timestamp updatedTime) {
		this.updatedTime = updatedTime;
	}
	/**
	 * @return the doctorId
	 */
	public int getDoctorId() {
		return doctorId;
	}
	/**
	 * @param doctorId the doctorId to set
	 */
	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}
	/**
	 * @return the doctorEmail
	 */
	public String getDoctorEmail() {
		return doctorEmail;
	}
	/**
	 * @param doctorEmail the doctorEmail to set
	 */
	public void setDoctorEmail(String doctorEmail) {
		this.doctorEmail = doctorEmail;
	}
	/**
	 * @return the doctorName
	 */
	public String getDoctorName() {
		return doctorName;
	}
	/**
	 * @param doctorName the doctorName to set
	 */
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	/**
	 *
	 */
	@Override
	public String toString() {
		return "PatientWithDoctor [pkUserId=" + pkUserId + ", userName=" + userName + ", password=" + password
				+ ", fkRoleId=" + fkRoleId + ", email=" + email + ", age=" + age + ", phone=" + phone + ", isActive="
				+ isActive + ", createdTime=" + createdTime + ", updatedTime=" + updatedTime + ", doctorId=" + doctorId
				+ ", doctorEmail=" + doctorEmail + ", doctorName=" + doctorName + ", getPkUserId()=" + getPkUserId()
				+ ", getUserName()=" + getUserName() + ", getPassword()=" + getPassword() + ", getFkRoleId()="
				+ getFkRoleId() + ", getEmail()=" + getEmail() + ", getAge()=" + getAge() + ", getPhone()=" + getPhone()
				+ ", isActive()=" + isActive() + ", getCreatedTime()=" + getCreatedTime() + ", getUpdatedTime()="
				+ getUpdatedTime() + ", getDoctorId()=" + getDoctorId() + ", getDoctorEmail()=" + getDoctorEmail()
				+ ", getDoctorName()=" + getDoctorName() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}


}
