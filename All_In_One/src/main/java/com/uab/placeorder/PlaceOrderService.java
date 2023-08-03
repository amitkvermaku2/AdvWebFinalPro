package com.uab.placeorder;

import java.util.List;

import com.uab.cart.Cart;
import com.uab.product.Product;

public interface PlaceOrderService {
	PlaceOrder createPlaceOrder(PlaceOrder placeOrder);

	PlaceOrder getPlaceOrderById(Long orderId);

    List<PlaceOrder> getAllPlaceOrders();

    PlaceOrder updatePlaceOrder(PlaceOrder placeOrder);

    void deletePlaceOrder(Long orderId);
    
    List<PlaceOrder> getAllByUserId(Long userId);
    
    List<Product> getPlaceOrderUserById(Long productId, Long oid);
}
