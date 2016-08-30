package _05model.event;

import java.io.Serializable;
import java.sql.Time;

import _05model.contest.ContestVO;

public class EventVO {
	private EventPK eventPK;
	private String eventName;
	private int distance;
	private int fee;
	private int quota;
	private Time whenToRun;
	private int limitTime;
	ContestVO contestVO;
	
	
	public ContestVO getContestVO() {
		return contestVO;
	}
	public void setContestVO(ContestVO contestVO) {
		this.contestVO = contestVO;
	}
	public EventPK getEventPK() {
		return eventPK;
	}
	public void setEventPK(EventPK eventPK) {
		this.eventPK = eventPK;
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
