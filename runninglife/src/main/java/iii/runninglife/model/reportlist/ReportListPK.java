package iii.runninglife.model.reportlist;
import java.io.Serializable;

import javax.persistence.Embeddable;


@Embeddable
public class ReportListPK  implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private  String postID;
	private  String reporterID;
	public String getReporterID() {
		return reporterID;
	}
	public void setReporterID(String reporterID) {
		this.reporterID = reporterID;
	}
	public String getPostID() {
		return postID;
	}
	public void setPostID(String postID) {
		this.postID = postID;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((reporterID == null) ? 0 : reporterID.hashCode());
		result = prime * result + ((postID == null) ? 0 : postID.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof ReportListPK))
			return false;
		ReportListPK other = (ReportListPK) obj;
		if (reporterID == null) {
			if (other.reporterID != null)
				return false;
		} else if (!reporterID.equals(other.reporterID))
			return false;
		if (postID == null) {
			if (other.postID != null)
				return false;
		} else if (!postID.equals(other.postID))
			return false;
		return true;
	}	
}
