package iii.runninglife._01.model.country;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import iii.runninglife._01.model.city.CityVO;

@Repository("CountryDAO")
public class CountryDAO implements CountryInterface{
	
	private static final String GET_ALL_STMT = "from CountryVO order by countryID";
	
	SessionFactory sessionFactory;
	
	public CountryDAO() {super();}
	public CountryDAO(SessionFactory sessionFactory) {this.sessionFactory = sessionFactory;}
	public SessionFactory getSessionFactory() {return sessionFactory;}
	public void setSessionFactory(SessionFactory sessionFactory) {this.sessionFactory = sessionFactory;}

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
		Session session = sessionFactory.getCurrentSession();
		return (CountryVO)session.get(CountryVO.class,countryVO);
	}

	@Override
	public List<CountryVO> selectAll() {
		Session session = sessionFactory.getCurrentSession();
		List<CountryVO> list = new ArrayList<CountryVO>();
		Query query = session.createQuery(GET_ALL_STMT);
		return query.list();
	}
	
}
