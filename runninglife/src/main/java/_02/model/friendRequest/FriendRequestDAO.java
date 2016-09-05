package _02.model.friendRequest;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import _02.model.HibernateUtil;
import _02.model.members.MembersVO;

public class FriendRequestDAO implements FriendRequestDAO_interface {
	
	static private final String GET_BY_REQUESTER_STMT = "FROM FriendRequestVO WHERE requesterID=?";
	static private final String GET_BY_RECEIVER_STMT = "FROM FriendRequestVO WHERE receiverID=?";
	static private final String GET_ALL_STMT = "FROM FriendRequestVO";

	@Override
	public void insert(FriendRequestVO friendRequestVO) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		
		try{
			session.beginTransaction();
			session.saveOrUpdate(friendRequestVO);
			session.getTransaction().commit();
		} catch  (RuntimeException e) {
			session.getTransaction().rollback();
			throw e;
		}
	}

	@Override
	public void update(FriendRequestVO friendRequestVO) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		
		try{
			session.beginTransaction();
			session.saveOrUpdate(friendRequestVO);
			session.getTransaction().commit();
		} catch  (RuntimeException e) {
			session.getTransaction().rollback();
			throw e;
		}
	}

	@Override
	public void delete(FriendRequestVO friendRequestVO) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		
		try{
			session.beginTransaction();
			session.delete(friendRequestVO);
			session.getTransaction().commit();
		} catch  (RuntimeException e) {
			session.getTransaction().rollback();
			throw e;
		}
	}

	@Override
	public FriendRequestVO findByPrimaryKey(FriendRequestPK friendRequestPK) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		FriendRequestVO frsvo = new FriendRequestVO();
		
		try{
			session.beginTransaction();
			frsvo = (FriendRequestVO) session.get(FriendRequestVO.class, friendRequestPK);
			session.getTransaction().commit();
		} catch  (RuntimeException e) {
			session.getTransaction().rollback();
			throw e;
		}
		
		return frsvo;
	}

	@Override
	public List<FriendRequestVO> findByRequesterID(MembersVO membersVO) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		List<FriendRequestVO> frsvos = new ArrayList<FriendRequestVO>();
		
		try{
			session.beginTransaction();
			Query query = session.createQuery(GET_BY_REQUESTER_STMT);
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
	public List<FriendRequestVO> findByReceiverID(MembersVO membersVO) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		List<FriendRequestVO> frsvos = new ArrayList<FriendRequestVO>();
		
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

	@Override
	public List<FriendRequestVO> getAll() {
		return null;
	}

}
