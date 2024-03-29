package com.uab.product;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.uab.user.User;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ProductController {

	@Autowired
    ProductService productService;

    @PostMapping("/saveProduct")
    public ResponseEntity<Product> createProduct(@RequestBody Product product){
        Product savedproduct = productService.createProduct(product);
        return new ResponseEntity<>(savedproduct, HttpStatus.CREATED);
    }

    @GetMapping("/getProductById/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") Long productId){
        Product product = productService.getProductById(productId);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @GetMapping("/getAllProducts")
    public ResponseEntity<List<Product>> getAllProduct(){
        List<Product> products = productService.getAllProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @PutMapping("/updateProductById/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable("id") Long productId,
                                           @RequestBody Product product){
    	Product existingProduct = productService.getProductById(productId);

        if (existingProduct == null) {
            return ResponseEntity.notFound().build();
        }
        Product updatedProduct = productService.updateProduct(product);
        return ResponseEntity.ok(updatedProduct);
    }
    
    @GetMapping("/getProductByIdCHeck/{id}/{sid}")
    public ResponseEntity<Product> getProductByIdCheck(@PathVariable("id") Long productId, @PathVariable("sid") Long sellerId){
        Product product = productService.getProductById(productId);
        if(product.getSellerId().equals(sellerId)) {
        return new ResponseEntity<>(product, HttpStatus.OK);}
        else {
        	return ResponseEntity.badRequest().body(null);
        }
    }
    
    @GetMapping("/getAllProductsById/{sellerId}")
    public ResponseEntity<List<Product>> getAllProductById(@PathVariable("sellerId") Long sellerId){
        List<Product> products = productService.getAllProductsBySellerId(sellerId);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @DeleteMapping("deleteProduct/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable("id") Long productId){
        productService.deleteProduct(productId);
        return new ResponseEntity<>("Product successfully deleted!", HttpStatus.OK);
    }
}
