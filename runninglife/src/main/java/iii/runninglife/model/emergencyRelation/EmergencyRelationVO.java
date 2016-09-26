package iii.runninglife.model.emergencyRelation;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import iii.runninglife.model.members.MembersVO;

@Entity
@Table(name = "emergencyRelation")
public class EmergencyRelationVO implements Serializable{
	@Id
	@Column(name = "relationID")
	private int relationID;
	private String relationName;
	
	public EmergencyRelationVO() {
		super();
	}
	public EmergencyRelationVO(int relationID, String relationName) {
		super();
		this.relationID = relationID;
		this.relationName = relationName;
	}
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
