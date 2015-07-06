package com.interview.algorithms;

public class FibonanciSeries {


	public void generateFibonanciSeries(int kth) {
		System.out.println(kth + "th : Fib no is :" + recFibonanci(kth));

	}

	private int recFibonanci(int n) {
		if (n == 0) {
			return 0;
		} else if (n == 1) {
			return 1;
		} else {
			int fib = recFibonanci(n - 1) + recFibonanci(n - 2);
			
			return fib;
		}

	}
	
	private int iterativeFibonanci(int n) {
		   int f1 = 0;
		   int f2 = 1;
		   int fn=0;;
		   for ( int i = 2; i <= n; i++ ){
		      fn = f1 + f2;
		      f1 = f2;
		      f2 = fn;
		   }
		   
		   return fn;

	}

	public static void main(String[] args) {

		FibonanciSeries series = new FibonanciSeries();

		series.generateFibonanciSeries(8);

		for (int i = 0; i <= 8; i++) {
			System.out.print("   " + series.recFibonanci(i));
		}
		System.out.println("   ");
		System.out.println("   " + series.iterativeFibonanci(8));

	}

}
