package cms.dao;

import java.util.List;
import java.util.Map;

import cms.pojo.User;

public interface UserDao {
	
	List<Map<String, Object>> findSession(User user);
	
	int count();
	
	int find(User user);

	int save(User user);

	List<Map<String, Object>> queryPage(Integer pageNo, Integer type, String mUser);
	
	int updateUser(Integer id);
	
	int delUser(Integer id);

	int Count(String mUser);
	
	List<Map<String, Object>> findUser(Integer id);
	
	int updateUser(User user);

	List<Map<String,Object>> find(String username, String password);
}
