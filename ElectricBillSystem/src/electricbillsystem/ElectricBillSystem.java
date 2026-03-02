/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package electricbillsystem;

import java.util.Scanner;

/**
 *
 * @author guruv
 */
public class ElectricBillSystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Electric Bill Calculator ===");
        System.out.print("Enter Meter Number: ");
        String meterNumber = sc.nextLine();
        
        System.out.print("Enter Customer Name: ");
        String customerName = sc.nextLine();
        
        System.out.print("Enter Last Month Reading: ");
        double lastReading = sc.nextDouble();
        
        System.out.print("Enter Present Month Reading: ");
        double presentReading = sc.nextDouble();
        
        System.out.print("Enter Category (f/b/h): ");
        char cat = sc.next().toLowerCase().charAt(0);

      
        double units = presentReading - lastReading;
        double rate = 0;

        if (units < 0) {
            System.out.println("Invalid readings: Present month reading is less than last month.");
            return;
        }

        
        switch (cat) {
            case 'f':
                if (units >= 25000) rate = 26.9;
                else if (units >= 23000) rate = 24.5;
                else if (units >= 20000) rate = 22.1;
                else rate = 19.0;
                break;

            case 'b':
                if (units > 10000) rate = 17.9;
                else if (units >= 7000) rate = 15.0;
                else if (units >= 4000) rate = 12.9;
                else rate = 10.9;
                break;

            case 'h':
                if (units > 1000) rate = 12.0;
                else if (units >= 700) rate = 7.9; 
                else if (units >= 400) rate = 4.6;
                else if (units >= 200) rate = 2.1;
                else rate = 1.5;
                break;

            default:
                System.out.println("Invalid category selected.");
                return;
        }

    
        double totalBill = units * rate;

        System.out.println("\n--- Bill Details ---");
        System.out.println("Meter Number: " + meterNumber);
        System.out.println("Customer Name: " + customerName);
        System.out.println("Usage (kWh): " + units);
        System.out.println("Rate (Rs): " + rate);
        System.out.printf("Total Bill Amount: Rs %.2f\n", totalBill);
    }
    
}
