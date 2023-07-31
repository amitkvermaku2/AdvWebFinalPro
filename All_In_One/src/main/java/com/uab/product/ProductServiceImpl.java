package com.uab.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepository;
	
	@Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id).get();
    }

    @Override
    public List<Product> getAllProducts() {
    	return (List<Product>) productRepository.findAll();
    }

    @Override
    public Product updateProduct(Product product) {
    	return productRepository.save(product);
    }

    @Override
    public void deleteProduct(Long productId) {
    	productRepository.deleteById(productId);
    }
    
    @Override
    public List<Product> getAllProductsBySellerId(Long sellerId){
       return productRepository.findOrderByProductsId(sellerId);
    }
}
