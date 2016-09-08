package _02.model.members;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "member")
public class MembersVO implements java.io.Serializable {
	
	@Id
	@GeneratedValue(generator="uuid")
	@GenericGenerator(name = "uuid", strategy = "guid")
	private String memberID;
	
	private String firstName;
	
	private String lastName;
	
	private String nickname;
	
	private String account;
	
	private String password;
	
	@Override
	public String toString() {
		return "MembersVO [memberID=" + memberID + ", firstName=" + firstName + ", lastName=" + lastName + ", nickname="
				+ nickname + ", account=" + account + ", password=" + password + "]";
	}

	public String getMemberID() {
		return memberID;
	}

	public void setMemberID(String memberID) {
		this.memberID = memberID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((account == null) ? 0 : account.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((memberID == null) ? 0 : memberID.hashCode());
		result = prime * result + ((nickname == null) ? 0 : nickname.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)return true;
		if (obj == null)return false;
		if (!(obj instanceof MembersVO))return false;
		
		MembersVO other = (MembersVO) obj;
		
		if (account == null) {
			if (other.account != null)return false;
		} else if (!account.equals(other.account))return false;
		
		if (firstName == null) {
			if (other.firstName != null)return false;
		} else if (!firstName.equals(other.firstName))return false;
		
		if (lastName == null) {
			if (other.lastName != null)return false;
		} else if (!lastName.equals(other.lastName))return false;
		
		if (memberID == null) {
			if (other.memberID != null)return false;
		} else if (!memberID.equals(other.memberID))return false;
		
		if (nickname == null) {
			if (other.nickname != null)return false;
		} else if (!nickname.equals(other.nickname))return false;
		
		if (password == null) {
			if (other.password != null)return false;
		} else if (!password.equals(other.password))return false;
		
		return true;
	}
	
}