package com.interview.algorithms.stack.queues;

import com.example.datastructures.Stack;

/**
 * Implement a MyQueue class which implements a queue using two stacks.
 * 
 * @author ajitkoti
 *
 */
public class StackAsQueue {

	public static void main(String[] args) {

	}

}

/**
 * Since the major difference between a queue and a stack is the order
 * (first-in-first-out vs. last- in-first-out), we know that we need to modify
 * peek() and pop() to go in reverse order. We can use our second stack to
 * reverse the order of the elements (by popping s1 and pushing the elements on
 * to s2). In such an implementation, on each peek() and pop() operation, we
 * would pop everything from s1 onto s2, perform the peek / pop operation, and
 * then push everything back
 * 
 * @author ajitkoti
 *
 * @param <T>
 */
class MyQueue<T> {

	Stack<T> s1, s2;

	public MyQueue() {

		s1 = new Stack<T>(10);

		s2 = new Stack<T>(10);

	}

	public int size() {

		return s1.size() + s2.size();

	}

	public void add(T value) {

		s1.push(value);

	}

	public T peek() {

		if (!s2.isEmpty())
			return s2.peek();

		while (!s1.isEmpty())
			s2.push(s1.pop());

		return s2.peek();

	}

	public T remove() {

		if (!s2.isEmpty())
			return s2.pop();

		while (!s1.isEmpty())
			s2.push(s1.pop());

		return s2.pop();

	}
}
