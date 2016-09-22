package _05model.team;

import java.util.List;

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
public  class TeamDAOimpl implements TeamDAO {
	private static final String GET_ALL_STMT = "from TeamVO order by ageRange";
	
    @Autowired
    private SessionFactory sessionFactory;
 
    protected Session getSession(){
        return sessionFactory.getCurrentSession();
    }
    
	@Override
	public void insert(TeamVO teamVO) {
		Session session = getSession();
		try {
			session.saveOrUpdate(teamVO);
		} catch (RuntimeException ex) {
			throw ex;
		}
	}
//	@Override
//	public void insert(TeamVO teamVO) {
//		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
//		try {
//			session.beginTransaction();
//			session.saveOrUpdate(teamVO);
//			session.getTransaction().commit();
//		} catch (RuntimeException ex) {
//			session.getTransaction().rollback();
//			throw ex;
//		}
//	}
	@Override
	public void update(TeamVO teamVO) {
		Session session = getSession();
		try {
			session.saveOrUpdate(teamVO);
		} catch (RuntimeException ex) {
			throw ex;
		}
	}
//	@Override
//	public void update(TeamVO teamVO) {
//		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
//		try {
//			session.beginTransaction();
//			session.saveOrUpdate(teamVO);
//			session.getTransaction().commit();
//		} catch (RuntimeException ex) {
//			session.getTransaction().rollback();
//			throw ex;
//		}
//	}
	@Override
	public void delete(Integer teamID) {
		RunnerDAOimpl runnerDAO = new RunnerDAOimpl();
		List<RunnerVO>list =runnerDAO.getTeamGroup(teamID);
		Session session = getSession();
		try {
			TeamVO teamVO = (TeamVO) session.get(TeamVO.class, teamID);
			session.delete(teamVO);
		} catch (RuntimeException ex) {
			throw ex;
		}
	}
//	@Override
//	public void delete(Integer teamID) {
//		RunnerDAOimpl runnerDAO = new RunnerDAOimpl();
//		List<RunnerVO>list =runnerDAO.getTeamGroup(teamID);
//		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
//		try {
//			session.beginTransaction();
//			TeamVO teamVO = (TeamVO) session.get(TeamVO.class, teamID);
//			session.delete(teamVO);
//			session.getTransaction().commit();
//		} catch (RuntimeException ex) {
//			session.getTransaction().rollback();
//			throw ex;
//		}
//	}

	@Override
	public TeamVO findByPrimaryKey(Integer teamID) {
		TeamVO teamVO = null;
		Session session = getSession();
		try {
			teamVO = (TeamVO) session.get(TeamVO.class, teamID);
		} catch (RuntimeException ex) {
			throw ex;
		}
		return teamVO;
	}
//	@Override
//	public TeamVO findByPrimaryKey(Integer teamID) {
//		TeamVO teamVO = null;
//		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
//		try {
//			session.beginTransaction();
//			teamVO = (TeamVO) session.get(TeamVO.class, teamID);
//			session.getTransaction().commit();
//		} catch (RuntimeException ex) {
//			session.getTransaction().rollback();
//			throw ex;
//		}
//		return teamVO;
//	}

	@Override
	public List<TeamVO> getAll() {
		List<TeamVO> list = null;
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
//	public List<TeamVO> getAll() {
//		List<TeamVO> list = null;
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
	public List<TeamVO> getTeamById(Integer contestID) {
		List<TeamVO> list = null;
		Session session = getSession();
		try {
			Query query = session.createQuery("from TeamVO where contestID = ? order by ageRange desc");
			query.setParameter(0, contestID);
			list = query.list();
		} catch (RuntimeException ex) {
			throw ex;
		}
		return list;
	}
//	@Override
//	public List<TeamVO> getTeamById(Integer contestID) {
//		List<TeamVO> list = null;
//		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
//		try {
//			session.beginTransaction();
//			Query query = session.createQuery("from TeamVO where contestID = ? order by ageRange desc");
//			query.setParameter(0, contestID);
//			list = query.list();
//			session.getTransaction().commit();
//		} catch (RuntimeException ex) {
//			session.getTransaction().rollback();
//			throw ex;
//		}
//		return list;
//	}

	public static void main(String[] args) {
		TeamVO teamvo = new TeamVO()	;
		teamvo.setTeamName("男子組");
		teamvo.setContestID(1);
		teamvo.setAgeRange(25);
		TeamDAOimpl dao = new TeamDAOimpl();
		dao.insert(teamvo);
		List<TeamVO> list =dao.getTeamById(1);
		for(TeamVO aList:list){
			System.out.println(aList.getTeamID());
		}
	}

}
