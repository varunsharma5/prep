package com.interview.algorithms.tree;

import com.example.datastructures.node.BinaryNode;

/**
 * Print all nodes that are at distance k from a leaf node
 * http://www.geeksforgeeks.org/print-nodes-distance-k-leaf-node/
 * 
 * @author ajitkoti
 *
 */
public class FindNodesKDistanceFromLeafNode {

	/*
	 * This function prints all nodes that are distance k from a leaf node
	 * path[] --> Store ancestors of a node visited[] --> Stores true if a node
	 * is printed as output. A node may be k distance away from many leaves, we
	 * want to print it once
	 */
	void kDistantFromLeafUtil(BinaryNode node, InfoNode path[], int pathLen, int k) {
		// Base case
		if (node == null)
			return;

		/* append this Node to the path array */
		InfoNode infoNode = new InfoNode(node.getData(), false);
		path[pathLen] = infoNode;		
		pathLen++;

		/*
		 * it's a leaf, so print the ancestor at distance k only if the ancestor
		 * is not already printed
		 */
		if (node.getLeftChild() == null && node.getRightChild() == null
				&& pathLen - k - 1 >= 0 && !path[pathLen - k - 1].isVistied()) {
			System.out.println(path[pathLen - k - 1].getData());
			path[pathLen - k - 1].setVistied(true);
			return;
		}

		/* If not leaf node, recur for left and right subtrees */
		kDistantFromLeafUtil(node.getLeftChild(), path, pathLen, k);
		kDistantFromLeafUtil(node.getRightChild(), path, pathLen, k);
	}

	/*
	 * Given a binary tree and a nuber k, print all nodes that are k distant
	 * from a leaf
	 */
	void printKDistantfromLeaf(BinaryNode node, int k) {
		InfoNode[] path = new InfoNode[100];		
		kDistantFromLeafUtil(node, path, 0, k);
	}

}

class InfoNode{
	private int data;
	private boolean vistied = false;
	public InfoNode(int data2, boolean b) {
		
	}
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public boolean isVistied() {
		return vistied;
	}
	public void setVistied(boolean vistied) {
		this.vistied = vistied;
	}
	
	
}
