package _02.model.members;

import java.util.List;

public interface MembersService_interface {
	
	public void insert(MembersVO memberVo);
	public void update(MembersVO memberVo);
	public void deleteByPrimaryKey(String memberID);
	public MembersVO findByID(String memberID);
	public List<MembersVO> getAll();
	public MembersVO findByFirstName(String firstName);
	public List<MembersVO> findByFirstNameOrLastName(String name);
	public MembersVO findByAccount(String account);
	public MembersVO listFriend(String memberID);
	public MembersVO listFriendReceive(String memberID);
}
