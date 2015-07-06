package com.interview.algorithms.linkedlist;

import com.example.datastructures.node.Node;

/**
 * Given a singly linked list, write a function to swap elements pairwise. For
 * example, if the linked list is 1->2->3->4->5 then the function should change
 * it to 2->1->4->3->5, and if the linked list is 1->2->3->4->5->6 then the
 * function should change it to 2->1->4->3->6->5.
 * 
 * @author ajitkoti
 * 
 */
public class PairwiseSwapElementsOfAGivenLinkedList {

	private static void checkAndDoPairWiseSwap(Node head) {
		/* There must be at-least two nodes in the list */
		if (head != null && head.getNextNode() != null) {
			pairWiseSwap(head);
		}

	}

	/**
	 * If there are 2 or more than 2 nodes in Linked List then swap the first
	 * two nodes and recursively call for rest of the list.
	 * 
	 * @param head
	 */
	private static void pairWiseSwap(Node head) {

		if (head != null && head.getNextNode() != null) {
			/* Swap the node's data with data of next node */
			int temp = head.getData();
			head.setData(head.getNextNode().getData());
			head.getNextNode().setData(temp);

			/* Call pairWiseSwap() for rest of the list */
			pairWiseSwap(head.getNextNode().getNextNode());
		}
	}

	private static void swap(int data, int data2) {

	}
}
