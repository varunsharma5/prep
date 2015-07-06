package com.interview.algorithms.tree;

import com.example.datastructures.node.BinaryNode;

/**
 * Given the root of the binary tree and a pointer to any random node in that
 * tree, the objective is to print all the nodes at ‘k’ distance from the given
 * random node.
 * http://sundaycomputing.blogspot.in/2012/03/find-nodes-in-binary-tree
 * -at-distance-k.html
 * 
 * @author ajitkoti
 *
 */
public class FindNodesInTreeAtDistanceKFromANode {

	/**
	 * Given Node root, Node n, and int k, find all nodes in binary tree which
	 * are at a distance of k from the node.
	 * 
	 * @param root
	 * @param randomNode
	 * @param k
	 * @return
	 */
	public static int function(BinaryNode root, BinaryNode randomNode, int k) {

		if (root == null)
			return 0;
		
		// If node is found,then find nodes at a distance of k in the tree rooted at the node.
		if (root == randomNode) {
			find_kth(root.getRightChild(), k);
			find_kth(root.getLeftChild(), k);
			return 1; // return 1 so that current’s parent knows that it is at a distance 1 from randomNode;
		}

		// the function returns what’s the distance of the randomNode
		// from current node in current’s left sub tree.
		int left_count = function(root.getLeftChild(), randomNode, k);

		int right_count = function(root.getRightChild(), randomNode, k);

		if (left_count > 0) {
			if (left_count < k) {
				find_kth(root.getRightChild(), k - left_count);
				return left_count++;
				// this is so that the current node knows what's the distance of
				// Node*n in its left sub tree
			}
		}
		if (right_count > 0) {
			if (right_count < k) {
				find_kth(root.getLeftChild(), k - right_count);
				return right_count++;
			}
		}
		return -1;
	}

	// Helper Function - finds node at distance k from the root.

	public static void find_kth(BinaryNode root, int k) {
		if (root == null)
			return;
		if (k == 0)
			System.out.println(root.getData());
		else {
			find_kth(root.getLeftChild(), k - 1);
			find_kth(root.getRightChild(), k - 1);
		}
	}

}
