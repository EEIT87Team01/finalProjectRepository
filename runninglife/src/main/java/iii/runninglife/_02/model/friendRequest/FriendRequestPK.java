package iii.runninglife._02.model.friendRequest;

import java.io.Serializable;

import javax.persistence.*;

import iii.runninglife._02.model.members.MembersVO;

@Embeddable
public class FriendRequestPK implements Serializable{

	@ManyToOne
	@JoinColumn(name = "requesterID", referencedColumnName = "memberID")
	MembersVO requesterID;
	
	@ManyToOne
	@JoinColumn(name = "receiverID", referencedColumnName = "memberID")
	MembersVO receiverID;
	
	public FriendRequestPK() {
		super();
	}

	public FriendRequestPK(MembersVO requesterID, MembersVO receiverID) {
		super();
		this.requesterID = requesterID;
		this.receiverID = receiverID;
	}

	public MembersVO getRequesterID() {
		return requesterID;
	}

	public void setRequesterID(MembersVO requesterID) {
		this.requesterID = requesterID;
	}

	public MembersVO getReceiverID() {
		return receiverID;
	}

	public void setReceiverID(MembersVO receiverID) {
		this.receiverID = receiverID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((receiverID == null) ? 0 : receiverID.hashCode());
		result = prime * result + ((requesterID == null) ? 0 : requesterID.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof FriendRequestPK))
			return false;
		FriendRequestPK other = (FriendRequestPK) obj;
		if (receiverID == null) {
			if (other.receiverID != null)
				return false;
		} else if (!receiverID.equals(other.receiverID))
			return false;
		if (requesterID == null) {
			if (other.requesterID != null)
				return false;
		} else if (!requesterID.equals(other.requesterID))
			return false;
		return true;
	}
}
