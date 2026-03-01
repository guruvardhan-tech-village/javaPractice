package BankingSystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BankAdministration {
	
	private void createBankAcc(int custId,String accType) throws SQLException, Exception {
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

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Admin Login!");
		
	}

}
