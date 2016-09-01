package _05model.event;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;

import _05hibernate.util.HibernateUtil;
import _05model.contest.ContestVO;
@Service
public class EventDAOimpl implements EventDAO {
	private static final String GET_ALL_STMT = "from EventVO order by eventID";
	
	@Override
	public void insert(EventVO eventVO) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			//自動生成eventID
			//取最大值+1
//			Query query  = session.createQuery(" from EventVO where contestID=:contestID order by eventID desc");
//			query.setParameter("contestID",eventVO.getEventPK().getContestID());
//			List<EventVO> events =query.list();
//			int eventID=0;
//			if(!events.isEmpty()){
//			eventID=events.get(0).getEventPK().getEventID();
//			}
//			eventVO.getEventPK().setEventID(eventID+1);
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
	public void delete(Integer eventID) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			EventVO eventVO = (EventVO) session.get(EventVO.class, eventID);
			session.delete(eventVO);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
	}

	@Override
	public EventVO findByPrimaryKey(Integer eventID) {
		EventVO eventVO =null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			eventVO = (EventVO) session.get(EventVO.class, eventID);
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
		eventVO.setContestID(1);
		dao.insert(eventVO);
//		dao.delete(5);
	}

}
