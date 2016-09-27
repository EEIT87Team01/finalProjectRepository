package iii.runninglife.model.team;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import iii.runninglife.model.contest.ContestVO;
import iii.runninglife.model.runner.RunnerVO;


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
	@ManyToOne
	@JsonBackReference(value="team-contest")
	@JoinColumn(name = "contestID", referencedColumnName = "contestID",insertable = false, updatable = false)
	private ContestVO contest;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "team",orphanRemoval = true,cascade=CascadeType.REMOVE)
	@JsonBackReference(value="team-runners")
	private Set<RunnerVO> runners ;
	public ContestVO getContest() {
		return contest;
	}
	public void setContest(ContestVO contest) {
		this.contest = contest;
	}
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
