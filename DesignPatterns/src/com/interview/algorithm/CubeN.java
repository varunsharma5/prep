package com.interview.algorithm;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/*
 * Given N,find all a and b combination which satisfies a^3 + b^3 = N
 */
public class CubeN {
	public static void main(String[] args) {

		int cube = 0,l = 1;
		HashMap<Integer,Integer> hm  = new HashMap<Integer,Integer>();

		System.out.println("Enter the Value of N :");
		Scanner s = new Scanner(System.in);

		int n = s.nextInt();

		for(int j = 0; j < n; j++){

			cube = j*j*j;
			hm.put(cube,j);
		}	


		Set set = hm.entrySet();		
		Iterator i = set.iterator();


		while(i.hasNext()){

			Map.Entry me = (Map.Entry)i.next();
			int Value = n - (Integer) me.getKey();
			int num1 = (Integer)me.getValue();

			if(hm.containsKey(Value)){
				int num2 = hm.get(Value);
				System.out.println("Combination:"+l+" "+num1+","+num2);
				l++;

			}		
		}	
	}
}
