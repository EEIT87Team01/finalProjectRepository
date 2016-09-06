package _01.model.country.main;

import org.hibernate.Session;
import org.hibernate.Transaction;

import _01.model.city.CityPK;
import _01.model.city.CityVO;
import _01.model.country.CountryDAO;
import _01.model.country.CountryVO;
import _01.model.hibernate.util.HibernateUtil;

public class MainCountry {

	public static void main(String[] args) {
		//hibernateDAO test
		CountryDAO countryDao = new CountryDAO();
		CountryVO countryVO = new CountryVO();
		CityVO cityBean = new CityVO();
		CityPK cityPK = new CityPK();
//		countryBean.setCountryID("TWN");
//		countryBean.setCountry("台灣");
//		countryDao.insert(countryBean);
//		cityPK.setCountryID(countryDao.selectOne("300"));;
//		cityPK.setCityID("952");
//		cityBean.setCityID(cityPK);
//		countryDao.delete("TWN");
		countryDao.selectOne("TWN");
//		countryDao.selectAll();
		
		//Unit test
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			
//			//select one
//			Query query = session.createQuery("from CountryVO where countryID=? ");
//			query.setParameter(0, "300");
			
			
////			CountryBean countryBean = (CountryBean)session.get(CountryBean.class,"300");
////			System.out.println("CountryID: "+countryBean.getCountryID() +",");
////			System.out.println("CountryID: "+countryBean.getCountry());
//			
//			//insert one
////			CountryBean countryBean = new CountryBean();
////			countryBean.setCountryID("500");
////			countryBean.setCountry("中國");
////			System.out.println("insert CountryID:" + countryBean.getCountryID() + 
////					", Country:"	+ countryBean.getCountry());
////			session.save(countryBean);
//			
//			//insert save or update
////			CountryBean countryBean = new CountryBean();
////			countryBean.setCountryID("600");
////			countryBean.setCountry("美國");
////			session.saveOrUpdate(countryBean);
//			
//			//delete one
////			CountryBean countryBean = (CountryBean)session.get(CountryBean.class,"600");
////			session.delete(countryBean);
//			
//			//select all
////			CountryBean countryBean = (CountryBean)session.get(CountryBean.class,CountryBean);
////			Query query = session.createQuery("from CountryBean order by countryID"); //HQL - Query介面 - 可封裝查詢條件
////			List<CountryBean> list = query.list();
////			for (CountryBean aCountry : list) {
////				System.out.print(aCountry.getCountryID() + ", ");
////				System.out.println(aCountry.getCountry());
////			}
			
			tx.commit();
		}catch(RuntimeException ex){
			if (tx != null){
				tx.rollback();
				System.out.println("runtime error!");
				throw ex;
			}
		} finally{
			HibernateUtil.getSessionFactory().close();
		}

	}

}
