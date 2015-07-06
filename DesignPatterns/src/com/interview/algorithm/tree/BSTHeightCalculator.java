package com.interview.algorithm.tree;

/**
 * 
	 //Compute the "height" of a tree -- the number of
	 //nodes along the longest path from the root node
	 //down to the farthest leaf node.
		int height(struct node* node)
		{
		   if (node==NULL)
		       return 0;
		   else
		   {
		     // compute the height of each subtree 
		     int lheight = height(node->left);
		     int rheight = height(node->right);
		 
			// use the larger one 
		     if (lheight > rheight)
		         return(lheight+1);
		     else return(rheight+1);
		   }
		}
 * 
 * @author Varun
 *
 */
public class BSTHeightCalculator {
	public static int getHeight(TNode root) {
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
	
}
