

<%
List<Category> categoryList = CategoryDao.listOfAllcategories();
%>
<%@page import="com.learn.ecommercewebsite.entities.User"%>
<%@page import="com.learn.ecommercewebsite.dao.CategoryDao"%>
<%@page import="com.learn.ecommercewebsite.entities.*"%>
<%@page import="java.util.List"%>

<%@page import="java.util.List"%>

<%
User user1 = (User) session.getAttribute("current-user");
%>

<nav class="navbar navbar-expand-lg navbar-dark custom-bg">
	<div class="container">
		<div class="container-fluid">
			<a class="navbar-brand" href="index.jsp">EcommerceWebsite</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="index.jsp">Home</a>
						
									
				<li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown" aria-expanded="false">
            All Categories
          </a>
          <ul class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
            
            <%
				for (Category c : categoryList) {
				%>
	<li><a class="dropdown-item" href="index.jsp?cId=<%=c.getCategoryId()%>"><%=c.getCategoryTitle()%>
				 </a></li>
				<% } %>
            
            
       
          </ul>
        </li>
				</ul>

				<ul class="navbar-nav ml-auto">
					<li class="nav-item active"><a class="nav-link" href="#"
						data-toggle="modal" data-target="#cart"> <i
							class="fa fa-cart-plus " style="font-size: 30px;"><span
								class="ml-0 cart-items" style="font-size: 20px;">( 0 ) </span></i></a> </li>

					<%
					if (user1 == null) {
					%>

					<li class="nav-item active"><a class="nav-link"
						href="login.jsp">login</a></li>
					<li class="nav-item active"><a class="nav-link"
						href="register.jsp">register</a></li>


					<%
					} else {
					%>
					<li class="nav-item active">
					<a class="nav-link" href="<%= user1.getUser_type().equals("admin")?"admin.jsp" : "normal.jsp" %>"><%=user1.getUserName()%></a>
					</li>
					<li class="nav-item active"><a class="nav-link"
						href="LogoutServlet">logout</a></li>


					<%
					}
					%>



				</ul>

			</div>
		</div>
	</div>
</nav>