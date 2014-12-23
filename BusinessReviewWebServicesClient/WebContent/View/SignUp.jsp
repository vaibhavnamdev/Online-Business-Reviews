<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<title>Sign-Up</title>
 <link rel='stylesheet' href='../css/style.css'  type="text/css" />
    <link rel='stylesheet' href='../css/bootstrap.min.css' type="text/css" />
    
    <script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
	<script src="http://code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
    
</head>
<body>


 <%
        Cookie[] cookies = request.getCookies();
        boolean foundCookie = false;

        for(int i = 0; i < cookies.length; i++) { 
            Cookie c = cookies[i];
            if (c.getName().equals("session")) {
                foundCookie = true;
                
            }
        }  

        if (foundCookie) {
        	response.sendRedirect("yourProfile");	
        }
        else
        {
        	
        }
  %> 


<div class="app-header simple-header">
    				<div class="header-container clearfix">
        			<h1 class="logo">
        			<a href="start" action ="GET">Yelp</a>
    				</h1>     		
         			</div>
         		
         		
         		<div class="signup-wrapper ytype">	
         		<div class="embossed-box">
         			<div class="header">
        			<h2>Sign up for Yelp</h2>
            		<p class="subheading">Connect with great local businesses</p>
    				</div>
         				<div>
			        	<form action="SignUp" class="yform signup-form  city-hidden" id="signup-form" method="POST">
			            <input type="hidden">
			             <ul class="inline-layout">
			             <li>
			        	
			       		 <input id="first_name" name="first_name" placeholder="First Name" required="required" type="text" value="">
			   			 </li>
			
			             <li>
			        	
			        	<input id="last_name" name="last_name" placeholder="Last Name" required="required" type="text" value="">
			    		</li>
			
			        	</ul>
			        	
			        	<input id="email" name="email" placeholder="Email" required="required" type="email" value="">
			        	<label class="placeholder-sub">Password</label>
			        	<input id="password" name="password" placeholder="Password" required="required" type="password" value="">
			         	
         		<button id="signup-button" type="submit" value="Sign Up" class="ybtn ybtn-primary ytype disable-on-submit submit signup-button"><span>Sign Up</span></button>
        	</div>
        	</form>
        		<div class="sub-text-box">
                <small class="subtle-text">Already on Yelp? <a href="login">Log in</a></small>
           		 </div>
         		</div>
       
         			
           		 
        			
        			</div>
        			<div class="picture-container">
           		 	<img src="../resourses/signuppic.png">
           
           </div>



</html>