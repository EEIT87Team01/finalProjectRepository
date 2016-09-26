package iii.runninglife.model.reportreason;

import java.util.List;
import java.util.Set;

import org.springframework.transaction.annotation.Transactional;

import iii.runninglife.model.reportlist.ReportListVO;

@Transactional
public interface ReportReasonDAO_interface {
          public void insert(ReportReasonVO peportReasonVO);
          public void update(ReportReasonVO peportReasonVO);
          public void delete(String typeID);
          public ReportReasonVO findByPrimaryKey(String peportReasonVO);
          public List<ReportReasonVO> getAll();
}
//test all ok save20160904