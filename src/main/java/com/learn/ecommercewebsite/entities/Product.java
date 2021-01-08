package com.learn.ecommercewebsite.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

@Entity
public class Product {
 
	// product should have these variables ......
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pId;
	private String pName;
	@Column(length = 1500)
	private String pDesc;

	@Lob
	private String pPhoto;
	private int pPrice;
	private int pDiscount;
	private int pQuantity;
	@ManyToOne
	private Category category;

	//creating constructor 3 times
	// 1. where all variables are there.
	// 2. except primary key (in my case pID is my primary Key) variable all the variables are there.
	// 3. its a  default constructor .
	
	
	public Product(Integer pId, String pName, String pDesc, String pPhoto, Integer pPrice, Integer pDiscount,
			Integer pQuantity) {
		this.pId = pId;
		this.pName = pName;
		this.pDesc = pDesc;
		this.pPhoto = pPhoto;
		this.pPrice = pPrice;
		this.pDiscount = pDiscount;
		this.pQuantity = pQuantity;
	}

	public Product(String pName, String pDesc, String pPhoto, Integer pPrice, Integer pDiscount, Integer pQuantity,
			Category category) {
		this.pName = pName;
		this.pDesc = pDesc;
		this.pPhoto = pPhoto;
		this.pPrice = pPrice;
		this.pDiscount = pDiscount;
		this.pQuantity = pQuantity;
		this.category = category;
	}

	public Product() {
	}
	
	
	// Set getter / setter for all variables

	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public String getpDesc() {
		return pDesc;
	}

	public void setpDesc(String pDesc) {
		this.pDesc = pDesc;
	}

	public String getpPhoto() {
		return pPhoto;
	}

	public void setpPhoto(String pPhoto) {
		this.pPhoto = pPhoto;
	}

	public int getpPrice() {
		return pPrice;
	}

	public void setpPrice(int pPrice) {
		this.pPrice = pPrice;
	}

	public int getpDiscount() {
		return pDiscount;
	}

	public void setpDiscount(int pDiscount) {
		this.pDiscount = pDiscount;
	}

	public int getpQuantity() {
		return pQuantity;
	}

	public void setpQuantity(int pQuantity) {
		this.pQuantity = pQuantity;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	// set tostring for all variables
	
	@Override
	public String toString() {
		return "Product{" + "pId=" + pId + ", pName=" + pName + ", pDesc=" + pDesc + ", pPhoto=" + pPhoto + ", pPrice="
				+ pPrice + ", pDiscount=" + pDiscount + ", pQuantity=" + pQuantity + '}';
	}

	public int getPriceAfterApplyingDicount() {

		int d = (int) ((this.getpPrice() / 100.0) * this.getpDiscount());
		return this.getpPrice() - d;

	}
}
