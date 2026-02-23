package com;

import java.util.Scanner;

public class EmployeeMain {
    public static void main(String[] args) {
        EmployeeFunction empFunc = new EmployeeFunction();
        Scanner sc = new Scanner(System.in);

        System.out.println("1. Insert");
        System.out.println("2. Update");
        System.out.println("3. Delete");
        System.out.println("4. Read");
        System.out.print("Enter choice: ");

        int choice = sc.nextInt();
        sc.nextLine();

        switch (choice) {

            case 1: {
                System.out.print("Enter Id: ");
                int id = sc.nextInt();
                sc.nextLine();
                System.out.print("Enter Name: ");
                String name = sc.nextLine();
                System.out.println("Enter the Department name:");
                String dept = sc.nextLine();
                System.out.println("Enter the salary:");
                double salary = sc.nextDouble();

                empFunc.insertEmp(id, name, dept, salary);
            }
            break;

            case 2: {
                System.out.print("Enter Id: ");
                int uid = sc.nextInt();
                sc.nextLine();

                System.out.print("Enter new Name: ");
                String newName = sc.nextLine();

                empFunc.updateEmp(uid, newName);
            }
            break;

            case 3: {
                System.out.print("Enter Id: ");
                int did = sc.nextInt();

                empFunc.deleteEmp(did);
            }
            break;

            case 4:
                empFunc.readEmp();
                break;

            default:
                System.out.println("Invalid choice");
        }

        sc.close();
    }
}
