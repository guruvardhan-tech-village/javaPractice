package BankingSystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class BankDAO1 {
	public void createCustomer(String name,String mail,String pass) throws Exception {
		
		String q1= "INSERT INTO customers(name,email,password) values(?,?,?)";
		
		try(Connection con = BankJDBC.getConnection()){
			
			PreparedStatement ps1 =con.prepareStatement(q1);
			ps1.setString(1, name);
			ps1.setString(2, mail);
			ps1.setString(3, pass);
			
			int rows = ps1.executeUpdate();
			if (rows > 0) {
				try (ResultSet rs = ps1.getGeneratedKeys()) {
	                if (rs.next()) {
	                    // 3. Get the ID from the first column of the result set
	                    int generatedId = rs.getInt(1);
	                    System.out.println("Customer created successfully! Your Customer ID is: " + generatedId);
	                }
	            }
		
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void debitAmount(int accNo,double amount) throws SQLException, Exception {
		
		try(Connection con = BankJDBC.getConnection()){
			String amountCheck= "SELECT balance FROM accounts where Acc_NO=?";
			PreparedStatement ps2 =con.prepareStatement(amountCheck);
			ps2.setInt(1, accNo);
			
			ResultSet rs = ps2.executeQuery();
			if(rs.next()) {
				double currentBalance = rs.getDouble("Balance");
				if(currentBalance>=amount) {
					String debitQuery = "UPDATE TABLE accounts set Balance =Balance-? where Acc_NO=?";
					PreparedStatement ps3 = con.prepareStatement(debitQuery);
					ps3.setDouble(1, amount);
					ps3.setInt(2, accNo);
					
					transactionInfo(accNo,"Withdrawl",amount);
					
					System.out.println("Successfully amount Withdrawn:"+amount);
				}else {
					System.out.println("Insufficient Balance");
				}
			}else {
				System.out.println("Account not found!");
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void creditAmount(int accNo,double amount) throws Exception{
		try(Connection con = BankJDBC.getConnection()){
			String creditQuery = "UPDATE accounts set Balance = Balance + ? where Acc_No=?";
			PreparedStatement ps4 = con.prepareStatement(creditQuery);
			ps4.setDouble(1, amount);
			ps4.setInt(2, accNo);
			
			int count = ps4.executeUpdate();
			if(count>0) {
				transactionInfo(accNo,"Credit",amount);
				System.out.println("Amount credited");
			}else {
				System.out.println("Account number not found");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void viewAccount(int accNo) throws Exception{
		try(Connection con = BankJDBC.getConnection()){
			String viewQuery="SELECT c.name, a.Acc_Type, a.Balance from customers c"+ 
							  "JOIN accounts a ON c.Cust_ID = a.Cust_ID where Acc_NO = ?";
			PreparedStatement ps5 = con.prepareStatement(viewQuery);
			ps5.setInt(1, accNo);
			
			ResultSet rs = ps5.executeQuery();
			
			if(rs.next()) {
				System.out.println("\n----Account Details----\n");
				System.out.println("AccountHolder: "+rs.getString("name"));
				System.out.println("Account Type: "+rs.getString("Acc_Type"));
				System.out.println("Balance: "+rs.getDouble("Balance"));
			}else {
				System.out.println("Account not Found!");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private void transactionInfo(int accNo,String transtype,double amount) throws SQLException, Exception {
		
		Connection con = BankJDBC.getConnection();
		String transQuery = "INSERT INTO transactions (Acc_No,TransType,Amount) VALUES(?,?,?)";
		PreparedStatement ps6 = con.prepareStatement(transQuery);
		ps6.setInt(1, accNo);
		ps6.setString(2, transtype);
		ps6.setDouble(3, amount);
		ps6.executeUpdate();
		
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

}
