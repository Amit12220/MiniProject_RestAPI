package com.masai.pojo;

import java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
@Entity
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer orderId;
	private Integer productId;
	private LocalDateTime dateTime;
	private boolean status;
	
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private User user;
	public Order() {
		super();
	}
	public Order(Integer productId, LocalDateTime dateTime, boolean status, User user) {
		super();
		this.productId = productId;
		this.dateTime = dateTime;
		this.status = status;
		this.user = user;
	}
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer integer) {
		this.productId = integer;
	}
	public LocalDateTime getDateTime() {
		return dateTime;
	}
	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}
	public boolean getStatus() {
		return status;
	}
	public void setStatus(boolean b) {
		this.status = b;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", productId=" + productId + ", dateTime=" + dateTime + ", status="
				+ status + ", user=" + user + ", getOrderId()=" + getOrderId() + ", getProductId()=" + getProductId()
				+ ", getDateTime()=" + getDateTime() + ", getStatus()=" + getStatus() + ", getUser()=" + getUser()
				+ "]";
	}
	
	
	

}
