package BankingSystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Scanner;

public class BankAdministration {
	
	public void createBankAcc(int custId,String accType) throws SQLException, Exception {
		try(Connection con = BankJDBC.getConnection()){
			String q = "INSERT INTO accounts (Cust_ID,Acc_Type) VALUES(?,?)";
			PreparedStatement ps = con.prepareStatement(q);
			ps.setInt(1, custId);
			ps.setString(2, accType);
			
			int rows = ps.executeUpdate();
			if(rows>0) {
				System.out.println("Account created for customer ID:"+custId);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	public void deleteAcc() {
		
	}
	public void viewTrans(int accNo) throws Exception{
		try(Connection con = BankJDBC.getConnection()){
			String vtrans = "SELECT * from transaction where Acc_No = ?";
			PreparedStatement ps = con.prepareStatement(vtrans);
			ps.setInt(1, accNo);
			
			ResultSet rs = ps.executeQuery();
			
			boolean hasRecords = false;
			
			while(rs.next()) {
				hasRecords = true;
				System.out.printf("-----Transaction Details of Account Number %d-----",accNo);
				System.out.println("\nTransID | AccountNo | TransType | Amount | Date");
				int id = rs.getInt("TransID");
				int accno = rs.getInt("ACC_No");
				String type = rs.getString("TransType");
				double amt = rs.getDouble("Amount");
				Timestamp date = rs.getTimestamp("TransDate");
				
				System.out.printf("\n %-2d | %-5d | %-10s | %-7.2f | %s \n",id,accno,type,amt,date);
				
			}
			if(!hasRecords) {
				System.out.println("Account not found!");
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private boolean adminLogin(String name, String passwd) throws ClassNotFoundException, SQLException {

	    try (Connection con = AdminJDBC.getConnection()) {

	        String query = "SELECT * FROM AdminDetails WHERE Name = ? AND Password = ?";
	        PreparedStatement ps = con.prepareStatement(query);

	        ps.setString(1, name);
	        ps.setString(2, passwd);

	        ResultSet rs = ps.executeQuery();

	        if (rs.next()) {
	            return true;   // Login successful
	        } else {
	            return false;  // Login failed
	        }
	    }
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		BankAdministration admn = new BankAdministration();
		
		System.out.println("Admin Login!");
		System.out.println("Enter the Admin name:");
		String name = sc.nextLine();
		System.out.println("Enter the Password:");
		String pass = sc.nextLine();
		
		boolean loginStatus = admn.adminLogin(name, pass);
		
		while(loginStatus) {
			System.out.println("Login Successful ✅");

	        System.out.println("1. Create Bank Account");
	        System.out.println("2. Delete Account");
	        System.out.println("Choose option:");

	        int choice = sc.nextInt();

	       

	    sc.close();
		}
		
	}

}
