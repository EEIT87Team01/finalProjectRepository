package _02.controller.spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import _02.model.friendRelationship.FriendRelationshipDAO;
import _02.model.friendRelationship.FriendRelationshipPK;
import _02.model.friendRelationship.FriendRelationshipVO;
import _02.model.friendRequest.FriendRequestDAO;
import _02.model.friendRequest.FriendRequestPK;
import _02.model.friendRequest.FriendRequestVO;
import _02.model.members.MembersDAO;
import _02.model.members.MembersVO;

@Controller
public class FriendSpringController {
	
	@RequestMapping(value = "/friend/invite/{rid}&{id}", method = RequestMethod.GET)
	public ModelAndView invite(@PathVariable String rid, @PathVariable String id){
		MembersDAO mdao = new MembersDAO();
		MembersVO requester = mdao.findByID(id);
		requester.getFriendRequest().add(mdao.findByID(rid));
		mdao.update(requester);
		return new ModelAndView("redirect:/pages/friend/FriendRequest.jsp");
	}
	
	@RequestMapping(value = "/friend/accept/{requestId}&{receiveId}", method = RequestMethod.GET)
	public ModelAndView accept(@PathVariable String requestId, @PathVariable String receiveId){
		MembersDAO mdao = new MembersDAO();
		FriendRequestDAO frdao = new FriendRequestDAO();
		FriendRelationshipDAO frsdao = new FriendRelationshipDAO();
		FriendRequestVO frvo = new FriendRequestVO(new FriendRequestPK(mdao.findByID(requestId), mdao.findByID(receiveId)));
		FriendRelationshipVO frsvo = new FriendRelationshipVO(new FriendRelationshipPK(mdao.findByID(requestId), mdao.findByID(receiveId)));
		
		frdao.delete(frvo);
		frsdao.insert(frsvo);
		
		return new ModelAndView("redirect:/pages/friend/FriendReceive.jsp", "member", mdao.findByID(receiveId));
	}
	
	
}
