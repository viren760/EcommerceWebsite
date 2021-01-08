<%@page import="com.learn.ecommercewebsite.helper.helper"%>
<%@page import="com.learn.ecommercewebsite.dao.CategoryDao"%>
<%@page import="com.learn.ecommercewebsite.entities.*"%>
<%@page import="java.util.List"%>
<%@page import="com.learn.ecommercewebsite.dao.ProductDao"%>
<%@page import="com.learn.ecommercewebsite.helper.FactoryProvider"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.learn.ecommercewebsite.entities.User"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Normal Panel</title>
<%@include file="components/common_css_js.jsp"%>
</head>
<body>
	<%@ include file="components/navbar1.jsp"%>

	<%
	List<Product> list = null;
	ProductDao p = new ProductDao();
	if (request.getParameter("cId") == null || request.getParameter("cId").equals("")) {
		list = p.getAllProducts();
	} else {
		list = p.getProductsByCategoryId(Integer.parseInt(request.getParameter("cId")));
	}
	List<Category> clist = CategoryDao.listOfAllcategories();
	%>

	<div class="container-fluid  d-flex flex-column flex-md-row"
		style="background: #e2e2e2;">
		<div class="col-12 col-sm-12 col-md-3 col-lg-2  mt-4" >

			<div class="list-group">

				<a href="index.jsp"
					class="list-group-item list-group-item-action active"> All
					Products </a>

				<%
				for (Category c : clist) {
				%>

				<a href="index.jsp?cId=<%=c.getCategoryId()%>"
					class="list-group-item list-group-item-action"> <%=c.getCategoryTitle()%></a>
				<%
				}
				%>
			</div>

		</div>









		<div class="col-12 col-sm-12 col-md-9 col-lg-10 ">
			<div class="row mt-4">
				<div class="col-md-12">

					<div class="card-columns">

						<%
						for (Product p2 : list) {
						%>

						<div class="card product-card">
							<div class="conatiner text-center">
								<img src=" img/products/<%=p2.getpPhoto()%>"
									style="max-height: 200px; max-width: 100%; width: auto;"
									class="card-img-top m-2" alt="">
							</div>
							<div class="card-body">

								<h5 class="card-title"><%=p2.getpName()%>
								</h5>

								<p class="card-text">
									<%=helper.get10Words(p2.getpDesc())%>
								</p>
							</div>
							<div class="card-footer d-flex">
								<button class="btn custom-bg text-white"
									onclick="add_to_cart(<%=p2.getpId()%>,'<%=p2.getpName()%>',<%=p2.getpPrice()%>)">Add
									to cart</button>
								<button class="btn-outline-success ">
									&#8377;
									<%=p2.getPriceAfterApplyingDicount()%>/- <span
										class="text-secondary  discount-label"> &#8377;<%=p2.getpPrice()%>
										<br> <%=p2.getpDiscount()%>% OFF
									</span>
								</button>
							</div>


						</div>

						<%
						}
						%>


					</div>

				</div>

			</div>


		</div>

	</div>

	<div class="container-fluid py-4" style="background:#e2e2e2;">
		<hr>
	</div>

	<div class="footer" style="background: #232F3E; color: white;">
		<div class="container text-center py-4">
			<a href=" https://www.facebook.com/virender.negi.180625/"> <img
				src="img/fb.png" width="40px" ; height="40px";>
			</a> <a href="https://www.linkedin.com/in/virender-negi-0610ba19b/ ">
				<img src="img/in.png" width="35px" ; height="33px";>
			</a> <a href=" https://github.com/viren760"></a> <img src="img/git.png"
				width="30px" ; height="30px";> </a> <a
				href=" https://twitter.com/virennnnn_ "> <img
				src="img/twitter.png" width="35px" ; height="35px";>
			</a> <br>
			<h15>Contacted me </h15>
		</div>
		<hr>
		<div class="container text-center">
			<h15>@2021 Copyright | All right Reserved </h15>
			<br>
			<h15>Created by Virender Negi </h15>
		</div>
	</div>

	<%@ include file="components/common_modal.jsp"%>

</body>
</html>