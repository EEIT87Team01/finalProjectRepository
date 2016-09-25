package iii.runninglife.model.challdata;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "challData")
public class ChallDataVO implements Serializable{

	@EmbeddedId
	private ChallDataPK challDataPK;
	private Timestamp finishTime;
	private double processLength;
	private String duration;
	private String status;
	private String isFounder;
	

    public ChallDataVO(){
		
	}
	
	public ChallDataVO(ChallDataPK challDataPK,Timestamp finishTime,double processLength,String duration,String status,String isFounder){
		this.challDataPK=challDataPK;
		this.finishTime=finishTime;
		this.processLength=processLength;
		this.duration=duration;
		this.status=status;
		this.isFounder=isFounder;
	}
	
	
	public ChallDataPK getChallDataPK() {
		return challDataPK;
	}
	public void setChallDataPK(ChallDataPK challDataPK) {
		this.challDataPK = challDataPK;
	}

	@Column(name = "finishTime")
	public Timestamp getFinishTime() {
		return finishTime;
	}
	public void setFinishTime(Timestamp finishTime) {
		this.finishTime = finishTime;
	}
	@Column(name = "processLength")
	public double getProcessLength() {
		return processLength;
	}
	public void setProcessLength(double processLength) {
		this.processLength = processLength;
	}
	@Column(name = "duration")
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getIsFounder() {
		return isFounder;
	}

	public void setIsFounder(String isFounder) {
		this.isFounder = isFounder;
	}
	
		
}