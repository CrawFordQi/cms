package cms.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cms.dao.ContentDao;
import cms.pojo.Content;
import cms.pojo.News_type;
import cms.pojo.User;

@Service
public class ContentServiceImpl implements ContentService {

	@Autowired
	private ContentDao contentDao;
	public List<Map<String, Object>> queryPage(Integer pageNo) {
		if (pageNo == null || "".equals(pageNo) || pageNo == 0) {
			pageNo = 1;
		}
 		return contentDao.queryPage(pageNo);
	}
	
	public List<Map<String, Object>> queryContent(Integer id) {
		
		return contentDao.queryContent(id);
	}

	public void insertPP(Integer id) {
		
		contentDao.insertPP(id);
	}

	public List<Map<String, Object>> queryComment(Integer id) {
		
		return contentDao.queryComment(id);
	}

	public int insertComment(Integer id, String comment,Integer user_id) {
		
		return contentDao.insertComment(id, comment, user_id);
	}

	public int count() {
		
		return contentDao.count();
	}

	public int queryComment(String mUser) {
		
		return contentDao.queryComment(mUser);
	}

	public List<Map<String, Object>> queryCommentPage(Integer pageNo,String mUser) {
		if (pageNo == null || "".equals(pageNo)) {
			pageNo = 1;
		}
		return contentDao.queryCommentPage(pageNo,mUser);
	}

	public int delComment(Integer id) {
		
		return contentDao.delComment(id);
	}

	public List<Map<String, Object>> queryNews_typePage(Integer pageNo,String mUser) {
		
		return contentDao.queryNews_typePage(pageNo,mUser);
	}

	public int queryNews_type(String mUser) {
		
		return contentDao.queryNews_type(mUser);
	}

	public int saveNews_type(String news_type) {
		
		return contentDao.saveNews_type(news_type);
	}

	public int delNew_type(Integer id) {
		return contentDao.delNew_type(id);
	}

	public List<Map<String, Object>> findNws_type(Integer id) {
		
		return contentDao.findNws_type(id);
	}

	public int updateNews_type(News_type news_type) {
		
		return contentDao.updateNews_type(news_type);
	}

	public List<Map<String, Object>> queryContentManagerPage(Integer pageNo, String mUser) {
		 
		return contentDao.queryContentManagerPage(pageNo,mUser);
	}

	public int queryContentManager(String mUser) {
		
		return contentDao.queryContentManager(mUser);
	}

	public int delContentManager(Integer id) {
		
		return contentDao.delContentManager(id);
	}

	public List<Map<String, Object>> findContentManager(Integer id) {
		
		return contentDao.findContentManager(id);
	}

	public int updateContentManagerA(Content content) {
		
		return contentDao.updateContentManagerA(content);
	}

	public List<Map<String, Object>> addContentA() {
		
		return contentDao.addContentA();
	}

	public int addContentB(Content news) {
		
		return contentDao.addContentB(news);
	}

	public int querySelectAll(String selectAll,String selectClasses) {
		
		return contentDao.querySelectAll(selectAll,selectClasses);
	}

	public List<Map<String, Object>> querySelectAll(Integer pageNo, String selectAll,String selectClasses) {
		
		return contentDao.querySelectAll(pageNo,selectAll,selectClasses);
	}

}
