package com.adnan.springboot.rest.example.productcatalog;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Product {
	@Id
	@GeneratedValue
	private String key;
	private String title;
	private String price;
	private String imageSrc;
	
	public Product() {
		super();
	}

	public Product(String key, String title, String imageSrc,String price) {
		super();
		this.key = key;
		this.title = title;
		this.imageSrc = imageSrc;
		this.price = price;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getImageSrc() {
		return imageSrc;
	}

	public void setImageSrc(String imageSrc) {
		this.imageSrc = imageSrc;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}
	
		
}
