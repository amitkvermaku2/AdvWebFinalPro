package com.uab.odetail;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class OrderDetailSeller {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long oId;
 private String shipped;
 private Long sellerId;
 private String userAddress;
 private String uFirstName;
 private String uLastName;
 private String userContact;
 private String productName;
 private String productId;
public Long getoId() {
	return oId;
}
public void setoId(Long oId) {
	this.oId = oId;
}
public String getShipped() {
	return shipped;
}
public void setShipped(String shipped) {
	this.shipped = shipped;
}
public Long getSellerId() {
	return sellerId;
}
public void setSellerId(Long sellerId) {
	this.sellerId = sellerId;
}
public String getUserAddress() {
	return userAddress;
}
public void setUserAddress(String userAddress) {
	this.userAddress = userAddress;
}
public String getuFirstName() {
	return uFirstName;
}
public void setuFirstName(String uFirstName) {
	this.uFirstName = uFirstName;
}
public String getuLastName() {
	return uLastName;
}
public void setuLastName(String uLastName) {
	this.uLastName = uLastName;
}
public String getUserContact() {
	return userContact;
}
public void setUserContact(String userContact) {
	this.userContact = userContact;
}
public String getProductName() {
	return productName;
}
public void setProductName(String productName) {
	this.productName = productName;
}
public String getProductId() {
	return productId;
}
public void setProductId(String productId) {
	this.productId = productId;
}
public OrderDetailSeller(Long oId, String shipped, Long sellerId, String userAddress, String uFirstName,
		String uLastName, String userContact, String productName, String productId) {
	super();
	this.oId = oId;
	this.shipped = shipped;
	this.sellerId = sellerId;
	this.userAddress = userAddress;
	this.uFirstName = uFirstName;
	this.uLastName = uLastName;
	this.userContact = userContact;
	this.productName = productName;
	this.productId = productId;
}
public OrderDetailSeller() {
	super();
	// TODO Auto-generated constructor stub
}
@Override
public String toString() {
	return "OrderDetailSeller [oId=" + oId + ", shipped=" + shipped + ", sellerId=" + sellerId + ", userAddress="
			+ userAddress + ", uFirstName=" + uFirstName + ", uLastName=" + uLastName + ", userContact=" + userContact
			+ ", productName=" + productName + ", productId=" + productId + "]";
}

 

}