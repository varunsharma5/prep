package com.interview.algorithm.tree;

import java.io.File;
import java.io.FileInputStream;

/**
 * http://www.sanfoundry.com/java-program-implement-binary-search-tree/
 * 
 * http://pages.cs.wisc.edu/~skrentny/cs367-common/readings/Binary-Search-Trees/index.html
 * 
 * @author varun
 *
 */

class TreeNode {
	int data;
	TreeNode left;
	TreeNode right;
}


class MyBST {
	TreeNode root = null;
	
	public void addNode(int data) {
		if(root == null) {
			root = createNode(data);
			return;
		}
		
		TreeNode travPtr = root;
		
		if(data > root.data) {
			while(travPtr.right != null && travPtr.data < data) {
				travPtr = travPtr.right;
			}
			TreeNode newNode = createNode(data);
			travPtr.right = newNode;
		} else {
			while(travPtr.left != null && travPtr.data > data) {
				travPtr = travPtr.left;
			}
			TreeNode newNode = createNode(data);
			travPtr.left = newNode;
		}
	}
	
	public void insert(int data) {
		root = insert(root, data);
	}
	
	private TreeNode insert(TreeNode node, int data) {
		if(node == null) {
			node = createNode(data);
		} else {
			if(data <= node.data) {
				node.left = insert(node.left, data);
			} else {
				node.right = insert(node.right, data);
			}
		}
		return node;
	}
	
	public void inorder() {
		System.out.println("Inorder: ");
		inorder(root);
		System.out.println("");
	}
	
	private void inorder(TreeNode node) {
		if(node != null) {
			inorder(node.left);
			System.out.print(node.data + ",");
			inorder(node.right);
		}
	}
	
	public boolean search(int val) {
		return search(root, val);
	}
	
	private boolean search(TreeNode node, int val) {
		boolean found = false;
		
		while(node!= null && !found) {
			int nodeVal = node.data;
			
			if(nodeVal > val) {
				node = node.left;
			} else if(nodeVal < val) {
				node = node.right;
			} else if(nodeVal == val) {
				found = true;
				break;
			}
			
			found = search(node, val);
		}
		return found;
	}
	
	
	public int countNodes() {
		return count(root);
	}
	
	private int count(TreeNode node) {
		if(node == null) {
			return 0;
		} else {
			int len = 1;
			len += count(node.left);
			len += count(node.right);
			return len;
		}
		
		
	}
	
	private TreeNode createNode(int val) {
		TreeNode node = new TreeNode();
		node.data = val;
		node.left = null;
		node.right = null;
		return node;
	}
	
	public int height() {
		return height(root);
	}
	
	private int height(TreeNode node) {
		if(node == null) {
			return 0;
		}
		return 1 + Math.max(height(node.right), height(node.left));
	}
}

public class TreeExamples {
	public static void main(String[] args) {
		MyBST bst = new MyBST();
		
		bst.insert(100);
		bst.insert(150);
		bst.insert(230);
		bst.insert(50);
		bst.insert(68);
		bst.insert(75);
		bst.insert(175);
		bst.insert(10);
		
		bst.inorder();
		
		System.out.println("find for 50: " + bst.search(50));
		
		System.out.println("Num of nodes: " + bst.countNodes());
		
		System.out.println("Height: " + bst.height());
	}
}
