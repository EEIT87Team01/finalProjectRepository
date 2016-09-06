package _01.model.loginInformation;

import java.util.List;

public interface LoginInformationInterface {
	public int insert(LoginInformationVO loginInformationVO);
	public int update(LoginInformationVO loginInformationVO);
	public int delete(LoginInformationPK loginInformationPK);
	public LoginInformationVO selectOne(LoginInformationPK loginInformationPK);
	public List<LoginInformationVO> selectAll(LoginInformationVO loginInformationVO);
}
