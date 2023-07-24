package com.uab.product.image;

import java.awt.Image;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class PhotoService {
	@Autowired
    ProductImageRepository productImageRepository;
    
    public void savePhoto(byte[] photoData, Long id) {
    	ProductImage productImage = new ProductImage();
    	productImage.setPhotoData(photoData);
    	productImage.setId(id);
    	productImageRepository.save(productImage);
    }
    
    public ProductImage getImageById(Long id) {
        return productImageRepository.findById(id).orElse(null);
    }
    
   
}
