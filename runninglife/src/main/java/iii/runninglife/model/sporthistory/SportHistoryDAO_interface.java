package iii.runninglife.model.sporthistory;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

import org.springframework.transaction.annotation.Transactional;

import iii.runninglife.model.sporthistorypath.SportHistoryPathVO;

@Transactional
public interface SportHistoryDAO_interface {
	      public void insert(SportHistoryVO sportHistoryVO);
          public void update(SportHistoryVO sportHistoryVO);
          public void delete(String recordID);
          public SportHistoryVO findByPrimaryKey(String recordID);

          public List<SportHistoryVO> getAll();              
          public List<SportHistoryVO> getDataByMember(String memberID);
          public List<SportHistoryVO> getDataByMemberDate(String memberID,Date date);
          public List<SportHistoryVO> getDataByMemberDurationDate(String memberID,Date startDate,Date endDate);
	      public Set<SportHistoryPathVO> getPathsByRecordID(String recordID);
//	      public int getPathNextSeqByRecordID(String recordID);
	      public String getMemberCurrentRecordID(String memberID);
}
