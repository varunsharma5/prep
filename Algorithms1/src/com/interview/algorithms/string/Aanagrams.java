package com.interview.algorithms.string;

public class Aanagrams {
	public static void main(String[] args) {
		System.out.println(anagram("cat", "cat"));

	}

	public static boolean anagram(String s, String t) {
		return sort(s).equals(sort(t));
	}

	private static String sort(String str) {
		char temp;
		int in;
		int length = str.length();
		char[] chars = str.toCharArray();

		// start the outer loop at 1 so would be compared with previous 0
		for (int out = 1; out < length; out++) {
			temp = chars[out]; // copy into temp , later insert at the
									// correct empty position
			in = out;
			while (in > 0 && chars[in - 1] >= temp) {
				// shift the elements if they are greater than temp
				chars[in] = chars[in - 1];
				--in;
			}
			// insert at the correct empty position after all shifts done
			chars[in] =temp;
			
		}
		str = new String(chars);
		
		System.out.println(str);
		return str;

	}

}
