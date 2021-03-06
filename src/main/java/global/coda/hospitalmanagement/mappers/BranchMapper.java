package global.coda.hospitalmanagement.mappers;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import global.coda.hospitalmanagement.constants.QueryConstants;
import global.coda.hospitalmanagement.models.Branch;

/**
 * Maps branch table and Branch model.
 *
 * @author Vijay
 *
 */
@Mapper
public interface BranchMapper {

	/**
	 *
	 * @param branch branch model
	 * @return int the number of rows affected
	 */
	@Insert(QueryConstants.CREATE_BRANCH_QUERY)
	int createBranch(Branch branch);

	/**
	 *
	 * @param id id of the branch
	 * @return Branch the branch model
	 */
	@Select(QueryConstants.READ_BRANCH_BY_ID_QUERY)
	Branch readBranchById(int id);

	/**
	 *
	 * @param hospital_id id of hospital
	 * @return Branch
	 */
	@Select(QueryConstants.READ_BRANCH_BY_HOSPITAL_ID_QUERY)
	Branch readBranchByHospitalId(int hospital_id);

	/**
	 *
	 * @param branch the branch model
	 * @return int the number of rows affected
	 */
	@Update(QueryConstants.UPDATE_BRANCH_QUERY)
	int updateBranch(Branch branch);

	/**
	 *
	 * @param id id of the branch
	 * @return int the number of rows affected
	 */
	@Update(QueryConstants.DELETE_BRANCH_QUERY)
	int deleteBranch(int id);
}
