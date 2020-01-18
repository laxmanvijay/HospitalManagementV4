package global.coda.hospitalmanagement.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import global.coda.hospitalmanagement.constants.QueryNamesConstants;
import global.coda.hospitalmanagement.models.Patient;

/**
 * Maps Patient model and patient table.
 *
 * @author Vijay
 *
 */
@Mapper
public interface PatientMapper {

	/**
	 *
	 * @param patient the patient model
	 * @return int the number of rows affected
	 */
	@Insert(QueryNamesConstants.CREATE_PATIENT_QUERY)
	int createPatient(Patient patient);

	/**
	 *
	 * @param id id of the patient
	 * @return Patient
	 */
	@Select(QueryNamesConstants.READ_PATIENT_BY_ID_QUERY)
	Patient readPatientByUserId(int id);

	/**
	 *
	 * @param idstring string of ids
	 * @return List<Patient>
	 */
	@Select(QueryNamesConstants.READ_SEVERAL_PATIENT_WITH_THEIR_ID_QUERY)
	List<Patient> getSeveralPatientsWithTheirId(String idstring);

	/**
	 *
	 * @param patient the patient model
	 * @return int the number of rows affected
	 */
	@Update(QueryNamesConstants.UPDATE_PATIENT_QUERY)
	int updatePatient(Patient patient);

	/**
	 *
	 * @param id id of the patient
	 * @return int the number of rows affected
	 */
	@Delete(QueryNamesConstants.DELETE_USER_QUERY)
	int deletePatient(int id);
}
