package com.interview.algorithms.linkedlist;

import com.example.datastructures.node.Node;
/**
 * Implement an algorithm to find the nth to last element of a singly linked list.
 * @author ajitkoti
 *
 */
public class FindNthLastElementinLinkedList {

	/*
	 * Algorithm: 
	 *  1. Create two pointers, nthNode and forward, that point to the beginning
	 * of the node.
	 *  2. Increment forward by n-1 positions, to make it point to the
	 * nth node from the beginning (to make the distance of n between nthNode and
	 * forward).
	 *  3. Check for forward->next == null if yes return value of nthNode, otherwise
	 * increment nthNode and forward. If next of forward is null it means nthNode points to the nth
	 * node from the last as the distance between the two is n.
	 *  4. Repeat Step  3.
	 */
	Node nthToLast(Node root, int n) {
		if (root == null || n < 1) {
			return null;
		}

		Node nthNode = root;
		Node forward = root;

		for (int j = 0; j < n - 1; ++j) {// skip n-1 steps ahead
			if (forward == null) {
				return null; // not found since list size < n
			}

			forward = forward.getNextNode();
		}

		while (forward.getNextNode() != null) {
			nthNode = nthNode.getNextNode();
			forward = forward.getNextNode();
		}
		return nthNode;
	}
}
