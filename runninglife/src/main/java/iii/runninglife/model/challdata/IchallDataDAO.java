package iii.runninglife.model.challdata;

import java.sql.Date;
import java.sql.SQLException;
import java.util.*;

import org.springframework.transaction.annotation.Transactional;

import iii.runninglife.model.members.MembersVO;

@Transactional
public interface IchallDataDAO {
	public void insert(ChallDataVO challDataVO);
	public void insertByFounder(ChallDataVO challDataVO);
	public void update(ChallDataVO challDataVO);
	public void delete(ChallDataPK two_ID);
	public ChallDataVO findByPrimaryKey(ChallDataPK two_ID);
	public List<ChallDataVO> getAll();
	public List<ChallDataVO> findByChall(String challenID);
	public List<ChallDataVO> findByMember(String memberID);
	public List<ChallDataVO> findByMemberAndTime(String memberID, Date startTime, Date endTime);
	public List<ChallDataVO> findByMemberProcessing(MembersVO memberID);
	public List<ChallDataVO> findByMemberFinish(MembersVO memberID);
	public List<ChallDataVO> findByMemberReserved(MembersVO memberID);
	public List<ChallDataVO> findByMemberReceivedRequest(MembersVO memberID);
} // end of class IEmpDAO