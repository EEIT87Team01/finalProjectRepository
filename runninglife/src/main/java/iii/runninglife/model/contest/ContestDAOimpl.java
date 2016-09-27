package iii.runninglife.model.contest;

import java.sql.Date;
import java.text.ParseException;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
@Repository
@Transactional
public class ContestDAOimpl  implements ContestDAO  {
	private static final String GET_ALL_STMT = "from ContestVO order by startDate desc";
	private String countContest = "Select count(*) from ContestVO";
	private static final String GET_ALL_BETWEEN_DATE = "from ContestVO where startDate between :stDate and :edDate  order by startDate desc";
	private static final String COUNT_ALL_BETWEEN_DATE = "Select count(*) from ContestVO where startDate between :stDate and :edDate ";
	private static final String FIND_BY_PRIMARYKEY = "from ContestVO where contestID=:contestID";
	
	
    @Autowired
    private SessionFactory sessionFactory;
 
    protected Session getSession(){
        return sessionFactory.getCurrentSession();
    }
//	@Override
//	public void insert(ContestVO contestVO) {
//		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
//		try {
//			session.beginTransaction();
//			session.saveOrUpdate(contestVO);
//			session.getTransaction().commit();
//		} catch (RuntimeException ex) {
//			session.getTransaction().rollback();
//			throw ex;
//		}
//	}
	@Override
	public void insert(ContestVO contestVO) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.saveOrUpdate(contestVO);
		} catch (RuntimeException ex) {
			throw ex;
		}
	}
	
//	@Override
//	public void update(ContestVO contestVO) {
//		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
//		try {
//			session.beginTransaction();
//			session.saveOrUpdate(contestVO);
//			session.getTransaction().commit();
//		} catch (RuntimeException ex) {
//			session.getTransaction().rollback();
//			throw ex;
//		}
//	}
	@Override
	public void update(ContestVO contestVO) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.saveOrUpdate(contestVO);
		} catch (RuntimeException ex) {
			throw ex;
		}
	}

//	@Override
//	public void delete(Integer contestID) {
//		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
//		try {
//			session.beginTransaction();
//			ContestVO contestVO = (ContestVO) session.get(ContestVO.class, contestID);
//			session.delete(contestVO);
//			session.getTransaction().commit();
//		} catch (RuntimeException ex) {
//			session.getTransaction().rollback();
//			// throw ex;
//		}
//	}
	@Override
	public void delete(Integer contestID) {
		Session session = sessionFactory.getCurrentSession();
		try {
			ContestVO contestVO = (ContestVO) session.get(ContestVO.class, contestID);
			session.delete(contestVO);
		} catch (RuntimeException ex) {
			// throw ex;
		}
	}
//	@Override
//	public ContestVO findByPrimaryKey(Integer contestID) {
//		ContestVO contestVO = null;
//		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
//		try {
//			session.beginTransaction();
//			contestVO = (ContestVO) session.get(ContestVO.class, contestID);
//			session.getTransaction().commit();
//		} catch (RuntimeException ex) {
//			session.getTransaction().rollback();
//			throw ex;
//		}
//		return contestVO;
//	}
	@Override
	public ContestVO findByPrimaryKey(Integer contestID) {
		ContestVO contestVO = null;
		Session session = sessionFactory.getCurrentSession();
		try {
			contestVO = (ContestVO) session.get(ContestVO.class, contestID);
		} catch (RuntimeException ex) {
			throw ex;
		}
		return contestVO;
	}
//	@Override
//	public List findByPrimaryKey2(Integer contestID) {
//		List<ContestVO> list = null;
//		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
//		try {
//			session.beginTransaction();
//			Query query = session.createQuery(FIND_BY_PRIMARYKEY);
//			query.setParameter("contestID", contestID);
//			list =  query.list();
//			session.getTransaction().commit();
//		} catch (RuntimeException ex) {
//			session.getTransaction().rollback();
//			throw ex;
//		}
//		return list;
//	}
	@Override
	public List findByPrimaryKey2(Integer contestID) {
		List<ContestVO> list = null;
		Session session = sessionFactory.getCurrentSession();
		try {
			Query query = session.createQuery(FIND_BY_PRIMARYKEY);
			query.setParameter("contestID", contestID);
			list =  query.list();
		} catch (RuntimeException ex) {
			throw ex;
		}
		return list;
	}

//	@Override
//	public List<ContestVO> getAll() {
//		List<ContestVO> list = null;
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
	public List<ContestVO> getAll() {
		List<ContestVO> list = null;
		Session session = sessionFactory.getCurrentSession();
		try {
			Query query = session.createQuery(GET_ALL_STMT);
			list = query.list();
		} catch (RuntimeException ex) {
			throw ex;
		}
		return list;
	}

//	public List<ContestVO> page(Integer page) {
//		List<ContestVO> list = null;
//		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
//		Integer pageSize = 5;
//		try {
//			session.beginTransaction();
//			Query countQuery = session.createQuery(countContest);
//			Long countResults = (Long) countQuery.uniqueResult();
//			// int lastPageNumber = (int) ((countResults / pageSize) + 1);
//			Query query = session.createQuery(GET_ALL_STMT);
//			query.setFirstResult((page - 1) * pageSize);
//			query.setMaxResults(pageSize);
//			list = query.list();
//			session.getTransaction().commit();
//		} catch (RuntimeException ex) {
//			session.getTransaction().rollback();
//			throw ex;
//		}
//
//		return list;
//	}
	public List<ContestVO> page(Integer page) {
		List<ContestVO> list = null;
		Session session = sessionFactory.getCurrentSession();
		Integer pageSize = 5;
		try {
			Query countQuery = session.createQuery(countContest);
			Long countResults = (Long) countQuery.uniqueResult();
			// int lastPageNumber = (int) ((countResults / pageSize) + 1);
			Query query = session.createQuery(GET_ALL_STMT);
			query.setFirstResult((page - 1) * pageSize);
			query.setMaxResults(pageSize);
			list = query.list();
		} catch (RuntimeException ex) {
			throw ex;
		}
		
		return list;
	}

