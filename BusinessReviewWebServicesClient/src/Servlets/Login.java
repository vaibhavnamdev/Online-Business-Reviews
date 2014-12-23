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
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 ServiceProxy proxy=new ServiceProxy();  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
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
        	
    		final String LOGIN = "../View/login.jsp";
    		response.sendRedirect(LOGIN);
        }
		
	}
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");

		String[] qdone;
		 try{			
			 
			 	String email = request.getParameter("email");
			 	String password = request.getParameter("password");
			 
			 	proxy.setEndpoint("http://localhost:8080/YelpWebServices/services/Service");
				
			 	qdone = proxy.login(email, password);
				HttpSession session = request.getSession();
				if(qdone!=null){
					session.setAttribute("userSession", session);
					System.out.println("Logged in Successfully");
					
					int qdoneLenght = qdone.length-1;
					String name = qdone[0]+" "+qdone[1];
					String lastLogin = qdone[qdoneLenght];
					Cookie cookie = new Cookie("session",email+","+password+","+name+","+lastLogin);
					Cookie cookie1 = new Cookie("suggs","Restaurants");
					Cookie cookie2 = new Cookie("category","All");
					Cookie cookie3 = new Cookie("Allhighlight","selected");
					Cookie cookie4 = new Cookie("yourhighlight","no");
					
					response.addCookie(cookie);
					response.addCookie(cookie1);
					response.addCookie(cookie2);
					response.addCookie(cookie3);
					response.addCookie(cookie4);
					
					
				
					request.getRequestDispatcher("successLogin.jsp").forward(request, response);
				}
			
				else{
					final String LOGIN = "../View/login.jsp";
					System.out.println(qdone+" incorrect details");
					response.sendRedirect(LOGIN);
				}
		 }
		 catch (Exception e)
	        {
	            e.printStackTrace();
	        }
	}

}
