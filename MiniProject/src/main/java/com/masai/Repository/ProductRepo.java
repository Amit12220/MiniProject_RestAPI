package com.masai.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.masai.Exception.ProductException;
import com.masai.pojo.Product;

public interface ProductRepo extends JpaRepository<Product, Integer>{
	
	@Query("select p from Product p where p.price < ?1")
	public List<Product> getProductsUnderPrice(Integer price) throws ProductException ;

	@Query("select p from Product p where p.price Between ?1 AND ?2")
	public List<Product> getProductsFromPriceToPrice(Integer fromPrice, Integer toPrice) throws ProductException ;

}
