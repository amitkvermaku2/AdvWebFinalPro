package com.uab.cart;
import java.util.List;

import com.uab.product.Product;
public interface CartService {

	Cart createCart(Cart cart);

    Cart getCartById(Long userId);

    List<Cart> getAllCarts();

    Cart updateCart(Cart cart);

    void deleteCart(Long userId);
    
    List<Product> getCartByOrerId(Long userId);
}
