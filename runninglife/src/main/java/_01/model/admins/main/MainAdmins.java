package _01.model.admins.main;

import _01.model.admins.AdminsDAO;
import _01.model.admins.AdminsVO;
import _01.model.adminsPriority.AdminsPriorityDAO;
import _01.model.adminsPriority.AdminsPriorityVO;

public class MainAdmins {

	public static void main(String[] args) {
		//hibernateDAO test
		AdminsDAO adminsDao = new AdminsDAO();
		AdminsVO adminsVO = new AdminsVO();
		AdminsPriorityVO adminPriorityVO = new AdminsPriorityVO();
		AdminsPriorityDAO adminPriorityDAO = new AdminsPriorityDAO();
		
		//insert or update
//		adminsVO.setAdminAccount("admin2");
//		adminsVO.setPassword("test8888");
//		adminsVO.setName("Bill");
//		adminPriorityVO.setLevelID("1");
//		adminsVO.setLevelID(adminPriorityVO);
//		adminsVO.setStatus("login_fail");
//		adminsDao.insert(adminsVO);
		//delete
//		adminsDao.delete("admin2");
		//selectOne
//		adminsDao.selectOne("admin2");
		//selectAll
//		adminsDao.selectAll();
		
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
