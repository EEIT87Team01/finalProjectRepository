package _01.model.competence.main;

import org.hibernate.Session;
import org.hibernate.Transaction;

import _01.model.city.CityPK;
import _01.model.city.CityVO;
import _01.model.competence.CompetenceDAO;
import _01.model.competence.CompetenceVO;
import _01.model.hibernate.util.HibernateUtil;

public class MainCompetence {

	public static void main(String[] args) {
		//hibernateDAO test
		CompetenceDAO competenceDao = new CompetenceDAO();
		CompetenceVO competenceVO = new CompetenceVO();


//		cityPK.setCountryID(countryDao.selectOne("300"));;
//		cityPK.setCityID("952");
//		cityBean.setCityID(cityPK);
		
//		countryDao.delete("JP");
//		competenceVO.setCompetenceID(1);
//		competenceDao.selectOne(1);
		competenceDao.selectAll();
		
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
