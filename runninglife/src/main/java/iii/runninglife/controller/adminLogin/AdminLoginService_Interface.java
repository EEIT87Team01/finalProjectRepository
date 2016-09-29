package iii.runninglife.controller.adminLogin;

import java.io.UnsupportedEncodingException;
import java.util.Map;

import iii.runninglife.model.admins.AdminsVO;
import iii.runninglife.model.members.MembersVO;

public interface AdminLoginService_Interface {
	public Map<String ,Object> CheckPassword(String adminAccount,String password);
	public AdminsVO InsertAdmin(Map<String ,Object> loginInfo);
	public AdminsVO createAdmin(String adminAccount,String password,String name,String levelID,String status) throws UnsupportedEncodingException;
	public MembersVO MemberUpdate(String memberID);
	public MembersVO MemberSelectOne(String memberID);
}
