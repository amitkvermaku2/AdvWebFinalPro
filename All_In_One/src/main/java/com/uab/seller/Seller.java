package com.uab.seller;

import jakarta.persistence.Id;

public class Seller {
  
	private String businessName;
	private String businessAddress;
	private String bContsct;
	private String bEmail;
	private String bSSN;
	private String category;
	private String license;
	@Id
	private Long id;
	private String password;
	private String role;
	public String getBusinessName() {
		return businessName;
	}
	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}
	public String getBusinessAddress() {
		return businessAddress;
	}
	public void setBusinessAddress(String businessAddress) {
		this.businessAddress = businessAddress;
	}
	public String getbContsct() {
		return bContsct;
	}
	public void setbContsct(String bContsct) {
		this.bContsct = bContsct;
	}
	public String getbEmail() {
		return bEmail;
	}
	public void setbEmail(String bEmail) {
		this.bEmail = bEmail;
	}
	public String getbSSN() {
		return bSSN;
	}
	public void setbSSN(String bSSN) {
		this.bSSN = bSSN;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getLicense() {
		return license;
	}
	public void setLicense(String license) {
		this.license = license;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "Seller [businessName=" + businessName + ", businessAddress=" + businessAddress + ", bContsct="
				+ bContsct + ", bEmail=" + bEmail + ", bSSN=" + bSSN + ", category=" + category + ", license=" + license
				+ ", id=" + id + ", password=" + password + ", role=" + role + "]";
	}
	public Seller(String businessName, String businessAddress, String bContsct, String bEmail, String bSSN,
			String category, String license, Long id, String password, String role) {
		super();
		this.businessName = businessName;
		this.businessAddress = businessAddress;
		this.bContsct = bContsct;
		this.bEmail = bEmail;
		this.bSSN = bSSN;
		this.category = category;
		this.license = license;
		this.id = id;
		this.password = password;
		this.role = role;
	}
	public Seller() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
