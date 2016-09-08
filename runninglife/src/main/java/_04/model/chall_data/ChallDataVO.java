package _04.model.chall_data;

import java.sql.Timestamp;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import _04.model.challs.ChallsVO;
import _04.model.members.MembersVO;



@Entity
@Table(name = "challData")
public class ChallDataVO {

	@EmbeddedId
	private Two_ID two_ID;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "challenID",insertable = false, updatable = false)
	private  ChallsVO challenID;
	@ManyToOne
	@JoinColumn(name = "memberID",insertable = false, updatable = false)
	private MembersVO memberID;
	private Timestamp finishTime;
	private double processLength;
	private double duration;

    public ChallDataVO(){
		
	}
	
	public ChallDataVO(Two_ID two_ID,Timestamp finishTime,double processLength,double duration){
		this.two_ID=two_ID;
		this.finishTime=finishTime;
		this.processLength=processLength;
		this.duration=duration;
	}
	
	
	public Two_ID getId() {
		return two_ID;
	}
	public void setId(Two_ID id) {
		this.two_ID = id;
	}

	public ChallsVO getChallenID() {
		return challenID;
	}

	public void setChallenID(ChallsVO challenID) {
		this.challenID = challenID;
	}

	public MembersVO getMemberID() {
		return memberID;
	}

	public void setMemberID(MembersVO memberID) {
		this.memberID = memberID;
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
	public double getDuration() {
		return duration;
	}
	public void setDuration(double duration) {
		this.duration = duration;
	}
	
		
} // end of class EmpVO