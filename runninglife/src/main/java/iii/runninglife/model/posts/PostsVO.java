package iii.runninglife.model.posts;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import iii.runninglife.model.members.MembersVO;

@Entity
@Table(name = "posts")
public class PostsVO  implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	//	@SequenceGenerator(name="xxx", allocationSize=1) 
//	@GeneratedValue(strategy = GenerationType.IDENTITY, generator="xxx")  
	@Id
	@Column(name = "postID")
	private String postID;
	@ManyToOne
	@JoinColumn(name = "postMemberID", referencedColumnName = "memberID")
	private MembersVO postMemberID;
	private String content;
	private	Timestamp time;
	private Integer good;
	private	String status;
	private String parent;
	private	String responsed;
	private String imgPath;
	
	public PostsVO(){
		
	}
	
	public String getPostID() {
		return postID;
	}
	public void setPostID(String postID) {
		this.postID = postID;
	}
	public MembersVO getPostMemberID() {
		return postMemberID;
	}
	public void setPostMemberID(MembersVO postMemberID) {
		this.postMemberID = postMemberID;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Timestamp getTime() {
		return time;
	}
	public void setTime(Timestamp time) {
		this.time = time;
	}
	public Integer getGood() {
		return good;
	}
	public void setGood(Integer good) {
		this.good = good;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getParent() {
		return parent;
	}
	public void setParent(String parent) {
		this.parent = parent;
	}
	public String getResponsed() {
		return responsed;
	}
	public void setResponsed(String responsed) {
		this.responsed = responsed;
	}

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

}
