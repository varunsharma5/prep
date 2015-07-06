package com.interview.algorithms.array;

/**
 * An element in a sorted array can be found in O(log n) time via binary search.
 * But suppose I rotate the sorted array at some pivot unknown to you
 * beforehand. So for instance, 1 2 3 4 5 might become 3 4 5 1 2. Devise a way
 * to find an element in the rotated array in O(log n) time.
 * 
 * Algorithm: Find the pivot point, divide the array in two sub-arrays and call
 * binary search. The main idea for finding pivot is – for a sorted (in
 * increasing order) and pivoted array, pivot element is the only only element
 * for which next element to it is smaller than it. Using above criteria and
 * binary search methodology we can get pivot element in O(logn) time
 * 
 * Input arr[] = {3, 4, 5, 1, 2} Element to Search = 1 1) Find out pivot point
 * and divide the array in two sub-arrays. (pivot = 2) Index of 5 2) Now call
 * binary search for one of the two sub-arrays. (a) If element is greater than
 * 0th element then search in left array (b) Else Search in right array (1 will
 * go in else as 1 < 0th element(3)) 3) If element is found in selected
 * sub-array then return index Else return -1.
 * http://www.geeksforgeeks.org/search-an-element-in-a-sorted-and-pivoted-array/
 * 
 * @author ajitkoti
 * 
 */
public class SearchAnElementInSortedAndPivotedArray {
	
	/* Searches an element no in a pivoted sorted array arrp[]
	   of size arr_size */
	static int pivotedBinarySearch(int arr[], int arr_size, int no)
	{
	   int pivot = findPivot(arr, 0, arr_size-1);
	 
	   // If we didn't find a pivot, then array is not rotated at all
	   if (pivot == -1)
	     return binarySearch(arr, 0, arr_size-1, no);
	 
	   // If we found a pivot, then first compare with pivot and then
	   // search in two subarrays around pivot
	   if (arr[pivot] == no)
	     return pivot;
	   if (arr[0] <= no)
	     return binarySearch(arr, 0, pivot-1, no);
	   else
	     return binarySearch(arr, pivot+1, arr_size-1, no);
	}
	 
	/* Function to get pivot. For array 3, 4, 5, 6, 1, 2 it will
	   return 3. If array is not rotated at all, then it returns -1 */
	static int findPivot(int arr[], int low, int high)
	{
	   // base cases
	   if (high < low)  return -1;
	   if (high == low) return low;
	 
	   int mid = (low + high)/2;   /*low + (high - low)/2;*/
	   if (mid < high && arr[mid] > arr[mid + 1])
	     return mid;
	   if (mid > low && arr[mid] < arr[mid - 1])
	     return (mid-1);
	   if (arr[low] >= arr[mid])
	     return findPivot(arr, low, mid-1);
	   else
	     return findPivot(arr, mid + 1, high);
	}
	 
	/* Standard Binary Search function*/
	static int binarySearch(int arr[], int low, int high, int no)
	{
	   if (high < low)
	       return -1;
	   int mid = (low + high)/2;  /*low + (high - low)/2;*/
	   if (no == arr[mid])
	     return mid;
	   if (no > arr[mid])
	     return binarySearch(arr, (mid + 1), high, no);
	   else
	     return binarySearch(arr, low, (mid -1), no);
	}
	 
	 
	
	/* Driver program to check above functions */
	public static void main(String[] args)
	{
	   // Let us search 3 in below array
	   int arr1[] = {5, 6, 7, 8, 9, 10, 1, 2, 3};
	   int arr_size = arr1.length;
	   int no = 3;
	   System.out.println("Index of the element ["+ no+"] is "+ pivotedBinarySearch(arr1, arr_size, no));
	 
	    // Let us search 3 in below array
	   int arr2[] = {3, 4, 5, 1, 2};
	   arr_size = arr2.length;
	   System.out.println("Index of the element["+ no+"] is "+ pivotedBinarySearch(arr2, arr_size, no));
	 
	  
	}

}
