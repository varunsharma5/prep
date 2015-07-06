package com.interview.algorithms.tree;

import java.util.ArrayList;
import java.util.LinkedList;

import com.example.datastructures.node.BinaryNode;

/**
 * Given a binary search tree, design an algorithm which creates a linked list
 * of all the nodes at each depth (eg, if you have a tree with depth D, you’ll
 * have D linked lists)
 * 
 * @author ajitkoti
 *
 */
public class LinkedListPerDepthOfTree {

	public static void main(String[] args) {

	}

	/**
	 * We can do a simple level by level traversal of the tree, with a slight
	 * modification of the breath- first traversal of the tree. In a usual
	 * breath first search traversal, we simply traverse the nodes without
	 * caring which level we are on. In this case, it is critical to know the
	 * level. We thus use a dummy node to indicate when we have finished one
	 * level and are starting on the next
	 * 
	 * @param root
	 * @return
	 */
	private static ArrayList<LinkedList<BinaryNode>> findLevelLinkList(BinaryNode root) {
		int level = 0;
		ArrayList<LinkedList<BinaryNode>> result = new ArrayList<LinkedList<BinaryNode>>();
		LinkedList<BinaryNode> list = new LinkedList<BinaryNode>();

		list.add(root);
		result.add(level, list);

		while (true) {
			list = new LinkedList<BinaryNode>();

			for (int i = 0; i < result.get(level).size(); i++) {
				BinaryNode node = (BinaryNode) result.get(level).get(i);

				if (node != null) {
					if (node.getLeftChild() != null)
						list.add(node.getLeftChild());

					if (node.getRightChild() != null)
						list.add(node.getRightChild());
				}

			}

			if (list.size() > 0) {
				result.add(level + 1, list);
			} else {
				break;
			}

			level++;
		}

		return result;
	}

}
