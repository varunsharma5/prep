package com.interview.algorithms.search;

public class BinarySearch extends AbstractSerach {
	private int[] searchArray;

	@Override
	public int find(int[] searchArray, int tobeFound) {
		this.searchArray = searchArray;

		return find(tobeFound, 0, searchArray.length - 1);
	}

	public int find(int tobeFound, int lowerbound, int upperbound) {
		int mid;

		mid = (lowerbound + upperbound) / 2;

		if (searchArray[mid] == tobeFound) {
			return tobeFound;
		} else if (lowerbound > upperbound) {
			return -1;
		} else {
			if (searchArray[mid] > tobeFound) {
				return find(tobeFound, lowerbound, mid - 1);
			} else {
				return find(tobeFound, mid + 1, upperbound);
			}
		}

	}

	public static void main(String[] args) {
		int[] searchArray = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		BinarySearch search = new BinarySearch();
		System.out.println(search.find(searchArray, 5));
		System.out.println(search.find(searchArray, 11));

	}

}
