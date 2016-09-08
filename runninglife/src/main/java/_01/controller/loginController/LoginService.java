package _01.controller.loginController;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
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
	
	
	

	
//	public LoginInformationVO addInfo(LoginInformationPK memberAccount,MembersVO  memberID,String password,String status){
//		LoginInformationVO infoVO = new LoginInformationVO();
//		infoVO.setMemberAccount(memberAccount);
//		infoVO.setPassword(password);
//		infoVO.setMemberID(memberID);
//		infoVO.setStatus(status);
//		loginDao.insert(infoVO);
//		return infoVO;
//	}
	@Override
	public Map<String ,Object> checkPassword(String memberAccount,String password){
		MessageDigest mDigest = null;
		try {
			mDigest = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		Collection<String> errorMessage = new ArrayList<String>();
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
		
		MembersVO membersVO = new MembersVO();
		MembersDAO membersDAO = new MembersDAO();
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
	

	
	//正規表示式確認
	public void regExpCheck(String memberAccount,String password){
		
	}
}
