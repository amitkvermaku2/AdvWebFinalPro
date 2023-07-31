package com.uab.cart;

import java.util.Arrays;
import java.util.List;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity
public class Cart {
	@Id
	private Long userId;
	
	
	private Integer longArray[];


	public Long getUserId() {
		return userId;
	}


	public void setUserId(Long userId) {
		this.userId = userId;
	}


	public Integer[] getLongArray() {
		return longArray;
	}


	public void setLongArray(Integer[] longArray) {
		this.longArray = longArray;
	}


	public Cart(Long userId, Integer[] longArray) {
		super();
		this.userId = userId;
		this.longArray = longArray;
	}


	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Override
	public String toString() {
		return "Cart [userId=" + userId + ", longArray=" + Arrays.toString(longArray) + "]";
	}

	
	
}
