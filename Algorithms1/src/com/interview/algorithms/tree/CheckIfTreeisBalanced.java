package com.interview.algorithms.tree;

import com.example.datastructures.node.BinaryNode;

/**
 * Implement a function to check if a tree is balanced. For the purposes of this
 * question, a balanced tree is defined to be a tree such that no two leaf nodes
 * differ in distance from the root by more than one.
 * 
 * http://stackoverflow.com/questions/8015630/definition-of-a-balanced-tree
 * 
 * @author ajitkoti
 *
 */
public class CheckIfTreeisBalanced {

	/**
	 * The idea is very simple: the difference of min depth and max depth should
	 * not exceed 1, since the difference of the min and the max depth is the
	 * maximum distance difference pos- sible in the tree.
	 * 
	 * @param root
	 * @return
	 */
	public static int maxDepth(BinaryNode root) {
		if (root == null) {
			return 0;
		}

		return 1 + Math.max(maxDepth(root.getLeftChild()), maxDepth(root.getRightChild()));
	}

	public static int minDepth(BinaryNode root) {
		if (root == null) {
			return 0;
		}

		return 1 + Math.min(minDepth(root.getLeftChild()), minDepth(root.getRightChild()));
	}

	public static boolean isBalanced(BinaryNode root) {
		return (maxDepth(root) - minDepth(root) <= 1);
	}

}
