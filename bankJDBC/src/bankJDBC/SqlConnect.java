package bankJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SqlConnect {
	
	String forName;
	String getConnection;
	String user;
	String pass;
	
	public SqlConnect(String forName, String getConnection, String user,
			String pass) {
		super();
		this.forName = forName;
		this.getConnection = getConnection;
		this.user = user;
		this.pass = pass;
	}
	
	public Connection connect(){
	System.out.println("-------- PostgreSQL "+ "JDBC Connection Testing ------------");
	try 
	{

		Class.forName(forName);

	} catch (ClassNotFoundException e) {

		System.out.println("Where is your PostgreSQL JDBC Driver? "
				+ "Include in your library path!");
		e.printStackTrace();
		

	}
	
	Connection connection = null;
	try{
		connection = DriverManager.getConnection(getConnection,user, pass);
			if (connection != null) {
				System.out.println("You made it, take control your database now!");
			} else {
				System.out.println("Failed to make connection!");
			}
	}catch(SQLException e){
		System.out.println("Connection Failed! Check output console");
		e.printStackTrace();
	}
	
	return connection;
	}
	
	

}
