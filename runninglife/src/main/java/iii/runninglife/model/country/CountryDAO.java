package iii.runninglife.model.country;

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
public class CountryDAO implements CountryInterface{
	
	private static final String GET_ALL_STMT = "from CountryVO order by countryID";

	@Autowired
	SessionFactory sessionFactory;
		
	public CountryDAO() { super(); }
	public SessionFactory getSessionFactory() {	return sessionFactory; }
	public void setSessionFactory(SessionFactory sessionFactory) { this.sessionFactory = sessionFactory; }
	
	@Override
	public void insert(CountryVO countryVO) {
		sessionFactory.getCurrentSession().saveOrUpdate(countryVO);
	}

	@Override
	public void update(CountryVO countryVO) {
		sessionFactory.getCurrentSession().saveOrUpdate(countryVO);
	}

	@Override
	public void delete(String countryVO) {
		Session session = sessionFactory.getCurrentSession();
		CountryVO countryBean = (CountryVO)session.get(CountryVO.class,countryVO);
		session.delete(countryBean);
	}

	@Override
	public CountryVO selectOne(String countryVO) {
		Criteria cri =  sessionFactory.getCurrentSession()
				.createCriteria(CountryVO.class).add(Restrictions.eq("countryID", countryVO));
		
		return (CountryVO)cri.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CountryVO> selectAll() {
		Query query = sessionFactory.getCurrentSession().createQuery(GET_ALL_STMT); 
		return query.list();
	}
	
}
