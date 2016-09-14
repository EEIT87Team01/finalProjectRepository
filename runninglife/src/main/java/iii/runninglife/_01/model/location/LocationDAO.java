package iii.runninglife._01.model.location;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("LocationDAO")
public class LocationDAO implements LocationInterface{
	
	private static final String GET_ALL_STMT = "from LocationVO order by locationID";
	
	@Autowired
	SessionFactory sessionFactory;
	
	public LocationDAO() {super();}
	public LocationDAO(SessionFactory sessionFactory) {this.sessionFactory = sessionFactory;}
	public SessionFactory getSessionFactory() {return sessionFactory;}
	public void setSessionFactory(SessionFactory sessionFactory) {this.sessionFactory = sessionFactory;}

	@Override
	public void insert(LocationVO locationVO) {
		sessionFactory.getCurrentSession().saveOrUpdate(locationVO);
	}

	@Override
	public void update(LocationVO locationVO) {
		sessionFactory.getCurrentSession().saveOrUpdate(locationVO);
	}

	@Override
	public void delete(LocationPK locationPK) {
		Session session = sessionFactory.getCurrentSession();
		LocationVO locationBean = (LocationVO)session.get(LocationVO.class,locationPK);
		session.delete(locationBean);
			
	}

	@Override
	public LocationVO selectOne(LocationPK locationPK) {
		Session session = sessionFactory.getCurrentSession();
		return (LocationVO)session.get(LocationVO.class, locationPK);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<LocationVO> selectAll(LocationVO locationVO) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(GET_ALL_STMT); 
		return query.list();
	}
	
}
