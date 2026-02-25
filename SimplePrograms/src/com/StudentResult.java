package com;

import java.util.Scanner;

class GradeCalculator{
	public void grade(String name,double sub1,double sub2,double sub3){
		
		if(sub1<35 || sub2<35 || sub3<35){
			System.out.println("Failed! ****");
			return;
		}
		
		double percent = ((sub1+sub2+sub3)/300)*100;
		
		if(percent>=90) {
			System.out.printf("%s got A+ with percentage of %.2f",name,percent);
		}else if(percent >=70 && percent<90) {
			System.out.printf("%s got A with percentage of ",name,percent);
		}else if(percent >=50 && percent <70) {
			System.out.printf("%s got B with percentage of %.2f",name,percent);
		}else if(percent >=35 && percent <50) {
			System.out.printf("%s got C with percentage of %.2f",name,percent);
		}else {
			System.out.printf(" %s is fail try better next time",name);
		}
	}
	
}

public class StudentResult {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the student name:");
		String name=sc.nextLine();
		System.out.println("Enter the Subject1 marks:");
		double sub1= sc.nextDouble();
		System.out.println("Enter the subject2 marks:");
		double sub2 = sc.nextDouble();
		System.out.println("Enter the subject3 marks:");
		double sub3 = sc.nextDouble();
		
		GradeCalculator gr = new GradeCalculator();
		
		gr.grade(name, sub1, sub2, sub3);
		
		sc.close();


	}

}
