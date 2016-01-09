package cms.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cms.dao.ManagerDao;
import cms.pojo.User;

@Service
public class ManagerServiceImpl implements ManagerService{

	@Autowired
	private ManagerDao managerDao;
	
	/**
	 * 查询所有用户
	 */
	public List<Map<String, Object>> findUser() {
		
		return managerDao.findUser();
	}
	
	/**
	 * 模糊查询
	 */
	public int count(String mUser) {
		if (null == mUser || "".equals(mUser)) {
			mUser = "";
		}
		return managerDao.Count(mUser);
	}

	/**
	 * 分页查询系统用户
	 */
	public List<Map<String, Object>> queryPage(Integer pageNo,Integer type,String mUser) {
		if("".equals(type) || null == type){
			type = 0;
		}
		if("".equals(mUser) || null == mUser){
			mUser = "";
		}
		List<Map<String, Object>> list = managerDao.queryPage(pageNo,type,mUser);
		return list;
	}

	/**
	 * 删除用户 
	 */
	public int delAdmin(Integer id) {
		
		return managerDao.delAdmin(id);
	}
	/**
	 * 根据ID查询要修改用户
	 */
	public List<Map<String, Object>> findAdmin(Integer id) {
		
		return managerDao.findAdmin(id);
	}

	/**
	 * 修改admin用户
	 */
	public int updateAdmin(User user) {
		
		return managerDao.updateAdmin(user);
	}

	/**
	 * 添加用户
	 */
	public int save(User user) {
		
		return managerDao.save(user);
	}

}
