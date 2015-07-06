package com.interview.algorithms.stack.queues;

/*
 *  Java Program to Check for balanced paranthesis by using Stacks
 */

import java.util.Stack;

public class ParenthesisMatching {
	public static boolean parenthesisOtherMatching(String str) {
		Stack<Character> stack = new Stack<Character>();

		char c;
		for (int i = 0; i < str.length(); i++) {
			c = str.charAt(i);

			if (c == '{')
				stack.push(c);

			if (c == '(')
				stack.push(c);

			if (c == '}') {
				if (stack.empty())
					return false;
				else if (stack.peek() == '{') {
					stack.pop();
				}
			} else if (c == ')') {
				if (stack.empty())
					return false;
				else if (stack.peek() == '(') {
					stack.pop();
				}
			} else
				return false;

		}
		return stack.empty();
	}

	public static void main(String[] args) {
		String str = "({})";
		System.out.println(parenthesisOtherMatching(str));
	}
}