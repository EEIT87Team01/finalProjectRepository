package iii.runninglife.model.writer;

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
@Table(name = "writer")
public class WriterVO {
	@Id
	@Column(name = "writerAccount")
	private String writerAccount;
	
	private String name;
	private byte[] password;
	private String phone;
	private String email;
	private String address;
	private String status;
	
//	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="writerAccount")
//	private Set<AdminsVO> adminsPrioritys = new HashSet<AdminsVO>();
	
	public WriterVO() {
		
	}

	public WriterVO(String writerAccount, String name, byte[] password, String phone, String email, String address,
			String status, Set<AdminsVO> adminsPrioritys) {
		super();
		this.writerAccount = writerAccount;
		this.name = name;
		this.password = password;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.status = status;
//		this.adminsPrioritys = adminsPrioritys;
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

	public byte[] getPassword() {
		return password;
	}

	public void setPassword(byte[] password) {
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

//	public Set<AdminsVO> getAdminsPrioritys() {
//		return adminsPrioritys;
//	}
//
//	public void setAdminsPrioritys(Set<AdminsVO> adminsPrioritys) {
//		this.adminsPrioritys = adminsPrioritys;
//	}
	
//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + ((address == null) ? 0 : address.hashCode());
//		result = prime * result + ((adminsPrioritys == null) ? 0 : adminsPrioritys.hashCode());
//		result = prime * result + ((email == null) ? 0 : email.hashCode());
//		result = prime * result + ((name == null) ? 0 : name.hashCode());
//		result = prime * result + ((password == null) ? 0 : password.hashCode());
//		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
//		result = prime * result + ((status == null) ? 0 : status.hashCode());
//		result = prime * result + ((writerAccount == null) ? 0 : writerAccount.hashCode());
//		return result;
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		WriterVO other = (WriterVO) obj;
//		if (address == null) {
//			if (other.address != null)
//				return false;
//		} else if (!address.equals(other.address))
//			return false;
//		if (adminsPrioritys == null) {
//			if (other.adminsPrioritys != null)
//				return false;
//		} else if (!adminsPrioritys.equals(other.adminsPrioritys))
//			return false;
//		if (email == null) {
//			if (other.email != null)
//				return false;
//		} else if (!email.equals(other.email))
//			return false;
//		if (name == null) {
//			if (other.name != null)
//				return false;
//		} else if (!name.equals(other.name))
//			return false;
//		if (password == null) {
//			if (other.password != null)
//				return false;
//		} else if (!password.equals(other.password))
//			return false;
//		if (phone == null) {
//			if (other.phone != null)
//				return false;
//		} else if (!phone.equals(other.phone))
//			return false;
//		if (status == null) {
//			if (other.status != null)
//				return false;
//		} else if (!status.equals(other.status))
//			return false;
//		if (writerAccount == null) {
//			if (other.writerAccount != null)
//				return false;
//		} else if (!writerAccount.equals(other.writerAccount))
//			return false;
//		return true;
//	}
	
}
