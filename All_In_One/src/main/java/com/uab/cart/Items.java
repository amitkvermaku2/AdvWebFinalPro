package com.uab.cart;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Items {
    @Id
	private Long idProduct;
	private String Quantity;
	public Long getIdProduct() {
		return idProduct;
	}
	public void setIdProduct(Long idProduct) {
		this.idProduct = idProduct;
	}
	public String getQuantity() {
		return Quantity;
	}
	public void setQuantity(String quantity) {
		Quantity = quantity;
	}
	public Items(Long idProduct, String quantity) {
		super();
		this.idProduct = idProduct;
		Quantity = quantity;
	}
	public Items() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
