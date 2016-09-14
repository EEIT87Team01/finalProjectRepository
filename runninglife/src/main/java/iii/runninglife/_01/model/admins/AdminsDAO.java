package iii.runninglife._01.model.admins;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("AdminsDAO")
public class AdminsDAO implements AdminsInterface{
	
	private static final String GET_ALL_STMT = "from AdminsVO order by adminAccount";
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public AdminsDAO() { super(); }
	public AdminsDAO(SessionFactory sessionFactory) { this.sessionFactory = sessionFactory; }
	public SessionFactory getSessionFactory() {	return sessionFactory; }
	public void setSessionFactory(SessionFactory sessionFactory) { this.sessionFactory = sessionFactory; }
	
	@Override
	public void insert(AdminsVO adminsVO) {
		sessionFactory.getCurrentSession().saveOrUpdate(adminsVO);
	}

	@Override
	public void update(AdminsVO adminsVO) {
		AdminsVO adminsBean = (AdminsVO)sessionFactory.getCurrentSession().get(AdminsVO.class,adminsVO);
		sessionFactory.getCurrentSession().delete(adminsBean);
	}

	@Override
	public void delete(String adminsVO) {
		AdminsVO adminsBean = (AdminsVO)sessionFactory.getCurrentSession().get(AdminsVO.class,adminsVO);
		sessionFactory.getCurrentSession().delete(adminsBean);
	}

	@Override
	public AdminsVO selectOne(String adminsVO) {
		AdminsVO adminsBean = (AdminsVO)sessionFactory.getCurrentSession().get(AdminsVO.class,adminsVO);
		return adminsBean;
	}

	@Override
	public List<AdminsVO> selectAll() {
		Query query = sessionFactory.getCurrentSession().createQuery(GET_ALL_STMT); 
		return query.list();
	}

}
