package _05model.contest;

import java.sql.Date;
import java.sql.Timestamp;

public class ContestVO {
	private int contestID;
	private String contestName;
	private String place;
	private Date startDate;
	private Timestamp registrationBegin;
	private Timestamp registrationEnd;
	private String goal;
	private String organizer;
	private String coorganizer;
	private String contestPhotoPath;
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
		return registrationBegin;
	}
	public void setRegistrationBegin(Timestamp registrationBegin) {
		this.registrationBegin = registrationBegin;
	}
	public Timestamp getRegistrationEnd() {
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
	
	
}
