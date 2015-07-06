package com.interview.algorithms.stack.queues;

import com.example.datastructures.Stack;

public class StackWithMin {
	private final int maxSize;
	private Stack<Integer> stack;
	private Stack<Integer> stackMin;
	private int min = Integer.MAX_VALUE;

	@SuppressWarnings("unchecked")
	public StackWithMin(int maxSize) {
		this.maxSize = maxSize;
		stack = new Stack<Integer>(maxSize);
		stackMin = new Stack<Integer>(maxSize);

	}

	public void push(int t) {
		if (t < min) {
			min = t;
			stackMin.push(t);
		}
		stack.push(t);

	}

	public int pop() {
		int value = stack.pop();
		if (min == value) {
			stackMin.pop();
			min = stackMin.peek();
		}
		return value;
	}

	public int peek() {
		return stack.peek();
	}

	public boolean isEmpty() {
		return stack.isEmpty();

	}

	public int min() {
		if (isEmpty()) {
			return Integer.MAX_VALUE;
		} else {
			return min;

		}

	}

	public static void main(String[] args) {

		StackWithMin stack = new StackWithMin(10);

		for (int i = 0; i < 11; i++) {
			stack.push(i);
		}

		if (!stack.isEmpty()) {
			System.out.println("Top of Stack is :" + stack.peek());
		}

		System.out.println("The Contents of Stack are ");

		for (int i = 0; i < 10; i++) {
			System.out.print(stack.pop() + ",");
		}
		
		System.out.println(stack.min());

	}

}
