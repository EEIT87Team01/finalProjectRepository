package _02.model.friendRequest;

import java.util.List;

public interface FriendRequestDAO_interface {
	public void insert(FriendRequestVO friendRequestVO);
	public void update(FriendRequestVO friendRequestVO);
	public void deleteByPrimaryKey(FriendRequestPK friendRequestPK);
	public FriendRequestVO findByPrimaryKey(FriendRequestPK friendRequestPK);
	public List<FriendRequestVO> getAll();
}
