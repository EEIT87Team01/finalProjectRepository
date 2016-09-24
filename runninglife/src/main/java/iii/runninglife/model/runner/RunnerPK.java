package iii.runninglife.model.runner;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import iii.runninglife.model.contest.ContestVO;

@Embeddable
public class RunnerPK implements Serializable{
    @Column(name = "memberID")
    private String memberID;
    @Column(name = "contestID")
    private int contestID;
	public String getMemberID() {
		return memberID;
	}
	public void setMemberID(String memberID) {
		this.memberID = memberID;
	}
	public int getContestID() {
		return contestID;
	}
	public void setContestID(int contestID) {
		this.contestID = contestID;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + contestID;
		result = prime * result + ((memberID == null) ? 0 : memberID.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof RunnerPK))
			return false;
		RunnerPK other = (RunnerPK) obj;
		if (contestID != other.contestID)
			return false;
		if (memberID == null) {
			if (other.memberID != null)
				return false;
		} else if (!memberID.equals(other.memberID))
			return false;
		return true;
	}
    
    
}
