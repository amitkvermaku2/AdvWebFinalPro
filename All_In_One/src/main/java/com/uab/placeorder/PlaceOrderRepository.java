package com.uab.placeorder;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.uab.product.Product;

public interface PlaceOrderRepository extends JpaRepository<PlaceOrder, Long> {

	@Query(value = "SELECT * FROM place_order WHERE user_id = ?1", nativeQuery = true)
	List<PlaceOrder> findAllByUserId(Long userId);
}
