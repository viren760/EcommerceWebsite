
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>New User</title>
          <%@include file ="components/common_css_js.jsp" %>
    </head>
   <body style="background:url(img/register.jpg); background-size: cover; ">
        <%@include file="components/navbar.jsp" %>
       <div class="container-fluid register">
           <div class="row mt-5" >
            <div class="col-md-4 offset-md-4">
                <div class="card">
                    <%@include file="components/message.jsp" %>  
            <div class="card-body px-5">
                <form action="RegisterServlet" method="post">
           <div class="container text-center">
                   
							<img   class="img-fluid "
								src="img/profile.png" width="80px"; height="80px"; alt="user_icon">
					 
              </div>   
                 <h3 class="text-center my-3"> Signup Here !!</h3>
                    <div class="form-group">
                         <label for="name" >User Name</label>
                         <input name="user_name" type="text" class="form-control" id="name" placeholder="enter here"  aria-describedby="emailHelp" required>
                        
                    </div>
                    <div class="form-group">
                         <label for="Emai1" > User Email</label>
                         <input name="user_email" type="email" class="form-control" id="email" placeholder="enter here"  aria-describedby="emailHelp" required>
                        
                    </div>   
                
                    <div class="form-group">
                         <label for="password" >User Password</label>
                         <input name="user_password" type="password" class="form-control" id="password" placeholder="enter here"  aria-describedby="emailHelp" required>
                        
                    </div>  
                
                    <div class="form-group">
                         <label for="phone" >User phone</label>
                         <input name="user_phone" type="number" class="form-control" id="phone" placeholder="enter here"  aria-describedby="emailHelp" required>
                        
                    </div>   
                    <div class="form-group">
                         <label for="address" >User Address</label>
                         <textarea name="user_address" style="height:150px;" class="form-control" placeholder="enter address"  required>
                         </textarea>
                        
                    </div>   
                    
                    <div class="container text-center">
                        <button class="btn btn-outline-success"> Register</button>
                        <button class="btn btn-outline-warning"> Reset</button>
                    </div>
            </div>    
        </div>   
                </form> 
                
            </div>   
        </div>

       </div>   
                  
    </body>
</html>
