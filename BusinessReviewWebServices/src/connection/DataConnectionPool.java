package connection;

import java.sql.*;
import java.util.Vector;

import com.mysql.jdbc.Connection;

public class DataConnectionPool {

	String databaseUrl = "jdbc:mysql://localhost:3306/test";
	 String userName = "root";
	 String password = "root";
	
	 Vector connectionPool = new Vector();
	 
	 public DataConnectionPool()
	 {
	  initialize();
	 }

	private void initialize() {
		// TODO Auto-generated method stub
		initializeConnectionPool();
	}
	 
	private void initializeConnectionPool()
	 {
	  while(!isPoolFull())
	  {
	   System.out.println("Connection Pool is NOT full. Proceeding with adding new connections");
	   //Adding new connection instance until the pool is full
	   connectionPool.addElement(createConnPool());
	  }
	  System.out.println("Connection Pool is full.");
	 }
	 
	//checking of connection pool full
	
	private synchronized boolean isPoolFull()
	 {
	 

	  //Check if the pool size
	  if(connectionPool.size() < 100)
	  {
	   return false;
	  }

	  return true;
	 }

	 
	 //Creating a connection
	 private Connection createConnPool()
	 {
	  Connection connection = null;

	  try
	  {
	   Class.forName("com.mysql.jdbc.Driver");
	   connection = (Connection) DriverManager.getConnection(databaseUrl, userName, password);
	   System.out.println("Connection: "+connection);
	  }
	  catch(SQLException sqle)
	  {
	   System.err.println("SQLException: "+sqle);
	   return null;
	  }
	  catch(ClassNotFoundException ex)
	  {
	   System.err.println("ClassNotFoundException: "+ex);
	   return null;
	  }

	  return connection;
	 }

	 public synchronized Connection getConnectionFromPool()
	 {
	  Connection connection = null;

	  //Check if there is a connection available. There are times when all the connections in the pool may be used up
	  if(connectionPool.size() > 0)
	  {
	   connection = (Connection) connectionPool.firstElement();
	   connectionPool.removeElementAt(0);
	  }
	  //Giving away the connection from the connection pool
	  return connection;
	 }
	 
	// return connection to Pool...
	 public synchronized void returnConnectionToPool(Connection connection)
	 {
	  //Adding the connection from the client back to the connection pool
	  connectionPool.addElement(connection);
	 }

	 
	 //initialize connection and everyone can use get connecton and return connection 
	
}
