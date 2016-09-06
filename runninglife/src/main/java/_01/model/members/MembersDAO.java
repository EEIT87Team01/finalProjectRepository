package _01.model.members;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import _01.model.hibernate.util.HibernateUtil;
import _01.model.location.LocationVO;

public class MembersDAO implements MembersInterface{
	
	private static final String GET_ALL_STMT = "from MembersVO ";
	
	Transaction tx = null;
	@Override
	public int insert(MembersVO membersVO) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		int count = 0;
		try{
			session.beginTransaction();
			session.saveOrUpdate(membersVO);
			session.getTransaction().commit();
		} catch(RuntimeException ex){
			session.getTransaction().rollback();
			throw ex;
		} 
		count++;
		return count;
	}

	@Override
	public int update(MembersVO memberVO) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		int count = 0;
		try{
			session.beginTransaction();
			session.saveOrUpdate(memberVO);
			session.getTransaction().commit();
		} catch(RuntimeException ex){
			session.getTransaction().rollback();
			throw ex;
		} 
		count++;
		return count;
	}

	@Override
	public int delete(String memberVO) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		int count = 0;
		try{
			session.beginTransaction();
			
			MembersVO membersBean = (MembersVO)session.get(MembersVO.class,memberVO);
			session.delete(membersBean);
			
			session.getTransaction().commit();
			System.out.print("success delete");
		} catch(RuntimeException ex){
			session.getTransaction().rollback();
			throw ex;
		} 
		count++;
		return count;
	}

	@Override
	public MembersVO selectOne(String memberVO) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		MembersVO memberBean = null;
		try{
			session.beginTransaction();
			memberBean = (MembersVO)session.get(MembersVO.class,memberVO);
			System.out.println("MemberID: "+memberBean.getMemberID() +", ");
			System.out.println("FirstName: "+memberBean.getFirstName() + ", ");
			System.out.println("LastName: "+memberBean.getLastName() + ", ");
			System.out.println("Nickname: "+memberBean.getNickname() + ", ");
			System.out.println("Email: "+memberBean.getEmail() + ", ");
			System.out.println("Gender: "+memberBean.getGender() + ", ");
			System.out.println("Birthday: "+memberBean.getBirthday() + ", ");
			System.out.println("CountryID: "+memberBean.getLocationID().getLocationID().getCityID().getCityID().getCountryID() + ", ");
			System.out.println("CityID: "+memberBean.getLocationID().getLocationID().getCityID().getCityID().getCityID() + ", ");
			System.out.println("LocationID: "+memberBean.getLocationID().getLocationID().getLocationID() + ", ");
			System.out.println("Address: "+memberBean.getAddress() + ", ");
			System.out.println("Height: "+memberBean.getHeight() + ", ");
			System.out.println("Weight: "+memberBean.getWeight() + ", ");
			System.out.println("Phone: "+memberBean.getPhone() + ", ");
			System.out.println("Phone: "+memberBean.getPhoto() + ", ");
			System.out.println("CompetenceID: "+memberBean.getIdentityID() + ", ");
			System.out.println("CompetenceID: "+memberBean.getCompetenceID() + ", ");
			System.out.println("EmergencyContact: "+memberBean.getEmergencyContact() + ", ");
			System.out.println("EmergencyPhone: "+memberBean.getEmergencyPhone() + ", ");
			System.out.println("RelationID: "+memberBean.getEmergencyRelation().getRelationID() + ", ");
			System.out.println("CreateDate: "+memberBean.getCreateDate() + ", ");
			System.out.println("LastOnlineDateTime: "+memberBean.getLastOnlineDateTime());
			System.out.println(" ");
			session.getTransaction().commit();
		} catch(RuntimeException ex){
			session.getTransaction().rollback();
			throw ex;
		} 
		return memberBean;
	}

	@Override
	public List<MembersVO> selectAll() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try{
			session.beginTransaction();
			Query query = session.createQuery(GET_ALL_STMT); 
			List<MembersVO> list = query.list();
			for (MembersVO aMember : list) {
				System.out.println("MemberID: "+aMember.getMemberID() +", ");
				System.out.println("FirstName: "+aMember.getFirstName() + ", ");
				System.out.println("LastName: "+aMember.getLastName() + ", ");
				System.out.println("Nickname: "+aMember.getNickname() + ", ");
				System.out.println("Email: "+aMember.getEmail() + ", ");
				System.out.println("Gender: "+aMember.getGender() + ", ");
				System.out.println("Birthday: "+aMember.getBirthday() + ", ");
				System.out.println("CountryID: "+aMember.getLocationID().getLocationID().getCityID().getCityID().getCountryID() + ", ");
				System.out.println("CityID: "+aMember.getLocationID().getLocationID().getCityID().getCityID().getCityID() + ", ");
				System.out.println("LocationID: "+aMember.getLocationID().getLocationID().getLocationID() + ", ");
				System.out.println("Address: "+aMember.getAddress() + ", ");
				System.out.println("Height: "+aMember.getHeight() + ", ");
				System.out.println("Weight: "+aMember.getWeight() + ", ");
				System.out.println("Phone: "+aMember.getPhone() + ", ");
				System.out.println("Phone: "+aMember.getPhoto() + ", ");
				System.out.println("IdentityID: "+aMember.getIdentityID() + ", ");
				System.out.println("CompetenceID: "+aMember.getCompetenceID().getCompetenceID() + ", ");
				System.out.println("EmergencyContact: "+aMember.getEmergencyContact() + ", ");
				System.out.println("EmergencyPhone: "+aMember.getEmergencyPhone() + ", ");
				System.out.println("RelationID: "+aMember.getEmergencyRelation().getRelationID() + ", ");
				System.out.println("CreateDate: "+aMember.getCreateDate() + ", ");
				System.out.println("LastOnlineDateTime: "+aMember.getLastOnlineDateTime());
				System.out.println(" ");
			}
			
			session.getTransaction().commit();
		} catch(RuntimeException ex){
			session.getTransaction().rollback();
			throw ex;
		} 

		return null;
	}

}
