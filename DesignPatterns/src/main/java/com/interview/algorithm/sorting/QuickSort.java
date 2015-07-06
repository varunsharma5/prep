package com.interview.algorithm.sorting;

import java.util.Arrays;

class QuickSorter {
	private long[] theArray;
	private int nElems;

	public QuickSorter(long a[]) {
		this.theArray = a;
		nElems = a.length;
	}

	public void sort() {
		recQuickSort(0, nElems-1);
	}

	private void recQuickSort(int left, int right) {
		if(left>=right) { // if size <= 1, already sorted
			return;
		} else {	// // size is 2 or larger
			long pivot = theArray[right];

			int partition = partitionIt(left, right, pivot);

			recQuickSort(left, partition-1);
			recQuickSort(partition+1, right);
		}
	}

	private int partitionIt(int left, int right, long pivot) {

		int leftPtr = left - 1;
		int rightPtr = right;

		while(true) {
			while(theArray[++leftPtr] < pivot) {}
			
			while(rightPtr > 0 && theArray[--rightPtr] > pivot){}

			if(left >= right) {
				break;
			} else {
				swap(leftPtr, rightPtr);
			}
		}
		swap(leftPtr, right);
		return leftPtr;
	}
	
	private void swap(int index1, int index2) {
		long temp = theArray[index1];
		theArray[index1] = theArray[index2];
		theArray[index2] = temp;
	}
}

public class QuickSort {
	public static void main(String[] args) {
		
		int maxSize = 16; // array size
		long a[] = new long[maxSize];
		for(int j=0; j<maxSize; j++) { // fill array with random numbers 
			long n = (int)(java.lang.Math.random()*99);
			a[j] = n;
		}
		
		System.out.println(Arrays.toString(a));
		
		QuickSorter sorter = new QuickSorter(a);
		sorter.sort();
		
		System.out.println(Arrays.toString(a));
	}
}
