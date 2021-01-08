package com.learn.ecommercewebsite.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Category {

	// categories should have these variables ...
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int categoryId;
	@Column(unique = true)
	private String categoryTitle;
	private String categoryDescription;
	@OneToMany(mappedBy = "category")
	private List<Product> products = new ArrayList<>();

	//creating constructor 3 times
		// 1. where all variables are there.
     	// 2. except primary key (in my case categoryID is my primary Key) variable all the variables are there.
		// 3. its a  default constructor .
		
	
	public Category(Integer categoryId, String categoryTitle, String categoryDescription) {
		this.categoryId = categoryId;
		this.categoryTitle = categoryTitle;
		this.categoryDescription = categoryDescription;
	}

	public Category(String categoryTitle, String categoryDescription, List<Product> products) {
		this.categoryTitle = categoryTitle;
		this.categoryDescription = categoryDescription;
		this.products = products;
	}

	public Category() {
	}
	
	
	// set getter / setter for all variables 

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryTitle() {
		return categoryTitle;
	}

	public void setCategoryTitle(String categoryTitle) {
		this.categoryTitle = categoryTitle;
	}

	public String getCategoryDescription() {
		return categoryDescription;
	}

	public void setCategoryDescription(String categoryDescription) {
		this.categoryDescription = categoryDescription;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	// set tostring for all variables
	
	@Override
	public String toString() {
		return "Category{" + "categoryId=" + categoryId + ", categoryTitle=" + categoryTitle + ", categoryDescription="
				+ categoryDescription + '}';
	}

}
