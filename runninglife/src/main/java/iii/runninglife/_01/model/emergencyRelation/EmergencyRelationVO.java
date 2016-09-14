package iii.runninglife._01.model.emergencyRelation;

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

import iii.runninglife._01.model.members.MembersVO;

@Entity
@Table(name = "emergencyRelation")
public class EmergencyRelationVO implements Serializable{
//	  [relationID] int,
//	  [relationName] varchar(20),
	@Id
	@Column(name = "relationID")
	private int relationID;
	private String relationName;
	
	public EmergencyRelationVO() {
		super();
		// TODO Auto-generated constructor stub
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
//	public Set<MembersVO> getMembers() {
//		return members;
//	}
//	public void setMembers(Set<MembersVO> members) {
//		this.members = members;
//	}
	
}
