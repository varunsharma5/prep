package com.interview.algorithm.stack;

import java.util.Stack;

/**
 * 
1. Scan the infix expression from left to right.
2. If the scanned character is an operand, output(print) it.
3. Else,
	3.1 If the precedence of the scanned operator is greater than the precedence of the operator in the stack(or the stack is empty), push it.
	3.2 Else, Pop the operator from the stack until the precedence of the scanned operator is less-equal to the 
   	precedence of the operator residing on the top of the stack. Push the scanned operator to the stack.
4. If the scanned character is an ‘(‘, push it to the stack.
5. If the scanned character is an ‘)’, pop and output from the stack until an ‘(‘ is encountered.
6. Repeat steps 2-6 until infix expression is scanned.
7. Pop and output from the stack until it is not empty.
 * @author varun
 *
 */
public class InfixToPostfix {
	private Stack<Character> operators = new Stack<Character>();
	
	public static void main(String[] args) {
		InfixToPostfix obj = new InfixToPostfix();
		System.out.println(obj.convertToPostFix("a+b*(c^d-e)^(f+g*h)-i"));
	}
	
	private String convertToPostFix(String expression) {
		char[] charExpr = expression.toCharArray();
		StringBuilder retVal = new StringBuilder();
		
		for(char ch : charExpr) {
			if(isOperator(ch)) {
				if(operators.isEmpty()) {
					operators.push(ch);
					continue;
				}
				while(!operators.isEmpty() && (getPrecedence(ch) <= getPrecedence(operators.peek()))) {
					retVal.append(operators.pop());
				}
				operators.push(ch);
			} else if(ch == '(') {
				operators.push(ch);
			} else if(ch == ')') {
				while(!operators.isEmpty() && operators.peek() != '(') {
					retVal.append(operators.pop());
				}
				operators.pop();
			}
			else {
				retVal.append(ch);
			}
		}
		for(char c : operators) {
			retVal.append(c);
		}
		
		return retVal.toString();
	}
	
	public static boolean isOperator(char ch) {
		if(ch == '*' || ch == '+' || ch == '-' || ch == '/' || ch == '^') {
			return true;
		}
		return false;
	}
	
	/*
	 * Returns true if op1 has higher precedence than op2
	 */
	private int getPrecedence(char op1) {
		switch (op1) {
		case '+':
		case '-':
			return 1;
		case '*':
		case '/':
			return 2;
		case '^' :
			return 3;
		default:
			return -1;
		}
	}
	
}
