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
public class EditReview extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 ServiceProxy proxy=new ServiceProxy();  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditReview() {
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
			 	String edit = request.getParameter("edit");
			 	String rate = request.getParameter("rate");
			 	if(rate==null){rate="0";}
			 
			 	
			 	String id_No = request.getParameter("id_No");
			 	
			 	proxy.setEndpoint("http://localhost:8080/YelpWebServices/services/Service");
				
			 	qdone = proxy.editReview(email, password, edit, rate, id_No);
				
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


