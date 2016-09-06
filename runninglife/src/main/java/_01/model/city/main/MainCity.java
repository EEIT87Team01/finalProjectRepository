package _01.model.city.main;

import _01.model.city.CityDAO;
import _01.model.city.CityPK;
import _01.model.city.CityVO;
import _01.model.country.CountryDAO;
import _01.model.country.CountryVO;

public class MainCity {

	public static void main(String[] args) {
		//hibernateDAO test
		CountryVO coountryVO = new CountryVO();
		CityDAO cityDao = new CityDAO();
		CityVO cityVO = new CityVO();
		CityPK cityPK = new CityPK();
		CountryVO countryBean = new CountryVO();
		CountryDAO countryDAO = new CountryDAO();
		//insert or update
//		cityPK.setCityID("TPE");
//		countryBean.setCountryID("TWN");
//		cityPK.setCountryID(countryBean);
//		cityVO.setCityID(cityPK);
//		cityVO.setCityName("台北市");
//		cityDao.insert(cityVO);
		//delete
//		cityPK.setCityID("952");
//		cityPK.setCountryID(countryDAO.selectOne("300"));
//		cityDao.delete(cityPK);		
		//selectOne
//		cityPK.setCityID("TPE");
//		cityPK.setCountryID(countryDAO.selectOne("TWN"));
//		cityVO.setCityID(cityPK);
//		cityDao.selectOne(cityPK);
		
		//selectAll
		cityDao.selectAll();
		
		//Unit JDBC 架構 
//		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
//		Transaction tx = null;
//		try{
//			tx = session.beginTransaction();
//			//hibernate unit test
//			Query query3 = session.createQuery("from CityVO city "
//					+ "where city.cityID.cityID=:cityID and city.cityID.countryID.countryID=:countryID");
//			
//			query3.setParameter("cityID", "952");
//			query3.setParameter("countryID", "300");
//		
//			List<CityVO> list = query3.list();
//			for (CityVO aCity : list) {
//				System.out.print(aCity.getCityID().getCityID() + ",");
//				System.out.print(aCity.getCityID().getCountryID().getCountryID() + ",");
//				System.out.print(aCity.getCityName());
//				System.out.println();
//			}
		
//			//JDBC unit test
//			//select one
////			CityBean countryBean = (CityBean)session.get(CityBean.class,"952");
////			System.out.print("CityID: "+cityBean.getCityID() +", ");
////			System.out.print("CityID: "+cityBean.getCityName() + ", ");
////			System.out.println("CityID: "+cityBean.getCountryBean() + ", ");
//			
//			//insert one
////			CityBean cityBean = new CityBean();
////			CountryBean countryBean = new CountryBean();
////			
////			cityBean.setCityID("700");
////			cityBean.setCityName("熊本市");
////			countryBean.setCountryID("300");
////			cityBean.setCountryBean(countryBean);
////			System.out.println("insert CityID:" + cityBean.getCityID() + 
////					", CityName:"	+ cityBean.getCityName() + 
////					", CountryID:" + cityBean.getCountryBean().getCountryID() );
////			session.save(cityBean);
//			
//			//insert save or update
////			CityBean cityBean = new CityBean();
////			CountryBean countryBean = new CountryBean();
////			cityBean.setCityID("600");
////			cityBean.setCityName("奈良市");
////			countryBean.setCountryID("300");
////			cityBean.setCountryBean(countryBean);
////			session.saveOrUpdate(cityBean);
//			
//			//delete one
////			CityBean cityBean = (CityBean)session.get(CityBean.class,"600");
////			session.delete(cityBean);
//			
//			//select all
////			Query query = session.createQuery("from CityBean order by cityID"); //HQL - Query介面 - 可封裝查詢條件
////			List<CityBean> list = query.list();
////			for (CityBean aCity : list) {
////				System.out.print(aCity.getCityID() + ", ");
////				System.out.print(aCity.getCityName() + ", ");
////				System.out.println(aCity.getCountryBean().getCountryID());
////			}
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
//
	}

}
