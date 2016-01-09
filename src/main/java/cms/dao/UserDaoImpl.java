package cms.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import cms.pojo.User;

@Repository
public class UserDaoImpl implements UserDao {
	

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<Map<String, Object>> findSession(User user) {
		String sql="select * from user u where u.username = '"+user.getUsername()+"' and u.password = '"+user.getPassword()+"'";
		List<Map<String,Object>> list = jdbcTemplate.queryForList(sql);
		return list;
	}

	public int count() {
		String sql="select count(*) from user ";
		return jdbcTemplate.queryForInt(sql);
	}

	public int find(User user) {
		String sql="select * from user u where u.username = '"+user.getUsername()+"' and u.password = '"+user.getPassword()+"'";
		List<Map<String,Object>> list = jdbcTemplate.queryForList(sql);
		if (list.size() > 0) {
			return 1;
		}
		return 0;
	}
	
	public int save(User user) {
		String sql="insert into user(username,password,type) values('"+user.getUsername()+"','"+user.getPassword()+"','0')";
		return jdbcTemplate.update(sql);
	}

	public List<Map<String, Object>> queryPage(Integer pageNo,Integer type,String mUser) {
		int a = (pageNo - 1) * 5;
		String sql = "select * from user where username LIKE '%"+mUser+"%' and type = "+type+" limit "+a+",5";
		return jdbcTemplate.queryForList(sql);
	}

	public int updateUser(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int delUser(Integer id) {
		String sql ="delete from user where id  = "+id;
		return jdbcTemplate.update(sql);
	}

	public int Count(String mUser) {
		String sql="select count(*) from user where type = 0 and username like '%"+mUser+"%'";
		return jdbcTemplate.queryForInt(sql);
	}

	public List<Map<String, Object>> findUser(Integer id) {
		String sql = "select * from user where id =" +id;
		return jdbcTemplate.queryForList(sql);
	}
	
	public int updateUser(User user) {
		String sql="UPDATE user  set username ='"+user.getUsername()+"',password ='"+user.getPassword()+"'  where id="+user.getId();
		return jdbcTemplate.update(sql); 
	}

	public List<Map<String,Object>> find(String username, String password) {
		String sql = "select * from user where username = ?  and password ='1'";
		return jdbcTemplate.queryForList(sql, new Object[] {username});
	}


}
