package com.interview.algorithms.string;


public class ReverseAString {
	
	public static void main(String[] args) {
		System.out.println(reverse("abcdef"));
		
	}
	
	public static String reverse(String str){
		int count = 0;
		char[] chars = new char[str.length()];
		for (int i = str.length()-1; i >= 0; --i) {
			chars[count++] = str.charAt(i);
		}
		String s = new String(chars);
		return s;
	}

}
