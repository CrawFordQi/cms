package cms.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import cms.pojo.Content;
import cms.pojo.News_type;
import cms.pojo.User;

@Repository
public class ContentDaoImpl implements ContentDao{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	/**
	 * 分页查询  固定现实数据为5
	 * @param pageNo
	 * @return
	 */
	public List<Map<String, Object>> queryPage(Integer pageNo) {
		int a = (pageNo - 1) * 5;
		String sql = "select * from news limit "+a+",5";
		return jdbcTemplate.queryForList(sql);
	}
	
	public List<Map<String, Object>> queryContent(Integer id) {
		String sql = "select * from news where id = " +id;
		return jdbcTemplate.queryForList(sql);
	}

	public void insertPP(Integer id) {
		String sql ="update news set pplus = pplus+1  where id ="+id;
		List<Map<String, Object>> list = queryContent(id);
		int news_type  = (Integer)list.get(0).get("news_type");
		insertStatistics(id,news_type);
		jdbcTemplate.update(sql);
	}
	
	public void insertStatistics(Integer news_id ,Integer news_type) {
		String sql ="insert into statistics(clickdate,news_type,news_id) values (now(),"+news_type+","+news_id+")";
		jdbcTemplate.update(sql);
	}
	
	public List<Map<String, Object>> queryComment(Integer id) {
		String sql = "select * from comment where news_id = "+id +" ORDER BY id desc";
		return jdbcTemplate.queryForList(sql);
	}
	
	public int insertComment(Integer id, String comment,Integer user_id) {
		String sql = "insert into comment(news_id,comment,user_id) VALUES ("+id+",'"+comment+"',"+user_id+")";
		return jdbcTemplate.update(sql);
	}

	public int count() {
		String sql="select count(*) from news ";
		return jdbcTemplate.queryForInt(sql);
	}

	public int queryComment(String mUser) {
		String sql="select count(*) from news c,comment d,user u where d.user_id = u.id and c.id = d.news_id and d.comment like '%"+mUser+"%'";
		return jdbcTemplate.queryForInt(sql);
	}

	public List<Map<String, Object>> queryCommentPage(Integer pageNo,String mUser) {
		int a = (pageNo - 1) * 5;
		String sql = "select u.username,c.title,d.*  from news c,comment d,user u where d.user_id = u.id and c.id = d.news_id and d.comment like '%"+mUser+"%' limit "+a+",5";
		return jdbcTemplate.queryForList(sql);
	}

	public int delComment(Integer id) {
		String sql ="delete from comment where id  = "+id;
		return jdbcTemplate.update(sql);
	}

	public List<Map<String, Object>> queryNews_typePage(Integer pageNo,String mUser) {
		int a = (pageNo - 1) * 5;
		String sql = "select * from news_type where news_type_name like '%"+mUser+"%' limit "+a+",5";
		return jdbcTemplate.queryForList(sql);
	}

	public int queryNews_type(String mUser) {
		String sql="select count(*) from news_type where news_type_name like '%"+mUser+"%'";
		return jdbcTemplate.queryForInt(sql);
	}

	public int saveNews_type(String news_type) {
			String sql = "insert into news_type(news_type_name,number) VALUES ('"+news_type+"',0)";
			return jdbcTemplate.update(sql);
	}

	public int delNew_type(Integer id) {
			String sql ="delete from news_type where id  = "+id;
			return jdbcTemplate.update(sql);
		}

	public List<Map<String, Object>> findNws_type(Integer id) {
		String sql = "select * from news_type where id =" +id;
		return jdbcTemplate.queryForList(sql);
	}

	public int updateNews_type(News_type news_type) {
		String sql="UPDATE news_type  set news_type_name ='"+news_type.getNews_type_name()+"' where id="+news_type.getId();
		return jdbcTemplate.update(sql);
	}

	public List<Map<String, Object>> queryContentManagerPage(Integer pageNo, String mUser) {
		int a = (pageNo - 1) * 5;
		String sql = "select * from news  where title like '%"+mUser+"%' limit "+a+",5";
		return jdbcTemplate.queryForList(sql);
	}

	public int queryContentManager(String mUser) {
			String sql="select count(*) from news where title like '%"+mUser+"%'";
			return jdbcTemplate.queryForInt(sql);
	}

	public int delContentManager(Integer id) {
		String sql ="delete from news where id  = "+id;
		return jdbcTemplate.update(sql);
	}

	public List<Map<String, Object>> findContentManager(Integer id) {
		String sql = "select * from news where id =" +id;
		return jdbcTemplate.queryForList(sql);
	}

	 

