package com.masai.Service;

import java.util.List;

import com.masai.Exception.AdminException;
import com.masai.Exception.CategoryException;
import com.masai.Exception.OrderException;
import com.masai.Exception.ProductException;
import com.masai.Exception.UserException;
import com.masai.pojo.Cart;
import com.masai.pojo.Product;


public interface ProductService {
	
	public Product addProduct(Product product)
			throws  AdminException,ProductException;

	public Product updateProduct(Product product)
			throws  AdminException, ProductException;

	public Product deleteProduct(Integer productId)
			throws  AdminException, ProductException;

	public Product getProductById(Integer productId) throws ProductException;

	public List<Product> getAllProducts() throws ProductException;

	public List<Product> getProductsUnderPrice(Integer price) throws ProductException;

	public List<Product> getProductsFromPriceToPrice(Integer fromPrice, Integer toPrice) throws ProductException;

	

}
