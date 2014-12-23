package connection;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.jws.WebService;

@WebService
public class Service {	
	
	//------------------------SignUpCode-----------------------------------------
	
	public String signUp(String fname,String lname,String email ,String password)
	{

		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy @ HH:mm:ss");
		   //get current date time with Date()
		   Date date = new Date();
		   
		String dateTime="Last Login: "+ dateFormat.format(date);
		String insert = "INSERT INTO `test`.`users` (`Firstname`,`Lastname`,`emailid`,`password`,`lastLogin`) VALUES ('"+fname+"','"+lname+"','"+email+"','"+password+"','"+dateTime+"')";
		DatabaseConnection db=new DatabaseConnection(1,insert);
		System.out.println("Inside Signup");
		String result;		
		result = db.actions(insert);
		
		return result;//this value is returned to the calling servlet
	}	
	
	
	//------------------------LoginCode-----------------------------------------
	
	public String[] login(String email,String password){
		
		System.out.println("Inside Login");
		String[] login_details=null;
		String login = "select * from test.users where emailid ='"+email+"' && password ='"+password+"'";
		try{
			DatabaseConnection db=new DatabaseConnection(2,login);
			login_details = db.login();
		
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			login_details[0]="No such user";
			return login_details;
		}
		return login_details;//this value is returned to the calling servlet
	}
	
	//------------------------LogoutCode-----------------------------------------
	
	public String logout(String email,String password){
		
		String result=null;
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy @ HH:mm:ss");
		   //get current date time with Date()
		   Date date = new Date();
		   
		String dateTime="Last Login: "+ dateFormat.format(date);

		String updateTime= "update test.users SET lastLogin = '"+dateTime+"' where emailid ='"+email+"' && password ='"+password+"'";
		DatabaseConnection db=new DatabaseConnection(1,updateTime);
		result = db.actions(updateTime);
		return result;
	}

	
	//------------------------PostReviewCode-----------------------------------------
	
	public String postReview(String email, String password, String category, String element, String review, String rating, String perform, String description){
		String result = null;
		String insertReview, postInsert;
		if(perform.equalsIgnoreCase("add")){
			
			insertReview = "INSERT INTO `test`.`reviews`(`Time`,`email`,`password`,`category`,`elements`,`Review`,`Rating`,`Like`) VALUES (CURRENT_TIMESTAMP,'"+email+"', '"+password+"','"+category+"','"+element+"','"+review+"', '"+rating+"','0');";
			postInsert = "INSERT INTO `test`.`elements`(`ElementName`,`Category`,`Description`,`Rating`,`ReviewsTotal`) VALUES ('"+element+"','"+category+"','"+description+"','"+rating+"','1');";
		}

		else
		{
			
			insertReview = "INSERT INTO `test`.`reviews`(`Time`,`email`,`password`,`category`,`elements`,`Review`,`Rating`,`Like`) VALUES (CURRENT_TIMESTAMP,'"+email+"', '"+password+"','"+category+"','"+element+"','"+review+"', '"+rating+"','0');";
			postInsert="UPDATE `test`.`elements` SET `ReviewsTotal`=ReviewsTotal+1 WHERE `ElementName`='"+element+"' AND Category ='"+category+"';";
		}
		
		DatabaseConnection db=new DatabaseConnection(1,insertReview);
		result = db.actions(insertReview);
		if(result.equals("true"))
		{
			DatabaseConnection dbpost=new DatabaseConnection(1,postInsert);
			result = dbpost.actions(postInsert);
		}
		
		return result;
	}
	
	
	//------------------------EditReviewCode-----------------------------------------
	
	public String editReview(String email, String password, String edit, String rate, String id_No){
		String result = null;
		if(rate.equalsIgnoreCase("undefined")){rate="0";}
		String updateReview = "update `test`.`reviews` SET `Review` ='"+edit+"', `Rating` ='"+rate+"' WHERE `ReviewId`='"+id_No+"' AND `email` ='"+email+"' AND `password`= '"+password+"';";
		DatabaseConnection db=new DatabaseConnection(1,updateReview);
		result = db.actions(updateReview);
		return result;
	}
	
	
	//------------------------DeleteReviewCode-----------------------------------------
	
	public String deleteReview(String email, String password, String id_NoDel, String elementNameDel, String categoryDel){
		String result = null;
		
		String deleteUpdate = "UPDATE `test`.`elements` SET `ReviewsTotal`=ReviewsTotal-1 WHERE `ElementName`='"+elementNameDel+"' AND Category ='"+categoryDel+"';";
		String deleteQuery="DELETE FROM `test`.`reviews` WHERE `ReviewId` = '"+id_NoDel+"';";
		
		DatabaseConnection db=new DatabaseConnection(1,deleteUpdate);
		result = db.actions(deleteUpdate);
		if(result.equals("true"))
		{
			DatabaseConnection dbpost=new DatabaseConnection(1,deleteQuery);
			result = dbpost.actions(deleteQuery);
		}
		
		return result;
	}
	
	
	//-------------------------Get All Reviews----------------
	
	public Review[] getReviews(String email, String password, String categoryType){
		Review[] reviews=null;
		
		String fetchreviews;
		
		if(categoryType.equals("All"))
		{
			fetchreviews = "select * from `test`.`reviews` order by ReviewId DESC;";
			System.out.println(fetchreviews);
		}
		else if(categoryType.equals("Your")){
			fetchreviews = "select * from `test`.`reviews` WHERE `email` ='"+email+"' AND `password` ='"+password+"' ORDER BY ReviewId DESC;";
			System.out.println(fetchreviews);
		}
		else{
			fetchreviews ="select * from `test`.`reviews` WHERE category ='"+categoryType+"' ORDER BY ReviewId DESC ;";
			System.out.println(fetchreviews);
		}
		
		DatabaseConnection db=new DatabaseConnection(2,fetchreviews);
		try{
			reviews = db.getReviews();
		}
		catch (Exception ex){
			ex.printStackTrace();
		}
		return reviews;
	}
	
	
	//------------------Fetch Category-------------
	public Categories[] getCategories()
	{
		Categories[] category = null;
		String fetchCategory = "SELECT * FROM test.categories;";
		DatabaseConnection db=new DatabaseConnection(2,fetchCategory);
		try{
			
			category = db.getCategories();
			System.out.println("hi");
			System.out.println(category.length);
		}
		catch (Exception ex){
			
			ex.printStackTrace();
		}
		
		return category;
		
	}
	
	//---------------Fetch Element Suggestion-------------------
	public ElementSuggest[] getSuggestion(String suggestionValue)
	{
		ElementSuggest[] elementsuggs = null;
		String fetchsuggestion = "select * from test.elements where Category = '"+suggestionValue+"' order by ReviewsTotal;";
		DatabaseConnection db=new DatabaseConnection(2,fetchsuggestion);
		try{
			elementsuggs = db.getSuggest();
		}
		catch (Exception ex){
			ex.printStackTrace();
		}
		return elementsuggs;
	}
}
	
	
