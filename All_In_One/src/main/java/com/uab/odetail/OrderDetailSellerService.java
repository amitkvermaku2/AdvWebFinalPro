package com.uab.odetail;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.uab.cart.Cart;
import com.uab.placeorder.PlaceOrder;
import com.uab.placeorder.PlaceOrderRepository;
import com.uab.placeorder.PlaceOrderServiceImpl;
import com.uab.product.Product;
import com.uab.product.ProductRepository;
import com.uab.product.ProductService;
import com.uab.user.User;
import com.uab.user.UserRepository;
import com.uab.user.UserService;

@Service
@Transactional
public class OrderDetailSellerService {
	
	@Autowired
	OrderDetailRepository orderDetailRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	ProductRepository productRepository;
	
    public void createPlaceOrder(PlaceOrder placeOrder) {
    	Integer rray[] = placeOrder.getLongArray();
    	 for(int i=0;i<rray.length;i++) {
    		OrderDetailSeller orderDetailSeller = new OrderDetailSeller(); 
    		Product product = productRepository.findById(Long.valueOf(rray[i])).get();
    		Long sellerId = product.getSellerId();
    		orderDetailSeller.setSellerId(sellerId);
    		User user = userRepository.findById(placeOrder.getUserId()).get();
    		orderDetailSeller.setProductId(product.getIdProduct().toString());
    		orderDetailSeller.setProductName(product.getName());
    		orderDetailSeller.setuFirstName(user.getUserFirstName());
    		orderDetailSeller.setuLastName(user.getUserLastName());
    		orderDetailSeller.setUserAddress(user.getUserAddress());
    		orderDetailSeller.setUserContact(user.getUserContact());
    		orderDetailSeller.setShipped("NO");
    		orderDetailRepository.save(orderDetailSeller);
    		System.out.println("user saved");
    	}
    }
    
    public List<OrderDetailSeller> getOrder(Long userId) {
    	return (List<OrderDetailSeller>) orderDetailRepository.findBySellerId(userId);
    }
    
}
