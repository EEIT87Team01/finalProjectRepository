package _01.model.location.main;

import _01.model.city.CityDAO;
import _01.model.city.CityPK;
import _01.model.city.CityVO;
import _01.model.country.CountryDAO;
import _01.model.country.CountryVO;
import _01.model.location.LocationDAO;
import _01.model.location.LocationPK;
import _01.model.location.LocationVO;

public class MainLocation {

	public static void main(String[] args) {
		//hibernateDAO test
		CountryDAO countryDao = new CountryDAO();
		CityDAO cityDao	= new CityDAO();
		LocationDAO locationDao = new LocationDAO();
		LocationVO locationVO= new LocationVO();
		LocationPK locationPK = new LocationPK();
		CityVO cityVO = new CityVO();
		CityPK cityPK = new CityPK();
		CountryVO countryVO = new CountryVO();
		//insert or update
//		countryVO.setCountryID("JP");
//		cityPK.setCountryID(countryVO);
//		cityPK.setCityID("TKY");
//		cityVO.setCityID(cityPK);
//		locationPK.setCityID(cityVO);
//		locationPK.setLocationID("800");
//		locationVO.setLocationID(locationPK);
//		locationVO.setLocationName("東京都");
//		locationDao.insert(locationVO);
		
//		cityPK.setCountryID(countryDao.selectOne("JP"));
//		cityPK.setCityID("TKY");
//		cityVO.setCityID(cityPK);
//		locationPK.setCityID(cityDao.selectOne(cityPK));
//		locationPK.setLocationID("800");
//		locationVO.setLocationID(locationPK);
//		locationVO.setLocationName("東京都");
//		locationDao.insert(locationVO);
		
		//delete
//		cityPK.setCountryID(countryDao.selectOne("JP"));
//		cityPK.setCityID("TKY");
//		cityVO.setCityID(cityPK);
//		locationPK.setCityID(cityDao.selectOne(cityPK));
//		locationPK.setLocationID("800");
//		locationVO.setLocationID(locationPK);
//		locationDao.delete(locationPK);
		//selectOne
		countryVO.setCountryID("TWN");
		cityPK.setCountryID(countryVO);
		cityPK.setCityID("TPE");
		cityVO.setCityID(cityPK);
		locationPK.setCityID(cityVO);
		locationPK.setLocationID("777");
//		locationVO.setLocationID(locationPK);
//		locationVO.setLocationName("東京都");
		locationDao.selectOne(locationPK);
		//selectAll
//		countryVO.setCountryID("JP");
//		cityPK.setCountryID(countryVO);
//		cityPK.setCityID("TKY");
//		cityVO.setCityID(cityPK);
//		locationPK.setCityID(cityVO);
//		locationPK.setLocationID("800");
//		locationVO.setLocationID(locationPK);
//		locationVO.setLocationName("東京都");
//		locationDao.selectAll(locationVO);
		
		//Unit JDBC 架構 
//		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
//		Transaction tx = null;
//		try{
//			tx = session.beginTransaction();
//			
//			
//			tx.commit();
//		}catch(RuntimeException ex){
//			if (tx != null){
//				tx.rollback();
//				System.out.println("runtime error!");
//				throw ex;
//			}
//		} finally{
//			HibernateUtil.getSessionFactory().close();
//		}

	}

}
