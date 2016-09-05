package _02.model.membercomplete.membercom;

import java.sql.Blob;
import java.sql.Timestamp;
import java.util.Calendar;

import _02.model.membercomplete.competence.CompetenceVO;
import _02.model.membercomplete.emergencyRelation.EmergencyRelationVO;
import _02.model.membercomplete.location.LocationVO;

public class MembercomVO {
	
	private String memberID;
	private String firstName;
	private String lastName;
	private String nickname;
	private String email;
	private String gender;
	private String birthday;
	private LocationVO locationID;
	private String address;
	private float height;
	private float weight;
	private String phone;
	private Blob photo;
	private CompetenceVO competenceID;
	private String identityID;
	private String emergencyContact;
	private String emergencyPhone;
	private EmergencyRelationVO emergencyRelation;
	private Calendar createDate;
	private Timestamp lastOnlineDateTime;
	
}
