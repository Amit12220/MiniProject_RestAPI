package com.masai.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Exception.CartException;
import com.masai.Exception.OrderException;
import com.masai.Exception.UserException;
import com.masai.Repository.CartRepo;
import com.masai.Repository.OrderRepo;
import com.masai.Repository.ProductRepo;
import com.masai.Repository.UserRepo;
import com.masai.pojo.Cart;
import com.masai.pojo.Order;
import com.masai.pojo.Product;
import com.masai.pojo.User;
@Service
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	private OrderRepo orderrepo;
	@Autowired
	private UserRepo userrepo;
	
	@Autowired
	private CartRepo cartrepo;
	@Autowired
	private ProductRepo prorepo;

	@Override
	public Order viewOrder(Integer orderId, Integer UserId) throws UserException, OrderException {
		// TODO Auto-generated method stub
		Optional<Order> opt=orderrepo.findById(orderId);
		if(opt.isPresent())
		{
			return opt.get();
		}
		else
		{
			throw new OrderException("Order with this Id does not exist");
		}
		
	}

	@Override
	public List<Order> viewAllOrder(Integer UserId) throws UserException, OrderException {
		// TODO Auto-generated method stub
		
		Optional<User> opt=userrepo.findById(UserId);
		if(opt.isPresent())
		{
			List<Order> list=orderrepo.findAll();
			if(list!=null)
			{
				return list;
			}
			else
			{
				throw new OrderException("User with this Id does not exist");	
			}
		}
		else
		{
			throw new OrderException("No order avaliable with this userId");
		}
	}

	@Override
	public Order deleteOrderByOrderId(Integer orderId, Integer UserId) throws UserException, OrderException {
		Optional<User> opt=userrepo.findById(UserId);
		if(opt.isPresent())
		{
			Optional<Order> opt1=orderrepo.findById(orderId);
			if(opt1.isPresent())
			{
				orderrepo.delete(opt1.get());
				return opt1.get();
			}
			else
			{
				throw new OrderException("No order avaliable with this userId");	
			}
		}
		else
		{
			throw new OrderException("User with this Id does not exist");
		}
	}

	@Override
	public Order updateOrderByOrderId(Order order, Integer UserId) throws UserException, OrderException {
		// TODO Auto-generated method stub
		Optional<User> opt=userrepo.findById(UserId);
		if(opt.isPresent())
		{
			Optional<Order> opt1=orderrepo.findById(order.getOrderId());
			if(opt1.isPresent())
			{
				orderrepo.save(opt1.get());
				return opt1.get();
			}
			else
			{
				throw new OrderException("No order avaliable with this userId");	
			}
		}
		else
		{
			throw new OrderException("User with this Id does not exist");
		}
	}
	

	@Override
	public Order placeOrder(Integer UserId,Integer productId,Integer cartId) throws UserException, CartException {
		// TODO Auto-generated method stub
		Optional<User> opt=userrepo.findById(UserId);
		Optional<Product> opt1=prorepo.findById(productId);
		Optional<Cart> opt2=cartrepo.findById(cartId);
		if(opt.isPresent()&&opt1.isPresent()&&opt2.isPresent())
		{
			Cart c=opt2.get();
			if(c.getProductId()==productId)
			{
				
				Order or=new Order();
				or.setDateTime(c.getDateTime());
				or.setUser(opt.get());
				or.setStatus(true);
			}
			
			
		}
		return null;
		
	}

	@Override
	public boolean getProductInOrders(Product product) {
		// TODO Auto-generated method stub
		return false;
	}

	

	

}
