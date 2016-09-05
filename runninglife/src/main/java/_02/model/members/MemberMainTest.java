package _02.model.members;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import _02.model.HibernateUtil;

public class MemberMainTest {
	public static void main(String[] args){
		MembersDAO mdao = new MembersDAO();
		MembersVO avos = mdao.findByAccount("B");
		
		
		
			System.out.println(avos.toString());
			System.out.println("Friends");
			for (MembersVO fvo : avos.getFriends()){
				System.out.println("\t" + fvo.toString());
			}
			for (MembersVO fvo : avos.getInverseFriends()){
				System.out.println("\t" + fvo.toString());
			}
			System.out.println("Friend_Request");
			for (MembersVO fvo : avos.getFriendRequest()){
				System.out.println("\t" + fvo.toString());
			}
			System.out.println("Friend_Receive");
			for (MembersVO fvo : avos.getFriendReceive()){
				System.out.println("\t" + fvo.toString());
			}
			
		
	}
}