	public int updateContentManagerA(Content content) {
		String sql="UPDATE news  set title ='"+content.getTitle()+"',content = '"+content.getContent()+"',image = '"+content.getImage()+"'  where id="+content.getId();
		return jdbcTemplate.update(sql);
	}

	public List<Map<String, Object>> addContentA() {
		String sql="select * from news_type";
		return jdbcTemplate.queryForList(sql);
	}

	public int addContentB(Content news) {
		String sql = "insert into news(title,content,pplus,news_type,image) VALUES ('"+news.getTitle()+"','"+news.getContent()+"',0,'"+news.getNews_type()+"','"+news.getImage()+"')";
		return jdbcTemplate.update(sql);
	}

	public int querySelectAll(String selectAll,String selectClasses) {
		String sql= "";
		if("1".equals(selectAll)){
			if (selectClasses != null) {
				sql = "select count(t.count) d from (select COUNT(*) count from statistics  where date_sub(curdate(), INTERVAL 7 DAY) <= date(`clickdate`) and news_type = "+selectClasses+" GROUP BY news_id ) t";
			}else{
				sql = "select count(t.count) d from (select COUNT(*) count from statistics  where date_sub(curdate(), INTERVAL 7 DAY) <= date(`clickdate`)  GROUP BY news_id ) t";
			}
		}else if ("2".equals(selectAll)) {
			if (selectClasses != null) {
				sql = "select count(t.count) d from (select COUNT(*) count from statistics  where date_sub(curdate(), INTERVAL 30 DAY) <= date(`clickdate`) and news_type = "+selectClasses+" GROUP BY news_id ) t";
			}else{
				sql = "select count(t.count) d from (select COUNT(*) count from statistics  where date_sub(curdate(), INTERVAL 30 DAY) <= date(`clickdate`)  GROUP BY news_id ) t";
			}
		}else{
			if (selectClasses != null) {
				sql = "select count(t.count) d from (select COUNT(*) count from statistics  where date_sub(curdate(), INTERVAL 90 DAY) <= date(`clickdate`) and news_type = "+selectClasses+" GROUP BY news_id ) t";
			}else{
				sql = "select count(t.count) d from (select COUNT(*) count from statistics  where date_sub(curdate(), INTERVAL 90 DAY) <= date(`clickdate`)  GROUP BY news_id ) t";
			}		
		}
		return jdbcTemplate.queryForInt(sql);
	}

	public List<Map<String, Object>> querySelectAll(Integer pageNo, String selectAll,String selectClasses) {
		int a = (pageNo - 1) * 5;
		String sql = "";
		if ("1".equals(selectAll)) {
			if (selectClasses != null) {
				sql = "select COUNT(*) count,c.* from news c,statistics d where date_sub(curdate(), INTERVAL 7 DAY) <= date(`clickdate`) and c.id =d.news_id and d.news_type = "+selectClasses+" GROUP BY news_id  ORDER BY count DESC  limit "+a+",5";
			}else{
				sql = "select COUNT(*) count,c.* from news c,statistics d where date_sub(curdate(), INTERVAL 7 DAY) <= date(`clickdate`) and c.id =d.news_id GROUP BY news_id  ORDER BY count DESC  limit "+a+",5";
			}
		}else if ("2".equals(selectAll)) {
			if (selectClasses == null) {
				sql = "select COUNT(*) count,c.* from news c,statistics d where date_sub(curdate(), INTERVAL 30 DAY) <= date(`clickdate`) and c.id =d.news_id GROUP BY news_id  ORDER BY count DESC  limit "+a+",5";
			}else{
				sql = "select COUNT(*) count,c.* from news c,statistics d where date_sub(curdate(), INTERVAL 30 DAY) <= date(`clickdate`) and c.id =d.news_id and d.news_type = "+selectClasses+" GROUP BY news_id  ORDER BY count DESC  limit "+a+",5";
			}		
		}else{
				if (selectClasses == null) {
					sql = "select COUNT(*) count,c.* from news c,statistics d where date_sub(curdate(), INTERVAL 90 DAY) <= date(`clickdate`) and c.id =d.news_id GROUP BY news_id  ORDER BY count DESC  limit "+a+",5";
				}else{
					sql = "select COUNT(*) count,c.* from news c,statistics d where date_sub(curdate(), INTERVAL 90 DAY) <= date(`clickdate`) and c.id =d.news_id and d.news_type = "+selectClasses+" GROUP BY news_id  ORDER BY count DESC  limit "+a+",5";

				}		
		}
		return jdbcTemplate.queryForList(sql);
	}
}
