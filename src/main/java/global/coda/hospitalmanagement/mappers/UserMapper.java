package global.coda.hospitalmanagement.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import global.coda.hospitalmanagement.constants.QueryConstants;
import global.coda.hospitalmanagement.models.User;

/**
 * Maps User model and user table.
 *
 * @author Vijay
 *
 */
@Mapper
public interface UserMapper {

	/**
	 * creates the user and also sets the generated id of the user in the model.
	 *
	 * @param user the user model
	 * @return int the number of rows affected
	 */
	@Insert(QueryConstants.CREATE_USER_QUERY)
	@Options(useGeneratedKeys = true, keyProperty = "pkUserId", keyColumn = "pk_user_id")
	int createUser(User user);

	/**
	 *
	 * @return List<User>
	 */
	@Select(QueryConstants.READ_ALL_USERS_QUERY)
	List<User> readAllUsers();

	/**
	 *
	 * @param id id of the user
	 * @return User
	 */
	@Select(QueryConstants.READ_USER_BY_ID_QUERY)
	User readUserById(int id);

	/**
	 *
	 * @param email email of the user
	 * @return User
	 */
	@Select(QueryConstants.READ_USER_BY_EMAIL_QUERY)
	User readUserByEmail(String email);

	/**
	 *
	 * @param user the user model
	 * @return int the number of rows affected
	 */
	@Update(QueryConstants.UPDATE_USER_QUERY)
	int updateUser(User user);

	/**
	 *
	 * @param id id of the user
	 * @return int the number of rows affected
	 */
	@Update(QueryConstants.DELETE_USER_QUERY)
	int deleteUser(int id);

	/**
	 *
	 * @param id id of the user
	 * @return int the number of rows affected
	 */
	@Delete(QueryConstants.DELETE_USER_PERMANENTLY_QUERY)
	int deleteUserPermanently(int id);
}
