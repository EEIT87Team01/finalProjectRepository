package test.div.controller;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import _02.model.HibernateUtil;
import test.city.model.CityVO;
import test.div.model.DivVO;

public class MainTest {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		String GET_ALL_STMT = "FROM CityVO";
		List<CityVO> avos = new ArrayList<CityVO>();
		try {
			session.beginTransaction();
			Query q =session.createQuery(GET_ALL_STMT);
			avos = (List<CityVO>)q.list();
			session.getTransaction().commit();
		} catch (RuntimeException e) {
			session.getTransaction().rollback();
			throw e;
		}
//		for (AgeVO avo : avos){
//			System.out.println(avo.getCharaName() + ", " + avo.getAge());
//		}
		for (CityVO avo : avos){
			System.out.println(avo.getCityID() +", "+avo.getCityName() );
			for(DivVO d : avo.getDivs()){
				System.out.println(d.getDivID().getDivID() + ", " + d.getDivName());
			}
		}
	}

}
