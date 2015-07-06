package com.interview.algorithms.string;

public class IsStringUnique {
	public static void main(String[] args) {
		System.out.println(isUniqueChars("aaabbbc"));
		System.out.println(isUniqueChars("axcvdbkk"));
		System.out.println(isUniqueChars("ajit"));

	}

	/**
	 * For simplicity, assume char set is ASCII (if not, we need to increase the
	 * storage size. The rest of the logic would be the same)
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isUniqueChars(String str) {
		boolean[] char_set = new boolean[256];

		for (int i = 0; i < str.length(); i++) {
			int val = str.charAt(i);
			
			if (char_set[val])
				return false;

			char_set[val] = true;
		}

		return true;
	}

}
