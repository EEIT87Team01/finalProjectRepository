package iii.runninglife.model.members;

import java.util.List;

public interface MembersInterface {
	public void insert(MembersVO memberVO);
	public void update(MembersVO memberVO);
	public void delete(String memberVO);
	public MembersVO selectOne(String memberVO);
	public List<MembersVO> selectAll();
	public List<MembersVO> findByFirstNameOrLastName(String name);
}
