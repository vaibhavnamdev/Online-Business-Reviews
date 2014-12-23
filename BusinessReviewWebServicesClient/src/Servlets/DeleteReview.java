package Servlets;

import java.io.IOException;





import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import connection.ServiceProxy;

/**
 * Servlet implementation class SignUp
 */
public class DeleteReview extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 ServiceProxy proxy=new ServiceProxy();  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteReview() {
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
        	
    		final String SIGNUP_UP = "../View/login.jsp";
    		response.sendRedirect(SIGNUP_UP);
        }
		
	}
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
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
            String email = userDetail[0];
            String password = userDetail[1];
    		
		String qdone;
		 try{			
			 	String id_NoDel = request.getParameter("id_NoDel");
			 	String elementNameDel = request.getParameter("elementNameDel");
			 	String categoryDel = request.getParameter("categoryDel");
			 	
			 	proxy.setEndpoint("http://localhost:8080/YelpWebServices/services/Service");
				
			 	qdone = proxy.deleteReview(email, password, id_NoDel, elementNameDel, categoryDel);
				
				if(qdone.equals("true")){
					
					response.sendRedirect("yourProfile");
				}
				
			
				else{
					final String Profile_PAGE = "../View/profile.jsp";
					response.sendRedirect(Profile_PAGE);
				}
		 }
		 catch (Exception e)
	        {
	            e.printStackTrace();
	        }
	}

	}

