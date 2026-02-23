package com;

import java.sql.*;

public class EmployeeFunction {
    public void insertEmp(int id,String name,String department,double salary) throws Exception{
        try () {
            Connection con = EmployeeJDBC.getConnection();
            Statement st = con.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void deleteEmp(int id){

    }
    public void readEmp(){

    }
    public void updateEmp(){}
}
