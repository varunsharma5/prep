package com.interview.algorithms.stack.queues;

import com.example.datastructures.Stack;

/**
 * Write a program to sort a stack in ascending order. You should not make any
 * assump- tions about how the stack is implemented. The following are the only
 * functions that should be used to write this program: push | pop | peek |
 * isEmpty
 * 
 * @author ajitkoti
 *
 */
public class AscendingStack {

	public static void main(String[] args) {

	}

	/**
	 * Sorting can be performed with one more stack. The idea is to pull an item
	 * from the original stack and push it on the other stack. If pushing this
	 * item would violate the sort order of the new stack, we need to remove
	 * enough items from it so that it’s possible to push the new item. Since
	 * the items we removed are on the original stack, we’re back where we
	 * started. The algorithm is O(N^2) and appears below
	 * 
	 * @param s
	 * @return
	 */
	public static Stack<Integer> sort(Stack<Integer> s) {
		Stack<Integer> r = new Stack<Integer>(10);

		while (!s.isEmpty()) {
			int tmp = s.pop();

			while (!r.isEmpty() && r.peek() > tmp) {
				s.push(r.pop());
			}

			r.push(tmp);
		}

		return r;
	}

}
