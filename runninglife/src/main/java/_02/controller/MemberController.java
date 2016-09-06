package _02.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	
	@RequestMapping(value = {"/listFriend_id={memberID}"}, method = RequestMethod.GET)
	public String listFriend(@PathVariable String memberID, ModelMap model){
		MembersVO mvo = memberService.listFriend(memberID);
		model.addAttribute("member", mvo);
		return "/friend/FriendList";
	}
	
	@RequestMapping(value = {"/listFriendRequest_id={mid}"}, method = RequestMethod.GET)
	public String listFriendRequest(@PathVariable String mid, ModelMap model){
		MembersVO mvo = memberService.findByID(mid);
		model.addAttribute("member", mvo);
		return "/friend/FriendRequestTest";
	}
	
	@RequestMapping(value = {"/acceptRequest_requestid={requestID}&receiveid={receiveID}"}, method = RequestMethod.GET)
	public String acceptRequest(@PathVariable String requestID, @PathVariable String receiveID){
		MembersVO receiveMVO = memberService.findByID(receiveID);
		MembersVO requestMVO = memberService.findByID(requestID);
		FriendRequestPK frpk = new FriendRequestPK(requestMVO,receiveMVO);
		if (receiveID == null)System.out.println("null");
		friendRequestService.deleteByPrimaryKey(frpk);
		return "redirect:/member/listFriendRequest_id=" + receiveMVO.getMemberID();
	}
	
}
