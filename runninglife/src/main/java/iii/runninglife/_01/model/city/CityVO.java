package iii.runninglife._01.model.city;

import java.io.Serializable;


import javax.persistence.*;

@Entity
@Table(name = "city")
public class CityVO implements Serializable{
	@EmbeddedId
	private CityPK cityID;
	 
	private String cityName;
	
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

}
