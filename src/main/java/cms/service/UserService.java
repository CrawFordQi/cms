package cms.service;

import java.util.List;
import java.util.Map;

import cms.pojo.User;

public interface UserService {

	List<Map<String,Object>> find(String username,String password);
	
	int count();
	int count(String mUser);

	/**
	 * 检测是否存在
	 * @param user
	 * @return
	 */
	int find(User user);
	
	/**
	 * 用户注册 type 默认为0
	 * @param user
	 * @return
	 */
	int save(User user);
	
	/**
	 * 分页查询数据
	 * @param mUser 
	 * @param user
	 * @return
	 */
	List<Map<String, Object>> queryPage(Integer pageNo, Integer type, String mUser);
	
	/**
	 * session检测
	 * @param user
	 * @return
	 */
	List<Map<String, Object>> findSession(User user);
	
	/**
	 * 修改用户
	 * @param user
	 * @return
	 */
	int updateUser(User user);
	
	/**
	 * 删除用户
	 * @param user
	 * @return
	 */
	int delUser(Integer id);
	
	/**
	 * 根据ID查询user 信息
	 * @param id
	 * @return
	 */
	List<Map<String, Object>> findUser(Integer id);
	

}
