package com.uab.cart;
import lombok.AllArgsConstructor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CartController {

	@Autowired
    CartService cartService;

    @PostMapping("/saveCart")
    public ResponseEntity<Cart> createCart(@RequestBody Cart cart){
        Cart savedCart = cartService.createCart(cart);
        return new ResponseEntity<>(savedCart, HttpStatus.CREATED);
    }

    @GetMapping("/getCartById/{id}")
    public ResponseEntity<Cart> getCartById(@PathVariable("id") Long userId){
        Cart cart = cartService.getCartById(userId);
        return new ResponseEntity<>(cart, HttpStatus.OK);
    }

    @GetMapping("/getAllCarts")
    public ResponseEntity<List<Cart>> getAllCarts(){
        List<Cart> carts = cartService.getAllCarts();
        return new ResponseEntity<>(carts, HttpStatus.OK);
    }

    @PutMapping("/updateCarts/{id}")
    public ResponseEntity<Cart> updateCart(@PathVariable("id") Long userId,
                                           @RequestBody Cart cart){
       return null;
    }

    @DeleteMapping("/deleteCart/{id}")
    public ResponseEntity<String> deleteCart(@PathVariable("id") Long userId){
        cartService.deleteCart(userId);
        return new ResponseEntity<>("Cart successfully deleted!", HttpStatus.OK);
    }
}