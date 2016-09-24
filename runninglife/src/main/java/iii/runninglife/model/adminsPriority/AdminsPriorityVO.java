package iii.runninglife.model.adminsPriority;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import iii.runninglife.model.admins.AdminsVO;

@Entity
@Table(name = "adminsPriority")
public class AdminsPriorityVO implements Serializable{
	@Id
	@Column(name = "levelID")
	private String levelID;
	
	private String levelName;
	
	public AdminsPriorityVO() {
		
	}

	public AdminsPriorityVO(String levelID, String levelName) {
		super();
		this.levelID = levelID;
		this.levelName = levelName;
	}

	public String getLevelID() {
		return levelID;
	}

	public void setLevelID(String levelID) {
		this.levelID = levelID;
	}

	public String getLevelName() {
		return levelName;
	}

	public void setLevelName(String levelName) {
		this.levelName = levelName;
	}

}
