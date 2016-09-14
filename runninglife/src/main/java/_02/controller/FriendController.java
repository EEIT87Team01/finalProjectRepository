package _02.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import _02.model.friendRelationship.FriendRelationshipPK;
import _02.model.friendRelationship.FriendRelationshipService_interface;
import _02.model.friendRelationship.FriendRelationshipVO;
import _02.model.friendRequest.FriendRequestPK;
import _02.model.friendRequest.FriendRequestService_interface;
import _02.model.friendRequest.FriendRequestVO;
import _02.model.members.MembersService_interface;
import _02.model.members.MembersVO;

@Controller
@RequestMapping("/friend")
@SessionAttributes("member")
public class FriendController {
	
	@Autowired
	MembersService_interface memberService;
	
	@Autowired
	FriendRequestService_interface friendRequestService;
	
	@Autowired
	FriendRelationshipService_interface friendRelationshipService;
	
	//用 memberID 顯示所有收到的邀請 by JSON
	@RequestMapping(value = {"/listrequestjson"}, produces = "application/json")
	public @ResponseBody List<FriendRequestVO> listRequestJSON(@ModelAttribute("member")MembersVO member){
		return friendRequestService.findByReceiverID(member);
	}
	
	@RequestMapping(value = {"/sendRequest"})
	public String toSendRequest(){
		return "SendRequest";
	}
	
	//用 memberID 顯示所有的朋友
	@RequestMapping(value = {"/listFriend"})
	public ModelAndView listFriend(@ModelAttribute("member")MembersVO member){
		return new ModelAndView("/FriendList", "friends", friendRelationshipService.findByMemberID(member));
	}
	
	//用 memberID 顯示所有收到的邀請
	@RequestMapping(value = {"/listFriendRequest"})
	public ModelAndView listFriendRequest(@ModelAttribute("member")MembersVO member){
		return new ModelAndView("/FriendRequest", "receivedRequest", friendRequestService.findByReceiverID(member));
	}
	
	//接受邀請
	@RequestMapping(value = {"/acceptRequest"}, method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
	public void acceptRequest(@ModelAttribute("member")MembersVO member, @RequestParam String requestID){
		MembersVO requestMVO = memberService.findByID(requestID);
		friendRequestService.deleteByPrimaryKey(new FriendRequestPK(requestMVO,member));
		friendRelationshipService.insert(new FriendRelationshipVO(new FriendRelationshipPK(member, requestMVO)));
	}
	
	//寄送邀請
	@RequestMapping(value = {"/sendRequest"}, method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
	public void sendRequest(@ModelAttribute("member")MembersVO member, @RequestParam String receiveID){
		MembersVO receiveMVO = memberService.findByID(receiveID);
		friendRequestService.insert(new FriendRequestVO (new FriendRequestPK(member,receiveMVO)));
	}
	
	//刪除好友
	@RequestMapping(value = {"/deletefriend"}, method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
	public void deleteFriend(@ModelAttribute("member")MembersVO member, @RequestParam String friendID){
		MembersVO friendMVO = memberService.findByID(friendID);
		friendRelationshipService.deleteByPrimaryKey(new FriendRelationshipPK(member,friendMVO));
	}
	
	//尋找會員(加入朋友)
	@RequestMapping(value = {"/searchmembersforrequestfriend"}, produces = "application/json", method = RequestMethod.POST)
	public @ResponseBody List<MembersVO> searchMembers(@RequestParam String name, @ModelAttribute("member") MembersVO member){
		List<MembersVO> mvos = memberService.findByFirstNameOrLastName(name);
		List<MembersVO> compare = friendRelationshipService.findByMemberIDALLFriendID(member);
		compare.addAll(friendRequestService.findByReceiverIDALLRequester(member));
		compare.addAll(friendRequestService.findByRequesterIDALLReceiver(member));
		compare.add(member);
		mvos.removeAll(compare);
		return mvos;
	}
}
