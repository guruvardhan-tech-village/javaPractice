package BankingSystem;

import java.sql.Connection;
import java.sql.DriverManager;

public class BankJDBC {
	public static Connection getConnection() throws Exception{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/customerManagement",
				"root",
				"password");
		return con;
	}

}
