package com.interview.algorithm.sorting;

import java.util.Arrays;


class InsertionSorter {
	private long a[];
	private int nElems ;
	public InsertionSorter(long a[]) {
		this.a = a;
		nElems = a.length;
	}

	public void sort() {
		int in, out;
		for(out=1; out<nElems; out++) // out is dividing line
		{
			long temp = a[out]; // remove marked item
			in = out; // start shifts at out
			while(in>0 && a[in-1] >= temp) // until one is smaller,
			{
				a[in] = a[in-1]; // shift item right,
				--in; // go left one position
			}
			a[in] = temp; // insert marked item
		} // end for
	} // end insertionSort()
}
public class InsertionSort {
	public static void main(String[] args) {
		long a[] = new long[]{3,2,15,6,4,21,8,1,0,10};
//		int a[] = new int[]{0, 1, 2, 3, 4, 6, 8, 10, 15, 21};
		InsertionSorter sorter = new InsertionSorter(a);
		sorter.sort();
		System.out.println(Arrays.toString(a));
	}

}
