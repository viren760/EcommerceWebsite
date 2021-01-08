
<%@page import="com.learn.ecommercewebsite.helper.helper"%>
<%
User user = (User) session.getAttribute("current-user");
if (user == null) {
	session.setAttribute("message", "You are not logged in !! login first.");
	response.sendRedirect("login.jsp");
	return;
} else {

	if (user.getUser_type().equals("normal")) {
		session.setAttribute("message", " You are not Admin !");
		response.sendRedirect("login.jsp");
		return;
	}
}


long []arr = helper.getCounts();

%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.learn.ecommercewebsite.entities.User"%>
<%@ page import="com.learn.ecommercewebsite.dao.CategoryDao"%>
<%@ page import="java.util.List"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Panel</title>
<%@include file="components/common_css_js.jsp"%>
</head>
<body>
	<%@include file="components/navbar.jsp"%>
	
	<div class="container-fluid admin"  >

		<div class="container-fluid mt-3">

			<%@include file="components/message.jsp"%>

		</div>


		<div class="row mt-3 ">

			<div class="col-md-4"
				style="hover: background-color:#e2e2e2; cursor: pointer;">
				<div class="card">
					<div class="card-body text-center">
						<div class="container">
							<img style="max-width: 100px;" class="img-fluid rounded"
								src="img/customer.png" alt="user_icon">
						</div>
						<h1><%= arr[0] %></h1>
						<h1 class="text-uppercase text-muted">Users</h1>

					</div>

				</div>

			</div>

			<div class="col-md-4"
				style="hover: background-color:#e2e2e2; cursor: pointer;">
				<div class="card">
					<div class="card-body text-center">
						<div class="container">
							<img style="max-width: 100px;" class="img-fluid rounded"
								src="img/list.png " alt="user_icon">
						</div>
						<h1><%= arr[2] %></h1>
						<h1 class="text-uppercase text-muted">Category</h1>

					</div>

				</div>

			</div>

			<div class="col-md-4"
				style="hover: background-color:#e2e2e2; cursor: pointer;">
				<div class="card">
					<div class="card-body text-center">
						<div class="container">
							<img style="max-width: 100px;" class="img-fluid rounded"
								src="img/package.png" alt="user_icon">
						</div>
						<h1><%= arr[1] %></h1>
						<h1 class="text-uppercase text-muted">Products</h1>

					</div>

				</div>

			</div>
		</div>
		<div class="row mt-2">
			<div class="col-md-6"
				style="hover: background-color:#e2e2e2; cursor: pointer;">
				<div class="card " data-toggle="modal"
					data-target="#add-category-modal">
					<div class="card-body text-center">
						<div class="container">
							<img style="max-width: 100px;" class="img-fluid rounded"
								src="img/category.png" alt="user_icon">
						</div>
						<p class="mt-2">Click here to Add new Category</p>
						<h1 class="text-uppercase text-muted">Add Category</h1>

					</div>

				</div>

			</div>

			<div class="col-md-6"
				style="hover: background-color: #e2e2e2; cursor: pointer;">
				<div class="card" data-toggle="modal"
					data-target="#add-product-modal">
					<div class="card-body text-center">
						<div class="container">
							<img style="max-width: 100px;" class="img-fluid rounded"
								src="img/plus.png" alt="user_icon">
						</div>
						<p class="mt-2">Click here to Add new Product</p>
						<h1 class="text-uppercase text-muted">Add Product</h1>

					</div>

				</div>
			</div>
		</div>


	</div>


	<!-- Modal -->
	<div class="modal fade" id="add-category-modal" tabindex="-1"
		role="dialog" aria-labelledby="exampleModalLongTitle"
		aria-hidden="true">
		<div class="modal-dialog modal-lg" role="document">
			<div class="modal-content">
				<div class="modal-header custom-bg text-white">
					<h5 class="modal-title" id="exampleModalLongTitle">Fill
						Category Details</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<form action="ProductOperationServlet" method="post">
						<input type="hidden" name="operation" value="addcategory">

						<div class="form-group">
							<input type="text" class="form-control" name="cattitle"
								placeholder="Enter Category Title" required />

						</div>
						<div class="form-group text-center">
							<textarea style="height: 200px;" class="form-control"
								name="catDescription" placeholder="Enter Category Description"
								required> </textarea>
						</div>
						<div class="container text-center">

							<button class="btn btn-outline-success">Add Category</button>
							<button type="button" class="btn btn-outline-warning"
								data-dismiss="modal">Close</button>

						</div>
					</form>
				</div>

			</div>
		</div>
	</div>

	<!-- Modal -->
	<div class="modal fade" id="add-product-modal" tabindex="-1"
		role="dialog" aria-labelledby="exampleModalLongTitle"
		aria-hidden="true">
		<div class="modal-dialog modal-lg" role="document">
			<div class="modal-content">
				<div class="modal-header custom-bg text-white">
					<h5 class="modal-title" id="exampleModalLongTitle">Fill
						Product Details</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<form action="ProductOperationServlet" method="post"
						enctype="multipart/form-data">
						<input type="hidden" name="operation" value="addProduct">
						<div class="form-group">
							<input type="text" class="form-control" name="pName"
								placeholder="Enter Product Name" required />

						</div>
						<div class="form-group text-center">
							<textarea style="height: 200px;" class="form-control"
								name="pDescription" placeholder="Enter Product Description"
								required> </textarea>
						</div>
						<div class="form-group">
							<input type="number" class="form-control" name="pPrice"
								placeholder="Enter Product Price" required />

						</div>
						<div class="form-group">
							<input type="number" class="form-control" name="pDiscount"
								placeholder="Enter Product Discount" required />

						</div>
						<div class="form-group">
							<input type="number" class="form-control" name="pQuantity"
								placeholder="Enter Product Quantity" required />

						</div>

						<div class="form-group">
							<select name="catTitle" class="form-control">
								<%
							List<String>	list = CategoryDao.listOfAllcategorieNames();
								for (String str : list) {
								%>
								<option value="<%=str%>">
									<%=str%>
								</option>
								<%
								}
								%>
							</select>

						</div>

						<div class="form-group mt-2">
							<input type="file" class="form-control" name="pPic" required />

						</div>


						<div class="container text-center">

							<button class="btn btn-outline-success">Add Product</button>
							<button type="button" class="btn btn-outline-warning"
								data-dismiss="modal">Close</button>

						</div>
					</form>
				</div>

			</div>
		</div>
	</div>
<%@ include file="components/common_modal.jsp" %>>
</body>
</html>