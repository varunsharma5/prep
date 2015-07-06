package com.interview.algorithms.tree;

import com.example.datastructures.node.BinaryNode;

/**
 * Given a Binary Tree, print left view of it. Left view of a Binary Tree is set
 * of nodes visible when tree is visited from left side.
 * 
 * The left view contains all nodes that are first nodes in their levels. A
 * simple solution is to do level order traversal and print the first node in
 * every level.
 * 
 * The problem can also be solved using simple recursive traversal. We can keep
 * track of level of a node by passing a parameter to all recursive calls. The
 * idea is to keep track of maximum level also. Whenever we see a node whose
 * level is more than maximum level so far, we print the node because this is
 * the first node in its level (Note that we traverse the left subtree before
 * right subtree).
 * 
 *  http://www.geeksforgeeks.org/print-left-view-binary-tree/
 * 
 * @author ajitkoti
 *
 */
public class PrintLeftAndRightViewOfBinaryTree {

	// Recursive function to print left view of a binary tree.
	private static void leftViewUtil(BinaryNode root, int level, int max_level) {
		// Base Case
		if (root == null)
			return;

		// If this is the first node of its level
		if (max_level < level) {
			System.out.println(root.getData());
			max_level = level;
		}

		// Recur for left and right subtrees
		leftViewUtil(root.getLeftChild(), level + 1, max_level);
		leftViewUtil(root.getRightChild(), level + 1, max_level);
	}

	// A wrapper over leftViewUtil()
	public static void leftView(BinaryNode root) {
		int max_level = 0;
		leftViewUtil(root, 1, max_level);
	}
	
	
	// Recursive function to print left view of a binary tree.
		private static void RightViewUtil(BinaryNode root, int level, int max_level) {
			// Base Case
			if (root == null)
				return;

			// If this is the first node of its level
			if (max_level < level) {
				System.out.println(root.getData());
				max_level = level;
			}

			// Recur for left and right subtrees
			RightViewUtil(root.getRightChild(), level + 1, max_level);
			RightViewUtil(root.getLeftChild(), level + 1, max_level);
			 
		}

		// A wrapper over leftViewUtil()
		public static void  RightView(BinaryNode root) {
			int max_level = 0;
			 RightViewUtil(root, 1, max_level);
		}


}
