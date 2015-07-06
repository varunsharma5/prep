package com.interview.algorithm;

public class SwappingNums {
	// swap() doesn't swap i and j
//	public static void swap(Integer i, Integer j) {
//		Integer temp = new Integer(i);
//		i = j;
//		j = temp;
//		System.out.println("i = " + i + ", j = " + j);
//	}
//
//
//	public static void main(String[] args) {
//		Integer i = new Integer(10);
//		Integer j = new Integer(20);
//		System.out.println("i = " + i + ", j = " + j);
//		swap(i, j);
//		System.out.println("i = " + i + ", j = " + j);
//	}
	
	public static void main(String[] args) {
//		IntWrap i = new IntWrap();
//		i.x = 10;
//		IntWrap j = new IntWrap();
//		j.x = 20;
//		swap(i, j);
//		System.out.println("i.x = " + i.x + ", j.x = " + j.x);
		
		swapWithoutThirdVar();
	}

	public static void swap(IntWrap i, IntWrap j) {
		int temp = i.x;
		i.x = j.x;
		j.x = temp; 
	}
	
	public static void swapWithoutThirdVar() {
		int a = -2;
		int b = -10;
		System.out.println("SwappingNums.swapWithoutThirdVar(): a = " + a + " ,b = " + b);
		a = a + b;
		b = a - b;
		a = a - b;
		System.out.println("SwappingNums.swapWithoutThirdVar(): a = " + a + " ,b = " + b);
		
	}
}


class IntWrap {
	int x;
}