
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> User login - EcommerceWebsite</title>
        <%@ include file="components/common_css_js.jsp"%>    
    </head>
    
    <body style="background:url(img/login.jpg); background-size: cover; ">
        <%@include file="components/navbar.jsp" %>
        <div class="container login">
           <div class="row">
               <div class="col-md-4 offset-md-4">
                   <div class="card mt-3">
                       <div class="card-header custom-bg text-white">
                           <h3>
                               Login Here!!
                           </h3>
                        </div>   
                           <div class="card-body">
                           <%@include file="components/message.jsp" %>
    <form action="LoginServlet" method="post">
  <div class="form-group">
    <label for="Email1">Email address</label>
    <input name="email" type="email" class="form-control" id="Emsil" aria-describedby="emailHelp" placeholder="Enter email" required>
   
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1">Password</label>
    <input name="password" type="password" class="form-control" id="exampleInputPassword1" placeholder="Password" required>
  </div>
        
        <a href="register.jsp" class="text-center d-block mb-3"> if not registerd click here? </a>
      <div class="container text-center">                            
    <button type="submit" class="btn btn-primary custom-bg ">Submit</button>
    <button type="reset" class="btn btn-primary custom-bg ">Reset</button>
      </div>
</form>
                           </div>   
                       </div>
                   </div>   
               </div>   
           </div>   
    </body>
</html>
