package com.uab.placeorder;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.uab.product.Product;
import com.uab.product.ProductRepository;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PlaceOrderController {

	@Autowired
	PlaceOrderService placeOrderService;
	@Autowired
	ProductRepository productRepository;

    @PostMapping("/savePlaceOrder")
    public ResponseEntity<PlaceOrder> createPlaceOrder(@RequestBody PlaceOrder placeOrder){
    	PlaceOrder savedPlaceOrder = placeOrderService.createPlaceOrder(placeOrder);
        return new ResponseEntity<>(savedPlaceOrder, HttpStatus.CREATED);
    }

    @GetMapping("/getPlaceOrderById/{id}")
    public ResponseEntity<PlaceOrder> getPlaceOrderById(@PathVariable("id") Long placeOrderId){
    	PlaceOrder placeOrder = placeOrderService.getPlaceOrderById(placeOrderId);
        return new ResponseEntity<>(placeOrder, HttpStatus.OK);
    }
    
    @GetMapping("/getPlaceOrderUserById/{id}/{oid}")
    public ResponseEntity<List<Product>> getPlaceDetailsUserById(@PathVariable("id") Long placeOrderId, @PathVariable("oid") Long orderId){
    	List<Product> placeOrders = placeOrderService.getPlaceOrderUserById(placeOrderId,orderId);
    	return new ResponseEntity<>(placeOrders, HttpStatus.OK);
    }

    @GetMapping("/getplaceOrder")
    public ResponseEntity<List<PlaceOrder>> getAllPlaceOrder(){
        List<PlaceOrder> placeOrders = placeOrderService.getAllPlaceOrders();
        return new ResponseEntity<>(placeOrders, HttpStatus.OK);
    }
    
    @GetMapping("/getPlaceUserOrderById/{id}")
    public ResponseEntity<List<PlaceOrder>> getAllUserPlaceOrder(@PathVariable("id") Long userId){
        List<PlaceOrder> placeOrders = placeOrderService.getAllByUserId(userId);
        return new ResponseEntity<>(placeOrders, HttpStatus.OK);
    }

    @PutMapping("/updatePlaceOrders/{id}")
    public ResponseEntity<PlaceOrder> updatePlaceOrders(@PathVariable("id") Long orderId,
                                           @RequestBody PlaceOrder placeOrder){
    	PlaceOrder existingProduct = placeOrderService.getPlaceOrderById(orderId);

        if (existingProduct == null) {
            return ResponseEntity.notFound().build();
        }
        PlaceOrder updatedPlaceOrder = placeOrderService.updatePlaceOrder(placeOrder);
        return ResponseEntity.ok(updatedPlaceOrder);
    }

    @DeleteMapping("deletePlaceOrder/{id}")
    public ResponseEntity<String> deletePlaceOrder(@PathVariable("id") Long orderId){
    	placeOrderService.deletePlaceOrder(orderId);
        return new ResponseEntity<>("PlaceOrder successfully deleted!", HttpStatus.OK);
    }

    @GetMapping("/getTotal/{id}")
    public int getTotalPrice(@PathVariable("id") Long placeOrderId){
    	int total = 0;
    	PlaceOrder placeOrder = placeOrderService.getPlaceOrderById(placeOrderId);
    	Integer rray[] = placeOrder.getLongArray();
    	for(int i=0;i<rray.length;i++) {
    		Integer intr = rray[i];
    		Long longValue = intr.longValue();
    		Product product = productRepository.findById(longValue).get();
    		total = total + Integer.parseInt(product.getPrice());
    	}
        return total;
    }
}
