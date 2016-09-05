package _02.model.friendRequest;

import java.util.List;

import _02.model.members.MembersVO;

public interface FriendRequestDAO_interface {
	public void insert(FriendRequestVO friendRequestVO);
	public void update(FriendRequestVO friendRequestVO);
	public void delete(FriendRequestVO friendRequestVO);
	public FriendRequestVO findByPrimaryKey(FriendRequestPK friendRequestPK);
	public List<FriendRequestVO> findByRequesterID(MembersVO membersVO);
	public List<FriendRequestVO> findByReceiverID(MembersVO membersVO);
	public List<FriendRequestVO> getAll();
}
