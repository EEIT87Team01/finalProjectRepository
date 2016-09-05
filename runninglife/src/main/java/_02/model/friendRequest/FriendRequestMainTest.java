package _02.model.friendRequest;

import _02.model.members.MembersDAO;
import _02.model.members.MembersVO;

public class FriendRequestMainTest {
	public static void main(String[] args){
		MembersDAO mdao = new MembersDAO();
		FriendRequestDAO frdao = new FriendRequestDAO();
		FriendRequestVO frvo = new FriendRequestVO();
		MembersVO req = mdao.findByID("1D826786-03FE-44B4-9CBA-B258745CE939");
		MembersVO rec = mdao.findByID("1B98BB09-4904-4FDA-9C14-A65FB4C03973");
		FriendRequestPK frpk = new FriendRequestPK();
		frpk.setReceiverID(rec);
		frpk.setRequesterID(req);
		frvo.setFriendRequestPK(frpk);
		
		frdao.insert(frvo);
		
		System.out.println(frvo.friendRequestPK.receiverID + ", " + frvo.friendRequestPK.requesterID);
	}
}
