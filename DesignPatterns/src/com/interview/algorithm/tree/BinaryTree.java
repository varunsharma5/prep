package com.interview.algorithm.tree;

public class BinaryTree {
	private TNode root;
	
	public BinaryTree(int[] values) {
		createTree(values);
	}
	
	public TNode getRoot() {
		return root;
	}
	
	public void addNode(int key, String name) {
//		this("sadsad");
//		addNodeRecur(root, key, name);
		addNodeNonRecur(key, name);
	}
	
	private void addNodeRecur(TNode node, int key, String name) {
		TNode newNode = new TNode(key, name);
		if(root == null) {
			root = newNode;
			return;
		}
		
		if(key > node.Key) {
			if(node.rightChild != null) {
				addNodeRecur(node.rightChild,key,name);
			} else {
				node.rightChild = newNode;
			}
		} else if(key < node.Key) {
			if(node.leftChild != null) {
				addNodeRecur(node.leftChild,key,name);
			} else {
				node.leftChild = newNode;
			}
		}
	}
	
	private void addNodeNonRecur(int key, String name) {
		TNode newNode = new TNode(key, name);
		if(root == null) {
			root = newNode;
			return;
		}
		
		TNode focusNode = root;
		TNode parent;
		while(true) {
			parent = focusNode;
			if(key > focusNode.Key) {
				focusNode = focusNode.rightChild;
				if(focusNode == null) {
					parent.rightChild = newNode;
					return;
				}
			} else if(key < focusNode.Key) {
				focusNode = focusNode.leftChild;
				if(focusNode == null) {
					parent.leftChild = newNode;
					return;
				}
			}
		}
	}
	
	public void printInorder() {
		inOrderTraversal(this.root);
	}
	
	public void printPostOrder() {
		postOrderTraversal(root);
	}
	
	public void printPreOrder() {
		preorderTraversal(root);
	}
	
	public int getHeight() {
		return getHeight(root);
	}
	
	public int getHeight(TNode root) {
		if(root == null) {
			return 0;
		} else {
			int lheight = getHeight(root.leftChild);
			int rheight = getHeight(root.rightChild);
			
			if(lheight > rheight) {
				return lheight + 1;
			} else {
				return rheight + 1;
			}
		}
	}
	
	/*
	 * Sorted list
	 */
 	private void inOrderTraversal(TNode focusNode) {
		if(focusNode != null) {
			inOrderTraversal(focusNode.leftChild);
			System.out.println(focusNode);
			inOrderTraversal(focusNode.rightChild);
		}
	}
	
 	private void postOrderTraversal(TNode focusNode) {
		if(focusNode != null) {
			inOrderTraversal(focusNode.leftChild);
			inOrderTraversal(focusNode.rightChild);
			System.out.println(focusNode);
		}
	}
	
 	private void preorderTraversal(TNode focusNode) {
		if(focusNode != null) {
			System.out.println(focusNode);
			inOrderTraversal(focusNode.leftChild);
			inOrderTraversal(focusNode.rightChild);
		}
	}
	
	public TNode createTree(int[] values) {
		for(int value : values) {
			addNode(value, null);
		}
		return this.root;
	}
	
	public static void main(String[] args) {
//		BinaryTree tree = new BinaryTree();
//		
//		tree.addNode(30, "Varun");
//		tree.addNode(50, "Taani");
//		tree.addNode(24, "Mouli");
//		tree.addNode(10, "John");
//		tree.addNode(44, "Joe");
//		
//		tree.inOrderTraversal(tree.root);
	}
	
	public boolean remove(int key) {

		// Start at the top of the tree

		TNode focusNode = root;
		TNode parent = root;

		// When searching for a Node this will
		// tell us whether to search to the
		// right or left

		boolean isItALeftChild = true;

		// While we haven't found the Node keep looking

		while (focusNode.Key != key) {

			parent = focusNode;

			// If we should search to the left

			if (key < focusNode.Key) {

				isItALeftChild = true;

				// Shift the focus Node to the left child

				focusNode = focusNode.leftChild;

			} else {

				// Greater than focus node so go to the right

				isItALeftChild = false;

				// Shift the focus Node to the right child

				focusNode = focusNode.rightChild;

			}

			// The node wasn't found

			if (focusNode == null)
				return false;

		}

		// If Node doesn't have children delete it. Its a leaf node

		if (focusNode.leftChild == null && focusNode.rightChild == null) {

			// If root delete it

			if (focusNode == root)
				root = null;

			// If it was marked as a left child of the parent delete it in its parent

			else if (isItALeftChild)
				parent.leftChild = null;

			// Vice versa for the right child

			else
				parent.rightChild = null;

		}

		// If no right child

		else if (focusNode.rightChild == null) {

			if (focusNode == root)
				root = focusNode.leftChild;

			// If focus Node was on the left of parent
			// move the focus Nodes left child up to the
			// parent node

			else if (isItALeftChild)
				parent.leftChild = focusNode.leftChild;

			// Vice versa for the right child

			else
				parent.rightChild = focusNode.leftChild;

		}

		// If no left child

		else if (focusNode.leftChild == null) {

			if (focusNode == root)
				root = focusNode.rightChild;

			// If focus Node was on the left of parent
			// move the focus Nodes right child up to the
			// parent node

			else if (isItALeftChild)
				parent.leftChild = focusNode.rightChild;

			// Vice versa for the left child

			else
				parent.rightChild = focusNode.rightChild;

		}

		// Two children so I need to find the deleted nodes replacement

		else {

			TNode replacement = getReplacementNode(focusNode);

			// If the focusNode is root replace root
			// with the replacement

			if (focusNode == root)
				root = replacement;

			// If the deleted node was a left child
			// make the replacement the left child

			else if (isItALeftChild)
				parent.leftChild = replacement;

			// Vice versa if it was a right child

			else
				parent.rightChild = replacement;

			replacement.leftChild = focusNode.leftChild;

		}

		return true;

	}

	public TNode getReplacementNode(TNode nodeToBeReplaced) {

		TNode replacementParent = nodeToBeReplaced;
		TNode replacement = nodeToBeReplaced;

		TNode focusNode = nodeToBeReplaced.rightChild;

		// While there are no more left children

		while (focusNode != null) {

			replacementParent = replacement;

			replacement = focusNode;

			focusNode = focusNode.leftChild;

		}

		// If the replacement isn't the right child, move the replacement into the 
		// parent's leftChild slot and move the replaced nodes right child into the replacements rightChild

		if (replacement != nodeToBeReplaced.rightChild) {

			replacementParent.leftChild = replacement.rightChild;
			replacement.rightChild = nodeToBeReplaced.rightChild;

		}

		return replacement;

	}
}
