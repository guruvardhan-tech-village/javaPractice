package com.jdbcsample;

import java.sql.*;

public class CarsJDBCapp {

	public void insertCar(int id,String name) throws Exception{
		Connection con = JDBConnectionApp.getConnection();
		
		String q = "insert into cars values(?,?)";
		PreparedStatement ps = con.prepareStatement(q);
		
		ps.setInt(1, id);
		ps.setString(2, name);
		
		int row = ps.executeUpdate(q);
		System.out.println(row+" rows are affected");
		
		ps.close();
		con.close();
	}
	
	public void deleteCars(int id) throws Exception{
		Connection con = JDBConnectionApp.getConnection();
		
		String q = "delete from cars where Id=?";
		PreparedStatement ps = con.prepareStatement(q);
		
		ps.setInt(1,id);
		
		int rows = ps.executeUpdate();
		System.out.println(rows+" rows affected");
		
		ps.close();
		con.close();
	}
	public void updateCars(int id,String name) throws Exception{
		Connection con = JDBConnectionApp.getConnection();
		
		String q = "update students set name=? where id=?";
		PreparedStatement ps = con.prepareStatement(q);
		
		ps.setString(1, name);
		ps.setInt(2, id);
		
		int rows = ps.executeUpdate();
		System.out.println(rows+" rows affected");
		
		ps.close();
		con.close();
		
	}
	public void readCars() throws Exception{
		
		Connection con = JDBConnectionApp.getConnection();
		String q = "select * from cars";
		
		Statement st =con.createStatement();
		ResultSet rs = st.executeQuery(q);
		
		while(rs.next()) {
			System.out.println(rs.getInt("Id")+" "+
					rs.getString("name"));
		}
		rs.close();
		st.close();
		con.close();
	}
	
}
