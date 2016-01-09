package cms.action;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cms.pojo.Content;
import cms.pojo.News_type;
import cms.service.ContentService;

@Controller
public class ContentAction {
	
	@Autowired
	private ContentService contentService;
	
	@RequestMapping(value="content.do")
	@ResponseBody
	public List<Map<String, Object>> qeuryPage(Integer pageNo){
		List<Map<String, Object>> list = contentService.queryPage(pageNo);
		Map<String,Object> map = new HashMap<String, Object>();
		List<Map<String, Object>> list1 = new ArrayList<Map<String,Object>>();
		map.put("data", list);
		int countAll = contentService.count();
		map.put("countAll", countAll);
		list1.add(map);
 		return list1;
	}
	
	@RequestMapping(value="queryContentJsp.do")
	public String queryContentJsp(Model model,Integer id){
		contentService.insertPP(id);
		return "queryContent";
	}
	
	@RequestMapping(value="queryContent.do")
	public String queryContent(Model model,Integer id){
		List<Map<String, Object>> list = contentService.queryContent(id);
		List<Map<String, Object>> list1 = contentService.queryComment(id);
		model.addAttribute("list",list);
		model.addAttribute("comment",list1);
		return "queryContent";
	}
	
	@RequestMapping(value="insertComment.do")
	@ResponseBody
	public int insertComment(Integer id,String comment,Integer user_id){
		int a = contentService.insertComment(id, comment,user_id);
		return a;
	}
	
	/* 评论内容 查 删 改  */
	@RequestMapping(value="/comment.do")
	public String managerAdmin(){
		
		return "backmanager/comment";
	}
	
	@RequestMapping(value="queryComment.do")
	@ResponseBody
	public List<Map<String, Object>> queryComment(Integer pageNo,String mUser){
		List<Map<String, Object>> list = contentService.queryCommentPage(pageNo,mUser);
		Map<String,Object> map = new HashMap<String, Object>();
		List<Map<String, Object>> list1 = new ArrayList<Map<String,Object>>();
		map.put("data", list);
		int countAll = contentService.queryComment(mUser);
		map.put("countAll", countAll);
		list1.add(map);
 		return list1;
	}
	
	@RequestMapping(value="/delComment.do")
	@ResponseBody
	public int delComment(Integer id){
		int a = contentService.delComment(id);
		return a;
	}
	/** 类型   */
	
	@RequestMapping(value="/news_type.do")
	public String news_type(){
		
		return "backmanager/news_type";
	}
	
	@RequestMapping(value="queryNews_type.do")
	@ResponseBody
	public List<Map<String, Object>> queryNews_type(Integer pageNo,String mUser){
		List<Map<String, Object>> list = contentService.queryNews_typePage(pageNo,mUser);
		Map<String,Object> map = new HashMap<String, Object>();
		List<Map<String, Object>> list1 = new ArrayList<Map<String,Object>>();
		map.put("data", list);
		int countAll = contentService.queryNews_type(mUser);
		map.put("countAll", countAll);
		list1.add(map);
 		return list1;
	}
	
	@RequestMapping(value="/addNews_typeA.do")
	public String addNews_typeA(){
		return "backmanager/addNews_type";
	}
	
	@RequestMapping(value="/addNews_type.do")
	@ResponseBody
	public int addAdmin(String news_type_name){
		int a = contentService.saveNews_type(news_type_name);
		return a;
	}
	
	@RequestMapping(value="/delNew_type.do")
	@ResponseBody
	public int delNew_type(Integer id){
		int a = contentService.delNew_type(id);
		return a;
	}
	
	@RequestMapping(value="/updateNws_type.do")
	public String  updateNws_type(Model model,Integer id){
		 List<Map<String, Object>> list = contentService.findNws_type(id);
		 model.addAttribute("list",list);
		 return "backmanager/updateNews_type";
	}
	@RequestMapping(value="/updateNws_typeA.do")
	@ResponseBody
	public int updateNws_typeA(News_type news_type){
		int a = contentService.updateNews_type(news_type);
		return a;
	}
	
