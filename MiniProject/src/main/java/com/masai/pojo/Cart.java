package com.masai.pojo;

import java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
@Entity
public class Cart {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer cartId;
	private Integer productId;
	private LocalDateTime dateTime;
	private Status status;
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private User user;
	public Cart() {
		super();
	}
	public Cart(Integer productId, LocalDateTime dateTime, Status status, User user) {
		super();
		this.productId = productId;
		this.dateTime = dateTime;
		this.status = status;
		this.user = user;
	}
	public Integer getCartId() {
		return cartId;
	}
	public void setCartId(Integer cartId) {
		this.cartId = cartId;
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId2) {
		this.productId = productId2;
	}
	public LocalDateTime getDateTime() {
		return dateTime;
	}
	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", productId=" + productId + ", dateTime=" + dateTime + ", status=" + status
				+ ", user=" + user + ", getCartId()=" + getCartId() + ", getProductId()=" + getProductId()
				+ ", getDateTime()=" + getDateTime() + ", getStatus()=" + getStatus() + ", getUser()=" + getUser()
				+ "]";
	}
	
	
	
	

}
