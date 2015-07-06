package com.interview.algorithms.array;

import java.util.HashMap;
import java.util.Map;

public class FindSubArrayWhichSumsToZero {
	
	private static void subArraySumsZero() {
        int [] seed = new int[] {0,1,2,3,4,-9,6,7,-8,1,9};
        int currSum = 0;
        Map<Integer, Integer> sumMap = new HashMap<Integer, Integer>();
        for(int i = 0 ; i < seed.length ; i ++){
            currSum += seed[i];
            if(currSum == 0){
               System.out.println("subset : { 0 - " + i + " }");
            }else if(sumMap.containsKey(currSum)){
                System.out.println("subset : { " + (sumMap.get(currSum) + 1) + " - " + i + " }");
                sumMap.put(currSum, i);
            }else
                sumMap.put(currSum, i);
            System.out.println("HASH MAP HAS: " + sumMap);
        }
        
    }
	
	public static void main(String[] args) {
		subArraySumsZero();
	}

}
