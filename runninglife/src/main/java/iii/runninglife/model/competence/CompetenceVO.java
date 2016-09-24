package iii.runninglife.model.competence;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import iii.runninglife.model.members.MembersVO;

@Entity
@Table(name = "competence")
public class CompetenceVO implements Serializable{
//	SQL
//	[competenceID] int,
//	  [competenceName] varchar(20),
	@Id
	private int competenceID;
	private String competenceName;
	

	
	public CompetenceVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CompetenceVO(int competenceID, String competenceName) {
		super();
		this.competenceID = competenceID;
		this.competenceName = competenceName;
	}

	public int getCompetenceID() {
		return competenceID;
	}

	public void setCompetenceID(int competenceID) {
		this.competenceID = competenceID;
	}

	public String getCompetenceName() {
		return competenceName;
	}

	public void setCompetenceName(String competenceName) {
		this.competenceName = competenceName;
	}

	@Override
	public String toString() {
		return "CompetenceVO [competenceID=" + competenceID + ", competenceName=" + competenceName + "]";
	}

}
