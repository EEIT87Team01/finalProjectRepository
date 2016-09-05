package _02.model.membercomplete.country;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import _02.model.HibernateUtil;
import _02.model.membercomplete.city.CityVO;

public class CountryMainTest {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		String GET_ALL_STMT = "FROM CountryVO";
		List<CountryVO> avos = new ArrayList<CountryVO>();
		try {
			session.beginTransaction();
			Query q =session.createQuery(GET_ALL_STMT);
			avos = (List<CountryVO>)q.list();
			session.getTransaction().commit();
		} catch (RuntimeException e) {
			session.getTransaction().rollback();
			throw e;
		}
		for (CountryVO avo : avos){
			System.out.println(avo.getCountryID()+", "+avo.getCountryName());
			for (CityVO cvo : avo.getCityID()){
				System.out.println("\t" + cvo.getCityPK().getCityID() + ", " + cvo.getCityName());
			}
		}
	}

}
