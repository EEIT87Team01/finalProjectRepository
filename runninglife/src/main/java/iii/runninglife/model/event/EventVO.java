package iii.runninglife.model.event;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.sql.Time;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import iii.runninglife.model.contest.ContestVO;
import iii.runninglife.model.runner.RunnerVO;

@Entity
@Table(name = "event")
public class EventVO implements Serializable {
//	@Column
//	private int contestID;
	@Id
	@GeneratedValue(strategy = IDENTITY)
	private int eventID;
	@Column
	private String eventName;
	@Column
	private int distance;
	@Column
	private int fee;
	@Column
	private int quota;
	@Column
	private java.sql.Time whenToRun;
	@Column
	private int limitTime;
	@ManyToOne
	@JsonBackReference(value="event-contest")
	@JoinColumn(name = "contestID", referencedColumnName = "contestID",insertable = true, updatable = false)
	private ContestVO contestID;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "eventID",orphanRemoval = true,cascade=CascadeType.REMOVE)
	@JsonBackReference(value="event-runners")
	private Set<RunnerVO> runners ;
	
	public Set<RunnerVO> getRunners() {
		return runners;
	}
	public void setRunners(Set<RunnerVO> runners) {
		this.runners = runners;
	}


	public EventVO() {
		super();
	}
	
	public ContestVO getContest() {
		return contestID;
	}
	public void setContest(ContestVO contestID) {
		this.contestID = contestID;
	}
	//偷吃
//	public int getContestID() {
//		return contestID;
//	}
//	public void setContestID(int contestID) {
//		this.contestID = contestID;
//	}

	public int getEventID() {
		return eventID;
	}

	public void setEventID(int eventID) {
		this.eventID = eventID;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public int getFee() {
		return fee;
	}

	public void setFee(int fee) {
		this.fee = fee;
	}

	public int getQuota() {
		return quota;
	}

	public void setQuota(int quota) {
		this.quota = quota;
	}

	public Time getWhenToRun() {
		return whenToRun;
	}

	public void setWhenToRun(Time whenToRun) {
		this.whenToRun = whenToRun;
	}

	public int getLimitTime() {
		return limitTime;
	}

	public void setLimitTime(int limitTime) {
		this.limitTime = limitTime;
	}

}
