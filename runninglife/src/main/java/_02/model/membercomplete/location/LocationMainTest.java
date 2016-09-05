package _02.model.membercomplete.location;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import _02.model.HibernateUtil;

public class LocationMainTest {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		String GET_ALL_STMT = "FROM LocationVO";
		List<LocationVO> avos = new ArrayList<LocationVO>();
		try {
			session.beginTransaction();
			Query q = session.createQuery(GET_ALL_STMT);
			avos = (List<LocationVO>) q.list();
			session.getTransaction().commit();
		} catch (RuntimeException e) {
			session.getTransaction().rollback();
			throw e;
		}
		for (LocationVO avo : avos) {
			System.out.println(avo.getLocationPK().getLocationID() + ", " + avo.getLocationName() + ", " + avo.getLocationPK().getCityID().getCityName());
		}
	}
}
