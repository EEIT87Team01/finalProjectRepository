package _04.model.chall_data;

import java.util.*;
import org.hibernate.Query;
import org.hibernate.Session;
import _04.hibernate.util.HibernateUtil;
import java.sql.*;

public class ChallDataDAO implements IchallDataDAO {

	private static final String GET_ALL_STMT = 
		"from ChallDataVO order by challenID";
	private static final String GET_CHALL_STMT = 
		"from ChallDataVO where challenID = :chall";
	private static final String GET_MEMBER_STMT = 
		"from ChallDataVO where memberID = :member";

	@Override
	public void insert(ChallDataVO challDataVO) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(challDataVO);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
	}

	public void update(ChallDataVO challDataVO) throws SQLException {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(challDataVO);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
	}

	@Override
	public void delete(Two_ID two_ID) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			Two_ID reportListVO = (Two_ID) session.get(Two_ID.class, two_ID);
			session.delete(reportListVO);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
	}

	@Override
	public ChallDataVO findByPrimaryKey(Two_ID two_ID) {
		ChallDataVO challDataVO = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			challDataVO = (ChallDataVO) session.get(ChallDataVO.class, two_ID);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return challDataVO;
	}
	@Override
	public List<ChallDataVO> getAll() throws SQLException {
		List<ChallDataVO> list = null;
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
	@Override
	public List<ChallDataVO> findByChall(String challenID) throws SQLException {
		List<ChallDataVO> list = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			Query query = session.createQuery(GET_CHALL_STMT).setParameter("chall", challenID);
			list = query.list();
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return list;
	}
	@Override
	public List<ChallDataVO> findByMember(String memberID) throws SQLException {
		List<ChallDataVO> list = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			Query query = session.createQuery(GET_MEMBER_STMT).setParameter("member", memberID);
			list = query.list();
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return list;
	}

	public static void main(String[] args) {
		ChallDataDAO dao = new ChallDataDAO();
		List<ChallDataVO> list = null;
		try {
			list = dao.getAll();
			for (ChallDataVO aad : list) {
				System.out.print("id="+aad.getId().getChallenID() + ",");
				System.out.print("name="+aad.getId().getMemberID() + ",");
				System.out.print("division="+aad.getFinishTime() + ",");
				System.out.print("link="+aad.getProcessLength() + ",");
				System.out.print("st="+aad.getDuration());
				System.out.println();
			}
		} catch (SQLException e) {
			System.out.println("a");
			e.printStackTrace();
		}
		
	
	}


} // end of class EmpDAO