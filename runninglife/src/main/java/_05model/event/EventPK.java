package _05model.event;

import java.io.Serializable;

public class EventPK implements Serializable{
	private int eventID;
	private int contestID;
	public int getEventID() {
		return eventID;
	}
	public void setEventID(int eventID) {
		this.eventID = eventID;
	}
	public int getContestID() {
		return contestID;
	}
	public void setContestID(int contestID) {
		this.contestID = contestID;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + contestID;
		result = prime * result + eventID;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EventPK other = (EventPK) obj;
		if (contestID != other.contestID)
			return false;
		if (eventID != other.eventID)
			return false;
		return true;
	}
	
}
