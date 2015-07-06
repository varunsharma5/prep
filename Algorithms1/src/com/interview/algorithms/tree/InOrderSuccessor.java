package com.interview.algorithms.tree;

import com.example.datastructures.node.BinaryNode;

/**
 * http://www.geeksforgeeks.org/inorder-successor-in-binary-search-tree/
 * 
 * @author ajitkoti
 * 
 */
public class InOrderSuccessor {

	public static void main(String[] args) {

	}

	/**
	 * The Algorithm is divided into two cases on the basis of right subtree of
	 * the input node being empty or not.
	 * 
	 * Input: node, root node is the node whose Inorder successor is needed.
	 * output:succ is Inorder successor of node.
	 * 
	 * 1) If right subtree of node is not NULL, then succ lies in right subtree.
	 * Do following. Go to right subtree and return the node with minimum key
	 * value in right subtree.
	 * 
	 * 2) If right subtree of node is NULL, then start from root and use search
	 * like technique. Do following. Travel down the tree, if a node’s data is
	 * greater than root’s data then go right side, otherwise go to left side.
	 * 
	 * @param currentNode
	 * @param parentNode
	 * @return
	 */
	public static BinaryNode inorderSucc(BinaryNode currentNode, BinaryNode root) {
		// step 1 of the above algorithm
		if (currentNode.hasrightChild())
			return leftMostChild(currentNode.getRightChild());

		BinaryNode succ = null;

		// Start from root and search for successor down the tree
		while (root != null) {
			if (currentNode.getData() < root.getData()) {
				succ = root;
				root = root.getLeftChild();
			} else if (currentNode.getData() > root.getData())
				root = root.getRightChild();
			else
				break;
		}

		return succ;
	}

	public static BinaryNode leftMostChild(BinaryNode e) {
		if (e == null)
			return null;

		while (e.getLeftChild() != null)
			e = e.getLeftChild();

		return e;
	}

}
