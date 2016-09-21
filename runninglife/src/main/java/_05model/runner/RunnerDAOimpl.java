package _05model.runner;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Service;

import _05hibernate.util.HibernateUtil;

@Service
public class RunnerDAOimpl implements RunnerDAO {
	private static final String GET_ALL_STMT = "from RunnerVO order by memberID ";
	private static final String GET_ALL_LIST_BY_CONTESTID = "from RunnerVO where contestID = :contestID order by memberID";
	private static final String GET_MY_CONTEST = "from RunnerVO where memberID = :memberID order by contestID";
	private static final String GET_SCORE_GROUP = "from RunnerVO where contestID = :contestID and eventID = :eventID and teamID=:teamID" ;
	private static final String GET_EVENT_GROUP = "from RunnerVO where eventID = :eventID";
	private static final String GET_TEAM_GROUP = "from RunnerVO where teamID =:teamID";

	@Override
	public String insert(RunnerVO runnerVO) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.save(runnerVO);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			System.out.println(ex.getMessage());
			return "已經報名過了";
		}
		return "報名成功";
	}

	@Override
	public void update(RunnerVO runnerVO) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(runnerVO);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
	}

	@Override
	public void delete(RunnerPK pk) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			RunnerVO runnerVO = (RunnerVO) session.get(RunnerVO.class, pk);
			session.delete(runnerVO);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
	}

	@Override
	public RunnerVO findByPrimaryKey(RunnerPK pk) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		RunnerVO runnerVO = null;
		try {
			session.beginTransaction();
			runnerVO = (RunnerVO) session.get(RunnerVO.class, pk);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return runnerVO;
	}

	@Override
	public List<RunnerVO> getAll() {
		List<RunnerVO> list = null;
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
	
	public List<RunnerVO> getList(Integer contestID) {
		List<RunnerVO> list = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			Query query = session.createQuery(GET_ALL_LIST_BY_CONTESTID);
			query.setParameter("contestID", contestID);
			list = query.list();
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return list;
	}

	public List<RunnerVO> getMyContest(String memberID) {
		List<RunnerVO> list = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			Query query = session.createQuery(GET_MY_CONTEST);
			query.setParameter("memberID", memberID);
			list = query.list();
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return list;
	}

	public List<RunnerVO> getScoreGroup(Integer contestID ,Integer eventID, Integer teamID) {
		List<RunnerVO> list = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			Query query = session.createQuery(GET_SCORE_GROUP);
			query.setParameter("contestID", contestID);
			query.setParameter("eventID", eventID);
			query.setParameter("teamID", teamID);
			list = query.list();
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return list;
	}

	public List<RunnerVO> getEventGroup(Integer eventID) {
		List<RunnerVO> list = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			Query query = session.createQuery(GET_EVENT_GROUP);
			query.setParameter("eventID", eventID);
			list = query.list();
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return list;
	}

	public List<RunnerVO> getTeamGroup(Integer teamID) {
		List<RunnerVO> list = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			Query query = session.createQuery(GET_TEAM_GROUP);
			query.setParameter("teamID", teamID);
			list = query.list();
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return list;
	}

	public static void main(String[] args) {
		RunnerDAOimpl dao = new RunnerDAOimpl();
		List<RunnerVO>list = dao.getScoreGroup(1 ,1, 3);
		for(RunnerVO a :list){
			System.out.println(a);
		}

	}

}
