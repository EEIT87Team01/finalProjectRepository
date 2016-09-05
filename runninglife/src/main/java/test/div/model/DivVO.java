package test.div.model;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="div")
public class DivVO implements Serializable {
	@EmbeddedId
	private DivPK divID;
	
	private String divName;

	public DivPK getDivID() {
		return divID;
	}

	public void setDivID(DivPK divID) {
		this.divID = divID;
	}

	public String getDivName() {
		return divName;
	}

	public void setDivName(String divName) {
		this.divName = divName;
	}
	
	

}
