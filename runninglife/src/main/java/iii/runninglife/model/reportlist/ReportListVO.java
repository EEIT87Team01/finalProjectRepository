package iii.runninglife.model.reportlist;


import java.sql.Timestamp;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import iii.runninglife.model.members.MembersVO;
import iii.runninglife.model.posts.PostsVO;
import iii.runninglife.model.reportreason.ReportReasonVO;

@Entity
@Table(name = "ReportList")
public class ReportListVO  implements java.io.Serializable{
	@EmbeddedId
	private ReportListPK reportListPK;
	@ManyToOne
	@JoinColumn(name = "postID" ,insertable = false, updatable = false)
	private PostsVO postID;
	@ManyToOne
	@JoinColumn(name = "reporterID" ,insertable = false, updatable = false)
	private MembersVO memberID;
	private String typeID;
	private	String comment;
	private	Timestamp time;
	private String status;
	@ManyToOne
	@JoinColumn(name = "typeID" ,insertable = false, updatable = false)
	private ReportReasonVO reportReasonVO;
	public ReportListVO(){
		
	}
	public ReportListVO(PostsVO postID, MembersVO reportID, String typeID, String comment, Timestamp time, String status) {
				this.postID = postID;
				this.memberID =reportID;
				this.typeID=typeID;
				this.comment =comment;
				this.time=time;
				this.status=status;
	}
	
	
	public ReportListPK getReportListPK() {
		return reportListPK;
	}
	public void setReportListPK(ReportListPK reportListPK) {
		this.reportListPK = reportListPK;
	}
	public PostsVO getPostID() {
		return postID;
	}
	public void setPostID(PostsVO postID) {
		this.postID = postID;
	}
	public MembersVO getReporterID() {
		return memberID;
	}
	public void setReporterID(MembersVO reporterID) {
		this.memberID = reporterID;
	}
	public String getTypeID() {
		return typeID;
	}
	public void setTypeID(String typeID) {
		this.typeID = typeID;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Timestamp getTime() {
		return time;
	}
	public void setTime(Timestamp time) {
		this.time= time;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public ReportReasonVO getReportReasonVO() {
		return reportReasonVO;
	}
	public void setReportReasonVO(ReportReasonVO reportReasonVO) {
		this.reportReasonVO = reportReasonVO;
	}

	
}
