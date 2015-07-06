package com.interview.algorithm;

class TriangleApp {
	public int triangle(int n) {
		if(n == 1) {
			System.out.print("1");
			return 1;
		}
		int t = n + triangle(n-1);
		System.out.print(" " + t);
		return t;
	}
}

public class TriangularNumber {
	public static void main(String[] args) {
		TriangleApp app = new TriangleApp(); 
		app.triangle(5);
	}
}
