package _02.model.friendRelationship;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("friendRelationshipService")
@Transactional
public class FriendRelationshipService implements FriendRelationshipService_interface {
	
	@Autowired
	FriendRelationshipDAO_interface friendRelationshipDAO;
	
	@Override
	public void insert(FriendRelationshipVO friendRelationshipVO) {
		friendRelationshipDAO.insert(friendRelationshipVO);
	}

	@Override
	public void deleteByPrimaryKey(FriendRelationshipPK friendRelationshipPK) {
		friendRelationshipDAO.deleteByPrimaryKey(friendRelationshipPK);
	}

	@Override
	public FriendRelationshipVO findByPrimaryKey(FriendRelationshipPK friendRelationshipPK) {
		return friendRelationshipDAO.findByPrimaryKey(friendRelationshipPK);
	}

	@Override
	public List<FriendRelationshipVO> getAll() {
		return friendRelationshipDAO.getAll();
	}

}
