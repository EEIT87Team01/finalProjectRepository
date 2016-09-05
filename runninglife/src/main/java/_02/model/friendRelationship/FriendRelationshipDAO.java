package _02.model.friendRelationship;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import _02.model.HibernateUtil;
import _02.model.members.MembersVO;

public class FriendRelationshipDAO implements FriendRelationshipDAO_interface {
	
	static private final String GET_BY_MEMBERID_STMT = "FROM FriendRelationshipVO WHERE memberID=?";
	static private final String GET_ALL_STMT = "FROM FriendRelationshipVO";

	@Override
	public void insert(FriendRelationshipVO friendRelationshipVO) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		
		try{
			session.beginTransaction();
			session.saveOrUpdate(friendRelationshipVO);
			session.getTransaction().commit();
		} catch  (RuntimeException e) {
			session.getTransaction().rollback();
			throw e;
		}
		
		Session session2 = HibernateUtil.getSessionFactory().getCurrentSession();
		try{
			session2.beginTransaction();
			session2.saveOrUpdate(new FriendRelationshipVO (
										new FriendRelationshipPK(
												friendRelationshipVO.getFriendRelationshipPK().getFriendID(),
												friendRelationshipVO.getFriendRelationshipPK().getMemberID())));
			session2.getTransaction().commit();
		} catch  (RuntimeException e) {
			session2.getTransaction().rollback();
			throw e;
		}
	}

	@Override
	public void update(FriendRelationshipVO friendRelationshipVO) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		
		try{
			session.beginTransaction();
			session.saveOrUpdate(friendRelationshipVO);
			session.getTransaction().commit();
		} catch  (RuntimeException e) {
			session.getTransaction().rollback();
			throw e;
		}
	}

	@Override
	public void delete(FriendRelationshipVO friendRelationshipVO) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		
		try{
			session.beginTransaction();
			session.saveOrUpdate(friendRelationshipVO);
			session.getTransaction().commit();
		} catch  (RuntimeException e) {
			session.getTransaction().rollback();
			throw e;
		}
	}

	@Override
	public FriendRelationshipVO findByPrimaryKey(FriendRelationshipPK friendRelationshipPK) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		FriendRelationshipVO frsvo = new FriendRelationshipVO();
		
		try{
			session.beginTransaction();
			frsvo = (FriendRelationshipVO) session.get(FriendRelationshipVO.class, friendRelationshipPK);
			session.getTransaction().commit();
		} catch  (RuntimeException e) {
			session.getTransaction().rollback();
			throw e;
		}
		
		return frsvo;
	}

	@Override
	public List<FriendRelationshipVO> findByMemberID(MembersVO membersVO) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		List<FriendRelationshipVO> frsvos = new ArrayList<FriendRelationshipVO>();
		
		try{
			session.beginTransaction();
			Query query = session.createQuery(GET_BY_MEMBERID_STMT);
			query.setString(1, membersVO.getMemberID());
			frsvos = query.list();
			session.getTransaction().commit();
		} catch  (RuntimeException e) {
			session.getTransaction().rollback();
			throw e;
		}
		
		return frsvos;
	}

	@Override
	public List<FriendRelationshipVO> getAll() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		List<FriendRelationshipVO> frsvos = new ArrayList<FriendRelationshipVO>();
		
		try{
			session.beginTransaction();
			Query query = session.createQuery(GET_ALL_STMT);
			frsvos = query.list();
			session.getTransaction().commit();
		} catch  (RuntimeException e) {
			session.getTransaction().rollback();
			throw e;
		}
		
		return frsvos;
	}

}
