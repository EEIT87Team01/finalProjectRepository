package _04.model.chall_data;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;


@Embeddable 
public class Two_ID implements Serializable {

	private static final long serialVersionUID = 1L;
    
	
	@Column(name="challenID")
	private String challenID;
    @Column(name="memberID")
	private String memberID;
    
	public Two_ID(){
		
	}
	
    public Two_ID(String challenID,String memberID){
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
		final Two_ID other = (Two_ID) obj;
		if (challenID == other.challenID && memberID == other.memberID)
			return true;
		return false;
	}
	
	
	public String getChallenID() {
		return challenID;
	}
	public void setChallenID(String challenID) {
		this.challenID = challenID;
	}

	public String getMemberID() {
		return memberID;
	}
	public void setMemberID(String membersVO) {
		this.memberID = membersVO;
	}

}
