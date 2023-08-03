package com.uab.odetail;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


public interface OrderDetailRepository extends JpaRepository<OrderDetailSeller, Long> {
	List<OrderDetailSeller> findBySellerId(Long sellerId);
}
