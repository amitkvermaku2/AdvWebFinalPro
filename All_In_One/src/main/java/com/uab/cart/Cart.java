package com.uab.cart;

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
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
	private List<Items> products;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public List<Items> getProducts() {
		return products;
	}

	public void setProducts(List<Items> products) {
		this.products = products;
	}

	public Cart(Long userId, List<Items> products) {
		super();
		this.userId = userId;
		this.products = products;
	}

	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
}
