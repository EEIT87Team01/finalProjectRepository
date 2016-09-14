package iii.runninglife._01.model.admins;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import iii.runninglife._01.model.adminsPriority.AdminsPriorityVO;

@Entity
@Table(name = "admins")
public class AdminsVO implements Serializable{
	
	@Id
	@Column(name = "adminAccount")
	private String adminAccount;
	private String password;
	private String name;
	
	@ManyToOne
	@JoinColumn(name = "levelID")
	private AdminsPriorityVO levelID;
	
	@Column(name = "status")
	private String status;
	
	public AdminsVO() {
		
	}

	public AdminsVO(String adminAccount, String password, String name, AdminsPriorityVO levelID, String status) {
		super();
		this.adminAccount = adminAccount;
		this.password = password;
		this.name = name;
		this.levelID = levelID;
		this.status = status;
	}

	@Override
	public String toString() {
		return "AdminsVO [adminAccount=" + adminAccount + ", password=" + password + ", name=" + name + ", levelID="
				+ levelID + ", status=" + status + "]";
	}

	public String getAdminAccount() {
		return adminAccount;
	}

	public void setAdminAccount(String adminAccount) {
		this.adminAccount = adminAccount;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public AdminsPriorityVO getAdminsPriorityBean() {
		return levelID;
	}

	public void setLevelID(AdminsPriorityVO levelID) {
		this.levelID = levelID;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
