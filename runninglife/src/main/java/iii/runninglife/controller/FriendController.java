package iii.runninglife.controller;

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

import iii.runninglife.model.friendRelationship.FriendRelationshipPK;
import iii.runninglife.model.friendRelationship.FriendRelationshipService_interface;
import iii.runninglife.model.friendRelationship.FriendRelationshipVO;
import iii.runninglife.model.friendRequest.FriendRequestPK;
import iii.runninglife.model.friendRequest.FriendRequestService_interface;
import iii.runninglife.model.friendRequest.FriendRequestVO;
import iii.runninglife.model.members.MembersInterface;
import iii.runninglife.model.members.MembersVO;

@Controller
@RequestMapping("/friend")
@SessionAttributes("membersVO")
public class FriendController {
	
	@Autowired
	MembersInterface memberService;
	
	@Autowired
	FriendRequestService_interface friendRequestService;
	
	@Autowired
	FriendRelationshipService_interface friendRelationshipService;
	
	//用 memberID 顯示所有收到的邀請 by JSON
	@RequestMapping(value = {"/listrequestjson"}, produces = "application/json")
	public @ResponseBody List<FriendRequestVO> listRequestJSON(@ModelAttribute("membersVO")MembersVO member){
		return friendRequestService.findByReceiverID(member);
	}
	
	@RequestMapping(value = {"/sendRequest"})
	public String toSendRequest(){
		return "SendRequest";
	}
	
	//用 memberID 顯示所有的朋友
	@RequestMapping(value = {"/listFriend"})
	public ModelAndView listFriend(@ModelAttribute("membersVO")MembersVO member){
		return new ModelAndView("/FriendList", "friends", friendRelationshipService.findByMemberID(member));
	}
	
	//用 memberID 顯示所有收到的邀請
	@RequestMapping(value = {"/listFriendRequest"})
	public ModelAndView listFriendRequest(@ModelAttribute("membersVO")MembersVO member){
		return new ModelAndView("/FriendRequest", "receivedRequest", friendRequestService.findByReceiverID(member));
	}
	
	//接受邀請
	@RequestMapping(value = {"/acceptRequest"}, method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
	public void acceptRequest(@ModelAttribute("membersVO")MembersVO member, @RequestParam String requestID){
		MembersVO requestMVO = memberService.selectOne(requestID);
		friendRequestService.deleteByPrimaryKey(new FriendRequestPK(requestMVO,member));
		friendRelationshipService.insert(new FriendRelationshipVO(new FriendRelationshipPK(member, requestMVO)));
	}
	
	//寄送邀請
	@RequestMapping(value = {"/sendRequest"}, method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
	public void sendRequest(@ModelAttribute("membersVO")MembersVO member, @RequestParam String receiveID){
		MembersVO receiveMVO = memberService.selectOne(receiveID);
		friendRequestService.insert(new FriendRequestVO (new FriendRequestPK(member,receiveMVO)));
	}
	
	//刪除好友
	@RequestMapping(value = {"/deletefriend"}, method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
	public void deleteFriend(@ModelAttribute("membersVO")MembersVO member, @RequestParam String friendID){
		MembersVO friendMVO = memberService.selectOne(friendID);
		friendRelationshipService.deleteByPrimaryKey(new FriendRelationshipPK(member,friendMVO));
	}
	
	//尋找會員(加入朋友)
	@RequestMapping(value = {"/searchmembersforrequestfriend"}, produces = "application/json", method = RequestMethod.POST)
	public @ResponseBody List<MembersVO> searchMembers(@RequestParam String name, @ModelAttribute("membersVO") MembersVO member){
		List<MembersVO> mvos = memberService.findByFirstNameOrLastName(name);
		List<MembersVO> compare = friendRelationshipService.findByMemberIDALLFriendID(member);
		compare.addAll(friendRequestService.findByReceiverIDALLRequester(member));
		compare.addAll(friendRequestService.findByRequesterIDALLReceiver(member));
		compare.add(member);
		mvos.removeAll(compare);
		return mvos;
	}
}
