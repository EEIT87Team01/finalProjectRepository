package _05model.contest;

import java.sql.Date;
import java.text.ParseException;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Subqueries;
import org.springframework.stereotype.Service;

import _05hibernate.util.HibernateUtil;
import _05model.event.EventVO;

@Service
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
			// throw ex;
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

	public List<ContestVO> page() {
		List<ContestVO> list = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			DetachedCriteria dc = DetachedCriteria.forClass(ContestVO.class,"assignment");
//			dc.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);

			dc.setProjection(Projections.projectionList().add(Projections.property("assignment.contestID")));
//			dc.setProjection(Projections.id());
			dc.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
			
//			
			Criteria criteria = session.createCriteria(ContestVO.class,"contest");
			criteria.add(Subqueries.propertyIn("contest.contestID", dc));
//			criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
			
			
//			Criteria criteria = dc.getExecutableCriteria(session);

			criteria.setFirstResult(1);
			criteria.setMaxResults(50);
			list = criteria.list();
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}

		return list;
	}

	// @Override
	// public Set<EmpVO> getEmpsByDeptno(Integer contestID) {
	// Set<EmpVO> set = findByPrimaryKey(contestID).getEmps();
	// return set;
	// }
	public static void main(String[] args) throws ParseException {
		ContestDAOimpl dao = new ContestDAOimpl();
//		ContestVO contest = dao.findByPrimaryKey(1);
		// dao.delete(1);
//		ContestVO contestVO = new ContestVO();
//		contestVO.setContestName("hibernate3");
//		contestVO.setPlace("干你屁事");
//		contestVO.setStartDate(Date.valueOf("2016-3-13"));
		// dao.delete(6);
//		dao.insert(contestVO);
		 List<ContestVO> list = dao.getAll();
		 for(ContestVO item:list){
		// System.out.printf("10%s",item.getContestID());
		 System.out.printf("賽事:%s",item.getContestName());
		 System.out.printf("地點:%s\n",item.getPlace());
		 System.out.printf("報名開始:%s\n",item.getRegistrationBegin());
		 System.out.printf("報名結束:%s\n",item.getRegistrationEnd());
		 Set <EventVO> events = item.getEvents();
		 for(EventVO event :events){
		// System.out.printf("10%s\n",event.getEventID());
		 System.out.printf("項目:%s\n",event.getEventName());
		 }
		 }
	}
}
