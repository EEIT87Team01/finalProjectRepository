package iii.runninglife._01.model.writer;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import iii.runninglife._01.model.admins.AdminsVO;

@Entity
@Table(name = "writer")
public class WriterVO {
	@Id
	@Column(name = "writerAccount")
	private String writerAccount;
	
	private String name;
	private String password;
	private String phone;
	private String email;
	private String address;
	private String status;
	
	
	public WriterVO() {
		
	}

	public WriterVO(String writerAccount, String name, String password, String phone, String email, String address,
			String status, Set<AdminsVO> adminsPrioritys) {
		super();
		this.writerAccount = writerAccount;
		this.name = name;
		this.password = password;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.status = status;
	}



	public String getWriterAccount() {
		return writerAccount;
	}

	public void setWriterAccount(String writerAccount) {
		this.writerAccount = writerAccount;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
