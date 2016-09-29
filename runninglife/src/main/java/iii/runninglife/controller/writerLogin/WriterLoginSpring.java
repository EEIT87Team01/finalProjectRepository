package iii.runninglife.controller.writerLogin;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import iii.runninglife.model.writer.WriterVO;

@Controller
@RequestMapping("/WriterLogin")
public class WriterLoginSpring {

	@Autowired
	WriterLoginService writerLoginService;
	
	//登入
	@RequestMapping("/WriterAccountCheck.do")
	public ModelAndView WriterAccountCheck(@RequestParam String writerAccount,@RequestParam String password,
			HttpServletRequest requst){
		
		Collection<String> errorMessage = new ArrayList<String>();
		Map<String ,Object> InfoMsg = new HashMap<String ,Object>();
		/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
		if("writerAccount" == null || writerAccount.trim().length() == 0){
			errorMessage.add("請輸入帳號");
		}
		
		if(password == null || password.trim().length() == 0){
			errorMessage.add("請輸入密碼");
		}	
		
		if (!errorMessage.isEmpty()) {
			return  new ModelAndView("writerLogin/show","errorMessage",errorMessage);
		}
		
		InfoMsg = writerLoginService.CheckPassword(writerAccount, password);
		if(((String)InfoMsg.get("Msg")).equals("登入成功")){
			String referer = requst.getHeader("Referer");
//			return new ModelAndView("redirect:"+ referer,"membersVO",loginService.insertMember(InfoMsg));
			return new ModelAndView("writerLogin/show","writerVO",writerLoginService.InsertWriter(InfoMsg));
		}else if(((String)InfoMsg.get("Msg")).equals("密碼錯誤")){
			errorMessage.add("密碼錯誤");
			return new ModelAndView("writerLogin/show","errorMessage",errorMessage);
		}else if(((String)InfoMsg.get("Msg")).equals("帳號不存在")){
			errorMessage.add("查無此帳號");
			return new ModelAndView("writerLogin/show","errorMessage",errorMessage);
		}else{
			errorMessage.add("登入失敗");
			return new ModelAndView("writerLogin/show","errorMessage",errorMessage);
		}
	}
	
	//登出
	@RequestMapping(value="/Logout.do" ,method=RequestMethod.GET)
	public ModelAndView Logout(@ModelAttribute("writerVO") WriterVO writerVO , HttpServletRequest requst,SessionStatus sessionStatus){
//		String referer = requst.getHeader("Referer");
		//清除session裡的東西
		sessionStatus.setComplete();
//		return new ModelAndView("redirect:"+ referer,"membersVO",membersVO);
		//回到登入頁面or首頁
		return new ModelAndView("writerLogin/writerLogin");
	}
	
//	//新增作家
//	@RequestMapping(value="/WriterCreateAccount.do" ,method=RequestMethod.POST, produces="text/plain;charset=UTF-8")
//	public ModelAndView writerCreateAccount(@RequestParam String writerAccount,@RequestParam String password,
//			@RequestParam String name,@RequestParam String email,@RequestParam String address,@RequestParam String status) 
//	throws IOException{
//		System.out.println(new String(name.getBytes("ISO-8859-1"),"UTF-8"));
//		name = Encoding.encodeStr(name);
//		
//		return new ModelAndView("writerLogin/show","writerVO"
//				,writerLoginService.createWriter(writerAccount,password,name, email,address,status));
//	}
	
}
