package com.uab.placeorder;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class PlaceOrderController {

	@Autowired
	PlaceOrderService placeOrderService;

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

    @GetMapping("/getplaceOrder")
    public ResponseEntity<List<PlaceOrder>> getAllPlaceOrder(){
        List<PlaceOrder> placeOrders = placeOrderService.getAllPlaceOrders();
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
}
