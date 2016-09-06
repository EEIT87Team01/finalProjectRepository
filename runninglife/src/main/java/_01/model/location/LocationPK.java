package _01.model.location;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import _01.model.city.CityVO;

@Embeddable
public class LocationPK  implements Serializable{

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumns({
		@JoinColumn (name = "cityID", referencedColumnName = "cityID"),
		@JoinColumn (name = "countryID", referencedColumnName = "countryID")
	})
	private CityVO cityID;
	
	private String locationID;

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
		if (getClass() != obj.getClass())
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

	@Override
	public String toString() {
		return "LocationPK [cityID=" + cityID + ", locationID=" + locationID + "]";
	}
	
}
