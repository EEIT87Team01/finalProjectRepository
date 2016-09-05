package _02.model.membercomplete.competence;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "competence")
public class CompetenceVO implements Serializable{
	@Id
	private int competenceID;
	private String competenceName;
	
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
	
	
}
