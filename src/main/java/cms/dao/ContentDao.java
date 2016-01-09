package cms.dao;

import java.util.List;
import java.util.Map;

import cms.pojo.Content;
import cms.pojo.News_type;

public interface ContentDao {

	List<Map<String, Object>> queryPage(Integer pageNo);
	
	List<Map<String, Object>> queryContent(Integer id);
	
	void insertPP(Integer id);
	
	List<Map<String, Object>> queryComment(Integer id);
	
	int insertComment(Integer id, String comment, Integer user_id);
	
	int count();

	int queryComment(String mUser);

	List<Map<String, Object>> queryCommentPage(Integer pageNo, String mUser);

	int delComment(Integer id);

	List<Map<String, Object>> queryNews_typePage(Integer pageNo, String mUser);

	int queryNews_type(String mUser);

	int saveNews_type(String news_type);

	int delNew_type(Integer id);

	List<Map<String, Object>> findNws_type(Integer id);

	int updateNews_type(News_type news_type);

	List<Map<String, Object>> queryContentManagerPage(Integer pageNo, String mUser);

	int queryContentManager(String mUser);

	int delContentManager(Integer id);

	List<Map<String, Object>> findContentManager(Integer id);

	int updateContentManagerA(Content content);

	List<Map<String, Object>> addContentA();

	int addContentB(Content news);

	int querySelectAll(String selectAll, String selectClasses);

	List<Map<String, Object>> querySelectAll(Integer pageNo, String selectAll, String selectClasses);
}
