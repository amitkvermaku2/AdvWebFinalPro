package com.uab.cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uab.product.Product;
import com.uab.product.ProductRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CardServiceImpl implements CartService {

	@Autowired
	CartRepository cartRepository;
	
	@Autowired
	ProductRepository productRepository;
	
	@Override
    public Cart createCart(Cart cart) {
        return cartRepository.save(cart);
    }

    @Override
    public Cart getCartById(Long id) {
        return cartRepository.findById(id).get();
    }

    @Override
    public List<Cart> getAllCarts() {
    	return (List<Cart>) cartRepository.findAll();
    }

    @Override
    public Cart updateCart(Cart cart) {
    	return cartRepository.save(cart);
    }

    @Override
    public void deleteCart(Long userId) {
        cartRepository.deleteById(userId);
    }
    
    @Override
    public  List<Product> getCartByOrerId(Long userId){
    	Cart cart = cartRepository.findById(userId).get();
    	Integer[] num = cart.getLongArray();
    	List<Product> products = new ArrayList<>();
    	for (int i = 0; i <  num.length ; i++) {
    	    int number = num[i];
    	    Long orderId = (long) number;
    	    Product pro = new Product();
    	    pro =	productRepository.findById(orderId).get();
    	    products.add(pro);
    	}
    	return products;
    }
    
}

