package com.masai.Service;

import java.util.List;

import com.masai.Exception.AdminException;
import com.masai.Exception.CategoryException;
import com.masai.pojo.Category;
import com.masai.pojo.Product;

public interface CategoryService {
	
	public Category addCategory(Category category) throws  AdminException, CategoryException;

	public Category updateCategory(Category category) throws AdminException, CategoryException;

	public Category getCategoryById(Integer categoryId) throws CategoryException,  AdminException;

	public Category deleteCategory(Integer categoryId) throws CategoryException,  AdminException;

	public List<Category> getAllCategory() throws CategoryException;

	public List<Product> getAllProductByCategoryId(Integer categoryId) throws CategoryException;

	public List<Product> getAllProductByCategoryname(String categoryName) throws CategoryException;

}
