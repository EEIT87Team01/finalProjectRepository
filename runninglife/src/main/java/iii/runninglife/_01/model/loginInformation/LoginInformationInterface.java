package iii.runninglife._01.model.loginInformation;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface LoginInformationInterface {
	public void insert(LoginInformationVO loginInformationVO);
	public void update(LoginInformationVO loginInformationVO);
	public void delete(LoginInformationPK loginInformationPK);
	public LoginInformationVO selectOne(LoginInformationPK loginInformationPK);
	public List<LoginInformationVO> selectAll(LoginInformationVO loginInformationVO);
}
