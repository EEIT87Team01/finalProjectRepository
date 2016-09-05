package _02.model.membercomplete.membercom;

import org.hibernate.Session;

import _02.model.HibernateUtil;

public class MembercomTest {
	
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		MembercomVO mcvo = new MembercomVO();
		
		session.beginTransaction();
		mcvo = (MembercomVO) session.get(MembercomVO.class, "F349A8E2-DE67-4F70-838B-C099C687D57F");
		session.getTransaction().commit();
		
		System.out.println(mcvo.toString());
		
	}

}
