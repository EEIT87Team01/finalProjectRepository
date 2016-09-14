package iii.runninglife._02.model.friendRequest;

import java.util.List;

import iii.runninglife._02.model.members.MembersVO;

public interface FriendRequestDAO_interface {
	
	public void insert(FriendRequestVO friendRequestVO);
	public void update(FriendRequestVO friendRequestVO);
	public void deleteByPrimaryKey(FriendRequestPK friendRequestPK);
	public FriendRequestVO findByPrimaryKey(FriendRequestPK friendRequestPK);
	public List<FriendRequestVO> findByRequesterID(MembersVO requesterID);
	public List<MembersVO> findByRequesterIDALLReceiver(MembersVO requesterID);
	public List<FriendRequestVO> findByReceiverID(MembersVO receiverID);
	public List<MembersVO> findByReceiverIDALLRequester(MembersVO receiverID);
	public List<FriendRequestVO> getAll();
	
}
