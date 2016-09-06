package _01.model.loginInformation;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import _01.model.members.MembersVO;

@Entity
@Table(name = "loginInformation")
public class LoginInformationVO implements Serializable{
	
	@EmbeddedId
	private LoginInformationPK memberID;
	
	private String memberAccount;
	private String password;
	private String status;
	
	public LoginInformationVO() {

	}

	public LoginInformationVO(LoginInformationPK memberID, String memberAccount, String password, String status) {
		super();
		this.memberID = memberID;
		this.memberAccount = memberAccount;
		this.password = password;
		this.status = status;
	}

	public LoginInformationPK getLoginInformationID() {
		return memberID;
	}


	public void setLoginInformationID(LoginInformationPK memberID) {
		this.memberID = memberID;
	}


	public String getMemberAccount() {
		return memberAccount;
	}


	public void setMemberAccount(String memberAccount) {
		this.memberAccount = memberAccount;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "LoginInformationVO [membersID=" + memberID + ", memberAccount=" + memberAccount + ", password="
				+ password + ", status=" + status + "]";
	}
	
}
