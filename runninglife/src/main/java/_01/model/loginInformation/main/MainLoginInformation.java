package _01.model.loginInformation.main;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import _01.model.loginInformation.LoginInformationDAO;
import _01.model.loginInformation.LoginInformationPK;
import _01.model.loginInformation.LoginInformationVO;
import _01.model.members.MembersDAO;
import _01.model.members.MembersVO;

public class MainLoginInformation {

	public static void main(String[] args) throws UnsupportedEncodingException{
		//hibernateDAO test
		LoginInformationDAO loginInformationDao = new LoginInformationDAO();
		LoginInformationVO loginInformationVO = new LoginInformationVO();
		LoginInformationPK loginInformationPK = new LoginInformationPK();
		MembersVO membersVO = new MembersVO();
		MessageDigest mDigest = null;
		try {
			mDigest = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//------------------------
		//insert or update
//		UUID uuid = UUID.fromString("38400000-8cf0-11bd-b23e-10b96e4ef00d");
//		System.out.println(uuid);
//		loginInformationPK.setMemberID(uuid);
		membersVO.setMemberID("F349A8E2-DE67-4F70-838B-C099C687D57F");
		loginInformationPK.setMemberAccount("admin1");
		loginInformationPK.setLoginMethod("1");
		loginInformationVO.setMemberAccount(loginInformationPK);
		loginInformationVO.setMemberID(membersVO);
		String password = "12345678";
		byte[] temp = password.getBytes("UTF-8");	//明碼  //使用者輸入byte[]
		temp = mDigest.digest(temp); 		//亂碼
		loginInformationVO.setPassword(temp);
		loginInformationVO.setStatus("login_OK");
		loginInformationDao.insert(loginInformationVO);
		
//		writerDao.insert(writerVO);
		
//------------------------------------------
		//selectOne
		MembersDAO membersDAO = new MembersDAO();
		loginInformationPK.setMemberAccount("admin1");
		loginInformationPK.setLoginMethod("1");
		loginInformationVO = loginInformationDao.selectOne(loginInformationPK);
		System.out.println(loginInformationVO.getMemberID().getMemberID());
		System.out.println(loginInformationVO.getPassword());
		loginInformationVO.getMemberID();
		
		System.out.println(loginInformationVO);
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