//	public int countPage() {
//		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
//		Integer pageSize = 5;
//		int lastPageNumber;
//		try {
//			session.beginTransaction();
//			Query countQuery = session.createQuery(countContest);
//			Long countResults = (Long) countQuery.uniqueResult();
//			lastPageNumber = (int) ((countResults / pageSize) + 1);
//			session.getTransaction().commit();
//		} catch (RuntimeException ex) {
//			session.getTransaction().rollback();
//			throw ex;
//		}
//		return lastPageNumber;
//	}
	public int countPage() {
		Session session = getSession()	;
		Integer pageSize = 5;
		int lastPageNumber;
		try {
			Query countQuery = session.createQuery(countContest);
			Long countResults = (Long) countQuery.uniqueResult();
			lastPageNumber = (int) ((countResults / pageSize) + 1);
		} catch (RuntimeException ex) {
			throw ex;
		}
		return lastPageNumber;
	}
//	public List<ContestVO> date() {
//		List<ContestVO> list = null;
//		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
//		try {
//			session.beginTransaction();
//			Criteria criteria = session.createCriteria(ContestVO.class);
//			criteria.add(Restrictions.between("startDate", Date.valueOf("2016-01-01"), Date.valueOf("2016-10-01")));
//
//			list = criteria.list();
//			session.getTransaction().commit();
//		} catch (RuntimeException ex) {
//			session.getTransaction().rollback();
//			throw ex;
//		}
//		return list;
//	}
	public List<ContestVO> date(String memberID ,Date stDate,Date edDate) {
		List<ContestVO> list = null;
		Session session =getSession();
		try {
			Criteria criteria = session.createCriteria(ContestVO.class);
			criteria.add(Restrictions.between("startDate", stDate, edDate));
			criteria.add(Restrictions.eq("memberID",memberID ));
			criteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
			list = criteria.list();
		} catch (RuntimeException ex) {
			throw ex;
		}
		return list;
	}

//	public List<ContestVO> date2(Date stDate, Date edDate,Integer page) {
//		List<ContestVO> list = null;
//		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
//		Integer pageSize = 5;
//		try{
//			session.beginTransaction();
//			Query query = session.createQuery(GET_ALL_BETWEEN_DATE);
//			query.setFirstResult((page - 1) * pageSize);
//			query.setMaxResults(pageSize);
//			query.setParameter("stDate", stDate);
//			query.setParameter("edDate", edDate);
//			list = query.list();
//			session.getTransaction().commit();
//		}catch (RuntimeException ex) {
//			session.getTransaction().rollback();
//			throw ex;
//		}
//		return list;
//	}
	public List<ContestVO> date2(Date stDate, Date edDate,Integer page) {
		List<ContestVO> list = null;
		Session session = getSession();
		Integer pageSize = 5;
		try{
			Query query = session.createQuery(GET_ALL_BETWEEN_DATE);
			query.setFirstResult((page - 1) * pageSize);
			query.setMaxResults(pageSize);
			query.setParameter("stDate", stDate);
			query.setParameter("edDate", edDate);
			list = query.list();
		}catch (RuntimeException ex) {
			throw ex;
		}
		return list;
	}
	
	
//	public int countPageBetweenDate(Integer year, Integer month) {
//		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
//		Integer pageSize = 5;
//		int lastPageNumber;
//		Date stDate = Date.valueOf(year+"-"+month+"-01");
//		if(month==12){
//			year++;
//			month=0;
//		}
//		Date edDate = Date.valueOf(year+"-"+(month+1)+"-01");
//		try {
//			session.beginTransaction();
//			Query countQuery = session.createQuery(COUNT_ALL_BETWEEN_DATE);
//			countQuery.setParameter("stDate", stDate);
//			countQuery.setParameter("edDate", edDate);
//			Long countResults = (Long) countQuery.uniqueResult();
//			lastPageNumber = (int) ((countResults / pageSize) + 1);
//			session.getTransaction().commit();
//		} catch (RuntimeException ex) {
//			session.getTransaction().rollback();
//			throw ex;
//		}
//		return lastPageNumber;
//	}
	public int countPageBetweenDate(Integer year, Integer month) {
		Session session = getSession();
		Integer pageSize = 5;
		int lastPageNumber;
		Date stDate = Date.valueOf(year+"-"+month+"-01");
		if(month==12){
			year++;
			month=0;
		}
		Date edDate = Date.valueOf(year+"-"+(month+1)+"-01");
		try {
			Query countQuery = session.createQuery(COUNT_ALL_BETWEEN_DATE);
			countQuery.setParameter("stDate", stDate);
			countQuery.setParameter("edDate", edDate);
			Long countResults = (Long) countQuery.uniqueResult();
			lastPageNumber = (int) ((countResults / pageSize) + 1);
		} catch (RuntimeException ex) {
			throw ex;
		}
		return lastPageNumber;
	}

	public static void main(String[] args) throws ParseException {
		ContestDAOimpl dao = new ContestDAOimpl();
//		List<ContestVO> list = new ArrayList<>();
//		list = dao.date();
//		for (ContestVO a : list) {
//			System.out.println(a);
//		}
		
//		List<ContestVO>list =dao.date2(Date.valueOf("2016-09-10"), Date.valueOf("2016-10-10"),2);
//		for(ContestVO a:list){
//			
//			System.out.println(a.getStartDate());
//		}
	}
}
