package com.interview.algorithms.array;

import java.util.BitSet;

public class FindMissingElementInArray {
	private int[] intArray = new int[100];

	private void loadArray() {
		for (int i = 0; i < intArray.length; i++) {
			intArray[i] = i + 1;
		}
	}

	private void displayArray() {
		System.out.println("The Contents are");
		for (int i = 0; i < intArray.length; i++) {
			System.out.print(intArray[i] + ",");
		}
		System.out.println("--------------------------------");
	}

	private void setElement(int index, int value) {
		intArray[index] = value;
	}

	/**
	 * if the sum of the numbers goes beyond maximum allowed integer, then there
	 * can be integer overflow and we may not get correct answer. Method 2 & 3has
	 * no such problems.
	 * 
	 * @return
	 */
	private int missingElemntUsingSum() {
		int sum = 0;
		int missingNo = -1;

		int actualSum = (intArray.length * (intArray.length + 1)) / 2;

		for (int i = 0; i < intArray.length; i++) {
			sum += intArray[i];
		}

		missingNo = actualSum - sum;

		return missingNo;

	}

	private void missingElemntUsingBitSet() {
		BitSet bitset = new BitSet(intArray.length);

		for (int i = 0; i < intArray.length; i++) {
			if (intArray[i] != i + 1) {
				bitset.flip(i);
			}
		}

		System.out.println("The missing nos are : ");

		for (int i = 0; i < intArray.length; i++) {
			if (bitset.get(i)) {
				System.out.print(i + ",");
			}
		}

		System.out.println("----------------------------------------- ");

	}

	private void getMissingNo(int a[], int n) {
		int i;
		int x1 = a[0]; /* For xor of all the elemets in arary */
		int x2 = 1; /* For xor of all the elemets from 1 to n+1 */

		for (i = 1; i < n; i++)
			x1 = x1 ^ a[i];

		for (i = 2; i <= n + 1; i++)
			x2 = x2 ^ i;

		System.out.println("The missing no is  : " + (x1 ^ x2));
	}

	public static void main(String[] args) {
		FindMissingElementInArray find = new FindMissingElementInArray();
		find.loadArray();
		find.setElement(30, 0);
		find.setElement(60, 0);
		find.displayArray();

		find.missingElemntUsingBitSet();

		find.loadArray();
		find.setElement(30, 0);
		find.displayArray();
		System.out.println("The missing no is : "
				+ find.missingElemntUsingSum());

	}

}
