package _02.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import _02.model.friendRequest.FriendRequestPK;
import _02.model.friendRequest.FriendRequestService_interface;
import _02.model.members.MembersService_interface;
import _02.model.members.MembersVO;

@Controller
@RequestMapping("/member")
public class MemberController {
	@Autowired
	MembersService_interface memberService;
	
	@Autowired
	FriendRequestService_interface friendRequestService;
	
	@RequestMapping(value = {"/list","/"}, method = RequestMethod.GET)
	public String listMembers(ModelMap model){
		List<MembersVO> mvos = memberService.getAll();
		model.addAttribute("members", mvos);
		return "test";
	}
	
	@RequestMapping(value = {"/listjson"}, produces = "application/json")
	public @ResponseBody List<MembersVO> listJSONMembers(ModelMap model){
		List<MembersVO> mvos = memberService.getAll();
		return mvos;
	}
	
	@RequestMapping(value = {"/Login"}, method = RequestMethod.POST)
	public ModelAndView login(@RequestParam String account, @RequestParam String pass){
		MembersVO mvo = memberService.findByAccount(account);
		if (mvo.getPassword().equals(pass)){
			return new ModelAndView("MemberInfo", "member", mvo);
		} else {
		return new ModelAndView("LoginError");
		}
	}
	
	@RequestMapping(value = {"/searchmembers"}, produces = "application/json", method = RequestMethod.POST)
	public @ResponseBody List<MembersVO> searchMembers(@RequestParam String name){
		List<MembersVO> mvos = memberService.findByFirstNameOrLastName(name);
		return mvos;
	}	
}
