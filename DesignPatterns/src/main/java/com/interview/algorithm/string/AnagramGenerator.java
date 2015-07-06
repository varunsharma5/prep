package com.interview.algorithm.string;
import java.util.Scanner;



public class AnagramGenerator{
	public static void main (String args[])
	{
		System.out.println("Please enter the string whose permutations we need to show ");
		Scanner in = new Scanner(System.in);
		String original=in.nextLine();
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("Results are :");
		System.out.println("");
		System.out.println("");
		permute(original);
	}

	/*
	 * public static void main(String[] args) {
   int[] a = {5, 4, 2, 8, 6, 0};
   int subGroupLength = 3;
   int[] used = new int[subGroupLength];
   Arrays.fill(used, -1);
   allSubGroups(a, used, 0, 0);
}

	public static void allSubGroups(int[] a, int[] used, int startIndex, int usedCount){
		if(usedCount == used.length){
			for(int i = 0; i < usedCount; i++)
				System.out.print(a[used[i]]+" ");
			System.out.println();
		}else{
			for(int i = startIndex; i < a.length; i++){
				used[usedCount] = i;
				allSubGroups(a, used, i+1, usedCount+1);
				used[usedCount] = -1;
			}
		}
	}
	 */


	public static   void permute( String input) {
		int inputLength = input.length() -1 ;
		boolean[ ] used = new boolean[ inputLength ];
		StringBuffer outputString = new StringBuffer();
		char[] in = input.toCharArray( );
		
		doPermute ( in, outputString, used, inputLength, 0 );

	}

	public static void doPermute(char[ ] in, StringBuffer outputString, boolean[ ] used, int inputLength, int level)
	{
		if(level == inputLength) {
			System.out.println ( outputString.toString());
			return;
		}

		for(int i = 0; i < inputLength; ++i) {
			if(used[i]) { 
				continue;
			}
			outputString.append(in[i]);
			used[i] = true;
			
			doPermute(in, outputString, used, inputLength, level + 1);
			
			used[i] = false;
			outputString.setLength(outputString.length() - 1);
		}
	}
}