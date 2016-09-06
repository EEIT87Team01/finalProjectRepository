package _01.model.loginInformation.main;

import _01.model.loginInformation.LoginInformationDAO;
import _01.model.loginInformation.LoginInformationPK;
import _01.model.loginInformation.LoginInformationVO;
import _01.model.members.MembersVO;

public class MainLoginInformation {

	public static void main(String[] args) {
		//hibernateDAO test
		LoginInformationDAO loginInformationDao = new LoginInformationDAO();
		LoginInformationVO loginInformationVO = new LoginInformationVO();
		LoginInformationPK loginInformationPK = new LoginInformationPK();
		MembersVO membersVO = new MembersVO();
		//------------------------
		//insert or update
//		UUID uuid = UUID.fromString("38400000-8cf0-11bd-b23e-10b96e4ef00d");
//		System.out.println(uuid);
//		loginInformationPK.setMemberID(uuid);
		membersVO.setMemberID("38400000-8cf0-11bd-b23e-10b96e4ef00d");
		loginInformationPK.setMemberID(membersVO);
		loginInformationPK.setLoginMethod("1");
		loginInformationVO.setLoginInformationID(loginInformationPK);
		loginInformationVO.setMemberAccount("admin3");
		loginInformationVO.setPassword("test1");
		loginInformationVO.setStatus("login_OK");
		loginInformationDao.insert(loginInformationVO);
		
//		writerDao.insert(writerVO);
		
//------------------------------------------
		//selectOne
//		loginInformationPK.setMemberID("F349A8E2-DE67-4F70-838B-C099C687D57F");
//		loginInformationPK.setLoginMethod("1");
//		loginInformationDao.selectOne(loginInformationPK);
		//------------------------
		
		//selectAll
//		loginInformationDao.selectAll(loginInformationVO);
		
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
