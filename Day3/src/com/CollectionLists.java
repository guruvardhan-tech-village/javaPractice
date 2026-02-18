package com;


import java.util.*;

public class CollectionLists {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> fruits = new ArrayList<>();
		fruits.add("Mango");
		fruits.add("orange");
		fruits.add("Mango");
		System.out.println( fruits);
		System.out.println(fruits.contains("orange"));
		fruits.clear();
		System.out.println( "fruits After clear: "+ fruits);
		
		ArrayList<Integer> nums = new ArrayList<>();
		nums.add(5);
		nums.add(6);
		nums.add(4);
		nums.add(7);
		nums.add(8);
		nums.add(1);
		
		System.out.println( nums);
		nums.clear();
		System.out.println( "After clear nums: "+nums);
		
		LinkedList<String> cars = new LinkedList<>();
		cars.add("BMW");
		cars.add("Bugatti");
		cars.add("Brabuss");
		cars.add("Buzza");
		cars.add("Benz");
		System.out.println("Cars: "+cars);
		cars.addLast("Koenigsegg");
		cars.addFirst("VolksWagen");
		System.out.println("Cars after added last and first: "+cars);
		System.out.println(cars.get(5));
		System.out.println(cars.getLast());
		
		Iterator<String> it = cars.iterator();
		
		while(it.hasNext()) {
			System.out.print(it.next()+" ");
		}
		System.out.println();
		cars.forEach(item -> System.out.print(item+" "));
		
	}

}
