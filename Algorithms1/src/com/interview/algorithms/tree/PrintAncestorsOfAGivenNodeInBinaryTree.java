package com.interview.algorithms.tree;

import com.example.datastructures.node.BinaryNode;

/**
 * Given a Binary Tree and a key, write a function that prints all the ancestors of the key in the given binary tree.
 * http://www.geeksforgeeks.org/print-ancestors-of-a-given-node-in-binary-tree/
 * 
 * @author ajitkoti
 * 
 */
public class PrintAncestorsOfAGivenNodeInBinaryTree {

	/*
	 * If target is present in tree, then prints the ancestors and returns true,
	 * otherwise returns false.
	 */
	boolean printAncestors(BinaryNode root, int target) {
		/* base cases */
		if (root == null)
			return false;

		if (root.getData() == target)
			return true;

		/*
		 * If target is present in either left or right subtree of this node,
		 * then print this node
		 */
		if (printAncestors(root.getLeftChild(), target)
				|| printAncestors(root.getRightChild(), target)) {
			System.out.println(root.getData());
			return true;
		}

		/* Else return false */
		return false;
	}

}
	