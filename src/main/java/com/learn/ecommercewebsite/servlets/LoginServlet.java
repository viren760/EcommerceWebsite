package com.learn.ecommercewebsite.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.learn.ecommercewebsite.dao.UserDao;
import com.learn.ecommercewebsite.entities.User;
import com.learn.ecommercewebsite.helper.FactoryProvider;

public class LoginServlet extends HttpServlet {

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		try (PrintWriter out = response.getWriter()) {

			String email = request.getParameter("email");
			String password = request.getParameter("password");

			
			// validations

			
			// authentications
			UserDao userDao = new UserDao(FactoryProvider.getFactory());
			User user = userDao.getUserByEmailAndPassword(email, password);
			HttpSession httpsession = request.getSession();
		
			
			if (user == null) {
				httpsession.setAttribute("message", "user not found");
				response.sendRedirect("login.jsp");
				return;
			} else {

				out.println(" <h1> Welcome" + user.getUserName() + "</h1>");

				httpsession.setAttribute("current-user", user);
				if (user.getUser_type().equals("admin")) {
					httpsession.setAttribute("message", "welcome admin");
					response.sendRedirect("admin.jsp");
				} else {

					httpsession.setAttribute("message", "welcome user");
					response.sendRedirect("normal.jsp");
				}

			}
		}
	}

	/**
	 * Handles the HTTP <code>GET</code> method.
	 *
	 * @param request  servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException      if an I/O error occurs
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * Handles the HTTP <code>POST</code> method.
	 *
	 * @param request  servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException      if an I/O error occurs
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * Returns a short description of the servlet.
	 *
	 * @return a String containing servlet description
	 */
	@Override
	public String getServletInfo() {
		return "Short description";
	}// </editor-fold>

}
