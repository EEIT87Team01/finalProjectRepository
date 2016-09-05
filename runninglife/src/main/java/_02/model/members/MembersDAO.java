package _02.model.members;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;

import _02.model.HibernateUtil;

public class MembersDAO implements MembersDAO_interface{
	
	static private final String FIND_BY_FIRSTNAME_STMT = "FROM MembersVO WHERE firstName=?";
	static private final String FIND_BY_FIRSTNAME_AND_LASTNAME_STMT = "FROM MembersVO WHERE firstName=? or lastName=?";
	static private final String FIND_BY_ACCOUNT_STMT = "FROM MembersVO WHERE account=?";
	static private final String GET_ALL_STMT = "FROM MembersVO";

	@Override
	public void insert(MembersVO memberVo) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		
		try {
			session.beginTransaction();
			session.saveOrUpdate(memberVo);
			session.getTransaction().commit();
			
		} catch (RuntimeException e) {
			session.getTransaction().rollback();
			throw e;
		}
	}

	@Override
	public void update(MembersVO memberVo) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		
		try {
			session.beginTransaction();
			session.saveOrUpdate(memberVo);
			session.getTransaction().commit();
			
		} catch (RuntimeException e) {
			session.getTransaction().rollback();
			throw e;
		}
	}

	@Override
	public void delete(String memberID) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		
		try {
			session.beginTransaction();
			MembersVO mvo = (MembersVO) session.get(MembersVO.class, memberID);
			session.delete(mvo);
			session.getTransaction().commit();
			
		} catch (RuntimeException e) {
			session.getTransaction().rollback();
			throw e;
		}
	}

	@Override
	public MembersVO findByID(String memberID) {
		MembersVO mvo = new MembersVO();
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		
		try {
			session.beginTransaction();
			mvo = (MembersVO) session.get(MembersVO.class, memberID);
			session.getTransaction().commit();
			} catch (RuntimeException e) {
				session.getTransaction().rollback();
				throw e;
		}
		return mvo;
	}
	
	@Override
	public MembersVO findByFirstName(String firstName) {
		MembersVO mvo = new MembersVO();
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		
		try {
			session.beginTransaction();
			Query query = session.createQuery(FIND_BY_FIRSTNAME_STMT);
			query.setString(0, firstName);
			mvo = (MembersVO) query.uniqueResult();
			session.getTransaction().commit();
			} catch (RuntimeException e) {
				session.getTransaction().rollback();
				throw e;
		}
		return mvo;
	}

	@Override
	public List<MembersVO> getAll() {
		List<MembersVO> mvos = new ArrayList<MembersVO>();
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		
		try {
			session.beginTransaction();
			Query query = session.createQuery(GET_ALL_STMT);
			mvos = query.list();
			session.getTransaction().commit();
			} catch (RuntimeException e) {
				session.getTransaction().rollback();
				throw e;
		}
		return mvos;
	}

	@Override
	public MembersVO findByAccount(String account) {
		MembersVO mvo = new MembersVO();
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		
		try {
			session.beginTransaction();
			Query query = session.createQuery(FIND_BY_ACCOUNT_STMT);
			query.setString(0, account);
			mvo = (MembersVO) query.uniqueResult();
			session.getTransaction().commit();
			} catch (RuntimeException e) {
				session.getTransaction().rollback();
				throw e;
		}
		return mvo;
	}
	
	@Override
	public List<MembersVO> listFriend(MembersVO memberVO){
		List<MembersVO> friends = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		
		try {
			session.beginTransaction();
			friends = ((MembersVO) session.load(MembersVO.class, memberVO.getMemberID())).getFriends();
			session.getTransaction().commit();
			} catch (RuntimeException e) {
				session.getTransaction().rollback();
				throw e;
		}
		
		return friends;
		
	}

	@Override
	public List<MembersVO> findByFirstNameOrLastName(String name) {
		List<MembersVO> mvos = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		
		try {
			session.beginTransaction();
			Query query = session.createQuery(FIND_BY_FIRSTNAME_AND_LASTNAME_STMT);
			query.setString(0, name);
			query.setString(1, name);
			mvos = query.list();
			session.getTransaction().commit();
			} catch (RuntimeException e) {
				session.getTransaction().rollback();
				throw e;
		}
		return mvos;
	}

}
