package com.interview.algorithms.array;

public class FindMedianOfTwoSortedArrays {

	/*
	 * 1) Calculate the medians m1 and m2 of the input arrays ar1[] and ar2[]
	 * respectively.
	 * 
	 * 2) If m1 and m2 both are equal then we are done. return m1 (or m2)
	 * 
	 * 3) If m1 is greater than m2, then median is present in one of the below
	 * two subarrays. a) From first element of ar1 to m1* (ar1[0...|_n/2_|]) b)
	 * From m2 to last element of ar2 (ar2[|_n/2_|...n-1])
	 * 
	 * 4) If m2 is greater than m1, then median is present in one of the below
	 * two subarrays. a) From m1 to last element of ar1 (ar1[|_n/2_|...n-1]) b)
	 * From first element of ar2 to m2 (ar2[0...|_n/2_|])
	 * 
	 * 5) Repeat the above process until size of both the subarrays becomes 2.
	 * 
	 * 6) If size of the two arrays is 2 then use below formula to get the
	 * median. Median = (max(ar1[0], ar2[0]) + min(ar1[1], ar2[1]))/2
	 * 
	 * 
	 * Assumptions in this function: Both ar1[] and ar2[] are sorted arrays Both
	 * have n elements
	 */
	public static int medianOfTwoSortredArrays(int[] arr1, int[] arr2) {
		int N = arr1.length;
		return medianRec(arr1, 0, N - 1, arr2, 0, N - 1);
	}

	public static int medianRec(int[] arr1, int l1, int h1, int[] arr2, int l2,
			int h2) {
		int mid1 = (h1 + l1) / 2;
		int mid2 = (h2 + l2) / 2;

		if (h1 - l1 == 1)
			return (Math.max(arr1[l1], arr2[l2]) + Math.min(arr1[h1], arr2[h2])) / 2;
		else if (arr1[mid1] > arr2[mid2])
			return medianRec(arr1, l1, mid1, arr2, mid2, h2);
		else
			return medianRec(arr1, mid1, h1, arr2, l2, mid2);
	}

	/* Driver program to test above function */
	public static void main(String[] args) {
		int ar1[] = { 1, 2, 3, 6 };
		int ar2[] = { 4, 6, 8, 10 };

		System.out.println("Median is " + medianOfTwoSortredArrays(ar1, ar2));
	}

	

}
