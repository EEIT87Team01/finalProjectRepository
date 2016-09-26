package iii.runninglife.model.friendRequest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import iii.runninglife.model.members.MembersVO;

@Service("friendRequestService")
@Transactional
public class FriendRequestService implements FriendRequestService_interface {
	
	@Autowired
	FriendRequestDAO_interface friendRequestDAO;

	@Override
	public void insert(FriendRequestVO friendRequestVO) {
		friendRequestDAO.insert(friendRequestVO);
	}

	@Override
	public void update(FriendRequestVO friendRequestVO) {
		friendRequestDAO.update(friendRequestVO);
	}

	@Override
	public void deleteByPrimaryKey(FriendRequestPK friendRequestPK) {
		friendRequestDAO.deleteByPrimaryKey(friendRequestPK);
	}

	@Override
	public FriendRequestVO findByPrimaryKey(FriendRequestPK friendRequestPK) {
		return friendRequestDAO.findByPrimaryKey(friendRequestPK);
	}
	
	@Override
	public List<FriendRequestVO> findByRequesterID(MembersVO requesterID) {
		return friendRequestDAO.findByRequesterID(requesterID);
	}

	@Override
	public List<FriendRequestVO> findByReceiverID(MembersVO receiverID) {
		return friendRequestDAO.findByReceiverID(receiverID);	
	}

	@Override
	public List<FriendRequestVO> getAll() {
		return friendRequestDAO.getAll();
	}

	@Override
	public List<MembersVO> findByRequesterIDALLReceiver(MembersVO requesterID) {
		return friendRequestDAO.findByRequesterIDALLReceiver(requesterID);
	}

	@Override
	public List<MembersVO> findByReceiverIDALLRequester(MembersVO receiverID) {
		return friendRequestDAO.findByReceiverIDALLRequester(receiverID);
	}

	
	
}
