package com.learn.ecommercewebsite.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.learn.ecommercewebsite.entities.User;
import com.learn.ecommercewebsite.helper.FactoryProvider;

public class RegisterServlet extends HttpServlet {

	private String userId;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		try (PrintWriter out = response.getWriter()) {

			try {

				String userName = request.getParameter("user_name");
				String userEmail = request.getParameter("user_email");
				String userPassword = request.getParameter("user_password");
				String userPhone = request.getParameter("user_phone");
				String userAddress = request.getParameter("user_address");

				// validation

				if (userName.isEmpty()) {
					out.println("Name is Blank");
					return;
				}
				if (userEmail.isEmpty()) {
					out.println("Email is Blank");
					return;
				}
				if (userPassword.isEmpty()) {
					out.println("Password is Blank");
					return;
				}
				if (userPhone.isEmpty()) {
					out.println("Phone Number is Blank");
					return;
				}
				if (userAddress.isEmpty()) {
					out.println("Address is Blank");
					return;
				}

				// creating user object to store data
				User user = new User(userName, userEmail, userPassword, userPhone, "shopping.jpg", userAddress,
						"normal");

				Session hibernateSession = FactoryProvider.getFactory().openSession();
				Transaction tx = hibernateSession.beginTransaction();

				hibernateSession.save(user);

				tx.commit();
				hibernateSession.close();

				HttpSession httpSession = request.getSession();
				httpSession.setAttribute("message", "Registration Successfully !!" + userId);
				response.sendRedirect("register.jsp");
				return;

			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}

}
