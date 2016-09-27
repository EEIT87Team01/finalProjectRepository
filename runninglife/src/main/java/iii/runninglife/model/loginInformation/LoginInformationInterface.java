package iii.runninglife.model.loginInformation;

import java.util.List;

public interface LoginInformationInterface {
	public void insert(LoginInformationVO loginInformationVO);
	public void update(LoginInformationVO loginInformationVO);
	public LoginInformationVO selectOne(LoginInformationPK loginInformationPK);
	public List<LoginInformationVO> selectAll(LoginInformationVO loginInformationVO);
}
