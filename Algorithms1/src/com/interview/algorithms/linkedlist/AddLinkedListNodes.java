package com.interview.algorithms.linkedlist;

import com.example.datastructures.node.Node;

/**
 * 
 * You have two numbers represented by a linked list, where each node contains a
 * single digit. The digits are stored in reverse order, such that the 1’s digit
 * is at the head of the list. Write a function that adds the two numbers and
 * returns the sum as a linked list. EXAMPLE Input: (3 -> 1 -> 5),(5 -> 9 ->2) Output: 8 -> 0 -> 8 
 * 513+295=808
 * 
 * @author ajitkoti
 *
 */
public class AddLinkedListNodes {

	public static void main(String[] args) {

	}

	/**
	 * We can implement this recursively by adding node by node, just as we would digit by digit. 
	 * 1. result.data = (node1 + node2 + any earlier carry) % 10 
	 * 2. if node1 + node2 > 10, then carry a 1 to the next addition.
	 * 3. add the tails of the two nodes, passing along the carry.
	 * 
	 * @param l1
	 * @param l2
	 * @param carry
	 * @return
	 */
	Node addLists(Node l1, Node l2, int carry) {
		if (l1 == null && l2 == null) {
			return null;
		}

		Node result = new Node(carry, null);
		int value = carry;

		if (l1 != null) {
			value += l1.getData();
		}

		if (l2 != null) {
			value += l2.getData();
		}

		result.setData(value % 10);
		Node more = addLists( l1.getNextNode(), l2.getNextNode(), value > 10 ? 1 : 0);

		result.setNextNode(more);
		return result;
	}

}
