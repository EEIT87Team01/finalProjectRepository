package iii.runninglife.model.city;

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
public class CityDAO implements CityInterface{
	
	private static final String GET_ALL_STMT = "from CityVO where countryID = ? ";
	
	@Autowired
	SessionFactory sessionFactory;
		
	public CityDAO() { super(); }
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
	public void delete(CityPK cityPK) {
		Session session = sessionFactory.getCurrentSession();
		CityVO cityBean = (CityVO)session.get(CityVO.class,cityPK);
		session.delete(cityBean);
	}

	@Override
	public CityVO selectOne(CityPK cityPK) {
		Criteria cri =  sessionFactory.getCurrentSession()
				.createCriteria(CityVO.class).add(Restrictions.eq("cityID", cityPK));
		return (CityVO)cri.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CityVO> selectAll(String countryID) {
		Criteria cri =  sessionFactory.getCurrentSession().createCriteria(CityVO.class)
				.add(Restrictions.eq("cityID.countryID.countryID", countryID));
		List<CityVO> list = cri.list();
		
		return list;
	}
	
}
