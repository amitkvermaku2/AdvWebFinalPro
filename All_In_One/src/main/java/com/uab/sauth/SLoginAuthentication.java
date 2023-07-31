package com.uab.sauth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uab.seller.Seller;
import com.uab.seller.SellerRepository;
import com.uab.seller.SellerService;
import com.uab.user.User;
import com.uab.user.UserRepository;
import com.uab.user.UserService;

@RestController
@CrossOrigin
@RequestMapping("/sauth")
public class SLoginAuthentication {
	
	@Autowired
    private SellerService sellerService;
	
	@Autowired
    private UserService userService;
	
	@Autowired
    private UserRepository userRepository;

	@Autowired
    private SellerRepository sellerRepository;
	
	@PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody SUserValue sellerValue) {
        Seller seller = sellerService.getSellerById(sellerValue.getUname());

        if (seller != null && seller.getPassword().equals(sellerValue.getUpassword())) {
            return ResponseEntity.ok("successful");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid Uname or Upassword");
        }
    }
	
	@PostMapping("/loginUser")
    public ResponseEntity<String> loginUser(@RequestBody SUserValue sellerValue) {
        User seller = userService.getUserById(sellerValue.getUname());

        if (seller != null && seller.getUserPassword().equals(sellerValue.getUpassword())) {
            return ResponseEntity.ok("successful");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid Uname or Upassword");
        }
    }
	
}
