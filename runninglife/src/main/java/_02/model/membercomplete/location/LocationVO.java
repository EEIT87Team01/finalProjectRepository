package _02.model.membercomplete.location;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "location")
public class LocationVO implements Serializable  {
	
	@EmbeddedId	
	private LocationPK locationPK;
	
	@Column(name = "locationName")
	private String locationName;

	public LocationPK getLocationPK() {
		return locationPK;
	}

	public void setLocationPK(LocationPK locationPK) {
		this.locationPK = locationPK;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}
	
}
