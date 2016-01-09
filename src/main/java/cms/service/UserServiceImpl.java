package cms.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cms.dao.UserDao;
import cms.pojo.User;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;

	public List<Map<String,Object>> find(String username,String password) {
		// TODO Auto-generated method stub
		return userDao.find(username,password);
	}

	public int count() {
		// TODO Auto-generated method stub
		return userDao.count();
	}

	public int find(User user) {
		
		return userDao.find(user);
	}
	
	public int save(User user){
		
		return userDao.save(user);
	}

	public List<Map<String, Object>> queryPage(Integer pageNo,Integer type,String mUser) {
		if("".equals(type) || null == type){
			type = 0;
		}
		if("".equals(mUser) || null == mUser){
			mUser = "";
		}
		List<Map<String, Object>> list = userDao.queryPage(pageNo,type,mUser);
		return list;
	}

	public List<Map<String, Object>> findSession(User user) {

		return userDao.findSession(user);
	}

	public int updateUser(User user) {
		return userDao.updateUser(user);
	} 

	public int delUser(Integer id) {
		return userDao.delUser(id);
	}

	public int count(String mUser) {
		if (null == mUser || "".equals(mUser)) {
			mUser = "";
		}
		return userDao.Count(mUser);
	}

	public List<Map<String, Object>> findUser(Integer id) {
		return userDao.findUser(id);
	}
}
