package _01.model.loginInformation;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import _01.model.members.MembersVO;

@Embeddable
public class LoginInformationPK implements Serializable{
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "memberID")
	private MembersVO  memberID;
	
	private String loginMethod;
	
	public LoginInformationPK() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LoginInformationPK(MembersVO memberID, String loginMethod) {
		super();
		this.memberID = memberID;
		this.loginMethod = loginMethod;
	}

	public MembersVO getMemberID() {
		return memberID;
	}

	public void setMemberID(MembersVO memberID) {
		this.memberID = memberID;
	}

	public String getLoginMethod() {
		return loginMethod;
	}

	public void setLoginMethod(String loginMethod) {
		this.loginMethod = loginMethod;
	}

}
