package com.interview.algorithm;

import java.util.ArrayList;
import java.util.List;


class A {
	protected int a;
	void print() {
	}
	
	void method(List<? extends Object> list) {
//		list = new ArrayList<Object>();
		list.remove(1);
	}
}

public class Testing extends A {
	protected int a;
	void print() {
	}

	public static void main(String args[]) {
//		A a = new Testing();
//		
//		Testing b = (Testing) a;
//
//		System.out.println(b);
		
//		System.out.println((100%29));
		
//		isPrime(16);
		
		List<A> list = new ArrayList<A>();
		list.add(new A());
		list.add(new A());
		list.add(new A());
		list.add(new A());
		list.add(new A());
		
		A obj = new A();
		System.out.println("Testing.main(): List Size: " + list.size());
		obj.method(list);
		System.out.println("Testing.main():" + list);
		System.out.println("Testing.main(): List Size: " + list.size());
		
		
	}
	
	private static boolean isPrime(int number) {

		// Eliminate the need to check versus even numbers

		if (number % 2 == 0)
			return false;

		// Check against all odd numbers

		for (int i = 3; i * i <= number; i += 2) {

			if (number % i == 0)
				return false;

		}

		// If we make it here we know it is odd

		return true;

	}
} 