package test.div.model;

import java.io.Serializable;

import javax.persistence.*;

import test.city.model.CityVO;

@Embeddable
public class DivPK implements Serializable {
	
	@ManyToOne
	@JoinColumn(name = "cityID")
	private CityVO cityID;
	
	private int divID;

	public CityVO getCityID() {
		return cityID;
	}

	public void setCityID(CityVO cityID) {
		this.cityID = cityID;
	}

	public int getDivID() {
		return divID;
	}

	public void setDivID(int divID) {
		this.divID = divID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cityID == null) ? 0 : cityID.hashCode());
		result = prime * result + divID;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof DivPK))
			return false;
		DivPK other = (DivPK) obj;
		if (cityID == null) {
			if (other.cityID != null)
				return false;
		} else if (!cityID.equals(other.cityID))
			return false;
		if (divID != other.divID)
			return false;
		return true;
	}

}
