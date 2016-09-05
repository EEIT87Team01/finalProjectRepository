package _02.model.members;

import java.util.List;

import javax.persistence.*;

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
	
	@ManyToMany(cascade={CascadeType.MERGE}, fetch = FetchType.EAGER)
	@JoinTable(name="friendRequest",
		joinColumns={@JoinColumn(name="requesterID")},
		inverseJoinColumns={@JoinColumn(name="receiverID")})
	private List<MembersVO> friendRequest;
	
	@ManyToMany(mappedBy="friendRequest", fetch = FetchType.EAGER)
	private List<MembersVO> friendReceive;
	
	@ManyToMany(cascade={CascadeType.MERGE}, fetch = FetchType.EAGER)
	@JoinTable(name="friendRelationship",
		joinColumns={@JoinColumn(name="memberID")},
		inverseJoinColumns={@JoinColumn(name="friendID")})
	private List<MembersVO> friends;

	@ManyToMany(mappedBy="friends", fetch = FetchType.EAGER)
	private List<MembersVO> inverseFriends;
	
	
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

	public List<MembersVO> getFriendRequest() {
		return friendRequest;
	}

	public void setFriendRequest(List<MembersVO> friendRequest) {
		this.friendRequest = friendRequest;
	}

	public List<MembersVO> getFriendReceive() {
		return friendReceive;
	}

	public void setFriendReceive(List<MembersVO> friendReceive) {
		this.friendReceive = friendReceive;
	}

	public List<MembersVO> getFriends() {
		return friends;
	}

	public void setFriends(List<MembersVO> friends) {
		this.friends = friends;
	}

	public List<MembersVO> getInverseFriends() {
		return inverseFriends;
	}

	public void setInverseFriends(List<MembersVO> inverseFriends) {
		this.inverseFriends = inverseFriends;
	}
	
	
	
}
