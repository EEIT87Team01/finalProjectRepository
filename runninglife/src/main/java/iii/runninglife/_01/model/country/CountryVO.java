package iii.runninglife._01.model.country;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import iii.runninglife._01.model.city.CityVO;
import iii.runninglife._01.model.location.LocationVO;

@Entity
@Table(name = "country")
public class CountryVO implements Serializable{
//sql
//	[countryID] char(3),
//	  [country] varchar(50),
	@Id
	@Column(name = "countryID")
	private String countryID;
	
	private String country;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy = "cityID.countryID")
	private Set<CityVO> citys = new HashSet<CityVO>();
	
//	@OneToMany(cascade=CascadeType.ALL,  fetch=FetchType.EAGER, mappedBy="countryID")
//	@JoinColumn(name = "locationID")
//	private Set<LocationVO> locations = new HashSet<LocationVO>();
	
	public CountryVO() {
		
	}

	public CountryVO(String countryID, String country) {
		super();
		this.countryID = countryID;
		this.country = country;
	}

	//IDENTITY
//	@SequenceGenerator(name="countryID", allocationSize=1) //對應@GeneratedValue，每次增長1
//	@GeneratedValue(strategy = GenerationType.IDENTITY, generator="countryID") //主鍵自動增長，類似XML內的identity
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
	

	public Set<CityVO> getCitys() {
		return citys;
	}

	public void setCitys(Set<CityVO> citys) {
		this.citys = citys;
	}

//	public Set<LocationVO> getLocations() {
//		return locations;
//	}
//
//	public void setLocations(Set<LocationVO> locations) {
//		this.locations = locations;
//	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((citys == null) ? 0 : citys.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + ((countryID == null) ? 0 : countryID.hashCode());
//		result = prime * result + ((locations == null) ? 0 : locations.hashCode());
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
		if (citys == null) {
			if (other.citys != null)
				return false;
		} else if (!citys.equals(other.citys))
			return false;
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
//		if (locations == null) {
//			if (other.locations != null)
//				return false;
//		} else if (!locations.equals(other.locations))
//			return false;
		return true;
	}

}
