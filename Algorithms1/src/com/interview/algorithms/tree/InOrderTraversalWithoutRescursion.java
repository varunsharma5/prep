package com.interview.algorithms.tree;

import com.example.datastructures.node.BinaryNode;

/**
 
 * @author ajitkoti
 *
 */
public class InOrderTraversalWithoutRescursion {
	
	/* Function to traverse binary tree without recursion and 
	   without stack */
	private static void MorrisTraversal(BinaryNode root)
	{
		BinaryNode tNode ,current,pre;
	 
	  if(root == null)
	     return; 
	 
	  current = root;
	  while(current != null)
	  {                 
	    if(current.getLeftChild() == null)
	    {
	      System.out.println(current.getData());
	      current = current.getRightChild();      
	    }    
	    else
	    {
	      /* Find the inorder predecessor of current */
	      pre = current.getLeftChild();
	      while(pre.getRightChild() != null && pre.getRightChild() != current)
	        pre = pre.getRightChild();
	 
	      /* Make current as right child of its inorder predecessor */
	      if(pre.getRightChild() == null)
	      {
	        pre.setRightChild(current);
	        current = current.getLeftChild();
	      }
	             
	      /* Revert the changes made in if part to restore the original 
	        tree i.e., fix the right child of predecssor */   
	      else 
	      {
	        pre.setRightChild(null);
	        System.out.println(current.getData());
	        current = current.getRightChild();      
	      } /* End of if condition pre.getRightChild() == null */
	    } /* End of if condition current.getLeftChild() == null*/
	  } /* End of while */
	}
	 
	/* UTILITY FUNCTIONS */
	/* Helper function that allocates a new tNode with the
	   given data and null left and right pointers. */
	BinaryNode newtNode(int data)
	{
	  BinaryNode tNode = new BinaryNode();
	  tNode.setData(data);
	  tNode.setLeftChild(null);
	  tNode.setRightChild(null);
	 
	  return(tNode);
	}
	

	 
	public static void main(String[] args) {
	 
	  /* Constructed binary tree is
	            1
	          /   \
	        2      3
	      /  \
	    4     5
	  */
		BinaryNode root = new BinaryNode(1);
	  root.setLeftChild(new BinaryNode(2));
	  root.setRightChild(new BinaryNode(3));
	  root.getLeftChild().setLeftChild(new BinaryNode(4));
	  root.getLeftChild().setRightChild(new BinaryNode(5));
	
	  MorrisTraversal(root);
	
	}
}
