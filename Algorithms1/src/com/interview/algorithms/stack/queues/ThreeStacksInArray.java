package com.interview.algorithms.stack.queues;

/**
 * use a single array to implement three stacks.
 * 
 * @author ajitkoti
 *
 */
public class ThreeStacksInArray {

	int stackSize = 300;
	int[] buffer = new int[stackSize * 3];
	int[] stackPointer = { 0, 0, 0 }; // stack pointers to track top elem

	/*
	 * Find the index of the top element in the array + 1, and		 * 
	 * increment the stack pointer
	 */
	void push(int stackNum, int value) {
		int index = stackNum * stackSize + stackPointer[stackNum] + 1;
		stackPointer[stackNum]++;
		buffer[index] = value;
	}

	int pop(int stackNum) {
		int index = stackNum * stackSize + stackPointer[stackNum];
		stackPointer[stackNum]--;
		int value = buffer[index];
		buffer[index] = 0;
		return value;
	}

	int peek(int stackNum) {
		int index = stackNum * stackSize + stackPointer[stackNum];
		return buffer[index];
	}

	boolean isEmpty(int stackNum) {
		return stackPointer[stackNum] == stackNum * stackSize;
	}
}