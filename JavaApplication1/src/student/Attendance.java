/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package student;

import java.util.Scanner;
import java.sql.*;

/**
 *
 * @author guruv
 */
public class Attendance {
    public static void main(String[] args) throws Exception {
        
        Student s1 = new Student("Jack");
        s1.markAttendance("Java Programming","Present");
        s1.viewAttendance();
        s1.updateAttendance(3,"Absent");
        s1.generateSummary();
    }
    
}
