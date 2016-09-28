package iii.runninglife.controller.loginController;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

import iii.runninglife.globalservice.GlobalService;
import iii.runninglife.model.city.CityVO;
import iii.runninglife.model.country.CountryVO;
import iii.runninglife.model.emergencyRelation.EmergencyRelationVO;
import iii.runninglife.model.location.LocationVO;
import iii.runninglife.model.loginInformation.LoginInformationInterface;
import iii.runninglife.model.loginInformation.LoginInformationPK;
import iii.runninglife.model.members.MembersVO;

@RestController
@RequestMapping("/Login")
@SessionAttributes("membersVO")
public class LoginSpring {
	@Autowired
	LoginService loginService;
	@Autowired
	GlobalService globalservice;
	
	
	//登入驗證
	@RequestMapping(value="/LoginCheck" ,method=RequestMethod.POST,produces="application/json")
	public @ResponseBody Map<String ,String> LoginCheck(@RequestParam String memberAccount, @RequestParam String password){
		Map<String ,String> errorMessage = new HashMap<String ,String>();
		Map<String ,Object> InfoMsg = new HashMap<String ,Object>();
		
		System.out.println("logincheck");
		System.out.println(password);
		/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
		if (memberAccount == null || memberAccount.trim().length() == 0){ 
			errorMessage.put("errorMessage","NoAccount"); 
			}else if (password == null || password.trim().length() == 0){ 
				errorMessage.put("errorMessage","NoPassword"); 
				}
		
		if (!errorMessage.isEmpty()) { return  errorMessage; }

		InfoMsg = loginService.CheckPassword(memberAccount, password);
		
		/***************************3.查詢完成,準備轉交(Send the Success view)*************/
		if(((String)InfoMsg.get("Msg")).equals("LoginOK")) { errorMessage.put("errorMessage","LoginOK"); }
		else if(((String)InfoMsg.get("Msg")).equals("WrongPassword")) { errorMessage.put("errorMessage","WrongPassword"); }
		else if(((String)InfoMsg.get("Msg")).equals("NotExistAccount")) { errorMessage.put("errorMessage","NotExistAccount"); }
		else { errorMessage.put("errorMessage","LoginFail"); }
			
		return  errorMessage;
	}

	//登入驗證帳號密碼
	@RequestMapping(value="/DBCheck" ,method=RequestMethod.POST)
	public ModelAndView LoginDBCheck(@RequestParam String memberAccount, @RequestParam String password){
		return new ModelAndView("redirect:/","membersVO",loginService.findByPrimaryKey(new LoginInformationPK(memberAccount, "1")).getMemberID());
	}
	
	//登入驗證帳號密碼
	@RequestMapping(value="/DBCheckForApp" ,method=RequestMethod.POST, produces="application/json")
	public Map<String,String> LoginDBCheckForApp(@RequestParam String memberAccount, @RequestParam String password){
		Map<String,String> map = new HashMap<>();
		map.put("memberID", loginService.findByPrimaryKey(new LoginInformationPK(memberAccount, "1")).getMemberID().getMemberID());
		return map;
	}
	
	//登出
	@RequestMapping(value="/Logout" ,method=RequestMethod.GET)
	public ModelAndView Logout(@ModelAttribute("membersVO") MembersVO membersVO , HttpServletRequest requst,SessionStatus sessionStatus){
		sessionStatus.setComplete();
		return new ModelAndView("redirect:/");
	}
	
	//-----------------------------------------------------------------------------------
	//忘記密碼換頁(Spring)
	@RequestMapping(value="/ChangeForgetPage")
	public ModelAndView ChangeForgetPage(){
		return new ModelAndView("login/forgetPaswd");
	}
	
