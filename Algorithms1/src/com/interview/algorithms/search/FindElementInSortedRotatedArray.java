package com.interview.algorithms.search;


/**
 * Given a sorted array of n integers that has been rotated an unknown number of
 * times, give an O(log n) algorithm that finds an element in the array. You may
 * assume that the array was originally sorted in increasing order.
 *  EXAMPLE: Input: find 5 in array (15 16 19 20 25 1 3 4 5 7 10 14)
 *  Output: 8 (the index of 5 in the array)
 * 
 * @author ajitkoti
 *
 */
public class FindElementInSortedRotatedArray {

	int[] array;
	
	public FindElementInSortedRotatedArray(int[] A) {
		this.array = A;
	}

	public int find(int[] searchArray, int tobeFound) {
		this.array = searchArray;

		return find(tobeFound, 0, searchArray.length - 1);
	}

	public int find(int tobeFound, int lowerbound, int upperbound) {
		int mid;

		mid = (lowerbound + upperbound) / 2;

		if (array[mid] == tobeFound) {
			return mid;
		} else if (lowerbound > upperbound) {
			return -1;
		} else {
			if (array[mid] > tobeFound) {
				return find(tobeFound, lowerbound, mid - 1);
			} else {
				return find(tobeFound, mid + 1, upperbound);
			}
		}

	}
	
	private int circularBinSearch (int tobeFound, int low, int high )  {
		if (low > high) { 
			return -1; // not found 
		} 

		int mid = (low + high) / 2; 

		if (array[mid] == tobeFound)  { 
			return mid; 
		}  else if (tobeFound < array[mid]) { 
			return ((array[low] <= array[mid]) && (array[low] > tobeFound)) ? circularBinSearch(tobeFound, mid + 1, high) : circularBinSearch(tobeFound, low, mid - 1); 
		} 
		else {// key > A[mid]  
			return ((array[mid] <= array[high]) && (tobeFound > array[high])) ? circularBinSearch(tobeFound, low, mid - 1) : circularBinSearch(tobeFound, mid + 1, high); 
		} 
	}
	
	public int searchKey(int key) {
		return circularBinSearch(key, 0, array.length);
	}

	public static void main(String[] args) {
		int[] searchArray = new int[] { 15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14 };
		FindElementInSortedRotatedArray search = new FindElementInSortedRotatedArray(searchArray);
//		System.out.println(search.findElement(searchArray, 5));
//		System.out.println(search.find(searchArray, 10));
		System.out.println(search.searchKey(5));

	}

}
