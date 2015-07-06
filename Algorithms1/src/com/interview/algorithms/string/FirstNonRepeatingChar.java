package com.interview.algorithms.string;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class FirstNonRepeatingChar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter a string");
		StringBuilder str = new StringBuilder((scan.nextLine()));
		int len = str.length();

		Map<Character, Boolean> map = new LinkedHashMap<Character, Boolean>();

		for (int i = 0; i < len; i++) {
			if (!map.containsKey(str.charAt(i))) {
				map.put(str.charAt(i), true);
			} else {
				map.put(str.charAt(i), false);
			}
		}

		System.out.println(map);
		for (Entry<Character, Boolean> e : map.entrySet()) {
			if (e.getValue()) {
				System.out.println(e);
				break;
			}

		}
		scan.close();
	}

}
