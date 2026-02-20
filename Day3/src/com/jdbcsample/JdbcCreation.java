package com.jdbcsample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcCreation {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		// to connect JDBC load the drivers
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//Create the connection.
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/companydb","root","password");
		Statement st = con.createStatement();
		
		String q="select * from cars";
		
		ResultSet rs = st.executeQuery(q);
		while(rs.next()) {
			int id = rs.getInt("Id");
			String name = rs.getString("name");
			
			System.out.println(id+ " "+name);
		}
		
		
//		int a = st.executeUpdate(q);
//		System.out.println(a);
		st.close();
		con.close();
		
	}

}
