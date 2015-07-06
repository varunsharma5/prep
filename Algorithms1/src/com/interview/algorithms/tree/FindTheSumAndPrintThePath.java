package com.interview.algorithms.tree;

import java.util.ArrayList;

import com.example.datastructures.node.BinaryNode;

/**
 * You are given a binary tree in which each node contains a value. Design an
 * algorithm to print all paths which sum up to that value. Note that it can be
 * any path in the tree - it does not have to start at the root.
 * 
 * @author ajitkoti
 * 
 */
public class FindTheSumAndPrintThePath {
	/*
	 * This function prints all nodes that are distance k from a leaf node
	 * path[] --> Store ancestors of a node visited[] --> Stores true if a node
	 * is printed as output. A node may be k distance away from many leaves, we
	 * want to print it once
	 */
	private static void hasPathSumTillLeafGotSum(BinaryNode node, int sum, int[] path,
			int pathLen) {
		// Base case
		if (node == null)
			return;

		int subSum = sum - node.getData();
		path[pathLen] = node.getData();
		pathLen++;
		/*
		 * it's a leaf, so print the ancestor at distance k only if the ancestor
		 * is not already printed
		 */
		if (node.getLeftChild() == null && node.getRightChild() == null
				&& subSum == 0) {
			printArray(path, pathLen);
		}

		/* If not leaf node, recur for left and right subtrees */
		hasPathSumTillLeafGotSum(node.getLeftChild(), sum, path, pathLen);
		hasPathSumTillLeafGotSum(node.getRightChild(), sum, path, pathLen);
	}

	/*
	 * Given a binary tree and a nuber k, print all nodes that are k distant
	 * from a leaf
	 */
	private static void hasPathSumTillLeafGotSum(BinaryNode node) {
		int[] path = new int[100];
		hasPathSumTillLeafGotSum(node, 10, path, 0);
	}

	/* UTILITY FUNCTIONS */
	/* Utility that prints out an array on a line. */
	private static  void printArray(int ints[], int len) {
		int i;
		for (i = 0; i < len; i++) {
			System.out.println(ints[i] + ",");
		}

	}

}
