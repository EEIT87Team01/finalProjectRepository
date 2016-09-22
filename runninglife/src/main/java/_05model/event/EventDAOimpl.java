package _05model.event;

import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import _05hibernate.util.HibernateUtil;
import _05model.runner.RunnerDAOimpl;
import _05model.runner.RunnerVO;
@Repository
@Transactional
public class EventDAOimpl implements EventDAO {
	private static final String GET_ALL_STMT = "from EventVO order by eventID";
	private static final String GET_EVENT_BY_ID = "from EventVO where contestID = :contestID order by EventID";
	
    @Autowired
    private SessionFactory sessionFactory;
 
    protected Session getSession(){
        return sessionFactory.getCurrentSession();
    }
    
	@Override
	public void insert(EventVO eventVO) {
		Session session = getSession();
		try {
			session.saveOrUpdate(eventVO);
		} catch (RuntimeException ex) {
			throw ex;
		}
	}
//	@Override
//	public void insert(EventVO eventVO) {
//		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
//		try {
//			session.beginTransaction();
//			session.saveOrUpdate(eventVO);
//			session.getTransaction().commit();
//		} catch (RuntimeException ex) {
//			session.getTransaction().rollback();
//			throw ex;
//		}
//	}
	@Override
	public void update(EventVO eventVO) {
		Session session = getSession();
		try {
			session.saveOrUpdate(eventVO);
		} catch (RuntimeException ex) {
			throw ex;
		}
	}
//	@Override
//	public void update(EventVO eventVO) {
//		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
//		try {
//			session.beginTransaction();
//			session.saveOrUpdate(eventVO);
//			session.getTransaction();
//		} catch (RuntimeException ex) {
//			session.getTransaction();
//			throw ex;
//		}
//	}

	@Override
	public void delete(Integer eventID) {
		RunnerDAOimpl runnerDAO = new RunnerDAOimpl();
		List<RunnerVO> list = runnerDAO.getEventGroup(eventID);
		Session session = getSession();
		try {
			EventVO eventVO = (EventVO) session.get(EventVO.class, eventID);
			session.delete(eventVO);
		} catch (RuntimeException ex) {
			throw ex;
		}
	}
//	@Override
//	public void delete(Integer eventID) {
//		RunnerDAOimpl runnerDAO = new RunnerDAOimpl();
//		List<RunnerVO> list = runnerDAO.getEventGroup(eventID);
//		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
//		try {
//			session.beginTransaction();
//			EventVO eventVO = (EventVO) session.get(EventVO.class, eventID);
//			session.delete(eventVO);
//			session.getTransaction().commit();
//		} catch (RuntimeException ex) {
//			session.getTransaction().rollback();
//			throw ex;
//		}
//	}

	@Override
	public EventVO findByPrimaryKey(Integer eventID) {
		EventVO eventVO = null;
		Session session = getSession();
		try {
			eventVO = (EventVO) session.get(EventVO.class, eventID);
		} catch (RuntimeException ex) {
			throw ex;
		}
		return eventVO;
	}
//	@Override
//	public EventVO findByPrimaryKey(Integer eventID) {
//		EventVO eventVO = null;
//		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
//		try {
//			session.beginTransaction();
//			eventVO = (EventVO) session.get(EventVO.class, eventID);
//			session.getTransaction().commit();
//		} catch (RuntimeException ex) {
//			session.getTransaction().rollback();
//			throw ex;
//		}
//		return eventVO;
//	}

	@Override
	public List<EventVO> getAll() {
		List<EventVO> list = null;
		Session session = getSession();
		try {
			Query query = session.createQuery(GET_ALL_STMT);
			list = query.list();
		} catch (RuntimeException ex) {
			throw ex;
		}
		return list;
	}
//	@Override
//	public List<EventVO> getAll() {
//		List<EventVO> list = null;
//		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
//		try {
//			session.beginTransaction();
//			Query query = session.createQuery(GET_ALL_STMT);
//			list = query.list();
//			session.getTransaction().commit();
//		} catch (RuntimeException ex) {
//			session.getTransaction().rollback();
//			throw ex;
//		}
//		return list;
//	}
	@Override
	public List<EventVO> getEventById(Integer contestID) {
		List<EventVO> list = null;
		Session session = getSession();
		try {
			Query query = session.createQuery(GET_EVENT_BY_ID);
			query.setParameter("contestID", contestID);
			list = query.list();
		} catch (RuntimeException ex) {
			throw ex;
		}
		return list;
	}
//	@Override
//	public List<EventVO> getEventById(Integer contestID) {
//		List<EventVO> list = null;
//		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
//		try {
//			session.beginTransaction();
//			Query query = session.createQuery(GET_EVENT_BY_ID);
//			query.setParameter("contestID", contestID);
//			list = query.list();
//			session.getTransaction().commit();
//		} catch (RuntimeException ex) {
//			session.getTransaction().rollback();
//			throw ex;
//		}
//		return list;
//	}

	public static void main(String[] args) {
			EventDAOimpl dao = new EventDAOimpl();
			EventVO eventVO = new EventVO();
			dao.insert(eventVO);
			// dao.delete(5);
	}

}
