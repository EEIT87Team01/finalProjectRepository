package _05model.contest;

import java.sql.Date;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import _05hibernate.util.HibernateUtil;

@Service
public class ContestDAOimpl implements ContestDAO {
	private static final String GET_ALL_STMT = "from ContestVO order by contestID";
	private String countContest = "Select count(*) from ContestVO";

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

	public List<ContestVO> page(Integer page) {
		List<ContestVO> list = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Integer pageSize = 10;
		try {
			session.beginTransaction();
			Query countQuery = session.createQuery(countContest);
			Long countResults = (Long) countQuery.uniqueResult();
			
//			int lastPageNumber = (int) ((countResults / pageSize) + 1);

			Query query = session.createQuery(GET_ALL_STMT);
			query.setFirstResult((page - 1) * pageSize);
			query.setMaxResults(pageSize);
			list = query.list();
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}

		return list;
	}
	public List<ContestVO>date(){
		List<ContestVO> list = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try{
			session.beginTransaction();
			Criteria criteria = session.createCriteria(ContestVO.class);
			criteria.add(Restrictions.between("startDate", Date.valueOf("2016-01-01"), Date.valueOf("2016-10-01")));
			
			
			list=criteria.list();
			session.getTransaction().commit();
		}catch(RuntimeException ex){
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
		List<ContestVO> list = new ArrayList<>();
		list =dao.date();
		for(ContestVO a: list){
			System.out.println(a);
		}

	}
}
