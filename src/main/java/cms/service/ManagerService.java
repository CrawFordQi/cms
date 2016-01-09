package cms.service;

import java.util.List;
import java.util.Map;

import cms.pojo.User;

public interface ManagerService {
	
	List<Map<String,Object>> findUser();

	int count(String mUser);

	List<Map<String, Object>> queryPage(Integer pageNo, Integer type, String mUser);

	int delAdmin(Integer id);

	List<Map<String, Object>> findAdmin(Integer id);

	int updateAdmin(User user);

	int save(User user);
	
	
}
