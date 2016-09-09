package _01.controller.loginController;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import _01.model.loginInformation.LoginInformationDAO;
import _01.model.loginInformation.LoginInformationPK;
import _01.model.loginInformation.LoginInformationVO;
import _01.model.members.MembersDAO;
import _01.model.members.MembersVO;

public class LoginService implements LoginService_Interface{
//	private LoginInformationInterface loginDao;
	LoginInformationVO loginInfo = new LoginInformationVO();
	LoginInformationPK loginInfoPK = new LoginInformationPK();
	LoginInformationDAO loginInfoDAO = new LoginInformationDAO();
	MembersVO membersVO = new MembersVO();
	MembersDAO membersDAO = new MembersDAO();
	
	@Override
	public Map<String ,Object> checkPassword(String memberAccount,String password){
		MessageDigest mDigest = null;
		try {
			mDigest = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String message = null;
		byte[] insetPswd = null;
		Map<String ,Object> InfoMsg = new HashMap<String ,Object>();
		/***************************2.開始查詢資料*****************************************/
		loginInfoPK.setMemberAccount(memberAccount);
		loginInfoPK.setLoginMethod("1");
		
				//輸入帳號CO Hibernate
				loginInfo = loginInfoDAO.selectOne(loginInfoPK);
				//確認資料庫有此帳號
				if(loginInfo != null){
					//轉碼
					insetPswd= changeMD5Encoding(password);
					//取出byte[]
					for  (byte e : insetPswd) 
						System.out.print(e);
					//從DB取出
					byte[] dbPassword = loginInfo.getPassword();
					//取出byte[]
					for  (byte e : dbPassword) 
						System.out.print(e);
												
					//確認密碼正確
					if(dbPassword != null && Arrays.equals(dbPassword, insetPswd)){
						loginInfo.setMemberAccount(loginInfoPK);
						loginInfo.setPassword(dbPassword);
						message = "登入成功";
						InfoMsg.put("Msg",message);
						InfoMsg.put("Info",loginInfo);
					    
						return InfoMsg;
						/***************************其他可能的錯誤處理*************************************/
					}else{
						message = "密碼錯誤";
						InfoMsg.put("Msg",message);
						InfoMsg.put("Info",loginInfo);
						return InfoMsg;
					}
				}else{
					message = "查無此帳號";
					InfoMsg.put("Msg",message);
					return InfoMsg;
				}
	}
	
	@Override
	public MembersVO insertMember(Map<String ,Object> loginInfo){
		String memberID = null;
		memberID = ((LoginInformationVO)loginInfo.get("Info")).getMemberID().getMemberID();
		membersVO.setMemberID(memberID);
		membersVO = membersDAO.selectOne(memberID);
		return membersVO;
	}
	
	//Password Change
	@Override
	public byte[] changeMD5Encoding(String password){
//		String regex = "^.*(?=.{6,})(?=.[a-z])";
		//java.security.MessageDigest
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(password!=null && password.length()!=0) {
			byte[] temp = password.getBytes();	//明碼  //使用者輸入byte[]
			temp = md.digest(temp); 		//亂碼
			return temp;
		}else{
			return null;
		}
	}
	
	public String ForgetPaswd(String memberAccount,String memberEmail){
		String DBEmail = null;
		String message = null;
		String memberID = null;
		loginInfoPK.setMemberAccount(memberAccount);
		loginInfoPK.setLoginMethod("1");
		//輸入帳號CO Hibernate
		loginInfo = loginInfoDAO.selectOne(loginInfoPK);
		if(loginInfo != null){
//			message = "帳號無誤";
			membersVO = membersDAO.selectOne(loginInfo.getMemberID().getMemberID().toString());
			DBEmail = membersVO.getEmail();
			return DBEmail;
		}else {
			message = "無此帳號";
			return message;
		}
	}
	
	public Map<String ,Object> CheckVerification(String memberAccount,String loginSataus){
		String dbStatus = null;
		String newStatus = null;
		Map<String ,Object> returnInfo = new HashMap<String ,Object>();
		loginInfoPK.setMemberAccount(memberAccount);
		loginInfoPK.setLoginMethod("1");
		loginInfo = loginInfoDAO.selectOne(loginInfoPK);
		dbStatus = loginInfo.getStatus();
		//與DB比對
		if(loginSataus.equals(dbStatus.trim())){
			newStatus = "login_OK";
			returnInfo.put("status", newStatus);
			returnInfo.put("Info",loginInfo); 
			
			loginInfo.setStatus(newStatus);
			loginInfoDAO.update(loginInfo);
			
			return returnInfo;
		}else{

			returnInfo.put("status","驗證失敗");
			return returnInfo;
		}
	}
	
	//正規表示式確認
	public void regExpCheck(String memberAccount,String password){
		
	}
}
