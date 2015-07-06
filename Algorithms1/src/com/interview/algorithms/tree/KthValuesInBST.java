package com.interview.algorithms.tree;

import com.example.datastructures.node.BinaryNode;

public class KthValuesInBST {

	static int index = 0; // Counter variable

	public static void getKthLargestValue(BinaryNode root, int k) {
		// Base condition
		if (root == null)
			return;

		getKthLargestValue(root.getRightChild(), k); // first traverse the right
														// sub // tree
		if (++index == k) {
			System.out.println(root.getData());
			return;
		}
		getKthLargestValue(root.getLeftChild(), k); // then traverse the left
													// sub tree
	}

	public static void getKthSmallestValue(BinaryNode root, int k) {
		// Base condition
		if (root == null)
			return;

		getKthSmallestValue(root.getLeftChild(), k); // first traverse the
														// left
														// sub // tree
		if (++index == k) {
			System.out.println(root.getData());
			return;
		}
		getKthSmallestValue(root.getRightChild(), k); // then traverse the right
														// sub tree
	}
}
