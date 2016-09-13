package _01.controller.loginController;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.invoke.MethodType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.stat.SessionStatistics;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import _01.globalserveice.Encoding;
import _01.model.loginInformation.LoginInformationVO;
import _01.model.members.MembersVO;

@Controller
@RequestMapping("/Login")
@SessionAttributes("membersVO")
public class LoginSpring {
	
	LoginService loginService = new LoginService();
	//登入驗證
	@RequestMapping(value="/DBCheck" ,method=RequestMethod.POST)
	public ModelAndView LoginDBCheck(@RequestParam String memberAccount, @RequestParam String password,
			HttpServletRequest requst){
		
		Collection<String> errorMessage = new ArrayList<String>();
		Map<String ,Object> InfoMsg = new HashMap<String ,Object>();

		/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
		if("memberAccount" == null || memberAccount.trim().length() == 0){
			errorMessage.add("請輸入帳號");
		}
		
		if(password == null || password.trim().length() == 0){
			errorMessage.add("請輸入密碼");
		}	
		
		if (!errorMessage.isEmpty()) {
			return  new ModelAndView("login/show","errorMessage",errorMessage);
		}

		InfoMsg = loginService.checkPassword(memberAccount, password);
		/***************************3.查詢完成,準備轉交(Send the Success view)*************/
		if(((String)InfoMsg.get("Msg")).equals("登入成功")){
			String referer = requst.getHeader("Referer");
//			return new ModelAndView("redirect:"+ referer,"membersVO",loginService.insertMember(InfoMsg));
			return new ModelAndView("login/show","membersVO",loginService.insertMember(InfoMsg));
		}else if(((String)InfoMsg.get("Msg")).equals("密碼錯誤")){
			errorMessage.add("密碼錯誤");
			return new ModelAndView("login/show","errorMessage",errorMessage);
		}else if(((String)InfoMsg.get("Msg")).equals("帳號不存在")){
			errorMessage.add("查無此帳號");
			return new ModelAndView("login/show","errorMessage",errorMessage);
		}else{
			errorMessage.add("登入失敗");
			return new ModelAndView("login/show","errorMessage",errorMessage);
		}
	}
	
	//登出
	
	//設定HttpServletRequest requst,SessionStatus sessionStatus
	//放入Session裡的值:@ModelAttribute("membersVO") MembersVO membersVO
	//String referer = requst.getHeader("Referer");
	@RequestMapping(value="/Logout" ,method=RequestMethod.GET)
	public ModelAndView Logout(@ModelAttribute("membersVO") MembersVO membersVO , HttpServletRequest requst,SessionStatus sessionStatus){
//		String referer = requst.getHeader("Referer");
		//清除session裡的東西
		sessionStatus.setComplete();
//		return new ModelAndView("redirect:"+ referer,"membersVO",membersVO);
		//回到登入頁面or首頁
		return new ModelAndView("login/login");
	}
	
	//忘記密碼帳號確認
	@RequestMapping(value="/CheckAccount" ,method=RequestMethod.POST)
	public ModelAndView ForgetPaswd(@RequestParam String memberAccount, @RequestParam String memberEmail){
		Collection<String> errorMessage = new ArrayList<String>();
		Map<String ,Object> InfoMsg = new HashMap<String ,Object>();
		
		if("memberAccount" == null || memberAccount.trim().length() == 0){
			errorMessage.add("請輸入帳號");
		}
		
		if("memberEmail" == null || memberEmail.trim().length() == 0){
			errorMessage.add("請輸入Email");
		}	
		
		if (!errorMessage.isEmpty()) {
			return  new ModelAndView("login/show","errorMessage",errorMessage);
		}
		
		String returnMsg = loginService.ForgetPaswd(memberAccount, memberEmail);
		//帳號驗證
		if(returnMsg.equals("無此帳號")){
			errorMessage.add("無此帳號");
			return  new ModelAndView("login/show","errorMessage",errorMessage);
		}else{
			//co兆良的Email發送程式

			//跳到驗證碼頁面
			return  new ModelAndView("login/verification");
			//跳到更換密碼頁面
//			int loginSataus = (int)(Math.random() *100);
//			System.out.println(loginSataus);
//			String returnStatus = loginService.CheckVerification(memberAccount, Integer.toString(loginSataus));
		
		}
	}
	
	//確認驗證碼
	@RequestMapping(value="/CheckVerification" ,method=RequestMethod.POST)
	public ModelAndView CheckVerification(@RequestParam String memberAccount,@RequestParam String status){
		Collection<String> errorMessage = new ArrayList<String>();
		Map<String ,Object> InfoMsg = new HashMap<String ,Object>();
		if("status" == null || status.trim().length() == 0){
			errorMessage.add("請輸驗證碼");
		}
		
		if (!errorMessage.isEmpty()) {
			return  new ModelAndView("login/show","errorMessage",errorMessage);
		}
		
		InfoMsg = loginService.CheckVerification(memberAccount, status);
		if(((String)InfoMsg.get("status")).equals("login_OK")){
			
//			return  new ModelAndView("login/show","membersVO",loginService.insertMember(InfoMsg));
			return  new ModelAndView("login/changePaswd","memberAccount",memberAccount);
		}else{
			errorMessage.add("驗證失敗");
			return  new ModelAndView("login/show","errorMessage",errorMessage);
		}
	}
	
	//確認帳號
	@RequestMapping(value="/ChangePassword" ,method=RequestMethod.POST)
	public ModelAndView changePassword(@RequestParam String memberAccount,@RequestParam String password){
		return new ModelAndView("login/show","membersVO",loginService.changePaswd(memberAccount,password));
	}
	
	@RequestMapping(value="/CreateAccount" ,method=RequestMethod.POST, produces="text/plain;charset=UTF-8")
	public ModelAndView createAccount(@RequestParam String memberAccount,@RequestParam String password,
			@RequestParam String firstName,@RequestParam String lastName,@RequestParam String nickname,
			@RequestParam String gender,@RequestParam String email,@RequestParam String birthday,
			@RequestParam String location,@RequestParam String address,@RequestParam String identityID) 
	throws IOException{
		System.out.println(new String(firstName.getBytes("ISO-8859-1"),"UTF-8"));
		firstName = Encoding.encodeStr(firstName);
		lastName = Encoding.encodeStr(lastName);
		nickname = Encoding.encodeStr(nickname);
		location = Encoding.encodeStr(location);
		address = Encoding.encodeStr(address);
		
		return new ModelAndView("login/show","membersVO"
				,loginService.createMember(memberAccount,password,firstName, lastName,
											nickname, gender, email, birthday, location, address, identityID));
	}
	
}
