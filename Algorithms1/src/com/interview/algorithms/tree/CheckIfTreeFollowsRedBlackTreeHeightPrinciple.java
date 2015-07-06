package com.interview.algorithms.tree;

import com.example.datastructures.node.BinaryNode;

/**
 * Check if a given Binary Tree is height balanced like a Red-Black Tree
 * http://www
 * .geeksforgeeks.org/check-given-binary-tree-follows-height-property-red
 * -black-tree/
 * 
 * @author ajitkoti
 *
 */
public class CheckIfTreeFollowsRedBlackTreeHeightPrinciple {

	/**
	 * In a Red-Black Tree, the maximum height of a node is at most twice the
	 * minimum height (The four Red-Black tree properties make sure this is
	 * always followed). Given a Binary Search Tree, we need to check for
	 * following property.
	 * 
	 * @param root
	 * @param maxh
	 * @param minh
	 * @return
	 */
	public static boolean isBalanced(BinaryNode root, int maxh, int minh) {
		// Base case
		if (root == null) {
			maxh = minh = 0;
			return true;
		}

		int lmxh = 0, lmnh = 0; // To store max and min heights of left subtree
		int rmxh = 0, rmnh = 0; // To store max and min heights of right subtree

		// Check if left subtree is balanced, also set lmxh and lmnh
		if (isBalanced(root.getLeftChild(), lmxh, lmnh) == false)
			return false;

		// Check if right subtree is balanced, also set rmxh and rmnh
		if (isBalanced(root.getRightChild(), rmxh, rmnh) == false)
			return false;

		// Set the max and min heights of this node for the parent call
		maxh = Math.max(lmxh, rmxh) + 1;
		minh = Math.min(lmnh, rmnh) + 1;

		// See if this node is balanced
		if (maxh <= 2 * minh)
			return true;

		return false;

	}

}
