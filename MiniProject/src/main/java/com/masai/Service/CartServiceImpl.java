package com.masai.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.masai.Exception.AdminException;
import com.masai.Exception.ProductException;
import com.masai.Exception.UserException;
import com.masai.Repository.ProductRepo;
import com.masai.Repository.UserRepo;
import com.masai.pojo.Cart;
import com.masai.pojo.Product;
import com.masai.pojo.User;

public class CartServiceImpl implements CartService{
	
	@Autowired
	private UserRepo userrepo;
	@Autowired
	private ProductRepo productrepo;
	

	@Override
	public Cart addProductToCart(Integer productId, Integer userId)
			throws UserException, AdminException, ProductException {
		// TODO Auto-generated method stub
		Optional<User> opt=userrepo.findById(userId);
		Optional<Product> opt1=productrepo.findById(productId);
		
		if(opt.isEmpty())
			throw new UserException("User with Id does not exist");
		if(opt1.isEmpty())
			throw new UserException("Product with Id does not exist");
		if(opt.isPresent()||opt.isPresent())
		{
			Cart c=new Cart();
			c.setProductId(productId);
			c.setUser(opt.get());
			//c.setStatus();
			
			return c;
		}
		
		return null;
	}

	@Override
	public Cart increaseProductQuantityInCart(Integer productId, String customerKey)
			throws  UserException, AdminException, ProductException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cart reduceProductQuantityInCart(Integer productId, String customerKey)
			throws UserException, AdminException, ProductException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cart deleteProductToCart(Integer productId, String customerKey)
			throws  UserException, AdminException, ProductException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> getProductListOfCart(String customerKey)
			throws  UserException, AdminException, ProductException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getCartValue(String customerKey)
			throws  UserException, AdminException, ProductException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cart emptyCart(String customerkey) throws  UserException, AdminException, ProductException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cart> getAllCartWithProduct(Product product) {
		// TODO Auto-generated method stub
		return null;
	}

}
