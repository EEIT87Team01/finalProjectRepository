package iii.runninglife.controller.loginController;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import iii.runninglife.globalservice.GlobalService;
import iii.runninglife.model.city.CityInterface;
import iii.runninglife.model.city.CityPK;
import iii.runninglife.model.city.CityVO;
import iii.runninglife.model.competence.CompetenceVO;
import iii.runninglife.model.country.CountryInterface;
import iii.runninglife.model.country.CountryVO;
import iii.runninglife.model.emergencyRelation.EmergencyRelationInterface;
import iii.runninglife.model.emergencyRelation.EmergencyRelationVO;
import iii.runninglife.model.location.LocationInterface;
import iii.runninglife.model.location.LocationPK;
import iii.runninglife.model.location.LocationVO;
import iii.runninglife.model.loginInformation.LoginInformationInterface;
import iii.runninglife.model.loginInformation.LoginInformationPK;
import iii.runninglife.model.loginInformation.LoginInformationVO;
import iii.runninglife.model.members.MembersInterface;
import iii.runninglife.model.members.MembersVO;

@Service
public class LoginService implements LoginService_Interface{
//	private LoginInformationInterface loginDao;
	
	@Autowired
	MembersInterface membersDAO;
	
	@Autowired
	CountryInterface countryDAO;
	@Autowired
	CityInterface cityDAO;
	@Autowired
	LocationInterface locationDAO;
	
	@Autowired
	LoginInformationInterface loginInfoDAO;
	@Autowired
	EmergencyRelationInterface emergencyRelationDAO;
	@Autowired
	GlobalService globalservice;
	

	MembersVO memberVO = new MembersVO();
	public void getPhotoFromByte(String memberID , byte[] bytes) {
		memberVO = membersDAO.selectOne(memberID);
		memberVO.setPhoto(bytes);
		membersDAO.update(memberVO);
	}
	
