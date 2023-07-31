package com.uab.placeorder;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class PlaceOrder {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long orderId;
	private String time;
	private String date;
	private List<String> productIds;
	private String userId;
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public List<String> getProductIds() {
		return productIds;
	}
	public void setProductIds(List<String> productIds) {
		this.productIds = productIds;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public PlaceOrder(Long orderId, String time, String date, List<String> productIds, String userId) {
		super();
		this.orderId = orderId;
		this.time = time;
		this.date = date;
		this.productIds = productIds;
		this.userId = userId;
	}
	public PlaceOrder() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "PlaceOrder [orderId=" + orderId + ", time=" + time + ", date=" + date + ", productIds=" + productIds
				+ ", userId=" + userId + "]";
	}
	
	
}
