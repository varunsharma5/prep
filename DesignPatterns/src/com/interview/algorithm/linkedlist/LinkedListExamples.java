package com.interview.algorithm.linkedlist;
class Node {
	int data;
	Node next;
}

class MyLinkedList {
	private Node root = null;
	
	public void addData(int val) {
		Node travPtr = null;
		
		if(root == null) {
			root = new Node();
			root.data = val;
			root.next = null;
			return;
		}
		
		travPtr = root;
		
		while (travPtr.next != null) {
			travPtr = travPtr.next;
		}
		
		Node newNode = createNode(val);
		
		travPtr.next = newNode;
	}
	
	private Node createNode(int val) {
		Node node = new Node();
		node.data = val;
		node.next = null;
		return node;
	}
	
	public void traverse() {
		Node travPtr = null;
		travPtr = root;
		while (travPtr != null) {
			System.out.print(travPtr.data + ",");
			travPtr = travPtr.next;
		}
	}
	
	public void traverse(Node ptr) {
		Node travPtr = null;
		travPtr = ptr;
		while (travPtr != null) {
			System.out.print(travPtr.data + ",");
			travPtr = travPtr.next;
		}
	}
	
	public void remove(int val) {
		Node travPtr = null;
		travPtr = root;
		
		while(travPtr.next.data != val) {
			travPtr = travPtr.next;
		}
		
		travPtr.next = travPtr.next.next;
	}
	
	public Node reverseNonRecursive() {
		Node ptr = root;
		Node prev = null;
		Node temp = null;
		
		while(ptr != null) {
			temp = ptr.next;
			ptr.next = prev;
			prev = ptr;
			ptr = temp;
		}
		return prev; 
	}
	
//	public Node reverseRecursive(Node ptr) {
//		if(ptr.next == null) {
//			return ptr;
//		}
//		
//		Node temp = reverseRecursive(ptr.next);
//		
//		
//	}
	
	public int findNthFromLast(int nthFrmLastPosition) {
		Node curr = root;
		Node behind = root;
		
		for(int i=0; i<nthFrmLastPosition ; i++) {
			if(curr.next != null) {
				curr = curr.next;
			} else {
				return -1;
			}
		}
		
		while(curr != null) {
			behind = behind.next;
			curr = curr.next;
		}
		
		return behind.data;
	}
}


public class LinkedListExamples {
	public static void main(String[] args) {
		MyLinkedList list = new MyLinkedList();
		list.addData(10);
		list.addData(20);
		list.addData(30);
		list.addData(40);
		list.addData(50);
		list.addData(60);
		list.addData(70);
		list.addData(80);
		list.addData(90);
		
		System.out.println("List: ");
		
		list.traverse();
		System.out.println("");
		
//		System.out.println("Deleting val 60 ...");
//
//		list.remove(60);
//		System.out.println("Value deleted, list after deletion ...");
//		list.traverse();
//		
//		System.out.println("");
//		
//		System.out.println("Reversing the list: ");
//		list.traverse(list.reverseNonRecursive());
//		System.out.println("");
		
		
		System.out.println("Find 3rd element from last");
		System.out.println("Value: " + list.findNthFromLast(3));
	}
}
