package _02.model.membercomplete.competence;

import java.io.Serializable;

public class CompetenceVO implements Serializable{
	
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
