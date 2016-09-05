package _02.model.membercomplete.city;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import _02.model.HibernateUtil;

public class CityMainTest {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		String GET_ALL_STMT = "FROM CityVO";
		List<CityVO> avos = new ArrayList<CityVO>();
		try {
			session.beginTransaction();
			Query q = session.createQuery(GET_ALL_STMT);
			avos = (List<CityVO>)q.list();
			session.getTransaction().commit();
		} catch (RuntimeException e) {
			session.getTransaction().rollback();
			throw e;
		}
		for (CityVO avo : avos){
			System.out.println(avo.getCityPK().getCountryID().getCountryID()+", "+avo.getCityPK().getCountryID().getCountryName() + ", " + avo.getCityPK().getCityID() + ", " + avo.getCityName());
		}
	}

}
