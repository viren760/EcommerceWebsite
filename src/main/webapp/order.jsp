<% User user = (User) session.getAttribute("current-user"); %>
<%@page import="com.learn.ecommercewebsite.entities.User,java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>order Placed</title>
</head>
<body>
	<%@ include file="components/common_css_js.jsp"%>
	<%@ include file="components/navbar3.jsp"%>

	<div class="container text-center">
		<img src="img/order.png" width="100px" ; height="100px"
			; alt="order_placed">
		<h1>Order placed Successfully !</h1>
		<h3 style="">Thankyou for your order.</h3>
	</div>
	<hr>
	<div class="container-fluid text-center" style="background:#e2e2e2;">
		<h3>Your order Id #<%= new Random().nextInt(10000)  %></h3>
	</div>
	<div class="container-fluid text-center" style="background:#e2e2e2;">
		<h3>An mail with all detail has been send to <%= user.getUserEmail() %></h3>
	</div>
	<hr>
	<div class="container text-center">
	<img src="img/placed.gif" width="250px"; height="250px";>
	</div>
</body>
</html>