package com.interview.algorithms.linkedlist;

import com.example.datastructures.LinkedList;
import com.example.datastructures.node.Node;

/**
 * Write a function to get the intersection point of two Linked Lists.
 * 
 * There are two singly linked lists in a system. By some programming error the
 * end node of one of the linked list got linked into the second list, forming a
 * inverted Y shaped list. Write a program to get the point where two linked
 * list merge.
 * 
 * http://www.geeksforgeeks.org/write-a-function-to-get-the-intersection-point-
 * of-two-linked-lists/
 * 
 * @author ajitkoti
 *
 */
public class FindIntersectionPointOfTwoLinkedLists {

	/**
	 * (Using difference of node counts) 
	 * 1) Get count of the nodes in first list, let count be c1.
	 * 
	 * 2) Get count of the nodes in second list, let count be c2. 
	 * 
	 * 3) Get the difference of counts d = (c1 – c2) 
	 * 
	 * 4) Now traverse the bigger list from the first node till d nodes so that from
	 * here onwards both the lists have equal no of nodes.

       5) Then we can traverse both the lists in parallel till we come across a common node.
	 * 
	 * (Note that getting a common node is done by comparing the address of the
	 * nodes)
	 */
	private static Node getIntersectionNodes(LinkedList list1, LinkedList list2) {
		Node intersectingNode = null;
		int list1Count = getLinkedListCount(list1);
		int list2Count = getLinkedListCount(list1);
		int diff;
		if (list1Count == 0 || list2Count == 0)
			return null;

		if (list1Count > list2Count) {
			diff = list1Count - list2Count;
			intersectingNode = getIntersectionNode(diff, list1.getRootNode(),
					list2.getRootNode());
		} else if (list2Count > list1Count) {
			diff = list2Count - list1Count;
			intersectingNode = getIntersectionNode(diff, list2.getRootNode(),
					list1.getRootNode());
		}

		return intersectingNode;

	}

	private static Node getIntersectionNode(int diff, Node head1, Node head2) {
		Node currentNode1 = head1;
		Node currentNode2 = head2;
		while (diff < 0) {
			if (currentNode1 == null) {
				return null;
			}
			currentNode1 = currentNode1.getNextNode();
			diff--;
		}

		while (currentNode1 != null && currentNode2 != null) {
			if (currentNode1 == currentNode2)
				return currentNode1;
			currentNode1 = currentNode1.getNextNode();
			currentNode2 = currentNode1.getNextNode();
		}

		return null;

	}

	private static int getLinkedListCount(LinkedList list) {
		int count = 0;
		Node currentNode = list.getRootNode();
		while (currentNode.getNextNode() != null){
			count++;
		currentNode = currentNode.getNextNode();
		}

		return count++;
	}

	public static void main(String[] args) {

	}

}
