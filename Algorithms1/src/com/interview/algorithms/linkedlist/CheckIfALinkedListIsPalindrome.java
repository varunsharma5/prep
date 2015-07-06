package com.interview.algorithms.linkedlist;

import com.example.datastructures.node.Node;

/**
 * Given a singly linked list of characters, write a function that returns true
 * if the given list is palindrome, else false.
 * 
 * Use two pointers left and right. Move right and left using recursion and
 * check for following in each recursive call. 1) Sub-list is palindrome. 2)
 * Value at current left and right are matching.
 * 
 * If both above conditions are true then return true.
 * 
 * The idea is to use function call stack as container. Recursively traverse
 * till the end of list. When we return from last NULL, we will be at last node.
 * The last node to be compared with first node of list.
 * 
 * http://www.geeksforgeeks.org/function-to-check-if-a-singly-linked-list-is-
 * palindrome/
 * 
 * @author ajitkoti
 * 
 */
public class CheckIfALinkedListIsPalindrome {

	// A wrapper over isPalindromeUtil()
	private static boolean isPalindrome(Node head) {
		return isPalindromeUtil(head, head);
	}

	// Initial parameters to this function are &head and head
	private static boolean isPalindromeUtil(Node left, Node right) {
		/* stop recursion when right becomes NULL */
		if (right == null)
			return true;

		/*
		 * If sub-list is not palindrome then no need to check for current left
		 * and right, return false
		 */
		boolean isp = isPalindromeUtil(left, right.getNextNode());
		if (isp == false)
			return false;

		/* Check values at current left and right */
		boolean isp1 = (right.getData() == left.getData());

		/* Move left to next node */
		left = left.getNextNode();

		return isp1;
	}

}
