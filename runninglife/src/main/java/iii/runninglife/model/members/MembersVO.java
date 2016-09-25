package iii.runninglife.model.members;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name = "members")
public class MembersVO implements Serializable{
	@Id
	@GeneratedValue(generator="uuid")
	@GenericGenerator(name= "uuid", strategy = "uuid2")
	private String memberID;
	private String firstName;
	private String lastName;
	private String nickname;
	private String email;
	private String gender;
	private String birthday;
	
	@ManyToOne 
	@JoinColumns({
		@JoinColumn(name = "countryID" , referencedColumnName = "countryID"), 
		@JoinColumn(name = "cityID" , referencedColumnName = "cityID"), 
		@JoinColumn(name = "locationID" , referencedColumnName = "locationID") 
	})
	
	private String address;
	private Double height;
	private Double weight;
	private String phone;
	private byte[] photo;
	@ManyToOne
	@JoinColumn(name = "competenceID", referencedColumnName = "competenceID")
	private String identityID;
	private String emergencyContact;
	private String emergencyPhone;
	
	@ManyToOne
	@JoinColumn(name = "emergencyRelation", referencedColumnName = "relationID")
	
	private String createDate;
	private String lastOnlineDateTime;
	
//	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="memberID")
//	private Set<LoginInformationVO> members = new HashSet<LoginInformationVO>();
	
	public MembersVO() {
		
	}
	

	public String getMemberID() {
		return memberID;
	}

	public void setMemberID(String memberID) {
		this.memberID = memberID;
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



	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Double getHeight() {
		return height;
	}

	public void setHeight(Double height) {
		this.height = height;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
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


	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getLastOnlineDateTime() {
		return lastOnlineDateTime;
	}

	public void setLastOnlineDateTime(String lastOnlineDateTime) {
		this.lastOnlineDateTime = lastOnlineDateTime;
	}
	

//	public Set<LoginInformationVO> getMembers() {
//		return members;
//	}
//
//	public void setMembers(Set<LoginInformationVO> members) {
//		this.members = members;
//	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((birthday == null) ? 0 : birthday.hashCode());
		result = prime * result + ((createDate == null) ? 0 : createDate.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((emergencyContact == null) ? 0 : emergencyContact.hashCode());
		result = prime * result + ((emergencyPhone == null) ? 0 : emergencyPhone.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + ((height == null) ? 0 : height.hashCode());
		result = prime * result + ((identityID == null) ? 0 : identityID.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((lastOnlineDateTime == null) ? 0 : lastOnlineDateTime.hashCode());
		result = prime * result + ((memberID == null) ? 0 : memberID.hashCode());
//		result = prime * result + ((members == null) ? 0 : members.hashCode());
		result = prime * result + ((nickname == null) ? 0 : nickname.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		result = prime * result + ((photo == null) ? 0 : photo.hashCode());
		result = prime * result + ((weight == null) ? 0 : weight.hashCode());
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
		MembersVO other = (MembersVO) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (birthday == null) {
			if (other.birthday != null)
				return false;
		} else if (!birthday.equals(other.birthday))
			return false;
		if (createDate == null) {
			if (other.createDate != null)
				return false;
		} else if (!createDate.equals(other.createDate))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (emergencyContact == null) {
			if (other.emergencyContact != null)
				return false;
		} else if (!emergencyContact.equals(other.emergencyContact))
			return false;
		if (emergencyPhone == null) {
			if (other.emergencyPhone != null)
				return false;
		} else if (!emergencyPhone.equals(other.emergencyPhone))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (gender == null) {
			if (other.gender != null)
				return false;
		} else if (!gender.equals(other.gender))
			return false;
		if (height == null) {
			if (other.height != null)
				return false;
		} else if (!height.equals(other.height))
			return false;
		if (identityID == null) {
			if (other.identityID != null)
				return false;
		} else if (!identityID.equals(other.identityID))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (lastOnlineDateTime == null) {
			if (other.lastOnlineDateTime != null)
				return false;
		} else if (!lastOnlineDateTime.equals(other.lastOnlineDateTime))
			return false;
		if (memberID == null) {
			if (other.memberID != null)
				return false;
		} else if (!memberID.equals(other.memberID))
			return false;
//		if (members == null) {
//			if (other.members != null)
//				return false;
//		} else if (!members.equals(other.members))
//			return false;
		if (nickname == null) {
			if (other.nickname != null)
				return false;
		} else if (!nickname.equals(other.nickname))
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		if (photo == null) {
			if (other.photo != null)
				return false;
		} else if (!photo.equals(other.photo))
			return false;
		if (weight == null) {
			if (other.weight != null)
				return false;
		} else if (!weight.equals(other.weight))
			return false;
		return true;
	}
}