	@RequestMapping(value="/contentManager.do")
	public String CountManager(){
		
		return "backmanager/content";
	}
	
	@RequestMapping(value="queryContentManagerPage.do")
	@ResponseBody
	public List<Map<String, Object>> queryContentManagerPage(Integer pageNo,String mUser){
		List<Map<String, Object>> list = contentService.queryContentManagerPage(pageNo,mUser);
		Map<String,Object> map = new HashMap<String, Object>();
		List<Map<String, Object>> list1 = new ArrayList<Map<String,Object>>();
		map.put("data", list);
		int countAll = contentService.queryContentManager(mUser);
		map.put("countAll", countAll);
		list1.add(map);
 		return list1;
	}
	
	@RequestMapping(value="/delContentManager.do")
	@ResponseBody
	public int delContentManager(Integer id){
		int a = contentService.delContentManager(id);
		return a;
	}
	
	@RequestMapping(value="/updateContentManagerA.do")
	public String  updateContentManagerA(Model model,Integer id){
		 List<Map<String, Object>> list = contentService.findContentManager(id);
		 model.addAttribute("list",list);
		 return "backmanager/updateContentManager";
	}
	
	@RequestMapping(value="/updateContentManager.do")
	public String updateContentManagerA(@RequestParam("textFile") MultipartFile textFile,HttpServletRequest request,Model model,Content content){
		System.out.println("开始");  
        String path = request.getSession().getServletContext().getRealPath("upload");  
        String fileName = textFile.getOriginalFilename();  
        System.out.println(path);  
        File targetFile = new File(path, fileName);  
        if(!targetFile.exists()){  
            targetFile.mkdirs();  
        }  
        //保存  
        try {  
        	textFile.transferTo(targetFile);  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        content.setImage(fileName);
        model.addAttribute("fileUrl", request.getContextPath()+"/upload/"+fileName);
		int a = contentService.updateContentManagerA(content);
		return "backmanager/content";
	}
	
	@RequestMapping(value="/statistics.do")
	public String statistics(Model model){
		 List<Map<String, Object>> list = contentService.addContentA();
		 model.addAttribute("list",list);
		return "backmanager/statistics";
	}
	
	@RequestMapping(value="/addContentA.do")
	public String  addContentA(Model model){
		 List<Map<String, Object>> list = contentService.addContentA();
		 model.addAttribute("list",list);
		 return "backmanager/addContent";
	}
	
	@RequestMapping(value="/addContentB.do")
	public String addContentB(@RequestParam("textFile") MultipartFile textFile,HttpServletRequest request,Model model,Content news){
		System.out.println("开始");  
        String path = request.getSession().getServletContext().getRealPath("upload");  
        String fileName = textFile.getOriginalFilename();  
        System.out.println(path);  
        File targetFile = new File(path, fileName);  
        if(!targetFile.exists()){  
            targetFile.mkdirs();  
        }  
        //保存  
        try {  
        	textFile.transferTo(targetFile);  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        news.setImage(fileName);
        model.addAttribute("fileUrl", request.getContextPath()+"/upload/"+fileName);  
		int a = contentService.addContentB(news);
		return "backmanager/addContent";
	}
	
	@RequestMapping(value="querySelectAll.do")
	@ResponseBody
	public List<Map<String, Object>> querySelectAll(Integer pageNo,String selectAll,String selectClasses){
		List<Map<String, Object>> list = contentService.querySelectAll(pageNo,selectAll,selectClasses);
		Map<String,Object> map = new HashMap<String, Object>();
		List<Map<String, Object>> list1 = new ArrayList<Map<String,Object>>();
		map.put("data", list);
		int countAll = contentService.querySelectAll(selectAll,selectClasses);
		map.put("countAll", countAll);
		list1.add(map);
 		return list1;
	}
}
