package com.masai.Service;

import java.util.List;

import com.masai.Exception.AdminException;
import com.masai.Exception.ProductException;
import com.masai.Exception.UserException;
import com.masai.pojo.Cart;
import com.masai.pojo.Product;



public interface CartService {
	
	public Cart addProductToCart(Integer productId, Integer userId)
			throws  UserException, AdminException, ProductException;

	public Cart increaseProductQuantityInCart(Integer productId, String customerKey)
			throws  UserException, AdminException, ProductException;

	public Cart reduceProductQuantityInCart(Integer productId, String customerKey)
			throws  UserException, AdminException, ProductException;

	public Cart deleteProductToCart(Integer productId, String customerKey)
			throws  UserException, AdminException, ProductException;

	public List<Product> getProductListOfCart(String customerKey)
			throws  UserException, AdminException, ProductException;

	public Integer getCartValue(String customerKey)
			throws  UserException, AdminException, ProductException;

	public Cart emptyCart(String customerkey) throws  UserException, AdminException, ProductException;

	public List<Cart> getAllCartWithProduct(Product product);

}
