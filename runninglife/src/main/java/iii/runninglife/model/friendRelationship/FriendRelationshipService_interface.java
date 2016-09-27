package iii.runninglife.model.friendRelationship;

import java.util.List;

import iii.runninglife.model.members.MembersVO;

public interface FriendRelationshipService_interface {
	public void insert(FriendRelationshipVO friendRelationshipVO);
	public void deleteByPrimaryKey(FriendRelationshipPK friendRelationshipPK);
	public FriendRelationshipVO findByPrimaryKey(FriendRelationshipPK friendRelationshipPK);
	public List<FriendRelationshipVO> findByMemberID(MembersVO memberID);
	public List<MembersVO> findByMemberIDALLFriendID(MembersVO memberID);
	public List<FriendRelationshipVO> getAll();
}
