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
		membersVO.setMemberID("F349A8E2-DE67-4F70-838B-C099C687D57F");
		loginInformationPK.setMemberAccount("admin4");
		loginInformationPK.setLoginMethod("1");
		loginInformationVO.setMemberAccount(loginInformationPK);
		loginInformationVO.setMemberID(membersVO);
		String password = "2266";
		byte[] temp = password.getBytes("UTF-8");	//明碼  //使用者輸入byte[]
		temp = mDigest.digest(temp); 		//亂碼
		
		loginInformationVO.setPassword(temp);
		int loginSataus = (int)(Math.random() *100 + 1);
		loginInformationVO.setStatus(Integer.toString(loginSataus));
		loginInformationDao.insert(loginInformationVO);
		
//------------------------------------------
		//selectOne
		MembersDAO membersDAO = new MembersDAO();
		loginInformationPK.setMemberAccount("admin4");
		loginInformationPK.setLoginMethod("1");
		loginInformationVO = loginInformationDao.selectOne(loginInformationPK);
		System.out.println(loginInformationVO.getMemberID().getMemberID());
		System.out.println(loginInformationVO.getPassword());
		
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
