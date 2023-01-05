package com.masai.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Exception.AdminException;
import com.masai.Exception.CategoryException;
import com.masai.Repository.CategoryRepo;
import com.masai.pojo.Category;
import com.masai.pojo.Product;

public class CategoryServiceImpl implements CategoryService{
	
	@Autowired
	private CategoryRepo caterepo;

	@Override
	public Category addCategory(Category category) throws AdminException, CategoryException {
		// TODO Auto-generated method stub
		if(category!=null)
		{
			caterepo.save(category);
			return category;
		}
		else
		{
		   throw new CategoryException("Category data is not perfect");
		}
		
	}

	@Override
	public Category updateCategory(Category category) throws AdminException, CategoryException {
		// TODO Auto-generated method stub
		Optional<Category> opt=caterepo.findById(category.getCategoryId());
		if(opt.isPresent())
		{
			caterepo.save(opt.get());
			return opt.get();
		}
		else
		{
			throw new CategoryException("Category with Id does  not perfect");
		}
		
	}

	@Override
	public Category getCategoryById(Integer categoryId) throws CategoryException, AdminException {
		// TODO Auto-generated method stub
		Optional<Category> opt=caterepo.findById(categoryId);
		if(opt.isPresent())
		{
			
			return opt.get();
		}
		else
		{
			throw new CategoryException("Category with Id does  not perfect");
		}
	}

	@Override
	public Category deleteCategory(Integer categoryId) throws CategoryException, AdminException {
		// TODO Auto-generated method stub
		Optional<Category> opt=caterepo.findById(categoryId);
		if(opt.isPresent())
		{
			caterepo.delete(opt.get());;
			return opt.get();
		}
		else
		{
			throw new CategoryException("Category with Id does  not perfect");
		}
	}

	@Override
	public List<Category> getAllCategory() throws CategoryException {
		// TODO Auto-generated method stub
		List<Category> list=caterepo.findAll();
		if(list!=null)
		{
			return list;
		}
		else
		{
			throw new CategoryException("No category Avaliable");
		}
	
	}

	@Override
	public List<Product> getAllProductByCategoryId(Integer categoryId) throws CategoryException {
		// TODO Auto-generated method stub
		List<Product> list=caterepo.getAllProductByCategoryId(categoryId);
		if(list!=null)
		{
			return list;
		}
		else
		{
			throw new CategoryException("No Product Avaliable with this categoryId");
		}
	}

	@Override
	public List<Product> getAllProductByCategoryname(String categoryName) throws CategoryException {
		// TODO Auto-generated method stub
		List<Product> list=caterepo.getAllProductByCategoryname(categoryName);
		if(list!=null)
		{
			return list;
		}
		else
		{
			throw new CategoryException("No Product Avaliable with this categoryName");
		}
	}

	
}
