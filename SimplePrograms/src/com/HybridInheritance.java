package com;

class Vehicle{
	public void vehicle() {
		System.out.println("This is Vehicle (super Parent class)");
		System.out.println("It has Car,Bus,Bike etc..");
	}
}

interface Bus{
	default void bus() {
		System.out.println("This is Class Bus");
	}
}

interface Carz{
	void car();
}

class Fourwheel extends Vehicle implements Bus,Carz{

	@Override
	public void car() {
		// TODO Auto-generated method stub
		System.out.println("This is Forwheeler child declaring abstract method of Carz Class.");
		
	}
	
}
class Deserttransport extends Fourwheel{
	public void desert() {
		System.out.println("The deser vehicles has Four wheel bike and offraoding cars.(Extended from class fourwheel).");
	}
	@Override
	public void car() {
		System.out.println("This is car method form deserttransport class.");
		
	}
	@Override
	public void vehicle() {
		// TODO Auto-generated method stub
		super.vehicle();
	}
	
}


public class HybridInheritance {

	public static void main(String[] args) {
		// TODO Auto-genedesrated method stub
		Fourwheel fr = new Fourwheel();
		fr.bus();
		fr.car();
		fr.vehicle();
		
		Deserttransport ds = new Deserttransport();
		ds.desert();
		ds.vehicle();
		ds.car();
		

	}

}
