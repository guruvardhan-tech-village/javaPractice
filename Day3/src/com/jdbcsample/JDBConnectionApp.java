package com.jdbcsample;

import java.sql.*;

public class JDBConnectionApp {

	public static Connection getConnection() throws Exception {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/companydb",
                "root",
                "Guru@24748");

		return con;
	}

}
