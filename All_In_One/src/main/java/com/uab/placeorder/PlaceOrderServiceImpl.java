package com.uab.placeorder;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uab.odetail.OrderDetailSellerService;
import com.uab.product.Product;
import com.uab.product.ProductRepository;

@Service
@Transactional
public class PlaceOrderServiceImpl implements PlaceOrderService{

	@Autowired
	PlaceOrderRepository placeOrderRepository;
	
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	OrderDetailSellerService orderDetailSellerService;
	
	@Override
    public PlaceOrder createPlaceOrder(PlaceOrder placeOrder) {
		//orderDetailSellerService.createPlaceOrder(placeOrder);
        return placeOrderRepository.save(placeOrder);
    }

    @Override
    public PlaceOrder getPlaceOrderById(Long orderId) {
        return placeOrderRepository.findById(orderId).get();
    }

    @Override
    public List<PlaceOrder> getAllPlaceOrders() {
    	return (List<PlaceOrder>) placeOrderRepository.findAll();
    }

    @Override
    public PlaceOrder updatePlaceOrder(PlaceOrder placeOrder) {
    	return placeOrderRepository.save(placeOrder);
    }

    @Override
    public void deletePlaceOrder(Long orderId) {
    	placeOrderRepository.deleteById(orderId);
    }
    
    @Override
    public List<PlaceOrder> getAllByUserId(Long userId){
    	return placeOrderRepository.findAllByUserId(userId);
    }
    
    @Override
    public List<Product> getPlaceOrderUserById(Long productId, Long oid){
    	List<PlaceOrder> placeOrders = getAllByUserId(productId);
    	List<Product> products = new ArrayList();
    	for (PlaceOrder placeOrder : placeOrders) {
    		if(placeOrder.getOrderId().equals(oid)) {
    	Integer orderarray[] = placeOrder.getLongArray();
    	
    	for (int i = 0; i < orderarray.length; i++) {
    	    Integer number = orderarray[i];
    	    Product product = productRepository.findById(number.longValue()).get();
    	    products.add(product);
    	    System.out.println(number);
    	}
    		}
    	}
    	return products;
    }
}
