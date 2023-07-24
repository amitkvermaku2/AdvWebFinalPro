package com.uab.product.image;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class ProductImageController {
	@Autowired
    PhotoService photoService;

	@Autowired
    ProductImageRepository productImageRepository;
    @PostMapping("/uploadImage")
    public ResponseEntity<String> uploadImage(@RequestParam("id") Long id,@RequestParam("photoFile") MultipartFile file) {
        try {
            if (!file.isEmpty()) {
                byte[] photoData = file.getBytes();
                photoService.savePhoto(photoData,id);
                return ResponseEntity.ok("done");
            } else {
                return ResponseEntity.badRequest().body("not done select .img");
            }
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("error came");
        }
    }
    
    @GetMapping("/photoById/{id}")
    public ResponseEntity<byte[]> getImageById(@PathVariable Long id) {
    	ProductImage productImage = photoService.getImageById(id);

        if (productImage != null) {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.IMAGE_JPEG); // Update the content type based on your image format
            return new ResponseEntity<>(productImage.getPhotoData(), headers, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
