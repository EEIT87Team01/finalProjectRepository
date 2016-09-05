package _02.model.membercomplete.emergencyRelation;

import javax.persistence.*;

@Entity
@Table(name = "emergencyRelation")
public class EmergencyRelationVO {
	@Id
	private int relationID;
	private String relationName;
	
	public int getRelationID() {
		return relationID;
	}
	public void setRelationID(int relationID) {
		this.relationID = relationID;
	}
	public String getRelationName() {
		return relationName;
	}
	public void setRelationName(String relationName) {
		this.relationName = relationName;
	}
	
	
}
