package com.masai.pojo;
import jakarta.persistence.CascadeType;
import java.util.ArrayList;
import java.util.List;



import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer categoryId;
	
	@ElementCollection(fetch = FetchType.EAGER)
	@ManyToMany(cascade = CascadeType.ALL,mappedBy = "productCategory")
	List<Product> list=new ArrayList<>();

	public Category(List<Product> list) {
		super();
		this.list = list;
	}

	public Category() {
		super();
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public List<Product> getList() {
		return list;
	}

	public void setList(List<Product> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", list=" + list + ", getCategoryId()=" + getCategoryId()
				+ ", getList()=" + getList() + "]";
	}
	
	
	

}
