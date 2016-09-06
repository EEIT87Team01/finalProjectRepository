package _01.model.emergencyRelation.main;

import _01.model.emergencyRelation.EmergencyRelationVO;
import _01.model.emergencyRelation.EmergencyRelationDAO;

public class MainEmergencyRelation {

	public static void main(String[] args) {
		//hibernateDAO test
		EmergencyRelationDAO emergencyRelationDao = new EmergencyRelationDAO();
		EmergencyRelationVO emergencyRelationVO = new EmergencyRelationVO();
		//insert or update
//		emergencyRelationBean.setRelationID(11);
//		emergencyRelationBean.setRelationName("mother");
//		emergencyRelationDao.insert(emergencyRelationVO);
		//delete
//		emergencyRelationDao.delete(10);
		//selectOne
//		emergencyRelationDao.selectOne(10);
		//selectAll
		emergencyRelationDao.selectAll(emergencyRelationVO);
		
		//Unit test
//		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
//		Transaction tx = null;
//		try{
//			tx = session.beginTransaction();
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
