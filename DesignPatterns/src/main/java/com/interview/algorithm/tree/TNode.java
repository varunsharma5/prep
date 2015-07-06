package com.interview.algorithm.tree;

public class TNode {
	int Key;
	String name;
	
	TNode leftChild;
	TNode rightChild;
	
	TNode(int Key, String name) {
		this.Key = Key;
		this.name = name;
	}
	
	@Override
	public String toString() {
		return String.valueOf(Key);
	}
}
