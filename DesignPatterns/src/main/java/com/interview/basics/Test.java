package com.interview.basics;

import java.util.concurrent.atomic.AtomicInteger;

public class Test {
	
	static int val = 1;
	AtomicInteger counter = new AtomicInteger();
	
	public int getValue() {
		counter.getAndIncrement();
		try {
			val = val + 1;
			return val;
		} catch (Exception e ) {
			return 0;
		} finally	 {
			val = val + 1;
		}
	}
	public static void main(String[] args) {
//		Test t = new Test();
//		System.out.println("Test.main(): " + t.getValue());
//		System.out.println("Test.main(): " + t.val);
		
//		int x = 012;
//		if(x == 10.0) {
//			System.out.println("test");
//		}
		
		String s1 = new String ("String A");
		String s2 = new String ("String B");
		String s3 = s1;
		String s4 = s3+"String C";
		String s5 = s2;
		
		s1 = null;
		s2 = null;
		s3 = null;
	}
}
