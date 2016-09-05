package _02.model.members;

import java.util.List;

public interface MembersDAO_interface {
	public void insert(MembersVO memberVo);
	public void update(MembersVO memberVo);
	public void delete(String memberID);
	public MembersVO findByID(String memberID);
	public List<MembersVO> getAll();
	public MembersVO findByFirstName(String firstName);
	public List<MembersVO> findByFirstNameOrLastName(String firstName);
	public List<MembersVO> listFriend(MembersVO memberVO);
	public MembersVO findByAccount(String account);
}
