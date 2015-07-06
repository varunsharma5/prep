package com.interview.algorithms.tree;

import com.example.datastructures.node.BinaryNode;

/**
 * Find distance between two given keys of a Binary Tree
 * http://www.geeksforgeeks.org/find-distance-two-given-nodes/
 * 
 * @author ajitkoti
 *
 */
public class FindDistanceBtwTwoGivenKeysOfBinaryTree {

	/**
	 * The distance between two nodes can be obtained in terms of lowest common ancestor.
	 * Following is the formula.
	 * Dist(n1, n2) = Dist(root, n1) + Dist(root, n2) - 2*Dist(root, lca) 
	 * 
	 * 'n1' and 'n2' are the two given keys 'root' is root of given Binary Tree.
	 * 'lca' is lowest common ancestor of n1 and n2
	 * 
	 * @param root
	 * @param n1
	 * @param n2
	 * @return
	 */
	public int findDistance(BinaryNode root, int n1, int n2) {
		// Initialize d1 (distance of n1 from root), d2 (distance of n2 from
		// root) and dist(distance between n1 and n2)
		int d1 = -1, d2 = -1, dist = 0;
		BinaryNode lca = findDistUtil(root, n1, n2, d1, d2, dist, 1);
		// If both n1 and n2 were present in Binary Tree, return dist
		if (d1 != -1 && d2 != -1)
			return dist;

		// If n1 is ancestor of n2, consider n1 as root and find level
		// of n2 in subtree rooted with n1
		if (d1 != -1) {
			dist = findLevel(lca, n2, 0);
			return dist;
		}

		// If n2 is ancestor of n1, consider n2 as root and find level
		// of n1 in subtree rooted with n2
		if (d2 != -1) {
			dist = findLevel(lca, n1, 0);
			return dist;
		}

		return -1;

	}

	private BinaryNode findDistUtil(BinaryNode root, int n1, int n2, int d1,int d2, int dist, int lvl) {
		// Base case
		if (root == null)
			return null;

		// If either n1 or n2 matches with root's key, report
		// the presence by returning root (Note that if a key is
		// ancestor of other, then the ancestor key becomes LCA
		if (root.getData() == n1) {
			d1 = lvl;
			return root;
		}
		if (root.getData() == n2) {
			d2 = lvl;
			return root;
		}

		// Look for n1 and n2 in left and right subtrees
		BinaryNode left_lca = findDistUtil(root.getLeftChild(), n1, n2, d1, d2,dist, lvl + 1);
		BinaryNode right_lca = findDistUtil(root.getRightChild(), n1, n2, d1,d2, dist, lvl + 1);

		// If both of the above calls return Non-NULL, then one key
		// is present in once subtree and other is present in other,
		// So this node is the LCA
		if (left_lca != null && right_lca != null) {
			dist = d1 + d2 - 2 * lvl;
			return root;
		}

		// Otherwise check if left subtree or right subtree is LCA
		return (left_lca != null) ? left_lca : right_lca;
	}

	private int findLevel(BinaryNode lca, int k, int lvl) {
		// Base Case
		if (lca == null)
			return -1;

		// If key is present at root, or in left subtree or right subtree,
		// return true;
		if (lca.getData() == k)
			return lvl;

		int l = findLevel(lca.getLeftChild(), k, lvl + 1);
		return (l != -1) ? l : findLevel(lca.getRightChild(), k, lvl + 1);
	}

}