	@Override
	public Map<String ,Object> CheckPassword(String memberAccount,String password){
		LoginInformationVO loginInfo = new LoginInformationVO();
		LoginInformationPK loginInfoPK = new LoginInformationPK();
		
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
					insetPswd= globalservice.changeMD5Encoding(password);
					//從DB取出
					byte[] dbPassword = loginInfo.getPassword();
												
					//確認密碼正確
					if(dbPassword != null && Arrays.equals(dbPassword, insetPswd)){
						loginInfo.setMemberAccount(loginInfoPK);
						loginInfo.setPassword(dbPassword);
						InfoMsg.put("Msg","LoginOK");
						InfoMsg.put("Info",loginInfo);
					    
						return InfoMsg;
						/***************************其他可能的錯誤處理*************************************/
					}else{
						InfoMsg.put("Msg","WrongPassword");
						InfoMsg.put("Info",loginInfo);
						return InfoMsg;
					}
				}else{
					InfoMsg.put("Msg","NotExistAccount");
					return InfoMsg;
				}
	}
	
	@Override
	public MembersVO InsertMember(Map<String ,Object> loginInfo){
		MembersVO membersVO = new MembersVO();
		String memberID = null;
		memberID = ((LoginInformationVO)loginInfo.get("Info")).getMemberID().getMemberID();
		membersVO.setMemberID(memberID);
		
		
		membersVO = membersDAO.selectOne(memberID);
		
		Calendar cl=Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String lastTime = sdf.format(cl.getTime());
		membersVO.setLastOnlineDateTime(lastTime);
		membersDAO.update(membersVO);
		return membersVO;
	}
	
	//Password Change
	@Override
	public String ForgetPaswd(String memberAccount,String memberEmail){
		LoginInformationVO loginInfo = new LoginInformationVO();
		LoginInformationPK loginInfoPK = new LoginInformationPK();
		MembersVO membersVO = new MembersVO();
		String DBEmail = null;
		String message = null;
		loginInfoPK.setMemberAccount(memberAccount);
		loginInfoPK.setLoginMethod("1");
		//輸入帳號CO Hibernate
		loginInfo = loginInfoDAO.selectOne(loginInfoPK);
		if(loginInfo != null){
			
			int ran = (int)(Math.random()*1000)+1;
			String random = ""+ran;
			loginInfo.setStatus(random);
			loginInfoDAO.update(loginInfo);
			
//			message = "帳號無誤";
			membersVO = membersDAO.selectOne(loginInfo.getMemberID().getMemberID().toString());
			DBEmail = membersVO.getEmail();
			return random;
		}else {
			message = "無此帳號";
			return message;
		}
	}
	
	@Override
	public Map<String ,Object> CheckVerification(String memberAccount,String loginSataus){
		LoginInformationVO loginInfo = new LoginInformationVO();
		LoginInformationPK loginInfoPK = new LoginInformationPK();
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
	@Override
	public MembersVO ChangePaswd(String memberAccount,String password){
		LoginInformationVO loginInfo = new LoginInformationVO();
		LoginInformationPK loginInfoPK = new LoginInformationPK();
		MembersVO membersVO = new MembersVO();
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

	//新增會員
	@Override
	public MembersVO CreateMember(String memberAccount,String password,String firstName,String lastName,String phone,
			String email ,String gender,String birthday, byte[] photo){
		MembersVO membersVO = new MembersVO();
		LoginInformationVO loginInfo = new LoginInformationVO();
		LoginInformationPK loginInfoPK = new LoginInformationPK();
		
		MessageDigest mDigest = null;
		try {
			mDigest = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		membersVO.setFirstName(firstName);
		membersVO.setLastName(lastName);
		membersVO.setEmail(email);
		membersVO.setGender(gender);
		membersVO.setBirthday(birthday);
		membersVO.setPhone(phone);
		membersVO.setPhoto(photo);
		
		Calendar cl=Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String createTime = sdf.format(cl.getTime());
		membersVO.setCreateDate(createTime);
		
		membersDAO.insert(membersVO);
		
		loginInfoPK.setMemberAccount(memberAccount);
		loginInfoPK.setLoginMethod("1");
		loginInfo.setMemberAccount(loginInfoPK);
		loginInfo.setMemberID(membersVO);
		loginInfo.setStatus("login_OK");
		byte[] temp = password.getBytes();	//明碼  //使用者輸入byte[]
		temp = mDigest.digest(temp); 
		loginInfo.setPassword(temp);
		loginInfoDAO.update(loginInfo);
		
		return findByPrimaryKey(new LoginInformationPK(memberAccount, "1")).getMemberID();
	}
	
	//修改會員
	public MembersVO updateMember(MembersVO membersVO){
		String memberID = null;
		membersDAO.update(membersVO);
		memberID = membersVO.getMemberID();
		membersVO = membersDAO.selectOne(memberID);
		return membersVO;
	}
	
	//修改會員
	@Override
	public MembersVO UpdateMember(String firstName,String lastName,String nickname,
			String email ,String gender,String birthday ,String address
			, Double height, Double weight, String phone,int competenceID, String identityID, String emergencyContact
			, String emergencyPhone, int emergencyRelation){
		MembersVO membersVO = new MembersVO();
		CompetenceVO competenceVO = new CompetenceVO();
		EmergencyRelationVO emergencyRelationVO = new EmergencyRelationVO();
		membersVO.setFirstName(firstName);
		membersVO.setLastName(lastName);
		membersVO.setNickname(nickname);
		membersVO.setEmail(email);
		membersVO.setGender(gender);
		membersVO.setBirthday(birthday);
		membersVO.setAddress(address);
		membersVO.setHeight(height);
		membersVO.setWeight(weight);
		membersVO.setPhone(phone);
		competenceVO.setCompetenceID(competenceID);
		membersVO.setCompetenceID(competenceVO);
		membersVO.setIdentityID(identityID);
		membersVO.setEmergencyContact(emergencyContact);
		membersVO.setEmergencyPhone(emergencyPhone);
		emergencyRelationVO.setRelationID(emergencyRelation);
		membersVO.setEmergencyRelation(emergencyRelationVO);
		
		membersDAO.insert(membersVO);
		
		System.out.println(membersVO.getFirstName());
		
		return membersVO;
	}
	
	public LoginInformationVO findByPrimaryKey(LoginInformationPK loginInformationPK){
		return loginInfoDAO.selectOne(loginInformationPK);
	}
	
	//Country取得
	@Override
	public List<CountryVO> Country(){
		
		List<CountryVO> countryVO = countryDAO.selectAll();
		
		System.out.println(countryVO);
		return countryVO;
	}
	
	//City取得
	@Override
	public List<CityVO> city(String countryID){
		
		List<CityVO> city = cityDAO.selectAll(countryID);
		
		System.out.println(city);
		return city;
	}
	
	//location取得
	@Override
	public List<LocationVO> location(String cityID){
		
		List<LocationVO> location = locationDAO.selectAll(cityID);
		
		System.out.println(location);
		return location;
	}
	
	//EmergencyRelation取得
	@Override
	public List<EmergencyRelationVO> EmergencyRelation(){
			
		List<EmergencyRelationVO> emergencyRelation = emergencyRelationDAO.selectAll();
			
		return emergencyRelation;
	}
		
	//Client驗證----------------------------------------------------------------------
	//用戶端帳號確認
	@Override
	public String AccountCheck(String memberAccount){
		LoginInformationVO loginInfo = new LoginInformationVO();
		LoginInformationPK loginInfoPK = new LoginInformationPK();
//		List<LoginInformationVO> list;
		String Info = null;
		
		loginInfoPK.setMemberAccount(memberAccount);
		loginInfoPK.setLoginMethod("1");
		
		loginInfo = loginInfoDAO.selectOne(loginInfoPK);
		if(loginInfo != null){
			Info = "fail";
		}else{
			Info = "success";
		}
		return Info;
	}
	
	//正規表示式確認
	public void regExpCheck(String memberAccount,String password){
		
	}
}
