package _01.controller.loginController;

import java.io.IOException;
import java.util.Map;

import _01.model.members.MembersVO;

public interface LoginService_Interface {
	public Map<String ,Object> checkPassword(String memberAccount,String password);
	public MembersVO insertMember(Map<String ,Object> loginInfo);
	public byte[] changeMD5Encoding(String password);
}
