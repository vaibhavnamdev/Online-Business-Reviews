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
public class PostReview extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 ServiceProxy proxy=new ServiceProxy();  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostReview() {
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
		String perform=null;
		boolean foundCookie = false;

        for(int i = 0; i < cookies.length; i++) { 
            Cookie c = cookies[i];
            if (c.getName().equals("session")) {
            	String userDetails = c.getValue();
                userDetail = userDetails.split(",");
            	foundCookie = true; 
            }
            else if(c.getName().equals("action")){
            	String actionDetails =c.getValue();
            	perform=actionDetails;
            	
            }
        }
            String email = userDetail[0];
            String password = userDetail[1];
    		
		String qdone;
		 try{	
			 String element ;
			 	String category = request.getParameter("categories");
			 	
			 	String review = request.getParameter("reviewMatter");
			 	String rating = request.getParameter("rate");
			 	String description = request.getParameter("description");
			 	if(rating==null){rating="0";}
			 	
			 	if(perform.equalsIgnoreCase("add")){
			 		element	= request.getParameter("newElement");
					
				}

				else
				{
					
					element	= request.getParameter("element");
				}
			 	
			 	
			 	proxy.setEndpoint("http://localhost:8080/YelpWebServices/services/Service");
				
			 	qdone = proxy.postReview(email, password, category, element, review, rating, perform, description);
				
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


