package iii.runninglife._01.controller.loginController;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import iii.runninglife._01.model.city.CityDAO;
import iii.runninglife._01.model.city.CityPK;
import iii.runninglife._01.model.city.CityVO;
import iii.runninglife._01.model.country.CountryDAO;
import iii.runninglife._01.model.location.LocationPK;
import iii.runninglife._01.model.location.LocationVO;
import iii.runninglife._01.model.loginInformation.LoginInformationDAO;
import iii.runninglife._01.model.loginInformation.LoginInformationPK;
import iii.runninglife._01.model.loginInformation.LoginInformationVO;
import iii.runninglife._01.model.members.MembersDAO;
import iii.runninglife._01.model.members.MembersVO;

@Service("LoginService")
@Transactional
public class LoginService implements LoginService_Interface{
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
					message = "帳號不存在";
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
	
	
	//更換密碼
	public MembersVO changePaswd(String memberAccount,String password){
		String memberID = null;
		MessageDigest mDigest = null;
		try {
			mDigest = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//查詢會員
		loginInfoPK.setMemberAccount(memberAccount);
		loginInfoPK.setLoginMethod("1");
		loginInfo = loginInfoDAO.selectOne(loginInfoPK);
		memberID = loginInfo.getMemberID().getMemberID();
		membersVO = membersDAO.selectOne(memberID);
		
		byte[] temp = password.getBytes();	//明碼  //使用者輸入byte[]
		temp = mDigest.digest(temp); 		//亂碼
		loginInfo.setPassword(temp);
		loginInfoDAO.update(loginInfo);
		
		return membersVO;
	}
	
	//正規表示式確認
	public MembersVO createMember(String memberAccount,String password,String firstName,String lastName,String nickname,String gender,
			String email,String birthday,String location,String address,String identityID){
		CityDAO cityDAO = new CityDAO();
		CountryDAO countryDAO = new CountryDAO();
		
		CityPK cityPK = new CityPK();
		CityVO cityVO = new CityVO();
		LocationVO locationVO = new LocationVO();
		LocationPK locationPK = new LocationPK();
		MessageDigest mDigest = null;
		try {
			mDigest = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		loginInfoPK.setMemberAccount(memberAccount);
		loginInfoPK.setLoginMethod("1");
		loginInfo.setMemberAccount(loginInfoPK);
		byte[] temp = password.getBytes();	//明碼  //使用者輸入byte[]
		temp = mDigest.digest(temp); 
		loginInfo.setPassword(temp);
		loginInfoDAO.update(loginInfo);
		
		membersVO.setFirstName(firstName);
		membersVO.setLastName(lastName);
		membersVO.setNickname(nickname);
		membersVO.setGender(gender);
		membersVO.setEmail(email);
		membersVO.setBirthday(birthday);
		cityPK.setCountryID(countryDAO.selectOne("TWN"));
		cityPK.setCityID("TPE");
		cityVO.setCityID(cityPK);
		locationPK.setCityID(cityDAO.selectOne(cityPK));
		locationPK.setLocationID("777");
		locationVO.setLocationID(locationPK);
		locationVO.setLocationName(location);
		membersVO.setLocationID(locationVO);
//		LocationVO locationVO = new LocationVO();
//		locationVO.setLocationName(location);
//		membersVO.setLocationID(locationVO);
		membersVO.setAddress(address);
		membersVO.setIdentityID(identityID);
		membersDAO.insert(membersVO);
		System.out.println(membersVO.getFirstName());
		return membersVO;
	}
	
	//正規表示式確認
	public void regExpCheck(String memberAccount,String password){
		
	}
}
