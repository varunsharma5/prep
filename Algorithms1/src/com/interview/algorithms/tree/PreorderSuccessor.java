package com.interview.algorithms.tree;

import com.example.datastructures.node.BinaryNode;

/**
 * Please find the algorithm herein below:
 * 
 * if given node is not present, return null if node has left child, return left
 * child if node has right child, return right child return right child of the
 * closest ancestor whose right child is present and not yet processed
 * 
 * @author ajitkoti
 *
 */
public class PreorderSuccessor {

	public static BinaryNode getPreorderSuccessor(BinaryNode root, int val) {
		if (root == null || (root.getLeftChild() == null && root.getRightChild() == null))
			return null;
		BinaryNode temp = root;
		BinaryNode ancestor = null;
		while (temp != null && temp.getData() != val) {
			if (val < temp.getData()) {
				if (temp.getRightChild() != null) {
					ancestor = temp;
				}
				temp = temp.getLeftChild();
			} else {
				temp = temp.getRightChild();
			}
		}
		// node not found case
		if (temp == null)
			return null;
		if (temp.getLeftChild() != null)
			return temp.getLeftChild();
		if (temp.getRightChild() != null)
			return temp.getRightChild();
		if (ancestor != null)
			return ancestor.getRightChild();
		return null;
	}

}
