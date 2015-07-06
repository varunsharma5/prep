package com.interview.algorithms.tree;

import com.example.datastructures.node.BinaryNode;

/**
 * A binary search tree (BST) is a node based binary tree data structure which
 * has the following properties. • The left subtree of a node contains only
 * nodes with keys less than the node’s key. • The right subtree of a node
 * contains only nodes with keys greater than the node’s key. • Both the left
 * and right subtrees must also be binary search trees.
 * 
 * http://www.geeksforgeeks.org/a-program-to-check-if-a-binary-tree-is-bst-or-not/
 * 
 * @author ajitkoti
 * 
 */
public class IsThisTreeABST {

	public void isValid(BinaryNode root) {
		// Method one
		isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);

		// Method two
		isValidBST(root, root);
	}

	/**
	 * The method traverses down the tree keeping track of the narrowing min and
	 * max allowed values as it goes, looking at each node only once. The
	 * initial values for min and max should be INT_MIN and INT_MAX — they
	 * narrow from there.
	 * 
	 * Time Complexity: O(n) Auxiliary Space : O(1) if Function Call Stack size
	 * is not considered, otherwise O(n)
	 * 
	 * @param node
	 * @param MIN
	 * @param MAX
	 * @return
	 */
	private boolean isValidBST(BinaryNode node, int MIN, int MAX) {
		if (node == null)
			return true;
		if (node.getData() > MIN && node.getData() < MAX
				&& isValidBST(node.getLeftChild(), MIN, node.getData() - 1)
				&& isValidBST(node.getRightChild(), node.getData() + 1, MAX))
			return true;
		else
			return false;
	}

	/**
	 * While doing In-Order traversal, we can keep track of previously visited
	 * node. If the value of the currently visited node is less than the
	 * previous value, then tree is not BST.
	 * 
	 * @param root
	 * @param prev
	 * @return
	 */
	private boolean isValidBST(BinaryNode root, BinaryNode prev) {
		if (root == null)
			return true;

		// traverse the tree in inorder fashion and keep track of prev node
		if (!isValidBST(root.getLeftChild(), prev))
			return false;

		// Allows only distinct valued nodes
		if (prev != null && root.getData() <= prev.getData())
			return false;

		prev = root;

		return isValidBST(root.getRightChild(), prev);

	}

}
