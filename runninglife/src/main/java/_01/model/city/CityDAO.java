package _01.model.city;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import _01.model.hibernate.util.HibernateUtil;

public class CityDAO implements CityInterface{
	
	private static final String GET_ALL_STMT = "from CityVO";
	//selectOne方法一
//	private static final String GET_ONE_STMT = "from CityVO city "
//			+ "where city.cityID.cityID=:cityID and city.cityID.countryID.countryID=:countryID";

	@Override
	public int insert(CityVO cityVO) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		int count = 0;
		try{
			session.beginTransaction();
			session.saveOrUpdate(cityVO);
			session.getTransaction().commit();
		} catch(RuntimeException ex){
			session.getTransaction().rollback();
			throw ex;
		} 
		count++;
		return count;
	}

	@Override
	public int update(CityVO cityVO) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		int count = 0;
		try{
			session.beginTransaction();
			session.saveOrUpdate(cityVO);
			session.getTransaction().commit();
		} catch(RuntimeException ex){
			session.getTransaction().rollback();
			throw ex;
		} 
		count++;
		return count;
	}

	@Override
	public int delete(CityPK CityPK) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		int count = 0;
		try{
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			
			CityVO cityBean = (CityVO)session.get(CityVO.class,CityPK);
			session.delete(cityBean);
			
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
	public CityVO selectOne(CityPK cityPK) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		CityVO cityBean = null;
		try{
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			
			//方法一
			cityBean = (CityVO)session.get(CityVO.class,cityPK);
			System.out.print(cityBean.getCityID().getCityID() + ",");
			System.out.print(cityBean.getCityID().getCountryID().getCountryID() + ",");
			System.out.print(cityBean.getCityName());
			
			//方法二
//			Query  query = session.createQuery(GET_ONE_STMT);
//			query.setParameter("cityID", cityPK.getCityID());
//			query.setParameter("countryID", cityPK.getCountryID().getCountryID());
//			
//			List<CityVO> list = query.list();
//			for (CityVO aCity : list) {
//				System.out.print(aCity.getCityID().getCityID() + ",");
//				System.out.print(aCity.getCityID().getCountryID().getCountryID() + ",");
//				System.out.print(aCity.getCityName());
//				System.out.println();
//			}

			session.getTransaction().commit();
		} catch(RuntimeException ex){
			session.getTransaction().rollback();
			throw ex;
		} 
		return cityBean;
	}

	@Override
	public List<CityVO> selectAll() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try{
			session.beginTransaction();
			Query query = session.createQuery(GET_ALL_STMT); 
			List<CityVO> list = query.list();
			for (CityVO aCity : list) {
				System.out.print(aCity.getCityID().getCityID() + ", ");
				System.out.println(aCity.getCityName());
//				System.out.println(aCity.getCountryBean().getCountryID());
			}
			
			session.getTransaction().commit();
		} catch(RuntimeException ex){
			session.getTransaction().rollback();
			throw ex;
		} 

		return null;
	}
	
}
