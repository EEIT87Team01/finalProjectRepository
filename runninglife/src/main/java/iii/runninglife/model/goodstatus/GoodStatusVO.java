package iii.runninglife.model.goodstatus;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import iii.runninglife.model.members.MembersVO;
import iii.runninglife.model.posts.PostsVO;

@Entity
@Table(name = "goodStatus")
public class GoodStatusVO {
	@EmbeddedId
	private GoodStatusPK goodStatusPK;

	public GoodStatusPK getGoodStatusPK() {
		return goodStatusPK;
	}

	public void setGoodStatusPK(GoodStatusPK goodStatusPK) {
		this.goodStatusPK = goodStatusPK;
	}
}
//test all ok save20160904