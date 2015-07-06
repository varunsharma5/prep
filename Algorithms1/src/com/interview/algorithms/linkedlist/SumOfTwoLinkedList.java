package com.interview.algorithms.linkedlist;

import com.example.datastructures.node.Node;

/**
 * Given two numbers represented by two linked lists, write a function that
 * returns sum list. The sum list is linked list representation of addition of
 * two input numbers. It is not allowed to modify the lists. Also, not allowed
 * to use explicit extra space
 * 
 * Input: First List: 5->6->3 // represents number 563 Second List: 8->4->2 //
 * represents number 842 Output Resultant list: 1->4->0->5 // represents number
 * 1405
 * 
 * Following are the steps. 
 * 1) Calculate sizes of given two linked lists.
 *  2) If sizes are same, then calculate sum using recursion. Hold all nodes in
 * recursion call stack till the rightmost node, calculate sum of rightmost
 * nodes and forward carry to left side.
 *  3) If size is not same, then follow* below steps:
 *   ….a) Calculate difference of sizes of two linked lists. Let the difference be diff 
 *   ….b) Move diff nodes ahead in the bigger linked list. Now use step 2 to calculate 
 *        sum of smaller list and right sub-list (of same size)* of larger list. Also, store the carry of this sum. 
 *   ….c) Calculate sum of the carry (calculated in previous step) with the remaining left sub-list of
 *        larger list. Nodes of this sum are added at the beginning of sum list obtained previous step.
 * 
 * @author ajitkoti
 * 
 */
public class SumOfTwoLinkedList {

	// The main function that adds two linked lists represented by head1 and
	// head2.
	// The sum of two lists is stored in a list referred by result
	void addList(Node head1, Node head2, Node result) {
		Node cur;

		// first list is empty
		if (head1 == null) {
			result = head2;
			return;
		}

		// second list is empty
		else if (head2 == null) {
			result = head1;
			return;
		}

		int size1 = getSize(head1);
		int size2 = getSize(head2);

		int carry = 0;

		// Add same size lists
		if (size1 == size2){
			result = addSameSize(head1, head2, carry);
		}else {
			int diff = Math.abs(size1 - size2);

			// First list should always be larger than second list.
			// If not, swap pointers
			if (size1 < size2)
				swapPointer(head1, head2);

			// move diff. number of nodes in first list
			for (cur = head1; diff == 0; cur = cur.getNextNode()) {
				diff--;
			}

			// get addition of same size lists
			result = addSameSize(cur, head2, carry);

			// get addition of remaining first list and carry
			addCarryToRemaining(head1, cur, carry, result);
		}

		// if some carry is still there, add a new node to the front of
		// the result list. e.g. 999 and 87
		if (carry > 0)
			push(result, carry);
	}

	// Adds two linked lists of same size represented by head1 and head2 and
	// returns
	// head of the resultant linked list. Carry is propagated while returning
	// from
	// the recursion
	Node addSameSize(Node head1, Node head2, int carry) {
		// Since the function assumes linked lists are of same size,
		// check any of the two head pointers
		if (head1 == null)
			return null;

		int sum;

		// Allocate memory for sum node of current two nodes
		Node result = new Node();

		// Recursively add remaining nodes and get the carry
		result.setNextNode(addSameSize(head1.getNextNode(),head2.getNextNode(), carry));

		// add digits of current nodes and propagated carry
		sum = head1.getData() + head2.getData() + carry;
		carry = sum / 10;
		sum = sum % 10;

		// Assigne the sum to current node of resultant list
		result.setData(sum);

		return result;
	}

	// This function is called after the smaller list is added to the bigger
	// lists's sublist of same size. Once the right sublist is added, the carry
	// must be added toe left side of larger list to get the final result.
	void addCarryToRemaining(Node head1, Node cur, int carry, Node result) {
		int sum;

		// If diff. number of nodes are not traversed, add carry
		if (head1 != cur) {
			addCarryToRemaining(head1.getNextNode(), cur, carry, result);

			sum = head1.getData() + carry;
			carry = sum / 10;
			sum %= 10;

			// add this node to the front of the result
			push(result, sum);
		}
	}

	// A utility function to swap two pointers
	void swapPointer(Node a, Node b) {
		Node t = a;
		a = b;
		b = t;
	}

	/* A utility function to insert a node at the beginning of linked list */
	void push(Node head_ref, int new_data) {

		/* put in the data */
		Node newNode = new Node();
		newNode.setData(new_data);

		/* link the old list off the new node */
		newNode.setNextNode(head_ref);

		head_ref = newNode;
	}

	/* A utility function to get size of linked list */
	int getSize(Node node) {
		int size = 0;
		while (node != null) {
			node = node.getNextNode();
			size++;
		}
		return size;
	}

}
