package Servlets;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import connection.ServiceProxy;

/**
 * Servlet implementation class logout
 */
public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 ServiceProxy proxy=new ServiceProxy();  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Logout() {
        super();
        // TODO Auto-generated constructor stub
    }

	
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		Cookie[] cookies = request.getCookies();
		String[] userDetail=null;
		boolean foundCookie = false;

        for(int i = 0; i < cookies.length; i++) { 
            Cookie c = cookies[i];
            if (c.getName().equals("session")) {
            	String userDetails = c.getValue();
                userDetail = userDetails.split(",");
            	foundCookie = true; 
            }
        }  

        if (foundCookie) {
        	
		String qdone;
		try{		
		String email = userDetail[0];
		String password = userDetail[1];
			
			 	proxy.setEndpoint("http://localhost:8080/YelpWebServices/services/Service");
				
			 	qdone = proxy.logout(email, password);
			
				if(qdone.substring(0,4).equals("true")){
			
			        cookies = request.getCookies();
			        if(cookies != null){
			            for(int i = 0; i < cookies.length; i++){
			                 Cookie cookie = cookies[i];
			                 {
			                     cookie.setMaxAge(0);
			                     response.addCookie(cookie);
			                 }
			             }
			        }
					
					final String START_PAGE = "../View/start.jsp";
					response.sendRedirect(START_PAGE);
				}
			
				else{
					final String SIGNUP_PAGE = "../View/redirect.jsp";
					response.sendRedirect(SIGNUP_PAGE);
				}
		 }
		 catch (Exception e)
	        {
	            e.printStackTrace();
	        }
		 
        }
        else
        {
        	
    		final String SIGNUP_UP = "../View/SignUp.jsp";
    		response.sendRedirect(SIGNUP_UP);
        }
	}
		
	
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		

}
}
