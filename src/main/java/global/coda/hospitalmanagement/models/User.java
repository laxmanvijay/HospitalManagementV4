package global.coda.hospitalmanagement.models;

import java.sql.Timestamp;

/**
 *
 * @author Vijay
 *
 * entity that represents a user
 *
 */
public class User {
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

	/**
	 * checks for null values in the object.
	 * @return boolean
	 */
	public boolean isEmpty() {
		if (userName == null || password == null || fkRoleId == -1 || email == null || age == -1 || phone == null) {
			return true;
		}
		return false;
	}

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
	 *
	 */
	@Override
	public String toString() {
		return "User [pkUserId=" + pkUserId + ", userName=" + userName + ", password=" + password + ", fkRoleId="
				+ fkRoleId + ", email=" + email + ", age=" + age + ", phone=" + phone + ", isActive=" + isActive
				+ ", createdTime=" + createdTime + ", updatedTime=" + updatedTime + ", isEmpty()=" + isEmpty()
				+ ", getPkUserId()=" + getPkUserId() + ", getUserName()=" + getUserName() + ", getPassword()="
				+ getPassword() + ", getFkRoleId()=" + getFkRoleId() + ", getEmail()=" + getEmail() + ", getAge()="
				+ getAge() + ", getPhone()=" + getPhone() + ", isActive()=" + isActive() + ", getCreatedTime()="
				+ getCreatedTime() + ", getUpdatedTime()=" + getUpdatedTime() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}


}
