package com.interview.algorithms.array;

//http://stackoverflow.com/questions/4686823/given-2-sorted-arrays-of-integers-find-the-nth-largest-number-in-sublinear-time

public class KthSmallElementInTwoSortedArray {

	public static int binSearch(int[] arr, int low, int high, int key) {
		int mid = 0;
		while (high >= low) {
			mid = (high + low) / 2;
			if (arr[mid] == key) {
				return (mid);
			} else if (arr[mid] < key) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		if (arr[mid] > key) {
			return (mid - 1);
		}
		return (mid);
	}

	public static int kthElement(int[] arr1, int[] arr2, int s1, int h1,int s2, int h2, int k) {
		int len1 = (h1 - s1 + 1);
		int len2 = (h2 - s2 + 1);
		if (len1 <= 0) {
			return (arr2[s2 + k - 1]);
		}
		if (len2 <= 0) {
			return (arr1[s1 + k - 1]);
		}

		if (k > (len1 + len2)) {
			return (-1);
		}

		int mid = (s1 + h1) / 2;
		int i = binSearch(arr2, s2, h2, arr1[mid]);
		int size = mid + i - s1 - s2 + 2;
		// System.out.println(mid+" "+i+" "+size);
		if (size == k) {
			return (arr1[mid]);
		}
		if (size > k) {
			return (kthElement(arr1, arr2, s1, mid - 1, s2, i, k));
		} else {
			return (kthElement(arr1, arr2, mid + 1, h1, i + 1, h2, k - size));
		}

	}

	public static void main(String[] args) {
		int[] arr1 = { 1, 3, 5, 7, 9, 11, 13 };
		int[] arr2 = { 2, 4, 6, 8, 10, 12 };
		int k = 6;
		System.out.println(k
				+ "th Element : "
				+ kthElement(arr1, arr2, 0, arr1.length - 1, 0,	arr2.length - 1, k));
	}

}
