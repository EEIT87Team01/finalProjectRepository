package _01.model.city;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


import javax.persistence.*;
//import javax.persistence.CascadeType;
//import javax.persistence.EmbeddedId;
//import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.OneToMany;
//import javax.persistence.OrderBy;
//import javax.persistence.Table;

import _01.model.location.LocationVO;

@Entity
@Table(name = "city")
public class CityVO implements Serializable{
	//sql
//	  [cityID] char(3),
//	  [countryID] char(3),
//	  [cityName] varchar(50),
	@EmbeddedId
	private CityPK cityID;
	 
	private String cityName;
	
//	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="cityID")
//	@OrderBy("cityID,asc")
//	private Set<LocationVO> locations = new HashSet<LocationVO>();
	
	public CityVO() {
		
	}
	
	public CityPK getCityID() {
		return cityID;
	}

	public void setCityID(CityPK cityID) {
		this.cityID = cityID;
	}

	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

//	public Set<LocationVO> getLocations() {
//		return locations;
//	}
//
//	public void setLocations(Set<LocationVO> locations) {
//		this.locations = locations;
//	}
}
