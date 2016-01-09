package cms.service;

import java.util.List;
import java.util.Map;

import cms.pojo.Content;
import cms.pojo.News_type;
import cms.pojo.User;

public interface ContentService {
	
	/**
	 * 分页查询
	 * @param pageNo
	 * @return
	 */
	List<Map<String, Object>> queryPage(Integer pageNo);
	
	/**
	 * 根据ID 查看新闻内容
	 * @param id
	 * @return
	 */
	public List<Map<String, Object>> queryContent(Integer id);
	
	/**
	 *  浏览新闻 内容根据ID 增1
	 * @param id
	 */
	public void insertPP(Integer id);
	
	/**
	 * 查看详细时列出评论
	 * @param id
	 * @return
	 */
	List<Map<String, Object>> queryComment(Integer id);
	
	/**
	 * 插入一条评论
	 * @param id 新闻ID
	 * @param comment 评论内容
	 * @param user_id 
	 * @return
	 */
	int insertComment(Integer id, String comment, Integer user_id);
	
	/**
	 * 分页时查询总数量
	 * @return
	 */
	int count();

	/**
	 * 新闻评论的数量
	 * @return
	 */
	int queryComment(String mUser);

	/**
	 * 查询评论分页
	 * @param pageNo
	 * @return
	 */
	List<Map<String, Object>> queryCommentPage(Integer pageNo, String mUser);
	
	/**
	 * 删除评论
	 * @param id
	 * @return
	 */
	int delComment(Integer id);

	/**
	 * 新闻类型数量
	 * @return
	 */
	int queryNews_type(String mUser);

	/**
	 * 新闻类型分页
	 * @param mUser 
	 * @return
	 */
	List<Map<String, Object>> queryNews_typePage(Integer pageNo, String mUser);

	/**
	 * 增加新闻类型
	 * @param news_type_name
	 * @return
	 */
	int saveNews_type(String news_type_name);
	
	/**
	 * 删除新闻类型
	 * @param id
	 * @return
	 */
	int delNew_type(Integer id);

	/**
	 * 修改新闻类型时查询一个
	 * @param id
	 * @return
	 */
	List<Map<String, Object>> findNws_type(Integer id);

	/**
	 * 修改新闻类型
	 * @param user
	 * @return
	 */
	int updateNews_type(News_type News_type);
	
	/**
	 * 新闻内容 分页
	 * @param pageNo
	 * @param mUser
	 * @return
	 */
	List<Map<String, Object>> queryContentManagerPage(Integer pageNo, String mUser);

	/**
	 * 新闻内容数量
	 * @param mUser
	 * @return
	 */
	int queryContentManager(String mUser);

	/**
	 * 删除新闻
	 * @param id
	 * @return
	 */
	int delContentManager(Integer id);

	/**
	 * 修改新闻时查找
	 * @param id
	 * @return
	 */
	List<Map<String, Object>> findContentManager(Integer id);

	/**
	 * 修改新闻
	 * @param news_type
	 * @return
	 */
	int updateContentManagerA(Content content);

	/**
	 * 添加新闻时查询新闻类型
	 * @return
	 */
	List<Map<String, Object>> addContentA();

	/**
	 * 添加新闻
	 * @param news
	 * @return
	 */
	int addContentB(Content news);
	
	/**
	 * 统计模块查询时候 查询数量
	 * @param selectAll
	 * @return
	 */
	int querySelectAll(String selectAll, String selectClasses);

	/**
	 * 统计模块查询时分页查询
	 * @param selectAll
	 * @return
	 */
	List<Map<String, Object>> querySelectAll(Integer pageNo, String selectAll, String selectClasses);
	 
}


