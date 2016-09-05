package _02.model.membercomplete.city;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "city")
public class CityVO implements Serializable {
	
	@EmbeddedId
	private CityPK cityPK;
	
	private String cityName;

	public CityPK getCityPK() {
		return cityPK;
	}

	public void setCityPK(CityPK cityPK) {
		this.cityPK = cityPK;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	
}