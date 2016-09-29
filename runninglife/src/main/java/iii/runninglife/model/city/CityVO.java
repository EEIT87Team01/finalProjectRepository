package iii.runninglife.model.city;

import java.io.Serializable;

//import javax.persistence.CascadeType;
//import javax.persistence.EmbeddedId;
//import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.OneToMany;
//import javax.persistence.OrderBy;
//import javax.persistence.Table;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;

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
