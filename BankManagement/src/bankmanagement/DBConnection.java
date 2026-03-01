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

public class DBConnection {
    public static Connection getConnection() throws Exception{
        
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/CustomerManagement",
                "root",
                "Guru@24748");
        return con;
    }
    
}
