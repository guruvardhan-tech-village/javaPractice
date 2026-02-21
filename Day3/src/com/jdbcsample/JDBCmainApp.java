package com.jdbcsample;

import java.util.*;


public class JDBCmainApp {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		CarsJDBCapp carData=new CarsJDBCapp();
		Scanner sc = new Scanner(System.in);
        
        System.out.println("1. Insert");
        System.out.println("2. Update");
        System.out.println("3. Delete");
        System.out.println("4. Read");
        System.out.print("Enter choice: ");

        int choice = sc.nextInt();
        sc.nextLine();

        switch (choice) {

            case 1:
                System.out.print("Enter Id: ");
                int id = sc.nextInt();
                sc.nextLine();

                System.out.print("Enter Name: ");
                String name = sc.nextLine();

                carData.insertCar(id, name);
                break;

            case 2:
                System.out.print("Enter Id: ");
                int uid = sc.nextInt();
                sc.nextLine();

                System.out.print("Enter new Name: ");
                String newName = sc.nextLine();

                carData.updateCars(uid, newName);
                break;

            case 3:
                System.out.print("Enter Id: ");
                int did = sc.nextInt();

                carData.deleteCars(did);
                break;

            case 4:
            	carData.readCars();
                break;

            default:
                System.out.println("Invalid choice");
        }

        sc.close();

	}

}
