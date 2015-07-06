package com.interview.algorithm;

public class FibonanciSeries {
	public static void main(String[] args) {
		System.out.println(findFibonanci(4));
	}
	
	private static int findFibonanci(int count) {
		if(count == 0) {
			return 0;
		} else if(count == 1) {
			return 1;
		}else if(count == 2) {
			return 2;
		}else {
			return findFibonanci(count-1) + findFibonanci(count-2);
//			System.out.println(fib);
//			return fib;
		}
	}
}
