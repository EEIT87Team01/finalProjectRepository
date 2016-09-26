package iii.runninglife.model.admins;

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
public class AdminsDAO implements AdminsInterface{
	
	private static final String GET_ALL_STMT = "from AdminsVO order by adminAccount";
	
	@Autowired
	SessionFactory sessionFactory;
		
	public AdminsDAO() { super(); }
	public SessionFactory getSessionFactory() {	return sessionFactory; }
	public void setSessionFactory(SessionFactory sessionFactory) { this.sessionFactory = sessionFactory; }
	
	@Override
	public void insert(AdminsVO adminsVO) {
		sessionFactory.getCurrentSession().saveOrUpdate(adminsVO);
	}

	@Override
	public void update(AdminsVO adminsVO) {
		sessionFactory.getCurrentSession().saveOrUpdate(adminsVO);
	}

	@Override
	public void delete(String adminsVO) {
		Session session = sessionFactory.getCurrentSession();
		AdminsVO adminsBean = (AdminsVO)session.get(AdminsVO.class,adminsVO);
		session.delete(adminsBean);
	}

	@Override
	public AdminsVO selectOne(String adminsVO) {
		Criteria cri =  sessionFactory.getCurrentSession()
				.createCriteria(AdminsVO.class).add(Restrictions.eq("adminAccount", adminsVO));
		
		return (AdminsVO)cri.uniqueResult();
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<AdminsVO> selectAll() {
		Query query = sessionFactory.getCurrentSession().createQuery(GET_ALL_STMT); 
		return query.list();
	}

}
