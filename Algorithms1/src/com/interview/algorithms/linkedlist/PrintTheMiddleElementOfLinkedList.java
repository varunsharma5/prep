package com.interview.algorithms.linkedlist;

import com.example.datastructures.node.Node;

/**
 * Write a function to print the middle of a given linked list
 * http://www.geeksforgeeks.org/write-a-c-function-to-print-the-middle-of-the-
 * linked-list/
 * 
 * @author ajitkoti
 * 
 */
public class PrintTheMiddleElementOfLinkedList {

	/**
	 * Traverse linked list using two pointers. Move one pointer by one and
	 * other pointer by two. When the fast pointer reaches end slow pointer will
	 * reach middle of the linked list.
	 * 
	 * @param head
	 */
	private static void printMiddle(Node head) {
		Node slow_ptr = head;
		Node fast_ptr = head;

		if (head != null) {
			while (fast_ptr != null && fast_ptr.getNextNode() != null) {
				fast_ptr = fast_ptr.getNextNode().getNextNode();
				slow_ptr = slow_ptr.getNextNode();
			}
			System.out.println("The middle element is" + slow_ptr.getData());
		}
	}
	
	public static void main(String[] args) {
		
	}

}
