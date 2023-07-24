package com.uab.seller;
import lombok.AllArgsConstructor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class SellerController {

	@Autowired
	SellerService sellerService;

    @PostMapping("/saveSeller")
    public ResponseEntity<Seller> createSeller(@RequestBody Seller seller){
    	Seller savedSeller = sellerService.createSeller(seller);
        return new ResponseEntity<>(savedSeller, HttpStatus.CREATED);
    }

    @GetMapping("/getSellerById/{id}")
    public ResponseEntity<Seller> getUserById(@PathVariable("id") Long sellerId){
    	Seller seller = sellerService.getSellerById(sellerId);
        return new ResponseEntity<>(seller, HttpStatus.OK);
    }

    @GetMapping("/getAllSellers")
    public ResponseEntity<List<Seller>> getAllSellers(){
        List<Seller> sellers = sellerService.getAllSellers();
        return new ResponseEntity<>(sellers, HttpStatus.OK);
    }

    @PutMapping("/updateSeller/{id}")
    public ResponseEntity<Seller> updateSeller(@PathVariable("id") Long sellerId,
                                           @RequestBody Seller seller){
       return null;
    }

    @DeleteMapping("/deleteSeller/{id}")
    public ResponseEntity<String> deleteSeller(@PathVariable("id") Long sellerId){
    	sellerService.deleteSeller(sellerId);
        return new ResponseEntity<>("Seller successfully deleted!", HttpStatus.OK);
    }
}
