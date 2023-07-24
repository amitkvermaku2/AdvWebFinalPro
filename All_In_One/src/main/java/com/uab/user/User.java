package com.uab.user;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class User {

	private String userFirstName;
	
	private String userLastName;
	
	private String userContact;
	
	private String userEmail;
	
	private String userAddress;
	
	private String userPassword;
	
	private String role;
	
	@Id
	private Long userId;
	
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getUserFirstName() {
		return userFirstName;
	}

	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}

	public String getUserLastName() {
		return userLastName;
	}

	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}

	public String getUserContact() {
		return userContact;
	}

	public void setUserContact(String userContact) {
		this.userContact = userContact;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "User [userFirstName=" + userFirstName + ", userLastName=" + userLastName + ", role=" + role + ", userContact="
				+ userContact + ", userEmail=" + userEmail + ", userAddress=" + userAddress + ", userPassword="
				+ userPassword + ", userId=" + userId + "]";
	}

	public User(String userFirstName, String userLastName, String userContact, String userEmail, String userAddress,
			String userPassword, Long userId, String role) {
		super();
		this.userFirstName = userFirstName;
		this.userLastName = userLastName;
		this.userContact = userContact;
		this.userEmail = userEmail;
		this.userAddress = userAddress;
		this.userPassword = userPassword;
		this.userId = userId;
		this.role = role;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
