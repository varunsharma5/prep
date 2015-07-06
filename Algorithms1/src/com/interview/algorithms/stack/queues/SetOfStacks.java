package com.interview.algorithms.stack.queues;

import java.util.ArrayList;

import com.example.datastructures.Stack;

public class SetOfStacks {

	ArrayList<Stack<Integer>> stacks = new ArrayList<Stack<Integer>>();

	public int capacity;

	public SetOfStacks(int capacity) {
		this.capacity = capacity;
	}

	public Stack<Integer> getLastStack() {

		if (stacks.size() == 0)
			return null;

		return stacks.get(stacks.size() - 1);

	}

	public void push(int v) {
		Stack<Integer> last = getLastStack();
		if (last != null && last.size() != capacity) {
			last.push(v);
		} else {
			Stack<Integer> latest = new Stack<Integer>(capacity);
			latest.push(v);
			stacks.add(latest);
		}

	}

	public int pop() {

		Stack<Integer> last = getLastStack();

		System.out.println(stacks.size());

		int v = last.pop();

		if (last.size() == 0)
			stacks.remove(stacks.size() - 1);

		return v;

	}

}