package com.interview.algorithms.tree;

import com.example.datastructures.node.BinaryNode;

/**
 * Let us consider the below traversals:
 * 
 * Inorder sequence: D B E A F C Preorder sequence: A B D E C F
 * 
 * In a Preorder sequence, leftmost element is the root of the tree. So we know
 * ‘A’ is root for given sequences. By searching ‘A’ in Inorder sequence, we can
 * find out all elements on left side of ‘A’ are in left subtree and elements on
 * right are in right subtree.
 * 
 * http://www.geeksforgeeks.org/construct-tree-from-given
 * -inorder-and-preorder-traversal/
 * 
 * @author ajitkoti
 * 
 */
public class CreateATreeUsingInorderAndPreOrder {

	private static BinaryNode buildTree(int in[], int pre[], int inStrt,int inEnd) {
		int preIndex = 0;

		if (inStrt > inEnd)
			return null;

		/*
		 * PickcurrentnodefromPreordertraversalusingpreIndex
		 * andincrementpreIndex
		 */
		BinaryNode tNode = new BinaryNode(pre[preIndex++]);

		/* If this node has no children then return */
		if (inStrt == inEnd)
			return tNode;

		/* Else find the index of this node in Inorder traversal */
		int inIndex = search(in, inStrt, inEnd, tNode.getData());

		/* Using indexin Inorder traversal,construct left and right subtress */
		tNode.setLeftChild(buildTree(in, pre, inStrt, inIndex - 1));
		tNode.setRightChild(buildTree(in, pre, inIndex + 1, inEnd));

		return tNode;
	}

	/*
	 * Function index of value inarr[start...end] The function assumes that
	 * value is presentin in[]
	 */
	private static int search(int arr[], int strt, int end, int value) {

		for (int i = strt; i <= end; i++) {
			if (arr[i] == value)
				return i;
		}
		return -1;
	}

}
