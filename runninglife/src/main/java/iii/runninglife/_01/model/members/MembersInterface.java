package iii.runninglife._01.model.members;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface MembersInterface {
	public void insert(MembersVO memberVO);
	public void update(MembersVO memberVO);
	public void delete(String memberVO);
	public MembersVO selectOne(String memberVO);
	public List<MembersVO> selectAll();
}
