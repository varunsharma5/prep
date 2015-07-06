package com.interview.algorithms.tree;

import com.example.datastructures.node.BinaryNode;

/**
 * Design an algorithm and write code to find the first common ancestor of two
 * nodes in a binary tree. Avoid storing additional nodes in a data structure.
 * 
 * http://www.geeksforgeeks.org/lowest-common-ancestor-in-a-binary-search-tree/
 * 
 * @author ajitkoti
 * 
 */
public class LeastCommonAncestor {
	public static void main(String[] args) {

	}

	/**
	 * We can recursively traverse the BST from root. The main idea of the
	 * solution is, while traversing from top to bottom, the first node n we
	 * encounter with value between n1 and n2, i.e., n1 < n < n2 or same as one
	 * of the n1 or n2, is LCA of n1 and n2 (assuming that n1 < n2). So just
	 * recursively traverse the BST in, if node's value is greater than both n1
	 * and n2 then our LCA lies in left side of the node, if it's is smaller
	 * than both n1 and n2, then LCA lies on right side. Otherwise root is LCA
	 * (assuming that both n1 and n2 are present in BST)
	 * 
	 * You could follow a chain in which p and q are on the same side. That is,
	 * if p and q are both on the left of the node, branch left to look for the
	 * common ancestor. When p and q are no longer on the same side, you must
	 * have found the first common ancestor
	 * 
	 * @param root
	 * @param p
	 * @param q
	 * @return
	 */
	public BinaryNode commonAncestor(BinaryNode root, BinaryNode p, BinaryNode q) {

		if (covers(root.getLeftChild(), p) && covers(root.getLeftChild(), q))
			return commonAncestor(root.getLeftChild(), p, q);

		if (covers(root.getRightChild(), p) && covers(root.getRightChild(), q))
			return commonAncestor(root.getRightChild(), p, q);

		return root;
	}

	private boolean covers(BinaryNode root, BinaryNode p) { // is p a child of root?
		if (root == null)
			return false;

		if (root == p)
			return true;

		return covers(root.getLeftChild(), p) || covers(root.getRightChild(), p);
	}

}
