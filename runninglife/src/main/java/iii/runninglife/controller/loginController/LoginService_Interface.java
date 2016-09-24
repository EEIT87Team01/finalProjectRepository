package iii.runninglife.controller.loginController;

import java.util.List;
import java.util.Map;

import iii.runninglife.model.city.CityVO;
import iii.runninglife.model.country.CountryVO;
import iii.runninglife.model.location.LocationVO;
import iii.runninglife.model.members.MembersVO;

public interface LoginService_Interface {
	public Map<String ,Object> CheckPassword(String memberAccount,String password);
	public MembersVO InsertMember(Map<String ,Object> loginInfo);
	public String ForgetPaswd(String memberAccount,String memberEmail);
	public Map<String ,Object> CheckVerification(String memberAccount,String loginSataus);
	public MembersVO ChangePaswd(String memberAccount,String password);
	public MembersVO CreateMember(String memberAccount,String password,String firstName,String lastName,String phone,
			String email ,String gender,String birthday);
	public MembersVO UpdateMember(String firstName,String lastName,String nickname,
			String email ,String gender,String birthday ,String address
			, Double height, Double weight, String phone,int competenceID, String identityID, String emergencyContact
			, String emergencyPhone, int emergencyRelation);
	public List<CountryVO> Country();
	public List<CityVO> city(String countryID);
	public List<LocationVO> location(String cityID);
}
