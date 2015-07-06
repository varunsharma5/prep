package com.interview.algorithms.search;


/**
 * Given a sorted array of strings which is interspersed with empty strings,
 * write a meth- od to find the location of a given string. 
 * 
 * Example: find "ball" in 
 * ["at", "", "", "", "ball", "", "", "car", "", "", "dad", "", ""] 
 * will return 4 
 * 
 * Example: find "ballcar" in
 *  ["at", "", "", "", "", "ball", "car", "", * "", "dad", "", ""] 
 *  will return -1
 * 
 * @author ajitkoti
 *
 */
public class SearchAStringInSortedArray {
	
	private String[] searchArray;

	public String find(String[] searchArray, String tobeFound) {
		this.searchArray = searchArray;

		return find(tobeFound, 0, searchArray.length - 1);
	}

	public String find(String tobeFound, int lowerbound, int upperbound) {
		int mid;

		mid = (lowerbound + upperbound) / 2;

		if (searchArray[mid].equals(tobeFound)) {
			return tobeFound;
		} else if (lowerbound > upperbound) {
			return null;
		} else {
			int result = searchArray[mid].compareToIgnoreCase(tobeFound);
			if (result > 0) {
				return find(tobeFound, lowerbound, mid - 1);
			} else if(result < 0){
				return find(tobeFound, mid + 1, upperbound);
			}
		}
		return tobeFound;

	}

	public static void main(String[] args) {
		String[] searchArray = new String[] { "at", "", "", "", "ball", "", "", "car","", "", "dad", "", "" };
		SearchAStringInSortedArray search = new SearchAStringInSortedArray();
		System.out.println(search.find(searchArray, "ball"));		
	}

}
