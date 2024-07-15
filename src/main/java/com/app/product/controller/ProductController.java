package com.app.product.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.product.exception.ResourceNotFoundException;
import com.app.product.models.Product;
import com.app.product.repository.ProductRepository;

@RestController
@RequestMapping("/api")
public class ProductController {

	@Autowired
	private ProductRepository pr;
	
	@GetMapping(value="/get")
	public List<Product> getAllProduct(Product P){
		return pr.findAll();
	}
	
	@PostMapping(value="/post")
	public Product PostProduct(@RequestBody Product P) {
		return pr.save(P);
	}
	
	/*Api to fetch data by Id*/
	@GetMapping("/get/{id}")
	public Optional<Product> findDataById(@PathVariable(value="id")Long product_id) {
		return pr.findById(product_id);
	}
	
	        /*Api to update data by id */
			@PutMapping(value = "/put/{id}")
			public Product UpdateProduct(@PathVariable(value="id") Long product_id, @RequestBody Product P) {
				Product setProduct = pr.findById(product_id).orElseThrow(()->new ResourceNotFoundException(product_id,"id","Product"));
				setProduct.setProduct_name(P.getProduct_name());
				setProduct.setOwner_name(P.getOwner_name());
				setProduct.setProduct_price(P.getProduct_price());
				Product UpdateProduct = pr.save(setProduct);
				return UpdateProduct;
			}
			
			/*Api to Delete data by id */
			@DeleteMapping("/delete/{id}")
			public ResponseEntity<?> DeleteProduct(@PathVariable(value="id") Long ProductId) {
				Product product = pr.findById(ProductId).orElseThrow(()->new ResourceNotFoundException(ProductId,"id","Product"));
				pr.delete(product);
				return ResponseEntity.ok().build();
			}
			
	
}
