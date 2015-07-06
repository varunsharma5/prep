package com.interview.algorithm.string;

/**
 * 	Write an efficient function to find the first nonrepeated character in a string. For
	instance, the first nonrepeated character in “total” is ‘o’ and the first nonrepeated
	character in “teeter” is ‘r’. Discuss the efficiency of your algorithm.
 * @author varun
 *
 */
public class FindFirstNonrepeatedCharacter {
	public static void main(String[] args) {
		System.out.println(approach1("total".toCharArray()));
		System.out.println(approach1("teeter".toCharArray()));
	}
	
	/*
	 * Using array with O(n)
	 */
	
	private static char approach1(char[] text) {
		int [] repeat = new int[128];
		char retVal = 0;
		
		for(char c : text) {
			int i = repeat[c];
			i++;
			repeat[c] = repeat[c]++;
		}
		
		for(char c : text) {
			if(repeat[c] == 1) {
				retVal = c;
				break;
			}
		}
		return retVal;
	}
}
