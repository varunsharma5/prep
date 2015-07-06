package com.interview.collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;


public class HashMapProbs {
	public static void main(String[] args) {
		prob2();
	}
	
	private static void prob1() {

		String s1 = "varun";
		String s2 = "varun";
		
		HashMap<String, String> map = new HashMap<String, String>();
		
		map.put(s1, s1);
		
		System.out.println(map.get(s2));
	
	}
	private static void prob2() {
	    StringBuilder s1 = new StringBuilder("madhav");
	    Map<StringBuilder,StringBuilder> map = new HashMap<StringBuilder,StringBuilder>();
	    map.put(s1,s1);
	    s1.append("text");
	    System.out.println(map.get(s1));
	}
	
	private static void prob3() {
		StringBuilder sb = new StringBuilder("madhav");
        modify(sb);
        System.out.println(sb.toString());
	}
	
	private static void modify(StringBuilder sb) {
		
		LinkedList<Integer> lst = new LinkedList<Integer>();
		
        sb.append("text");
    }
}