	//忘記密碼帳號確認
	@RequestMapping(value="/CheckAccount" ,method=RequestMethod.POST)
	public ModelAndView ForgetPaswd(@RequestParam String memberAccount, @RequestParam String memberEmail){
		Collection<String> errorMessage = new ArrayList<String>();
		
		if("memberAccount" == null || memberAccount.trim().length() == 0){ errorMessage.add("請輸入帳號"); }
		if("memberEmail" == null || memberEmail.trim().length() == 0){ errorMessage.add("請輸入Email"); }	
		if (!errorMessage.isEmpty()) { return  new ModelAndView("login/show","errorMessage",errorMessage); }
		
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
		
		}
	}
	
	//確認驗證碼
	@RequestMapping(value="/CheckVerification" ,method=RequestMethod.POST)
	public ModelAndView CheckVerification(@RequestParam String memberAccount,@RequestParam String status){
		Collection<String> errorMessage = new ArrayList<String>();
		Map<String ,Object> InfoMsg = new HashMap<String ,Object>();
		if("status" == null || status.trim().length() == 0){ errorMessage.add("請輸驗證碼"); }
		
		if (!errorMessage.isEmpty()) { return  new ModelAndView("login/show","errorMessage",errorMessage); }
		
		InfoMsg = loginService.CheckVerification(memberAccount, status);
		if(((String)InfoMsg.get("status")).equals("login_OK")){ return  new ModelAndView("login/changePaswd","memberAccount",memberAccount); }
		else{
			errorMessage.add("驗證失敗");
			return  new ModelAndView("login/show","errorMessage",errorMessage);
		}
	}
	
	//變更密碼
	@RequestMapping(value="/ChangePassword" ,method=RequestMethod.POST)
	public ModelAndView changePassword(@RequestParam String memberAccount,@RequestParam String password){
		return new ModelAndView("redirect:/");
	}
	
	
	//-----------------------------------------------------------------------------------
	//新增會員換頁(Spring)
	@RequestMapping(value="/CreateAccountPage")
	public ModelAndView CreateAccountPage(){
		return new ModelAndView("login/createAccount");
	}
	
	//新增會員
	@RequestMapping(value="/CreateAccount" ,method=RequestMethod.POST, produces="text/plain;charset=UTF-8")
	public ModelAndView CreateAccount(@RequestParam String memberAccount,@RequestParam String password,
			@RequestParam String firstName,@RequestParam String lastName,@RequestParam String email,
			@RequestParam String gender,@RequestParam String phone,@RequestParam String birthday,HttpServletRequest req) 
	throws IOException, ServletException{
		
		byte[] photo = null;
		
		List<Part> fileParts = req.getParts().stream().filter(part -> "file1".equals(part.getName())).collect(Collectors.toList()); 
		for (Part filePart : fileParts) { 
		InputStream is = filePart.getInputStream(); 
		photo = IOUtils.toByteArray(is); 
		} 
		
		return new ModelAndView("redirect:/","membersVO"
				,loginService.CreateMember(memberAccount,password,firstName,lastName,phone,email,gender,birthday,photo));
	}
	
	
	
	//修改會員資料換頁(Spring)
	@RequestMapping(value="/UpdateAccountPage")
	public ModelAndView UpdateAccountPage(@ModelAttribute MembersVO membersVO, Model model){
		model.addAttribute("memberForm", new MembersVO());
		return new ModelAndView("login/updateAccount","membersVO",membersVO);
	}
	
	//修改會員
	@RequestMapping(value="/UpdateAccount" ,method=RequestMethod.POST)
	public ModelAndView UpdateAccount(@ModelAttribute("memberForm") MembersVO memberForm) {
		MembersVO membersVO = loginService.updateMember(memberForm);
		return new ModelAndView("login/show","membersVO",membersVO);
	}
	
	@RequestMapping(value="/Country", method = RequestMethod.GET,produces="application/json")
	public @ResponseBody List<CountryVO> getCountry(){
		return loginService.Country();
	}
	
	@RequestMapping(value="/City", method = RequestMethod.POST,produces="application/json")
	public @ResponseBody List<CityVO> getCity(@RequestParam String countryID){
		return loginService.city(countryID);
	}
	
	@RequestMapping(value="/Location", method = RequestMethod.POST,produces="application/json")
	public @ResponseBody List<LocationVO> getLocation(@RequestParam String cityID){
		return loginService.location(cityID);
	}
	
	@RequestMapping(value="/EmergencyRelation.do", method = RequestMethod.GET,produces="application/json")
	public @ResponseBody List<EmergencyRelationVO> getEmergencyRelation(){
		return loginService.EmergencyRelation();
	}
	
	//Client驗證----------------------------------------------------------------------
	@RequestMapping(value="/AccountCheck.do", method = RequestMethod.POST,produces="application/json")
	public @ResponseBody String getAccountCheck(@RequestParam String memberAccount){
		System.out.println("star");
		System.out.println(loginService.AccountCheck(memberAccount));
		String result = null;
		Gson gson = new Gson();
		result = gson.toJson(loginService.AccountCheck(memberAccount));
		return result;
	}
	
}
