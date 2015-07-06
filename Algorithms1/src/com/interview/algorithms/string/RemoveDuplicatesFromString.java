package com.interview.algorithms.string;

public class RemoveDuplicatesFromString {

	public static void main(String[] args) {
		char[] str = new char[]{'a','a','c'};
		System.out.println(removeDuplicates(str));

	}

	public static String removeDuplicates(char[] str) {
		if (str == null)
			return null;

		int len = str.length;

		if (len < 2)
			return new String(str);

		int tail = 1;

		for (int i = 1; i < len; ++i) {
			int j;

			for (j = 0; j < tail; ++j) {
				if (str[i] == str[j])
					break;
			}

			if (j == tail) {				
				str[tail] = str[i];
				++tail;
			}

		}

		str[tail] = 0;
		
		return new String(str);
	}

}
