package com.adnan.springboot.rest.example.productcatalog;

public class ProductNotFoundException extends RuntimeException {

	public ProductNotFoundException(String exception) {
		super(exception);
	}

}
