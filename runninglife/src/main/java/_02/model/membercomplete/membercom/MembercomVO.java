package _02.model.membercomplete.membercom;

import java.sql.Blob;
import java.sql.Timestamp;
import java.util.Calendar;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

import _02.model.membercomplete.competence.CompetenceVO;
import _02.model.membercomplete.emergencyRelation.EmergencyRelationVO;
import _02.model.membercomplete.location.LocationVO;

@Entity
@Table(name = "members")
public class MembercomVO {
	
	@Id
	@GeneratedValue(generator="uuid")
	@GenericGenerator(name = "uuid", strategy = "guid")
	private String memberID;
	private String memberSeq; 
	private String firstName;
	private String lastName;
	private String nickname;
	private String email;
	private String gender;
	private String birthday;
	
	//foreign key references location
	@ManyToOne
	@JoinColumns({
		@JoinColumn (name = "cityID", referencedColumnName = "cityID"),
		@JoinColumn (name = "countryID", referencedColumnName = "countryID"),
		@JoinColumn (name = "locationID", referencedColumnName = "locationID")
	})
	private LocationVO locationID;
	
	private String address;
	private float height;
	private float weight;
	private String phone;
	private Blob photo;
	
	//foreign key references competence
	@ManyToOne
	@JoinColumn(name = "competenceID", referencedColumnName = "competenceID")
	private CompetenceVO competenceID;
	
	private String identityID;
	private String emergencyContact;
	private String emergencyPhone;
	
	//foreign key references emergencyRelation
	@ManyToOne
	@JoinColumn(name = "emergencyRelation", referencedColumnName = "relationID")
	private EmergencyRelationVO emergencyRelation;
	
	private Calendar createDate;
	private Timestamp lastOnlineDateTime;
	
	
	
	@Override
	public String toString() {
		return "MembercomVO [memberID=" + memberID + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", nickname=" + nickname + ", email=" + email + ", gender=" + gender + ", birthday=" + birthday
				+ ", locationID=" + locationID + ", address=" + address + ", height=" + height + ", weight=" + weight
				+ ", phone=" + phone + ", photo=" + photo + ", competenceID=" + competenceID + ", identityID="
				+ identityID + ", emergencyContact=" + emergencyContact + ", emergencyPhone=" + emergencyPhone
				+ ", emergencyRelation=" + emergencyRelation + ", createDate=" + createDate + ", lastOnlineDateTime="
				+ lastOnlineDateTime + "]";
	}
	public String getMemberID() {
		return memberID;
	}
	public void setMemberID(String memberID) {
		this.memberID = memberID;
	}
	public String getMemberSeq() {
		return memberSeq;
	}
	public void setMemberSeq(String memberSeq) {
		this.memberSeq = memberSeq;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public LocationVO getLocationID() {
		return locationID;
	}
	public void setLocationID(LocationVO locationID) {
		this.locationID = locationID;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public float getHeight() {
		return height;
	}
	public void setHeight(float height) {
		this.height = height;
	}
	public float getWeight() {
		return weight;
	}
	public void setWeight(float weight) {
		this.weight = weight;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Blob getPhoto() {
		return photo;
	}
	public void setPhoto(Blob photo) {
		this.photo = photo;
	}
	public CompetenceVO getCompetenceID() {
		return competenceID;
	}
	public void setCompetenceID(CompetenceVO competenceID) {
		this.competenceID = competenceID;
	}
	public String getIdentityID() {
		return identityID;
	}
	public void setIdentityID(String identityID) {
		this.identityID = identityID;
	}
	public String getEmergencyContact() {
		return emergencyContact;
	}
	public void setEmergencyContact(String emergencyContact) {
		this.emergencyContact = emergencyContact;
	}
	public String getEmergencyPhone() {
		return emergencyPhone;
	}
	public void setEmergencyPhone(String emergencyPhone) {
		this.emergencyPhone = emergencyPhone;
	}
	public EmergencyRelationVO getEmergencyRelation() {
		return emergencyRelation;
	}
	public void setEmergencyRelation(EmergencyRelationVO emergencyRelation) {
		this.emergencyRelation = emergencyRelation;
	}
	public Calendar getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Calendar createDate) {
		this.createDate = createDate;
	}
	public Timestamp getLastOnlineDateTime() {
		return lastOnlineDateTime;
	}
	public void setLastOnlineDateTime(Timestamp lastOnlineDateTime) {
		this.lastOnlineDateTime = lastOnlineDateTime;
	}
	
	
}
