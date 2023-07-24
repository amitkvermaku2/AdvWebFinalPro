package com.uab.product;

import java.util.Arrays;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
@Entity
public class Product {
	@Id
	private Long id;
	private String name;
	private String description;
	private String price;
	@Lob
    private byte[] imageData;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public byte[] getImageData() {
		return imageData;
	}
	public void setImageData(byte[] imageData) {
		this.imageData = imageData;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price
				+ ", imageData=" + Arrays.toString(imageData) + "]";
	}
	public Product(Long id, String name, String description, String price, byte[] imageData) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.imageData = imageData;
	}
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
