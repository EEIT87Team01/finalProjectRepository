package _02.model.members;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
	
	@ManyToMany(cascade={CascadeType.MERGE}, fetch = FetchType.LAZY)
	@JoinTable(name="friendRequest",
		joinColumns={@JoinColumn(name="requesterID")},
		inverseJoinColumns={@JoinColumn(name="receiverID")})
	private Set<MembersVO> friendRequest = new HashSet<MembersVO>();
	
	@ManyToMany(mappedBy="friendRequest", fetch = FetchType.LAZY)
	private Set<MembersVO> friendReceive = new HashSet<MembersVO>();
	
	@ManyToMany(cascade={CascadeType.MERGE}, fetch = FetchType.LAZY)
	@JoinTable(name="friendRelationship",
		joinColumns={@JoinColumn(name="memberID")},
		inverseJoinColumns={@JoinColumn(name="friendID")})
	private Set<MembersVO> friends = new HashSet<MembersVO>();

	@ManyToMany(mappedBy="friends", fetch = FetchType.LAZY)
	private Set<MembersVO> inverseFriends = new HashSet<MembersVO>();
	
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
	
	public Set<MembersVO> getFriendRequest() {
		return friendRequest;
	}

	public void setFriendRequest(Set<MembersVO> friendRequest) {
		this.friendRequest = friendRequest;
	}

	public Set<MembersVO> getFriendReceive() {
		return friendReceive;
	}

	public void setFriendReceive(Set<MembersVO> friendReceive) {
		this.friendReceive = friendReceive;
	}

	public Set<MembersVO> getFriends() {
		return friends;
	}

	public void setFriends(Set<MembersVO> friends) {
		this.friends = friends;
	}

	public Set<MembersVO> getInverseFriends() {
		return inverseFriends;
	}

	public void setInverseFriends(Set<MembersVO> inverseFriends) {
		this.inverseFriends = inverseFriends;
	}
}