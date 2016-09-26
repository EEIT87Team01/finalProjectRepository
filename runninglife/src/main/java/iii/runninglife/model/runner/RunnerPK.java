package iii.runninglife.model.runner;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import iii.runninglife.model.contest.ContestVO;
import iii.runninglife.model.members.MembersVO;

@Embeddable
public class RunnerPK implements Serializable{
    @ManyToOne
    @JoinColumn(name = "memberID", referencedColumnName = "memberID")
    private MembersVO memberID;
    @ManyToOne
    @JoinColumn(name = "contestID", referencedColumnName = "contestID")
    private ContestVO contestID;
	public MembersVO getMemberID() {
		return memberID;
	}
	public void setMemberID(MembersVO memberID) {
		this.memberID = memberID;
	}
	public ContestVO getContestID() {
		return contestID;
	}
	public void setContestID(ContestVO contestID) {
		this.contestID = contestID;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((contestID == null) ? 0 : contestID.hashCode());
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
		if (contestID == null) {
			if (other.contestID != null)
				return false;
		} else if (!contestID.equals(other.contestID))
			return false;
		if (memberID == null) {
			if (other.memberID != null)
				return false;
		} else if (!memberID.equals(other.memberID))
			return false;
		return true;
	}
    
    
}
