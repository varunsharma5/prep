package com.interview.algorithm.string;

public class StringProbs {
	public static void main(String[] args) {
		
//		String txt = "varrun";
//		
//		String retVal = String.valueOf(removeDuplicates2(txt.toCharArray()));
//		
//		txt.contains("abc");
//		
//		System.out.println(retVal);
		
		String text = "abcdefghijk";
		String word = "ijk1";
		
		System.out.println(isSubString(text, word));
	}
	
	
	private static char [] removeDuplicates2(char [] str) {
		boolean []chars = new boolean[256];
		for(int i=0; i<256; i++) {
			chars[i] = false;
		}
		
		int totalElems = 0;
		
		for(int i=0; i<str.length; i++) {
			if(chars[str[i]] == false) {
				chars[str[i]] = true;
				totalElems++;
			}
		}
		
		char[] retArray = new char[totalElems];
		int j=0;
		for(int i=0; i<chars.length;i++) {
			if(chars[i] == true) {
				retArray[j++] = (char)i;
			}
		}
		return retArray;
	}
	
	private static boolean isSubString(String text, String word) {
		if(text == null || word == null) {
			return false;
		}
		
		if(text.length() < word.length()) {
			return false;
		}
		
		for(int i=0; i< text.length(); i++) {
			int wordLen = word.length();
			int j = i;
			int k = 0;
			boolean found = false;
			
			while(k<wordLen && j < text.length()) {
				found = (text.charAt(j) == word.charAt(k));
				k++; j++;
			}
			
			if(k < wordLen) {
				return false;
			}
			if(found) {
				return true;
			}
		}
		
		return false;
	}
}