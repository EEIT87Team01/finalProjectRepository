package iii.runninglife.model.reportlist;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import iii.runninglife.model.competence.CompetenceVO;
import iii.runninglife.model.members.MembersInterface;
import iii.runninglife.model.members.MembersVO;
import iii.runninglife.model.posts.PostsDAO_interface;

@Service
public class ReportListService {
	
	static ReportListVO reportListVO = new ReportListVO();
	static ReportListPK reportListPK = new ReportListPK();
	static CompetenceVO competenceVO =new CompetenceVO();
	static MembersVO membersVO = new MembersVO();
	@Autowired
	ReportListDAO_interface reportListDAO;
	@Autowired
	private PostsDAO_interface postsDAO;
	@Autowired
	private MembersInterface mdao;
	
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
	public void checkReportList(String postID, String reporterID, String status) {
	
		reportListPK.setPostID(postID);
		reportListPK.setReporterID(reporterID);
		reportListVO =reportListDAO.findByPrimaryKey(reportListPK);
		reportListVO.setReportListPK(reportListPK);
		reportListVO.setTypeID(reportListVO.getTypeID());
		reportListVO.setComment(reportListVO.getComment());
		reportListVO.setTime(reportListVO.getTime());
		reportListVO.setStatus(status);
		reportListDAO.update(reportListVO);
		
		postsDAO.findByPrimaryKey(postID).getPostMemberID();
		
		membersVO = postsDAO.findByPrimaryKey(postID).getPostMemberID();
		membersVO = mdao.selectOne(membersVO.getMemberID());
		competenceVO.setCompetenceID(Integer.parseInt(status));
		membersVO.setCompetenceID(competenceVO);
		mdao.update(membersVO);		
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
	public List<ReportListVO> getUntreatedReportList() {
		List<ReportListVO> reportListVO = reportListDAO.getUntreatedReportList();
		return reportListVO;	
	}
	public List<ReportListVO> getFinishReportList(){
		List<ReportListVO> reportListVO =reportListDAO.getFinishReportList();
		return reportListVO;
	}
}