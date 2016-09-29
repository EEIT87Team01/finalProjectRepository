package iii.runninglife.model.friendRelationship;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import iii.runninglife.model.members.MembersVO;

@Embeddable
public class FriendRelationshipPK implements Serializable{

	@ManyToOne
	@JoinColumn(name = "memberID", referencedColumnName = "memberID")
	MembersVO memberID;
	
	@ManyToOne
	@JoinColumn(name = "friendID", referencedColumnName = "memberID")
	MembersVO friendID;

	public FriendRelationshipPK() {
		super();
	}

	public FriendRelationshipPK(MembersVO memberID, MembersVO friendID) {
		super();
		this.memberID = memberID;
		this.friendID = friendID;
	}

	public MembersVO getMemberID() {
		return memberID;
	}

	public void setMemberID(MembersVO memberID) {
		this.memberID = memberID;
	}

	public MembersVO getFriendID() {
		return friendID;
	}

	public void setFriendID(MembersVO friendID) {
		this.friendID = friendID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((friendID == null) ? 0 : friendID.hashCode());
		result = prime * result + ((memberID == null) ? 0 : memberID.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof FriendRelationshipPK))
			return false;
		FriendRelationshipPK other = (FriendRelationshipPK) obj;
		if (friendID == null) {
			if (other.friendID != null)
				return false;
		} else if (!friendID.equals(other.friendID))
			return false;
		if (memberID == null) {
			if (other.memberID != null)
				return false;
		} else if (!memberID.equals(other.memberID))
			return false;
		return true;
	}
	
}
