package _05model.event;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import _05hibernate.util.HibernateUtil;
import _05model.contest.ContestVO;

public class EventDAOimpl implements EventDAO {
	private static final String GET_ALL_STMT = "from event order by eventID";
	
	@Override
	public void insert(EventVO eventVO) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			//自動生成eventID
			//取最大值+1
			Query query  = session.createQuery(" from EventVO where contestID=:contestID order by eventID desc");
			query.setParameter("contestID",eventVO.getEventPK().getContestID());
			List<EventVO> events =query.list();
			int eventID=0;
			if(!events.isEmpty()){
			eventID=events.get(0).getEventPK().getEventID();
			}
			eventVO.getEventPK().setEventID(eventID+1);
//			for(EventVO aEvent:events){
//				System.out.println(aEvent.getEventPK().getEventID());
//			}
			session.save(eventVO);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}

	}

	@Override
	public void update(EventVO eventVO) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try{
			session.beginTransaction();
			session.saveOrUpdate(eventVO);
			session.getTransaction();
		}catch(RuntimeException ex){
			session.getTransaction();
			throw ex;
		}
	}

	@Override
	public void delete(EventPK pk) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			EventVO eventVO = (EventVO) session.get(EventVO.class, pk);
			session.delete(eventVO);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
	}

	@Override
	public EventVO findByPrimaryKey(EventPK pk) {
		EventVO eventVO =null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			eventVO = (EventVO) session.get(EventVO.class, pk);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return eventVO;
	}

	@Override
	public List<EventVO> getAll() {
		List<EventVO> list = null;
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

	public static void main(String[] args) {
		EventDAOimpl dao = new EventDAOimpl();
		
		EventVO eventVO = new EventVO();
		EventPK pk = new EventPK();
		pk.setContestID(4);
//		pk.setEventID(6);
		eventVO.setEventPK(pk);
		dao.insert(eventVO);
//		dao.delete(pk);
//		EventVO event = dao.findByPrimaryKey(pk);
//		System.out.println(event.getEventPK().getContestID());
//		System.out.println(event.getEventPK().getEventID());
	}

}
