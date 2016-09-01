package _05model.contest;

import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;

import _05hibernate.util.HibernateUtil;
import _05model.event.EventVO;

public class ContestDAOimpl implements ContestDAO {
	private static final String GET_ALL_STMT = "from ContestVO order by contestID";

	@Override
	public void insert(ContestVO contestVO) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(contestVO);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
	}

	@Override
	public void update(ContestVO contestVO) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(contestVO);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
	}

	@Override
	public void delete(Integer contestID) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			ContestVO contestVO = (ContestVO) session.get(ContestVO.class, contestID);
			session.delete(contestVO);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
	}

	@Override
	public ContestVO findByPrimaryKey(Integer contestID) {
		ContestVO contestVO = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			contestVO = (ContestVO) session.get(ContestVO.class, contestID);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return contestVO;
	}

	@Override
	public List<ContestVO> getAll() {
		List<ContestVO> list = null;
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

//	@Override
//	public Set<EmpVO> getEmpsByDeptno(Integer contestID) {		
//		Set<EmpVO>	set = findByPrimaryKey(contestID).getEmps();
//		return set;
//	}
	public static void main  (String []args){
		ContestDAOimpl dao = new ContestDAOimpl();
//		ContestVO contestVO = new ContestVO();
//		contestVO.setContestName("hibernate3");
//		contestVO.setPlace("干你屁事");
//		contestVO.setStartDate(Date.valueOf("2016-3-13"));
//		dao.delete(6);
//		dao.insert(contestVO);
		List<ContestVO> list = dao.getAll();
		for(ContestVO item:list){
//			System.out.printf("10%s",item.getContestID());
			System.out.printf("賽事:10%s",item.getContestName());
			System.out.printf("地點:10%s\n",item.getPlace());
			Set <EventVO> events = item.getEvents();
			for(EventVO event :events){
//				System.out.printf("10%s\n",event.getEventID());
				System.out.printf("項目:10%s\n",event.getEventName());
			}
		}
	}
}
