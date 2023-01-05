package com.masai.pojo;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer userId;
	private String userName;
	private String mobile;
	private String email;
	private String password;
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	List<Order> order=new ArrayList<>();
	
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private Cart cart;
	public User() {
		super();
	}
	public User(String userName, String mobile, String email, String password, List<Order> order, Cart cart) {
		super();
		this.userName = userName;
		this.mobile = mobile;
		this.email = email;
		this.password = password;
		this.order = order;
		this.cart = cart;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<Order> getOrder() {
		return order;
	}
	public void setOrder(List<Order> order) {
		this.order = order;
	}
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", mobile=" + mobile + ", email=" + email
				+ ", password=" + password + ", order=" + order + ", cart=" + cart + ", getUserId()=" + getUserId()
				+ ", getUserName()=" + getUserName() + ", getMobile()=" + getMobile() + ", getEmail()=" + getEmail()
				+ ", getPassword()=" + getPassword() + ", getOrder()=" + getOrder() + ", getCart()=" + getCart() + "]";
	}
	
	
	
	

}
