package com.interview.algorithms.array;

/**
 * A majority element in an array A[] of size n is an element that appears more
 * than n/2 times (and hence there is at most one such element).
 * http://www.geeksforgeeks.org/majority-element/
 * 
 * Using Moore’s Voting Algorithm
 * 
 * This is a two step process. 1. Get an element occurring most of the time in
 * the array. This phase will make sure that if there is a majority element then
 * it will return that only. 2. Check if the element obtained from above step is
 * majority element.
 * 
 * @author ajitkoti
 * 
 */
public class MajorityElementInAnArray {

	/* Function to print Majority Element */
	private static void printMajority(int a[], int size) {
		/* Find the candidate for Majority */
		int cand = findCandidate(a, size);

		/* Print the candidate if it is Majority */
		if (isMajority(a, size, cand))
			System.out.println(cand);
		else
			System.out.println("NO Majority Element");
	}

	/* Function to find the candidate for Majority */
	private static int findCandidate(int a[], int size) {
		int maj_index = 0, count = 1;
		int i;
		for (i = 1; i < size; i++) {
			if (a[maj_index] == a[i])
				count++;
			else
				count--;
			if (count == 0) {
				maj_index = i;
				count = 1;
			}
		}
		return a[maj_index];
	}

	/* Function to check if the candidate occurs more than n/2 times */
	private static boolean isMajority(int a[], int size, int cand) {
		int i, count = 0;
		for (i = 0; i < size; i++)
			if (a[i] == cand)
				count++;
		if (count > size / 2)
			return true;
		else
			return false;
	}

	public static void main(String[] args) {
		int a[] = { 1, 3, 3, 1, 2, 3, 3, 3, 3, 3, 3, 2, 2, 2, 2 };
		printMajority(a, a.length);

	}

}
