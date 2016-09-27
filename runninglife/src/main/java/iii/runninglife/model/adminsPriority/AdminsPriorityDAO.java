package iii.runninglife.model.adminsPriority;

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
public class AdminsPriorityDAO implements AdminsPriorityInterface{

	private static final String GET_ALL_STMT = "from AdminsPriorityVO order by levelID";
	
	@Autowired
	SessionFactory sessionFactory;
		
	public AdminsPriorityDAO() { super(); }
	public SessionFactory getSessionFactory() {	return sessionFactory; }
	public void setSessionFactory(SessionFactory sessionFactory) { this.sessionFactory = sessionFactory; }
	
	@Override
	public void insert(AdminsPriorityVO adminsPriorityVO) {
		sessionFactory.getCurrentSession().saveOrUpdate(adminsPriorityVO);
	}

	@Override
	public void update(AdminsPriorityVO adminsPriorityVO) {
		sessionFactory.getCurrentSession().saveOrUpdate(adminsPriorityVO);
	}

	@Override
	public void delete(String adminsPriorityVO) {
		Session session = sessionFactory.getCurrentSession();
		AdminsPriorityVO adminsPriorityBean = (AdminsPriorityVO)session.get(AdminsPriorityVO.class,adminsPriorityVO);
		session.delete(adminsPriorityBean);
	}

	@Override
	public AdminsPriorityVO selectOne(String adminsPriorityVO) {
		Criteria cri =  sessionFactory.getCurrentSession()
				.createCriteria(AdminsPriorityVO.class).add(Restrictions.eq("levelID", adminsPriorityVO));
		
		return (AdminsPriorityVO)cri.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<AdminsPriorityVO> selectAll() {
		Query query = sessionFactory.getCurrentSession().createQuery(GET_ALL_STMT); 
		return query.list();
	}

}
