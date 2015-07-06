package com.interview.algorithms.linkedlist;

import com.example.datastructures.node.Node;

/**
 * Given a singly linked list, rotate the linked list counter-clockwise by k
 * nodes. Where k is a given positive integer. For example, if the given linked
 * list is 10->20->30->40->50->60 and k is 4, the list should be modified to
 * 50->60->10->20->30->40. Assume that k is smaller than the count of nodes in
 * linked list.
 * 
 * To rotate the linked list, we need to change next of kth node to null, next
 * of last node to previous head node, and finally change head to (k+1)th node.
 * So we need to get hold of three nodes: kth node, (k+1)th node and last node.
 * Traverse the list from beginning and stop at kth node. Store pointer to kth
 * node. We can get (k+1)th node using kthNode.getNextNode(). Keep traversing
 * till end and store pointer to last node also. Finally, change pointers as
 * stated above.
 * 
 * http://www.geeksforgeeks.org/rotate-a-linked-list/
 * 
 * @author ajitkoti
 * 
 */
public class RotateALinkedList {

	/**
	 * 
	 * @param head
	 * @param k nodes to be rotated
	 */
	private static void rotate(Node head, int k) {
		if (k == 0)
			return;

		// Let us understand the below code for example k = 4 and
		// list = 10->20->30->40->50->60.
		Node current = head;

		// current will either point to kth or null after this loop.
		// current will point to node 40 in the above example
		int count = 1;
		while (count < k && current != null) {
			current = current.getNextNode();
			count++;
		}

		// If current is null, k is greater than or equal to count
		// of nodes in linked list. Don't change the list in this case
		if (current == null)
			return;

		// current points to kth node. Store it in a variable.
		// kthNode points to node 40 in the above example
		Node kthNode = current;

		// current will point to last node after this loop
		// current will point to node 60 in the above example
		while (current.getNextNode() != null)
			current = current.getNextNode();

		// Change next of last node to previous head
		// Next of 60 is now changed to node 10
		current.setNextNode(head);

		// Change head to (k+1)th node
		// head is now changed to node 50
		head = kthNode.getNextNode();

		// change next of kth node to null
		// next of 40 is now null
		kthNode.setNextNode(null);
	}

}
