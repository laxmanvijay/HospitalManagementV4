package global.coda.hospitalmanagement.models;

import java.sql.Timestamp;

/**
 *
 * @author Vijay
 *
 * entity that represents a hospital
 *
 */
public class Hospital {
	private int hospitalId;
	private String hospitalName;
	private boolean isActive;
	private Timestamp createdTime;
	private Timestamp updatedTime;
	/**
	 * @return the hospitalId
	 */
	public int getHospitalId() {
		return hospitalId;
	}
	/**
	 * @param hospitalId the hospitalId to set
	 */
	public void setHospitalId(int hospitalId) {
		this.hospitalId = hospitalId;
	}
	/**
	 * @return the hospitalName
	 */
	public String getHospitalName() {
		return hospitalName;
	}
	/**
	 * @param hospitalName the hospitalName to set
	 */
	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
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
		return "Hospital [hospitalId=" + hospitalId + ", hospitalName=" + hospitalName + ", isActive=" + isActive
				+ ", createdTime=" + createdTime + ", updatedTime=" + updatedTime + ", getHospitalId()="
				+ getHospitalId() + ", getHospitalName()=" + getHospitalName() + ", isActive()=" + isActive()
				+ ", getCreatedTime()=" + getCreatedTime() + ", getUpdatedTime()=" + getUpdatedTime() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}


}
