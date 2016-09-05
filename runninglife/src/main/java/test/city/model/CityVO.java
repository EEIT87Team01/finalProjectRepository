package test.city.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import test.div.model.DivVO;

@Entity
@Table(name = "city")
public class CityVO implements Serializable {
	@Id
	private int cityID;
	private String cityName;
	
	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "divID")
	private Set<DivVO> divs= new HashSet<DivVO>();
	
	public int getCityID() {
		return cityID;
	}
	public void setCityID(int cityID) {
		this.cityID = cityID;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public Set<DivVO> getDivs() {
		return divs;
	}
	public void setDivs(Set<DivVO> divs) {
		this.divs = divs;
	}
	
	
}
