package com.interview.algorithm.sorting;

import java.util.Arrays;

/**
 * O(N2)
 * 
 * @author varun
 *
 */
class SelectionSorter {
	private int a[];
	private int nElem;
	public SelectionSorter(int a[]) {
		this.a = a;
		this.nElem = a.length;
	}
	
	public void sort() {
		for(int outCounter=0; outCounter<nElem ;outCounter++) {
			int minIndex = outCounter;
			for(int inCounter=outCounter; inCounter<nElem; inCounter++) {
				if(a[inCounter] < a[minIndex]) {
					minIndex = inCounter;
				}
			}
			
			swap(outCounter, minIndex);
		}
	}
	
	private void swap(int index1, int index2) {
		int temp = a[index1];
		a[index1] = a[index2];
		a[index2] = temp;
	}
}

public class SelectionSort {

	public static void main(String[] args) {
		int a[] = new int[]{3,2,15,6,4,21,8,1,0,10};
//		int a[] = new int[]{0, 1, 2, 3, 4, 6, 8, 10, 15, 21};
		SelectionSorter sorter = new SelectionSorter(a);
		sorter.sort();
		System.out.println(Arrays.toString(a));
	}

}
