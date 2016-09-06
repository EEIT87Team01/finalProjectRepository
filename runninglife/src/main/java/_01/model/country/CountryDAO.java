package _01.model.country;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import _01.model.city.CityVO;
import _01.model.hibernate.util.HibernateUtil;

public class CountryDAO implements CountryInterface{
	
	private static final String GET_ALL_STMT = "from CountryVO order by countryID";

	@Override
	public int insert(CountryVO countryVO) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		int count = 0;
		try{
			session.beginTransaction();
			session.saveOrUpdate(countryVO);
			session.getTransaction().commit();
		} catch(RuntimeException ex){
			session.getTransaction().rollback();
			throw ex;
		} 
		count++;
		return count;
	}

	@Override
	public int update(CountryVO countryVO) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		int count = 0;
		try{
			session.beginTransaction();
			session.saveOrUpdate(countryVO);
			session.getTransaction().commit();
		} catch(RuntimeException ex){
			session.getTransaction().rollback();
			throw ex;
		} 
		count++;
		return count;
	}

	@Override
	public int delete(String countryVO) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		int count = 0;
		try{
			session.beginTransaction();
			
			CountryVO countryBean = (CountryVO)session.get(CountryVO.class,countryVO);
			session.delete(countryBean);
			
			session.getTransaction().commit();
			System.out.print("success delete");
		} catch(RuntimeException ex){
			session.getTransaction().rollback();
			throw ex;
		} 
		count++;
		return count;
	}

	@Override
	public CountryVO selectOne(String countryVO) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		CountryVO countryBean = null;
		try{
			session.beginTransaction();
			
			countryBean = (CountryVO)session.get(CountryVO.class,countryVO);
			System.out.println("CountryID: "+countryBean.getCountryID() +",");
			System.out.println("CountryID: "+countryBean.getCountry());
			System.out.println(" ");
			
			session.getTransaction().commit();
		} catch(RuntimeException ex){
			session.getTransaction().rollback();
			throw ex;
		} 
		return countryBean;
	}

	@Override
	public List<CountryVO> selectAll() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		List<CountryVO> list = new ArrayList<CountryVO>();
		try{
			session.beginTransaction();
			
			Query query = session.createQuery(GET_ALL_STMT);
			list = (List<CountryVO>)query.list();
			for (CountryVO aCountry : list) {
				System.out.print(aCountry.getCountryID() + ", ");
				System.out.print(aCountry.getCountry());
			}
			
			session.getTransaction().commit();
		} catch(RuntimeException ex){
			session.getTransaction().rollback();
			throw ex;
		}

		return null;
	}
	
}
