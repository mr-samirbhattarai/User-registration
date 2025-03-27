<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration Form</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
 rel="stylesheet" 
 integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" 
 crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" 
integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" 
crossorigin="anonymous"></script>
 <link rel="stylesheet" href="../css/register.css">
</head>
<body>
	<div class="hero-section">
		<div class="container">
	    <h2>Registration Form</h2>
	    <form action="../RegisterController" method="post">
	        <div class="form-group">
	            <div>
	                <label>First Name:</label>
	                <input type="text" required name="firstname">
	            </div>
	            
	            <div>
	                <label>Last Name:</label>
	                <input type="text" required  name="lastname">
	            </div>
	        </div>
	        	<%
		        	String errorName = request.getParameter("error");
		        	if (errorName != null && errorName.equals("name")){
		        %>
		        		<p> No numbers and Special in firstname and lastname</p>
		        <%
		        	}
		        %>		
	
	        <div class="form-group">
	            <div>
	                <label>Username:</label>
	                <input type="text" required  name="username">
	            </div>
	            <div>
	                <label>Birthday:</label>
	                <input type="date" required name="birthday">
	            </div>
	        </div>
	       		<%
		        	String errorUsername = request.getParameter("error");
		        	if (errorUsername != null && errorUsername.equals("username")){
		        %>
		        		<p> username must contain atleast 6 character</p>
		        <%
		        	}
		        %>	
	        	<%
		        	String errorSpecialUsername = request.getParameter("error");
		        	if (errorSpecialUsername != null && errorSpecialUsername.equals("specialUsername")){
		        %>
		        		<p> No special character in username</p>
		        <%
		        	}
		        %>	
		        <%
		        	String errorBirthday = request.getParameter("error");
		        	if (errorSpecialUsername != null && errorSpecialUsername.equals("birthday")){
		        %>
		        		<p>Invalid Birthday</p>
		        <%
		        	}
		        %>
	
	        <div class="form-group">
	            <div>
	                <label>Gender:</label>
	                <input type="text" required name="gender">
	            </div>
	            <div>
	                <label>Email:</label>
	                <input type="email" required name="email">
	            </div>
	        </div>
	        	
	
	        <div class="form-group">
	            <div>
	                <label>Phone Number:</label>
	                <input required name="phno">
	            </div>
	            <div>
	                <label>Subject:</label>
	                <input type="text" required placeholder="Computing"  name="subject" >
	            </div>
	        </div>
	        	<%
		        	String errorPhno = request.getParameter("error");
		        	if (errorPhno != null && errorPhno.equals("phno")){
		        %>
		        		<p>Invalid phone number! must contain 13 digits followed by +</p>
		        <%
		        	}
		        %>
	
	        <div class="form-group">
	            <div>
	                <label>Password:</label>
	                <input type="password" required name="password">
	            </div>
	            <div>
	                <label>Retype Password:</label>
	                <input type="password" required name="retype-password">
	            </div>
	        </div>
		        
		        <%
		        	String errorPassword = request.getParameter("error");
		        	if (errorPassword != null && errorPassword.equals("password")){
		        %>
		        		<p>include atleast one capital letter, one special character and a number</p>
		        <%
		        	}
		        %>
	        
	        	<%
		        	String errorRetypePassword = request.getParameter("error");
		        	if (errorRetypePassword != null && errorRetypePassword.equals("retypePassword")){
		        %>
		        		<p>Password din't match</p>
		        <%
		        	}
		        %>
		        
		<button type="submit" class="btn btn-success btn-sm">Submit</button>
	    </form>
	</div>
</div>
</body>
</html>
</body>
</html>