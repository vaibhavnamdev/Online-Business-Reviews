package Servlets;

import java.io.IOException;






import java.net.URLDecoder;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;







import connection.Categories;
import connection.ElementSuggest;
import connection.Review;
import connection.ServiceProxy;

/**
 * Servlet implementation class Login
 */
public class User_Profile extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 ServiceProxy proxy=new ServiceProxy();  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public User_Profile() {
        super();
        // TODO Auto-generated constructor stub
    }

	
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		Cookie[] cookies = request.getCookies();
		String[] userDetail=null;
			
		 String suggest=null;//suggs cookies value
         String allhigh=null;//Allhighlight Cookie value
         String yourhigh=null;//yourhighlight Cookie value
		 String categoryType=null;
		boolean foundCookie = false;

        for(int i = 0; i < cookies.length; i++) { 
            Cookie c = cookies[i];
            if (c.getName().equals("session")) {
            	String userDetails = c.getValue();
                userDetail = userDetails.split(",");
            	foundCookie = true; 
            }
            else if(c.getName().equals("suggs")){
            	String suggsDetails =c.getValue();
            	suggest=URLDecoder.decode(suggsDetails, "UTF-8");
            	System.out.println(suggest);
            }
            else if(c.getName().equals("Allhighlight")){
            	String allhighDetails = c.getValue();
            	allhigh=allhighDetails;
            }
            else if(c.getName().equals("yourhighlight")){
            	String yourhighDetails = c.getValue();
            	yourhigh=yourhighDetails;
            }
            else if(c.getName().equals("category")){
            	String catorytype=c.getValue();
            	categoryType=URLDecoder.decode(catorytype, "UTF-8");
            	
            }
        }  
     
//------------ Logged in users------------------------
        if (foundCookie) {	
        String email = userDetail[0];
        String password = userDetail[1];
		String name = userDetail[2];
		String lastLogin = userDetail[3];
		
		request.setAttribute("user", name);
		request.setAttribute("email", email);
		request.setAttribute("suggest", suggest);
		request.setAttribute("allhigh", allhigh);
		request.setAttribute("yourhigh", yourhigh);
		request.setAttribute("lastLogin", lastLogin);
		request.setAttribute("categoryType", categoryType);
       
        
		 //--------------Fetch All Details------
        Categories[] category=null;
        ElementSuggest[] suggestion=null;
        Review[] review=null;
		 try{	
			
			 proxy.setEndpoint("http://localhost:8080/YelpWebServices/services/Service");
			 review = proxy.getReviews(email, password, categoryType);
			 category=proxy.getCategories();
			 suggestion=proxy.getSuggestion(suggest);
			
		 }
		 catch(Exception ex){
			 ex.printStackTrace();
		 }
        
		 //-------Bind up all data and Send to profile page--------------------
		 
		 
		 request.setAttribute("review", review);
		 request.setAttribute("category", category);
		 request.setAttribute("suggestion", suggestion);
		 
		 
		 request.getRequestDispatcher("profile.jsp").forward(request, response);
		 
		 
     }
    
        
        
        //----Not Logged in-------------------------------   
        
		else{
			final String LOGIN = "../View/login.jsp";
			response.sendRedirect(LOGIN);
		}    
		
	}
	
	
	
	
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

}
}
