package com.interview.algorithm.tree;

import java.util.Stack;

import com.interview.algorithm.stack.InfixToPostfix;


class ExpressionTreeNode {
	char val;
	ExpressionTreeNode right;
	ExpressionTreeNode left;
	public ExpressionTreeNode(char val, ExpressionTreeNode right,
			ExpressionTreeNode left) {
		super();
		this.val = val;
		this.right = right;
		this.left = left;
	}
}

public class ExpressionTree1 {
	private InfixToPostfix infixToPostfix = new InfixToPostfix();
	private Stack<ExpressionTreeNode> treeNodeStack = new Stack<ExpressionTreeNode>();
	
	
	private ExpressionTreeNode constructExpressionTree(String postFixExpr) {
		char[] charArray = postFixExpr.toCharArray();

		for(char ch : charArray) {
			if(InfixToPostfix.isOperator(ch)) {
				ExpressionTreeNode rightChild = treeNodeStack.pop();
				ExpressionTreeNode leftChild = treeNodeStack.pop();
				
				treeNodeStack.push(new ExpressionTreeNode(ch, rightChild, leftChild));
				
			} else {
				treeNodeStack.push(new ExpressionTreeNode(ch, null, null));
			}
		}
		return treeNodeStack.pop();
	}
	
	public static void main(String[] args) {
		
	}
	
}
