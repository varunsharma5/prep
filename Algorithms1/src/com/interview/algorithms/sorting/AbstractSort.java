package com.interview.algorithms.sorting;

public abstract class  AbstractSort {
	private static int count = 0;

	protected void display(int[] unsorted) {

		System.out.print("Contents:" + ++count + " ---> ");
		for (int i : unsorted) {
			System.out.print(i + ", ");
		}
		System.out.println();

	}

	protected void swap(int[] unsorted, int i, int j) {
		int temp = unsorted[i];
		unsorted[i] = unsorted[j];
		unsorted[j] = temp;

	}
	
	public abstract void sort(int[] unsorted);
	
	
	public static void main(String[] args) {
		
	}

}
