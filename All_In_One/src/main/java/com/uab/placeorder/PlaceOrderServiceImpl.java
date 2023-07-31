package com.uab.placeorder;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PlaceOrderServiceImpl implements PlaceOrderService{

	@Autowired
	PlaceOrderRepository placeOrderRepository;
	
	@Override
    public PlaceOrder createPlaceOrder(PlaceOrder placeOrder) {
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
}
