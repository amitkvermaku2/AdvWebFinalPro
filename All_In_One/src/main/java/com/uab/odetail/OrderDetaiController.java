package com.uab.odetail;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.uab.cart.Cart;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class OrderDetaiController {

	@Autowired
	OrderDetailSellerService orderDetailSellerService;
	
	@Autowired
	OrderDetailRepository orderDetailRepository;
	@GetMapping("/getOrderDetail/{id}")
    public ResponseEntity<List<OrderDetailSeller>> getODByUserId(@PathVariable("id") Long userId){
    	List<OrderDetailSeller> getOrders = orderDetailSellerService.getOrder(userId);
        return new ResponseEntity<>(getOrders, HttpStatus.OK);
}
	
	@GetMapping("/updateShippemt/{id}")
    public String updateCart(@PathVariable("id") Long id){
		OrderDetailSeller existingOrderDetailSeller = orderDetailRepository.findById(id).get();
		existingOrderDetailSeller.setShipped("YES");
        if (existingOrderDetailSeller == null) {
            return "not updated";
        }
        OrderDetailSeller updatedCart = orderDetailRepository.save(existingOrderDetailSeller);
        return "updated";
    }
}