package com.interview.algorithms.linkedlist;

import java.util.HashSet;
import java.util.Set;

import com.example.datastructures.node.Node;

/**
 * Write code to remove duplicates from an unsorted linked list. 
 *  How would you solve this problem if a temporary buffer is not allowed?
 * 
 * @author ajitkoti
 *
 */
public class RemoveDuplicatesFromLinkedList {

	public static void main(String[] args) {

	}

	/*
	 * If we can use a buffer, we can keep track of elements in a hashset and
	 * remove any dups:
	 */
	public static void deleteDups(Node n) {

		Set<Integer> table = new HashSet<Integer>();

		Node previous = null;

		while (n != null) {
			if (table.contains(n.getData()))
				previous.setNextNode(n.getNextNode());
			else {
				table.add(n.getData());
				previous = n;
			}
			n = n.getNextNode();

		}
	}

	/*
	 * Without a buffer, we can iterate with two pointers: “current” does a
	 * normal iteration, while “runner” iterates through all prior nodes to
	 * check for dups. Runner will only see one dup per node, because if there
	 * were multiple duplicates they would have been removed alread
	 */
	public static void deleteDups2(Node root) {

		if (root == null)
			return;

		Node previous = root;
		Node current = previous.getNextNode();

		while (current != null) {
			Node runner = root;

			while (runner != current) { // Check for earlier dups

				if (runner.getData() == current.getData()) {
					previous.setNextNode(current.getNextNode());
					current = current.getNextNode(); // update current to next node
					break; // all other dups have already been removed
				}
				runner = runner.getNextNode();

			}

			if (runner == current) { // current not updated - update now
				previous = current;
				current = current.getNextNode();

			}

		}
	}

}
