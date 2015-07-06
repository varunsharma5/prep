package com.interview.algorithms.tree;

import com.example.datastructures.node.BinaryNode;

/**
 * 
 * 
 * @author ajitkoti
 * 
 */
public class MaxDeptOfATree {

	public static int maxDepth(BinaryNode root) {
		if (root == null) {
			return 0;
		}

		return 1 + Math.max(maxDepth(root.getLeftChild()),maxDepth(root.getRightChild()));
	}

}
