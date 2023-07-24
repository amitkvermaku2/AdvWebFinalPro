package com.uab.seller;

import java.util.List;

public interface SellerService {

	Seller createSeller(Seller seller);

    Seller getSellerById(Long sellerId);

    List<Seller> getAllSellers();

    Seller updateSeller(Seller seller);

    void deleteSeller(Long sellerId);
    
}
