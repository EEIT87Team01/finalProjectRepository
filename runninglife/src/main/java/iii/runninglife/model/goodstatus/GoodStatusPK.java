package iii.runninglife.model.goodstatus;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import iii.runninglife.model.members.MembersVO;
import iii.runninglife.model.posts.PostsVO;


@Embeddable
public class GoodStatusPK implements Serializable {
	
	@ManyToOne
	@JoinColumn(name = "memberID", referencedColumnName = "memberID")
	private  MembersVO memberID;
	
	@ManyToOne
	@JoinColumn(name = "postID", referencedColumnName = "postID")
	private PostsVO postID;
	public MembersVO getMemberID() {
		return memberID;
	}
	public void setMemberID(MembersVO memberID) {
		this.memberID = memberID;
	}
	public PostsVO getPostID() {
		return postID;
	}
	public void setPostID(PostsVO postID) {
		this.postID = postID;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((memberID == null) ? 0 : memberID.hashCode());
		result = prime * result + ((postID == null) ? 0 : postID.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof GoodStatusPK))
			return false;
		GoodStatusPK other = (GoodStatusPK) obj;
		if (memberID == null) {
			if (other.memberID != null)
				return false;
		} else if (!memberID.equals(other.memberID))
			return false;
		if (postID == null) {
			if (other.postID != null)
				return false;
		} else if (!postID.equals(other.postID))
			return false;
		return true;
	}	
}
//test all ok save20160904