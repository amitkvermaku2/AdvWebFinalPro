package com.uab.seller;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;


public interface SellerRepository extends CrudRepository<Seller, Long>{
	
}
