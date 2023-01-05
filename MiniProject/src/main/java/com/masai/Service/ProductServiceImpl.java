package com.masai.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Exception.AdminException;
import com.masai.Exception.CategoryException;
import com.masai.Exception.OrderException;
import com.masai.Exception.ProductException;
import com.masai.Exception.UserException;
import com.masai.Repository.ProductRepo;
import com.masai.pojo.Cart;
import com.masai.pojo.Product;


@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductRepo prorepo;

	@Override
	public Product addProduct(Product product) throws AdminException, ProductException {
		// TODO Auto-generated method stub
		
		if(product!=null)
		{
			prorepo.save(product);
			return product;
		}
		else
		{
			throw new ProductException("something wrong in this product");
		}
		
	}

	@Override
	public Product updateProduct(Product product) throws AdminException, ProductException {
		// TODO Auto-generated method stub
		Optional<Product> opt=prorepo.findById(product.getProductId());
		if(opt.isPresent())
		{
			prorepo.save(product);
			return product;
		}
		else
		{
			throw new ProductException("product with this Id is not available");
		}
	
	}

	@Override
	public Product deleteProduct(Integer productId) throws AdminException, ProductException {
		// TODO Auto-generated method stub
		Optional<Product> opt=prorepo.findById(productId);
		if(opt.isPresent())
		{
			prorepo.delete(opt.get());
			return opt.get();
		}
		else
		{
			throw new ProductException("product with this Id is not available");
		}
		
	}

	@Override
	public Product getProductById(Integer productId) throws ProductException {
		// TODO Auto-generated method stub
		Optional<Product> opt=prorepo.findById(productId);
		if(opt.isPresent())
		{
			return opt.get();
		}
		else
		{
			throw new ProductException("product with this Id is not available");
		}
		
	}

	@Override
	public List<Product> getAllProducts() throws ProductException {
		// TODO Auto-generated method stub
		List<Product> list=prorepo.findAll();
		if(list!=null)
		{
			return list;
		}
		else
		{
			throw new ProductException("No products available");
		}
	}

	@Override
	public List<Product> getProductsUnderPrice(Integer price) throws ProductException {
		// TODO Auto-generated method stub
		List<Product> list=prorepo.getProductsUnderPrice(price);
		if(list!=null)
		{
			return list;
		}
		else
		{
			throw new ProductException("No products available under this price");
		}
		
	}

	@Override
	public List<Product> getProductsFromPriceToPrice(Integer fromPrice, Integer toPrice) throws ProductException {
		// TODO Auto-generated method stub
		List<Product> list=prorepo.getProductsFromPriceToPrice(fromPrice, toPrice);
		if(list!=null)
		{
			return list;
		}
		else
		{
			throw new ProductException("No products available from " +fromPrice +"to "+toPrice);
		}
	}


	

	
}
