package global.coda.hospitalmanagement.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import global.coda.hospitalmanagement.constants.QueryNamesConstants;
import global.coda.hospitalmanagement.models.Doctor;
import global.coda.hospitalmanagement.models.PatientWithDoctor;

/**
 * Maps Doctor model and doctor table.
 *
 * @author Vijay
 *
 */
@Mapper
public interface DoctorMapper {

	/**
	 *
	 * @param id id of the doctor
	 * @return Doctor
	 */
	@Select(QueryNamesConstants.READ_DOCTOR_BY_ID_QUERY)
	Doctor readDoctorbyUserId(int id);

	/**
	 *
	 * @param doctor the doctor model
	 * @return int the number of rows affected
	 */
	@Insert(QueryNamesConstants.CREATE_DOCTOR_QUERY)
	int createDoctor(Doctor doctor);

	/**
	 *
	 * @param doctor the doctor model
	 * @return int the number of rows affected
	 */
	@Update(QueryNamesConstants.UPDATE_DOCTOR_QUERY)
	int updateDoctor(Doctor doctor);

	/**
	 *
	 * @param id id of the doctor
	 * @return int the number of rows affected
	 */
	@Delete(QueryNamesConstants.DELETE_USER_QUERY)
	int deleteDoctor(int id);

	/**
	 *
	 * @param id id of the doctor
	 * @return List<Integer> list of patient ids
	 */
	@Select(QueryNamesConstants.GET_ALL_PATIENT_ID_OF_A_DOCTOR_QUERY)
	List<Integer> getAllPatientIdOfADoctor(int id);

	/**
	 *
	 * @return List<PatientWithDoctor> list of patients and their doctors
	 */
	@Select(QueryNamesConstants.GET_ALL_PATIENTS_OF_ALL_DOCTORS_QUERY)
	List<PatientWithDoctor> getAllPatientsOfAllDoctors();
}
