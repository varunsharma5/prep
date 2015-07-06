package com.interview.algorithms;


public class SwapTwoIntgerVaraiables {

	public static void swap(int high, int low) {
		System.out.println("high : is" + high + "low is" + low);
		if (high > low) {
			high = high + low;
			low = high - low;
			high = high - low;

			System.out.println("high : is" + high + "low is" + low);
		} else {
			low = high + low;
			high = low - high;
			low = low - high;
			System.out.println("In else - high : is" + high + " low is" + low);
		}
	}

	public static void swapUsingXOR(int high, int low) {
		System.out.println("high : is" + high + "low is" + low);
		if (high > low) {
			high = high ^ low;
			low = high ^ low;
			high = high ^ low;

			System.out.println("high : is" + high + "low is" + low);
		} else {
			high = high ^ low;
			low = high ^ low;
			high = high ^ low;
			System.out.println("In else - high : is" + high + " low is" + low);
		}
	}

	public static void main(String[] args) {
		 
	}
}
