package com;

import java.util.*;

class EmployeeDetails{
	String name;
	int id;
	double salary;
	
	 EmployeeDetails(String name,int id,double salary){
		 this.name=name;
		 this.id=id;
		 this.salary=salary;
	 }
	
	@Override
	public String toString() {
		return "EmployeeDetails [name=" + name + ", id=" + id + ", salary=" + salary + "]";
	}
	
}

public class CollectionProject {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<EmployeeDetails> employeeDetails = new ArrayList<>();
		
		Scanner sc= new Scanner(System.in);
		int id;
		String name;
		double salary;
		int updId;
		int delId;
		while(true) {
			
			 System.out.println("1.Create 2.Read 3.Update 4.Delete 5.Exit");
			 int choice = sc.nextInt();
			 
			 switch (choice) {
			 case 1:
				 sc.nextLine();
				 System.out.println("Enter EmployeeName: ");
				 name =sc.nextLine();
				 
				 System.out.println("Enter ID:");
				 id =sc.nextInt();
				 
				 System.out.println("Enter salary");
				 salary = sc.nextDouble();
				 
				 employeeDetails.add(new EmployeeDetails(name,id,salary));
				 break;
				 
			 case 2:
				 if(!employeeDetails.isEmpty()) {
					 System.out.println("All Details of employees: ");
					 for(EmployeeDetails e: employeeDetails) {
						 System.out.println(e); 
					 }
					 break;
				 }
				 System.out.println("You haven't entered data!");
				 break;
				 
			 case 3:
				 System.out.println("Enter the employee Id you want to update:");
				 updId=sc.nextInt();
				 
				 boolean found =false;
				 
				 for(EmployeeDetails e: employeeDetails) {
					 if(e.id==updId) {
						 System.out.println("Enter the Name");
						 e.name=sc.next();
						 System.out.println("Enter the salary");
						 e.salary = sc.nextDouble();
						 System.out.println("Updted");
						 found=true;
						 break;
					 }
					 
					 if(!found) {
						 System.out.println("Id is not found!");
						 break;
					 }
				 }
			 case 4:
				 System.out.println("Enter the Id you wnat to delete:");
				 delId=sc.nextInt();
				 
				 Iterator<EmployeeDetails> list = employeeDetails.iterator();
				 
				 boolean removed=false;
				 
				 while(list.hasNext()) {
					 if(list.next().id==delId) {
						 list.remove();
						 removed=true;
						 System.out.println("Deleted");
                         break;
					 }
				 }
				 if (!removed) System.out.println("ID not found");
                 break;
			 case 5:
				 System.out.println("Exiting..");
				 sc.close();
				 return;
			 default:
				 System.out.println("Invalid entry!");
				 break; 
			 }
			 
		}
		
	}

}
