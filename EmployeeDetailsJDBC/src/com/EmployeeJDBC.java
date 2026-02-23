package com;

import java.sql.*;

public class EmployeeJDBC {
    public Connection getConnection() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/companydb","root","Guru@24748");
        return con;
    }
}
