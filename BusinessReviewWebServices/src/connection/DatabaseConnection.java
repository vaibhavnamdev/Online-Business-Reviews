package connection;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseConnection {
	
	Connection con = null;
	static ResultSet rs;
    Statement stmt = null;
	PreparedStatement statment=null;
	
	DatabaseConnection(int type, String query){		
				
		try {			
		
//				DataConnectionPool db=new DataConnectionPool();
//				con=db.getConnectionFromPool();
			
				Class.forName("com.mysql.jdbc.Driver").newInstance();
				
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
				
				if(type==1){
				stmt = con.createStatement();
				}
				else if(type==2){
					statment=con.prepareStatement(query);
				}
				
				
				if(!con.isClosed())
					System.out.println("Successfully Connected!!!");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

//---------------------DataBase Actions------------------------------------------	
	public String actions(String query){
		String result = "";
		int rowcount;
		
	

		try {
			rowcount=stmt.executeUpdate(query);
			if(rowcount>0)
			{
				result="true";
				System.out.println("Insert Successful");
			}
			else{
				result="false: The data could not be inserted in the database.";
			}	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	

//---------------------DataBase Login Action------------------------------------------		
	public String[] login(){
		
		 String[] data =null;
			
			 
			ResultSet rs=null;
			 try{
			      
			        rs = statment.executeQuery();
			       
			        if(rs!=null&&rs.first()){ 
			        	 ResultSetMetaData md = rs.getMetaData();  
			             int colcount = md.getColumnCount();  
			        	
			        	rs.last();  
		                int rowcount = rs.getRow();  
		                rs.beforeFirst();  
		                System.out.println(rowcount);
		                data = new String[colcount];
		              
		                while (rs.next())  
		                {  
		             
		                	for (int i=1; i<=colcount; i++)  
		                    {  
		                    	data[i-1] = rs.getString(i);  
		                        System.out.println(data[i-1]);  
		                    }
		                	
		                }
		                
		                System.out.println("Fetched Successful");
			       }
			     
			 } catch (SQLException e){
			        e.printStackTrace();
			       
			    }
	 
		return data;
	}



//-----------------Reviews-----------------------

public Review[] getReviews() throws SQLException{
	List<Review> reviews = new ArrayList<Review>();
	
	
	
	ResultSet rs= statment.executeQuery();
	while(rs.next()){
		
		Review review = new Review();
		review.Time=rs.getString("Time");
		review.email=rs.getString("email");
		review.category=rs.getString("category");
		review.elements=rs.getString("elements");
		review.Review=rs.getString("Review");
		review.Rating=rs.getString("Rating");
		review.ReviewId=rs.getString("ReviewId");
		reviews.add(review);
	}
	
	Review[] reviewsArray= reviews.toArray(new Review[reviews.size()]);
	

	
		return reviewsArray;
	
}


//------------Fetch Category------------
public Categories[] getCategories() throws SQLException{
	List<Categories> categorys = new ArrayList<Categories>();
	
	ResultSet rs= statment.executeQuery();
	while(rs.next()){
		
		Categories category = new Categories();
		category.categoryId=rs.getString("categoryId");
		category.categoryName=rs.getString("categoryName");
		
		categorys.add(category);
	}
	
	Categories[] categoryArray= categorys.toArray(new Categories[categorys.size()]);
	
	return categoryArray;
}


//---------------Fetch Suggestion-----------------
public ElementSuggest[] getSuggest() throws SQLException{
	List<ElementSuggest> elements = new ArrayList<ElementSuggest>();
	ResultSet rs= statment.executeQuery();
	while(rs.next()){
		
		ElementSuggest element = new ElementSuggest();
		
		element.ElementName=rs.getString("ElementName");
		element.Category=rs.getString("Category");
		element.Description=rs.getString("Description");
		element.Rating=rs.getString("Rating");
		element.ReviewsTotal=rs.getString("ReviewsTotal");
		
		elements.add(element);
	}
	
	ElementSuggest[] elementArray= elements.toArray(new ElementSuggest[elements.size()]);
	return elementArray;
}

}
