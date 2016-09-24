package iii.runninglife.model.reportlist;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface ReportListDAO_interface {
          public void insert(ReportListVO reportListVO);
          public void update(ReportListVO reportListVO);
          public void delete(ReportListVO reportListVO);
          public ReportListVO findByPrimaryKey(ReportListPK reportListPK);
          public List<ReportListVO> getAll();
          public List<ReportListVO> getFinishReportList();
          public List<ReportListVO> getUntreatedReportList();
}

//20160908 test all ok