package iii.runninglife.model.friendRequest;

import java.util.List;

import iii.runninglife.model.members.MembersVO;

public interface FriendRequestService_interface {
	
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
