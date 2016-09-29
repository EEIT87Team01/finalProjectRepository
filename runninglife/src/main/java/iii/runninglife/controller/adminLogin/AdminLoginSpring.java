package iii.runninglife.controller.adminLogin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.RequestWrapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import iii.runninglife.controller.writerLogin.WriterLoginService;
import iii.runninglife.globalservice.GlobalService;
import iii.runninglife.model.admins.AdminsVO;

@Controller
@RequestMapping("/AdminLogin")
public class AdminLoginSpring {

	@Autowired
	AdminLoginService adminLoginService;
	@Autowired
	WriterLoginService writerLoginService;
	@Autowired
	GlobalService globalservice;
	
	@RequestMapping("/AdminPageChange.do")
	public ModelAndView AdminPageChange(){
		return new ModelAndView("adminLogin/adminLogin");
	}
	
	//登入
	@RequestMapping("/AdminAccountCheck.do")
	public ModelAndView AdminAccountCheck(@RequestParam String adminAccount,@RequestParam String password,
			HttpServletRequest requst){
		
		Collection<String> errorMessage = new ArrayList<String>();
		Map<String ,Object> InfoMsg = new HashMap<String ,Object>();
		/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
		if("adminAccount" == null || adminAccount.trim().length() == 0){
			errorMessage.add("請輸入帳號");
		}
		
		if(password == null || password.trim().length() == 0){
			errorMessage.add("請輸入密碼");
		}	
		
		if (!errorMessage.isEmpty()) {
			return  new ModelAndView("adminLogin/show","errorMessage",errorMessage);
		}
		
		InfoMsg = adminLoginService.CheckPassword(adminAccount, password);
		if(((String)InfoMsg.get("Msg")).equals("登入成功")){
			String referer = requst.getHeader("Referer");
//			return new ModelAndView("redirect:"+ referer,"membersVO",loginService.insertMember(InfoMsg));
			return new ModelAndView("adminLogin/show","adminsVO",adminLoginService.InsertAdmin(InfoMsg));
		}else if(((String)InfoMsg.get("Msg")).equals("密碼錯誤")){
			errorMessage.add("密碼錯誤");
			return new ModelAndView("adminLogin/show","errorMessage",errorMessage);
		}else if(((String)InfoMsg.get("Msg")).equals("帳號不存在")){
			errorMessage.add("查無此帳號");
			return new ModelAndView("adminLogin/show","errorMessage",errorMessage);
		}else{
			errorMessage.add("登入失敗");
			return new ModelAndView("adminLogin/show","errorMessage",errorMessage);
		}
	}
	
	//登出
	@RequestMapping(value="/Logout.do" ,method=RequestMethod.GET)
	public ModelAndView Logout(@ModelAttribute("adminsVO") AdminsVO adminsVO , HttpServletRequest requst,SessionStatus sessionStatus){
//		String referer = requst.getHeader("Referer");
		//清除session裡的東西
		sessionStatus.setComplete();
//		return new ModelAndView("redirect:"+ referer,"membersVO",membersVO);
		//回到登入頁面or首頁
		return new ModelAndView("adminLogin/adminLogin");
	}
	
	@RequestMapping("/CreateAdminPage.do")
	public ModelAndView CreateAdminPage(){
		return new ModelAndView("adminLogin/adminCreateAccount");
	}
	
	//新增管理者
	@RequestMapping(value="/CreateAccount.do" ,method=RequestMethod.POST, produces="text/plain;charset=UTF-8")
	public ModelAndView CreateAccount(@RequestParam String adminAccount,@RequestParam String password,
			@RequestParam String name,@RequestParam String levelID,@RequestParam String status) 
	throws IOException{
		System.out.println(new String(name.getBytes("ISO-8859-1"),"UTF-8"));
		name = globalservice.encodeStr(name);
		
		return new ModelAndView("adminLogin/show","adminsVO"
				,adminLoginService.createAdmin(adminAccount,password,name, levelID,status));
	}
	
	@RequestMapping(value="/MemberUpdate.do",method=RequestMethod.POST)
	public ModelAndView MemberUpdate(@RequestParam String memberID){
		adminLoginService.MemberUpdate(memberID);
		//回傳至建偉的檢舉頁面 MemberUpdate
		return new ModelAndView("");
	}
	
	@RequestMapping(value="/MemberSelect.do",method=RequestMethod.POST)
	public ModelAndView MemberSelectOne(@RequestParam String memberID){
		adminLoginService.MemberSelectOne(memberID);
		//回傳至建偉的檢舉頁面 MemberSelectOne
		return new ModelAndView("");
	}
	
}
