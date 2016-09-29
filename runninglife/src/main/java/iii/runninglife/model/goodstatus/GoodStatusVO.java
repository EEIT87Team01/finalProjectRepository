package iii.runninglife.model.goodstatus;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;


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