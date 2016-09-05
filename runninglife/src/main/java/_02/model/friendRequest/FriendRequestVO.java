package _02.model.friendRequest;

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

}
