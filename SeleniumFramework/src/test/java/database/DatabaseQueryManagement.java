package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.training.constants.Constants;
import com.training.testcases.BaseTest;

/*
 * Reference :- https://www.youtube.com/watch?v=CjNqKlTluxc
 * 
 */

public class DatabaseQueryManagement  {
	Statement stmt = null;
	
	public DatabaseQueryManagement connectToDB() throws ClassNotFoundException, SQLException {
		
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("JDBC Driver Loaded :");
			Connection con = DriverManager.getConnection(Constants.DBCONSTRING,Constants.DBUID,Constants.DBPWD);
			System.out.println("Connected to MYSQL DB");
			stmt = con.createStatement();
//			dbMgmt.connectToDB().executeQuery();
			return this;
			
	}
	
	
	public DatabaseQueryManagement executeQuery() throws SQLException {
		
		ResultSet rs = stmt.executeQuery("select * from CustomerInfo where purchasedDate=CURDATE() and Location ='Asia';");
		while (rs.next()) {
			System.out.println(rs.getString("CourseName"));
		}
		
		return this;
		//
		
	}
}
