package com.uab.product.image;

import java.util.Arrays;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;

@Entity
public class ProductImage {

	@Id
    private Long id;

	@Lob
    @Column(columnDefinition = "mediumblob")
    private byte[] photoData;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public byte[] getPhotoData() {
		return photoData;
	}

	public void setPhotoData(byte[] photoData) {
		this.photoData = photoData;
	}

	@Override
	public String toString() {
		return "ProductImage [id=" + id + ", photoData=" + Arrays.toString(photoData) + "]";
	}

	public ProductImage(Long id, byte[] photoData) {
		super();
		this.id = id;
		this.photoData = photoData;
	}

	public ProductImage() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
}
