package DBConnection;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class DbConnection {
	public Connection getConnection()
	{
	Connection con = null;
	String user="root";
	String pwd="";
	String url="jdbc:mysql://localhost:3306/lambtong6";
	
	try {
		Class.forName("com.mysql.jdbc.Driver");
		con=(Connection) DriverManager.getConnection(url,user,pwd);
		System.out.println("Connection successful!!!");
	} 
	catch (ClassNotFoundException e) {
		e.printStackTrace();
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return con;
	}
}
