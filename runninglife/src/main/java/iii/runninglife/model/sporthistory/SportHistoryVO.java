package iii.runninglife.model.sporthistory;

import java.sql.Timestamp;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import iii.runninglife.model.sporthistorypath.SportHistoryPathVO;

@Entity
@Table(name="sportHistory")
public class SportHistoryVO implements java.io.Serializable {

	@Id
	private String recordID;
	private String memberID;
	private Timestamp startDateTime;
	private Timestamp endDateTime;
	private String duration;
	private Double avgSpeed;
	private Double length;
	private String locationID;
	
	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "recordID")
	@OrderBy(value="recordID,seq")
	private Set<SportHistoryPathVO> sportHistoryPaths = new LinkedHashSet<SportHistoryPathVO>();
	
	public SportHistoryVO() {
	}

	public String getRecordID() {
		return recordID;
	}

	public void setRecordID(String recordID) {
		this.recordID = recordID;
	}

	public String getMemberID() {
		return memberID;
	}

	public void setMemberID(String memberID) {
		this.memberID = memberID;
	}

	public Timestamp getStartDateTime() {
		return startDateTime;
	}

	public void setStartDateTime(Timestamp startDateTime) {
		this.startDateTime = startDateTime;
	}

	public Timestamp getEndDateTime() {
		return endDateTime;
	}

	public void setEndDateTime(Timestamp endDateTime) {
		this.endDateTime = endDateTime;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public Double getAvgSpeed() {
		return avgSpeed;
	}

	public void setAvgSpeed(Double avgSpeed) {
		this.avgSpeed = avgSpeed;
	}

	public Double getLength() {
		return length;
	}

	public void setLength(Double length) {
		this.length = length;
	}

	public String getLocationID() {
		return locationID;
	}

	public void setLocationID(String locationID) {
		this.locationID = locationID;
	}

	public Set<SportHistoryPathVO> getSportHistoryPaths() {
		return sportHistoryPaths;
	}

	public void setSportHistoryPaths(Set<SportHistoryPathVO> sportHistoryPaths) {
		this.sportHistoryPaths = sportHistoryPaths;
	}
}
