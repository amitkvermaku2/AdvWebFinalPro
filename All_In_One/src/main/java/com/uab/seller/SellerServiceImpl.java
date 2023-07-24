package com.uab.seller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class SellerServiceImpl implements SellerService {

	@Autowired
	SellerRepository sellerRepository;
	
	@Override
    public Seller createSeller(Seller seller) {
		seller.setRole("seller");
        return sellerRepository.save(seller);
    }

    @Override
    public Seller getSellerById(Long id) {
        return sellerRepository.findById(id).get();
    }

    @Override
    public List<Seller> getAllSellers() {
    	return (List<Seller>) sellerRepository.findAll();
    }

    @Override
    public Seller updateSeller(Seller seller) {
    	seller.setRole("seller");
        return null;
    }

    @Override
    public void deleteSeller(Long sellerId) {
    	sellerRepository.deleteById(sellerId);
    }
    
}
