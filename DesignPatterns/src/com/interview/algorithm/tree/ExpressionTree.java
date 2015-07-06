//package com.interview.algorithm.tree;
//
//import java.util.Scanner;
//
//public class ExpressionTree
//{
//	/**
//	 * One node in an expression tree, allowing double values.
//	 */
//	public static class TreeNode {
//		private final boolean leaf; // ?Is this aleaf? else internal
//		private final char op; // For an internal node, the operator
//		private int value; // For a leaf,the value
//		private TreeNode left, // Left subexpression (internal node)
//		right; // Right subexpression
//		// Bare-bones constructor
//		public TreeNode ( boolean leaf, char op, int value )
//		{
//			this.leaf = leaf;
//			this.op = op;
//			this.value = value;
//			this.left = null; // Empty to start
//			this.right = null;
//		}
//		// For leaf nodes, show the value; for internal, the operator.
//		public String toString()// Overrides Object.toString, must be public.
//		{ return leaf ? Integer.toString(value) : Character.toString(op); }
//	}
//	
//	TreeNode root = null;
//	
//	public ExpressionTree ( Scanner input ) { 
//		root = build(input); 
//	}
//	
//	/**
//	 * Based on a white-space delimited prefix expression, build the corresponding binary expression tree.
//	 * 
//	 * @param input The scanner with the expression
//	 * @return reference to the corresponding binary expression tree
//	 */
//
//
//	public TreeNode build (Scanner input) {
//		boolean leaf;
//		String token;
//		int value;
//		TreeNode node;
//		leaf = input.hasNextInt();
//		if ( leaf ) {
//			value = input.nextInt();
//			node = new TreeNode ( leaf, '\0', value );
//		} else {
//			token = input.next();
//			node = new TreeNode ( leaf, token.charAt(0), 0 );
//			node.left = build ( input );
//			node.right = build ( input );
//		}
//		return node;
//	}
//	/**
//	 * Show the expression tree as a postfix expression
//     .
//	 * All the work is done in the private recursive me
//     thod.
//	 */
//	public void showPostFix ()
//	{
//		showPostFix ( root );
//		System.out.println();
//	}
//	// Postfix expression is the result of a post-order traversal
//	public void showPostFix ( TreeNode node )
//	{
//		if ( node != null )
//		{
//			showPostFix ( node.left );
//			showPostFix ( node.right );
//			System.out.print ( node + " " );
//		}
//	}
//	/**
//	 * Show the expression tree as a prefix expression.
//	 * All the work is done in the private recursive me
//       thod.
//	 */
//	public void showPreFix ()
//	{
//		showPreFix ( root );
//		System.out.println();
//	}
//	// Prefix expression is the result of a pre-order traversal
//	public void showPreFix ( TreeNode node )
//	{ // NOTE: removing tail recursion
//		while ( node != null )
//		{
//			System.out.print ( node + " " );
//			showPreFix ( node.left );
//			node = node.right; // Update parameter for right traversal
//		}
//	}
//	/**
//	 * Show the expression tree as a parenthesized infi
//     x expression.
//	 * All the work is done in the private recursive me
//     thod.
//	 */
//	public void showInFix ()
//	{
//		showInFix ( root );
//		System.out.println();
//	}
//	// Parenthesized infix requires parentheses in both the
//	// pre-order and post-order positions, plus thenode
//	// itself in the in-order position.
//	public void showInFix ( TreeNode node )
//	{
//		if ( node != null )
//		{
//			// Note: do NOT parenthesize leaf nodes
//			if ( ! node.leaf )
//				System.out.print ("( "); // Pre-order position
//			showInFix ( node.left );
//			System.out.print ( node + " " ); // In-order position
//			showInFix ( node.right );
//			if ( ! node.leaf ) // Post-order position
//				System.out.print (") ");
//		}
//	}
//	/**
//	 * Evaluate the expression and return its value.
//	 * All the work is done in the private recursive me
//     thod.
//	 * @return the value of the expression tree.
//	 */
//	public int evaluate ()	{ 
//		return root == null ? 0: evaluate ( root ); 
//	}
//	
//	// Evaluate the expression: for internal nodes this amounts
//	// to a post-order traversal, in which the processing is doing
//	// the actual arithmetic. For leaf nodes, it is simply the
//	// value of the node.
//	public int evaluate ( TreeNode node )
//	{
//		int result; // Value to be returned
//		if ( node.leaf ) // Just get the value of the leaf
//			result = node.value;
//		else
//		{
//			// We've got work to do, evaluating the expression
//			int left, right;
//			char operator = node.op;
//			// Capture the values of the left and right subexpressions
//			left = evaluate ( node.left );
//			right = evaluate ( node.right );
//			// Do the arithmetic, based on the operator
//			switch ( operator )
//			{
//			case '-': result = left - right; break;
//			case '*': result = left * right; break;
//			case '/': result = left / right; break;
//			// NOTE: allow fall-through from defaultto case '+'
//			default: System.out.println ("Unrecognized operator " +operator + " treated as +.");
//			case '+': result = left + right;
//			break;
//			}
//		}
//		// Return either the leaf's value or the one we just calculated.
//		return result;
//	}
//
//	public static void main ( String[] args ){
//		System.out.println("Enter an infix expression");
//		ExpressionTree calc = new ExpressionTree(new Scanner(System.in));
//		System.out.println ("\nInput as prefix expression:");
//		calc.showPreFix();
//		System.out.println ("\nInput as postfix expression:");
//		calc.showPostFix();
//		System.out.println ("\nInput as parenthesizedinfix expression:");
//		calc.showInFix();
//		System.out.println ("\nValue: " + calc.evaluate());
//	}
//}

