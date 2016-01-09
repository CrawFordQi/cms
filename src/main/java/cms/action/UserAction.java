package cms.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import cms.until.EncryptUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cms.pojo.User;
import cms.service.UserService;

@Controller
public class UserAction {

	@Autowired
	private UserService userService;

	@RequestMapping(value="/count.do")
	public String count(Model model){
		model.addAttribute("usercount",userService.count());
		return "index";
	}

	/**
	 * 进入登录页
	 * @return
	 */
	@RequestMapping(value="/login.do")
	public String login(){

		return "login";
	}

	/**
	 * 登录检测
	 * @return
	 */
	@RequestMapping(value="/loginCkeck.do")
	@ResponseBody
	public List<Map<String,Object>> loginCkeck(User user,HttpSession httpSession){
		//	int a = userService.find(user);
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), EncryptUtils.encryptMD5(user.getPassword()));
		token.setRememberMe(true);
		try {
			subject.login(token);
		} catch (UnknownAccountException e){
			System.out.println();
			e.printStackTrace();

		}
		if (subject.hasRole("admin")){
			System.out.println("啊啊啊 ");
		}else{
			System.out.println("哦哦哦 ");
		}
		List<Map<String,Object>> list = userService.findSession(user);
		httpSession.setAttribute("session", list);
		return list;
	}

	@RequestMapping(value="/loginOut.do")
	public String loginOut(){
		Subject subject = SecurityUtils.getSubject();
		subject.logout();
		return "login";
	}

	@RequestMapping(value="/sign.do")
	public String regisered(){

		return "registered";
	}

	@RequestMapping(value="/registered.do")
	@ResponseBody
	public int save(User user){

		return userService.save(user);
	}

	@RequestMapping(value="/queryPage.do")
	public String queryPage(Model model,Integer pageNo,Integer type,String mUser){
		List<Map<String,Object>> list = userService.queryPage(pageNo,type,mUser);
		model.addAttribute("list",list);
		return "login";
	}
//	public String count(Model model){
//		model.addAttribute("usercount",userService.count());
//		return "/index";
//	}

}
