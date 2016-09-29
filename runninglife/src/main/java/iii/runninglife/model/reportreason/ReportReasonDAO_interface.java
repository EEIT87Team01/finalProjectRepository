package iii.runninglife.model.reportreason;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface ReportReasonDAO_interface {
          public void insert(ReportReasonVO peportReasonVO);
          public void update(ReportReasonVO peportReasonVO);
          public void delete(String typeID);
          public ReportReasonVO findByPrimaryKey(String peportReasonVO);
          public List<ReportReasonVO> getAll();
}