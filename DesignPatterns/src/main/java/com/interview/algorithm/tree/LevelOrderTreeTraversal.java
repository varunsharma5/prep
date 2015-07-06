package com.interview.algorithm.tree;

/**
 * 
 * METHOD 1 (Use function to print a given level)

	Algorithm:
	There are basically two functions in this method. One is to 
	print all nodes at a given level (printGivenLevel), and other is to 
	print level order traversal of the tree (printLevelorder). 
	printLevelorder makes use of printGivenLevel to print nodes at all 
	levels one by one starting from root.

		//Function to print level order traversal of tree
		printLevelorder(tree)
		for d = 1 to height(tree)
		   printGivenLevel(tree, d);
		
		//Function to print all nodes at a given level
		printGivenLevel(tree, level)
		if tree is NULL then return;
		if level is 1, then
		    print(tree->data);
		else if level greater than 1, then
		    printGivenLevel(tree->left, level-1);
		    printGivenLevel(tree->right, level-1);
 * 
 * 
 * @author Varun
 *
 */
public class LevelOrderTreeTraversal {
	public static void main(String[] args) {
		BinaryTree binaryTree = new BinaryTree(new int[]{30,50,24,10,44});
//		binaryTree.printInorder();
		
		printLevelOrder(binaryTree.getRoot());
	}
	
	private static void printLevelOrder(TNode root) {
		for(int i=1; i<= BSTHeightCalculator.getHeight(root); i++) {
			printGivenLevel(root, i);
			System.out.println();
		}
	}
	
	private static void printGivenLevel(TNode root, int level) {
		if(root == null)
			return;
		if(level == 1 ) {
			System.out.print(root.Key + " ");
		} else if(level > 1) {
			printGivenLevel(root.leftChild, level-1);
			printGivenLevel(root.rightChild, level-1);
		}
		
	}
}
