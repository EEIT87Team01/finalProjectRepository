package _02.model.membercomplete.country;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import _02.model.membercomplete.city.CityVO;

@Entity
@Table(name = "country")
public class CountryVO implements Serializable {
	
	@Id
	private String countryID;
	
	private String countryName;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "cityPK.countryID")
	private List<CityVO> cityID;

	public String getCountryID() {
		return countryID;
	}

	public void setCountryID(String countryID) {
		this.countryID = countryID;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public List<CityVO> getCityID() {
		return cityID;
	}

	public void setCityID(List<CityVO> cityID) {
		this.cityID = cityID;
	}
	
	
}
