package com.uab.cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CardServiceImpl implements CartService {

	@Autowired
	CartRepository cartRepository;
	
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
        return null;
    }

    @Override
    public void deleteCart(Long userId) {
        cartRepository.deleteById(userId);
    }
    
}

