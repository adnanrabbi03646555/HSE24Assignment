package com.adnan.springboot.rest.example.productcatalog;

import java.net.URI;
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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class ProductResource {

	@Autowired
	private ProductRepository productRepository;

	@GetMapping("/products")
	public List<Product> retrieveAllProducts() {
		return productRepository.findAll();
	}

	@GetMapping("/products/{key}")
	public Product retrieveProduct(@PathVariable String key) {
		Optional<Product> product = productRepository.findById(key);

		if (!product.isPresent())
			throw new ProductNotFoundException("key-" + key);

		return product.get();
	}

	@DeleteMapping("/products/{key}")
	public void deleteStudent(@PathVariable String key) {
		productRepository.deleteById(key);
	}

	@PostMapping("/products")
	public ResponseEntity<Object> createProduct(@RequestBody Product product) {
		Product savedProduct = productRepository.save(product);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{key}")
				.buildAndExpand(savedProduct.getKey()).toUri();

		return ResponseEntity.created(location).build();

	}
	
	@PutMapping("/products/{key}")
	public ResponseEntity<Object> updateProduct(@RequestBody Product product, @PathVariable String key) {

		Optional<Product> productOptional = productRepository.findById(key);

		if (!productOptional.isPresent())
			return ResponseEntity.notFound().build();

		product.setKey(key);
		
		productRepository.save(product);

		return ResponseEntity.noContent().build();
	}
}
