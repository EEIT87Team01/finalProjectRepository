package iii.runninglife.model.location;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import iii.runninglife.model.city.CityVO;

@Repository
@Transactional
public class LocationDAO implements LocationInterface{
	
	private static final String GET_ALL_STMT = "from LocationVO where locationID = ?";

	@Autowired
	SessionFactory sessionFactory;
		
	public LocationDAO() { super(); }
	public SessionFactory getSessionFactory() {	return sessionFactory; }
	public void setSessionFactory(SessionFactory sessionFactory) { this.sessionFactory = sessionFactory; }
	
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
		Criteria cri =  sessionFactory.getCurrentSession()
				.createCriteria(LocationVO.class).add(Restrictions.eq("locationID", locationPK));
		return (LocationVO)cri.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<LocationVO> selectAll(String cityID) {
		Criteria cri =  sessionFactory.getCurrentSession().createCriteria(LocationVO.class)
				.add(Restrictions.eq("locationID.cityID.cityID.cityID", cityID));
		List<LocationVO> list = cri.list();
		
		return list;
	}
	
}
