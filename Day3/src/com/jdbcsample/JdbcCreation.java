package com.jdbcsample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcCreation {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		// to connect JDBC load the drivers
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//Create the connection.
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/companydb","root","Guru@24748");
		Statement st = con.createStatement();
		String q="insert into Cars values(3,'BYD'),(4,'Maserati')";
		int a = st.executeUpdate(q);
		System.out.println(a);
		st.execute(q);
		st.close();
		con.close();
		
	}

}
