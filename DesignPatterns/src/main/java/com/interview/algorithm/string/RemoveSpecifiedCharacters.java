package com.interview.algorithm.string;

/**
 * 	Write an efficient function that deletes characters from a string. Use the prototype
	string removeChars( string str, string remove );
	where any character existing in remove must be deleted from str. For example,
	given a str of “Battle of the Vowels: Hawaii vs. Grozny” and a remove of “aeiou”,
	the function should transform str to “Bttl f th Vwls: Hw vs. Grzny”. Justify any
	design decisions you make and discuss the efficiency of your solution.
 * @author varun
 *
 */
public class RemoveSpecifiedCharacters {
	public static void main(String[] args) {
		approach1("Battle of the Vowels: Hawaii vs. Grozny", "aeiou");
		approach2("Battle of the Vowels: Hawaii vs. Grozny", "aeiou");
	}

	/*
	 * O(n*m): Not good
	 */
	private static void approach1(String text, String remove) {
		char [] removeChars = remove.toCharArray();
		char [] textChars = text.toCharArray();
		
		for(char c : removeChars) {
			for(int i=0 ; i<textChars.length; i++) {
				if(c == textChars[i]) {
					textChars = deleteChar(textChars,i);
				}
			}
		}
		System.out.println(new String(textChars));
	}
	
	private static char[] deleteChar(char[] text, int index) {
		StringBuilder builder = new StringBuilder(new String(text));
		return builder.deleteCharAt(index).toString().toCharArray();
	}
	
	/*
	 * o(n + m): Better
	 */
	private static void approach2(String text, String remove) {
		boolean[] lookup = new boolean[128];
		char [] removeChars = remove.toCharArray();
		char [] textChars = text.toCharArray();
		char [] finalChar = new char[text.length()-remove.length()]; 
		
		for(int i=0; i<128; i++) {
			lookup[i] = false;
		}
		
		for(char c : removeChars) {
			lookup[c] = true;
		}
		
		int j = 0;
		for(int i=0; i< textChars.length; i++) {
			if(lookup[textChars[i]]) {
				continue;
			}
			finalChar[j] = textChars[i];
			j++;
		}
		
		System.out.println(new String(finalChar));
	}
	
}
