package global.coda.hospitalmanagement.models;

import java.sql.Timestamp;

/**
 *
 * @author Vijay
 *
 * Branch model that represents branch table
 *
 */
public class Branch {
	private int pkBranchId;
	private String location;
	private int fkHospitalId;
	private boolean isActive;
	private Timestamp createdTime;
	private Timestamp updatedTime;
	/**
	 * @return the pkBranchId
	 */
	public int getPkBranchId() {
		return pkBranchId;
	}
	/**
	 * @param pkBranchId the pkBranchId to set
	 */
	public void setPkBranchId(int pkBranchId) {
		this.pkBranchId = pkBranchId;
	}
	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}
	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}
	/**
	 * @return the fkHospitalId
	 */
	public int getFkHospitalId() {
		return fkHospitalId;
	}
	/**
	 * @param fkHospitalId the fkHospitalId to set
	 */
	public void setFkHospitalId(int fkHospitalId) {
		this.fkHospitalId = fkHospitalId;
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
		return "Branch [pkBranchId=" + pkBranchId + ", location=" + location + ", fkHospitalId=" + fkHospitalId
				+ ", isActive=" + isActive + ", createdTime=" + createdTime + ", updatedTime=" + updatedTime
				+ ", getPkBranchId()=" + getPkBranchId() + ", getLocation()=" + getLocation() + ", getFkHospitalId()="
				+ getFkHospitalId() + ", isActive()=" + isActive() + ", getCreatedTime()=" + getCreatedTime()
				+ ", getUpdatedTime()=" + getUpdatedTime() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}


}
