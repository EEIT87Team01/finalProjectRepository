package iii.runninglife.model.runner;

import java.io.Serializable;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import iii.runninglife.model.contest.ContestVO;
import iii.runninglife.model.event.EventVO;
import iii.runninglife.model.members.MembersVO;
import iii.runninglife.model.team.TeamVO;


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
	@OneToOne
	@JoinColumn(name = "memberID", referencedColumnName = "memberID", insertable = false, updatable = false)
	private MembersVO member;
	@Column
	private String status;
	@ManyToOne
	@JsonBackReference(value="runner-contest")
	@JoinColumn(name = "contestID", referencedColumnName = "contestID",insertable = false, updatable = false)
	private ContestVO contest;
	@ManyToOne
	@JoinColumn(name = "eventID", referencedColumnName = "eventID",insertable = false, updatable = false)
	private EventVO event;
	@ManyToOne
	@JoinColumn(name = "teamID", referencedColumnName = "teamID",insertable = false, updatable = false)
	private TeamVO team;
	
	public RunnerVO() {
		super();
	}
	public TeamVO getTeam() {
		return team;
	}
	public void setTeam(TeamVO team) {
		this.team = team;
	}
	public EventVO getEvent() {
		return event;
	}
	public void setEvent(EventVO event) {
		this.event = event;
	}
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public MembersVO getMember() {
		return member;
	}
	public void setMember(MembersVO member) {
		this.member = member;
	}
	

}
