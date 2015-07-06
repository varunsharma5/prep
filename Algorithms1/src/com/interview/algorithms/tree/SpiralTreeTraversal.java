package com.interview.algorithms.tree;

import com.example.datastructures.node.BinaryNode;

/**
 * 
 * http://www.geeksforgeeks.org/level-order-traversal-in-spiral-form/
 * 
 * @author ajitkoti
 * 
 */
public class SpiralTreeTraversal {

	/* Function to print level order traversal a tree */
	void printLevelOrder(BinaryNode root) {
		boolean leftToRight = false;
		int h = height(root);
		int i;
		for (i = 1; i <= h; i++) {
			printGivenLevel(root, i, leftToRight);
			/* Revert ltr to traverse next level in oppposite order */
			leftToRight = !leftToRight;
		}
	}

	/* Print nodes at a given level */
	void printGivenLevel(BinaryNode root, int level, boolean leftToRight) {
		if (root == null)
			return;
		if (level == 1)
			System.out.println(root.getData() + ",");
		else if (level > 1) {
			if (leftToRight) {
				printGivenLevel(root.getLeftChild(), level - 1, leftToRight);
				printGivenLevel(root.getRightChild(), level - 1, leftToRight);
			} else {
				printGivenLevel(root.getRightChild(), level - 1, leftToRight);
				printGivenLevel(root.getLeftChild(), level - 1, leftToRight);
				
			}
		}
	}

	/*
	 * Compute the "height" of a tree -- the number of nodes along the longest
	 * path from the root node down to the farthest leaf node.
	 */
	int height(BinaryNode root) {
		if(root == null )
	       return 0;
	   return 1+Math.max(height(root.getLeftChild()), height(root.getRightChild()));
	   }

}
