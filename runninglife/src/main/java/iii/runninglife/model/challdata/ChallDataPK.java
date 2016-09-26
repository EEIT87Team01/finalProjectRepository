package iii.runninglife.model.challdata;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import iii.runninglife.model.challs.ChallsVO;
import iii.runninglife.model.members.MembersVO;


@Embeddable 
public class ChallDataPK implements Serializable {

	@ManyToOne
	@JoinColumn(name = "challenID", referencedColumnName = "challenID")
	private ChallsVO challenID;
	@ManyToOne
	@JoinColumn(name = "memberID", referencedColumnName = "memberID")
	private MembersVO memberID;
    
	public ChallDataPK(){
		
	}
	
    public ChallDataPK(ChallsVO challenID,MembersVO memberID){
		this.challenID=challenID;
		this.memberID=memberID;
	}
    
	@Override
	public int hashCode() {
		int result = 1;
		result = challenID.hashCode() + memberID.hashCode();
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final ChallDataPK other = (ChallDataPK) obj;
		if (challenID == other.challenID && memberID == other.memberID)
			return true;
		return false;
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
	public void setMemberID(MembersVO membersVO) {
		this.memberID = membersVO;
	}

}
