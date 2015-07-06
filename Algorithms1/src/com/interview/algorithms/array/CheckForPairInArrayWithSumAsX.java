package com.interview.algorithms.array;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Given an array A[] of n numbers and another number x, determines whether or
 * not there exist two elements in S whose sum is exactly x.
 * 
 * hasArrayTwoCandidates (A[], sum) 1) Sort the array in ascending order.
 * 
 * 2) Initialize two index variables to find the candidate elements in the
 * sorted array. (a) Initialize first to the leftmost index: l = 0 (b)
 * Initialize second the rightmost index: r = ar_size-1
 * 
 * 3) Loop while l < r. (a) If (A[l] + A[r] == sum) then return 1 (b) Else
 * if(A[l] + A[r] < sum ) then l++ (c) Else r-- 4) No candidates in whole array
 * - return 0
 * 
 * @author ajitkoti
 *
 */
public class CheckForPairInArrayWithSumAsX {	

	/**
	 * Time Complexity: If we use Quick Sort then O(n^2) in worst case.
	 * @param unsorted
	 * @param sum
	 */
	private static void hasArrayTwoCandidates(int unsorted[], int sum) {
		Map<Integer, Integer > pairs = new HashMap<Integer, Integer>();         
          int left = 0;
          int right = unsorted.length-1;
          reQuickSort(unsorted, left,right); // sorts array 
          display(unsorted);
          
          
          
          while (left< right){
        	int tempSum =  (unsorted [left] + unsorted [right]);
        	  if(tempSum == sum){
        		  System.out.println(unsorted [left]+" + " +unsorted [right] +" == "+sum);
        		  pairs.put(left, right);
        		  left++;
        		  right--;
        	  }
        	  else if(tempSum < sum){
        		  left++;
        		  System.out.println(unsorted [left]+" + " +unsorted [right] +" < "+sum);
        		  System.out.println("Incrementing left ptr-" +left);
        	  }
        	  else if(tempSum > sum){
        		  right--;
        		  System.out.println(unsorted [left]+" + " +unsorted [right] +" > "+sum);
        		  System.out.println("decrementing right ptr -" + right);
        	  }
          }
          
          System.out.println("\nThe Pairs are ");
          for (Entry<Integer, Integer> pairEntry : pairs.entrySet()) {
        	System.out.println((unsorted [pairEntry.getKey()]+" + " +unsorted [pairEntry.getValue()] +" == "+sum));
			
		}
          
	}

	public static void main(String[] args) {
		 int[] array = new int[]{9, 7,-8, 1, 4, 6, 10, 45};
		 hasArrayTwoCandidates(array, 16);
		 

	}
	
	
	public static void  reQuickSort(int unsorted[],int left, int right) {
		if (right - left <= 0) // already sorted
			return;
		else {
			int pivot = unsorted[right];
			int partition = partition(unsorted,left, right, pivot);
			reQuickSort(unsorted,left, partition - 1);
			reQuickSort(unsorted,partition + 1, right);
		}

	}

	private static int partition(int unsorted[],int left, int right, int pivot) {
		int leftPtr = left - 1;
		int rightPtr = right;

		while (true) {
			while (unsorted[++leftPtr] < pivot)
				; // find greater than pivot

			while (rightPtr > 0 && unsorted[--rightPtr] > pivot)
				; // find smaller item

			if (leftPtr >= rightPtr) {
				break;
			} else {
				swap(unsorted,leftPtr, rightPtr);
			}
		}
		swap(unsorted,leftPtr, right);
		return leftPtr;
	}
	
	private static void swap(int unsorted[] ,int i, int j) {
		int temp = unsorted[i];
		unsorted[i] = unsorted[j];
		unsorted[j] = temp;

	}
	
	private static void display(int[] unsorted) {
		System.out.print("Contents:" + unsorted.length + " ---> ");
		for (int i : unsorted) {
			System.out.print(i + ", ");
		}
		System.out.println();

	}

}
