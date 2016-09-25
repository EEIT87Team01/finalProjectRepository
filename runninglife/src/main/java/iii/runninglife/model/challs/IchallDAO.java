package iii.runninglife.model.challs;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import iii.runninglife.model.members.MembersVO;

@Transactional
public interface IchallDAO {
	public void insert(ChallsVO chall);
	public void delete(String challenID);
	public ChallsVO findByPrimaryKey(String challenID);
	public List<ChallsVO> getAll();
	public String countDateChallenge(String challenDate);
	public List<ChallsVO> findByDate();
	public List<ChallsVO> findByEndDate();
	public List<ChallsVO> findByStartDate();
	public List<ChallsVO> findByFounderID(MembersVO founderID);
} // end of class IEmpDAO