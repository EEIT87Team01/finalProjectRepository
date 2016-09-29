package iii.runninglife.model.city;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.beans.factory.annotation.Autowired;

import iii.runninglife.model.country.CountryVO;

@Embeddable
public class CityPK implements Serializable {

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "countryID")
	private CountryVO countryID;

	private String cityID;

	public CountryVO getCountryID() {
		return countryID;
	}

	public void setCountryID(CountryVO countryID) {
		this.countryID = countryID;
	}

	public String getCityID() {
		return cityID;
	}

	public void setCityID(String cityID) {
		this.cityID = cityID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cityID == null) ? 0 : cityID.hashCode());
		result = prime * result + ((countryID == null) ? 0 : countryID.hashCode());
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
		CityPK other = (CityPK) obj;
		if (cityID == null) {
			if (other.cityID != null)
				return false;
		} else if (!cityID.equals(other.cityID))
			return false;
		if (countryID == null) {
			if (other.countryID != null)
				return false;
		} else if (!countryID.equals(other.countryID))
			return false;
		return true;
	}

}
