package iii.runninglife._01.model.adminsPriority;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("AdminsPriorityDAO")
public class AdminsPriorityDAO implements AdminsPriorityInterface{

	private static final String GET_ALL_STMT = "from AdminsPriorityVO order by levelID";
	
	@Autowired
	SessionFactory sessionFactory;
	
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
		AdminsPriorityVO adminsPriorityBean = 
				(AdminsPriorityVO)session.get(AdminsPriorityVO.class,adminsPriorityVO);
		session.delete(adminsPriorityBean);
	}

	@Override
	public AdminsPriorityVO selectOne(String adminsPriorityVO) {
		Session session = sessionFactory.getCurrentSession();
		return (AdminsPriorityVO)session.get(AdminsPriorityVO.class,adminsPriorityVO);
	}

	@Override
	public List<AdminsPriorityVO> selectAll() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(GET_ALL_STMT); 
		return query.list();
	}

}
