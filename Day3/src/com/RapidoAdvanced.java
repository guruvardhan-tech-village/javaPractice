package com;

import java.util.Scanner;

abstract class Vehicles{
	abstract double ratePerKm();
	
	public void fareInfo(double distance) {
		double fare = distance * ratePerKm();
		System.out.printf("Tha rate for %.2fKm is: %.2f",distance,fare);
	}
}

class Bikes extends Vehicles{
	double ratePerKm() {
		return 5;
	}
	public void show(double distance) {
		super.fareInfo(distance);
	}
}
class Carx extends Vehicles{
	double ratePerKm() {
		return 10;
	}
	public void show(double distance) {
		super.fareInfo(distance);
	}
}

public class RapidoAdvanced {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Scanner sc = new Scanner(System.in);
		
		int vehicle;
		double dist;
		int decision;
		
		Bikes obj1 = new Bikes();
		Carx obj2 = new Carx();
		
		boolean exit = false;
		while(!exit) {
			System.out.println("Enter the Vehicle you want to Travel: 1.Car 2.Bike 3.Exit:");
			vehicle = sc.nextInt();
			
			if(vehicle==3) {
				System.out.println("Exiting.... Thank you for using our service!");
				break;
			}
			
			System.out.println("Enter the distance:");
			dist = sc.nextDouble();
			
			switch (vehicle) {
			case 1:
				System.out.println("For Cars we put 10.Rs/km proceed? 1.Ok 2.No ");
				decision=sc.nextInt();
				if(decision==1) {
					obj2.show(dist);
				}
				break;
				
			case 2:
				System.out.println("For Bikes we put 5.Rs/km proceed? 1.Ok 2.No ");
				decision=sc.nextInt();
				if(decision==1) {
					obj1.show(dist);
				}
				break;
				
			default:
				System.out.println("Invalid entry..");
				break;
			}
			
		}
		sc.close();

	}

}
