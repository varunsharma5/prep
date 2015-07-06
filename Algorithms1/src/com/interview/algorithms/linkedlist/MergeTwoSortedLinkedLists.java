package com.interview.algorithms.linkedlist;

import com.example.datastructures.node.Node;

/**
 * Write a SortedMerge() function that takes two lists, each of which is sorted
 * in increasing order, and merges the two together into one list which is in
 * increasing order. SortedMerge() should return the new list. The new list
 * should be made by splicing together the nodes of the first two lists.
 * 
 * For example if the first linked list a is 5->10->15 and the other linked list
 * b is 2->3->20, then SortedMerge() should return a pointer to the head node of
 * the merged list 2->3->5->10->15->20.
 * 
 * There are many cases to deal with: either ‘a’ or ‘b’ may be empty, during
 * processing either ‘a’ or ‘b’ may run out first, and finally there’s the
 * problem of starting the result list empty, and building it up while going
 * through ‘a’ and ‘b’.
 * 
 * http://www.geeksforgeeks.org/merge-two-sorted-linked-lists/
 * 
 * @author ajitkoti
 * 
 */
public class MergeTwoSortedLinkedLists {

	/**
	 * Merge is one of those nice recursive problems where the recursive
	 * solution code is much cleaner than the iterative code. You probably
	 * wouldn’t want to use the recursive version for production code however,
	 * because it will use stack space which is proportional to the length of
	 * the lists.
	 * 
	 * http://cslibrary.stanford.edu/105/LinkedListProblems.pdf
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	private static Node SortedMerge(Node a, Node b) {
		Node result = null;

		/* Base cases */
		if (a == null)
			return (b);
		else if (b == null)
			return (a);

		/* Pick either a or b, and recur */
		if (a.getData() <= b.getData()) {
			result = a;
			result.setNextNode(SortedMerge(a.getNextNode(), b));
		} else {
			result = b;
			result.setNextNode(SortedMerge(a, b.getNextNode()));
		}
		return (result);
	}

}
