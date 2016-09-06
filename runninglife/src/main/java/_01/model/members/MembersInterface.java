package _01.model.members;

import java.util.List;

public interface MembersInterface {
	public int insert(MembersVO memberVO);
	public int update(MembersVO memberVO);
	public int delete(String memberVO);
	public MembersVO selectOne(String memberVO);
	public List<MembersVO> selectAll();
}
