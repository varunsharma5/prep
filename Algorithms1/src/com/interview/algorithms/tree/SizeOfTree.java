package com.interview.algorithms.tree;

import com.example.datastructures.node.BinaryNode;

/**
 * 
 * @author ajitkoti
 * 
 */
public class SizeOfTree {

	/* Computes the number of nodes in a tree. */
	public static int size(BinaryNode node) {
		if (node == null)
			return 0;
		else
			return (size(node.getLeftChild()) + 1 + size(node.getRightChild()));
	}

}
