package com.learn.ecommercewebsite.servlets;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.learn.ecommercewebsite.dao.CategoryDao;
import com.learn.ecommercewebsite.dao.ProductDao;
import com.learn.ecommercewebsite.entities.Category;
import com.learn.ecommercewebsite.entities.Product;

/**
 * Servlet implementation class ProductOperationServlet
 */
@WebServlet("/ProductOperationServlet")
@MultipartConfig
public class ProductOperationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProductOperationServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);

		// fetching category data

		String op = request.getParameter("operation");
		CategoryDao categoryDao = new CategoryDao();
		HttpSession httpSession = request.getSession();

		if (op.trim().equals("addcategory")) {
			String title = request.getParameter("cattitle");
			String description = request.getParameter("catDescription");

			Category category = new Category();
			category.setCategoryTitle(title);
			category.setCategoryDescription(description);

			// category database save

			boolean isAddedToDatabase = categoryDao.saveCategory(category);

			if (isAddedToDatabase == false) {
				httpSession.setAttribute("message", "category not added/already exists");
				response.sendRedirect("admin.jsp");
			} else {
				httpSession.setAttribute("message", "Category Added Succesfully");
				response.sendRedirect("admin.jsp");
			}
		} else if (op.trim().equals("addProduct")) {
			String name = request.getParameter("pName");
			String description = request.getParameter("pDescription");
			Integer price = Integer.parseInt(request.getParameter("pPrice"));
			Integer discount = Integer.parseInt(request.getParameter("pDiscount"));
			Integer quantity = Integer.parseInt(request.getParameter("pQuantity"));
			String categoryTitle = request.getParameter("catTitle");
			String filename = this.uploadFile(request.getPart("pPic"));

			Category category = categoryDao.getCategoryByName(categoryTitle.trim());

			System.out.println("category from database : " + category);

			Product product = new Product(name, description, filename, price, discount, quantity, category);
			ProductDao productDao = new ProductDao();

			boolean isProductSaved = productDao.saveProduct(product);
			if (isProductSaved == false) {
				httpSession.setAttribute("message", "product not added/ an error occured");
				response.sendRedirect("admin.jsp");
			} else {
				httpSession.setAttribute("message", "product Added Succesfully");
				response.sendRedirect("admin.jsp");
			}

		}

	}
//	

	private String uploadFile(Part filePart) {
		String filename = this.generateRandomUUID() + filePart.getSubmittedFileName();
// 		try (FileOutputStream fout = new FileOutputStream(
// 				"C:\\Users\\V I R E N\\Desktop\\New folder\\EcommerceWebsite\\EcommerceWebsite\\src\\main\\webapp\\img\\products\\"
// 						+ filename)) {
// 			InputStream is = filePart.getInputStream();
// 			byte[] readAllBytes = is.readAllBytes();
// 			fout.write(readAllBytes);

// 		} catch (Exception e) {
// 			e.printStackTrace();
// 			System.out.println("error occured while saving image");
// 		}
		return filename;
	}

	private String generateRandomUUID() {
		return UUID.randomUUID().toString();
	}
}
