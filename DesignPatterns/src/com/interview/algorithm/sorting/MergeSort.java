package com.interview.algorithm.sorting;

class MergeSorter {
	private long[] theArray;
	private int nElems;
	
	public MergeSorter(long a[]) {
		this.theArray = a;
		nElems = a.length;
	}

	public void sort() {
		long[] workSpace = new long[nElems];
		recMergeSort(workSpace, 0, nElems-1);
	}
	
	private void recMergeSort(long[] workspace, int lowerBound, int upperBound) {
		if(lowerBound == upperBound) { // if range is 1, no use sorting
			return;
		} else {
			int mid = (lowerBound + upperBound)/2; // find midpoint
			
			recMergeSort(workspace, lowerBound, mid); // sort low half
			
			recMergeSort(workspace, mid+1, upperBound); // sort high half
			
			merge(workspace, lowerBound, mid+1, upperBound); // merge them
		}
	}
	
	private void merge(long[] workSpace, int lowPtr, int highPtr, int upperBound) {
		int j = 0; // workspace index
		int lowerBound = lowPtr;
		int mid = highPtr - 1;
		int n = upperBound - lowerBound + 1; // # of items
		
		while(lowPtr <= mid && highPtr <= upperBound) {
			if(theArray[lowPtr] < theArray[highPtr]) {
				workSpace[j++] = theArray[lowPtr++];
			} else {
				workSpace[j++] = theArray[highPtr++];
			}
		}
		
		while(lowPtr <= mid) {
			workSpace[j++] = theArray[lowPtr++];
		}
		
		while(highPtr <= upperBound) {
			workSpace[j++] = theArray[highPtr++];
		}
		
		for(j=0; j<n ;j++) {
			theArray[lowerBound+j] = workSpace[j];
		}
	}
	
//	private void mergeArray(int arrayA[], int sizeA, int arrayB[], int sizeB, int arrayC[]) {
//		int aDex=0, bDex=0, cDex=0;
//		
//		while(aDex < sizeA && bDex < sizeB) {
//			if(arrayA[aDex] < arrayB[bDex]) {
//				arrayC[cDex++] = arrayA[aDex++];
//			} else {
//				arrayC[cDex++] = arrayB[bDex++];
//			}
//		}
//		
//		while(aDex < sizeA) {
//			arrayC[cDex++] = arrayA[aDex++];
//		}
//		
//		while(bDex < sizeB) {
//			arrayC[cDex++] = arrayB[bDex++];
//		}
//	}
}
public class MergeSort {
	public static void main(String[] args) {
		
	}
}
