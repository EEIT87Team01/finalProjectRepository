package iii.runninglife.model.adsClick;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import iii.runninglife.model.ads.AdsVO;


@Entity
@Table(name = "adsClick")
public class AdsClickVO  implements java.io.Serializable{

	@EmbeddedId
	private AdsClickPK adsClickPK;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "adID",insertable = false, updatable = false)
	private AdsVO adID;
	@Column(name = "clickDay",insertable = false, updatable = false)
	private java.sql.Date clickDay;
	private int countClick;
	
	
	public AdsClickVO (){
		
	}
	
	public AdsClickVO (AdsClickPK adsClick_PK,int countClick){
		this.adsClickPK=adsClick_PK;
		this.countClick=countClick;
	}
	public AdsClickPK getAdsClick_PK() {
		return adsClickPK;
	}
	public void setAdsClick_PK(AdsClickPK adsClick_PK) {
		this.adsClickPK = adsClick_PK;
	}
	@Column(name = "adID")
	public AdsVO getAdID() {
		return adID;
	}
	public void setAdID(AdsVO adID) {
		this.adID = adID;
	}

	
	@Column(name = "clickDay")
	public java.sql.Date getClickDay() {
		return clickDay;
	}
	public void setClickDay(java.sql.Date clickDay) {
		this.clickDay = clickDay;
	}
	@Column(name = "countClick")
	public int getCountClick() {
		return countClick;
	}
	public void setCountClick(int countClick) {
		this.countClick = countClick;
	}
	
		
} // end of class EmpVO