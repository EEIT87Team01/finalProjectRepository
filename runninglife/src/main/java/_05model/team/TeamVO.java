package _05model.team;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import _05model.runner.RunnerVO;

@Entity
@Table(name="team")
public class TeamVO implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int teamID;
	@Column
	private int contestID;
	@Column
	private String teamName;
	@Column
	private int ageRange;
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "team",cascade=CascadeType.ALL)
	private Set<RunnerVO> runners ;
	
	public Set<RunnerVO> getRunners() {
		return runners;
	}
	public void setRunners(Set<RunnerVO> runners) {
		this.runners = runners;
	}
	public int getTeamID() {
		return teamID;
	}
	public void setTeamID(int teamID) {
		this.teamID = teamID;
	}
	public int getContestID() {
		return contestID;
	}
	public void setContestID(int contestID) {
		this.contestID = contestID;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public int getAgeRange() {
		return ageRange;
	}
	public void setAgeRange(int ageRange) {
		this.ageRange = ageRange;
	}
	
}
