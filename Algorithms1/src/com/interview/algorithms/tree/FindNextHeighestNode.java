package com.interview.algorithms.tree;

import com.example.datastructures.node.BinaryNode;

/**
 * 
 * @author ajitkoti
 *
 */
public class FindNextHeighestNode {

	BinaryNode findNextHeighestNode(BinaryNode root, int val) {
		BinaryNode temp = root;
		BinaryNode last = root;

		while (temp != null) {
			if (temp.getData() == val)
				break;
			else if (val < temp.getData()) {
				temp = temp.getLeftChild();
			} else {
				temp = temp.getRightChild();
				
			}
		}
		
		
		if (temp != null) // node is present
		{
			if (val < last.getData()) {
				return last;
			} else {
				while (val > last.getData()) {
					last = last.getRightChild();
				}
				return last;
			}
		}
		return null;

	}

}
