package iii.runninglife.controller.adminLogin;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import iii.runninglife.globalservice.GlobalService;
import iii.runninglife.model.admins.AdminsInterface;
import iii.runninglife.model.admins.AdminsVO;
import iii.runninglife.model.adminsPriority.AdminsPriorityVO;
import iii.runninglife.model.members.MembersDAO;
import iii.runninglife.model.members.MembersInterface;
import iii.runninglife.model.members.MembersVO;

@Service
public class AdminLoginService implements AdminLoginService_Interface{

	AdminsVO adminsVO = new AdminsVO();
	AdminsPriorityVO adminsPritoryVO = new AdminsPriorityVO();
	@Autowired
	AdminsInterface adminsDAO;
	@Autowired
	MembersInterface membersDAO;
	@Autowired
	GlobalService globalservice;
	//管理者登入
	@Override
	public Map<String, Object> CheckPassword(String adminAccount, String password) {
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
				//輸入帳號CO Hibernate
				adminsVO = adminsDAO.selectOne(adminAccount);
				//確認資料庫有此帳號
				if(adminsVO != null){
					//轉碼
					insetPswd= globalservice.changeMD5Encoding(password);
					//取出byte[]
					for  (byte e : insetPswd) 
						System.out.print(e);
					//從DB取出
					byte[] dbPassword = adminsVO.getPassword();
					//取出byte[]
					for  (byte e : dbPassword) 
						System.out.print(e);
												
					//確認密碼正確
					if(dbPassword != null && Arrays.equals(dbPassword, insetPswd)){
						adminsVO.setAdminAccount(adminAccount);
						adminsVO.setPassword(dbPassword);
						message = "登入成功";
						InfoMsg.put("Msg",message);
						InfoMsg.put("Info",adminsVO);
					    
						return InfoMsg;
						/***************************其他可能的錯誤處理*************************************/
					}else{
						message = "密碼錯誤";
						InfoMsg.put("Msg",message);
						InfoMsg.put("Info",adminsVO);
						return InfoMsg;
					}
				}else{
					message = "帳號不存在";
					InfoMsg.put("Msg",message);
					return InfoMsg;
				}
	}
	
	//管理者登出
	@Override
	public AdminsVO InsertAdmin(Map<String ,Object> loginInfo){
		String adminsAccount = null;
		adminsAccount = ((AdminsVO)loginInfo.get("Info")).getAdminAccount();
		adminsVO = adminsDAO.selectOne(adminsAccount);
		return adminsVO;
	}
	
	//新增管理者
	@Override
	public AdminsVO createAdmin(String adminAccount,String password,String name,String levelID,String status) throws UnsupportedEncodingException{
			
		MessageDigest mDigest = null;
		try {
			mDigest = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
			
		adminsVO.setAdminAccount(adminAccount);
		byte[] temp = password.getBytes("UTF-8");	//明碼  //使用者輸入byte[]
		temp = mDigest.digest(temp); 		//亂碼
		adminsVO.setPassword(temp);
		adminsVO.setName(name);
		
		adminsPritoryVO.setLevelID(levelID);
		adminsVO.setLevelID(adminsPritoryVO);
		adminsVO.setStatus(status);
		
		adminsDAO.insert(adminsVO);
		return adminsVO;
	}
	
	@Override
	public MembersVO MemberUpdate(String memberID) {
		MembersVO membersVO = new MembersVO();
		membersVO.setMemberID(memberID);
		membersDAO.update(membersVO);
		return membersVO;
	}
	
	@Override
	public MembersVO MemberSelectOne(String memberID) {
		MembersVO membersVO = new MembersVO();
		membersDAO.selectOne(memberID);
		return membersVO;
	}
		
}
