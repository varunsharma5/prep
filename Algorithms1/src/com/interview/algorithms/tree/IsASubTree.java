/**
 * 
 */
package com.interview.algorithms.tree;

import com.example.datastructures.node.BinaryNode;

/**
 * You have two very large binary trees: T1, with millions of nodes, and T2,
 * with hun- dreds of nodes. Create an algorithm to decide if T2 is a subtree of
 * T1.
 * 
 * @author ajitkoti
 *
 */
public class IsASubTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}

	private static boolean containsTree(BinaryNode t1, BinaryNode t2) {
		if (t2 == null)
			return true; // The empty tree is always a subtree
		else
			return subTree(t1, t2);
	}

	private static boolean subTree(BinaryNode r1, BinaryNode r2) {
		if (r1 == null)
			return false; // big tree empty & subtree still not found.

		if (r1.getData() == r2.getData()) {
			if (matchTree(r1, r2))
				return true;
		}

		return (subTree(r1.getLeftChild(), r2) || subTree(r1.getRightChild(), r2));
	}

	/**
	 * The treeMatch procedure visits each node in the small tree at most once
	 * and is called no more than once per node of the large tree. Worst case
	 * runtime is at most O(n * m), where n and m are the sizes of trees T1 and
	 * T2, respectively. If k is the number of occurrences of T2’s root in T1,
	 * the worst case runtime can be characterized as O(n + k * m
	 * 
	 * @param r1
	 * @param r2
	 * @return
	 */
	private static boolean matchTree(BinaryNode r1, BinaryNode r2) {
		if (r2 == null && r1 == null)
			return true; // nothing left in the subtree

		if (r1 == null || r2 == null)
			return false; // big tree empty & subtree still not found

		if (r1.getData() != r2.getData())
			return false; // data doesn't match

		return (matchTree(r1.getLeftChild(), r2.getLeftChild()) &&	matchTree(r1.getRightChild(), r2.getRightChild()));

	}
}
