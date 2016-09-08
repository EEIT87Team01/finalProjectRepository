package _02.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
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
public class FriendController {
	
	@Autowired
	MembersService_interface memberService;
	
	@Autowired
	FriendRequestService_interface friendRequestService;
	
	@Autowired
	FriendRelationshipService_interface friendRelationshipService;
	
	//用 memberID 顯示所有收到的邀請 by JSON
	@RequestMapping(value = {"/listrequestjson_id={memberID}"},method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<FriendRequestVO> listRequestJSON(@PathVariable String memberID){
		return friendRequestService.findByReceiverID(memberService.findByID(memberID));
	}
	
	//用 memberID 顯示所有的朋友
	@RequestMapping(value = {"/listFriend_id={memberID}"}, method = RequestMethod.GET)
	public ModelAndView listFriend(@PathVariable String memberID){
		return new ModelAndView("/friend/FriendList", "friends", friendRelationshipService.findByMemberID(memberService.findByID(memberID)));
	}
	
	//用 memberID 顯示所有收到的邀請
	@RequestMapping(value = {"/listFriendRequest_id={mid}"}, method = RequestMethod.GET)
	public ModelAndView listFriendRequest(@PathVariable String mid){
		return new ModelAndView("/friend/FriendRequest", "member", friendRequestService.findByReceiverID(memberService.findByID(mid)));
	}
	
	//接受邀請
	@RequestMapping(value = {"/acceptRequest_requestid={requestID}&receiverid={receiveID}"}, method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	public void acceptRequest(@PathVariable String requestID, @PathVariable String receiveID){
		MembersVO receiveMVO = memberService.findByID(receiveID);
		MembersVO requestMVO = memberService.findByID(requestID);
		friendRequestService.deleteByPrimaryKey(new FriendRequestPK(requestMVO,receiveMVO));
		friendRelationshipService.insert(new FriendRelationshipVO(new FriendRelationshipPK(receiveMVO, requestMVO)));
	}
	
	//寄送邀請
	@RequestMapping(value = {"/sendRequest"}, method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
	public void sendRequest(@RequestParam String requestID, @RequestParam String receiveID){
		MembersVO receiveMVO = memberService.findByID(receiveID);
		MembersVO requestMVO = memberService.findByID(requestID);
		friendRequestService.insert(new FriendRequestVO (new FriendRequestPK(requestMVO,receiveMVO)));
	}
	
	//刪除好友
	@RequestMapping(value = {"/deletefriend_memberid={memberID}&friendid={friendID}"}, method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	public void deleteFriend(@PathVariable String memberID, @PathVariable String friendID){
		MembersVO memberMVO = memberService.findByID(memberID);
		MembersVO friendMVO = memberService.findByID(friendID);
		friendRelationshipService.deleteByPrimaryKey(new FriendRelationshipPK(memberMVO,friendMVO));
	}
}
