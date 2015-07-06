package com.interview.algorithms.tree;

import com.example.datastructures.Stack;
import com.example.datastructures.node.BinaryNode;

/**
 * http://www.geeksforgeeks.org/inorder-tree-traversal-without-recursion/
 * Using Stack is the obvious way to traverse tree without recursion. Below is an algorithm for traversing binary tree using stack.
 * 
 * See this for step wise step execution of the algorithm.

1) Create an empty stack S.
2) Initialize current node as root
3) Push the current node to S and set current = current->left until current is NULL
4) If current is NULL and stack is not empty then 
     a) Pop the top item from stack.
     b) Print the popped item, set current = current->right 
     c) Go to step 3.
5) If current is NULL and stack is empty then we are done.

 * @author ajitkoti
 *
 */
public class InOrderTraversalWithoutRescursionWithoutStack {

	/**
	 * Iterative function for inorder tree traversal
	 * 
	 * @param root
	 */
	public static void inOrder(BinaryNode root) {
		BinaryNode current = root;
		Stack<BinaryNode> stack = new Stack<BinaryNode>(100);
		boolean done = false;

		while (!done) {

			/* Reach the left most tNode of the current tNode */
			if (current != null) {
				// place pointer to a tree node on the stack before traversing
				// the node's left subtree
				stack.push(current);
				current = current.getLeftChild();
			}

			/*
			 * backtrack from the empty subtree and visit the Node at the top of
			 * the stack; however, if the stack is empty, you are done
			 */
			else {
				if (!stack.isEmpty()) {
					current = stack.pop();
					System.out.println(current.getData());

					/*
					 * we have visited the node and its left subtree. Now, it's
					 * right subtree's turn
					 */
					current = current.getRightChild();
				} else {
					// stack is empty all nodes traversed
					done = true;
				}
			}
		}
	}

}
