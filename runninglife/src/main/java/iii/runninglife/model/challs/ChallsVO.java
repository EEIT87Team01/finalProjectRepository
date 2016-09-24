package iii.runninglife.model.challs;


import java.io.Serializable;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import iii.runninglife.model.challdata.ChallDataVO;
import iii.runninglife.model.members.MembersVO;

@Entity
@Table(name = "challenges")
public class ChallsVO implements Serializable{
	@Id
	private String challenID;
	private String challenName;
	private String locationID;
	private double challenDistance;
	private java.sql.Date challenStartTime;
	private java.sql.Date challenEndTime;
	private String comment;
	private String image;
	private MembersVO founderID;
	
//	@OneToMany
//	@JoinColumn( name = "challDataPK.challenID")
//	private Set<ChallDataVO> challDatas = new HashSet<ChallDataVO>();
	
//	@OneToMany( fetch = FetchType.LAZY, mappedBy = "challDatas.challDataPK.memberID" )
//	@JoinColumn( name = "memberID" )
//	private Set<MembersVO> members = new HashSet<MembersVO>();
	
//	public Set<ChallDataVO> getChallDatas() {
//		return challDatas;
//	}
//
//	public void setChallDatas(Set<ChallDataVO> challDatas) {
//		this.challDatas = challDatas;
//	}

	public ChallsVO(){
		
	}
	
	public ChallsVO(String challenID,String challenName,String locationID,double challenDistance,java.sql.Date challenStartTime,java.sql.Date challenEndTime,String comment,String image,MembersVO founderID){
		this.challenID=challenID;
		this.challenName=challenName;
		this.locationID=locationID;
		this.challenDistance=challenDistance;
		this.challenStartTime=challenStartTime;
		this.challenEndTime=challenEndTime;
		this.comment=comment;
		this.founderID = founderID;
	}
	@Id
	@Column(name = "challenID")
	public String getChallenID() {
		return challenID;
	}
	public void setChallenID(String challenID) {
		this.challenID = challenID;
	}
	@Column(name = "challenName")
	public String getChallenName() {
		return challenName;
	}
	public void setChallenName(String challenName) {
		this.challenName = challenName;
	}
	@Column(name = "locationID")
	public String getLocationID() {
		return locationID;
	}
	public void setLocationID(String locationID) {
		this.locationID = locationID;
	}
	@Column(name = "challenDistance")
	public double getChallenDistance() {
		return challenDistance;
	}
	public void setChallenDistance(double challenDistance) {
		this.challenDistance = challenDistance;
	}
	@Column(name = "challenStartTime")
	public java.sql.Date getChallenStartTime() {
		return challenStartTime;
	}
	public void setChallenStartTime(java.sql.Date challenStartTime) {
		this.challenStartTime = challenStartTime;
	}
	@Column(name = "challenEndTime")
	public java.sql.Date getChallenEndTime() {
		return challenEndTime;
	}
	public void setChallenEndTime(java.sql.Date challenEndTime) {
		this.challenEndTime = challenEndTime;
	}
	@Column(name = "comment")
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	@Column(name = "image")
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	@ManyToOne
	@JoinColumn( name = "founderID", referencedColumnName = "memberID")
	public MembersVO getFounderID() {
		return founderID;
	}

	public void setFounderID(MembersVO founderID) {
		this.founderID = founderID;
	}

		
} // end of class EmpVO