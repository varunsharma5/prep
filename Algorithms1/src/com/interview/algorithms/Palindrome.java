package com.interview.algorithms;

public class Palindrome {

	public void checkPalindrome(String str) {
		StringBuffer strBuff = new StringBuffer(str);
		if (str.equalsIgnoreCase(strBuff.reverse().toString())) {
			System.out.println(str + " is a palindrome");
		} else {
			System.out.println(str + " is not a palindrome");
		}

	}

	public void checkPalindromeAnotherWay(String str) {
		int left = 0;
		boolean flag = true;
		int right = str.length() - 1;
		while (left < right) {
			if (str.charAt(left) != str.charAt(right)) {
				flag = false;
				break;
			}
			++left;
			--right;

		}

		if (flag) {
			System.out.println(str + " is a palindrome");
		} else {
			System.out.println(str + " is not a palindrome");
		}

	}

	public static void main(String[] args) {
		Palindrome palindrome = new Palindrome();
		palindrome.checkPalindrome("asa");
		palindrome.checkPalindrome("hello");
		
		palindrome.checkPalindromeAnotherWay("asa");
		palindrome.checkPalindromeAnotherWay("hello");
	}

}
