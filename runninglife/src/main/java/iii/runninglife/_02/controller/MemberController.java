package iii.runninglife._02.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import iii.runninglife._02.model.members.MembersService_interface;
import iii.runninglife._02.model.members.MembersVO;

@Controller
@RequestMapping("/member")
@SessionAttributes("member")
public class MemberController {
	
	@Autowired
	MembersService_interface memberService;
	
	//登入(偽)
	@RequestMapping(value = {"/login"}, method = RequestMethod.POST)
	public ModelAndView login(@RequestParam String account, @RequestParam String password, HttpServletRequest request){
		MembersVO mvo = memberService.findByAccount(account);
		String referer = request.getHeader("Referer");
		if (mvo.getPassword().equals(password)) return new ModelAndView("redirect:" + referer, "member", mvo);
		else return new ModelAndView("LoginError");
	}
	
	//登出(偽)
	@RequestMapping(value = {"/logout"}, method = RequestMethod.GET)
	public ModelAndView logout(@ModelAttribute("member") MembersVO member, HttpServletRequest request, SessionStatus status){
		status.setComplete();
		return new ModelAndView("redirect:/index_test.jsp");
	}
	
	
}
