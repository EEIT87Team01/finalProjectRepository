package _02.model.friendRelationship;

import java.util.List;

public interface FriendRelationshipService_interface {
	public void insert(FriendRelationshipVO friendRelationshipVO);
	public void deleteByPrimaryKey(FriendRelationshipPK friendRelationshipPK);
	public FriendRelationshipVO findByPrimaryKey(FriendRelationshipPK friendRelationshipPK);
	public List<FriendRelationshipVO> getAll();
}
