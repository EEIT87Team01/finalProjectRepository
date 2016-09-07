package _01.model.loginInformation;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import _01.model.members.MembersVO;

@Entity
@Table(name = "loginInformation")
public class LoginInformationVO implements Serializable{
	
	@EmbeddedId
	private LoginInformationPK memberAccount;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "memberID")
	private MembersVO  memberID;
	
	private String password;
	private String status;
	
	public LoginInformationVO() {

	}

	public LoginInformationVO(LoginInformationPK memberAccount, MembersVO memberID, String password, String status) {
		super();
		this.memberAccount = memberAccount;
		this.memberID = memberID;
		this.password = password;
		this.status = status;
	}

	public LoginInformationPK getMemberAccount() {
		return memberAccount;
	}

	public void setMemberAccount(LoginInformationPK memberAccount) {
		this.memberAccount = memberAccount;
	}

	public MembersVO getMemberID() {
		return memberID;
	}

	public void setMemberID(MembersVO memberID) {
		this.memberID = memberID;
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

}
