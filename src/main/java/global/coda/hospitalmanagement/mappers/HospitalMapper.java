package global.coda.hospitalmanagement.mappers;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import global.coda.hospitalmanagement.constants.QueryConstants;
import global.coda.hospitalmanagement.models.Hospital;

/**
 * Maps Hospital Model and hospital table.
 *
 * @author Vijay
 *
 */
@Mapper
public interface HospitalMapper {

	/**
	 *
	 * @param hospital the hospital model
	 * @return int the number of rows affected
	 */
	@Insert(QueryConstants.CREATE_HOSPITAL_QUERY)
	int createHospital(Hospital hospital);

	/**
	 *
	 * @param id id of the hospital
	 * @return Hospital
	 */
	@Select(QueryConstants.READ_HOSPITAL_BY_ID_QUERY)
	Hospital readHospitalById(int id);

	/**
	 *
	 * @param hospital the hospital model
	 * @return int the number of rows affected
	 */
	@Update(QueryConstants.UPDATE_HOSPITAL_QUERY)
	int updateHospital(Hospital hospital);

	/**
	 *
	 * @param id id of the hospital
	 * @return int the number of rows affected
	 */
	@Update(QueryConstants.DELETE_HOSPITAL_QUERY)
	int deleteHospital(int id);
}
