package _01.model.location;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import _01.model.city.CityVO;
import _01.model.country.CountryVO;
import _01.model.members.MembersVO;

@Entity
@Table(name = "location")
public class LocationVO implements Serializable{
//	SELECT TOP 1000 [locationID]
//		      ,[cityID]
//		      ,[countryID]
//		      ,[locationName]
	@EmbeddedId
	private LocationPK locationID;
	
	@Column(name = "locationName")
	private String locationName;
	
//	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="locationID")
//	private Set<MembersVO> members = new HashSet<MembersVO>();
			
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

//	public Set<MembersVO> getMembers() {
//		return members;
//	}
//
//	public void setMembers(Set<MembersVO> members) {
//		this.members = members;
//	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((locationID == null) ? 0 : locationID.hashCode());
		result = prime * result + ((locationName == null) ? 0 : locationName.hashCode());
//		result = prime * result + ((members == null) ? 0 : members.hashCode());
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
//		if (members == null) {
//			if (other.members != null)
//				return false;
//		} else if (!members.equals(other.members))
//			return false;
		return true;
	}

	@Override
	public String toString() {
		return "LocationVO [locationID=" + locationID + ", locationName=" + locationName + "]";
	}
	
	
}
