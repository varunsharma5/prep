package com.interview.collections;

public class HashmapTest {
	public static void main(String[] args) {
		String s1 = new String("abc");
		String s2 = new String("ab");
		s2 = s2 + "c";
		
		System.out.println(s1.hashCode() + " " + s2.hashCode());
	}
}
