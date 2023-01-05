package com.masai.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.masai.Exception.CategoryException;
import com.masai.pojo.Category;
import com.masai.pojo.Product;

public interface CategoryRepo extends JpaRepository<Category, Integer>{
	
	@Query("select p from Product p where category.categoryId=?1")
	public List<Product> getAllProductByCategoryId(Integer categoryId) throws CategoryException;
	
	@Query("select p from Product p where category.categoryname=?1")
	public List<Product> getAllProductByCategoryname(String categoryName) throws CategoryException;

}
