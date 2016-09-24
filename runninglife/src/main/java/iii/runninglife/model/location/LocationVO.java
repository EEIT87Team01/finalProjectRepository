package iii.runninglife.model.location;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name = "location")
public class LocationVO implements Serializable{
	@EmbeddedId
	private LocationPK locationID;
	@Column(name = "locationName")
	private String locationName;
	
	public LocationVO() {
		
	}

	public LocationVO(LocationPK locationID, String locationName) {
		super();
		this.locationID = locationID;
		this.locationName = locationName;
	}

	public LocationPK getLocationID() {
		return locationID;
	}

	public void setLocationID(LocationPK locationID) {
		this.locationID = locationID;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((locationID == null) ? 0 : locationID.hashCode());
		result = prime * result + ((locationName == null) ? 0 : locationName.hashCode());
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
		LocationVO other = (LocationVO) obj;
		if (locationID == null) {
			if (other.locationID != null)
				return false;
		} else if (!locationID.equals(other.locationID))
			return false;
		if (locationName == null) {
			if (other.locationName != null)
				return false;
		} else if (!locationName.equals(other.locationName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "LocationVO [locationID=" + locationID + ", locationName=" + locationName + "]";
	}
	
	
}
