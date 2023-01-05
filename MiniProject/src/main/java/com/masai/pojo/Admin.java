package com.masai.pojo;

import jakarta.validation.constraints.Size;


import jakarta.validation.constraints.Pattern;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.AssertTrue;
@Entity
public class Admin {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer adminId;
	
	
	@AssertTrue
	@Size(min = 3, max = 20, message = "{user.invalid.userName}")
	@Column(unique = true)
	private String adminName;
	private String mobile;
	private String email;
	@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$",message = "{user.invalid.password}")
	private String password;
	
	public Admin(String adminName, String mobile, String email, String password) {
		super();
		this.adminName = adminName;
		this.mobile = mobile;
		this.email = email;
		this.password = password;
	}

	public Admin() {
		super();
	}

	public Integer getAdminId() {
		return adminId;
	}

	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", adminName=" + adminName + ", mobile=" + mobile + ", email=" + email
				+ ", password=" + password + ", getAdminId()=" + getAdminId() + ", getAdminName()=" + getAdminName()
				+ ", getMobile()=" + getMobile() + ", getEmail()=" + getEmail() + ", getPassword()=" + getPassword()
				+ "]";
	}

	
	
	
	
}
