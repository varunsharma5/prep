package com.interview.algorithms.tree;

import com.example.datastructures.Stack;
import com.example.datastructures.node.BinaryNode;

/**
 * Given a Balanced Binary Search Tree and a target sum, write a function that
 * returns true if there is a pair with sum equals to target sum, otherwise
 * return false. Expected time complexity is O(n) and only O(Logn) extra space
 * can be used. Any modification to Binary Search Tree is not allowed.
 *  Note that height of a Balanced BST is always O(Logn).
 * 
 * http://www.geeksforgeeks.org/find-a-pair-with-given-sum-in-bst/
 * 
 * @author ajitkoti
 *
 */
public class FindAPairWithGivenSumInBST {

	/**
	 * The solution discussed below takes O(n) time, O(Logn) space and doesn’t
	 * modify BST. The idea is same as finding the pair in sorted array.
	 * We traverse BST in Normal Inorder and Reverse Inorder simultaneously. In reverse inorder, we start from the
	 * rightmost node which is the maximum value node. In normal inorder, we
	 * start from the left most node which is minimum value node. We add sum of
	 * current nodes in both traversals and compare this sum with given target
	 * sum. If the sum is same as target sum, we return true. If the sum is more
	 * than target sum, we move to next node in reverse inorder traversal,
	 * otherwise we move to next node in normal inorder traversal. If any of the
	 * traversals is finished without finding a pair, we return false
	 * 
	 * @param root
	 * @param target
	 * @return
	 */
	public boolean isPairPresent(BinaryNode root, int target) {
		// Create two stacks. s1 is used for normal inorder traversal
		// and s2 is used for reverse inorder traversal
		Stack<BinaryNode> s1 = new Stack<BinaryNode>(Integer.MAX_VALUE);
		Stack<BinaryNode> s2 = new Stack<BinaryNode>(Integer.MAX_VALUE);

		// Note the sizes of stacks is MAX_SIZE, we can find the tree size and
		// fix stack size as O(Logn) for balanced trees like AVL and Red Black
		// tree. We have used MAX_SIZE to keep the code simple

		// done1, val1 and curr1 are used for normal inorder traversal using s1
		// done2, val2 and curr2 are used for reverse inorder traversal using s2
		boolean done1 = false, done2 = false;
		int val1 = 0, val2 = 0;
		BinaryNode curr1 = root, curr2 = root;

		// The loop will break when we either find a pair or one of the two
		// traversals is complete
		while (true) {
			// Find next node in normal Inorder traversal. See following post
			// http://www.geeksforgeeks.org/inorder-tree-traversal-without-recursion/
			while (!done1) {
				if (curr1 != null) {
					s1.push(curr1);
					curr1 = curr1.getLeftChild();
				} else {
					if (s1.isEmpty())
						done1 = true;
					else {
						curr1 = s1.pop();
						val1 = curr1.getData();
						curr1 = curr1.getRightChild();
						done1 = true;
					}
				}
			}

			// Find next node in REVERSE Inorder traversal. The only
			// difference between above and below loop is, in below loop
			// right subtree is traversed before left subtree
			while (!done2) {
				if (curr2 != null) {
					s2.push(curr2);
					curr2 = curr2.getRightChild();
				} else {
					if (s2.isEmpty())
						done2 = true;
					else {
						curr2 = s2.pop();
						val2 = curr2.getData();
						curr2 = curr2.getLeftChild();
						done2 = true;
					}
				}
			}

			// If we find a pair, then print the pair and return. The first
			// condition makes sure that two same values are not added
			if ((val1 != val2) && (val1 + val2) == target) {
				System.out.println("Pair Found: " + val1 + " + " + val2 + " = "
						+ target);
				return true;
			}

			// If sum of current values is smaller, then move to next node in
			// normal inorder traversal
			else if ((val1 + val2) < target)
				done1 = false;

			// If sum of current values is greater, then move to next node in
			// reverse inorder traversal
			else if ((val1 + val2) > target)
				done2 = false;

			// If any of the inorder traversals is over, then there is no pair
			// so return false
			if (val1 >= val2)
				return false;
		}
	}

}
