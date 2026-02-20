package com.jdbcsample;

import java.sql.*;
import java.util.Scanner;


public class JDBCtrial {
	public static void main(String[] args) throws Exception {
		// load the drive
		Scanner sc = new Scanner(System.in);
	
	    // Load Driver
	    Class.forName("com.mysql.cj.jdbc.Driver");
	
	    // Create Connection
	    Connection con = DriverManager.getConnection(
	            "jdbc:mysql://localhost:3306/companydb",
	            "root",
	            "password");
	
	    
	    System.out.println("1. Insert");
	    System.out.println("2. Delete");
	    System.out.println("3. Update");
	    System.out.println("4. Read.");
	    System.out.print("Enter your choice: ");
	
	    int choice = sc.nextInt();
	    
	    int roll;
	    String name;
	
		switch(choice){
			
		case 1:
			
			System.out.println("Enter the RollNo:");
			roll=sc.nextInt();
			sc.nextLine();
			System.out.println("Enter the Name:");
			name=sc.nextLine();
			
			Statement st1=con.createStatement();
			String q1="insert into student values("+roll+",'"+name+"')";
			
			// execute the query
			int a=st1.executeUpdate(q1);
			System.out.println(a+" row inserted");
			// close connection 
			st1.close();
			break;
		
		case 2:
			System.out.println("Enter the RollNo to Delete:");
			int droll=sc.nextInt();
			
			Statement st2 = con.createStatement();
			String q2 = "Delete from student where roll="+droll;
			int b = st2.executeUpdate(q2);
			System.out.println(b+"rows affected");
			st2.close();
			break;			
		
		case 3:
			System.out.println("Enter for \" 1.Name 2.RollNo \" to upate:(press 1 or 2)");
			int decision = sc.nextInt();
			if(decision==1) {
				System.out.println("Enter RollNo to update name:");
				int uproll = sc.nextInt();
				sc.nextLine();
				System.out.println("Enter name to update:");
				String upname = sc.nextLine();
				
				Statement st3 = con.createStatement();
				String q3 = "update student set name='"+upname+"' where rollno="+uproll;
				
				int c = st3.executeUpdate(q3);
				System.out.println(c+"rows affected");
				st3.close();
				
			}else if(decision==2) {
				System.out.println("Enter Name to update RollNo:");
				String upname = sc.nextLine();
				
				System.out.println("Enter name to update:");
				int uproll = sc.nextInt();
				
				
				Statement st3 = con.createStatement();
				String q3 = "update student set rollno="+uproll+"where name='"+upname+"'";
				
				int c = st3.executeUpdate(q3);
				System.out.println(c+"rows affected");
				st3.close();

			}else {
				System.out.println("Invalid entry");
			}
			break;
			
		case 4://Read
			Statement st4 = con.createStatement();
			String q4 = "select * from student";
			ResultSet rs =st4.executeQuery(q4);
			
			
			while(rs.next()) {
				System.out.println(rs.getInt("rollno")+"\t"+rs.getString("name"));
			}
			st4.close();
			rs.close();
			break;
		default:
			System.out.println("Invalid entry..");
			break;			
		
		}
		con.close();
		sc.close();
	}
}