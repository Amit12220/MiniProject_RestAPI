package com.masai.Service;

import java.util.List;

import com.masai.Exception.CartException;
import com.masai.Exception.OrderException;
import com.masai.Exception.UserException;
import com.masai.pojo.Order;
import com.masai.pojo.Product;



public interface OrderService {
	

	public Order viewOrder(Integer orderId, Integer UserId) throws  UserException, OrderException;

	public List<Order> viewAllOrder(Integer UserId) throws UserException, OrderException;

	public Order deleteOrderByOrderId(Integer orderId,Integer UserId)
			throws  UserException, OrderException;

	public Order updateOrderByOrderId(Order order, Integer UserId)
			throws  UserException, OrderException;

	public Order placeOrder(Integer UserId,Integer productId,Integer cartId) throws  UserException, CartException;

	public boolean getProductInOrders(Product product);

}
