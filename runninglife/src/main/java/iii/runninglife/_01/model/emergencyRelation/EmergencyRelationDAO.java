package iii.runninglife._01.model.emergencyRelation;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("EmergencyRelationDAO")
public class EmergencyRelationDAO implements EmergencyRelationInterface {
	
	private static final String GET_ALL_STMT = "from EmergencyRelationVO order by relationID";
	
	@Autowired
	SessionFactory sessionFactory;
	
	public EmergencyRelationDAO() {super();}
	public EmergencyRelationDAO(SessionFactory sessionFactory) {this.sessionFactory = sessionFactory;}
	public SessionFactory getSessionFactory() {return sessionFactory;}
	public void setSessionFactory(SessionFactory sessionFactory) {this.sessionFactory = sessionFactory;}

	@Override
	public void insert(EmergencyRelationVO emergencyRelationVO) {
		sessionFactory.getCurrentSession().saveOrUpdate(emergencyRelationVO);
	}

	@Override
	public void update(EmergencyRelationVO emergencyRelationVO) {
		sessionFactory.getCurrentSession().saveOrUpdate(emergencyRelationVO);
	}

	@Override
	public void delete(int emergencyRelationVO) {
		Session session = sessionFactory.getCurrentSession();
		EmergencyRelationVO emergencyRelationBean = 
				(EmergencyRelationVO)session.get(EmergencyRelationVO.class,emergencyRelationVO);
		session.delete(emergencyRelationBean);
	}

	@Override
	public EmergencyRelationVO selectOne(int emergencyRelationVO) {
		Session session = sessionFactory.getCurrentSession();
		return (EmergencyRelationVO)session.get(EmergencyRelationVO.class,emergencyRelationVO);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<EmergencyRelationVO> selectAll(EmergencyRelationVO emergencyRelationVO) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(GET_ALL_STMT);
		return query.list();
	}

}
