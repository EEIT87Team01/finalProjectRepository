package _02.model.friendRelationship;

import java.util.List;

import _02.model.members.MembersVO;

public interface FriendRelationshipDAO_interface {
	public void insert(FriendRelationshipVO friendRelationshipVO);
	public void deleteByPrimaryKey(FriendRelationshipPK friendRelationshipPK);
	public FriendRelationshipVO findByPrimaryKey(FriendRelationshipPK friendRelationshipPK);
	public List<FriendRelationshipVO> findByMemberID(MembersVO MemberID);
	public List<FriendRelationshipVO> getAll();
}
