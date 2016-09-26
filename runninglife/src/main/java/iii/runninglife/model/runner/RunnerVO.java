package iii.runninglife.model.runner;

import java.io.Serializable;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import iii.runninglife.model.contest.ContestVO;
import iii.runninglife.model.event.EventVO;
import iii.runninglife.model.team.TeamVO;

@Entity
@Table(name = "runner")
public class RunnerVO implements Serializable {
	// @Column(name = "memberID")
	// @OneToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	// @JoinColumn(name="memberID")
	@EmbeddedId
	private RunnerPK runnerPK;
	@ManyToOne
	@JoinColumn(name = "eventID", referencedColumnName = "eventID",insertable = false, updatable = false)
	private EventVO eventID;
	@ManyToOne
	@JoinColumn(name = "teamID", referencedColumnName = "teamID",insertable = false, updatable = false)
	private TeamVO teamID;
	@Column
	private String clothesSize;
	@Column
	private Time runTime;
//	@JoinColumn(name = "contestID", referencedColumnName = "contestID", updatable = false, insertable = false)
//	private int contestID;
	@Column
	private String status;
	
	public RunnerVO() {
		super();
	}
	public TeamVO getTeamID() {
		return teamID;
	}
	public void setTeamID(TeamVO teamID) {
		this.teamID = teamID;
	}
	public EventVO getEventID() {
		return eventID;
	}
	public void setEventID(EventVO eventID) {
		this.eventID = eventID;
	}
	public RunnerPK getRunnerPK() {
		return runnerPK;
	}

	public void setRunnerPK(RunnerPK runnerPK) {
		this.runnerPK = runnerPK;
	}

	public String getClothesSize() {
		return clothesSize;
	}

	public void setClothesSize(String clothesSize) {
		this.clothesSize = clothesSize;
	}

	public Time getRunTime() {
		return runTime;
	}

	public void setRunTime(Time runTime) {
		this.runTime = runTime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	

}
