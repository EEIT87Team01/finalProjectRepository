package iii.runninglife.model.country;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;

import iii.runninglife.model.city.CityVO;

@Entity
@Table(name = "country")
public class CountryVO implements Serializable{
	@Id
	@Column(name = "countryID")
	private String countryID;
	private String country;
	
	public CountryVO() {
		
	}

	public CountryVO(String countryID, String country) {
		super();
		this.countryID = countryID;
		this.country = country;
	}

	public String getCountryID() {
		return countryID;
	}

	public void setCountryID(String countryID) {
		this.countryID = countryID;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "CountryVO [countryID=" + countryID + ", country=" + country + "]";
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((country == null) ? 0 : country.hashCode());
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
		CountryVO other = (CountryVO) obj;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (countryID == null) {
			if (other.countryID != null)
				return false;
		} else if (!countryID.equals(other.countryID))
			return false;
		return true;
	}

}
