package iii.runninglife.model.friendRelationship;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import iii.runninglife.model.members.MembersVO;

@Service("friendRelationshipService")
@Transactional
public class FriendRelationshipService implements FriendRelationshipService_interface {
	
	@Autowired
	FriendRelationshipDAO_interface friendRelationshipDAO;
	
	@Override
	public void insert(FriendRelationshipVO friendRelationshipVO) {
		friendRelationshipDAO.insert(friendRelationshipVO);
		friendRelationshipDAO.insert(new FriendRelationshipVO (
				new FriendRelationshipPK(
						friendRelationshipVO.getFriendRelationshipPK().getFriendID(), 
						friendRelationshipVO.getFriendRelationshipPK().getMemberID())));
	}

	@Override
	public void deleteByPrimaryKey(FriendRelationshipPK friendRelationshipPK) {
		friendRelationshipDAO.deleteByPrimaryKey(friendRelationshipPK);
		friendRelationshipDAO.deleteByPrimaryKey(new FriendRelationshipPK(
				friendRelationshipPK.getFriendID(),	friendRelationshipPK.getMemberID()));
	}

	@Override
	public FriendRelationshipVO findByPrimaryKey(FriendRelationshipPK friendRelationshipPK) {
		return friendRelationshipDAO.findByPrimaryKey(friendRelationshipPK);
	}
	
	@Override
	public List<FriendRelationshipVO> findByMemberID(MembersVO memberID) {
		return friendRelationshipDAO.findByMemberID(memberID);
	}

	@Override
	public List<FriendRelationshipVO> getAll() {
		return friendRelationshipDAO.getAll();
	}

	@Override
	public List<MembersVO> findByMemberIDALLFriendID(MembersVO memberID) {
		return friendRelationshipDAO.findByMemberIDALLFriendID(memberID);
	}


}
