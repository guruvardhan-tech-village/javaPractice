package com;

import java.sql.*;

public class EmployeeFunction {
    public void insertEmp(int id, String name, String department, double salary) {
        String sql = "INSERT INTO employees (id, name, department, salary) VALUES (?, ?, ?, ?)";
        try (Connection con = EmployeeJDBC.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setString(3, department);
            ps.setDouble(4, salary);
            int rows = ps.executeUpdate();
            System.out.println(rows + " row(s) inserted.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteEmp(int id) {
        String sql = "DELETE FROM employees WHERE id = ?";
        try (Connection con = EmployeeJDBC.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            int rows = ps.executeUpdate();
            System.out.println(rows + " row(s) deleted.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void readEmp() {
        String sql = "SELECT id, name, department, salary FROM employees";
        boolean hasData = false;
        try (Connection con = EmployeeJDBC.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String dept = rs.getString("department");
                double salary = rs.getDouble("salary");
                System.out.println(new Employee(id, name, dept, salary));
            }
            if(!hasData){
                System.out.println("No data inserted!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateEmp(int id, String newName) {
        String sql = "UPDATE employees SET name = ? WHERE id = ?";
        try (Connection con = EmployeeJDBC.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, newName);
            ps.setInt(2, id);
            int rows = ps.executeUpdate();
            System.out.println(rows + " row(s) updated.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
