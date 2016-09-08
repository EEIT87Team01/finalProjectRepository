package _02.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import _02.model.friendRelationship.FriendRelationshipService_interface;
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
	
	@Autowired
	FriendRelationshipService_interface friendRelationshipService;
	
	@RequestMapping(value = {"/Login"}, method = RequestMethod.POST)
	public ModelAndView login(@RequestParam String account, @RequestParam String pass){
		MembersVO mvo = memberService.findByAccount(account);
		if (mvo.getPassword().equals(pass))return new ModelAndView("MemberInfo", "member", mvo);
		else return new ModelAndView("LoginError");
	}
	
	@RequestMapping(value = {"/searchmembersforrequestfriend"}, produces = "application/json", method = RequestMethod.POST)
	public @ResponseBody List<MembersVO> searchMembers(@RequestParam String name, @RequestParam String memberID){
		MembersVO member = memberService.findByID(memberID);
		List<MembersVO> mvos = memberService.findByFirstNameOrLastName(name);
		List<MembersVO> compare = friendRelationshipService.findByMemberIDALLFriendID(member);
		compare.addAll(friendRequestService.findByReceiverIDALLRequester(member));
		compare.addAll(friendRequestService.findByRequesterIDALLReceiver(member));
		mvos.removeAll(compare);
		return mvos;
	}
}
