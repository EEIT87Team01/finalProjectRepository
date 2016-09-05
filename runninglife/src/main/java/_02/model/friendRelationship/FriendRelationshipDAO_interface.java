package _02.model.friendRelationship;

import java.util.List;

import _02.model.members.MembersVO;

public interface FriendRelationshipDAO_interface {
	public void insert(FriendRelationshipVO friendRelationshipVO);
	public void update(FriendRelationshipVO friendRelationshipVO);
	public void delete(FriendRelationshipVO friendRelationshipVO);
	public FriendRelationshipVO findByPrimaryKey(FriendRelationshipPK friendRelationshipPK);
	public List<FriendRelationshipVO> findByMemberID(MembersVO membersVO);
	public List<FriendRelationshipVO> getAll();
}
