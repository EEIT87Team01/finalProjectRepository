package iii.runninglife._02.model.friendRelationship;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "FriendRelationship")
public class FriendRelationshipVO implements Serializable {
	
	@EmbeddedId
	private FriendRelationshipPK friendRelationshipPK;

	public FriendRelationshipVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FriendRelationshipVO(FriendRelationshipPK friendRelationshipPK) {
		super();
		this.friendRelationshipPK = friendRelationshipPK;
	}

	public FriendRelationshipPK getFriendRelationshipPK() {
		return friendRelationshipPK;
	}

	public void setFriendRelationshipPK(FriendRelationshipPK friendRelationshipPK) {
		this.friendRelationshipPK = friendRelationshipPK;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((friendRelationshipPK == null) ? 0 : friendRelationshipPK.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof FriendRelationshipVO))
			return false;
		FriendRelationshipVO other = (FriendRelationshipVO) obj;
		if (friendRelationshipPK == null) {
			if (other.friendRelationshipPK != null)
				return false;
		} else if (!friendRelationshipPK.equals(other.friendRelationshipPK))
			return false;
		return true;
	}
	
}
