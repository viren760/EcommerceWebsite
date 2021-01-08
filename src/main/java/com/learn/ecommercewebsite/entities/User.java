package com.learn.ecommercewebsite.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {

	// User should have these variables ......
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length = 10, name = "user_id")
	private int userId;
	@Column(length = 100, name = "user_name")
	private String userName;
	@Column(length = 100, name = "user_email")
	private String userEmail;
	@Column(length = 100, name = "user_password")
	private String userPassword;
	@Column(length = 12, name = "user_phone")
	private String userPhone;
	@Column(length = 1500, name = "user_pic")
	private String userPic;
	@Column(length = 1500, name = "user_Address")
	private String userAddress;

	@Column(name = "user_type")
	private String user_Type;

	
	//creating constructor 3 times
	 // 1. where all variables are there.
	 // 2. except primary key (in my case user_id is my primary Key) variable all the variables are there.
	 // 3. its a  default constructor .
	
	public User(Integer userId, String userName, String userEmail, String userPassword, String userPhone,
			String userPic, String userAddress) {
		this.userId = userId;
		this.userName = userName;
		this.userEmail = userEmail;
		this.userPassword = userPassword;
		this.userPhone = userPhone;
		this.userPic = userPic;
		this.userAddress = userAddress;
	}

	public User(String userName, String userEmail, String userPassword, String userPhone, String userPic,
			String userAddress, String userType) {
		this.userName = userName;
		this.userEmail = userEmail;
		this.userPassword = userPassword;
		this.userPhone = userPhone;
		this.userPic = userPic;
		this.userAddress = userAddress;
		this.user_Type = userType;

	}

	public User() {
	}

	// set getter / setter for all variables
	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserPic() {
		return userPic;
	}

	public void setUserPic(String userPic) {
		this.userPic = userPic;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public String getUser_type() {
		return user_Type;
	}

	public void setUser_type(String user_type) {
		this.user_Type = user_type;
	}

	
	// set tostring for all variables
	
	@Override
	public String toString() {
		return "User{" + "userId=" + userId + ", userName=" + userName + ", userEmail=" + userEmail + ", userPassword="
				+ userPassword + ", userPhone=" + userPhone + ", userPic=" + userPic + ", userAddress=" + userAddress
				+ '}';
	}

}
