package _04.model.challs;

import java.util.*;
import org.hibernate.Query;
import org.hibernate.Session;
import _04.hibernate.util.HibernateUtil;
import java.sql.*;

public class ChallsDAO implements IchallDAO {
	
	private static final String GET_ALL_STMT = 
		"from ChallVO order by challenID";
	private static final String GET_DATE_STMT = 
		"select max(challenID) from ChallVO";
	


	@Override
	public void insert(ChallsVO challVO) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(challVO);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
	}


	@Override
	public void delete(String challenID) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			ChallsVO challVO = new ChallsVO();
			challVO.setChallenID(challenID);
			session.delete(challVO);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
	}

	@Override
	public ChallsVO findByPrimaryKey(String challenID) {
		ChallsVO challVO = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			challVO = (ChallsVO) session.get(ChallsVO.class, challenID);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return challVO;
	}


	@Override
	public List<ChallsVO> getAll() {
		List<ChallsVO> list = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			Query query = session.createQuery(GET_ALL_STMT);
			list = query.list();
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return list;
	}
	
	public String countDateChallenge(String challenDate) throws SQLException {
		String seq="";
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			Query query = session.createQuery(GET_DATE_STMT);
			int max=Integer.valueOf(query.list().toString().substring(9,14));
			seq=String.format("%05d",max+1);
			System.out.println(query.list().toString());
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return seq;
	}
	public static void main(String[] args) {
		IchallDAO dao = new ChallsDAO();
//		List<ChallVO> list = null;
//		try {
//			list = dao.getAll();
//			for (ChallVO aad : list) {
//				System.out.print("id="+aad.getChallenID() + ",");
//				System.out.print("name="+aad.getChallenName() + ",");
//				System.out.print("division="+aad.getLocationID() + ",");
//				System.out.print("link="+aad.getChallenDistance() + ",");
//				System.out.print("st="+aad.getChallenStartTime() + ",");
//				System.out.print("et="+aad.getChallenEndTime() + ",");
//				System.out.print("priority="+aad.getComment() );
//				System.out.println();
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			System.out.println("a");
//			e.printStackTrace();
//		}
		try {
			System.out.println(dao.countDateChallenge("20160101"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}

} // end of class EmpDAO