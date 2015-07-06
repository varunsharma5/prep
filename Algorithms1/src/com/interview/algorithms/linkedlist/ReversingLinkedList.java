package com.interview.algorithms.linkedlist;

import com.example.datastructures.node.Node;
/**
 * http://www.mytechinterviews.com/reverse-a-linked-list
 * @author ajitkoti
 *
 */
public class ReversingLinkedList {


	public Node reverse(Node current) {
		Node temp;
		Node previous = null;
		while (current != null) {
			temp = current.getNextNode();
			current.setNextNode(previous);
			previous = current;
			current = temp;
		}
		return previous;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
