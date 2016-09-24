package iii.runninglife.model.adsClick;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;


@Embeddable 
public class AdsClickPK implements Serializable {

	private static final long serialVersionUID = 1L;
    
	
	@Column(name="adID")
	private String adID;
    @Column(name="clickDay")
	private java.sql.Date clickDay;
    
	public AdsClickPK(){
		
	}
	
    public AdsClickPK(String adID,java.sql.Date clickDay){
		this.adID=adID;
		this.clickDay=clickDay;
	}
    
	@Override
	public int hashCode() {
		int result = 1;
		result = adID.hashCode() + clickDay.hashCode();
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
		final AdsClickPK other = (AdsClickPK) obj;
		if (adID == other.adID && clickDay == other.clickDay)
			return true;
		return false;
	}
	
	
	public String getAdID() {
		return adID;
	}
	public void setAdID(String adID) {
		this.adID = adID;
	}

	public java.sql.Date getClickDay() {
		return clickDay;
	}
	public void setClickDay(java.sql.Date clickDay) {
		this.clickDay = clickDay;
	}

}
