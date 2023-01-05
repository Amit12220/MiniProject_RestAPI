package com.masai.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.masai.Exception.CartException;
import com.masai.Exception.UserException;
import com.masai.pojo.Order;

public interface OrderRepo extends JpaRepository<Order, Integer>{

	@Query("Delete c from Cart c where user.userId=?1 AND product.productId=?2 AND cartId=?3")
	public Order placeOrder(Integer UserId,Integer productId,Integer cartId) throws UserException, CartException ;
}
