package com.interview.algorithm.sorting;

import java.util.Arrays;

/**
 * O(N2)
 * @author varun
 *
 */
class BubbleSorter {
	private int a[];
	private int nElem;
	public BubbleSorter(int a[]) {
		this.a = a;
		this.nElem = a.length;
	}
	
	public void sort() {
		boolean sorted = true;
		for(int outCounter=nElem-1; outCounter>1 ;outCounter--) {
			for(int inCounter=0; inCounter<outCounter; inCounter++) {
				if(a[inCounter] > a[inCounter + 1]) {
					sorted = false;
					swap(inCounter, inCounter+1);
				}
				if(sorted) {
					break;
				}
			}
		}
	}
	
	private void swap(int index1, int index2) {
		int temp = a[index1];
		a[index1] = a[index2];
		a[index2] = temp;
	}
}

public class BubbleSort {
	public static void main(String[] args) {
		int a[] = new int[]{3,2,15,6,4,21,8,1,0,10};
//		int a[] = new int[]{0, 1, 2, 3, 4, 6, 8, 10, 15, 21};
		BubbleSorter sorter = new BubbleSorter(a);
		sorter.sort();
		System.out.println(Arrays.toString(a));
	}
}
