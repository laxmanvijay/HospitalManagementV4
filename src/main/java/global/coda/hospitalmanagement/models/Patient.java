package global.coda.hospitalmanagement.models;

/**
 *
 * @author Vijay
 *
 * entity that represents patient
 *
 */
public class Patient extends User {
	private int weight = -1;

	/**
	 * checks for null values in the object.
	 * @return boolean
	 */
	@Override
	public boolean isEmpty() {
		if (super.isEmpty() || weight == -1) {
			return true;
		}
		return false;

	}

	/**
	 * @return the weight
	 */
	public int getWeight() {
		return weight;
	}

	/**
	 * @param weight the weight to set
	 */
	public void setWeight(int weight) {
		this.weight = weight;
	}

	/**
	 *
	 */
	@Override
	public String toString() {
		return "Patient [weight=" + weight + ", isEmpty()=" + isEmpty() + ", getWeight()=" + getWeight()
		+ ", getPkUserId()=" + getPkUserId() + ", getUserName()=" + getUserName() + ", getPassword()="
		+ getPassword() + ", getFkRoleId()=" + getFkRoleId() + ", getEmail()=" + getEmail() + ", getAge()="
		+ getAge() + ", getPhone()=" + getPhone() + ", isActive()=" + isActive() + ", getCreatedTime()="
		+ getCreatedTime() + ", getUpdatedTime()=" + getUpdatedTime() + ", toString()=" + super.toString()
		+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
	}


}
