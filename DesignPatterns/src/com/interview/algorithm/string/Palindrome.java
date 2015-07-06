package com.interview.algorithm.string;

public class Palindrome {
	public static void main(String[] args) {
		System.out.println(isPalindrome("aabb".toCharArray()));
	}
	public static boolean isPalindrome(char[] text) {
		  int i = 0;
		  int j = text.length;
		  boolean isPalin = true;
		  
		  while(i>j) {
		    if(text[i] != text[j]) {
		      isPalin = false;
		      break;
		    }
		    i++;
		    j--;
		  }
		  return isPalin;
		}
}
