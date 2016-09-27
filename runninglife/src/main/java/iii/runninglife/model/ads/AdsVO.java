package iii.runninglife.model.ads;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ads")
public class AdsVO  implements java.io.Serializable{

	private String adID;
	private String adName;
	private String division;
	private String link;
	private java.sql.Date adStartTime;
	private java.sql.Date adEndTime;
	private int priority;
	private String image;
	
	
	public AdsVO (){
		
	}
	
	public AdsVO (String adID,String adName,String division,String link,java.sql.Date adStartTime,java.sql.Date adEndTime,int priority,String image){
		this.adID=adID;
		this.adName=adName;
		this.division=division;
		this.link=link;
		this.adStartTime=adStartTime;
		this.adEndTime=adEndTime;
		this.priority=priority;
		this.image=image;
	}
	@Id
	@Column(name = "adID")
	public String getAdID() {
		return adID;
	}
	public void setAdID(String adID) {
		this.adID = adID;
	}

	@Column(name = "adName")  
	public String getAdName() {
		return adName;
	}
	public void setAdName(String adName) {
		this.adName = adName;
	}
	@Column(name = "division")
	public String getDivision() {
		return division;
	}
	public void setDivision(String division) {
		this.division = division;
	}
	@Column(name = "link")
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
//	@Temporal(TemporalType.DATE)
	@Column(name = "adStartTime")
	public java.sql.Date getAdStartTime() {
		return adStartTime;
	}
	public void setAdStartTime(java.sql.Date adStartTime) {
		this.adStartTime = adStartTime;
	}
//	@Temporal(TemporalType.DATE)
	@Column(name = "adEndTime")
	public java.sql.Date getAdEndTime() {
		return adEndTime;
	}
	public void setAdEndTime(java.sql.Date adEndTime) {
		this.adEndTime = adEndTime;
	}
	@Column(name = "priority")
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	@Column(name = "image")
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
		
} // end of class EmpVO