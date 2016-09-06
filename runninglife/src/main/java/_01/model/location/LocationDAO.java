package _01.model.location;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import _01.model.hibernate.util.HibernateUtil;

public class LocationDAO implements LocationInterface{
	
	private static final String GET_ALL_STMT = "from LocationVO order by locationID";

	@Override
	public void insert(LocationVO locationVO) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		int count = 0;
		try{
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			session.saveOrUpdate(locationVO);
			session.getTransaction().commit();
		} catch(RuntimeException ex){
			session.getTransaction().rollback();
			throw ex;
		} 
		count++;
	}

	@Override
	public int update(LocationVO locationVO) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		int count = 0;
		try{
			session.beginTransaction();
			session.saveOrUpdate(locationVO);
			session.getTransaction().commit();
		} catch(RuntimeException ex){
			session.getTransaction().rollback();
			throw ex;
		} 
		count++;
		return count;
	}

	@Override
	public int delete(LocationPK locationPK) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		int count = 0;
		try{
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			
			LocationVO locationBean = (LocationVO)session.get(LocationVO.class,locationPK);
			session.delete(locationBean);
			
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
	public LocationVO selectOne(LocationPK locationPK) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		LocationVO locationBean = null;
		try{
			session.beginTransaction();
			
			locationBean = (LocationVO)session.get(LocationVO.class, locationPK);
			System.out.print("LocationID: "+locationBean.getLocationID().getCityID().getCityID().getCityID() +", ");
			System.out.print("LocationID: "+locationBean.getLocationID().getLocationID() +", ");
			System.out.print("LocationName: "+locationBean.getLocationName() + ", ");
//			System.out.print("CityID: "+locationBean.getCityBean().getCityID() + ", ");
//			System.out.println("CountryID: "+locationBean.getCountryBean().getCountryID());
			System.out.println(" ");
			
			session.getTransaction().commit();
		} catch(RuntimeException ex){
			session.getTransaction().rollback();
			throw ex;
		} 
		return locationBean;
	}

	@Override
	public List<LocationVO> selectAll(LocationVO locationVO) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try{
			session.beginTransaction();
			Query query = session.createQuery(GET_ALL_STMT); 
			List<LocationVO> list = query.list();
			for (LocationVO aLocation : list) {
//				aLocation.toString();
				System.out.print("LocationID: "+aLocation.getLocationID() +", ");
				System.out.print("LocationName: "+aLocation.getLocationName() + ", ");
//				System.out.print("CityID: "+aLocation.getCityBean().getCityID() + ", ");
//				System.out.println("CountryID: "+aLocation.getCountryBean().getCountryID());
			}
			
			session.getTransaction().commit();
		} catch(RuntimeException ex){
			session.getTransaction().rollback();
			throw ex;
		} 

		return null;
	}
	
}
