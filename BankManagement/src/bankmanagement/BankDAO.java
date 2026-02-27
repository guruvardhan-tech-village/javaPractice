/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bankmanagement;

/**
 *
 * @author guruv
 */
import java.sql.*;

public class BankDAO {
    public void deposit(double amount, int accNo) {
        try (Connection con = DBConnection.getConnection()) {
            // Update balance in accounts table
            String updateSQL = "UPDATE accounts SET Balance = Balance + ? WHERE Acc_NO = ?";
            PreparedStatement ps = con.prepareStatement(updateSQL);
            ps.setDouble(1, amount);
            ps.setInt(2, accNo);
            
            int count = ps.executeUpdate();
            if (count > 0) {
                recordTransaction(accNo, "Deposit", amount);
                System.out.println("Successfully deposited: " + amount);
            } else {
                System.out.println("Account Number not found.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Withdraw Method
    public void withdraw(double amount, int accNo) {
        try (Connection con = DBConnection.getConnection()) {
            // Check current balance first
            String checkSQL = "SELECT Balance FROM accounts WHERE Acc_NO = ?";
            PreparedStatement psCheck = con.prepareStatement(checkSQL);
            psCheck.setInt(1, accNo);
            ResultSet rs = psCheck.executeQuery();

            if (rs.next()) {
                double currentBalance = rs.getDouble("Balance");
                if (currentBalance >= amount) {
                    // Perform withdrawal
                    String withdrawSQL = "UPDATE accounts SET Balance = Balance - ? WHERE Acc_NO = ?";
                    PreparedStatement psUpdate = con.prepareStatement(withdrawSQL);
                    psUpdate.setDouble(1, amount);
                    psUpdate.setInt(2, accNo);
                    psUpdate.executeUpdate();
                    
                    recordTransaction(accNo, "Withdrawal", amount);
                    System.out.println("Successfully withdrawn: " + amount);
                } else {
                    System.out.println("Insufficient funds!");
                }
            } else {
                System.out.println("Account not found.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // View Account Details
    public void viewAccount(int accNo) {
        try (Connection con = DBConnection.getConnection()) {
            String query = "SELECT c.name, a.Acc_Type, a.Balance FROM customers c " +
                           "JOIN accounts a ON c.CustID = a.Cust_ID WHERE a.Acc_NO = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, accNo);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                System.out.println("\n--- Account Details ---");
                System.out.println("Owner: " + rs.getString("name"));
                System.out.println("Type: " + rs.getString("Acc_Type"));
                System.out.println("Balance: Rs." + rs.getDouble("Balance"));
            } else {
                System.out.println("Account details not found.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    

    // Helper method to log transactions
    private void recordTransaction(int accNo, String type, double amount) throws Exception {
        Connection con = DBConnection.getConnection();
        String sql = "INSERT INTO Transactions(ACC_No, TransType, Amount) VALUES (?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, accNo);
        ps.setString(2, type);
        ps.setDouble(3, amount);
        ps.executeUpdate();
    }
    
}
