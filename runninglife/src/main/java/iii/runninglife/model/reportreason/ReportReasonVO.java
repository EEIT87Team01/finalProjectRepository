package iii.runninglife.model.reportreason;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import iii.runninglife.model.reportlist.ReportListVO;
	@Entity
	@Table(name = "reportreason")
public class ReportReasonVO implements java.io.Serializable{
	@Id
	@Column(name = "typeID")
	private String typeID;
	@Column(name = "typeContent")
	private String typeContent;
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER,mappedBy="reportReasonVO")
	@OrderBy("typeID asc")
	private Set<ReportListVO> reportlists=new HashSet<ReportListVO>();
	
	
	public String getTypeID() {
		return typeID;
	}
	public void setTypeID(String typeID) {
		this.typeID = typeID;
	}
	public String getTypeContent() {
		return typeContent;
	}
	public void setTypeContent(String typeContent) {
		this.typeContent = typeContent;
	}
	public Set<ReportListVO> getReportlists() {
		return reportlists;
	}
	public void setReportlists(Set<ReportListVO> reportlists) {
		this.reportlists = reportlists;
	}

}
	//test all ok save20160904