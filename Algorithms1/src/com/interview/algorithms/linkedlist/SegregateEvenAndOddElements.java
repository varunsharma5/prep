package com.interview.algorithms.linkedlist;

import com.example.datastructures.node.Node;

/**
 * Given a Linked List of integers, write a function to modify the linked list
 * such that all even numbers appear before all the odd numbers in the modified
 * linked list. Also, keep the order of even and odd numbers same.
 * 
 * Examples: Input: 17->15->8->12->10->5->4->1->7->6->NULL Output:
 * 8->12->10->4->6->17->15->5->1->7->NULL
 * 
 * The idea is to get pointer to the last node of list. And then traverse the
 * list starting from the head node and move the odd valued nodes from their
 * current position to end of the list.
 * 
 * 
 * Algorithm: 
 * …1) Get pointer to the last node. 
 * …2) Move all the odd nodes to the end.
 *  ……..a) Consider all odd nodes before the first even node and move them to end.
 *  ……..b) Change the head pointer to point to the first even node.
 *  ……..c) Consider all odd nodes after the first even node and move them to the end.
 * 
 * 
 * http://www.geeksforgeeks.org/segregate-even-and-odd-elements-in-a-linked-list
 * 
 * @author ajitkoti
 * 
 */
public class SegregateEvenAndOddElements {

	void segregateEvenOdd(Node head) {
		Node end = head;
		Node prev = null;
		Node curr = head;

		/* Get pointer to the last node */
		while (end.getNextNode() != null){
			end = end.getNextNode();
		}
		
		Node new_end = end;

		/*
		 * Consider all odd nodes before the first even node and move then after
		 * end
		 */
		while (curr.getData() % 2 != 0 && curr != end) {
			new_end.setNextNode(curr);
			curr = curr.getNextNode();
			new_end.getNextNode().setNextNode(null); // this is not required check
			new_end = new_end.getNextNode();
		}

		// 10->8->17->17->15
		/* Do following steps only if there is any even node */
		if (curr.getData() % 2 == 0) {
			/* Change the head pointer to point to first even node */
			head = curr;

			/* now current points to the first even node */
			while (curr != end) {
				if ((curr.getData()) % 2 == 0) {
					prev = curr;
					curr = curr.getNextNode();
				} else { // when its odd 
					/* break the link between prev and current */
					prev.setNextNode(curr.getNextNode());

					/* Make next of curr as null */
					curr.setNextNode(null);

					/* Move curr to end */
					new_end.setNextNode(curr);

					/* make curr as new end of list */
					new_end = curr;

					/* Update current pointer to next of the moved node */
					curr = prev.getNextNode();
				}
			}
		}

		/*
		 * We must have prev set before executing lines following this statement
		 */
		else
			prev = curr;

		/*
		 * If there are more than 1 odd nodes and end of original list is odd
		 * then move this node to end to maintain same order of odd numbers in
		 * modified list
		 */
		if (new_end != end && (end.getData()) % 2 != 0) {
			prev.setNextNode(end.getNextNode());
			end.setNextNode(null);
			new_end.setNextNode(end);
		}
		return;
	}

}
