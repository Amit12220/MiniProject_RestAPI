package com.masai.pojo;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer productId;
	
	
	@ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private Category category;
    private Integer price;

	
	
	public Product() {
		super();
		
	}



	public Product(Category category, Integer price) {
		super();
		this.category = category;
		this.price = price;
	}



	public Integer getProductId() {
		return productId;
	}



	public void setProductId(Integer productId) {
		this.productId = productId;
	}



	public Category getCategory() {
		return category;
	}



	public void setCategory(Category category) {
		this.category = category;
	}



	public Integer getPrice() {
		return price;
	}



	public void setPrice(Integer price) {
		this.price = price;
	}



	@Override
	public String toString() {
		return "Product [productId=" + productId + ", category=" + category + ", price=" + price + ", getProductId()="
				+ getProductId() + ", getCategory()=" + getCategory() + ", getPrice()=" + getPrice() + "]";
	}

	
	
	

}
