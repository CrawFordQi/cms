package cms.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import cms.pojo.User;

@Repository
public class ManagerDaoImpl implements ManagerDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<Map<String, Object>> findUser() {
		String sql = "select * from user";
		return jdbcTemplate.queryForList(sql);
	}

	public int Count(String mUser) {
		String sql="select count(*) from user where type = 1 and username like '%"+mUser+"%'";
		return jdbcTemplate.queryForInt(sql);
	}

	public List<Map<String, Object>> queryPage(Integer pageNo,Integer type,String mUser) {
		int a = (pageNo - 1) * 5;
		String sql = "select * from user where username LIKE '%"+mUser+"%' and type = "+type+" limit "+a+",5";
		return jdbcTemplate.queryForList(sql);
	}

	public int delAdmin(Integer id) {
		String sql ="delete from user where id  = "+id;
		return jdbcTemplate.update(sql);
	}

	public List<Map<String, Object>> findAdmin(Integer id) {
		String sql = "select * from user where id =" +id;
		return jdbcTemplate.queryForList(sql);
	}

	public int updateAdmin(User user) {
		String sql="UPDATE user  set username ='"+user.getUsername()+"',password ='"+user.getPassword()+"'  where id="+user.getId();
		return jdbcTemplate.update(sql); 
	}

	public int save(User user) {
		String sql="insert into user(username,password,type) values('"+user.getUsername()+"','"+user.getPassword()+"','1')";
		return jdbcTemplate.update(sql);
	}
}
