package com.interview.algorithm;

public class IntegerToBinary {
	public static void main(String[] args) {
		printBinary(187);
	}
	
	private static void printBinary(int i) {
		int remainder;
		
		if(i <= 1) {
			System.out.print(1);
			return;
		}
		
		remainder = i % 2;
		printBinary(i>>1);
		System.out.print(remainder);
	}
}
