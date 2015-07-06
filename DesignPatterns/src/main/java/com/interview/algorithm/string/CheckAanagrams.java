package com.interview.algorithm.string;
import java.util.Arrays;


public class CheckAanagrams {
	public static void main(String[] args) {
		System.out.println(isAnagram("cat", "tca"));
//		System.out.println("CheckAanagrams.main(): " + "tca".indexOf('a'));

	}

	public static boolean anagram(String s, String t) {
		return sort(s).equals(sort(t));
	}

	private static String sort(String str) {
		char temp;
		int in;
		int length = str.length();

		// start the outer loop at 1 so would be compared with previous 0
		for (int out = 1; out < length; out++) {
			temp = str.charAt(out); // copy into temp , later insert at the correct empty position
			in = out;
			while (in > 0 && str.charAt(in - 1) >= temp) {
				// shift the elements if they are greater than temp
				str = str.replace(str.charAt(in), str.charAt(in - 1));
				--in;
			}
			// insert at the correct empty position after all shifts done

			str = str.replace(str.charAt(in), str.charAt(out));
		}

		System.out.println(str);
		return str;

	}

	public static boolean iAnagram(String word, String anagram) { 
		char[] charFromWord = word.toCharArray(); 
		char[] charFromAnagram = anagram.toCharArray(); 
		
		Arrays.sort(charFromWord); 
		Arrays.sort(charFromAnagram); 
		
		return Arrays.equals(charFromWord, charFromAnagram); 
	}

	public static boolean checkAnagram(String first, String second) { 
		char[] characters = first.toCharArray(); 
		StringBuilder sbSecond = new StringBuilder(second); 
		
		for(char ch : characters){ 
			int index = sbSecond.indexOf("" + ch); 
			if(index != -1){ 
				sbSecond.deleteCharAt(index); 
			}else{ 
				return false; 
			} 
		} 
		return sbSecond.length()==0 ? true : false; 
	}
	
	/* * One way to find if two Strings are anagram in Java. 
	 * This method * assumes both arguments are not null and in lowercase. * * @return true, if both String are anagram */ 
	public static boolean isAnagram(String word, String anagram){ 
		if(word.length() != anagram.length()){ 
			return false; 
		} 
		char[] chars = word.toCharArray(); 
		for(char c : chars){ 
			int index = anagram.indexOf(c); 
				if(index != -1){ 
					anagram = anagram.substring(0,index) + anagram.substring(index +1, anagram.length()); 
				}else{ 
					return false; 
				} 
		} 
		return anagram.isEmpty(); 
	}

}
