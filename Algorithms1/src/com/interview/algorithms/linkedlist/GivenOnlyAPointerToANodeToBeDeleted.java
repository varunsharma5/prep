package com.interview.algorithms.linkedlist;

import com.example.datastructures.node.Node;

/**
 * Given only a pointer to a node to be deleted in a singly linked list, how do
 * you delete it? Solution is to copy the data from the next node to the node to
 * be deleted and delete the next node.
 * 
 * http://www.geeksforgeeks.org/in-a-linked-list-given-only-a-pointer-to-a-node-
 * to-be-deleted-in-a-singly-linked-list-how-do-you-delete-it/
 * 
 * @author ajitkoti
 * 
 */
public class GivenOnlyAPointerToANodeToBeDeleted {

	private static void deleteNode(Node toBeDeleted) {
		Node nextNode = toBeDeleted.getNextNode();
		toBeDeleted.setData(nextNode.getData());
		toBeDeleted.setNextNode(nextNode.getNextNode());

	}

}
