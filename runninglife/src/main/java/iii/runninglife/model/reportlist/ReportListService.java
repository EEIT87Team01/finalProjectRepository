package iii.runninglife.model.reportlist;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

@Service
public class ReportListService {
	
	ReportListVO reportListVO = new ReportListVO();
	ReportListPK reportListPK = new ReportListPK();
	
	@Autowired
	ReportListDAO_interface reportListDAO;
	
	public ReportListVO newReport(String postID,String reporterID,String typeID , String comment ){
		reportListPK.setPostID(postID);
		reportListPK.setReporterID(reporterID);
		reportListVO.setReportListPK(reportListPK);
		reportListVO.setTypeID(typeID);
		reportListVO.setComment(comment);
		reportListVO.setTime(new Timestamp(System.currentTimeMillis()));
		reportListVO.setStatus("0");
		reportListDAO.insert(reportListVO);
		return reportListVO;
	}
	public ReportListVO getReportAll(String postID,String reporterID,String typeID , String comment ){
		reportListPK.setPostID(postID);
		reportListPK.setReporterID(reporterID);
		reportListVO.setReportListPK(reportListPK);
		reportListVO.setTypeID(typeID);
		reportListVO.setComment(comment);
		reportListVO.setTime(new Timestamp(System.currentTimeMillis()));
		reportListVO.setStatus("0");
		reportListDAO.insert(reportListVO);
		return reportListVO;
	}
	public ReportListVO ProcessReport(String postID , String status){
		
//		reportListPK.setPostID(postID);
//		reportListPK.setReporterID(reporterID);
//		reportListVO.setReportListPK(reportListPK);
//		reportListVO.setTypeID(typeID);
//		reportListVO.setComment(comment);
//		reportListVO.setTime(new Timestamp(System.currentTimeMillis()));
//		reportListVO.setStatus("0");
		reportListDAO.insert(reportListVO);
		return reportListVO;
	}
	
	public ReportListVO getOneReportList(String postID, String reporterID){
		reportListPK.setPostID(postID);
		reportListPK.setReporterID(reporterID);
		reportListVO =reportListDAO.findByPrimaryKey(reportListPK);
		return reportListVO;
	}
	
	
	public List<ReportListVO> getAll(){
		List<ReportListVO> reportListVO =reportListDAO.getAll();
		return reportListVO;
	}
	public List<ReportListVO> getUntreatedReportList(){
		List<ReportListVO> reportListVO =reportListDAO.getUntreatedReportList();
			return reportListVO;	
	}
	public List<ReportListVO> getFinishReportList(){
		List<ReportListVO> reportListVO =reportListDAO.getFinishReportList();
		return reportListVO;
	}
}