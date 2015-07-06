package com.interview.algorithm;

public class PrintFactors {

	public static void main(String[] args) {
		printFactors2(68);
	}
	
	public static void printFactors2(int n) {
        System.out.print("[");
        int count = 0;
        for (int i = 2; i <= n - 1; i++) {
            if (n % i == 0) {
                // i is a factor of n
                count++;
                if (count > 1) {
                    System.out.print(", " + i);
                } else {
                    System.out.print(i);
                }
            }
        }
        System.out.println("]");
    }
	
}
