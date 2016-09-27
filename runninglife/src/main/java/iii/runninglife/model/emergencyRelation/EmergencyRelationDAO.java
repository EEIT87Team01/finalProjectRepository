package iii.runninglife.model.emergencyRelation;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class EmergencyRelationDAO implements EmergencyRelationInterface {
	
	private static final String GET_ALL_STMT = "from EmergencyRelationVO order by relationID";
	
	@Autowired
	SessionFactory sessionFactory;
		
	public EmergencyRelationDAO() { super(); }
	public SessionFactory getSessionFactory() {	return sessionFactory; }
	public void setSessionFactory(SessionFactory sessionFactory) { this.sessionFactory = sessionFactory; }
	
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
		EmergencyRelationVO emergencyRelationBean = (EmergencyRelationVO)session.get(EmergencyRelationVO.class,emergencyRelationVO);
		session.delete(emergencyRelationBean);
	}

	@Override
	public EmergencyRelationVO selectOne(int emergencyRelationVO) {
		Criteria cri =  sessionFactory.getCurrentSession()
				.createCriteria(EmergencyRelationVO.class).add(Restrictions.eq("relationID", emergencyRelationVO));
		
		return (EmergencyRelationVO)cri.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<EmergencyRelationVO> selectAll(EmergencyRelationVO emergencyRelationVO) {
		Query query = sessionFactory.getCurrentSession().createQuery(GET_ALL_STMT); 
		return query.list();
	}

}
