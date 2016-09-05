package _02.model.friendRelationship;

import org.hibernate.Query;
import org.hibernate.Session;
import java.util.List;
import _02.model.HibernateUtil;
import _02.model.members.MembersDAO;
import _02.model.members.MembersVO;

public class FriendRelationshipMainTest {
	public static void main(String[] args){
		MembersDAO mdao = new MembersDAO();
		
		FriendRelationshipVO frvo = new FriendRelationshipVO(
										new FriendRelationshipPK(mdao.findByID("1DDAC2E1-075F-43D7-B390-FFBF1CF66F35"),
																 mdao.findByID("1D826786-03FE-44B4-9CBA-B258745CE939")));
		FriendRelationshipDAO frsdao = new FriendRelationshipDAO();
		
		frsdao.insert(frvo);
		
		System.out.println("Hello");
		
	}
}
