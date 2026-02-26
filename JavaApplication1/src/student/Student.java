package student;

import java.sql.*;

public class Student extends User {

    // Database connection details (Consider moving these to a config file later)
    private final String url = "jdbc:mysql://localhost:3306/EmployeeCRUD";
    private final String user = "root";
    private final String password = "Guru@24748";

    public Student(String name) {
        super(name);
    }

    /**
     * Marks attendance for a specific subject.
     */
    public void markAttendance(String subject, String status) {
        String query = "INSERT INTO Attendance (name, subject, status, date) VALUES (?, ?, ?, CURDATE())";
        
        try (Connection con = DriverManager.getConnection(url, user, password);
             PreparedStatement ps1 = con.prepareStatement(query)) {

            ps1.setString(1, this.getName()); 
            ps1.setString(2, subject);
            ps1.setString(3, status);

            ps1.executeUpdate();
            System.out.println("Attendance inserted successfully.");

        } catch (SQLException e) {
            System.err.println("Error inserting attendance: " + e.getMessage());
        }
    }

    /**
     * Displays all attendance records.
     */
    public void viewAttendance() {
        String query = "SELECT * FROM Attendance WHERE name = ?";

        try (Connection con = DriverManager.getConnection(url, user, password);
             PreparedStatement ps = con.prepareStatement(query)) {
            
            ps.setString(1, this.getName());
            ResultSet rs = ps.executeQuery();

            System.out.println("\n--- Attendance Records for " + this.getName() + " ---");
            System.out.println("ID | Subject | Status | Date");
            
            while (rs.next()) {
                System.out.println(rs.getInt("id") + " | " +
                                   rs.getString("subject") + " | " +
                                   rs.getString("status") + " | " +
                                   rs.getDate("date"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Updates an existing attendance record by ID.
     */
    public void updateAttendance(int id, String newStatus) {
        String query = "UPDATE Attendance SET status = ? WHERE id = ?";

        try (Connection con = DriverManager.getConnection(url, user, password);
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setString(1, newStatus);
            ps.setInt(2, id);
           

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Record ID " + id + " updated to: " + newStatus);
            } else {
                System.out.println("No record found with ID " + id + " for this student.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Generates a summary of total Present vs Absent days.
     */
    public void generateSummary() {
        String query = "SELECT status, COUNT(*) as total FROM Attendance WHERE name = ? GROUP BY status";

        try (Connection con = DriverManager.getConnection(url, user, password);
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setString(1, this.getName());
            ResultSet rs = ps.executeQuery();

            System.out.println("\n--- Attendance Summary for " + this.getName() + " ---");
            while (rs.next()) {
                System.out.println(rs.getString("status") + ": " + rs.getInt("total"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Deletes a specific attendance record by its ID.
     */
    public void deleteRecord(int id) {
        // We include name = ? to ensure a student can't delete someone else's record by guessing IDs
        String query = "DELETE FROM Attendance WHERE id = ?";

        try (Connection con = DriverManager.getConnection(url, user, password);
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setInt(1, id);

            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Success: Attendance record #" + id + " has been deleted.");
            } else {
                System.out.println("Error: Record #" + id + " not found or you do not have permission to delete it.");
            }

        } catch (SQLException e) {
            System.err.println("Database error during deletion: " + e.getMessage());
        }
    }
}