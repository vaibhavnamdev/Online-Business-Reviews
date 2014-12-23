package Servlets;

import java.io.IOException;



import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import connection.ServiceProxy;

/**
 * Servlet implementation class SignUp
 */
public class SignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 ServiceProxy proxy=new ServiceProxy();  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUp() {
        super();
        // TODO Auto-generated constructor stub
    }

	
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		Cookie[] cookies = request.getCookies();
        boolean foundCookie = false;

        for(int i = 0; i < cookies.length; i++) { 
            Cookie c = cookies[i];
            if (c.getName().equals("session")) {
                foundCookie = true; 
            }
        }  

        if (foundCookie) {
        	final String USER_PAGE = "yourProfile";
    		response.sendRedirect(USER_PAGE);
        }
        else
        {
        	
    		final String SIGNUP_UP = "../View/SignUp.jsp";
    		response.sendRedirect(SIGNUP_UP);
        }
		
	}
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");

		String qdone;
		 try{			
			 	String fname = request.getParameter("first_name");
			 	String lname = request.getParameter("last_name");
			 	String email = request.getParameter("email");
			 	String password = request.getParameter("password");
			 
			 	proxy.setEndpoint("http://localhost:8080/YelpWebServices/services/Service");
				
			 	qdone = proxy.signUp(fname,lname,email,password);
				HttpSession session = request.getSession();
				if(qdone.substring(0,4).equals("true")){
					session.setAttribute("userSession", session);
					String name = fname+" "+lname;
					Cookie cookie = new Cookie("session",email+","+password+","+name+",First Time User");
					Cookie cookie1 = new Cookie("suggs","Restaurants");
					Cookie cookie2 = new Cookie("category","All");
					Cookie cookie3 = new Cookie("Allhighlight","selected");
					Cookie cookie4 = new Cookie("yourhighlight","no");
					
					response.addCookie(cookie);
					response.addCookie(cookie1);
					response.addCookie(cookie2);
					response.addCookie(cookie3);
					response.addCookie(cookie4);
					final String User_Page = "../View/successLogin.jsp";
					response.sendRedirect(User_Page);
				}
			
				else{
					final String SIGNUP_PAGE = "../View/SignUp.jsp";
					response.sendRedirect(SIGNUP_PAGE);
				}
		 }
		 catch (Exception e)
	        {
	            e.printStackTrace();
	        }
	}

}
