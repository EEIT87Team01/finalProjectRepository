package _01.model.adminsPriority.main;

import _01.model.adminsPriority.AdminsPriorityDAO;
import _01.model.adminsPriority.AdminsPriorityVO;

public class MainAdminsPriority {

	public static void main(String[] args) {
		//hibernateDAO test
		AdminsPriorityDAO adminsPriorityDao = new AdminsPriorityDAO();
		AdminsPriorityVO adminPriorityVO = new AdminsPriorityVO();
		//insert or update
//		adminPriorityVO.setLevelID("2");
//		adminPriorityVO.setLevelName("human");
//		adminsPriorityDao.insert(adminPriorityVO);
		//delete
//		adminsPriorityDao.delete("2");
		//selectOne
//		adminsPriorityDao.selectOne("1");
		//selectAll
//		adminsPriorityDao.selectAll();
		
		//Unit test
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
//
	}

}
