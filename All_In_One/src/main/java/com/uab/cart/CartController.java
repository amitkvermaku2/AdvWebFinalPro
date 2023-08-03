package com.uab.cart;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import lombok.AllArgsConstructor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.uab.odetail.OrderDetailSellerService;
import com.uab.placeorder.PlaceOrder;
import com.uab.placeorder.PlaceOrderRepository;
import com.uab.product.Product;
import com.uab.product.ProductRepository;
import com.uab.user.User;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CartController {

	@Autowired
    CartService cartService;
	
	@Autowired
	PlaceOrderRepository placeOrderRepository;
	@Autowired
	ProductRepository productRepository;
	@Autowired OrderDetailSellerService orderDetailSellerService;

    @PostMapping("/saveCart")
    public ResponseEntity<Cart> createCart(@RequestBody Cart cart){
        Cart savedCart = cartService.createCart(cart);
        return new ResponseEntity<>(savedCart, HttpStatus.CREATED);
    }
    
    @PostMapping("/orderOfCart/{id}")
    public ResponseEntity<PlaceOrder> createOrder(@PathVariable("id") Long userId){
    	Cart cart = cartService.getCartById(userId);
    	PlaceOrder placeOrder = new PlaceOrder();
    	placeOrder.setLongArray(cart.getLongArray());
        placeOrder.setUserId(cart.getUserId());
        LocalDate currentDate = LocalDate.now();
        LocalTime currentTime = LocalTime.now();
        String formatPattern = "MM-dd-yyyy"; 
        String cdAsString = currentDate.format(DateTimeFormatter.ofPattern(formatPattern));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        String ctString = currentTime.format(formatter);
        placeOrder.setTime(ctString);
        placeOrder.setDate(cdAsString);
        placeOrderRepository.save(placeOrder);
        orderDetailSellerService.createPlaceOrder(placeOrder);
        return new ResponseEntity<>(placeOrder, HttpStatus.CREATED);
    }

    @GetMapping("/getCartById/{id}")
    public ResponseEntity<Cart> getCartById(@PathVariable("id") Long userId){
        Cart cart = cartService.getCartById(userId);
        return new ResponseEntity<>(cart, HttpStatus.OK);
    }
    
    @GetMapping("/getCartTotal/{id}")
    public int getTotal(@PathVariable("id") Long userId){
        Cart cart = cartService.getCartById(userId);
        Integer rray[] = cart.getLongArray();
        int total = 0;
          for(int i=0;i<rray.length;i++) {
        	  
        	  Product product = productRepository.getById(Long.valueOf(rray[i]));
        	  String price = product.getPrice();
    		total = total + Integer.parseInt(price);
    	}
        return total;
    }
    
    @GetMapping("/getCartOrderById/{id}")
    public ResponseEntity<List<Product>> getCartOrderById(@PathVariable("id") Long userId){
        List<Product> cart = cartService.getCartByOrerId(userId);
        return new ResponseEntity<>(cart, HttpStatus.OK);
    }

    @GetMapping("/getAllCarts")
    public ResponseEntity<List<Cart>> getAllCarts(){
        List<Cart> carts = cartService.getAllCarts();
        return new ResponseEntity<>(carts, HttpStatus.OK);
    }

    @PutMapping("/updateCarts/{id}")
    public ResponseEntity<Cart> updateCart(@PathVariable("id") Long cartId,
                                           @RequestBody Cart cart){
    	Cart existingCart = cartService.getCartById(cartId);

        if (existingCart == null) {
            return ResponseEntity.notFound().build();
        }
        Cart updatedCart = cartService.updateCart(cart);
        return ResponseEntity.ok(updatedCart);
    }

    @DeleteMapping("/deleteCart/{id}")
    public ResponseEntity<String> deleteCart(@PathVariable("id") Long userId){
        cartService.deleteCart(userId);
        return new ResponseEntity<>("Cart successfully deleted!", HttpStatus.OK);
    }
}
