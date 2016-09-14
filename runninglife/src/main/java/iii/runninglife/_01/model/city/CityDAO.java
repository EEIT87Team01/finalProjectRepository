package iii.runninglife._01.model.city;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("CityDAO")
public class CityDAO implements CityInterface{
	
	private static final String GET_ALL_STMT = "from CityVO";
	
	@Autowired
	SessionFactory sessionFactory;

	public CityDAO() { super(); }
	public CityDAO(SessionFactory sessionFactory) {	this.sessionFactory = sessionFactory; }
	public SessionFactory getSessionFactory() {	return sessionFactory; }
	public void setSessionFactory(SessionFactory sessionFactory) { this.sessionFactory = sessionFactory; }

	@Override
	public void insert(CityVO cityVO) {
		sessionFactory.getCurrentSession().saveOrUpdate(cityVO);
	}

	@Override
	public void update(CityVO cityVO) {
		sessionFactory.getCurrentSession().saveOrUpdate(cityVO);
	}

	@Override
	public void delete(CityPK CityPK) {
		Session session = sessionFactory.getCurrentSession();
		CityVO cityBean = (CityVO)session.get(CityVO.class,CityPK);
		session.delete(cityBean);
	}

	@Override
	public CityVO selectOne(CityPK cityPK) {
		Session session = sessionFactory.getCurrentSession();
		return (CityVO)session.get(CityVO.class,cityPK);
	}

	@Override
	public List<CityVO> selectAll() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(GET_ALL_STMT); 
		return query.list();
	}
	
}
