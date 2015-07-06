package com.interview.algorithms.primitive.conversions;

public class ConvertStringToInteger {
	
	public static int myStringToInteger(String str) {
	    int answer = 0, factor = 1;
	    for (int i = str.length()-1; i >= 0; i--) {	    	
	        answer = answer+ ((str.charAt(i) - '0') * factor);
	        System.out.println(answer);
	        factor *= 10;
	    }
	    return answer;
	}
	
	public static void main(String[] args) {
		System.out.println(myStringToInteger("1234"));
		
	}

}
