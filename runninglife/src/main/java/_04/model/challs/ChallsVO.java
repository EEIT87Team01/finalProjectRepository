package _04.model.challs;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;




@Entity
@Table(name = "challenges")
public class ChallsVO {
	private String challenID;
	private String challenName;
	private String locationID;
	private double challenDistance;
	private java.sql.Date challenStartTime;
	private java.sql.Date challenEndTime;
	private String comment;
	private String image;
	private String founderID;
//	private Set<ChallDataVO> challData = new HashSet<ChallDataVO>();
	public ChallsVO(){
		
	}
	
	public ChallsVO(String challenID,String challenName,String locationID,double challenDistance,java.sql.Date challenStartTime,java.sql.Date challenEndTime,String comment,String image,String founderID){
		this.challenID=challenID;
		this.challenName=challenName;
		this.locationID=locationID;
		this.challenDistance=challenDistance;
		this.challenStartTime=challenStartTime;
		this.challenEndTime=challenEndTime;
		this.comment=comment;
		
	}
	@Id
	@Column(name = "challenID")
	@SequenceGenerator(name="xxx", allocationSize=1)
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator="xxx")
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
	@Column(name = "founderID")
	public String getFounderID() {
		return founderID;
	}

	public void setFounderID(String founderID) {
		this.founderID = founderID;
	}
	
//	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
//	@OrderBy("challenID,memberID asc")
//	public Set<ChallDataVO> getChallData() {
//		return this.challData;
//	}
//
//	public void setChallData(Set<ChallDataVO> challData) {
//		this.challData = challData;
//	}
		
} // end of class EmpVO