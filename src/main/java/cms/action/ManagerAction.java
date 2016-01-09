package cms.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cms.pojo.User;
import cms.service.ManagerService;
import cms.service.UserService;

@Controller
public class ManagerAction {

	@Autowired
	private ManagerService managerService;
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/manager.do")
	public String login(){
		
		return "backmanager/login";
	}
	
	@RequestMapping(value="/queryUser.do")
	@ResponseBody
	public List<Map<String,Object>> queryPage(Integer pageNo,Integer type,String mUser){
		List<Map<String,Object>> list = userService.queryPage(pageNo,type,mUser);
		Map<String,Object> map = new HashMap<String, Object>();
		List<Map<String, Object>> list1 = new ArrayList<Map<String,Object>>();
		map.put("data", list);
		int countAll = userService.count(mUser);
		map.put("countAll", countAll);
		list1.add(map);
 		return list1;
	}
	
	@RequestMapping(value="/delUser.do")
	@ResponseBody
	public int delUser(Integer id){
		int a = userService.delUser(id);
		return a;
	}
	
	@RequestMapping(value="/updateUser.do")
	public String  updateUser(Model model,Integer id){
		 List<Map<String, Object>> list = userService.findUser(id);
		 model.addAttribute("list",list);
		 return "backmanager/updateUser";
	}
	@RequestMapping(value="/updateUserU.do")
	@ResponseBody
	public int updateUserU(User user){
		int a = userService.updateUser(user);
		return a;
	}
	
	@RequestMapping(value="/managerAdmin.do")
	public String managerAdmin(){
		
		return "backmanager/manager";
	}
	
	@RequestMapping(value="/queryAdmin.do")
	@ResponseBody
	public List<Map<String,Object>> queryPageAdmin(Integer pageNo,Integer type,String mUser){
		List<Map<String,Object>> list = managerService.queryPage(pageNo,type,mUser);
		Map<String,Object> map = new HashMap<String, Object>();
		List<Map<String, Object>> list1 = new ArrayList<Map<String,Object>>();
		map.put("data", list);
		int countAll = managerService.count(mUser);
		map.put("countAll", countAll);
		list1.add(map);
 		return list1;
	}
	
	@RequestMapping(value="/delAdmin.do")
	@ResponseBody
	public int delAdmin(Integer id){
		int a = managerService.delAdmin(id);
		return a;
	}
	
	@RequestMapping(value="/updateAdmin.do")
	public String  updateAdmin(Model model,Integer id){
		 List<Map<String, Object>> list = managerService.findAdmin(id);
		 model.addAttribute("list",list);
		 return "backmanager/updateAdmin";
	}
	@RequestMapping(value="/updateAdminA.do")
	@ResponseBody
	public int updateAdminA(User user){
		int a = managerService.updateAdmin(user);
		return a;
	}
	
	@RequestMapping(value="/addUserA.do")
	public String addUserA(){
		return "backmanager/addUser";
	}
	
	@RequestMapping(value="/addUser.do")
	@ResponseBody
	public int addUser(User user){
		int a = userService.save(user);
		return a;
	}
	
	@RequestMapping(value="/addAdminA.do")
	public String addAdminA(){
		return "backmanager/addAdmin";
	}
	
	@RequestMapping(value="/addAdmin.do")
	@ResponseBody
	public int addAdmin(User user){
		int a = managerService.save(user);
		return a;
	}
	
}
