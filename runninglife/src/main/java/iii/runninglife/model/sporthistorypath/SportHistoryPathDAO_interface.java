package iii.runninglife.model.sporthistorypath;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface SportHistoryPathDAO_interface {
          public void insert(SportHistoryPathVO sportHistoryPathVO);
          public void update(SportHistoryPathVO sportHistoryPathVO);
          public void delete(SportHistoryPathPK sportHistoryPathPK);
          public SportHistoryPathVO findByPrimaryKey(SportHistoryPathPK sportHistoryPathPK);
          public int getNextSeqByRecordID(String recordID);
          public List<SportHistoryPathVO> getPathsByRecordID(String recordID);
          public List<SportHistoryPathVO> getAll();
}
