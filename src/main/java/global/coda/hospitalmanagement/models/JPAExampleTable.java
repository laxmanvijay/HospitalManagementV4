package global.coda.hospitalmanagement.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class JPAExampleTable {

	@Id
	private int value;

	public JPAExampleTable() {

	}

	public JPAExampleTable(int i) {
		value = i;
	}

	/**
	 * @return the value
	 */
	public int getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(int value) {
		this.value = value;
	}


}
