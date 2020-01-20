package global.coda.hospitalmanagement.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import global.coda.hospitalmanagement.constants.QueryConstants;
import global.coda.hospitalmanagement.models.Doctor;
import global.coda.hospitalmanagement.models.Patient;

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
	@Select(QueryConstants.READ_DOCTOR_BY_ID_QUERY)
	List<Doctor> readDoctorbyUserId(int id);

	/**
	 *
	 * @param doctor the doctor model
	 * @return int the number of rows affected
	 */
	@Insert(QueryConstants.CREATE_DOCTOR_QUERY)
	int createDoctor(Doctor doctor);

	/**
	 *
	 * @param doctor the doctor model
	 * @return int the number of rows affected
	 */
	@Update(QueryConstants.UPDATE_DOCTOR_QUERY)
	int updateDoctor(Doctor doctor);

	/**
	 *
	 * @param id id of the doctor
	 * @return int the number of rows affected
	 */
	@Delete(QueryConstants.DELETE_USER_QUERY)
	int deleteDoctor(int id);

	/**
	 *
	 * @param id id of the doctor
	 * @return Doctor
	 */
	@Select(QueryConstants.READ_DOCTOR_BY_ID_QUERY)
	@Results({
		@Result(property = "patients", column = "pk_user_id", javaType = List.class, many = @Many(select = "selectPatientsByDoctorId")),
		@Result(property = "pkUserId", column = "pk_user_id")
	})
	List<Doctor> readDoctorbyUserIdAlongWithPatients(int id);

	/**
	 *
	 * @param id id of the doctor
	 * @return List<Patient>
	 */
	@Select("select * from t_patient join t_user on t_patient.fk_user_id = t_user.pk_user_id where fk_user_id in (select fk_patient_id from t_patient_has_doctor where fk_doctor_id = #{id}) and is_active=1")
	List<Patient> selectPatientsByDoctorId(int id);
}
