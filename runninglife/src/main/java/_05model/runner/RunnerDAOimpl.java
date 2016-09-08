package _05model.runner;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Service;

import _05hibernate.util.HibernateUtil;
@Service
public class RunnerDAOimpl implements RunnerDAO {
	private static final String GET_ALL_STMT = "from RunnerVO order by runnerID ";
	@Override
	public String insert(RunnerVO runnerVO) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.save(runnerVO);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			return "已經報名過了";
		}
		return "成功";
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
			RunnerVO contestVO = (RunnerVO) session.get(RunnerVO.class, pk);
			session.delete(contestVO);
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

	public static void main(String[] args) {
		RunnerDAOimpl dao = new RunnerDAOimpl();
		RunnerVO runner = new RunnerVO();
		RunnerPK pk = new RunnerPK();
		pk.setContestID(1);
		pk.setMemberID("arthur");
		runner.setPk(pk);
		runner.setEventID(3);
		runner.setTeamID(30);
//		runner.setContestID(1);
//		runner.setRunTime(Time.valueOf("22:22:22"));
//		dao.delete(pk);
		dao.insert(runner);
		RunnerVO list =dao.findByPrimaryKey(pk);
		System.out.println(list.getPk().getContestID());
	}

}
