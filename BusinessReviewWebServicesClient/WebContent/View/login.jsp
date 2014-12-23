<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">

<title>Yelp-Login</title>

<link rel='stylesheet' href='../css/style.css'  type="text/css" />
 <link rel='stylesheet' href='../css/bootstrap.min.css' type="text/css" />
 
 <script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
	<script src="http://code.jquery.com/jquery-migrate-1.2.1.min.js"></script>

</head>

 <body class="body">
 
  
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
 
  
<div class="wrap">
  			<div class="app-header simple-header">
    		<div class="header-container clearfix">
        			<h1 class="logo">
        			<a href="start" 5>Yelp</a>
    				</h1>     		
         		</div>
         	</div>
        
        <span id="page-content" class="offscreen">&nbsp;</span>
        
			<div class="super-container">
				<div id="alert-container">
    			</div>	
			
				<div class="login" id="gateway">
					<div class="clearfix layout-block layout-h layout-border login-block">
					
					<div class="column column-alpha ">
						
						<form action="login" class="login-form" method="POST" name="login_form">
							<br>
							<h2>Log In</h2>
							<p>
	                    	Please enter your email address and password to log in.
	                		</p>
	                		
	                		<p>
                    		<label>Email Address</label>
                    		<input type="hidden" name="context" value="">
                    		<input tabindex="1" type="email" maxlength="64" size="20" class="input1" name="email" value="">
                			</p>
	                		
	                		<p>
                    		<label>Password</label>
                    		<input tabindex="2" autocomplete="off" type="password" size="20" class="input1" name="password">
                			</p>
	                		<br>
	                		<br>
	                		
	                		<p style="margin: 10px 0 20px; text-align: right;">
                    		<button name="action_submit" tabindex="3" type="submit" value="Log In" class="ybtn ybtn-small"><span>Log In</span></button>
                			</p>
                
						</form>	
					</div>
					
						<div class="column column-beta ">
            			<div class="login-to-signup"><br>
                		<h2>No Account Yet?</h2>
                		<p>That's okay, we still love you.</p>
                		<p>
                		<a href="SignUp.jsp" class="ybtn ybtn-primary">Sign Up</a>
                		</p>
                		<p>Yelp is the fun and easy way to find, review and talk about what's great - and not so great - in your local area. It's about real people giving their honest and personal opinions on everything from restaurants and spas to coffee shops and bars.</p>
            			</div>

						</div>
					
					</div>
				</div>	
			
			</div>        


        
         			
  </div>
  </body>

</html>