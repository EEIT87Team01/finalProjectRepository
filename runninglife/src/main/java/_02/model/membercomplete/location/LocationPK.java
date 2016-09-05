package _02.model.membercomplete.location;

import java.io.Serializable;

import javax.persistence.*;

import _02.model.membercomplete.city.CityVO;

@Embeddable
public class LocationPK implements Serializable {
	
	@ManyToOne
	@JoinColumns({
		@JoinColumn (name = "cityID", referencedColumnName = "cityID"),
		@JoinColumn (name = "countryID", referencedColumnName = "countryID")
	})
	private CityVO cityID;
	
	private String locationID;

	//import getter(), setter(), equals(), hashCode()
	//right click/source/(generate getter() and setter() / generate equals() and hashCode())
	
	public CityVO getCityID() {
		return cityID;
	}

	public void setCityID(CityVO cityID) {
		this.cityID = cityID;
	}

	public String getLocationID() {
		return locationID;
	}

	public void setLocationID(String locationID) {
		this.locationID = locationID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cityID == null) ? 0 : cityID.hashCode());
		result = prime * result + ((locationID == null) ? 0 : locationID.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof LocationPK))
			return false;
		LocationPK other = (LocationPK) obj;
		if (cityID == null) {
			if (other.cityID != null)
				return false;
		} else if (!cityID.equals(other.cityID))
			return false;
		if (locationID == null) {
			if (other.locationID != null)
				return false;
		} else if (!locationID.equals(other.locationID))
			return false;
		return true;
	}
	
}
