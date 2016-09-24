package iii.runninglife.model.loginInformation;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import iii.runninglife.model.members.MembersVO;

@Embeddable
public class LoginInformationPK implements Serializable{
	
	
	private String memberAccount;
	private String loginMethod;
	
	
	public LoginInformationPK() {
		super();
	}


	public LoginInformationPK(String memberAccount, String loginMethod) {
		super();
		this.memberAccount = memberAccount;
		this.loginMethod = loginMethod;
	}


	public String getMemberAccount() {
		return memberAccount;
	}


	public void setMemberAccount(String memberAccount) {
		this.memberAccount = memberAccount;
	}


	public String getLoginMethod() {
		return loginMethod;
	}


	public void setLoginMethod(String loginMethod) {
		this.loginMethod = loginMethod;
	}

	

}
