package com.interview.algorithms.tree;

import com.example.datastructures.node.BinaryNode;

/**
 * Given a sorted (increasing order) array, write an algorithm to create a
 * binary tree with minimal height
 * 
 * @author ajitkoti
 *
 */
public class SortedArrayIntoBinaryTree {

	public static void main(String[] args) {

	}

	public static BinaryNode createMinimalBST(int array[]) {
		return addToTree(array, 0, array.length - 1);
	}

	/**
	 * We will try to create a binary tree such that for each node, the number
	 * of nodes in the left subtree and the right subtree are equal, if
	 * possible. Algorithm: 
	 * 1. Insert into the tree the middle element of the
	 * array. 
	 * 
	 * 2. Insert (into the left subtree) the left subarray elements 
	 * 
	 * 3.Insert (into the right subtree) the right subarray elements 
	 * 
	 * 4. Recurse
	 * 
	 * @param arr
	 * @param start
	 * @param end
	 * @return
	 */
	public static BinaryNode addToTree(int arr[], int start, int end) {
		if (end < start) {
			return null;
		}

		int mid = (start + end) / 2;

		BinaryNode node = new BinaryNode(arr[mid]);
		node.setLeftChild(addToTree(arr, start, mid - 1));
		node.setRightChild(addToTree(arr, mid + 1, end));

		return node;
	}

}
