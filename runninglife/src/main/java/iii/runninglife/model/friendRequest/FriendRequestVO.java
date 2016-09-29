package iii.runninglife.model.friendRequest;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "FriendRequest")
public class FriendRequestVO implements Serializable{
	
	@EmbeddedId
	FriendRequestPK friendRequestPK;

	public FriendRequestVO() {
		super();
	}

	public FriendRequestVO(FriendRequestPK friendRequestPK) {
		super();
		this.friendRequestPK = friendRequestPK;
	}

	public FriendRequestPK getFriendRequestPK() {
		return friendRequestPK;
	}

	public void setFriendRequestPK(FriendRequestPK friendRequestPK) {
		this.friendRequestPK = friendRequestPK;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((friendRequestPK == null) ? 0 : friendRequestPK.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof FriendRequestVO))
			return false;
		FriendRequestVO other = (FriendRequestVO) obj;
		if (friendRequestPK == null) {
			if (other.friendRequestPK != null)
				return false;
		} else if (!friendRequestPK.equals(other.friendRequestPK))
			return false;
		return true;
	}
	
}
