package _05model.runner;

import java.io.Serializable;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import _05model.contest.ContestVO;

@Entity
@Table(name = "runner")
public class RunnerVO implements Serializable {
	// @Column(name = "memberID")
	// @OneToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	// @JoinColumn(name="memberID")
	@EmbeddedId
	private RunnerPK pk;
	@Column
	private int eventID;
	@Column
	private int teamID;
	@Column
	private String clothesSize;
	@Column
	private Time runTime;
//	@JoinColumn(name = "contestID", referencedColumnName = "contestID", updatable = false, insertable = false)
//	private int contestID;
	@ManyToOne
	@JoinColumn(name = "contestID", referencedColumnName = "contestID",insertable = false, updatable = false)
	private ContestVO contest;

	public ContestVO getContest() {
		return contest;
	}
	public void setContest(ContestVO contest) {
		this.contest = contest;
	}
	public RunnerPK getPk() {
		return pk;
	}

	public void setPk(RunnerPK pk) {
		this.pk = pk;
	}

	public int getEventID() {
		return eventID;
	}

	public void setEventID(int eventID) {
		this.eventID = eventID;
	}

	public int getTeamID() {
		return teamID;
	}

	public void setTeamID(int teamID) {
		this.teamID = teamID;
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

}