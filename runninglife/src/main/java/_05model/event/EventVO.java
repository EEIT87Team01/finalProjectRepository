package _05model.event;

import java.io.Serializable;
import static javax.persistence.GenerationType.IDENTITY;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import _05model.contest.ContestVO;
import _05model.team.TeamVO;
@Entity
@Table(name = "event")
public class EventVO implements Serializable{
	private int contestID;
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
	private Time whenToRun;
	@Column
	private int limitTime;
//	private ContestVO contestVO;
	public int getContestID() {
		return contestID;
	}
	public void setContestID(int contestID) {
		this.contestID = contestID;
	}
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
