package com.interview.algorithms.linkedlist;

import com.example.datastructures.node.Node;

/**
 * Given a circular linked list, implement an algorithm which returns node at
 * the begin- ning of the loop. DEFINITION Circular linked list: A (corrupt)
 * linked list in which a node’s getNextNode() pointer points to an earlier
 * node, so as to make a loop in the linked list.
 * 
 * EXAMPLE Input: A -> B -> C -> D -> E -> C [the same C as earlier] Output: C
 * 
 * http://umairsaeed.com/2011/06/23/finding-the-start-of-a-loop-in-a-circular-
 * linked-list/
 * 
 * @author ajitkoti
 *
 */
public class FindLoopInLinkedList {
	public static void main(String[] args) {

	}

	Node FindBeginning(Node root) {
		Node behind = root;
		Node forward = root;

		// Find meeting point

		while (forward.getNextNode() != null) {
			behind = behind.getNextNode();
			forward = forward.getNextNode().getNextNode();

			if (behind == forward) { 
				break;// both meet at same point  break;
			}

		}

		// Error check - there is no meeting point, and therefore no loop
		if (forward.getNextNode() == null) {
			return null;
		}

		/*
		 * Move behind to Head. Keep forward at Meeting Point. Each are k steps	 
		 * from the Loop Start. If they move at the same pace, they must 
		 * meet at Loop Start.
		 */

		behind = root;

		while (behind != forward) {
			behind = behind.getNextNode();
			forward = forward.getNextNode();
		}

		// Now forward points to the start of the loop.
		return forward;
	}

}
