<%
User user = (User) session.getAttribute("current-user");
if (user == null) {
	session.setAttribute("message", "You are not logged in !! login first to  Access Checkout Page");
	response.sendRedirect("login.jsp");
	return;
}
%>



<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Checkout</title>
<script>
$(document).ready(function(){
  $(":radio");
});
</script>


</head>
<body>
	<%@ include file="components/common_css_js.jsp"%>
	<%@ include file="components/navbar.jsp"%>


	<div class="container">

		<div class="row mt-5 ">
			<!-- cards -->
			<div class="col-md-6">
				<div class="card">
					<div class="card-body">
						<h3 class="text-center mb-3">Your Selected Items</h3>
						<div class="cart-body "></div>

					</div>
				</div>
			</div>
			<!-- form -->
			<div class="col-md-6">
				<div class="card">
					<div class="card-body">
						<h3 class="text-center mb-3">Your Details for Order</h3>
						<form action="">

							<div class="mb-3">
								<label for="exampleInputEmail1" class="form-label">Email
									address</label> <input value=<%=user.getUserEmail()%> type="email"
									class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp"
									placeholder="Enter your Email Address">
								<div id="emailHelp" class="form-text" required>We'll never
									share your email with anyone else.</div>

							</div>

							<div class="mb-3">
								<label for="name" class="form-label">Your Name</label> <input
									type="text" value=<%=user.getUserName()%>
									class="form-control" id="name" aria-describedby="emailHelp"
									placeholder="Enter your name">
								<div id="emailHelp" class="form-text" required>We'll never
									share your name with anyone else.</div>

							</div>


							<div class="mb-3">
								<label for="name" class="form-label">Phone Number</label> <input
									type="number" value=<%=user.getUserPhone()%>
									class="form-control" id="name" aria-describedby="emailHelp"
									placeholder="Enter your name" required>
								<div id="emailHelp" class="form-text">We'll never share
									your Phone Number with anyone else.</div>

							</div>


							<div class="form-floating">
								<label for="floatingTextarea2">Your Shipping Address</label>
								<textarea class="form-control "
									placeholder="Leave a comment here" id="floatingTextarea2"
									style="height: 100px" placeholder="Enter your Address" required="required"><%=user.getUserAddress().trim()%> </textarea>

							</div>

						<form>
							<div class="text-center mt-2">
								<h5 style="background: #2874f0; color: white;">PAYMENT
									METHOD</h5>
								<label>
									<div>
										<input type="radio" class="radiao" name="flexRadioDefault" readonly="" 
											value="on"  /> <img
											src="https://img1a.flixcart.com/linchpin-web/batman-returns/logos/upiLogo6.gif"
											width=30px; ""; height="30px;" ; class="payment">
										<h7>UPI(Phonepe/ Paytym / Googlepay) </h7>

									</div>
									<hr>

									<div>
										<input type="radio" class="radiao" name="flexRadioDefault" readonly="" 
											value="on" /> <img
											src="https://rukminim1.flixcart.com/www/96/96/promos/01/09/2020/a07396d4-0543-4b19-8406-b9fcbf5fd735.png?q=100"
											width="30px" ;  height="30px" ;class="_32J7lJ">

										<h7> Wallet</h7>

										<hr>
									</div>

									<div>
										<input type="radio" class="radiao" name="flexRadioDefault" readonly="" 
											value="on" />


										<h7> Credit card/ Debit card / ATM card</h7>
									</div>
									<hr>
									<div>
										<input type="radio" class="radiao" name="flexRadioDefault" readonly="" 
											value="on" />


										<h7> COD (Cash on delivery)</h7>
									</div>
									<hr>

								</label>
							</div>
						</form>
							<div class="container text-center mt-2">
								<button class="btn btn-outline-success " onclick="goToOrder()">Order
									Now</button>
								<button class="btn btn-outline-primary" onclick="goToLogin()">Continue
									Shopping</button>
							</div>
						</form>

					</div>
				</div>



			</div>
		</div>

	</div>

</body>
</html>