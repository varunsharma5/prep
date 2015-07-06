package com.interview.algorithms.tree;

import com.example.datastructures.node.BinaryNode;

public class AreTwoTreesIdentical {

	/*
	 * Given two trees, return true if they are structurally identical
	 */
	boolean identicalTrees(BinaryNode a, BinaryNode b) {
		/* 1. both empty */
		if (a == null && b == null)
			return true;

		/* 2. both non-empty -> compare them */
		if (a != null && b != null) {
			return ((a.getData() == b.getData())
					&& identicalTrees(a.getLeftChild(), b.getLeftChild()) && identicalTrees(
					a.getRightChild(), b.getRightChild()));
		}

		/* 3. one empty, one not -> false */
		return false;
	}

}
