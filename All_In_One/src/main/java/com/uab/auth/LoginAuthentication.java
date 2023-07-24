package com.uab.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uab.user.User;
import com.uab.user.UserRepository;
import com.uab.user.UserService;

@RestController
@RequestMapping("/auth")
public class LoginAuthentication {
	
	@Autowired
    private UserService userService;

	@Autowired
    private UserRepository userRepository;
	
	@PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserValue userValue) {
        User user = userService.findByUsername(userValue.getUname());

        if (user != null && user.getUserPassword().equals(userValue.getUpassword())) {
            return ResponseEntity.ok("successful");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid Uname or Upassword");
        }
    }
	
}
