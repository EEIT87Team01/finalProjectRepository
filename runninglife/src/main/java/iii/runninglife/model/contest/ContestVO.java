package iii.runninglife.model.contest;

import static javax.persistence.GenerationType.IDENTITY;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import iii.runninglife.model.event.EventVO;
import iii.runninglife.model.runner.RunnerVO;
import iii.runninglife.model.team.TeamVO;
@Entity
@Table(name="contest")
public class ContestVO {
	@Id
	@GeneratedValue(strategy = IDENTITY)
	private int contestID;
	@Column
	private String contestName;
	@Column
	private String place;
	@Column
	private Date startDate;
	@Column
	private Timestamp registrationBegin;
	@Column
	private Timestamp registrationEnd;
	@Column
	private String goal;
	@Column
	private String organizer;
	@Column
	private String coorganizer;
	@Column
	private String contestPhotoPath;
	//一對多
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "contestID",cascade=CascadeType.REMOVE)
	private List<EventVO> events ;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "contestID",cascade=CascadeType.REMOVE)
	private List<TeamVO> teams ;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "runnerPK.contestID",cascade=CascadeType.REMOVE)
	private List<RunnerVO> runners ;
	
	public List<EventVO> getEvents() {
		return events;
	}
	public void setEvents(List<EventVO> events) {
		this.events = events;
	}
	public List<TeamVO> getTeams() {
		return teams;
	}
	public void setTeams(List<TeamVO> teams) {
		this.teams = teams;
	}
	public List<RunnerVO> getRunners() {
		return runners;
	}
	public void setRunners(List<RunnerVO> runners) {
		this.runners = runners;
	}
	public int getContestID() {
		return contestID;
	}
	public void setContestID(int contestID) {
		this.contestID = contestID;
	}
	public String getContestName() {
		return contestName;
	}
	public void setContestName(String contestName) {
		this.contestName = contestName;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Timestamp getRegistrationBegin() {
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 hh:mm");
//		return sdf.format(registrationBegin);
		return registrationBegin;
	}

	public void setRegistrationBegin(Timestamp registrationBegin) {
		this.registrationBegin = registrationBegin;
	}
	public Timestamp getRegistrationEnd() {
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 hh:mm");
//		return sdf.format(registrationEnd);
		return registrationEnd;
	}
	public void setRegistrationEnd(Timestamp registrationEnd) {
		this.registrationEnd = registrationEnd;
	}
	public String getGoal() {
		return goal;
	}
	public void setGoal(String goal) {
		this.goal = goal;
	}
	public String getOrganizer() {
		return organizer;
	}
	public void setOrganizer(String organizer) {
		this.organizer = organizer;
	}
	public String getCoorganizer() {
		return coorganizer;
	}
	public void setCoorganizer(String coorganizer) {
		this.coorganizer = coorganizer;
	}
	public String getContestPhotoPath() {
		return contestPhotoPath;
	}
	public void setContestPhotoPath(String contestPhotoPath) {
		this.contestPhotoPath = contestPhotoPath;
	}
	public String getBegin() { 
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 hh:mm");
		return sdf.format(registrationBegin);
	}
	public String getEnd() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 hh:mm");
		return sdf.format(registrationEnd);
	}
	public Boolean getStart(){
		Boolean status = false;
		long current =System.currentTimeMillis();
		long begin= getRegistrationBegin().getTime();
		long end= getRegistrationEnd().getTime();
		if(current>begin && current<end){
			status = true;
		}
		return status;
	}
}
