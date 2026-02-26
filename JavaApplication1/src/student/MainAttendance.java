/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package student;

/**
 *
 * @author guruv
 * 
 * 
 */
import java.util.*;

public class MainAttendance {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Welcome to the Student Attendance System ===");
        System.out.print("Enter Student Name: ");
        String studentName = sc.nextLine();

        // Create the student object
        Student student = new Student(studentName);

        boolean exit = false;
        while (!exit) {
            System.out.println("\n--- MENU for " + student.getName() + " ---");
            System.out.println("1. Mark Attendance");
            System.out.println("2. View All Attendance");
            System.out.println("3. Update Attendance Record");
            System.out.println("4. Delete Attendance Record");
            System.out.println("5. View Summary (Stats)");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Subject: ");
                    String subject = sc.nextLine();
                    System.out.print("Enter Status (Present/Absent): ");
                    String status = sc.nextLine();
                    student.markAttendance(subject, status);
                    break;

                case 2:
                    student.viewAttendance();
                    break;

                case 3:
                    System.out.print("Enter Record ID to update: ");
                    int updateId = sc.nextInt();
                    sc.nextLine(); // Consume newline
                    System.out.print("Enter New Status (Present/Absent): ");
                    String newStatus = sc.nextLine();
                    student.updateAttendance(updateId, newStatus);
                    break;

                case 4:
                    System.out.print("Enter Record ID to delete: ");
                    int deleteId = sc.nextInt();
                    student.deleteRecord(deleteId);
                    break;

                case 5:
                    student.generateSummary();
                    break;

                case 6:
                    exit = true;
                    System.out.println("Exiting system... Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        sc.close();
    }
}
