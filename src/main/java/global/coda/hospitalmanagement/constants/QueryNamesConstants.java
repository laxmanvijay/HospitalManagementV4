package global.coda.hospitalmanagement.constants;

/**
 *
 * @author Vijay
 *
 * Constants file that contains query names which are used throughout the application
 *
 */
public final class QueryNamesConstants {

	/**
	 *
	 */
	private QueryNamesConstants() {

	}

	public static final String CREATE_USER_QUERY = "insert into t_user(username,email,password,fk_role_id,phone,age) values(#{userName},#{email},#{password},#{fkRoleId},#{phone},#{age})";
	public static final String READ_ALL_USERS_QUERY = "select * from t_user where is_active=1";
	public static final String READ_USER_BY_ID_QUERY = "select * from t_user where pk_user_id=#{id} and is_active=1";
	public static final String READ_USER_BY_EMAIL_QUERY = "select * from t_user where email=#{email} and is_active=1";
	public static final String UPDATE_USER_QUERY = "update t_user set username = #{userName},email = #{email},password = #{password},fk_role_id = #{fkRoleId},phone = #{phone},age=#{age} where pk_user_id=#{pkUserId}";
	public static final String DELETE_USER_QUERY = "update t_user set is_active=0 where pk_user_id = #{id} and is_active=1";
	public static final String DELETE_USER_PERMANENTLY_QUERY = "delete from t_user where pk_user_id = #{id}";

	public static final String CREATE_PATIENT_QUERY = "insert into t_patient(weight,fk_user_id) values(#{weight},#{pkUserId})";
	public static final String READ_PATIENT_BY_ID_QUERY = "select * from t_user join t_patient on t_user.pk_user_id=t_patient.fk_user_id where fk_user_id=#{id} and is_active=1";
	public static final String UPDATE_PATIENT_QUERY = "update t_patient set weight = ? where fk_user_id = ? and is_active=1";
	public static final String READ_SEVERAL_PATIENT_WITH_THEIR_ID_QUERY = "select * from t_user join t_patient on t_user.pk_user_id=t_patient.fk_user_id where is_active = 1 and fk_user_id in (#{idstring})";

	public static final String CREATE_DOCTOR_QUERY = "insert into t_doctor(specialist,fk_user_id) values(#{specialist},#{pkUserId})";
	public static final String READ_DOCTOR_BY_ID_QUERY = "select * from t_user join t_doctor on t_user.pk_user_id=t_doctor.fk_user_id where fk_user_id=#{id} and is_active=1";
	public static final String UPDATE_DOCTOR_QUERY = "update t_doctor set specialist = #{specialist} where fk_user_id = #{pkUserId}";
	public static final String GET_ALL_PATIENT_ID_OF_A_DOCTOR_QUERY = "select fk_patient_id from t_patient_has_doctor where fk_doctor_id = #{id}";
	public static final String GET_ALL_PATIENTS_OF_ALL_DOCTORS_QUERY = "select t_user.pk_user_id,t_user.username,t_user.email,t_user.password,t_user.fk_role_id,t_user.age,t_user.phone,t_user.is_active,t_user.created_time,t_user.updated_time,"
			+ "u.pk_user_id as doctor_id,u.email as doctor_email,u.username as doctor_name from"
			+ "t_user join t_patient_has_doctor on t_user.pk_user_id=t_patient_has_doctor.fk_patient_id"
			+ "join t_user as u on t_patient_has_doctor.fk_doctor_id=u.pk_user_id where u.is_active=1;";

	public static final String CREATE_HOSPITAL_QUERY = "insert into t_hospital(hospital_name) values(#{hospitalName})";
	public static final String READ_HOSPITAL_BY_ID_QUERY = "select * from t_hospital where t_hospital_id=#{id} and is_active=1";
	public static final String UPDATE_HOSPITAL_QUERY = "update t_hospital set hospital_name=? where hospital_id=#{hospitalId} and is_active=1";
	public static final String DELETE_HOSPITAL_QUERY = "update t_hospital set is_active=0 where hospital_id = #{id} and is_active=1";

	public static final String CREATE_BRANCH_QUERY = "insert into t_branch(location,fk_hospital_id) values(#{location},#{fkHospitalId})";
	public static final String READ_BRANCH_BY_HOSPITAL_ID_QUERY = "select * from t_branch where fk_hospital_id=#{hospital_id} and is_active=1";
	public static final String UPDATE_BRANCH_QUERY = "update t_branch set location = #{location} where pk_branch_id=?";
	public static final String DELETE_BRANCH_QUERY = "update t_branch set is_active = 0 where pk_branch_id=#{id}";
	public static final String READ_BRANCH_BY_ID_QUERY = "select * from t_branch where pk_branch_id=#{id} and is_active=1";

}
