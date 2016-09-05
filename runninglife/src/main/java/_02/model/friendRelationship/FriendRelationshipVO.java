package _02.model.friendRelationship;

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
	
}
